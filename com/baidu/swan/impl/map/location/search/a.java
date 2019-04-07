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
import com.baidu.swan.apps.core.c.b;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.f;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private RecyclerView bhD;
    private List<g> bhQ;
    private com.baidu.swan.impl.map.location.b bhS;
    private EditText biP;
    private View biQ;
    private TextView biR;
    private LinearLayoutManager biS;
    private InputMethodManager biU;
    private String biX;
    private boolean biY;
    private boolean mIsLoading;
    private PoiSearch biT = null;
    private int biV = 0;
    private int biW = 0;
    private String biZ = "北京";

    public static a B(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void Qg() {
        com.baidu.swan.apps.core.c.e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy != null) {
            uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqN, com.baidu.swan.apps.core.c.e.aqP).b(this).yZ();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.PL();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(d.h.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (yi()) {
            inflate = Q(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bhQ = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.biZ = string;
        }
        this.biP = (EditText) view.findViewById(d.g.search_text);
        this.bhD = (RecyclerView) view.findViewById(d.g.location_list);
        this.biQ = view.findViewById(d.g.no_result_tip);
        this.biR = (TextView) view.findViewById(d.g.cancel_search);
        this.biS = new LinearLayoutManager(com.baidu.swan.apps.w.e.Ea().DM());
        this.bhD.setLayoutManager(this.biS);
        this.bhS = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.Ea().DM(), this.bhD, this);
        this.bhD.setAdapter(this.bhS);
        this.bhD.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ea().DM()));
        this.bhD.setOnTouchListener(this);
        this.biR.setOnClickListener(this);
        this.biT = PoiSearch.newInstance();
        this.biT.setOnGetPoiSearchResultListener(this);
        this.biP.addTextChangedListener(this);
        this.biP.setOnFocusChangeListener(this);
        this.biP.setOnKeyListener(this);
        this.biP.requestFocus();
        this.bhD.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int QE;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (QE = a.this.QE()) >= 0 && QE + 1 == a.this.bhS.getItemCount()) {
                    a.this.QG();
                }
            }
        });
        this.biP.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.biP, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.biU == null) {
            this.biU = (InputMethodManager) com.baidu.swan.apps.w.e.Ea().DM().getApplicationContext().getSystemService("input_method");
        }
        if (this.biU != null) {
            if (z) {
                this.biU.showSoftInput(view, 0);
            } else {
                this.biU.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QE() {
        if (this.biS != null) {
            return this.biS.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int QE = QE();
        if (QE == -1) {
            return null;
        }
        return this.biS.findViewByPosition(QE);
    }

    private void QF() {
        if (!TextUtils.isEmpty(this.biX)) {
            this.biV = 0;
            jg(this.biX);
            d(this.biP, false);
        }
    }

    private void jg(String str) {
        this.biT.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.biZ).keyword(str).pageCapacity(13).pageNum(this.biV));
    }

    public void QG() {
        if (!this.mIsLoading) {
            if (this.biV < this.biW) {
                jg(this.biX);
                this.mIsLoading = true;
                return;
            }
            QH();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bip != null && gVar.bip.location != null) {
            PoiInfo poiInfo = gVar.bip;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        N(intent);
        Qs();
    }

    private void N(Intent intent) {
        if (Sv() != null) {
            Sv().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.biY) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.biW = poiResult.getTotalPageNum();
                if (this.biV == 0) {
                    this.bhQ.clear();
                }
                this.bhQ.addAll(g.E(poiResult.getAllPoi()));
                this.bhS.b(this.bhQ, this.biX);
                this.biV++;
            } else {
                if (this.biV == 0) {
                    this.biW = 0;
                    this.bhQ.clear();
                    this.bhS.setData(this.bhQ);
                }
                QH();
            }
            if (this.biV == 0 && this.bhQ.size() == 0) {
                z = true;
            }
            cK(z);
            if (this.bhQ.size() <= 0) {
                QH();
            }
        }
    }

    private void QH() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bhD.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof com.baidu.swan.impl.map.location.d) {
                ((com.baidu.swan.impl.map.location.d) childViewHolder).cI(false);
            }
        }
    }

    public void cK(boolean z) {
        this.biQ.setVisibility(z ? 0 : 8);
    }

    private void Qs() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.biT.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bhQ.clear();
            this.bhS.setData(this.bhQ);
            this.biX = "";
            this.biV = 0;
            this.biW = 0;
            this.biY = true;
            return;
        }
        this.biY = false;
        this.biV = 0;
        this.biW = 0;
        this.biX = editable.toString();
        jg(this.biX);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.biP, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.cancel_search) {
            Qs();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            QF();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.biP, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
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
