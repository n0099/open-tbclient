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
    private RecyclerView cwF;
    private List<g> cwS;
    private com.baidu.swan.impl.map.location.b cwU;
    private EditText cxP;
    private View cxQ;
    private LinearLayoutManager cxR;
    private String cxU;
    private boolean cxV;
    private TextView mCancel;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch cxS = null;
    private int mCurrentIndex = 0;
    private int cxT = 0;
    private String cxW = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void arV() {
        com.baidu.swan.apps.core.d.e GH = f.WV().GH();
        if (GH != null) {
            GH.ha("navigateTo").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).e(this).OC();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.arx();
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
        this.cwS = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.cxW = string;
        }
        this.cxP = (EditText) view.findViewById(R.id.search_text);
        this.cwF = (RecyclerView) view.findViewById(R.id.location_list);
        this.cxQ = view.findViewById(R.id.no_result_tip);
        this.mCancel = (TextView) view.findViewById(R.id.cancel_search);
        this.cxR = new LinearLayoutManager(f.WV().WG());
        this.cwF.setLayoutManager(this.cxR);
        this.cwU = new com.baidu.swan.impl.map.location.b(f.WV().WG(), this.cwF, this);
        this.cwF.setAdapter(this.cwU);
        this.cwF.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.WV().WG()));
        this.cwF.setOnTouchListener(this);
        this.mCancel.setOnClickListener(this);
        this.cxS = PoiSearch.newInstance();
        this.cxS.setOnGetPoiSearchResultListener(this);
        this.cxP.addTextChangedListener(this);
        this.cxP.setOnFocusChangeListener(this);
        this.cxP.setOnKeyListener(this);
        this.cxP.requestFocus();
        this.cwF.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int asu;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (asu = a.this.asu()) >= 0 && asu + 1 == a.this.cwU.getItemCount()) {
                    a.this.asw();
                }
            }
        });
        this.cxP.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.cxP, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.WV().WG().getApplicationContext().getSystemService("input_method");
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
    public int asu() {
        if (this.cxR != null) {
            return this.cxR.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int asu = asu();
        if (asu == -1) {
            return null;
        }
        return this.cxR.findViewByPosition(asu);
    }

    private void asv() {
        if (!TextUtils.isEmpty(this.cxU)) {
            this.mCurrentIndex = 0;
            qc(this.cxU);
            b((View) this.cxP, false);
        }
    }

    private void qc(String str) {
        this.cxS.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.cxW).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void asw() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.cxT) {
                qc(this.cxU);
                this.mIsLoading = true;
                return;
            }
            asx();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cxp != null && gVar.cxp.location != null) {
            PoiInfo poiInfo = gVar.cxp;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        Q(intent);
        asi();
    }

    private void Q(Intent intent) {
        if (auC() != null) {
            auC().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.cxV) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.cxT = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.cwS.clear();
                }
                this.cwS.addAll(g.aj(poiResult.getAllPoi()));
                this.cwU.b(this.cwS, this.cxU);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.cxT = 0;
                    this.cwS.clear();
                    this.cwU.setData(this.cwS);
                }
                asx();
            }
            if (this.mCurrentIndex == 0 && this.cwS.size() == 0) {
                z = true;
            }
            eS(z);
            if (this.cwS.size() <= 0) {
                asx();
            }
        }
    }

    private void asx() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.cwF.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void eS(boolean z) {
        this.cxQ.setVisibility(z ? 0 : 8);
    }

    private void asi() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cxS.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.cwS.clear();
            this.cwU.setData(this.cwS);
            this.cxU = "";
            this.mCurrentIndex = 0;
            this.cxT = 0;
            this.cxV = true;
            return;
        }
        this.cxV = false;
        this.mCurrentIndex = 0;
        this.cxT = 0;
        this.cxU = editable.toString();
        qc(this.cxU);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.cxP, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            asi();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            asv();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        b(this.cxP, z);
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
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
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
