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
/* loaded from: classes19.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private List<g> dBG;
    private b dBI;
    private RecyclerView dBt;
    private EditText dCD;
    private View dCE;
    private TextView dCF;
    private LinearLayoutManager dCG;
    private String dCJ;
    private boolean dCK;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dCH = null;
    private int mCurrentIndex = 0;
    private int dCI = 0;
    private String dCL = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aRL() {
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            XX.lo("navigateTo").al(f.cik, f.cim).f(this).ahx();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aRn();
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
        this.dBG = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dCL = string;
        }
        this.dCD = (EditText) view.findViewById(R.id.search_text);
        this.dBt = (RecyclerView) view.findViewById(R.id.location_list);
        this.dCE = view.findViewById(R.id.no_result_tip);
        this.dCF = (TextView) view.findViewById(R.id.cancel_search);
        this.dCG = new LinearLayoutManager(com.baidu.swan.apps.v.f.arY().arI());
        this.dBt.setLayoutManager(this.dCG);
        this.dBI = new b(com.baidu.swan.apps.v.f.arY().arI(), this.dBt, this);
        this.dBt.setAdapter(this.dBI);
        this.dBt.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.arY().arI()));
        this.dBt.setOnTouchListener(this);
        this.dCF.setOnClickListener(this);
        this.dCH = PoiSearch.newInstance();
        this.dCH.setOnGetPoiSearchResultListener(this);
        this.dCD.addTextChangedListener(this);
        this.dCD.setOnFocusChangeListener(this);
        this.dCD.setOnKeyListener(this);
        this.dCD.requestFocus();
        this.dBt.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aSj;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aSj = a.this.aSj()) >= 0 && aSj + 1 == a.this.dBI.getItemCount()) {
                    a.this.aSl();
                }
            }
        });
        this.dCD.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(a.this.dCD, true);
            }
        }, 100L);
    }

    public void c(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.arY().arI().getApplicationContext().getSystemService("input_method");
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
    public int aSj() {
        if (this.dCG != null) {
            return this.dCG.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aSj = aSj();
        if (aSj == -1) {
            return null;
        }
        return this.dCG.findViewByPosition(aSj);
    }

    private void aSk() {
        if (!TextUtils.isEmpty(this.dCJ)) {
            this.mCurrentIndex = 0;
            wv(this.dCJ);
            c(this.dCD, false);
        }
    }

    private void wv(String str) {
        this.dCH.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dCL).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aSl() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dCI) {
                wv(this.dCJ);
                this.mIsLoading = true;
                return;
            }
            aSm();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dCd != null && gVar.dCd.location != null) {
            PoiInfo poiInfo = gVar.dCd;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aRY();
    }

    private void A(Intent intent) {
        if (aUS() != null) {
            aUS().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dCK) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dCI = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dBG.clear();
                }
                this.dBG.addAll(g.aw(poiResult.getAllPoi()));
                this.dBI.b(this.dBG, this.dCJ);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dCI = 0;
                    this.dBG.clear();
                    this.dBI.setData(this.dBG);
                }
                aSm();
            }
            if (this.mCurrentIndex == 0 && this.dBG.size() == 0) {
                z = true;
            }
            gY(z);
            if (this.dBG.size() <= 0) {
                aSm();
            }
        }
    }

    private void aSm() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dBt.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void gY(boolean z) {
        this.dCE.setVisibility(z ? 0 : 8);
    }

    private void aRY() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dCH.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dBG.clear();
            this.dBI.setData(this.dBG);
            this.dCJ = "";
            this.mCurrentIndex = 0;
            this.dCI = 0;
            this.dCK = true;
            return;
        }
        this.dCK = false;
        this.mCurrentIndex = 0;
        this.dCI = 0;
        this.dCJ = editable.toString();
        wv(this.dCJ);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        c(this.dCD, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aRY();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aSk();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        c(this.dCD, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
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
