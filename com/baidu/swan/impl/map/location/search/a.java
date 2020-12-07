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
/* loaded from: classes25.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private TextView bTh;
    private RecyclerView ejc;
    private List<g> ejp;
    private b ejr;
    private EditText ekn;
    private View eko;
    private LinearLayoutManager ekp;
    private String eks;
    private boolean ekt;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch ekq = null;
    private int mCurrentIndex = 0;
    private int ekr = 0;
    private String eku = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void bbY() {
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null) {
            aim.nC("navigateTo").an(f.cQb, f.cQd).f(this).arM();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bbA();
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
        this.ejp = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.eku = string;
        }
        this.ekn = (EditText) view.findViewById(R.id.search_text);
        this.ejc = (RecyclerView) view.findViewById(R.id.location_list);
        this.eko = view.findViewById(R.id.no_result_tip);
        this.bTh = (TextView) view.findViewById(R.id.cancel_search);
        this.ekp = new LinearLayoutManager(com.baidu.swan.apps.v.f.aCp().aBZ());
        this.ejc.setLayoutManager(this.ekp);
        this.ejr = new b(com.baidu.swan.apps.v.f.aCp().aBZ(), this.ejc, this);
        this.ejc.setAdapter(this.ejr);
        this.ejc.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.aCp().aBZ()));
        this.ejc.setOnTouchListener(this);
        this.bTh.setOnClickListener(this);
        this.ekq = PoiSearch.newInstance();
        this.ekq.setOnGetPoiSearchResultListener(this);
        this.ekn.addTextChangedListener(this);
        this.ekn.setOnFocusChangeListener(this);
        this.ekn.setOnKeyListener(this);
        this.ekn.requestFocus();
        this.ejc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int bcw;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (bcw = a.this.bcw()) >= 0 && bcw + 1 == a.this.ejr.getItemCount()) {
                    a.this.bcy();
                }
            }
        });
        this.ekn.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.ekn, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.aCp().aBZ().getApplicationContext().getSystemService("input_method");
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
    public int bcw() {
        if (this.ekp != null) {
            return this.ekp.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int bcw = bcw();
        if (bcw == -1) {
            return null;
        }
        return this.ekp.findViewByPosition(bcw);
    }

    private void bcx() {
        if (!TextUtils.isEmpty(this.eks)) {
            this.mCurrentIndex = 0;
            yJ(this.eks);
            d(this.ekn, false);
        }
    }

    private void yJ(String str) {
        this.ekq.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.eku).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void bcy() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.ekr) {
                yJ(this.eks);
                this.mIsLoading = true;
                return;
            }
            bcz();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.ejN != null && gVar.ejN.location != null) {
            PoiInfo poiInfo = gVar.ejN;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        bcl();
    }

    private void A(Intent intent) {
        if (bfe() != null) {
            bfe().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.ekt) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.ekr = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.ejp.clear();
                }
                this.ejp.addAll(g.aX(poiResult.getAllPoi()));
                this.ejr.c(this.ejp, this.eks);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.ekr = 0;
                    this.ejp.clear();
                    this.ejr.setData(this.ejp);
                }
                bcz();
            }
            if (this.mCurrentIndex == 0 && this.ejp.size() == 0) {
                z = true;
            }
            ig(z);
            if (this.ejp.size() <= 0) {
                bcz();
            }
        }
    }

    private void bcz() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.ejc.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void ig(boolean z) {
        this.eko.setVisibility(z ? 0 : 8);
    }

    private void bcl() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ekq.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.ejp.clear();
            this.ejr.setData(this.ejp);
            this.eks = "";
            this.mCurrentIndex = 0;
            this.ekr = 0;
            this.ekt = true;
            return;
        }
        this.ekt = false;
        this.mCurrentIndex = 0;
        this.ekr = 0;
        this.eks = editable.toString();
        yJ(this.eks);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.ekn, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            bcl();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            bcx();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.ekn, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
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
