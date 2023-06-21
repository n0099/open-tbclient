package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.adapter.AddressConverter;
import com.baidu.pass.ecommerce.adapter.MapLocAddrAdapter;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.callback.SimpleTextWatcher;
import com.baidu.pass.ecommerce.common.ScreenUtil;
import com.baidu.pass.ecommerce.common.view.TitleBarView;
import com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter;
import com.baidu.pass.ecommerce.presenter.OnceLocationManager;
import com.baidu.pass.ecommerce.view.ScrollLayout;
import com.baidu.pass.ecommerce.view.ScrollRecyclerView;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MapLocationAddrActivity extends BaseAddressActivity<MapLocationPoiPresenter> implements ScrollLayout.OnScrollChangedListener, BaiduMap.OnMapStatusChangeListener {
    public static final String KEY_BDSTOKEN_FROM_ADDR_EDIT = "key_bdstoken_from_addr_edit";
    public static final String KEY_FROM_TYPE = "key_from_type";
    public static final String TAG = "MapLocationPoiActivity";
    public EditText addrMapSearchEt;
    public BaiduMap baiduMap;
    public TextView cancelSearchBtn;
    public ImageView cleanSearchTextBtn;
    public int contentHeight;
    public boolean isAutoUpdateSearchContent;
    public boolean isFocusSearchBoxEt;
    public boolean isFromCreateAddr;
    public boolean isInitLoadComplete;
    public boolean isSoftKeyBoardShowing;
    public boolean isStatShowSearch;
    public boolean isUserGestureDragMap = true;
    public SweepLightLoadingView loadingView;
    public LinearLayoutManager mLinearLayoutManager;
    public RecyclerView mRecyclerView;
    public ScrollLayout mScrollLayout;
    public LinearLayout mSearchBox;
    public TextView mapAddrEmpty;
    public View mapAddrListLoading;
    public MyLocationData mapChoiceLocData;
    public float mapControllerScrollValue;
    public View mapControllerView;
    public MapLocAddrAdapter mapLocAddrAdapter;
    public ImageView mapLocBtn;
    public View mapMarkLayout;
    public View mapMaskView;
    public float mapScrollValue;
    public MapView mapView;
    public boolean mapViewInitSuccess;
    public ImageView mapZoomInBtn;
    public ImageView mapZoomOutBtn;
    public int panelHeightOnKeyBoardHide;
    public int panelHeightOnKeyBoardShow;
    public View searchBoxLine;
    public JSONObject selectedAddrJsonObj;
    public TitleBarView titleBarView;

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onChildScroll(int i) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onScrollFinished(ScrollLayout.Status status) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeMapAddrListLayout() {
        SapiUtils.hideSoftInput(this);
        this.mScrollLayout.setHalf();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        MapLocAddrAdapter mapLocAddrAdapter = new MapLocAddrAdapter((MapLocationPoiPresenter) this.presenter, this.isDarkMode);
        this.mapLocAddrAdapter = mapLocAddrAdapter;
        this.mRecyclerView.setAdapter(mapLocAddrAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMapAddrListLayout() {
        this.mScrollLayout.setToOpen();
        this.mapLocAddrAdapter.setDatas(((MapLocationPoiPresenter) this.presenter).getAddrListByUserInput(), ((MapLocationPoiPresenter) this.presenter).isHasNextPageByUserInput());
    }

    private void requestLocation() {
        this.loadingView.setVisibility(0);
        ((MapLocationPoiPresenter) this.presenter).requestLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePanelSmallSize() {
        this.mapAddrEmpty.postDelayed(new Runnable() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.9
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) MapLocationAddrActivity.this.mapAddrEmpty.getLayoutParams();
                if (MapLocationAddrActivity.this.panelHeightOnKeyBoardHide <= 0) {
                    int[] iArr = new int[2];
                    MapLocationAddrActivity.this.mSearchBox.getLocationInWindow(iArr);
                    MapLocationAddrActivity mapLocationAddrActivity = MapLocationAddrActivity.this;
                    mapLocationAddrActivity.panelHeightOnKeyBoardHide = (ScreenUtil.getScreenHeight(mapLocationAddrActivity) - iArr[1]) + MapLocationAddrActivity.this.mSearchBox.getHeight();
                }
                layoutParams.height = MapLocationAddrActivity.this.panelHeightOnKeyBoardHide;
                MapLocationAddrActivity.this.mapAddrEmpty.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MapLocationAddrActivity.this.mapAddrListLoading.getLayoutParams();
                layoutParams2.height = MapLocationAddrActivity.this.panelHeightOnKeyBoardHide;
                MapLocationAddrActivity.this.mapAddrListLoading.setLayoutParams(layoutParams2);
            }
        }, 100L);
    }

    private void updateUserChoiceMapLocMarker() {
        BaiduMap baiduMap;
        if (this.mapViewInitSuccess && (baiduMap = this.baiduMap) != null) {
            baiduMap.setMyLocationData(this.mapChoiceLocData);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f010138);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MapView mapView;
        super.onDestroy();
        if (this.mapViewInitSuccess && (mapView = this.mapView) != null) {
            mapView.onDestroy();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        MapView mapView;
        super.onPause();
        if (this.mapViewInitSuccess && (mapView = this.mapView) != null) {
            mapView.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MapView mapView;
        super.onResume();
        if (this.mapViewInitSuccess && (mapView = this.mapView) != null) {
            mapView.onResume();
        }
    }

    private void processMapLoc2Region(JSONObject jSONObject) {
        AddressSelectedBean convertRegionJsonObj2Region = AddressConverter.convertRegionJsonObj2Region(jSONObject);
        String optString = jSONObject.optString(AddressField.KEY_DETAIL_ADDR);
        Intent intent = new Intent();
        intent.putExtra(AddressEditActivity.MAP_LOC_REGION_DETAIL, convertRegionJsonObj2Region);
        intent.putExtra(AddressEditActivity.MAP_LOC_ADDR_DETAIL, optString);
        setResult(10001, intent);
        finish();
    }

    private void processMapLocData(MyLocationData myLocationData) {
        if (myLocationData == null) {
            return;
        }
        this.mapChoiceLocData = myLocationData;
        updateUserChoiceMapLocMarker();
        if (TextUtils.isEmpty(this.addrMapSearchEt.getText().toString())) {
            ((MapLocationPoiPresenter) this.presenter).updateLatLngAndReverseGeoCode(new LatLng(myLocationData.latitude, myLocationData.longitude));
        }
        this.loadingView.setVisibility(8);
    }

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onScrollProgressChanged(float f) {
        float f2 = 1.0f - f;
        float f3 = -(this.mapScrollValue * f2);
        this.mapView.setTranslationY(f3);
        this.mapMarkLayout.setTranslationY(f3);
        this.mapControllerView.setTranslationY(-(this.mapControllerScrollValue * f2));
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        if (i == 1004) {
            this.mapAddrListLoading.setVisibility(0);
        }
    }

    private void hideSearchOptionViews() {
        this.isAutoUpdateSearchContent = true;
        this.addrMapSearchEt.setText("");
        this.addrMapSearchEt.clearFocus();
        this.cleanSearchTextBtn.setVisibility(8);
        this.searchBoxLine.setVisibility(8);
        this.cancelSearchBtn.setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.addrMapSearchEt.getWindowToken(), 0);
        }
    }

    private void setListener() {
        this.mapMarkLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                MapLocationAddrActivity.this.closeMapAddrListLayout();
                return false;
            }
        });
        this.mSearchBox.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                MapLocationAddrActivity.this.closeMapAddrListLayout();
                return false;
            }
        });
        this.mScrollLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (MapLocationAddrActivity.this.isSoftKeyBoardShowing) {
                    MapLocationAddrActivity.this.closeMapAddrListLayout();
                    return false;
                }
                return false;
            }
        });
        this.addrMapSearchEt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    MapLocationAddrActivity.this.searchBoxLine.setVisibility(0);
                    MapLocationAddrActivity.this.cancelSearchBtn.setVisibility(0);
                    MapLocationAddrActivity.this.isFocusSearchBoxEt = true;
                }
                return false;
            }
        });
        this.addrMapSearchEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.6
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!MapLocationAddrActivity.this.isAutoUpdateSearchContent) {
                    MapLocationAddrActivity.this.mapAddrEmpty.setVisibility(8);
                    MapLocationAddrActivity.this.selectedAddrJsonObj = null;
                    MapLocationAddrActivity.this.titleBarView.setRightBtnEnable(false);
                    if (charSequence.length() > 0) {
                        MapLocationAddrActivity.this.cleanSearchTextBtn.setVisibility(0);
                        if (MapLocationAddrActivity.this.isStatShowSearch) {
                            MapLocationAddrActivity.this.isStatShowSearch = false;
                            AddressStatUtil.statAddressOption(StatKey.EDITADDR_LOC_INPUT);
                        }
                        MapLocationAddrActivity.this.mapLocAddrAdapter.cleanData();
                        ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).queryAddrListByUserInputLoc(charSequence.toString().trim());
                        return;
                    }
                    MapLocationAddrActivity.this.mapAddrListLoading.setVisibility(8);
                    MapLocationAddrActivity.this.cleanSearchTextBtn.setVisibility(8);
                    MapLocationAddrActivity.this.mapLocAddrAdapter.cleanData();
                    MapLocationAddrActivity.this.mapLocAddrAdapter.setQueryContent("");
                    ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).cleanUserSearchAndEmptyQueryContent();
                    return;
                }
                MapLocationAddrActivity.this.isAutoUpdateSearchContent = false;
            }
        });
        SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.7
            @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardHide(int i) {
                MapLocationAddrActivity.this.isSoftKeyBoardShowing = false;
                MapLocationAddrActivity.this.updatePanelSmallSize();
            }

            @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardShow(final int i) {
                MapLocationAddrActivity.this.isSoftKeyBoardShowing = true;
                if (MapLocationAddrActivity.this.isFocusSearchBoxEt) {
                    MapLocationAddrActivity.this.isFocusSearchBoxEt = false;
                    ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).setQueryAddrListType(1);
                    MapLocationAddrActivity.this.openMapAddrListLayout();
                }
                MapLocationAddrActivity.this.mapAddrEmpty.postDelayed(new Runnable() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MapLocationAddrActivity.this.panelHeightOnKeyBoardShow <= 0) {
                            int[] iArr = new int[2];
                            MapLocationAddrActivity.this.mSearchBox.getLocationInWindow(iArr);
                            MapLocationAddrActivity mapLocationAddrActivity = MapLocationAddrActivity.this;
                            mapLocationAddrActivity.panelHeightOnKeyBoardShow = ((ScreenUtil.getScreenHeight(mapLocationAddrActivity) - i) - iArr[1]) + MapLocationAddrActivity.this.mSearchBox.getHeight();
                        }
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) MapLocationAddrActivity.this.mapAddrEmpty.getLayoutParams();
                        layoutParams.height = MapLocationAddrActivity.this.panelHeightOnKeyBoardShow;
                        MapLocationAddrActivity.this.mapAddrEmpty.setLayoutParams(layoutParams);
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) MapLocationAddrActivity.this.mapAddrListLoading.getLayoutParams();
                        layoutParams2.height = MapLocationAddrActivity.this.panelHeightOnKeyBoardShow;
                        MapLocationAddrActivity.this.mapAddrListLoading.setLayoutParams(layoutParams2);
                    }
                }, 100L);
            }
        });
        this.mapLocAddrAdapter.setItemClickListener(new ScrollRecyclerView.RecyclerViewItemClickListener<JSONObject>() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.ecommerce.view.ScrollRecyclerView.RecyclerViewItemClickListener
            public void onItemClickListener(int i, JSONObject jSONObject) {
                MapLocationAddrActivity.this.addrMapSearchEt.clearFocus();
                MapLocationAddrActivity.this.selectedAddrJsonObj = jSONObject;
                ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).setSelectedAddrId(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID));
                MapLocationAddrActivity.this.isUserGestureDragMap = false;
                BDLocation convertBdLocation = OnceLocationManager.getInstance().convertBdLocation(jSONObject.optDouble(SuggestAddrField.KEY_MAP_LAT), jSONObject.optDouble(SuggestAddrField.KEY_MAP_LNG), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                MapLocationAddrActivity.this.baiduMap.setMyLocationData(new MyLocationData.Builder().latitude(convertBdLocation.getLatitude()).longitude(convertBdLocation.getLongitude()).build());
                MapLocationAddrActivity.this.titleBarView.setRightBtnEnable(true);
                AddressStatUtil.statAddressOption(StatKey.ADDR_MAP_LOCATE_ITEM_CLICK);
            }
        });
    }

    private void initLayoutParams() {
        int screenHeight = ScreenUtil.getScreenHeight(this) - ScreenUtil.dip2px(this, 40.0f);
        this.contentHeight = screenHeight;
        float f = screenHeight;
        this.mapControllerScrollValue = f * 0.25f;
        this.mapScrollValue = 0.125f * f;
        int dip2px = ((int) (f * 0.5f)) + ScreenUtil.dip2px(this, 200.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
        layoutParams.height = dip2px;
        this.mapView.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mapControllerView.getLayoutParams();
        layoutParams2.height = dip2px;
        this.mapControllerView.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mapMarkLayout.getLayoutParams();
        layoutParams3.height = dip2px;
        this.mapMarkLayout.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mapMaskView.getLayoutParams();
        layoutParams4.height = dip2px;
        this.mapMaskView.setLayoutParams(layoutParams4);
        this.mScrollLayout.setContentHeight(this.contentHeight);
        this.mScrollLayout.setOpenedOffset((int) (this.contentHeight * 0.25f));
        this.mScrollLayout.setHalfOffset((int) (this.contentHeight * 0.5f));
        this.mScrollLayout.setExitOffset(0);
        this.mScrollLayout.setIsSupportExit(false);
        this.mScrollLayout.setAllowHorizontalScroll(true);
        this.mScrollLayout.setOnScrollChangedListener(this);
        this.mScrollLayout.setAssociatedRecyclerView(this.mRecyclerView);
        this.mScrollLayout.setHalf();
        updatePanelSmallSize();
    }

    private void initMapView() {
        BaiduMap map = this.mapView.getMap();
        this.baiduMap = map;
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setCompassEnabled(false);
        uiSettings.setOverlookingGesturesEnabled(false);
        uiSettings.setRotateGesturesEnabled(false);
        this.mapView.setLogoPosition(LogoPosition.logoPostionleftBottom);
        this.mapView.showScaleControl(false);
        this.mapView.showZoomControls(false);
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.zoom(16.0f);
        this.baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        this.baiduMap.setMyLocationEnabled(true);
        this.baiduMap.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, null, 523470335, 523470335));
        this.baiduMap.setOnMapStatusChangeListener(this);
    }

    private void processLocGetPoiInfos() {
        List<JSONObject> addrList4AdapterShow = ((MapLocationPoiPresenter) this.presenter).getAddrList4AdapterShow();
        if (addrList4AdapterShow != null && !addrList4AdapterShow.isEmpty()) {
            this.mRecyclerView.setVisibility(0);
            this.mapAddrEmpty.setVisibility(8);
            this.mapLocAddrAdapter.setQueryContent(this.addrMapSearchEt.getText().toString().trim());
            this.mapLocAddrAdapter.setDatas(((MapLocationPoiPresenter) this.presenter).getAddrList4AdapterShow(), ((MapLocationPoiPresenter) this.presenter).isHasNextPage());
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.mapAddrEmpty.setVisibility(0);
    }

    private void initView() {
        TitleBarView titleBarView = (TitleBarView) findViewById(R.id.obfuscated_res_0x7f091fc5);
        this.titleBarView = titleBarView;
        titleBarView.setTitle("定位地址");
        this.titleBarView.setLeft("取消", this);
        this.titleBarView.setRight("确认", this);
        this.mapView = (MapView) findViewById(R.id.obfuscated_res_0x7f091fb7);
        this.mapControllerView = findViewById(R.id.obfuscated_res_0x7f091f23);
        this.mapMarkLayout = findViewById(R.id.obfuscated_res_0x7f091f24);
        this.mapMaskView = findViewById(R.id.obfuscated_res_0x7f091f25);
        this.mapLocBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fc4);
        this.mapZoomInBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fc6);
        this.mapZoomOutBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fc7);
        this.mScrollLayout = (ScrollLayout) findViewById(R.id.obfuscated_res_0x7f091fd0);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091fcd);
        this.mSearchBox = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091fd1);
        this.addrMapSearchEt = (EditText) findViewById(R.id.obfuscated_res_0x7f091fc3);
        this.cleanSearchTextBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f75);
        this.searchBoxLine = findViewById(R.id.obfuscated_res_0x7f091fd4);
        this.cancelSearchBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091f6b);
        this.mapAddrEmpty = (TextView) findViewById(R.id.obfuscated_res_0x7f091fc0);
        this.mapLocBtn.setOnClickListener(this);
        this.mapZoomInBtn.setOnClickListener(this);
        this.mapZoomOutBtn.setOnClickListener(this);
        this.cancelSearchBtn.setOnClickListener(this);
        this.cleanSearchTextBtn.setOnClickListener(this);
        this.loadingView = (SweepLightLoadingView) findViewById(R.id.obfuscated_res_0x7f091f46);
        this.mapAddrListLoading = findViewById(R.id.obfuscated_res_0x7f091fc1);
        initLayoutParams();
        initRecyclerView();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                Log.d(MapLocationAddrActivity.TAG, "onScrollStateChanged newState=" + i);
                if (i == 0 && ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).isHasNextPage()) {
                    ((MapLocationPoiPresenter) MapLocationAddrActivity.this.presenter).queryNextPageAddrList(false);
                }
            }
        });
        if (this.isDarkMode) {
            this.titleBarView.setDarkMode();
            this.mapMaskView.setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f091f54).setBackgroundResource(R.drawable.obfuscated_res_0x7f081267);
            this.mSearchBox.setBackgroundResource(R.drawable.obfuscated_res_0x7f081267);
            findViewById(R.id.obfuscated_res_0x7f091fcc).setBackgroundResource(R.drawable.obfuscated_res_0x7f081269);
            findViewById(R.id.obfuscated_res_0x7f091fd3).setBackgroundResource(R.drawable.obfuscated_res_0x7f08126b);
            ((ImageView) findViewById(R.id.obfuscated_res_0x7f091fd2)).setImageResource(R.drawable.obfuscated_res_0x7f0812cc);
            this.addrMapSearchEt.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a04));
            this.addrMapSearchEt.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a06));
            findViewById(R.id.obfuscated_res_0x7f091fd4).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a8));
            this.cancelSearchBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609ae));
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091fc2)).setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06099e));
            this.mapAddrEmpty.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a02));
            this.cleanSearchTextBtn.setImageResource(R.drawable.obfuscated_res_0x7f081282);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public MapLocationPoiPresenter createPresenter() {
        MapLocationPoiPresenter mapLocationPoiPresenter = new MapLocationPoiPresenter(this);
        String stringExtra = getIntent().getStringExtra(KEY_BDSTOKEN_FROM_ADDR_EDIT);
        if (TextUtils.isEmpty(stringExtra)) {
            mapLocationPoiPresenter.getBdStokenFromServer(Integer.MIN_VALUE, null);
        } else {
            mapLocationPoiPresenter.setBdSTokenFromAddrEdit(stringExtra);
        }
        return mapLocationPoiPresenter;
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        if (1004 == i) {
            this.isInitLoadComplete = true;
        }
        if (!TextUtils.isEmpty(str)) {
            ToastUtil.show(str);
        }
        this.mapAddrListLoading.setVisibility(8);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        if (i != 1001) {
            if (i != 1004) {
                if (i == 1005) {
                    processMapLoc2Region((JSONObject) obj);
                    return;
                }
                return;
            }
            this.isInitLoadComplete = true;
            this.mapAddrListLoading.setVisibility(8);
            processLocGetPoiInfos();
            return;
        }
        processMapLocData((MyLocationData) obj);
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
        if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
            return;
        }
        BaseOptionActivity.lastClickTime = currentTimeMillis;
        int id = view2.getId();
        if (R.id.obfuscated_res_0x7f091fe4 == id) {
            finish();
        } else if (R.id.obfuscated_res_0x7f091fe5 == id) {
            ((MapLocationPoiPresenter) this.presenter).mapLocItem2RegoinDetail(this.selectedAddrJsonObj);
        } else if (R.id.obfuscated_res_0x7f091f6b == id) {
            this.isUserGestureDragMap = false;
            hideSearchOptionViews();
            closeMapAddrListLayout();
            updateUserChoiceMapLocMarker();
            ((MapLocationPoiPresenter) this.presenter).setQueryAddrListType(0);
            this.mapLocAddrAdapter.setQueryContent("");
            ((MapLocationPoiPresenter) this.presenter).cleanUserSearchAndEmptyQueryContent();
            this.mapLocAddrAdapter.setDatas(((MapLocationPoiPresenter) this.presenter).getAddrListByUserMapChoice(), ((MapLocationPoiPresenter) this.presenter).isHasNextPageByUserMapChoiceLoc());
            this.mRecyclerView.setVisibility(0);
        } else if (R.id.obfuscated_res_0x7f091f75 == id) {
            this.addrMapSearchEt.setText("");
        } else if (R.id.obfuscated_res_0x7f091fc4 == id) {
            ((MapLocationPoiPresenter) this.presenter).setQueryAddrListType(0);
            ((MapLocationPoiPresenter) this.presenter).queryAddrListByLocAddr();
        } else if (R.id.obfuscated_res_0x7f091fc6 == id) {
            this.baiduMap.setMapStatus(MapStatusUpdateFactory.zoomIn());
        } else if (R.id.obfuscated_res_0x7f091fc7 == id) {
            this.baiduMap.setMapStatus(MapStatusUpdateFactory.zoomOut());
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        LatLng latLng;
        Point point;
        if (mapStatus != null && (latLng = mapStatus.target) != null && (point = mapStatus.targetScreen) != null && latLng.latitude >= 0.0d && latLng.longitude >= 0.0d && point.x >= 0 && point.y >= 0) {
            Log.d(TAG, "onMapStatusChangeFinish: x=" + mapStatus.targetScreen.x + ", y=" + mapStatus.targetScreen.y);
            Log.d(TAG, "onMapStatusChangeFinish: lat=" + mapStatus.target.latitude + ", lng=" + mapStatus.target.longitude);
            if (!this.isInitLoadComplete) {
                Log.d(TAG, "onMapStatusChangeFinish init load has not complete");
            } else if (this.isUserGestureDragMap) {
                this.mapChoiceLocData = new MyLocationData.Builder().latitude(mapStatus.target.latitude).longitude(mapStatus.target.longitude).speed(0.0f).build();
                this.mapLocAddrAdapter.cleanData();
                ((MapLocationPoiPresenter) this.presenter).setSelectedAddrId("");
                LatLng latLng2 = mapStatus.target;
                ((MapLocationPoiPresenter) this.presenter).reverseGeoCode(new LatLng(latLng2.latitude, latLng2.longitude));
            } else {
                this.isUserGestureDragMap = true;
            }
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (this.addressManageDTO != null && this.addressManageDTO.mapStatusAndLocateCallback != null) {
                setContentView(R.layout.obfuscated_res_0x7f0d056d);
                ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060a7c));
                initView();
                initMapView();
                setListener();
                this.mapViewInitSuccess = true;
                requestLocation();
                this.isFromCreateAddr = getIntent().getBooleanExtra("key_from_type", true);
                AddressStatUtil.statAddressOption(StatKey.ADDR_MAP_LOCATE_ENTER);
                return;
            }
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            this.mapViewInitSuccess = false;
            finish();
        }
    }
}
