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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter;
import com.baidu.pass.ecommerce.presenter.OnceLocationManager;
import com.baidu.pass.ecommerce.view.ScrollLayout;
import com.baidu.pass.ecommerce.view.ScrollRecyclerView;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MapLocationAddrActivity extends BaseAddressActivity<MapLocationPoiPresenter> implements ScrollLayout.OnScrollChangedListener, BaiduMap.OnMapStatusChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_BDSTOKEN_FROM_ADDR_EDIT = "key_bdstoken_from_addr_edit";
    public static final String KEY_FROM_TYPE = "key_from_type";
    public static final String TAG = "MapLocationPoiActivity";
    public transient /* synthetic */ FieldHolder $fh;
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
    public boolean isUserGestureDragMap;
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

    public MapLocationAddrActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isUserGestureDragMap = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeMapAddrListLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            SapiUtils.hideSoftInput(this);
            this.mScrollLayout.setHalf();
        }
    }

    private void hideSearchOptionViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
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
    }

    private void initLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            int screenHeight = ScreenUtil.getScreenHeight(this) - ScreenUtil.dip2px(this, 40.0f);
            this.contentHeight = screenHeight;
            float f2 = screenHeight;
            this.mapControllerScrollValue = f2 * 0.25f;
            this.mapScrollValue = 0.125f * f2;
            int dip2px = ((int) (f2 * 0.5f)) + ScreenUtil.dip2px(this, 200.0f);
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
    }

    private void initMapView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
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
    }

    private void initRecyclerView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.mLinearLayoutManager = linearLayoutManager;
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            MapLocAddrAdapter mapLocAddrAdapter = new MapLocAddrAdapter((MapLocationPoiPresenter) this.presenter, this.isDarkMode);
            this.mapLocAddrAdapter = mapLocAddrAdapter;
            this.mRecyclerView.setAdapter(mapLocAddrAdapter);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            TitleBarView titleBarView = (TitleBarView) findViewById(R.id.sapi_sdk_map_location_poi_title);
            this.titleBarView = titleBarView;
            titleBarView.setTitle("定位地址");
            this.titleBarView.setLeft("取消", this);
            this.titleBarView.setRight("确认", this);
            this.mapView = (MapView) findViewById(R.id.sapi_sdk_location_poi_map_view);
            this.mapControllerView = findViewById(R.id.sapi_loc_map_controller_view);
            this.mapMarkLayout = findViewById(R.id.sapi_loc_map_marker_view);
            this.mapMaskView = findViewById(R.id.sapi_loc_map_shape_mask);
            this.mapLocBtn = (ImageView) findViewById(R.id.sapi_sdk_map_loc_btn);
            this.mapZoomInBtn = (ImageView) findViewById(R.id.sapi_sdk_map_zoom_in_btn);
            this.mapZoomOutBtn = (ImageView) findViewById(R.id.sapi_sdk_map_zoom_out_btn);
            this.mScrollLayout = (ScrollLayout) findViewById(R.id.sapi_sdk_scroll_layout);
            this.mRecyclerView = (RecyclerView) findViewById(R.id.sapi_sdk_recycler_view);
            this.mSearchBox = (LinearLayout) findViewById(R.id.sapi_sdk_search_box);
            this.addrMapSearchEt = (EditText) findViewById(R.id.sapi_sdk_map_addr_search_et);
            this.cleanSearchTextBtn = (ImageView) findViewById(R.id.sapi_sdk_clean_map_addr_search_text);
            this.searchBoxLine = findViewById(R.id.sapi_sdk_search_box_line);
            this.cancelSearchBtn = (TextView) findViewById(R.id.sapi_sdk_cancel_query_map_addr);
            this.mapAddrEmpty = (TextView) findViewById(R.id.sapi_sdk_map_addr_empty_notice);
            this.mapLocBtn.setOnClickListener(this);
            this.mapZoomInBtn.setOnClickListener(this);
            this.mapZoomOutBtn.setOnClickListener(this);
            this.cancelSearchBtn.setOnClickListener(this);
            this.cleanSearchTextBtn.setOnClickListener(this);
            this.loadingView = (SweepLightLoadingView) findViewById(R.id.sapi_sdk_addr_loading_view);
            this.mapAddrListLoading = findViewById(R.id.sapi_sdk_map_addr_list_loading);
            initLayoutParams();
            initRecyclerView();
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i2) == null) {
                        super.onScrollStateChanged(recyclerView, i2);
                        Log.d(MapLocationAddrActivity.TAG, "onScrollStateChanged newState=" + i2);
                        if (i2 == 0 && ((MapLocationPoiPresenter) this.this$0.presenter).isHasNextPage()) {
                            ((MapLocationPoiPresenter) this.this$0.presenter).queryNextPageAddrList(false);
                        }
                    }
                }
            });
            if (this.isDarkMode) {
                this.titleBarView.setDarkMode();
                this.mapMaskView.setVisibility(0);
                findViewById(R.id.sapi_sdk_addr_query_panel).setBackgroundResource(R.drawable.sapi_sdk_addr_map_scroll_layout_dark_bg);
                this.mSearchBox.setBackgroundResource(R.drawable.sapi_sdk_addr_map_scroll_layout_dark_bg);
                findViewById(R.id.sapi_sdk_panel_handler_view).setBackgroundResource(R.drawable.sapi_sdk_addr_map_scroll_top_line_dark);
                findViewById(R.id.sapi_sdk_search_box_layout).setBackgroundResource(R.drawable.sapi_sdk_addr_map_search_box_bg_dark);
                ((ImageView) findViewById(R.id.sapi_sdk_search_box_ic)).setImageResource(R.drawable.sapi_sdk_map_addr_search_box_dark);
                this.addrMapSearchEt.setHintTextColor(getResources().getColor(R.color.sapi_sdk_addr_map_search_hint_text_dark_color));
                this.addrMapSearchEt.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_map_search_text_dark_color));
                findViewById(R.id.sapi_sdk_search_box_line).setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
                this.cancelSearchBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_text_dark_color));
                ((TextView) findViewById(R.id.sapi_sdk_map_addr_loading_tips)).setTextColor(getResources().getColor(R.color.sapi_sdk_addr_edit_custom_tag_no_checked_text_dark_color));
                this.mapAddrEmpty.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_map_search_empty_dark_color));
                this.cleanSearchTextBtn.setImageResource(R.drawable.sapi_sdk_common_et_clean_bg_dark);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMapAddrListLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.mScrollLayout.setToOpen();
            this.mapLocAddrAdapter.setDatas(((MapLocationPoiPresenter) this.presenter).getAddrListByUserInput(), ((MapLocationPoiPresenter) this.presenter).isHasNextPageByUserInput());
        }
    }

    private void processLocGetPoiInfos() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
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
    }

    private void processMapLoc2Region(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, jSONObject) == null) {
            AddressSelectedBean convertRegionJsonObj2Region = AddressConverter.convertRegionJsonObj2Region(jSONObject);
            String optString = jSONObject.optString(AddressField.KEY_DETAIL_ADDR);
            Intent intent = new Intent();
            intent.putExtra(AddressEditActivity.MAP_LOC_REGION_DETAIL, convertRegionJsonObj2Region);
            intent.putExtra(AddressEditActivity.MAP_LOC_ADDR_DETAIL, optString);
            setResult(10001, intent);
            finish();
        }
    }

    private void processMapLocData(MyLocationData myLocationData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65578, this, myLocationData) == null) || myLocationData == null) {
            return;
        }
        this.mapChoiceLocData = myLocationData;
        updateUserChoiceMapLocMarker();
        if (TextUtils.isEmpty(this.addrMapSearchEt.getText().toString())) {
            ((MapLocationPoiPresenter) this.presenter).updateLatLngAndReverseGeoCode(new LatLng(myLocationData.latitude, myLocationData.longitude));
        }
        this.loadingView.setVisibility(8);
    }

    private void requestLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.loadingView.setVisibility(0);
            ((MapLocationPoiPresenter) this.presenter).requestLocation();
        }
    }

    private void setListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            this.mapMarkLayout.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        this.this$0.closeMapAddrListLayout();
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.mSearchBox.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        this.this$0.closeMapAddrListLayout();
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.mScrollLayout.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.this$0.isSoftKeyBoardShowing) {
                            this.this$0.closeMapAddrListLayout();
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.addrMapSearchEt.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.this$0.searchBoxLine.setVisibility(0);
                            this.this$0.cancelSearchBtn.setVisibility(0);
                            this.this$0.isFocusSearchBoxEt = true;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.addrMapSearchEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i2, i3, i4) == null) {
                        if (this.this$0.isAutoUpdateSearchContent) {
                            this.this$0.isAutoUpdateSearchContent = false;
                            return;
                        }
                        this.this$0.mapAddrEmpty.setVisibility(8);
                        this.this$0.selectedAddrJsonObj = null;
                        this.this$0.titleBarView.setRightBtnEnable(false);
                        if (charSequence.length() > 0) {
                            this.this$0.cleanSearchTextBtn.setVisibility(0);
                            this.this$0.mapLocAddrAdapter.cleanData();
                            ((MapLocationPoiPresenter) this.this$0.presenter).queryAddrListByUserInputLoc(charSequence.toString().trim());
                            return;
                        }
                        this.this$0.mapAddrListLoading.setVisibility(8);
                        this.this$0.cleanSearchTextBtn.setVisibility(8);
                        this.this$0.mapLocAddrAdapter.cleanData();
                        this.this$0.mapLocAddrAdapter.setQueryContent("");
                        ((MapLocationPoiPresenter) this.this$0.presenter).cleanUserSearchAndEmptyQueryContent();
                    }
                }
            });
            SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardHide(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.this$0.isSoftKeyBoardShowing = false;
                        this.this$0.updatePanelSmallSize();
                    }
                }

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardShow(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        this.this$0.isSoftKeyBoardShowing = true;
                        if (this.this$0.isFocusSearchBoxEt) {
                            this.this$0.isFocusSearchBoxEt = false;
                            ((MapLocationPoiPresenter) this.this$0.presenter).setQueryAddrListType(1);
                            this.this$0.openMapAddrListLayout();
                        }
                        this.this$0.mapAddrEmpty.postDelayed(new Runnable(this, i2) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass7 this$1;
                            public final /* synthetic */ int val$height;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$height = i2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.this$1.this$0.panelHeightOnKeyBoardShow <= 0) {
                                        int[] iArr = new int[2];
                                        this.this$1.this$0.mSearchBox.getLocationInWindow(iArr);
                                        MapLocationAddrActivity mapLocationAddrActivity = this.this$1.this$0;
                                        mapLocationAddrActivity.panelHeightOnKeyBoardShow = ((ScreenUtil.getScreenHeight(mapLocationAddrActivity) - this.val$height) - iArr[1]) + this.this$1.this$0.mSearchBox.getHeight();
                                    }
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.this$1.this$0.mapAddrEmpty.getLayoutParams();
                                    layoutParams.height = this.this$1.this$0.panelHeightOnKeyBoardShow;
                                    this.this$1.this$0.mapAddrEmpty.setLayoutParams(layoutParams);
                                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.this$1.this$0.mapAddrListLoading.getLayoutParams();
                                    layoutParams2.height = this.this$1.this$0.panelHeightOnKeyBoardShow;
                                    this.this$1.this$0.mapAddrListLoading.setLayoutParams(layoutParams2);
                                }
                            }
                        }, 100L);
                    }
                }
            });
            this.mapLocAddrAdapter.setItemClickListener(new ScrollRecyclerView.RecyclerViewItemClickListener<JSONObject>(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.pass.ecommerce.view.ScrollRecyclerView.RecyclerViewItemClickListener
                public void onItemClickListener(int i2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, jSONObject) == null) {
                        this.this$0.addrMapSearchEt.clearFocus();
                        this.this$0.selectedAddrJsonObj = jSONObject;
                        ((MapLocationPoiPresenter) this.this$0.presenter).setSelectedAddrId(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID));
                        this.this$0.isUserGestureDragMap = false;
                        BDLocation convertBdLocation = OnceLocationManager.getInstance().convertBdLocation(jSONObject.optDouble(SuggestAddrField.KEY_MAP_LAT), jSONObject.optDouble(SuggestAddrField.KEY_MAP_LNG), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                        this.this$0.baiduMap.setMyLocationData(new MyLocationData.Builder().latitude(convertBdLocation.getLatitude()).longitude(convertBdLocation.getLongitude()).build());
                        this.this$0.titleBarView.setRightBtnEnable(true);
                        AddressStatUtil.onEventAutoStatistic(StatKey.ADDR_MAP_LOCATE_ITEM_CLICK, this.this$0.isFromCreateAddr ? "0" : "1");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePanelSmallSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.mapAddrEmpty.postDelayed(new Runnable(this) { // from class: com.baidu.sapi2.ecommerce.activity.MapLocationAddrActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationAddrActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.this$0.mapAddrEmpty.getLayoutParams();
                        if (this.this$0.panelHeightOnKeyBoardHide <= 0) {
                            int[] iArr = new int[2];
                            this.this$0.mSearchBox.getLocationInWindow(iArr);
                            MapLocationAddrActivity mapLocationAddrActivity = this.this$0;
                            mapLocationAddrActivity.panelHeightOnKeyBoardHide = (ScreenUtil.getScreenHeight(mapLocationAddrActivity) - iArr[1]) + this.this$0.mSearchBox.getHeight();
                        }
                        layoutParams.height = this.this$0.panelHeightOnKeyBoardHide;
                        this.this$0.mapAddrEmpty.setLayoutParams(layoutParams);
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.this$0.mapAddrListLoading.getLayoutParams();
                        layoutParams2.height = this.this$0.panelHeightOnKeyBoardHide;
                        this.this$0.mapAddrListLoading.setLayoutParams(layoutParams2);
                    }
                }
            }, 100L);
        }
    }

    private void updateUserChoiceMapLocMarker() {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65582, this) == null) && this.mapViewInitSuccess && (baiduMap = this.baiduMap) != null) {
            baiduMap.setMyLocationData(this.mapChoiceLocData);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            if (1004 == i2) {
                this.isInitLoadComplete = true;
            }
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.show(str);
            }
            this.mapAddrListLoading.setVisibility(8);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            if (i2 == 1001) {
                processMapLocData((MyLocationData) obj);
            } else if (i2 != 1004) {
                if (i2 != 1005) {
                    return;
                }
                processMapLoc2Region((JSONObject) obj);
            } else {
                this.isInitLoadComplete = true;
                this.mapAddrListLoading.setVisibility(8);
                processLocGetPoiInfos();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.finish();
            overridePendingTransition(0, R.anim.sapi_sdk_anim_activity_push_bottom_out);
        }
    }

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onChildScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
            if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
                return;
            }
            BaseOptionActivity.lastClickTime = currentTimeMillis;
            int id = view.getId();
            if (R.id.sapi_sdk_titlebar_left_btn == id) {
                finish();
            } else if (R.id.sapi_sdk_titlebar_right_btn == id) {
                ((MapLocationPoiPresenter) this.presenter).mapLocItem2RegoinDetail(this.selectedAddrJsonObj);
            } else if (R.id.sapi_sdk_cancel_query_map_addr == id) {
                this.isUserGestureDragMap = false;
                hideSearchOptionViews();
                closeMapAddrListLayout();
                updateUserChoiceMapLocMarker();
                ((MapLocationPoiPresenter) this.presenter).setQueryAddrListType(0);
                this.mapLocAddrAdapter.setQueryContent("");
                ((MapLocationPoiPresenter) this.presenter).cleanUserSearchAndEmptyQueryContent();
                this.mapLocAddrAdapter.setDatas(((MapLocationPoiPresenter) this.presenter).getAddrListByUserMapChoice(), ((MapLocationPoiPresenter) this.presenter).isHasNextPageByUserMapChoiceLoc());
                this.mRecyclerView.setVisibility(0);
            } else if (R.id.sapi_sdk_clean_map_addr_search_text == id) {
                this.addrMapSearchEt.setText("");
            } else if (R.id.sapi_sdk_map_loc_btn == id) {
                ((MapLocationPoiPresenter) this.presenter).setQueryAddrListType(0);
                ((MapLocationPoiPresenter) this.presenter).queryAddrListByLocAddr();
            } else if (R.id.sapi_sdk_map_zoom_in_btn == id) {
                this.baiduMap.setMapStatus(MapStatusUpdateFactory.zoomIn());
            } else if (R.id.sapi_sdk_map_zoom_out_btn == id) {
                this.baiduMap.setMapStatus(MapStatusUpdateFactory.zoomOut());
            }
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            try {
                super.onCreate(bundle);
                if (this.addressManageDTO != null && this.addressManageDTO.mapStatusAndLocateCallback != null) {
                    setContentView(R.layout.layout_sapi_sdk_map_location_poi_activity);
                    ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.sapi_sek_title_bar_bg_start_color));
                    setEnableSliding(false);
                    initView();
                    initMapView();
                    setListener();
                    this.mapViewInitSuccess = true;
                    requestLocation();
                    boolean booleanExtra = getIntent().getBooleanExtra("key_from_type", true);
                    this.isFromCreateAddr = booleanExtra;
                    AddressStatUtil.onEventAutoStatistic(StatKey.ADDR_MAP_LOCATE_ENTER, booleanExtra ? "0" : "1");
                    return;
                }
                finish();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mapViewInitSuccess = false;
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            if (!this.mapViewInitSuccess || (mapView = this.mapView) == null) {
                return;
            }
            mapView.onDestroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        LatLng latLng;
        Point point;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, mapStatus) == null) || mapStatus == null || (latLng = mapStatus.target) == null || (point = mapStatus.targetScreen) == null || latLng.latitude < 0.0d || latLng.longitude < 0.0d || point.x < 0 || point.y < 0) {
            return;
        }
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

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, mapStatus, i2) == null) {
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            if (!this.mapViewInitSuccess || (mapView = this.mapView) == null) {
                return;
            }
            mapView.onPause();
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            if (!this.mapViewInitSuccess || (mapView = this.mapView) == null) {
                return;
            }
            mapView.onResume();
        }
    }

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onScrollFinished(ScrollLayout.Status status) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, status) == null) {
        }
    }

    @Override // com.baidu.pass.ecommerce.view.ScrollLayout.OnScrollChangedListener
    public void onScrollProgressChanged(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            float f3 = 1.0f - f2;
            float f4 = -(this.mapScrollValue * f3);
            this.mapView.setTranslationY(f4);
            this.mapMarkLayout.setTranslationY(f4);
            this.mapControllerView.setTranslationY(-(this.mapControllerScrollValue * f3));
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && i2 == 1004) {
            this.mapAddrListLoading.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public MapLocationPoiPresenter createPresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MapLocationPoiPresenter mapLocationPoiPresenter = new MapLocationPoiPresenter(this);
            String stringExtra = getIntent().getStringExtra(KEY_BDSTOKEN_FROM_ADDR_EDIT);
            if (TextUtils.isEmpty(stringExtra)) {
                mapLocationPoiPresenter.getBdStokenFromServer(Integer.MIN_VALUE, null);
            } else {
                mapLocationPoiPresenter.setBdSTokenFromAddrEdit(stringExtra);
            }
            return mapLocationPoiPresenter;
        }
        return (MapLocationPoiPresenter) invokeV.objValue;
    }
}
