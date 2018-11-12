package com.baidu.searchbox.ng.ai.apps.impl.map.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.OpenLocationModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MyCurrentLocationAnchor;
import com.baidu.searchbox.ng.ai.apps.impl.map.view.OpenLocationBottomMenu;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ActionUtils;
import com.baidu.searchbox.ng.ai.apps.shortcut.AiAppsShortcutHelper;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsMenuDecorate;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenu;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuItem;
import com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener;
import com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class MapLocationFragment extends AiAppsBaseFragment implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    protected static final boolean DEBUG = false;
    protected static final String TAG = "MapLocationFragment";
    private String mAddress;
    private BaiduMap mBaiduMap;
    private TextureMapView mBdMapView;
    private BDLocation mCurLocation;
    private boolean mFinishedShowPathFlag;
    private ImageView mGoToMyLocation;
    private TextView mLocationAddress;
    private MyCurrentLocationAnchor mLocationAnchor;
    private ImageView mLocationMenuIv;
    private TextView mLocationPosi;
    private Marker mMarker;
    private OpenLocationBottomMenu mMenuLayout;
    private String mName;
    private PopupWindow mPopMenu;
    private View mPopWindowLocationView;
    private GeoCoder mSearch;
    private String mWebViewId = "";

    public static MapLocationFragment newInstance(Bundle bundle) {
        MapLocationFragment mapLocationFragment = new MapLocationFragment();
        if (bundle != null) {
            mapLocationFragment.setArguments(bundle);
        }
        BdMapRuntime.makeSureMapSDKInit();
        return mapLocationFragment;
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AiAppsLog.i("map", "start MapLocationFragment");
        View inflate = layoutInflater.inflate(e.h.ai_apps_map_show_location_fragment, viewGroup, false);
        initActionBar(inflate);
        setBackViewVisible(isLandingFragment());
        setRightMenuVisibility(false);
        initMapView(inflate);
        initBottomPanel(inflate);
        startLocationAnchor();
        initGoMyPoint(inflate);
        setActionbarTitle(AppRuntime.getAppContext().getResources().getString(e.j.aiapps_map_open_location_title));
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    private void initMapView(View view) {
        this.mBdMapView = (TextureMapView) view.findViewById(e.g.bdMapView);
        this.mBaiduMap = this.mBdMapView.getMap();
        this.mBaiduMap.getUiSettings().setRotateGesturesEnabled(false);
        this.mBdMapView.showZoomControls(false);
        this.mBaiduMap.getUiSettings().setOverlookingGesturesEnabled(false);
        this.mBaiduMap.setOnMapLoadedCallback(this);
    }

    private void parseParams() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            this.mWebViewId = arguments.getString("slaveId");
            double d = arguments.getDouble(CoordinateModel.LATITUDE);
            double d2 = arguments.getDouble(CoordinateModel.LONGITUDE);
            double d3 = arguments.getDouble("scale");
            this.mName = arguments.getString("name");
            this.mAddress = arguments.getString(OpenLocationModel.ADDRESS);
            LatLng latLng = new LatLng(d, d2);
            locationToPosition(latLng);
            this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d3));
            this.mMarker = (Marker) this.mBaiduMap.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(e.f.aiapps_location_ding)).title(TextUtils.isEmpty(this.mName) ? "" : this.mName).anchor(0.5f, 0.5f));
            AiAppsLog.i("map", "show marker");
        }
    }

    public void startFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null) {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(this).commitNow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
        if (this.mToolMenu == null) {
            this.mToolMenu = new AiAppMenu(getContext(), this.mAiAppsActionBar, 12, new AiAppsMenuDecorate());
            this.mToolMenu.setMenuSource("swan");
            toolMenuItemClickListener();
        }
    }

    private void toolMenuItemClickListener() {
        this.mToolMenu.setOnItemClickListener(new OnAiAppMenuItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.1
            @Override // com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener
            public boolean onClick(View view, AiAppMenuItem aiAppMenuItem) {
                switch (aiAppMenuItem.getItemId()) {
                    case 4:
                        MapLocationFragment.this.share();
                        return true;
                    case 5:
                        MapLocationFragment.this.processNightMode(MapLocationFragment.this.getContext());
                        return true;
                    case 34:
                        MapLocationFragment.this.handleBackToHome();
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_GOHOME;
                        aiAppsUBCEvent.mSource = "menu";
                        MapLocationFragment.this.doUBCEventStatistic(aiAppsUBCEvent);
                        return true;
                    case 35:
                        AiAppsShortcutHelper.addShortcut(view.getContext(), ((AiAppsActivity) MapLocationFragment.this.mActivity).getLaunchInfo());
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent2 = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent2.mValue = AiAppsUBCStatistic.VALUE_ADD_SHORTCUT;
                        MapLocationFragment.this.doUBCEventStatistic(aiAppsUBCEvent2);
                        return true;
                    case 36:
                        MapLocationFragment.this.startAboutFragment();
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent3 = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent3.mValue = "about";
                        MapLocationFragment.this.doUBCEventStatistic(aiAppsUBCEvent3);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.mWebViewId);
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("sharebtn", hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackToHome() {
        ActionUtils.dispatchRouteRequest(ActionUtils.BACK_TO_HOME_REQUEST, "menu", AiAppsController.getInstance().getFirstPageUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAboutFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            UniversalToast.makeText(this.mActivity, e.j.aiapps_open_fragment_failed_toast).showToast();
        } else {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment("about", null).commit();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
        initToolMenu();
        this.mToolMenu.show(false);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        AiAppsLog.i("map", "onMapLoaded");
        parseParams();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == this.mMarker && !TextUtils.isEmpty(this.mName)) {
            LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
            linearLayout.setOrientation(1);
            TextView textView = new TextView(AppRuntime.getAppContext());
            textView.setText(this.mName);
            textView.setTextSize(18.0f);
            TextView textView2 = new TextView(AppRuntime.getAppContext());
            textView2.setText(this.mAddress);
            textView2.setTextSize(15.0f);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            this.mBaiduMap.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
        }
        return true;
    }

    private void initBottomPanel(View view) {
        this.mPopWindowLocationView = view;
        this.mLocationMenuIv = (ImageView) view.findViewById(e.g.location_icon_path);
        this.mLocationMenuIv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MapLocationFragment.this.showPopMenu();
            }
        });
        this.mLocationPosi = (TextView) view.findViewById(e.g.location_text_position);
        this.mLocationAddress = (TextView) view.findViewById(e.g.location_text_address);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mSearch != null) {
            this.mSearch.destroy();
        }
        OpenLocationBottomMenu.resetItemClickFlag();
        if (this.mLocationAnchor != null) {
            this.mLocationAnchor.triggerLocation(false);
        }
        if (Build.VERSION.SDK_INT > 19) {
            this.mBdMapView.onDestroy();
        }
    }

    private void locationToPosition(LatLng latLng) {
        this.mSearch = GeoCoder.newInstance();
        this.mSearch.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.3
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    MapLocationFragment.this.mLocationPosi.setText(e.j.unknown_location_info);
                    return;
                }
                MapLocationFragment.this.mAddress = reverseGeoCodeResult.getAddress();
                if (!TextUtils.isEmpty(MapLocationFragment.this.mAddress)) {
                    MapLocationFragment.this.mLocationAddress.setText(MapLocationFragment.this.mAddress);
                }
                List<PoiInfo> poiList = reverseGeoCodeResult.getPoiList();
                ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                MapLocationFragment.this.mName = (poiList == null || poiList.size() <= 0) ? addressDetail.street + addressDetail.streetNumber : poiList.get(0).name;
                if (!TextUtils.isEmpty(MapLocationFragment.this.mName)) {
                    MapLocationFragment.this.mLocationPosi.setText(MapLocationFragment.this.mName);
                } else {
                    MapLocationFragment.this.mLocationPosi.setText(e.j.unknown_location_info);
                }
                AiAppsLog.i("map", "mAddress +" + MapLocationFragment.this.mAddress + " mName" + MapLocationFragment.this.mName);
            }
        });
        this.mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopMenu() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.mPopMenu == null || !this.mPopMenu.isShowing()) {
                View inflate = View.inflate(activity, e.h.aiapps_openlocation_pop_menu, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MapLocationFragment.this.dismissPopMenu();
                    }
                });
                this.mMenuLayout = (OpenLocationBottomMenu) inflate.findViewById(e.g.openlocation_popmenu);
                this.mMenuLayout.setFragment(this);
                this.mPopMenu = new PopupWindow(activity);
                this.mPopMenu.setContentView(inflate);
                this.mPopMenu.setWidth(-1);
                this.mPopMenu.setHeight(-2);
                this.mPopMenu.setBackgroundDrawable(new BitmapDrawable());
                this.mPopMenu.setFocusable(true);
                this.mPopMenu.setOutsideTouchable(true);
                this.mPopMenu.showAtLocation(this.mPopWindowLocationView, 80, 0, 0);
                this.mPopMenu.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.5
                    @Override // com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MapLocationFragment.this.setScreenBackground(1.0f);
                    }
                });
                setScreenBackground(0.3f);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.mPopMenu != null && this.mPopMenu.isShowing()) {
            this.mPopMenu.dismiss();
        }
    }

    public BaiduMap getmBaiduMap() {
        return this.mBaiduMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenBackground(float f) {
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    private void initGoMyPoint(View view) {
        this.mGoToMyLocation = (ImageView) view.findViewById(e.g.goMyPoint);
        this.mGoToMyLocation.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MapLocationFragment.this.mLocationAnchor != null && MapLocationFragment.this.mLocationAnchor.getCurrentLocation() != null) {
                    BDLocation currentLocation = MapLocationFragment.this.mLocationAnchor.getCurrentLocation();
                    MapLocationFragment.this.mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude())));
                }
            }
        });
    }

    private void startLocationAnchor() {
        this.mLocationAnchor = new MyCurrentLocationAnchor(AiAppsController.getInstance().getActivity(), this.mBaiduMap);
        this.mLocationAnchor.triggerLocation(true);
        this.mLocationAnchor.setOnFirstLocationDoneListener(new MyCurrentLocationAnchor.OnLocationFirstDoneListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment.7
            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.utils.MyCurrentLocationAnchor.OnLocationFirstDoneListener
            public void onFirstLocationDone(BDLocation bDLocation) {
                MapLocationFragment.this.mCurLocation = bDLocation;
            }
        });
    }

    public BDLocation getCurLocation() {
        return this.mCurLocation;
    }

    public void setFinishedShowPathFlag(boolean z) {
        this.mFinishedShowPathFlag = z;
    }

    public boolean getFinishedShowPathFlag() {
        return this.mFinishedShowPathFlag;
    }
}
