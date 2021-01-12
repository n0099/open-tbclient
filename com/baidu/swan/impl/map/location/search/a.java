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
/* loaded from: classes8.dex */
public class a extends c implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, b {
    private TextView bUf;
    private List<com.baidu.swan.impl.map.location.c> enF;
    private LocationDetailAdapter enH;
    private RecyclerView enr;
    private EditText eoE;
    private View eoF;
    private LinearLayoutManager eoG;
    private String eoJ;
    private boolean eoK;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch eoH = null;
    private int bHL = 0;
    private int eoI = 0;
    private String eoL = "北京";

    public static a ab(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void bax() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            afz.mk("navigateTo").ai(f.cQm, f.cQo).f(this).apk();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aZZ();
        SDKInitializer.setCoordType(CoordType.GCJ02);
        View inflate = layoutInflater.inflate(R.layout.ai_apps_location_search, viewGroup, false);
        init(inflate);
        if (aok()) {
            inflate = az(inflate);
            gG(-1);
        }
        return a(inflate, this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(View view) {
        this.enF = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.eoL = string;
        }
        this.eoE = (EditText) view.findViewById(R.id.search_text);
        this.enr = (RecyclerView) view.findViewById(R.id.location_list);
        this.eoF = view.findViewById(R.id.no_result_tip);
        this.bUf = (TextView) view.findViewById(R.id.cancel_search);
        this.eoG = new LinearLayoutManager(com.baidu.swan.apps.v.f.azN().azx());
        this.enr.setLayoutManager(this.eoG);
        this.enH = new LocationDetailAdapter(com.baidu.swan.apps.v.f.azN().azx(), this.enr, this);
        this.enr.setAdapter(this.enH);
        this.enr.addItemDecoration(new LocationItemDecoration(com.baidu.swan.apps.v.f.azN().azx()));
        this.enr.setOnTouchListener(this);
        this.bUf.setOnClickListener(this);
        this.eoH = PoiSearch.newInstance();
        this.eoH.setOnGetPoiSearchResultListener(this);
        this.eoE.addTextChangedListener(this);
        this.eoE.setOnFocusChangeListener(this);
        this.eoE.setOnKeyListener(this);
        this.eoE.requestFocus();
        this.enr.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int baW;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (baW = a.this.baW()) >= 0 && baW + 1 == a.this.enH.getItemCount()) {
                    a.this.baY();
                }
            }
        });
        this.eoE.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(a.this.eoE, true);
            }
        }, 100L);
    }

    public void d(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) com.baidu.swan.apps.v.f.azN().azx().getApplicationContext().getSystemService("input_method");
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
    public int baW() {
        if (this.eoG != null) {
            return this.eoG.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int baW = baW();
        if (baW == -1) {
            return null;
        }
        return this.eoG.findViewByPosition(baW);
    }

    private void baX() {
        if (!TextUtils.isEmpty(this.eoJ)) {
            this.bHL = 0;
            xx(this.eoJ);
            d(this.eoE, false);
        }
    }

    private void xx(String str) {
        this.eoH.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.eoL).keyword(str).pageCapacity(13).pageNum(this.bHL));
    }

    public void baY() {
        if (!this.mIsLoading) {
            if (this.bHL < this.eoI) {
                xx(this.eoJ);
                this.mIsLoading = true;
                return;
            }
            baZ();
        }
    }

    @Override // com.baidu.swan.impl.map.location.b
    public void a(com.baidu.swan.impl.map.location.c cVar) {
        Intent intent = new Intent();
        if (cVar.eod != null && cVar.eod.location != null) {
            PoiInfo poiInfo = cVar.eod;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        B(intent);
        baK();
    }

    private void B(Intent intent) {
        if (bdG() != null) {
            bdG().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.eoK) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.eoI = poiResult.getTotalPageNum();
                if (this.bHL == 0) {
                    this.enF.clear();
                }
                this.enF.addAll(com.baidu.swan.impl.map.location.c.be(poiResult.getAllPoi()));
                this.enH.c(this.enF, this.eoJ);
                this.bHL++;
            } else {
                if (this.bHL == 0) {
                    this.eoI = 0;
                    this.enF.clear();
                    this.enH.setData(this.enF);
                }
                baZ();
            }
            if (this.bHL == 0 && this.enF.size() == 0) {
                z = true;
            }
            iv(z);
            if (this.enF.size() <= 0) {
                baZ();
            }
        }
    }

    private void baZ() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.enr.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof LocationFooterViewHolder) {
                ((LocationFooterViewHolder) childViewHolder).it(false);
            }
        }
    }

    public void iv(boolean z) {
        this.eoF.setVisibility(z ? 0 : 8);
    }

    private void baK() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eoH.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.enF.clear();
            this.enH.setData(this.enF);
            this.eoJ = "";
            this.bHL = 0;
            this.eoI = 0;
            this.eoK = true;
            return;
        }
        this.eoK = false;
        this.bHL = 0;
        this.eoI = 0;
        this.eoJ = editable.toString();
        xx(this.eoJ);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d(this.eoE, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            baK();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            baX();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        d(this.eoE, z);
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
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
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
