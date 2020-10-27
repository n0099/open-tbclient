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
    private TextView bKf;
    private RecyclerView dXS;
    private List<g> dYf;
    private b dYh;
    private EditText dZc;
    private View dZd;
    private LinearLayoutManager dZe;
    private String dZh;
    private boolean dZi;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dZf = null;
    private int mCurrentIndex = 0;
    private int dZg = 0;
    private String dZj = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aXa() {
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null) {
            adm.mM("navigateTo").al(f.cEZ, f.cFb).f(this).amM();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aWC();
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
        this.dYf = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dZj = string;
        }
        this.dZc = (EditText) view.findViewById(R.id.search_text);
        this.dXS = (RecyclerView) view.findViewById(R.id.location_list);
        this.dZd = view.findViewById(R.id.no_result_tip);
        this.bKf = (TextView) view.findViewById(R.id.cancel_search);
        this.dZe = new LinearLayoutManager(com.baidu.swan.apps.v.f.axo().awY());
        this.dXS.setLayoutManager(this.dZe);
        this.dYh = new b(com.baidu.swan.apps.v.f.axo().awY(), this.dXS, this);
        this.dXS.setAdapter(this.dYh);
        this.dXS.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.axo().awY()));
        this.dXS.setOnTouchListener(this);
        this.bKf.setOnClickListener(this);
        this.dZf = PoiSearch.newInstance();
        this.dZf.setOnGetPoiSearchResultListener(this);
        this.dZc.addTextChangedListener(this);
        this.dZc.setOnFocusChangeListener(this);
        this.dZc.setOnKeyListener(this);
        this.dZc.requestFocus();
        this.dXS.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aXy;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aXy = a.this.aXy()) >= 0 && aXy + 1 == a.this.dYh.getItemCount()) {
                    a.this.aXA();
                }
            }
        });
        this.dZc.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(a.this.dZc, true);
            }
        }, 100L);
    }

    public void c(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.axo().awY().getApplicationContext().getSystemService("input_method");
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
    public int aXy() {
        if (this.dZe != null) {
            return this.dZe.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aXy = aXy();
        if (aXy == -1) {
            return null;
        }
        return this.dZe.findViewByPosition(aXy);
    }

    private void aXz() {
        if (!TextUtils.isEmpty(this.dZh)) {
            this.mCurrentIndex = 0;
            xT(this.dZh);
            c(this.dZc, false);
        }
    }

    private void xT(String str) {
        this.dZf.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dZj).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aXA() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dZg) {
                xT(this.dZh);
                this.mIsLoading = true;
                return;
            }
            aXB();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dYC != null && gVar.dYC.location != null) {
            PoiInfo poiInfo = gVar.dYC;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aXn();
    }

    private void A(Intent intent) {
        if (bag() != null) {
            bag().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dZi) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dZg = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dYf.clear();
                }
                this.dYf.addAll(g.aN(poiResult.getAllPoi()));
                this.dYh.c(this.dYf, this.dZh);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dZg = 0;
                    this.dYf.clear();
                    this.dYh.setData(this.dYf);
                }
                aXB();
            }
            if (this.mCurrentIndex == 0 && this.dYf.size() == 0) {
                z = true;
            }
            hF(z);
            if (this.dYf.size() <= 0) {
                aXB();
            }
        }
    }

    private void aXB() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dXS.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void hF(boolean z) {
        this.dZd.setVisibility(z ? 0 : 8);
    }

    private void aXn() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dZf.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dYf.clear();
            this.dYh.setData(this.dYf);
            this.dZh = "";
            this.mCurrentIndex = 0;
            this.dZg = 0;
            this.dZi = true;
            return;
        }
        this.dZi = false;
        this.mCurrentIndex = 0;
        this.dZg = 0;
        this.dZh = editable.toString();
        xT(this.dZh);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        c(this.dZc, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aXn();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aXz();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        c(this.dZc, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
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
