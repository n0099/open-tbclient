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
    private List<g> drB;
    private b drD;
    private RecyclerView drn;
    private View dsA;
    private TextView dsB;
    private LinearLayoutManager dsC;
    private String dsF;
    private boolean dsG;
    private EditText dsz;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dsD = null;
    private int mCurrentIndex = 0;
    private int dsE = 0;
    private String dsH = "北京";

    public static a ac(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aIV() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            Sc.jO("navigateTo").ag(f.cci, f.cck).f(this).abl();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aIx();
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
        this.drB = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dsH = string;
        }
        this.dsz = (EditText) view.findViewById(R.id.search_text);
        this.drn = (RecyclerView) view.findViewById(R.id.location_list);
        this.dsA = view.findViewById(R.id.no_result_tip);
        this.dsB = (TextView) view.findViewById(R.id.cancel_search);
        this.dsC = new LinearLayoutManager(com.baidu.swan.apps.v.f.akr().akb());
        this.drn.setLayoutManager(this.dsC);
        this.drD = new b(com.baidu.swan.apps.v.f.akr().akb(), this.drn, this);
        this.drn.setAdapter(this.drD);
        this.drn.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.akr().akb()));
        this.drn.setOnTouchListener(this);
        this.dsB.setOnClickListener(this);
        this.dsD = PoiSearch.newInstance();
        this.dsD.setOnGetPoiSearchResultListener(this);
        this.dsz.addTextChangedListener(this);
        this.dsz.setOnFocusChangeListener(this);
        this.dsz.setOnKeyListener(this);
        this.dsz.requestFocus();
        this.drn.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aJt;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aJt = a.this.aJt()) >= 0 && aJt + 1 == a.this.drD.getItemCount()) {
                    a.this.aJv();
                }
            }
        });
        this.dsz.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.dsz, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.akr().akb().getApplicationContext().getSystemService("input_method");
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
    public int aJt() {
        if (this.dsC != null) {
            return this.dsC.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aJt = aJt();
        if (aJt == -1) {
            return null;
        }
        return this.dsC.findViewByPosition(aJt);
    }

    private void aJu() {
        if (!TextUtils.isEmpty(this.dsF)) {
            this.mCurrentIndex = 0;
            ue(this.dsF);
            d(this.dsz, false);
        }
    }

    private void ue(String str) {
        this.dsD.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dsH).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aJv() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dsE) {
                ue(this.dsF);
                this.mIsLoading = true;
                return;
            }
            aJw();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.drY != null && gVar.drY.location != null) {
            PoiInfo poiInfo = gVar.drY;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        y(intent);
        aJi();
    }

    private void y(Intent intent) {
        if (aMs() != null) {
            aMs().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dsG) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dsE = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.drB.clear();
                }
                this.drB.addAll(g.av(poiResult.getAllPoi()));
                this.drD.b(this.drB, this.dsF);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dsE = 0;
                    this.drB.clear();
                    this.drD.setData(this.drB);
                }
                aJw();
            }
            if (this.mCurrentIndex == 0 && this.drB.size() == 0) {
                z = true;
            }
            gB(z);
            if (this.drB.size() <= 0) {
                aJw();
            }
        }
    }

    private void aJw() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.drn.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void gB(boolean z) {
        this.dsA.setVisibility(z ? 0 : 8);
    }

    private void aJi() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dsD.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.drB.clear();
            this.drD.setData(this.drB);
            this.dsF = "";
            this.mCurrentIndex = 0;
            this.dsE = 0;
            this.dsG = true;
            return;
        }
        this.dsG = false;
        this.mCurrentIndex = 0;
        this.dsE = 0;
        this.dsF = editable.toString();
        ue(this.dsF);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.dsz, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aJi();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aJu();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.dsz, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
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
