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
    private TextView bYe;
    private RecyclerView epA;
    private List<com.baidu.swan.impl.map.location.c> epM;
    private LocationDetailAdapter epO;
    private EditText eqK;
    private View eqL;
    private LinearLayoutManager eqM;
    private String eqP;
    private boolean eqQ;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch eqN = null;
    private int bLv = 0;
    private int eqO = 0;
    private String eqR = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void baK() {
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            afX.mC("navigateTo").af(f.cSz, f.cSB).f(this).apI();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.bam();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (aoI()) {
            inflate = av(inflate);
            gJ(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.epM = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.eqR = string;
        }
        this.eqK = (EditText) view.findViewById(R.id.search_text);
        this.epA = (RecyclerView) view.findViewById(R.id.location_list);
        this.eqL = view.findViewById(R.id.no_result_tip);
        this.bYe = (TextView) view.findViewById(R.id.cancel_search);
        this.eqM = new LinearLayoutManager(com.baidu.swan.apps.v.f.aAl().azV());
        this.epA.setLayoutManager(this.eqM);
        this.epO = new LocationDetailAdapter(com.baidu.swan.apps.v.f.aAl().azV(), this.epA, this);
        this.epA.setAdapter(this.epO);
        this.epA.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.aAl().azV()));
        this.epA.setOnTouchListener(this);
        this.bYe.setOnClickListener(this);
        this.eqN = PoiSearch.newInstance();
        this.eqN.setOnGetPoiSearchResultListener(this);
        this.eqK.addTextChangedListener(this);
        this.eqK.setOnFocusChangeListener(this);
        this.eqK.setOnKeyListener(this);
        this.eqK.requestFocus();
        this.epA.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int bbj;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (bbj = a.this.bbj()) >= 0 && bbj + 1 == a.this.epO.getItemCount()) {
                    a.this.bbl();
                }
            }
        });
        this.eqK.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.eqK, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.aAl().azV().getApplicationContext().getSystemService("input_method");
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
    public int bbj() {
        if (this.eqM != null) {
            return this.eqM.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int bbj = bbj();
        if (bbj == -1) {
            return null;
        }
        return this.eqM.findViewByPosition(bbj);
    }

    private void bbk() {
        if (!TextUtils.isEmpty(this.eqP)) {
            this.bLv = 0;
            xQ(this.eqP);
            d(this.eqK, false);
        }
    }

    private void xQ(String str) {
        this.eqN.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.eqR).keyword(str).pageCapacity(13).pageNum(this.bLv));
    }

    public void bbl() {
        if (!this.mIsLoading) {
            if (this.bLv < this.eqO) {
                xQ(this.eqP);
                this.mIsLoading = true;
                return;
            }
            bbm();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(com.baidu.swan.impl.map.location.c cVar) {
        Intent intent = new Intent();
        if (cVar.eqk != null && cVar.eqk.location != null) {
            PoiInfo poiInfo = cVar.eqk;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        B(intent);
        baX();
    }

    private void B(Intent intent) {
        if (bdT() != null) {
            bdT().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.eqQ) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.eqO = poiResult.getTotalPageNum();
                if (this.bLv == 0) {
                    this.epM.clear();
                }
                this.epM.addAll(com.baidu.swan.impl.map.location.c.aZ(poiResult.getAllPoi()));
                this.epO.setData(this.epM, this.eqP);
                this.bLv++;
            } else {
                if (this.bLv == 0) {
                    this.eqO = 0;
                    this.epM.clear();
                    this.epO.setData(this.epM);
                }
                bbm();
            }
            if (this.bLv == 0 && this.epM.size() == 0) {
                z = true;
            }
            ix(z);
            if (this.epM.size() <= 0) {
                bbm();
            }
        }
    }

    private void bbm() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.epA.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof LocationFooterViewHolder) {
                ((LocationFooterViewHolder) childViewHolder).iv(false);
            }
        }
    }

    public void ix(boolean z) {
        this.eqL.setVisibility(z ? 0 : 8);
    }

    private void baX() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eqN.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.epM.clear();
            this.epO.setData(this.epM);
            this.eqP = "";
            this.bLv = 0;
            this.eqO = 0;
            this.eqQ = true;
            return;
        }
        this.eqQ = false;
        this.bLv = 0;
        this.eqO = 0;
        this.eqP = editable.toString();
        xQ(this.eqP);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.eqK, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            baX();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            bbk();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.eqK, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aog() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajx() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
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
