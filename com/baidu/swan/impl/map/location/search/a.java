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
/* loaded from: classes10.dex */
public class a extends b implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener, OnGetPoiSearchResultListener, e {
    private List<g> csD;
    private com.baidu.swan.impl.map.location.b csF;
    private RecyclerView csq;
    private EditText ctB;
    private View ctC;
    private LinearLayoutManager ctD;
    private InputMethodManager ctF;
    private String ctH;
    private boolean ctI;
    private TextView mCancel;
    private boolean mIsLoading;
    private PoiSearch ctE = null;
    private int mCurrentIndex = 0;
    private int ctG = 0;
    private String ctJ = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void apD() {
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El != null) {
            El.gM("navigateTo").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).e(this).Mj();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.ape();
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
        this.csD = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.ctJ = string;
        }
        this.ctB = (EditText) view.findViewById(R.id.search_text);
        this.csq = (RecyclerView) view.findViewById(R.id.location_list);
        this.ctC = view.findViewById(R.id.no_result_tip);
        this.mCancel = (TextView) view.findViewById(R.id.cancel_search);
        this.ctD = new LinearLayoutManager(f.UC().Un());
        this.csq.setLayoutManager(this.ctD);
        this.csF = new com.baidu.swan.impl.map.location.b(f.UC().Un(), this.csq, this);
        this.csq.setAdapter(this.csF);
        this.csq.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.UC().Un()));
        this.csq.setOnTouchListener(this);
        this.mCancel.setOnClickListener(this);
        this.ctE = PoiSearch.newInstance();
        this.ctE.setOnGetPoiSearchResultListener(this);
        this.ctB.addTextChangedListener(this);
        this.ctB.setOnFocusChangeListener(this);
        this.ctB.setOnKeyListener(this);
        this.ctB.requestFocus();
        this.csq.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int aqb;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (aqb = a.this.aqb()) >= 0 && aqb + 1 == a.this.csF.getItemCount()) {
                    a.this.aqd();
                }
            }
        });
        this.ctB.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.ctB, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.ctF == null) {
            this.ctF = (InputMethodManager) f.UC().Un().getApplicationContext().getSystemService("input_method");
        }
        if (this.ctF != null) {
            if (z) {
                this.ctF.showSoftInput(view, 0);
            } else {
                this.ctF.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aqb() {
        if (this.ctD != null) {
            return this.ctD.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int aqb = aqb();
        if (aqb == -1) {
            return null;
        }
        return this.ctD.findViewByPosition(aqb);
    }

    private void aqc() {
        if (!TextUtils.isEmpty(this.ctH)) {
            this.mCurrentIndex = 0;
            pO(this.ctH);
            b((View) this.ctB, false);
        }
    }

    private void pO(String str) {
        this.ctE.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.ctJ).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void aqd() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.ctG) {
                pO(this.ctH);
                this.mIsLoading = true;
                return;
            }
            aqe();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cta != null && gVar.cta.location != null) {
            PoiInfo poiInfo = gVar.cta;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        Q(intent);
        apQ();
    }

    private void Q(Intent intent) {
        if (asj() != null) {
            asj().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.ctI) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.ctG = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.csD.clear();
                }
                this.csD.addAll(g.aj(poiResult.getAllPoi()));
                this.csF.b(this.csD, this.ctH);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.ctG = 0;
                    this.csD.clear();
                    this.csF.setData(this.csD);
                }
                aqe();
            }
            if (this.mCurrentIndex == 0 && this.csD.size() == 0) {
                z = true;
            }
            eK(z);
            if (this.csD.size() <= 0) {
                aqe();
            }
        }
    }

    private void aqe() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.csq.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void eK(boolean z) {
        this.ctC.setVisibility(z ? 0 : 8);
    }

    private void apQ() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ctE.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.csD.clear();
            this.csF.setData(this.csD);
            this.ctH = "";
            this.mCurrentIndex = 0;
            this.ctG = 0;
            this.ctI = true;
            return;
        }
        this.ctI = false;
        this.mCurrentIndex = 0;
        this.ctG = 0;
        this.ctH = editable.toString();
        pO(this.ctH);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.ctB, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            apQ();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            aqc();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        b(this.ctB, z);
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
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
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
