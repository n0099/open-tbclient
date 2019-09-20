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
    private RecyclerView boU;
    private List<g> bph;
    private com.baidu.swan.impl.map.location.b bpj;
    private EditText bqe;
    private View bqf;
    private TextView bqg;
    private LinearLayoutManager bqh;
    private InputMethodManager bqj;
    private String bqm;
    private boolean bqn;
    private boolean mIsLoading;
    private PoiSearch bqi = null;
    private int bqk = 0;
    private int bql = 0;
    private String bqo = "北京";

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void UO() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null) {
            vN.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).c(this).AH();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Ut();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (zN()) {
            inflate = S(inflate);
            ce(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bph = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bqo = string;
        }
        this.bqe = (EditText) view.findViewById(R.id.search_text);
        this.boU = (RecyclerView) view.findViewById(R.id.location_list);
        this.bqf = view.findViewById(R.id.no_result_tip);
        this.bqg = (TextView) view.findViewById(R.id.cancel_search);
        this.bqh = new LinearLayoutManager(com.baidu.swan.apps.w.e.GJ().Gv());
        this.boU.setLayoutManager(this.bqh);
        this.bpj = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.GJ().Gv(), this.boU, this);
        this.boU.setAdapter(this.bpj);
        this.boU.addItemDecoration(new f(com.baidu.swan.apps.w.e.GJ().Gv()));
        this.boU.setOnTouchListener(this);
        this.bqg.setOnClickListener(this);
        this.bqi = PoiSearch.newInstance();
        this.bqi.setOnGetPoiSearchResultListener(this);
        this.bqe.addTextChangedListener(this);
        this.bqe.setOnFocusChangeListener(this);
        this.bqe.setOnKeyListener(this);
        this.bqe.requestFocus();
        this.boU.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int Vm;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (Vm = a.this.Vm()) >= 0 && Vm + 1 == a.this.bpj.getItemCount()) {
                    a.this.Vo();
                }
            }
        });
        this.bqe.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.bqe, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.bqj == null) {
            this.bqj = (InputMethodManager) com.baidu.swan.apps.w.e.GJ().Gv().getApplicationContext().getSystemService("input_method");
        }
        if (this.bqj != null) {
            if (z) {
                this.bqj.showSoftInput(view, 0);
            } else {
                this.bqj.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Vm() {
        if (this.bqh != null) {
            return this.bqh.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int Vm = Vm();
        if (Vm == -1) {
            return null;
        }
        return this.bqh.findViewByPosition(Vm);
    }

    private void Vn() {
        if (!TextUtils.isEmpty(this.bqm)) {
            this.bqk = 0;
            ko(this.bqm);
            d(this.bqe, false);
        }
    }

    private void ko(String str) {
        this.bqi.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bqo).keyword(str).pageCapacity(13).pageNum(this.bqk));
    }

    public void Vo() {
        if (!this.mIsLoading) {
            if (this.bqk < this.bql) {
                ko(this.bqm);
                this.mIsLoading = true;
                return;
            }
            Vp();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bpE != null && gVar.bpE.location != null) {
            PoiInfo poiInfo = gVar.bpE;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        N(intent);
        Va();
    }

    private void N(Intent intent) {
        if (Xf() != null) {
            Xf().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.bqn) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.bql = poiResult.getTotalPageNum();
                if (this.bqk == 0) {
                    this.bph.clear();
                }
                this.bph.addAll(g.F(poiResult.getAllPoi()));
                this.bpj.b(this.bph, this.bqm);
                this.bqk++;
            } else {
                if (this.bqk == 0) {
                    this.bql = 0;
                    this.bph.clear();
                    this.bpj.setData(this.bph);
                }
                Vp();
            }
            if (this.bqk == 0 && this.bph.size() == 0) {
                z = true;
            }
            de(z);
            if (this.bph.size() <= 0) {
                Vp();
            }
        }
    }

    private void Vp() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.boU.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).dc(false);
            }
        }
    }

    public void de(boolean z) {
        this.bqf.setVisibility(z ? 0 : 8);
    }

    private void Va() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bqi.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bph.clear();
            this.bpj.setData(this.bph);
            this.bqm = "";
            this.bqk = 0;
            this.bql = 0;
            this.bqn = true;
            return;
        }
        this.bqn = false;
        this.bqk = 0;
        this.bql = 0;
        this.bqm = editable.toString();
        ko(this.bqm);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.bqe, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            Va();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            Vn();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.bqe, z);
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
    public boolean zA() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zy() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
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
