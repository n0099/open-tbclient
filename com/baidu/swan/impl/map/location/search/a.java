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
/* loaded from: classes24.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private List<g> dDH;
    private b dDJ;
    private RecyclerView dDu;
    private EditText dEE;
    private View dEF;
    private TextView dEG;
    private LinearLayoutManager dEH;
    private String dEK;
    private boolean dEL;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dEI = null;
    private int mCurrentIndex = 0;
    private int dEJ = 0;
    private String dEM = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aSx() {
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null) {
            YG.lH("navigateTo").al(f.ckl, f.ckn).f(this).aih();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aRZ();
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
        this.dDH = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dEM = string;
        }
        this.dEE = (EditText) view.findViewById(R.id.search_text);
        this.dDu = (RecyclerView) view.findViewById(R.id.location_list);
        this.dEF = view.findViewById(R.id.no_result_tip);
        this.dEG = (TextView) view.findViewById(R.id.cancel_search);
        this.dEH = new LinearLayoutManager(com.baidu.swan.apps.v.f.asJ().ast());
        this.dDu.setLayoutManager(this.dEH);
        this.dDJ = new b(com.baidu.swan.apps.v.f.asJ().ast(), this.dDu, this);
        this.dDu.setAdapter(this.dDJ);
        this.dDu.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.asJ().ast()));
        this.dDu.setOnTouchListener(this);
        this.dEG.setOnClickListener(this);
        this.dEI = PoiSearch.newInstance();
        this.dEI.setOnGetPoiSearchResultListener(this);
        this.dEE.addTextChangedListener(this);
        this.dEE.setOnFocusChangeListener(this);
        this.dEE.setOnKeyListener(this);
        this.dEE.requestFocus();
        this.dDu.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aSV;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aSV = a.this.aSV()) >= 0 && aSV + 1 == a.this.dDJ.getItemCount()) {
                    a.this.aSX();
                }
            }
        });
        this.dEE.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(a.this.dEE, true);
            }
        }, 100L);
    }

    public void c(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.asJ().ast().getApplicationContext().getSystemService("input_method");
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
    public int aSV() {
        if (this.dEH != null) {
            return this.dEH.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aSV = aSV();
        if (aSV == -1) {
            return null;
        }
        return this.dEH.findViewByPosition(aSV);
    }

    private void aSW() {
        if (!TextUtils.isEmpty(this.dEK)) {
            this.mCurrentIndex = 0;
            wO(this.dEK);
            c(this.dEE, false);
        }
    }

    private void wO(String str) {
        this.dEI.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dEM).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aSX() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dEJ) {
                wO(this.dEK);
                this.mIsLoading = true;
                return;
            }
            aSY();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dEe != null && gVar.dEe.location != null) {
            PoiInfo poiInfo = gVar.dEe;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aSK();
    }

    private void A(Intent intent) {
        if (aVE() != null) {
            aVE().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dEL) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dEJ = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dDH.clear();
                }
                this.dDH.addAll(g.aA(poiResult.getAllPoi()));
                this.dDJ.b(this.dDH, this.dEK);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dEJ = 0;
                    this.dDH.clear();
                    this.dDJ.setData(this.dDH);
                }
                aSY();
            }
            if (this.mCurrentIndex == 0 && this.dDH.size() == 0) {
                z = true;
            }
            gW(z);
            if (this.dDH.size() <= 0) {
                aSY();
            }
        }
    }

    private void aSY() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dDu.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void gW(boolean z) {
        this.dEF.setVisibility(z ? 0 : 8);
    }

    private void aSK() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dEI.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dDH.clear();
            this.dDJ.setData(this.dDH);
            this.dEK = "";
            this.mCurrentIndex = 0;
            this.dEJ = 0;
            this.dEL = true;
            return;
        }
        this.dEL = false;
        this.mCurrentIndex = 0;
        this.dEJ = 0;
        this.dEK = editable.toString();
        wO(this.dEK);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        c(this.dEE, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aSK();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aSW();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        c(this.dEE, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
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
