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
/* loaded from: classes25.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private TextView bPL;
    private RecyclerView edJ;
    private List<g> edW;
    private b edY;
    private EditText eeT;
    private View eeU;
    private LinearLayoutManager eeV;
    private String eeY;
    private boolean eeZ;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch eeW = null;
    private int mCurrentIndex = 0;
    private int eeX = 0;
    private String efa = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void aZA() {
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null) {
            afM.nb("navigateTo").al(f.cKS, f.cKU).f(this).apn();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aZc();
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
        this.edW = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.efa = string;
        }
        this.eeT = (EditText) view.findViewById(R.id.search_text);
        this.edJ = (RecyclerView) view.findViewById(R.id.location_list);
        this.eeU = view.findViewById(R.id.no_result_tip);
        this.bPL = (TextView) view.findViewById(R.id.cancel_search);
        this.eeV = new LinearLayoutManager(com.baidu.swan.apps.v.f.azO().azy());
        this.edJ.setLayoutManager(this.eeV);
        this.edY = new b(com.baidu.swan.apps.v.f.azO().azy(), this.edJ, this);
        this.edJ.setAdapter(this.edY);
        this.edJ.addItemDecoration(new com.baidu.swan.impl.map.location.f(com.baidu.swan.apps.v.f.azO().azy()));
        this.edJ.setOnTouchListener(this);
        this.bPL.setOnClickListener(this);
        this.eeW = PoiSearch.newInstance();
        this.eeW.setOnGetPoiSearchResultListener(this);
        this.eeT.addTextChangedListener(this);
        this.eeT.setOnFocusChangeListener(this);
        this.eeT.setOnKeyListener(this);
        this.eeT.requestFocus();
        this.edJ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aZY;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aZY = a.this.aZY()) >= 0 && aZY + 1 == a.this.edY.getItemCount()) {
                    a.this.baa();
                }
            }
        });
        this.eeT.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.eeT, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.azO().azy().getApplicationContext().getSystemService("input_method");
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
    public int aZY() {
        if (this.eeV != null) {
            return this.eeV.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aZY = aZY();
        if (aZY == -1) {
            return null;
        }
        return this.eeV.findViewByPosition(aZY);
    }

    private void aZZ() {
        if (!TextUtils.isEmpty(this.eeY)) {
            this.mCurrentIndex = 0;
            yh(this.eeY);
            d(this.eeT, false);
        }
    }

    private void yh(String str) {
        this.eeW.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.efa).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void baa() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.eeX) {
                yh(this.eeY);
                this.mIsLoading = true;
                return;
            }
            bab();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.eet != null && gVar.eet.location != null) {
            PoiInfo poiInfo = gVar.eet;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        A(intent);
        aZN();
    }

    private void A(Intent intent) {
        if (bcG() != null) {
            bcG().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.eeZ) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.eeX = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.edW.clear();
                }
                this.edW.addAll(g.aU(poiResult.getAllPoi()));
                this.edY.c(this.edW, this.eeY);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.eeX = 0;
                    this.edW.clear();
                    this.edY.setData(this.edW);
                }
                bab();
            }
            if (this.mCurrentIndex == 0 && this.edW.size() == 0) {
                z = true;
            }
            hO(z);
            if (this.edW.size() <= 0) {
                bab();
            }
        }
    }

    private void bab() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.edJ.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void hO(boolean z) {
        this.eeU.setVisibility(z ? 0 : 8);
    }

    private void aZN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eeW.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.edW.clear();
            this.edY.setData(this.edW);
            this.eeY = "";
            this.mCurrentIndex = 0;
            this.eeX = 0;
            this.eeZ = true;
            return;
        }
        this.eeZ = false;
        this.mCurrentIndex = 0;
        this.eeX = 0;
        this.eeY = editable.toString();
        yh(this.eeY);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.eeT, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            aZN();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aZZ();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.eeT, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
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
