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
/* loaded from: classes9.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, b {
    private TextView bYR;
    private RecyclerView esg;
    private List<com.baidu.swan.impl.map.location.c> est;
    private LocationDetailAdapter esv;
    private EditText ets;
    private View ett;
    private LinearLayoutManager etu;
    private String etx;
    private boolean ety;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch etv = null;
    private int bMx = 0;
    private int etw = 0;
    private String etz = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void beq() {
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs != null) {
            ajs.nv("navigateTo").ai(f.cUY, f.cVa).f(this).ate();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bdS();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (ase()) {
            inflate = az(inflate);
            im(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.est = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.etz = string;
        }
        this.ets = (EditText) view.findViewById(R.id.search_text);
        this.esg = (RecyclerView) view.findViewById(R.id.location_list);
        this.ett = view.findViewById(R.id.no_result_tip);
        this.bYR = (TextView) view.findViewById(R.id.cancel_search);
        this.etu = new LinearLayoutManager(com.baidu.swan.apps.v.f.aDG().aDq());
        this.esg.setLayoutManager(this.etu);
        this.esv = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aDG().aDq(), this.esg, this);
        this.esg.setAdapter(this.esv);
        this.esg.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aDG().aDq()));
        this.esg.setOnTouchListener(this);
        this.bYR.setOnClickListener(this);
        this.etv = PoiSearch.newInstance();
        this.etv.setOnGetPoiSearchResultListener(this);
        this.ets.addTextChangedListener(this);
        this.ets.setOnFocusChangeListener(this);
        this.ets.setOnKeyListener(this);
        this.ets.requestFocus();
        this.esg.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int beP;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (beP = a.this.beP()) >= 0 && beP + 1 == a.this.esv.getItemCount()) {
                    a.this.beR();
                }
            }
        });
        this.ets.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.ets, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.aDG().aDq().getApplicationContext().getSystemService("input_method");
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
    public int beP() {
        if (this.etu != null) {
            return this.etu.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int beP = beP();
        if (beP == -1) {
            return null;
        }
        return this.etu.findViewByPosition(beP);
    }

    private void beQ() {
        if (!TextUtils.isEmpty(this.etx)) {
            this.bMx = 0;
            yI(this.etx);
            d(this.ets, false);
        }
    }

    private void yI(String str) {
        this.etv.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.etz).keyword(str).pageCapacity(13).pageNum(this.bMx));
    }

    public void beR() {
        if (!this.mIsLoading) {
            if (this.bMx < this.etw) {
                yI(this.etx);
                this.mIsLoading = true;
                return;
            }
            beS();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(com.baidu.swan.impl.map.location.c cVar) {
        Intent intent = new Intent();
        if (cVar.esR != null && cVar.esR.location != null) {
            PoiInfo poiInfo = cVar.esR;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        B(intent);
        beD();
    }

    private void B(Intent intent) {
        if (bhz() != null) {
            bhz().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.ety) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.etw = poiResult.getTotalPageNum();
                if (this.bMx == 0) {
                    this.est.clear();
                }
                this.est.addAll(com.baidu.swan.impl.map.location.c.be(poiResult.getAllPoi()));
                this.esv.c(this.est, this.etx);
                this.bMx++;
            } else {
                if (this.bMx == 0) {
                    this.etw = 0;
                    this.est.clear();
                    this.esv.setData(this.est);
                }
                beS();
            }
            if (this.bMx == 0 && this.est.size() == 0) {
                z = true;
            }
            iz(z);
            if (this.est.size() <= 0) {
                beS();
            }
        }
    }

    private void beS() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.esg.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof LocationFooterViewHolder) {
                ((LocationFooterViewHolder) childViewHolder).ix(false);
            }
        }
    }

    public void iz(boolean z) {
        this.ett.setVisibility(z ? 0 : 8);
    }

    private void beD() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.etv.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.est.clear();
            this.esv.setData(this.est);
            this.etx = "";
            this.bMx = 0;
            this.etw = 0;
            this.ety = true;
            return;
        }
        this.ety = false;
        this.bMx = 0;
        this.etw = 0;
        this.etx = editable.toString();
        yI(this.etx);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.ets, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            beD();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            beQ();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.ets, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean arC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aml() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amS() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arB() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amM() {
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
