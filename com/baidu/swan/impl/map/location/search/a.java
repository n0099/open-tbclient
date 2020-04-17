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
    private RecyclerView cVB;
    private List<g> cVO;
    private com.baidu.swan.impl.map.location.b cVQ;
    private EditText cWL;
    private View cWM;
    private TextView cWN;
    private LinearLayoutManager cWO;
    private String cWR;
    private boolean cWS;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch cWP = null;
    private int mCurrentIndex = 0;
    private int cWQ = 0;
    private String cWT = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aAg() {
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou != null) {
            Ou.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).e(this).Wq();
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
        this.cVO = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.cWT = string;
        }
        this.cWL = (EditText) view.findViewById(R.id.search_text);
        this.cVB = (RecyclerView) view.findViewById(R.id.location_list);
        this.cWM = view.findViewById(R.id.no_result_tip);
        this.cWN = (TextView) view.findViewById(R.id.cancel_search);
        this.cWO = new LinearLayoutManager(f.aeK().aev());
        this.cVB.setLayoutManager(this.cWO);
        this.cVQ = new com.baidu.swan.impl.map.location.b(f.aeK().aev(), this.cVB, this);
        this.cVB.setAdapter(this.cVQ);
        this.cVB.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.aeK().aev()));
        this.cVB.setOnTouchListener(this);
        this.cWN.setOnClickListener(this);
        this.cWP = PoiSearch.newInstance();
        this.cWP.setOnGetPoiSearchResultListener(this);
        this.cWL.addTextChangedListener(this);
        this.cWL.setOnFocusChangeListener(this);
        this.cWL.setOnKeyListener(this);
        this.cWL.requestFocus();
        this.cVB.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aAE;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aAE = a.this.aAE()) >= 0 && aAE + 1 == a.this.cVQ.getItemCount()) {
                    a.this.aAG();
                }
            }
        });
        this.cWL.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.cWL, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.aeK().aev().getApplicationContext().getSystemService("input_method");
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
        if (this.cWO != null) {
            return this.cWO.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aAE = aAE();
        if (aAE == -1) {
            return null;
        }
        return this.cWO.findViewByPosition(aAE);
    }

    private void aAF() {
        if (!TextUtils.isEmpty(this.cWR)) {
            this.mCurrentIndex = 0;
            rp(this.cWR);
            b((View) this.cWL, false);
        }
    }

    private void rp(String str) {
        this.cWP.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.cWT).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aAG() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.cWQ) {
                rp(this.cWR);
                this.mIsLoading = true;
                return;
            }
            aAH();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cWl != null && gVar.cWl.location != null) {
            PoiInfo poiInfo = gVar.cWl;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        P(intent);
        aAt();
    }

    private void P(Intent intent) {
        if (aCN() != null) {
            aCN().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.cWS) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.cWQ = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.cVO.clear();
                }
                this.cVO.addAll(g.as(poiResult.getAllPoi()));
                this.cVQ.b(this.cVO, this.cWR);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.cWQ = 0;
                    this.cVO.clear();
                    this.cVQ.setData(this.cVO);
                }
                aAH();
            }
            if (this.mCurrentIndex == 0 && this.cVO.size() == 0) {
                z = true;
            }
            fP(z);
            if (this.cVO.size() <= 0) {
                aAH();
            }
        }
    }

    private void aAH() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.cVB.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void fP(boolean z) {
        this.cWM.setVisibility(z ? 0 : 8);
    }

    private void aAt() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cWP.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.cVO.clear();
            this.cVQ.setData(this.cVO);
            this.cWR = "";
            this.mCurrentIndex = 0;
            this.cWQ = 0;
            this.cWS = true;
            return;
        }
        this.cWS = false;
        this.mCurrentIndex = 0;
        this.cWQ = 0;
        this.cWR = editable.toString();
        rp(this.cWR);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.cWL, false);
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
        b(this.cWL, z);
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
    public boolean Vm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QX() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
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
