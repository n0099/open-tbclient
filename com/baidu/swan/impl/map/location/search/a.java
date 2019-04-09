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
    private RecyclerView bhE;
    private List<g> bhR;
    private com.baidu.swan.impl.map.location.b bhT;
    private EditText biQ;
    private View biR;
    private TextView biS;
    private LinearLayoutManager biT;
    private InputMethodManager biV;
    private String biY;
    private boolean biZ;
    private boolean mIsLoading;
    private PoiSearch biU = null;
    private int biW = 0;
    private int biX = 0;
    private String bja = "北京";

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
            uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqO, com.baidu.swan.apps.core.c.e.aqQ).b(this).yZ();
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
        this.bhR = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bja = string;
        }
        this.biQ = (EditText) view.findViewById(d.g.search_text);
        this.bhE = (RecyclerView) view.findViewById(d.g.location_list);
        this.biR = view.findViewById(d.g.no_result_tip);
        this.biS = (TextView) view.findViewById(d.g.cancel_search);
        this.biT = new LinearLayoutManager(com.baidu.swan.apps.w.e.Ea().DM());
        this.bhE.setLayoutManager(this.biT);
        this.bhT = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.Ea().DM(), this.bhE, this);
        this.bhE.setAdapter(this.bhT);
        this.bhE.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ea().DM()));
        this.bhE.setOnTouchListener(this);
        this.biS.setOnClickListener(this);
        this.biU = PoiSearch.newInstance();
        this.biU.setOnGetPoiSearchResultListener(this);
        this.biQ.addTextChangedListener(this);
        this.biQ.setOnFocusChangeListener(this);
        this.biQ.setOnKeyListener(this);
        this.biQ.requestFocus();
        this.bhE.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int QE;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (QE = a.this.QE()) >= 0 && QE + 1 == a.this.bhT.getItemCount()) {
                    a.this.QG();
                }
            }
        });
        this.biQ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.biQ, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.biV == null) {
            this.biV = (InputMethodManager) com.baidu.swan.apps.w.e.Ea().DM().getApplicationContext().getSystemService("input_method");
        }
        if (this.biV != null) {
            if (z) {
                this.biV.showSoftInput(view, 0);
            } else {
                this.biV.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QE() {
        if (this.biT != null) {
            return this.biT.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int QE = QE();
        if (QE == -1) {
            return null;
        }
        return this.biT.findViewByPosition(QE);
    }

    private void QF() {
        if (!TextUtils.isEmpty(this.biY)) {
            this.biW = 0;
            jg(this.biY);
            d(this.biQ, false);
        }
    }

    private void jg(String str) {
        this.biU.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bja).keyword(str).pageCapacity(13).pageNum(this.biW));
    }

    public void QG() {
        if (!this.mIsLoading) {
            if (this.biW < this.biX) {
                jg(this.biY);
                this.mIsLoading = true;
                return;
            }
            QH();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.biq != null && gVar.biq.location != null) {
            PoiInfo poiInfo = gVar.biq;
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
        if (!this.biZ) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.biX = poiResult.getTotalPageNum();
                if (this.biW == 0) {
                    this.bhR.clear();
                }
                this.bhR.addAll(g.E(poiResult.getAllPoi()));
                this.bhT.b(this.bhR, this.biY);
                this.biW++;
            } else {
                if (this.biW == 0) {
                    this.biX = 0;
                    this.bhR.clear();
                    this.bhT.setData(this.bhR);
                }
                QH();
            }
            if (this.biW == 0 && this.bhR.size() == 0) {
                z = true;
            }
            cK(z);
            if (this.bhR.size() <= 0) {
                QH();
            }
        }
    }

    private void QH() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bhE.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof com.baidu.swan.impl.map.location.d) {
                ((com.baidu.swan.impl.map.location.d) childViewHolder).cI(false);
            }
        }
    }

    public void cK(boolean z) {
        this.biR.setVisibility(z ? 0 : 8);
    }

    private void Qs() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.biU.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bhR.clear();
            this.bhT.setData(this.bhR);
            this.biY = "";
            this.biW = 0;
            this.biX = 0;
            this.biZ = true;
            return;
        }
        this.biZ = false;
        this.biW = 0;
        this.biX = 0;
        this.biY = editable.toString();
        jg(this.biY);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.biQ, false);
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
        d(this.biQ, z);
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
