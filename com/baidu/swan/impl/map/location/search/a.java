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
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.impl.map.location.b;
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private TextView bOb;
    private RecyclerView ecb;
    private List<g> eco;
    private b ecq;
    private EditText edm;
    private View edn;
    private LinearLayoutManager edo;
    private String edr;
    private boolean eds;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch edp = null;
    private int mCurrentIndex = 0;
    private int edq = 0;
    private String edt = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aYT() {
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            afe.mV("navigateTo").al(f.cJi, f.cJk).f(this).aoE();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aYv();
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
        this.eco = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.edt = string;
        }
        this.edm = (EditText) view.findViewById(R.id.search_text);
        this.ecb = (RecyclerView) view.findViewById(R.id.location_list);
        this.edn = view.findViewById(R.id.no_result_tip);
        this.bOb = (TextView) view.findViewById(R.id.cancel_search);
        this.edo = new LinearLayoutManager(com.baidu.swan.apps.v.f.azg().ayQ());
        this.ecb.setLayoutManager(this.edo);
        this.ecq = new b(com.baidu.swan.apps.v.f.azg().ayQ(), this.ecb, this);
        this.ecb.setAdapter(this.ecq);
        this.ecb.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.azg().ayQ()));
        this.ecb.setOnTouchListener(this);
        this.bOb.setOnClickListener(this);
        this.edp = PoiSearch.newInstance();
        this.edp.setOnGetPoiSearchResultListener(this);
        this.edm.addTextChangedListener(this);
        this.edm.setOnFocusChangeListener(this);
        this.edm.setOnKeyListener(this);
        this.edm.requestFocus();
        this.ecb.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aZr;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aZr = a.this.aZr()) >= 0 && aZr + 1 == a.this.ecq.getItemCount()) {
                    a.this.aZt();
                }
            }
        });
        this.edm.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.edm, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.azg().ayQ().getApplicationContext().getSystemService("input_method");
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
    public int aZr() {
        if (this.edo != null) {
            return this.edo.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aZr = aZr();
        if (aZr == -1) {
            return null;
        }
        return this.edo.findViewByPosition(aZr);
    }

    private void aZs() {
        if (!TextUtils.isEmpty(this.edr)) {
            this.mCurrentIndex = 0;
            yc(this.edr);
            d(this.edm, false);
        }
    }

    private void yc(String str) {
        this.edp.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.edt).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aZt() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.edq) {
                yc(this.edr);
                this.mIsLoading = true;
                return;
            }
            aZu();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.ecM != null && gVar.ecM.location != null) {
            PoiInfo poiInfo = gVar.ecM;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aZg();
    }

    private void A(Intent intent) {
        if (bbZ() != null) {
            bbZ().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.eds) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.edq = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.eco.clear();
                }
                this.eco.addAll(g.aU(poiResult.getAllPoi()));
                this.ecq.c(this.eco, this.edr);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.edq = 0;
                    this.eco.clear();
                    this.ecq.setData(this.eco);
                }
                aZu();
            }
            if (this.mCurrentIndex == 0 && this.eco.size() == 0) {
                z = true;
            }
            hR(z);
            if (this.eco.size() <= 0) {
                aZu();
            }
        }
    }

    private void aZu() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.ecb.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void hR(boolean z) {
        this.edn.setVisibility(z ? 0 : 8);
    }

    private void aZg() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.edp.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.eco.clear();
            this.ecq.setData(this.eco);
            this.edr = "";
            this.mCurrentIndex = 0;
            this.edq = 0;
            this.eds = true;
            return;
        }
        this.eds = false;
        this.mCurrentIndex = 0;
        this.edq = 0;
        this.edr = editable.toString();
        yc(this.edr);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.edm, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aZg();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aZs();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.edm, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
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
