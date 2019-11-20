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
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.f;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private RecyclerView bGP;
    private EditText bHZ;
    private List<g> bHc;
    private com.baidu.swan.impl.map.location.b bHe;
    private View bIa;
    private TextView bIb;
    private LinearLayoutManager bIc;
    private InputMethodManager bIe;
    private String bIg;
    private boolean bIh;
    private boolean mIsLoading;
    private PoiSearch bId = null;
    private int apz = 0;
    private int bIf = 0;
    private String bIi = "北京";

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void ZB() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null) {
            AI.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).c(this).FD();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Zg();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (EJ()) {
            inflate = Y(inflate);
            da(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bHc = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bIi = string;
        }
        this.bHZ = (EditText) view.findViewById(R.id.search_text);
        this.bGP = (RecyclerView) view.findViewById(R.id.location_list);
        this.bIa = view.findViewById(R.id.no_result_tip);
        this.bIb = (TextView) view.findViewById(R.id.cancel_search);
        this.bIc = new LinearLayoutManager(com.baidu.swan.apps.w.e.LE().Lq());
        this.bGP.setLayoutManager(this.bIc);
        this.bHe = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.LE().Lq(), this.bGP, this);
        this.bGP.setAdapter(this.bHe);
        this.bGP.addItemDecoration(new f(com.baidu.swan.apps.w.e.LE().Lq()));
        this.bGP.setOnTouchListener(this);
        this.bIb.setOnClickListener(this);
        this.bId = PoiSearch.newInstance();
        this.bId.setOnGetPoiSearchResultListener(this);
        this.bHZ.addTextChangedListener(this);
        this.bHZ.setOnFocusChangeListener(this);
        this.bHZ.setOnKeyListener(this);
        this.bHZ.requestFocus();
        this.bGP.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int ZZ;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (ZZ = a.this.ZZ()) >= 0 && ZZ + 1 == a.this.bHe.getItemCount()) {
                    a.this.aab();
                }
            }
        });
        this.bHZ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.bHZ, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.bIe == null) {
            this.bIe = (InputMethodManager) com.baidu.swan.apps.w.e.LE().Lq().getApplicationContext().getSystemService("input_method");
        }
        if (this.bIe != null) {
            if (z) {
                this.bIe.showSoftInput(view, 0);
            } else {
                this.bIe.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ZZ() {
        if (this.bIc != null) {
            return this.bIc.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int ZZ = ZZ();
        if (ZZ == -1) {
            return null;
        }
        return this.bIc.findViewByPosition(ZZ);
    }

    private void aaa() {
        if (!TextUtils.isEmpty(this.bIg)) {
            this.apz = 0;
            kQ(this.bIg);
            d(this.bHZ, false);
        }
    }

    private void kQ(String str) {
        this.bId.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bIi).keyword(str).pageCapacity(13).pageNum(this.apz));
    }

    public void aab() {
        if (!this.mIsLoading) {
            if (this.apz < this.bIf) {
                kQ(this.bIg);
                this.mIsLoading = true;
                return;
            }
            aac();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bHz != null && gVar.bHz.location != null) {
            PoiInfo poiInfo = gVar.bHz;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        T(intent);
        ZN();
    }

    private void T(Intent intent) {
        if (abS() != null) {
            abS().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.bIh) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.bIf = poiResult.getTotalPageNum();
                if (this.apz == 0) {
                    this.bHc.clear();
                }
                this.bHc.addAll(g.ae(poiResult.getAllPoi()));
                this.bHe.b(this.bHc, this.bIg);
                this.apz++;
            } else {
                if (this.apz == 0) {
                    this.bIf = 0;
                    this.bHc.clear();
                    this.bHe.setData(this.bHc);
                }
                aac();
            }
            if (this.apz == 0 && this.bHc.size() == 0) {
                z = true;
            }
            dv(z);
            if (this.bHc.size() <= 0) {
                aac();
            }
        }
    }

    private void aac() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bGP.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).dt(false);
            }
        }
    }

    public void dv(boolean z) {
        this.bIa.setVisibility(z ? 0 : 8);
    }

    private void ZN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bId.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bHc.clear();
            this.bHe.setData(this.bHc);
            this.bIg = "";
            this.apz = 0;
            this.bIf = 0;
            this.bIh = true;
            return;
        }
        this.bIh = false;
        this.apz = 0;
        this.bIf = 0;
        this.bIg = editable.toString();
        kQ(this.bIg);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.bHZ, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            ZN();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aaa();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.bHZ, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return false;
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
