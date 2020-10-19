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
    private List<g> dPI;
    private b dPK;
    private RecyclerView dPv;
    private EditText dQF;
    private View dQG;
    private TextView dQH;
    private LinearLayoutManager dQI;
    private String dQL;
    private boolean dQM;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dQJ = null;
    private int mCurrentIndex = 0;
    private int dQK = 0;
    private String dQN = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aVg() {
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            abs.mt("navigateTo").ak(f.cwD, f.cwF).f(this).akS();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aUI();
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
        this.dPI = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dQN = string;
        }
        this.dQF = (EditText) view.findViewById(R.id.search_text);
        this.dPv = (RecyclerView) view.findViewById(R.id.location_list);
        this.dQG = view.findViewById(R.id.no_result_tip);
        this.dQH = (TextView) view.findViewById(R.id.cancel_search);
        this.dQI = new LinearLayoutManager(com.baidu.swan.apps.v.f.avu().ave());
        this.dPv.setLayoutManager(this.dQI);
        this.dPK = new b(com.baidu.swan.apps.v.f.avu().ave(), this.dPv, this);
        this.dPv.setAdapter(this.dPK);
        this.dPv.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.avu().ave()));
        this.dPv.setOnTouchListener(this);
        this.dQH.setOnClickListener(this);
        this.dQJ = PoiSearch.newInstance();
        this.dQJ.setOnGetPoiSearchResultListener(this);
        this.dQF.addTextChangedListener(this);
        this.dQF.setOnFocusChangeListener(this);
        this.dQF.setOnKeyListener(this);
        this.dQF.requestFocus();
        this.dPv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aVE;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aVE = a.this.aVE()) >= 0 && aVE + 1 == a.this.dPK.getItemCount()) {
                    a.this.aVG();
                }
            }
        });
        this.dQF.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(a.this.dQF, true);
            }
        }, 100L);
    }

    public void c(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.avu().ave().getApplicationContext().getSystemService("input_method");
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
    public int aVE() {
        if (this.dQI != null) {
            return this.dQI.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aVE = aVE();
        if (aVE == -1) {
            return null;
        }
        return this.dQI.findViewByPosition(aVE);
    }

    private void aVF() {
        if (!TextUtils.isEmpty(this.dQL)) {
            this.mCurrentIndex = 0;
            xA(this.dQL);
            c(this.dQF, false);
        }
    }

    private void xA(String str) {
        this.dQJ.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dQN).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aVG() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dQK) {
                xA(this.dQL);
                this.mIsLoading = true;
                return;
            }
            aVH();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dQf != null && gVar.dQf.location != null) {
            PoiInfo poiInfo = gVar.dQf;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aVt();
    }

    private void A(Intent intent) {
        if (aYn() != null) {
            aYn().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dQM) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dQK = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dPI.clear();
                }
                this.dPI.addAll(g.aD(poiResult.getAllPoi()));
                this.dPK.b(this.dPI, this.dQL);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dQK = 0;
                    this.dPI.clear();
                    this.dPK.setData(this.dPI);
                }
                aVH();
            }
            if (this.mCurrentIndex == 0 && this.dPI.size() == 0) {
                z = true;
            }
            hs(z);
            if (this.dPI.size() <= 0) {
                aVH();
            }
        }
    }

    private void aVH() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dPv.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void hs(boolean z) {
        this.dQG.setVisibility(z ? 0 : 8);
    }

    private void aVt() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dQJ.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dPI.clear();
            this.dPK.setData(this.dPI);
            this.dQL = "";
            this.mCurrentIndex = 0;
            this.dQK = 0;
            this.dQM = true;
            return;
        }
        this.dQM = false;
        this.mCurrentIndex = 0;
        this.dQK = 0;
        this.dQL = editable.toString();
        xA(this.dQL);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        c(this.dQF, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aVt();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aVF();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        c(this.dQF, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
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
