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
    private RecyclerView bhA;
    private List<g> bhN;
    private com.baidu.swan.impl.map.location.b bhP;
    private EditText biM;
    private View biN;
    private TextView biO;
    private LinearLayoutManager biP;
    private InputMethodManager biR;
    private String biU;
    private boolean biV;
    private boolean mIsLoading;
    private PoiSearch biQ = null;
    private int biS = 0;
    private int biT = 0;
    private String biW = "北京";

    public static a B(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void Qi() {
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz != null) {
            uz.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqJ, com.baidu.swan.apps.core.c.e.aqL).b(this).za();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.PN();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(d.h.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (yj()) {
            inflate = Q(inflate);
            ce(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bhN = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.biW = string;
        }
        this.biM = (EditText) view.findViewById(d.g.search_text);
        this.bhA = (RecyclerView) view.findViewById(d.g.location_list);
        this.biN = view.findViewById(d.g.no_result_tip);
        this.biO = (TextView) view.findViewById(d.g.cancel_search);
        this.biP = new LinearLayoutManager(com.baidu.swan.apps.w.e.Ec().DO());
        this.bhA.setLayoutManager(this.biP);
        this.bhP = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.Ec().DO(), this.bhA, this);
        this.bhA.setAdapter(this.bhP);
        this.bhA.addItemDecoration(new f(com.baidu.swan.apps.w.e.Ec().DO()));
        this.bhA.setOnTouchListener(this);
        this.biO.setOnClickListener(this);
        this.biQ = PoiSearch.newInstance();
        this.biQ.setOnGetPoiSearchResultListener(this);
        this.biM.addTextChangedListener(this);
        this.biM.setOnFocusChangeListener(this);
        this.biM.setOnKeyListener(this);
        this.biM.requestFocus();
        this.bhA.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int QG;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (QG = a.this.QG()) >= 0 && QG + 1 == a.this.bhP.getItemCount()) {
                    a.this.QI();
                }
            }
        });
        this.biM.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.biM, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.biR == null) {
            this.biR = (InputMethodManager) com.baidu.swan.apps.w.e.Ec().DO().getApplicationContext().getSystemService("input_method");
        }
        if (this.biR != null) {
            if (z) {
                this.biR.showSoftInput(view, 0);
            } else {
                this.biR.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QG() {
        if (this.biP != null) {
            return this.biP.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int QG = QG();
        if (QG == -1) {
            return null;
        }
        return this.biP.findViewByPosition(QG);
    }

    private void QH() {
        if (!TextUtils.isEmpty(this.biU)) {
            this.biS = 0;
            jf(this.biU);
            d(this.biM, false);
        }
    }

    private void jf(String str) {
        this.biQ.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.biW).keyword(str).pageCapacity(13).pageNum(this.biS));
    }

    public void QI() {
        if (!this.mIsLoading) {
            if (this.biS < this.biT) {
                jf(this.biU);
                this.mIsLoading = true;
                return;
            }
            QJ();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bim != null && gVar.bim.location != null) {
            PoiInfo poiInfo = gVar.bim;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        N(intent);
        Qu();
    }

    private void N(Intent intent) {
        if (Sx() != null) {
            Sx().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.biV) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.biT = poiResult.getTotalPageNum();
                if (this.biS == 0) {
                    this.bhN.clear();
                }
                this.bhN.addAll(g.E(poiResult.getAllPoi()));
                this.bhP.b(this.bhN, this.biU);
                this.biS++;
            } else {
                if (this.biS == 0) {
                    this.biT = 0;
                    this.bhN.clear();
                    this.bhP.setData(this.bhN);
                }
                QJ();
            }
            if (this.biS == 0 && this.bhN.size() == 0) {
                z = true;
            }
            cK(z);
            if (this.bhN.size() <= 0) {
                QJ();
            }
        }
    }

    private void QJ() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bhA.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof com.baidu.swan.impl.map.location.d) {
                ((com.baidu.swan.impl.map.location.d) childViewHolder).cI(false);
            }
        }
    }

    public void cK(boolean z) {
        this.biN.setVisibility(z ? 0 : 8);
    }

    private void Qu() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.biQ.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bhN.clear();
            this.bhP.setData(this.bhN);
            this.biU = "";
            this.biS = 0;
            this.biT = 0;
            this.biV = true;
            return;
        }
        this.biV = false;
        this.biS = 0;
        this.biT = 0;
        this.biU = editable.toString();
        jf(this.biU);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.biM, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.cancel_search) {
            Qu();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            QH();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.biM, z);
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
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
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
