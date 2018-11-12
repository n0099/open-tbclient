package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.bdmapsdk.BdMapRuntime;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.MyLocationAnchor;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.model.SelectedLocationInfo;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.search.SearchLocationFragment;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ChooseLocationFragment extends AiAppsBaseFragment implements View.OnClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, OnGetGeoCoderResultListener, LocationItemClickListener, MyLocationAnchor.OnLocationFirstDoneListener {
    private static final int CHOOSE_LOCATION_CANCEL = 17;
    private static final int CHOOSE_LOCATION_ERROR = 18;
    private static final int CHOOSE_LOCATION_OK = 16;
    private static final String DEFAULT_LOCATION_STR = "[位置]";
    private static final float DEFAULT_SCALE = 16.0f;
    private static final int DEFAULT_WAIT_TIME = 150;
    private static final int DING_ANIMATION_DURATION = 500;
    private static final int DING_ANIMATION_HEIGHT = AiAppsUIUtils.dp2px(20.0f);
    private static final String KEY_CITY = "city";
    private static final int LOCATION_MARKER_Z_INDEX = 88;
    private static final int LOCATION_REQUEST_CODE = 3001;
    private static final int MAX_LOCATION_SIZE = 11;
    private static final int RESULT_CODE = 1;
    private LocationDetailAdapter mAdapter;
    private BaiduMap mBaiduMap;
    private BitmapDescriptor mBitmapDescriptor;
    private View mCancel;
    private LocationPOIModel mCurrentModel;
    private ImageView mDing;
    private TextView mFinish;
    private FrameLayout mFloatContainer;
    private GeoCoder mGeoCoder;
    private ImageView mGoToMyLocation;
    private boolean mHasRefreshed;
    private boolean mIsNeedRefresh;
    private FrameLayout mListContainer;
    private View mLoadingView;
    private MyLocationAnchor mLocationAnchor;
    private RecyclerView mLocationList;
    private List<LocationPOIModel> mLocationPOIModels;
    private FrameLayout mMapContainer;
    private TextureMapView mMapView;
    private Marker mMarker;
    private OnChooseLocationListener mOnChooseLocationListener;
    private View mSearch;
    private SelectedLocationInfo mSearchedLocationInfo;
    private LocationViewFlipper mViewFlipper;

    /* loaded from: classes4.dex */
    public interface OnChooseLocationListener {
        void onCancel();

        void onError();

        void onSuccess(SelectedLocationInfo selectedLocationInfo);
    }

    public static ChooseLocationFragment newInstance(Bundle bundle) {
        ChooseLocationFragment chooseLocationFragment = new ChooseLocationFragment();
        if (bundle != null) {
            chooseLocationFragment.setArguments(bundle);
        }
        return chooseLocationFragment;
    }

    public void startFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null) {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(this).commitNow();
        }
    }

    public void setOnChooseLocationListener(OnChooseLocationListener onChooseLocationListener) {
        this.mOnChooseLocationListener = onChooseLocationListener;
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BdMapRuntime.makeSureMapSDKInit();
        View inflate = layoutInflater.inflate(e.h.ai_apps_location_choose, viewGroup, false);
        init(inflate);
        initMap();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    private void init(View view) {
        SDKInitializer.setCoordType(CoordType.GCJ02);
        this.mLocationPOIModels = new ArrayList(11);
        this.mLocationList = (RecyclerView) view.findViewById(e.g.location_list);
        this.mGoToMyLocation = (ImageView) view.findViewById(e.g.float_btn);
        this.mFloatContainer = (FrameLayout) view.findViewById(e.g.float_container);
        this.mCancel = view.findViewById(e.g.cancel);
        this.mSearch = view.findViewById(e.g.search);
        this.mFinish = (TextView) view.findViewById(e.g.finish);
        this.mDing = (ImageView) view.findViewById(e.g.center_ding);
        this.mListContainer = (FrameLayout) view.findViewById(e.g.list_container);
        this.mMapContainer = (FrameLayout) view.findViewById(e.g.map_container);
        this.mLoadingView = view.findViewById(e.g.loading_progress);
        this.mMapView = (TextureMapView) view.findViewById(e.g.bdMapView);
        this.mGoToMyLocation.setOnClickListener(this);
        this.mFinish.setOnClickListener(this);
        this.mSearch.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
        this.mGeoCoder = GeoCoder.newInstance();
        this.mBaiduMap = this.mMapView.getMap();
        this.mGeoCoder.setOnGetGeoCodeResultListener(this);
        this.mBaiduMap.setOnMapLoadedCallback(this);
        this.mBaiduMap.setOnMapStatusChangeListener(this);
        this.mLocationList.setLayoutManager(new LinearLayoutManager(AiAppsController.getInstance().getActivity()));
        this.mAdapter = new LocationDetailAdapter(AiAppsController.getInstance().getActivity(), this.mLocationList, this, false);
        this.mLocationList.setAdapter(this.mAdapter);
        this.mLocationList.addItemDecoration(new LocationItemDecoration(AiAppsController.getInstance().getActivity(), true));
        this.mViewFlipper = new LocationViewFlipper(this.mListContainer, this.mMapContainer, this.mFloatContainer);
        ((FlipperFrameLayout) this.mListContainer).setViewFlipper(this.mViewFlipper);
    }

    private void getNearPOIs(LatLng latLng) {
        this.mGeoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    private void initMap() {
        this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(DEFAULT_SCALE));
        this.mBaiduMap.getUiSettings().setRotateGesturesEnabled(false);
        this.mMapView.showZoomControls(false);
        this.mMapView.setLogoPosition(LogoPosition.logoPostionRightBottom);
        if (!needRequestPermission()) {
            startLocationAnchor();
        }
    }

    private void startLocationAnchor() {
        this.mLocationAnchor = new MyLocationAnchor(AiAppsController.getInstance().getActivity(), this.mBaiduMap);
        this.mLocationAnchor.triggerLocation(true);
        this.mLocationAnchor.setOnFirstLocationDoneListener(this);
        showLoadingView(true);
    }

    private void animationDing() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mDing, "translationY", 0.0f, -DING_ANIMATION_HEIGHT, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePOIData(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        PoiInfo poiInfo = new PoiInfo();
        if (this.mSearchedLocationInfo != null) {
            poiInfo.name = this.mSearchedLocationInfo.mName;
            poiInfo.location = new LatLng(this.mSearchedLocationInfo.mLatitude, this.mSearchedLocationInfo.mLongitude);
            poiInfo.address = this.mSearchedLocationInfo.mAddress;
            this.mSearchedLocationInfo = null;
            z = false;
        } else {
            String address = reverseGeoCodeResult.getAddress();
            String sematicDescription = reverseGeoCodeResult.getSematicDescription();
            if (TextUtils.isEmpty(address)) {
                address = DEFAULT_LOCATION_STR;
            }
            poiInfo.name = address;
            poiInfo.location = reverseGeoCodeResult.getLocation();
            poiInfo.address = sematicDescription;
            ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
            if (addressDetail != null) {
                poiInfo.city = addressDetail.city;
            }
            z = true;
        }
        LocationPOIModel locationPOIModel = new LocationPOIModel(poiInfo, true, z);
        this.mLocationPOIModels.clear();
        this.mLocationPOIModels.add(locationPOIModel);
        this.mLocationPOIModels.addAll(LocationPOIModel.createModels(reverseGeoCodeResult.getPoiList()));
        this.mAdapter.setData(this.mLocationPOIModels);
        this.mCurrentModel = locationPOIModel;
        if (this.mLocationPOIModels.size() > 0) {
            showLoadingView(false);
        }
    }

    private void showLoadingView(boolean z) {
        if (z) {
            this.mLocationPOIModels.clear();
            this.mAdapter.setData(this.mLocationPOIModels);
        }
        this.mLoadingView.setVisibility(z ? 0 : 8);
    }

    private void refreshPOIS(LatLng latLng, boolean z, boolean z2) {
        showLoadingView(true);
        getNearPOIs(latLng);
        removeMarker();
        if (z) {
            animationDing();
            if (this.mViewFlipper.isFlipped()) {
                this.mViewFlipper.scrollView(false);
            }
        }
        if (z2) {
            this.mLocationList.smoothScrollToPosition(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.float_btn) {
            if (this.mLocationAnchor != null && this.mLocationAnchor.getCurrentLocation() != null) {
                BDLocation currentLocation = this.mLocationAnchor.getCurrentLocation();
                LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
                this.mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                removeMarker();
                if (this.mHasRefreshed) {
                    refreshPOIS(latLng, true, true);
                    this.mHasRefreshed = false;
                }
                setGoToMyLocationBtnStatus(true);
            }
        } else if (view.getId() == e.g.finish) {
            sendResult(16);
            exitFragment();
        } else if (view.getId() == e.g.search) {
            startSearchLocationFragment(this.mCurrentModel);
        } else if (view.getId() == e.g.cancel) {
            sendResult(17);
            exitFragment();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationItemClickListener
    public void onItemClick(LocationPOIModel locationPOIModel) {
        if (locationPOIModel != null && locationPOIModel.poiInfo != null && locationPOIModel.poiInfo.location != null) {
            this.mCurrentModel = locationPOIModel;
            this.mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(locationPOIModel.poiInfo.location));
            removeMarker();
            if (this.mBitmapDescriptor == null) {
                this.mBitmapDescriptor = BitmapDescriptorFactory.fromResource(e.f.aiapps_location_selected);
            }
            if (!locationPOIModel.isDefaultItem) {
                this.mMarker = (Marker) this.mBaiduMap.addOverlay(new MarkerOptions().position(locationPOIModel.poiInfo.location).zIndex(88).icon(this.mBitmapDescriptor));
            }
            if (!locationPOIModel.isDefaultItem) {
                setGoToMyLocationBtnStatus(false);
            }
        }
    }

    private void removeMarker() {
        if (this.mMarker != null) {
            this.mMarker.remove();
            this.mMarker = null;
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(final ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.mLocationList.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.ChooseLocationFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    ChooseLocationFragment.this.updatePOIData(reverseGeoCodeResult);
                }
            }, 150L);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.MyLocationAnchor.OnLocationFirstDoneListener
    public void onFirstLocationDone(BDLocation bDLocation) {
        getNearPOIs(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            switch (i) {
                case 1:
                    SelectedLocationInfo selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY);
                    if (selectedLocationInfo != null) {
                        double d = selectedLocationInfo.mLatitude;
                        double d2 = selectedLocationInfo.mLongitude;
                        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
                            this.mSearchedLocationInfo = selectedLocationInfo;
                            LatLng latLng = new LatLng(d, d2);
                            this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                            this.mHasRefreshed = true;
                            refreshPOIS(latLng, false, true);
                            setGoToMyLocationBtnStatus(false);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void sendResult(int i) {
        if (this.mOnChooseLocationListener != null) {
            switch (i) {
                case 16:
                    if (this.mCurrentModel != null) {
                        PoiInfo poiInfo = this.mCurrentModel.poiInfo;
                        if (TextUtils.equals(poiInfo.name, DEFAULT_LOCATION_STR)) {
                            poiInfo.name = "";
                        }
                        this.mOnChooseLocationListener.onSuccess(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                        return;
                    }
                    return;
                case 17:
                    this.mOnChooseLocationListener.onCancel();
                    return;
                case 18:
                    this.mOnChooseLocationListener.onError();
                    return;
                default:
                    return;
            }
        }
    }

    private void exitFragment() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
        this.mOnChooseLocationListener = null;
    }

    private void setGoToMyLocationBtnStatus(boolean z) {
        if (this.mGoToMyLocation != null) {
            this.mGoToMyLocation.setImageResource(z ? e.f.aiapps_location_go_my_point_selected : e.f.aiapps_location_go_my_point);
        }
    }

    private void startSearchLocationFragment(LocationPOIModel locationPOIModel) {
        if (locationPOIModel != null && locationPOIModel.poiInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_CITY, locationPOIModel.poiInfo.city);
            SearchLocationFragment newInstance = SearchLocationFragment.newInstance(bundle);
            newInstance.setTargetFragment(this, 1);
            newInstance.startFragment();
        }
    }

    public LocationPOIModel getCurrentSelectLocation() {
        return this.mCurrentModel;
    }

    private boolean needRequestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (AiAppsController.getInstance().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (arrayList.size() > 0) {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 3001) {
            if (iArr.length > 0 && iArr[0] == -1) {
                UniversalToast.makeText(AiAppsController.getInstance().getActivity(), e.j.aiapps_location_permission_fail).showToast();
            } else if (iArr.length > 0 && iArr[0] == 0) {
                startLocationAnchor();
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mMapView.onResume();
        if (this.mLocationAnchor != null) {
            this.mLocationAnchor.triggerLocation(true);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mMapView.onPause();
        if (this.mLocationAnchor != null) {
            this.mLocationAnchor.triggerLocation(false);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 19) {
            this.mMapView.onDestroy();
        }
        this.mGeoCoder.destroy();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        sendResult(17);
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        getNearPOIs(this.mBaiduMap.getMapStatus().target);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        boolean z = false;
        this.mIsNeedRefresh = i == 1;
        if (this.mIsNeedRefresh || this.mHasRefreshed) {
            z = true;
        }
        this.mHasRefreshed = z;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        if (this.mIsNeedRefresh) {
            refreshPOIS(mapStatus.target, true, true);
            setGoToMyLocationBtnStatus(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
    }
}
