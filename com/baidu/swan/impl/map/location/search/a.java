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
import com.baidu.swan.apps.y.f;
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private RecyclerView cVG;
    private List<g> cVT;
    private com.baidu.swan.impl.map.location.b cVV;
    private EditText cWQ;
    private View cWR;
    private TextView cWS;
    private LinearLayoutManager cWT;
    private String cWW;
    private boolean cWX;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch cWU = null;
    private int mCurrentIndex = 0;
    private int cWV = 0;
    private String cWY = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aAg() {
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot != null) {
            Ot.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).e(this).Wp();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.azI();
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
        this.cVT = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.cWY = string;
        }
        this.cWQ = (EditText) view.findViewById(R.id.search_text);
        this.cVG = (RecyclerView) view.findViewById(R.id.location_list);
        this.cWR = view.findViewById(R.id.no_result_tip);
        this.cWS = (TextView) view.findViewById(R.id.cancel_search);
        this.cWT = new LinearLayoutManager(f.aeJ().aeu());
        this.cVG.setLayoutManager(this.cWT);
        this.cVV = new com.baidu.swan.impl.map.location.b(f.aeJ().aeu(), this.cVG, this);
        this.cVG.setAdapter(this.cVV);
        this.cVG.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.aeJ().aeu()));
        this.cVG.setOnTouchListener(this);
        this.cWS.setOnClickListener(this);
        this.cWU = PoiSearch.newInstance();
        this.cWU.setOnGetPoiSearchResultListener(this);
        this.cWQ.addTextChangedListener(this);
        this.cWQ.setOnFocusChangeListener(this);
        this.cWQ.setOnKeyListener(this);
        this.cWQ.requestFocus();
        this.cVG.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aAE;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aAE = a.this.aAE()) >= 0 && aAE + 1 == a.this.cVV.getItemCount()) {
                    a.this.aAG();
                }
            }
        });
        this.cWQ.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.cWQ, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.aeJ().aeu().getApplicationContext().getSystemService("input_method");
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
    public int aAE() {
        if (this.cWT != null) {
            return this.cWT.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aAE = aAE();
        if (aAE == -1) {
            return null;
        }
        return this.cWT.findViewByPosition(aAE);
    }

    private void aAF() {
        if (!TextUtils.isEmpty(this.cWW)) {
            this.mCurrentIndex = 0;
            rp(this.cWW);
            b((View) this.cWQ, false);
        }
    }

    private void rp(String str) {
        this.cWU.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.cWY).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aAG() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.cWV) {
                rp(this.cWW);
                this.mIsLoading = true;
                return;
            }
            aAH();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cWq != null && gVar.cWq.location != null) {
            PoiInfo poiInfo = gVar.cWq;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        C(intent);
        aAt();
    }

    private void C(Intent intent) {
        if (aCN() != null) {
            aCN().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.cWX) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.cWV = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.cVT.clear();
                }
                this.cVT.addAll(g.as(poiResult.getAllPoi()));
                this.cVV.b(this.cVT, this.cWW);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.cWV = 0;
                    this.cVT.clear();
                    this.cVV.setData(this.cVT);
                }
                aAH();
            }
            if (this.mCurrentIndex == 0 && this.cVT.size() == 0) {
                z = true;
            }
            fP(z);
            if (this.cVT.size() <= 0) {
                aAH();
            }
        }
    }

    private void aAH() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.cVG.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void fP(boolean z) {
        this.cWR.setVisibility(z ? 0 : 8);
    }

    private void aAt() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cWU.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.cVT.clear();
            this.cVV.setData(this.cVT);
            this.cWW = "";
            this.mCurrentIndex = 0;
            this.cWV = 0;
            this.cWX = true;
            return;
        }
        this.cWX = false;
        this.mCurrentIndex = 0;
        this.cWV = 0;
        this.cWW = editable.toString();
        rp(this.cWW);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.cWQ, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aAt();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aAF();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        b(this.cWQ, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
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
