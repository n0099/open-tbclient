package com.baidu.swan.impl.map.location.search;

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
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private RecyclerView dgH;
    private List<g> dgU;
    private com.baidu.swan.impl.map.location.b dgW;
    private EditText dhR;
    private View dhS;
    private TextView dhT;
    private LinearLayoutManager dhU;
    private String dhX;
    private boolean dhY;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dhV = null;
    private int mCurrentIndex = 0;
    private int dhW = 0;
    private String dhZ = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aDY() {
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH != null) {
            QH.jp("navigateTo").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).f(this).Zb();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aDA();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
            applyImmersion(-1);
        }
        return enableSliding(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.dgU = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dhZ = string;
        }
        this.dhR = (EditText) view.findViewById(R.id.search_text);
        this.dgH = (RecyclerView) view.findViewById(R.id.location_list);
        this.dhS = view.findViewById(R.id.no_result_tip);
        this.dhT = (TextView) view.findViewById(R.id.cancel_search);
        this.dhU = new LinearLayoutManager(f.ahV().ahF());
        this.dgH.setLayoutManager(this.dhU);
        this.dgW = new com.baidu.swan.impl.map.location.b(f.ahV().ahF(), this.dgH, this);
        this.dgH.setAdapter(this.dgW);
        this.dgH.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.ahV().ahF()));
        this.dgH.setOnTouchListener(this);
        this.dhT.setOnClickListener(this);
        this.dhV = PoiSearch.newInstance();
        this.dhV.setOnGetPoiSearchResultListener(this);
        this.dhR.addTextChangedListener(this);
        this.dhR.setOnFocusChangeListener(this);
        this.dhR.setOnKeyListener(this);
        this.dhR.requestFocus();
        this.dgH.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aEw;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aEw = a.this.aEw()) >= 0 && aEw + 1 == a.this.dgW.getItemCount()) {
                    a.this.aEy();
                }
            }
        });
        this.dhR.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.dhR, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.ahV().ahF().getApplicationContext().getSystemService("input_method");
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
    public int aEw() {
        if (this.dhU != null) {
            return this.dhU.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aEw = aEw();
        if (aEw == -1) {
            return null;
        }
        return this.dhU.findViewByPosition(aEw);
    }

    private void aEx() {
        if (!TextUtils.isEmpty(this.dhX)) {
            this.mCurrentIndex = 0;
            sT(this.dhX);
            d(this.dhR, false);
        }
    }

    private void sT(String str) {
        this.dhV.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dhZ).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aEy() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dhW) {
                sT(this.dhX);
                this.mIsLoading = true;
                return;
            }
            aEz();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dhr != null && gVar.dhr.location != null) {
            PoiInfo poiInfo = gVar.dhr;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        y(intent);
        aEl();
    }

    private void y(Intent intent) {
        if (aHu() != null) {
            aHu().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dhY) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dhW = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dgU.clear();
                }
                this.dgU.addAll(g.an(poiResult.getAllPoi()));
                this.dgW.b(this.dgU, this.dhX);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dhW = 0;
                    this.dgU.clear();
                    this.dgW.setData(this.dgU);
                }
                aEz();
            }
            if (this.mCurrentIndex == 0 && this.dgU.size() == 0) {
                z = true;
            }
            ga(z);
            if (this.dgU.size() <= 0) {
                aEz();
            }
        }
    }

    private void aEz() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dgH.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void ga(boolean z) {
        this.dhS.setVisibility(z ? 0 : 8);
    }

    private void aEl() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dhV.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dgU.clear();
            this.dgW.setData(this.dgU);
            this.dhX = "";
            this.mCurrentIndex = 0;
            this.dhW = 0;
            this.dhY = true;
            return;
        }
        this.dhY = false;
        this.mCurrentIndex = 0;
        this.dhW = 0;
        this.dhX = editable.toString();
        sT(this.dhX);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.dhR, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aEl();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aEx();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.dhR, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
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
