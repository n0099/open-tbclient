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
    private List<g> boJ;
    private com.baidu.swan.impl.map.location.b boL;
    private RecyclerView bow;
    private EditText bpG;
    private View bpH;
    private TextView bpI;
    private LinearLayoutManager bpJ;
    private InputMethodManager bpL;
    private String bpO;
    private boolean bpP;
    private boolean mIsLoading;
    private PoiSearch bpK = null;
    private int bpM = 0;
    private int bpN = 0;
    private String bpQ = "北京";

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void UK() {
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null) {
            vJ.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).c(this).AD();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Up();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (zJ()) {
            inflate = S(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.boJ = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bpQ = string;
        }
        this.bpG = (EditText) view.findViewById(R.id.search_text);
        this.bow = (RecyclerView) view.findViewById(R.id.location_list);
        this.bpH = view.findViewById(R.id.no_result_tip);
        this.bpI = (TextView) view.findViewById(R.id.cancel_search);
        this.bpJ = new LinearLayoutManager(com.baidu.swan.apps.w.e.GF().Gr());
        this.bow.setLayoutManager(this.bpJ);
        this.boL = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.GF().Gr(), this.bow, this);
        this.bow.setAdapter(this.boL);
        this.bow.addItemDecoration(new f(com.baidu.swan.apps.w.e.GF().Gr()));
        this.bow.setOnTouchListener(this);
        this.bpI.setOnClickListener(this);
        this.bpK = PoiSearch.newInstance();
        this.bpK.setOnGetPoiSearchResultListener(this);
        this.bpG.addTextChangedListener(this);
        this.bpG.setOnFocusChangeListener(this);
        this.bpG.setOnKeyListener(this);
        this.bpG.requestFocus();
        this.bow.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int Vi;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (Vi = a.this.Vi()) >= 0 && Vi + 1 == a.this.boL.getItemCount()) {
                    a.this.Vk();
                }
            }
        });
        this.bpG.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.bpG, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.bpL == null) {
            this.bpL = (InputMethodManager) com.baidu.swan.apps.w.e.GF().Gr().getApplicationContext().getSystemService("input_method");
        }
        if (this.bpL != null) {
            if (z) {
                this.bpL.showSoftInput(view, 0);
            } else {
                this.bpL.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Vi() {
        if (this.bpJ != null) {
            return this.bpJ.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int Vi = Vi();
        if (Vi == -1) {
            return null;
        }
        return this.bpJ.findViewByPosition(Vi);
    }

    private void Vj() {
        if (!TextUtils.isEmpty(this.bpO)) {
            this.bpM = 0;
            km(this.bpO);
            d(this.bpG, false);
        }
    }

    private void km(String str) {
        this.bpK.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bpQ).keyword(str).pageCapacity(13).pageNum(this.bpM));
    }

    public void Vk() {
        if (!this.mIsLoading) {
            if (this.bpM < this.bpN) {
                km(this.bpO);
                this.mIsLoading = true;
                return;
            }
            Vl();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bpg != null && gVar.bpg.location != null) {
            PoiInfo poiInfo = gVar.bpg;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        N(intent);
        UW();
    }

    private void N(Intent intent) {
        if (Xb() != null) {
            Xb().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.bpP) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.bpN = poiResult.getTotalPageNum();
                if (this.bpM == 0) {
                    this.boJ.clear();
                }
                this.boJ.addAll(g.F(poiResult.getAllPoi()));
                this.boL.b(this.boJ, this.bpO);
                this.bpM++;
            } else {
                if (this.bpM == 0) {
                    this.bpN = 0;
                    this.boJ.clear();
                    this.boL.setData(this.boJ);
                }
                Vl();
            }
            if (this.bpM == 0 && this.boJ.size() == 0) {
                z = true;
            }
            de(z);
            if (this.boJ.size() <= 0) {
                Vl();
            }
        }
    }

    private void Vl() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bow.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).dc(false);
            }
        }
    }

    public void de(boolean z) {
        this.bpH.setVisibility(z ? 0 : 8);
    }

    private void UW() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bpK.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.boJ.clear();
            this.boL.setData(this.boJ);
            this.bpO = "";
            this.bpM = 0;
            this.bpN = 0;
            this.bpP = true;
            return;
        }
        this.bpP = false;
        this.bpM = 0;
        this.bpN = 0;
        this.bpO = editable.toString();
        km(this.bpO);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.bpG, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            UW();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            Vj();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.bpG, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
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
