package com.baidu.swan.impl.map.location.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.swan.impl.map.location.LocationDetailAdapter;
import com.baidu.swan.impl.map.location.LocationFooterViewHolder;
import com.baidu.swan.impl.map.location.LocationItemDecoration;
import com.baidu.swan.impl.map.location.b;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, b {
    private TextView bZE;
    private RecyclerView erb;
    private List<com.baidu.swan.impl.map.location.c> ern;
    private LocationDetailAdapter erp;
    private EditText esm;
    private View esn;
    private LinearLayoutManager eso;
    private String esr;
    private boolean ess;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch esp = null;
    private int bMV = 0;
    private int esq = 0;
    private String est = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void baN() {
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null) {
            aga.mJ("navigateTo").af(f.cTZ, f.cUb).f(this).apL();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bap();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (aoL()) {
            inflate = av(inflate);
            gK(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.ern = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.est = string;
        }
        this.esm = (EditText) view.findViewById(R.id.search_text);
        this.erb = (RecyclerView) view.findViewById(R.id.location_list);
        this.esn = view.findViewById(R.id.no_result_tip);
        this.bZE = (TextView) view.findViewById(R.id.cancel_search);
        this.eso = new LinearLayoutManager(com.baidu.swan.apps.v.f.aAo().azY());
        this.erb.setLayoutManager(this.eso);
        this.erp = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aAo().azY(), this.erb, this);
        this.erb.setAdapter(this.erp);
        this.erb.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aAo().azY()));
        this.erb.setOnTouchListener(this);
        this.bZE.setOnClickListener(this);
        this.esp = PoiSearch.newInstance();
        this.esp.setOnGetPoiSearchResultListener(this);
        this.esm.addTextChangedListener(this);
        this.esm.setOnFocusChangeListener(this);
        this.esm.setOnKeyListener(this);
        this.esm.requestFocus();
        this.erb.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int bbl;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (bbl = a.this.bbl()) >= 0 && bbl + 1 == a.this.erp.getItemCount()) {
                    a.this.bbn();
                }
            }
        });
        this.esm.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.esm, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.aAo().azY().getApplicationContext().getSystemService("input_method");
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
    public int bbl() {
        if (this.eso != null) {
            return this.eso.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int bbl = bbl();
        if (bbl == -1) {
            return null;
        }
        return this.eso.findViewByPosition(bbl);
    }

    private void bbm() {
        if (!TextUtils.isEmpty(this.esr)) {
            this.bMV = 0;
            xX(this.esr);
            d(this.esm, false);
        }
    }

    private void xX(String str) {
        this.esp.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.est).keyword(str).pageCapacity(13).pageNum(this.bMV));
    }

    public void bbn() {
        if (!this.mIsLoading) {
            if (this.bMV < this.esq) {
                xX(this.esr);
                this.mIsLoading = true;
                return;
            }
            bbo();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(com.baidu.swan.impl.map.location.c cVar) {
        Intent intent = new Intent();
        if (cVar.erM != null && cVar.erM.location != null) {
            PoiInfo poiInfo = cVar.erM;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        B(intent);
        bba();
    }

    private void B(Intent intent) {
        if (bdV() != null) {
            bdV().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.ess) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.esq = poiResult.getTotalPageNum();
                if (this.bMV == 0) {
                    this.ern.clear();
                }
                this.ern.addAll(com.baidu.swan.impl.map.location.c.aZ(poiResult.getAllPoi()));
                this.erp.setData(this.ern, this.esr);
                this.bMV++;
            } else {
                if (this.bMV == 0) {
                    this.esq = 0;
                    this.ern.clear();
                    this.erp.setData(this.ern);
                }
                bbo();
            }
            if (this.bMV == 0 && this.ern.size() == 0) {
                z = true;
            }
            ix(z);
            if (this.ern.size() <= 0) {
                bbo();
            }
        }
    }

    private void bbo() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.erb.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof LocationFooterViewHolder) {
                ((LocationFooterViewHolder) childViewHolder).iv(false);
            }
        }
    }

    public void ix(boolean z) {
        this.esn.setVisibility(z ? 0 : 8);
    }

    private void bba() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.esp.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.ern.clear();
            this.erp.setData(this.ern);
            this.esr = "";
            this.bMV = 0;
            this.esq = 0;
            this.ess = true;
            return;
        }
        this.ess = false;
        this.bMV = 0;
        this.esq = 0;
        this.esr = editable.toString();
        xX(this.esr);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.esm, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            bba();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            bbm();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.esm, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
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
