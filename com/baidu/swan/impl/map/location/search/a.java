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
    private RecyclerView bnJ;
    private List<g> bnW;
    private com.baidu.swan.impl.map.location.b bnY;
    private EditText boT;
    private View boU;
    private TextView boV;
    private LinearLayoutManager boW;
    private InputMethodManager boY;
    private String bpb;
    private boolean bpc;
    private boolean mIsLoading;
    private PoiSearch boX = null;
    private int boZ = 0;
    private int bpa = 0;
    private String bpd = "北京";

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void TS() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null) {
            vi.dN("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).c(this).zW();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.Tx();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (zc()) {
            inflate = Q(inflate);
            cd(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.bnW = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.bpd = string;
        }
        this.boT = (EditText) view.findViewById(R.id.search_text);
        this.bnJ = (RecyclerView) view.findViewById(R.id.location_list);
        this.boU = view.findViewById(R.id.no_result_tip);
        this.boV = (TextView) view.findViewById(R.id.cancel_search);
        this.boW = new LinearLayoutManager(com.baidu.swan.apps.w.e.FV().FH());
        this.bnJ.setLayoutManager(this.boW);
        this.bnY = new com.baidu.swan.impl.map.location.b(com.baidu.swan.apps.w.e.FV().FH(), this.bnJ, this);
        this.bnJ.setAdapter(this.bnY);
        this.bnJ.addItemDecoration(new f(com.baidu.swan.apps.w.e.FV().FH()));
        this.bnJ.setOnTouchListener(this);
        this.boV.setOnClickListener(this);
        this.boX = PoiSearch.newInstance();
        this.boX.setOnGetPoiSearchResultListener(this);
        this.boT.addTextChangedListener(this);
        this.boT.setOnFocusChangeListener(this);
        this.boT.setOnKeyListener(this);
        this.boT.requestFocus();
        this.bnJ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int Uq;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (Uq = a.this.Uq()) >= 0 && Uq + 1 == a.this.bnY.getItemCount()) {
                    a.this.Us();
                }
            }
        });
        this.boT.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.boT, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.boY == null) {
            this.boY = (InputMethodManager) com.baidu.swan.apps.w.e.FV().FH().getApplicationContext().getSystemService("input_method");
        }
        if (this.boY != null) {
            if (z) {
                this.boY.showSoftInput(view, 0);
            } else {
                this.boY.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Uq() {
        if (this.boW != null) {
            return this.boW.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int Uq = Uq();
        if (Uq == -1) {
            return null;
        }
        return this.boW.findViewByPosition(Uq);
    }

    private void Ur() {
        if (!TextUtils.isEmpty(this.bpb)) {
            this.boZ = 0;
            ke(this.bpb);
            d(this.boT, false);
        }
    }

    private void ke(String str) {
        this.boX.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.bpd).keyword(str).pageCapacity(13).pageNum(this.boZ));
    }

    public void Us() {
        if (!this.mIsLoading) {
            if (this.boZ < this.bpa) {
                ke(this.bpb);
                this.mIsLoading = true;
                return;
            }
            Ut();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.bot != null && gVar.bot.location != null) {
            PoiInfo poiInfo = gVar.bot;
            intent.putExtra("SelectedLocationInfo", new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        N(intent);
        Ue();
    }

    private void N(Intent intent) {
        if (Wh() != null) {
            Wh().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.bpc) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.bpa = poiResult.getTotalPageNum();
                if (this.boZ == 0) {
                    this.bnW.clear();
                }
                this.bnW.addAll(g.F(poiResult.getAllPoi()));
                this.bnY.b(this.bnW, this.bpb);
                this.boZ++;
            } else {
                if (this.boZ == 0) {
                    this.bpa = 0;
                    this.bnW.clear();
                    this.bnY.setData(this.bnW);
                }
                Ut();
            }
            if (this.boZ == 0 && this.bnW.size() == 0) {
                z = true;
            }
            db(z);
            if (this.bnW.size() <= 0) {
                Ut();
            }
        }
    }

    private void Ut() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.bnJ.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).cZ(false);
            }
        }
    }

    public void db(boolean z) {
        this.boU.setVisibility(z ? 0 : 8);
    }

    private void Ue() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.boX.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.bnW.clear();
            this.bnY.setData(this.bnW);
            this.bpb = "";
            this.boZ = 0;
            this.bpa = 0;
            this.bpc = true;
            return;
        }
        this.bpc = false;
        this.boZ = 0;
        this.bpa = 0;
        this.bpb = editable.toString();
        ke(this.bpb);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.boT, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            Ue();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            Ur();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.boT, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void M(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
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
