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
import com.baidu.swan.apps.w.f;
import com.baidu.swan.impl.map.location.d;
import com.baidu.swan.impl.map.location.e;
import com.baidu.swan.impl.map.location.g;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private List<g> dlG;
    private com.baidu.swan.impl.map.location.b dlI;
    private RecyclerView dlt;
    private EditText dmD;
    private View dmE;
    private TextView dmF;
    private LinearLayoutManager dmG;
    private String dmJ;
    private boolean dmK;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch dmH = null;
    private int mCurrentIndex = 0;
    private int dmI = 0;
    private String dmL = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aFe() {
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN != null) {
            RN.jx("navigateTo").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).f(this).aah();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aEG();
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
        this.dlG = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.dmL = string;
        }
        this.dmD = (EditText) view.findViewById(R.id.search_text);
        this.dlt = (RecyclerView) view.findViewById(R.id.location_list);
        this.dmE = view.findViewById(R.id.no_result_tip);
        this.dmF = (TextView) view.findViewById(R.id.cancel_search);
        this.dmG = new LinearLayoutManager(f.ajb().aiL());
        this.dlt.setLayoutManager(this.dmG);
        this.dlI = new com.baidu.swan.impl.map.location.b(f.ajb().aiL(), this.dlt, this);
        this.dlt.setAdapter(this.dlI);
        this.dlt.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.ajb().aiL()));
        this.dlt.setOnTouchListener(this);
        this.dmF.setOnClickListener(this);
        this.dmH = PoiSearch.newInstance();
        this.dmH.setOnGetPoiSearchResultListener(this);
        this.dmD.addTextChangedListener(this);
        this.dmD.setOnFocusChangeListener(this);
        this.dmD.setOnKeyListener(this);
        this.dmD.requestFocus();
        this.dlt.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aFC;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aFC = a.this.aFC()) >= 0 && aFC + 1 == a.this.dlI.getItemCount()) {
                    a.this.aFE();
                }
            }
        });
        this.dmD.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.dmD, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.ajb().aiL().getApplicationContext().getSystemService("input_method");
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
    public int aFC() {
        if (this.dmG != null) {
            return this.dmG.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aFC = aFC();
        if (aFC == -1) {
            return null;
        }
        return this.dmG.findViewByPosition(aFC);
    }

    private void aFD() {
        if (!TextUtils.isEmpty(this.dmJ)) {
            this.mCurrentIndex = 0;
            tb(this.dmJ);
            d(this.dmD, false);
        }
    }

    private void tb(String str) {
        this.dmH.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.dmL).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aFE() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.dmI) {
                tb(this.dmJ);
                this.mIsLoading = true;
                return;
            }
            aFF();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.dmd != null && gVar.dmd.location != null) {
            PoiInfo poiInfo = gVar.dmd;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        y(intent);
        aFr();
    }

    private void y(Intent intent) {
        if (aIA() != null) {
            aIA().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.dmK) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.dmI = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.dlG.clear();
                }
                this.dlG.addAll(g.ar(poiResult.getAllPoi()));
                this.dlI.b(this.dlG, this.dmJ);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.dmI = 0;
                    this.dlG.clear();
                    this.dlI.setData(this.dlG);
                }
                aFF();
            }
            if (this.mCurrentIndex == 0 && this.dlG.size() == 0) {
                z = true;
            }
            gf(z);
            if (this.dlG.size() <= 0) {
                aFF();
            }
        }
    }

    private void aFF() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.dlt.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void gf(boolean z) {
        this.dmE.setVisibility(z ? 0 : 8);
    }

    private void aFr() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dmH.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.dlG.clear();
            this.dlI.setData(this.dlG);
            this.dmJ = "";
            this.mCurrentIndex = 0;
            this.dmI = 0;
            this.dmK = true;
            return;
        }
        this.dmK = false;
        this.mCurrentIndex = 0;
        this.dmI = 0;
        this.dmJ = editable.toString();
        tb(this.dmJ);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.dmD, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aFr();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aFD();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.dmD, z);
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
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
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
