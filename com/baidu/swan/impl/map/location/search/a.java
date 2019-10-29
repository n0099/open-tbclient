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
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.f;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private RecyclerView bHG;
    private List<g> bHT;
    private com.baidu.swan.impl.map.location.b bHV;
    private EditText bIQ;
    private View bIR;
    private TextView bIS;
    private LinearLayoutManager bIT;
    private InputMethodManager bIV;
    private String bIX;
    private boolean bIY;
    private boolean mIsLoading;
    private PoiSearch bIU = null;
    private int apR = 0;
    private int bIW = 0;
    private String bIZ = "北京";

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void ZD() {
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null) {
            AH.eC("navigateTo").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).c(this).FC();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Zi();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (EI()) {
            inflate = Y(inflate);
            da(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bHT = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bIZ = string;
        }
        this.bIQ = (EditText) view.findViewById(R.id.search_text);
        this.bHG = (RecyclerView) view.findViewById(R.id.location_list);
        this.bIR = view.findViewById(R.id.no_result_tip);
        this.bIS = (TextView) view.findViewById(R.id.cancel_search);
        this.bIT = new LinearLayoutManager(com.baidu.swan.apps.w.e.LD().Lp());
        this.bHG.setLayoutManager(this.bIT);
        this.bHV = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.LD().Lp(), this.bHG, this);
        this.bHG.setAdapter(this.bHV);
        this.bHG.addItemDecoration(new f(com.baidu.swan.apps.w.e.LD().Lp()));
        this.bHG.setOnTouchListener(this);
        this.bIS.setOnClickListener(this);
        this.bIU = PoiSearch.newInstance();
        this.bIU.setOnGetPoiSearchResultListener(this);
        this.bIQ.addTextChangedListener(this);
        this.bIQ.setOnFocusChangeListener(this);
        this.bIQ.setOnKeyListener(this);
        this.bIQ.requestFocus();
        this.bHG.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aab;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aab = a.this.aab()) >= 0 && aab + 1 == a.this.bHV.getItemCount()) {
                    a.this.aad();
                }
            }
        });
        this.bIQ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.bIQ, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.bIV == null) {
            this.bIV = (InputMethodManager) com.baidu.swan.apps.w.e.LD().Lp().getApplicationContext().getSystemService("input_method");
        }
        if (this.bIV != null) {
            if (z) {
                this.bIV.showSoftInput(view, 0);
            } else {
                this.bIV.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aab() {
        if (this.bIT != null) {
            return this.bIT.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aab = aab();
        if (aab == -1) {
            return null;
        }
        return this.bIT.findViewByPosition(aab);
    }

    private void aac() {
        if (!TextUtils.isEmpty(this.bIX)) {
            this.apR = 0;
            kQ(this.bIX);
            d(this.bIQ, false);
        }
    }

    private void kQ(String str) {
        this.bIU.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bIZ).keyword(str).pageCapacity(13).pageNum(this.apR));
    }

    public void aad() {
        if (!this.mIsLoading) {
            if (this.apR < this.bIW) {
                kQ(this.bIX);
                this.mIsLoading = true;
                return;
            }
            aae();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bIq != null && gVar.bIq.location != null) {
            PoiInfo poiInfo = gVar.bIq;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        T(intent);
        ZP();
    }

    private void T(Intent intent) {
        if (abU() != null) {
            abU().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.bIY) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.bIW = poiResult.getTotalPageNum();
                if (this.apR == 0) {
                    this.bHT.clear();
                }
                this.bHT.addAll(g.ae(poiResult.getAllPoi()));
                this.bHV.b(this.bHT, this.bIX);
                this.apR++;
            } else {
                if (this.apR == 0) {
                    this.bIW = 0;
                    this.bHT.clear();
                    this.bHV.setData(this.bHT);
                }
                aae();
            }
            if (this.apR == 0 && this.bHT.size() == 0) {
                z = true;
            }
            dv(z);
            if (this.bHT.size() <= 0) {
                aae();
            }
        }
    }

    private void aae() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bHG.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).dt(false);
            }
        }
    }

    public void dv(boolean z) {
        this.bIR.setVisibility(z ? 0 : 8);
    }

    private void ZP() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bIU.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bHT.clear();
            this.bHV.setData(this.bHT);
            this.bIX = "";
            this.apR = 0;
            this.bIW = 0;
            this.bIY = true;
            return;
        }
        this.bIY = false;
        this.apR = 0;
        this.bIW = 0;
        this.bIX = editable.toString();
        kQ(this.bIX);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.bIQ, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            ZP();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aac();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.bIQ, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return false;
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
