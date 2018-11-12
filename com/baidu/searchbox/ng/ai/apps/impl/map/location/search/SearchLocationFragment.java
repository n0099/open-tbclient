package com.baidu.searchbox.ng.ai.apps.impl.map.location.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.searchbox.bdmapsdk.BdMapRuntime;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationDetailAdapter;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationFooterViewHolder;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationItemClickListener;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationItemDecoration;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationPOIModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.model.SelectedLocationInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SearchLocationFragment extends AiAppsBaseFragment implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, LocationItemClickListener {
    private static final String DEFAULT_CITY = "北京";
    private static final int INPUT_SHOW_DELAY = 100;
    private static final String KEY_CITY = "city";
    private static final int PAGE_MAX = 13;
    private static final int SCOPE = 2;
    private LocationDetailAdapter mAdapter;
    private TextView mCancel;
    private String mCurrentKeyWorld;
    private InputMethodManager mImm;
    private boolean mIsClear;
    private boolean mIsLoading;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mLocationList;
    private List<LocationPOIModel> mLocationPOIModels;
    private View mNoResultTip;
    private EditText mSearchText;
    private PoiSearch mPoiSearch = null;
    private int mCurrentIndex = 0;
    private int mTotalPageNum = 0;
    private String mCurrentCity = DEFAULT_CITY;

    public static SearchLocationFragment newInstance(Bundle bundle) {
        SearchLocationFragment searchLocationFragment = new SearchLocationFragment();
        if (bundle != null) {
            searchLocationFragment.setArguments(bundle);
        }
        return searchLocationFragment;
    }

    public void startFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null) {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(this).commitNow();
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BdMapRuntime.makeSureMapSDKInit();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(e.h.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.mLocationPOIModels = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString(KEY_CITY);
            if (TextUtils.isEmpty(string)) {
                string = DEFAULT_CITY;
            }
            this.mCurrentCity = string;
        }
        this.mSearchText = (EditText) view.findViewById(e.g.search_text);
        this.mLocationList = (RecyclerView) view.findViewById(e.g.location_list);
        this.mNoResultTip = view.findViewById(e.g.no_result_tip);
        this.mCancel = (TextView) view.findViewById(e.g.cancel_search);
        this.mLinearLayoutManager = new LinearLayoutManager(AiAppsController.getInstance().getActivity());
        this.mLocationList.setLayoutManager(this.mLinearLayoutManager);
        this.mAdapter = new LocationDetailAdapter(AiAppsController.getInstance().getActivity(), this.mLocationList, this);
        this.mLocationList.setAdapter(this.mAdapter);
        this.mLocationList.addItemDecoration(new LocationItemDecoration(AiAppsController.getInstance().getActivity()));
        this.mLocationList.setOnTouchListener(this);
        this.mCancel.setOnClickListener(this);
        this.mPoiSearch = PoiSearch.newInstance();
        this.mPoiSearch.setOnGetPoiSearchResultListener(this);
        this.mSearchText.addTextChangedListener(this);
        this.mSearchText.setOnFocusChangeListener(this);
        this.mSearchText.setOnKeyListener(this);
        this.mSearchText.requestFocus();
        this.mLocationList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.search.SearchLocationFragment.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int lastViewPosition;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (lastViewPosition = SearchLocationFragment.this.getLastViewPosition()) >= 0 && lastViewPosition + 1 == SearchLocationFragment.this.mAdapter.getItemCount()) {
                    SearchLocationFragment.this.getNextPage();
                }
            }
        });
        this.mSearchText.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.search.SearchLocationFragment.2
            @Override // java.lang.Runnable
            public void run() {
                SearchLocationFragment.this.showInput(SearchLocationFragment.this.mSearchText, true);
            }
        }, 100L);
    }

    public void showInput(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) AiAppsController.getInstance().getActivity().getApplicationContext().getSystemService("input_method");
        }
        if (this.mImm != null) {
            if (z) {
                this.mImm.showSoftInput(view, 0);
            } else {
                this.mImm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastViewPosition() {
        if (this.mLinearLayoutManager != null) {
            return this.mLinearLayoutManager.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int lastViewPosition = getLastViewPosition();
        if (lastViewPosition == -1) {
            return null;
        }
        return this.mLinearLayoutManager.findViewByPosition(lastViewPosition);
    }

    private void reSearch() {
        if (!TextUtils.isEmpty(this.mCurrentKeyWorld)) {
            this.mCurrentIndex = 0;
            startSearch(this.mCurrentKeyWorld);
            showInput(this.mSearchText, false);
        }
    }

    private void startSearch(String str) {
        this.mPoiSearch.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.mCurrentCity).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void getNextPage() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.mTotalPageNum) {
                startSearch(this.mCurrentKeyWorld);
                this.mIsLoading = true;
                return;
            }
            onGetNoResult();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationItemClickListener
    public void onItemClick(LocationPOIModel locationPOIModel) {
        Intent intent = new Intent();
        if (locationPOIModel.poiInfo != null && locationPOIModel.poiInfo.location != null) {
            PoiInfo poiInfo = locationPOIModel.poiInfo;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        sendResult(intent);
        exitFragment();
    }

    private void sendResult(Intent intent) {
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.mIsClear) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.mTotalPageNum = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.mLocationPOIModels.clear();
                }
                this.mLocationPOIModels.addAll(LocationPOIModel.createModels(poiResult.getAllPoi()));
                this.mAdapter.setData(this.mLocationPOIModels, this.mCurrentKeyWorld);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.mTotalPageNum = 0;
                    this.mLocationPOIModels.clear();
                    this.mAdapter.setData(this.mLocationPOIModels);
                }
                onGetNoResult();
            }
            if (this.mCurrentIndex == 0 && this.mLocationPOIModels.size() == 0) {
                z = true;
            }
            showNoResultTip(z);
            if (this.mLocationPOIModels.size() <= 0) {
                onGetNoResult();
            }
        }
    }

    private void onGetNoResult() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.mLocationList.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof LocationFooterViewHolder) {
                ((LocationFooterViewHolder) childViewHolder).setVisibility(false);
            }
        }
    }

    public void showNoResultTip(boolean z) {
        this.mNoResultTip.setVisibility(z ? 0 : 8);
    }

    private void exitFragment() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mPoiSearch.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.mLocationPOIModels.clear();
            this.mAdapter.setData(this.mLocationPOIModels);
            this.mCurrentKeyWorld = "";
            this.mCurrentIndex = 0;
            this.mTotalPageNum = 0;
            this.mIsClear = true;
            return;
        }
        this.mIsClear = false;
        this.mCurrentIndex = 0;
        this.mTotalPageNum = 0;
        this.mCurrentKeyWorld = editable.toString();
        startSearch(this.mCurrentKeyWorld);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        showInput(this.mSearchText, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.cancel_search) {
            exitFragment();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            reSearch();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        showInput(this.mSearchText, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
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
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
