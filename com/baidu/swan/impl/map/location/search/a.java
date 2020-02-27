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
    private List<g> cwF;
    private com.baidu.swan.impl.map.location.b cwH;
    private RecyclerView cws;
    private EditText cxC;
    private View cxD;
    private LinearLayoutManager cxE;
    private String cxH;
    private boolean cxI;
    private TextView mCancel;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch cxF = null;
    private int mCurrentIndex = 0;
    private int cxG = 0;
    private String cxJ = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void arQ() {
        com.baidu.swan.apps.core.d.e GA = f.WQ().GA();
        if (GA != null) {
            GA.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.boe, com.baidu.swan.apps.core.d.e.bog).e(this).Ox();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.ars();
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
        this.cwF = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.cxJ = string;
        }
        this.cxC = (EditText) view.findViewById(R.id.search_text);
        this.cws = (RecyclerView) view.findViewById(R.id.location_list);
        this.cxD = view.findViewById(R.id.no_result_tip);
        this.mCancel = (TextView) view.findViewById(R.id.cancel_search);
        this.cxE = new LinearLayoutManager(f.WQ().WB());
        this.cws.setLayoutManager(this.cxE);
        this.cwH = new com.baidu.swan.impl.map.location.b(f.WQ().WB(), this.cws, this);
        this.cws.setAdapter(this.cwH);
        this.cws.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.WQ().WB()));
        this.cws.setOnTouchListener(this);
        this.mCancel.setOnClickListener(this);
        this.cxF = PoiSearch.newInstance();
        this.cxF.setOnGetPoiSearchResultListener(this);
        this.cxC.addTextChangedListener(this);
        this.cxC.setOnFocusChangeListener(this);
        this.cxC.setOnKeyListener(this);
        this.cxC.requestFocus();
        this.cws.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int asp;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (asp = a.this.asp()) >= 0 && asp + 1 == a.this.cwH.getItemCount()) {
                    a.this.asr();
                }
            }
        });
        this.cxC.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.cxC, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.WQ().WB().getApplicationContext().getSystemService("input_method");
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
    public int asp() {
        if (this.cxE != null) {
            return this.cxE.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int asp = asp();
        if (asp == -1) {
            return null;
        }
        return this.cxE.findViewByPosition(asp);
    }

    private void asq() {
        if (!TextUtils.isEmpty(this.cxH)) {
            this.mCurrentIndex = 0;
            qd(this.cxH);
            b((View) this.cxC, false);
        }
    }

    private void qd(String str) {
        this.cxF.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.cxJ).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void asr() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.cxG) {
                qd(this.cxH);
                this.mIsLoading = true;
                return;
            }
            ass();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cxc != null && gVar.cxc.location != null) {
            PoiInfo poiInfo = gVar.cxc;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        Q(intent);
        asd();
    }

    private void Q(Intent intent) {
        if (aux() != null) {
            aux().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.cxI) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.cxG = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.cwF.clear();
                }
                this.cwF.addAll(g.aj(poiResult.getAllPoi()));
                this.cwH.b(this.cwF, this.cxH);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.cxG = 0;
                    this.cwF.clear();
                    this.cwH.setData(this.cwF);
                }
                ass();
            }
            if (this.mCurrentIndex == 0 && this.cwF.size() == 0) {
                z = true;
            }
            eR(z);
            if (this.cwF.size() <= 0) {
                ass();
            }
        }
    }

    private void ass() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.cws.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void eR(boolean z) {
        this.cxD.setVisibility(z ? 0 : 8);
    }

    private void asd() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cxF.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.cwF.clear();
            this.cwH.setData(this.cwF);
            this.cxH = "";
            this.mCurrentIndex = 0;
            this.cxG = 0;
            this.cxI = true;
            return;
        }
        this.cxI = false;
        this.mCurrentIndex = 0;
        this.cxG = 0;
        this.cxH = editable.toString();
        qd(this.cxH);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.cxC, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            asd();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            asq();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        b(this.cxC, z);
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
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
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
