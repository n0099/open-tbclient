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
    private List<g> cwH;
    private com.baidu.swan.impl.map.location.b cwJ;
    private RecyclerView cwu;
    private EditText cxE;
    private View cxF;
    private LinearLayoutManager cxG;
    private String cxJ;
    private boolean cxK;
    private TextView mCancel;
    private InputMethodManager mImm;
    private boolean mIsLoading;
    private PoiSearch cxH = null;
    private int mCurrentIndex = 0;
    private int cxI = 0;
    private String cxL = "北京";

    public static a V(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void arS() {
        com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC != null) {
            GC.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).e(this).Oz();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.impl.map.a.aru();
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
        this.cwH = new ArrayList(11);
        if (getArguments() != null) {
            String string = getArguments().getString("city");
            if (TextUtils.isEmpty(string)) {
                string = "北京";
            }
            this.cxL = string;
        }
        this.cxE = (EditText) view.findViewById(R.id.search_text);
        this.cwu = (RecyclerView) view.findViewById(R.id.location_list);
        this.cxF = view.findViewById(R.id.no_result_tip);
        this.mCancel = (TextView) view.findViewById(R.id.cancel_search);
        this.cxG = new LinearLayoutManager(f.WS().WD());
        this.cwu.setLayoutManager(this.cxG);
        this.cwJ = new com.baidu.swan.impl.map.location.b(f.WS().WD(), this.cwu, this);
        this.cwu.setAdapter(this.cwJ);
        this.cwu.addItemDecoration(new com.baidu.swan.impl.map.location.f(f.WS().WD()));
        this.cwu.setOnTouchListener(this);
        this.mCancel.setOnClickListener(this);
        this.cxH = PoiSearch.newInstance();
        this.cxH.setOnGetPoiSearchResultListener(this);
        this.cxE.addTextChangedListener(this);
        this.cxE.setOnFocusChangeListener(this);
        this.cxE.setOnKeyListener(this);
        this.cxE.requestFocus();
        this.cwu.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.swan.impl.map.location.search.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int asr;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (asr = a.this.asr()) >= 0 && asr + 1 == a.this.cwJ.getItemCount()) {
                    a.this.ast();
                }
            }
        });
        this.cxE.postDelayed(new Runnable() { // from class: com.baidu.swan.impl.map.location.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b((View) a.this.cxE, true);
            }
        }, 100L);
    }

    public void b(View view, boolean z) {
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) f.WS().WD().getApplicationContext().getSystemService("input_method");
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
    public int asr() {
        if (this.cxG != null) {
            return this.cxG.findLastVisibleItemPosition();
        }
        return -1;
    }

    private View getLastItemView() {
        int asr = asr();
        if (asr == -1) {
            return null;
        }
        return this.cxG.findViewByPosition(asr);
    }

    private void ass() {
        if (!TextUtils.isEmpty(this.cxJ)) {
            this.mCurrentIndex = 0;
            qd(this.cxJ);
            b((View) this.cxE, false);
        }
    }

    private void qd(String str) {
        this.cxH.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.cxL).keyword(str).pageCapacity(13).pageNum(this.mCurrentIndex));
    }

    public void ast() {
        if (!this.mIsLoading) {
            if (this.mCurrentIndex < this.cxI) {
                qd(this.cxJ);
                this.mIsLoading = true;
                return;
            }
            asu();
        }
    }

    @Override // com.baidu.swan.impl.map.location.e
    public void a(g gVar) {
        Intent intent = new Intent();
        if (gVar.cxe != null && gVar.cxe.location != null) {
            PoiInfo poiInfo = gVar.cxe;
            intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
        }
        Q(intent);
        asf();
    }

    private void Q(Intent intent) {
        if (auz() != null) {
            auz().onActivityResult(getTargetRequestCode(), 0, intent);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        boolean z = false;
        this.mIsLoading = false;
        if (!this.cxK) {
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.cxI = poiResult.getTotalPageNum();
                if (this.mCurrentIndex == 0) {
                    this.cwH.clear();
                }
                this.cwH.addAll(g.aj(poiResult.getAllPoi()));
                this.cwJ.b(this.cwH, this.cxJ);
                this.mCurrentIndex++;
            } else {
                if (this.mCurrentIndex == 0) {
                    this.cxI = 0;
                    this.cwH.clear();
                    this.cwJ.setData(this.cwH);
                }
                asu();
            }
            if (this.mCurrentIndex == 0 && this.cwH.size() == 0) {
                z = true;
            }
            eR(z);
            if (this.cwH.size() <= 0) {
                asu();
            }
        }
    }

    private void asu() {
        View lastItemView = getLastItemView();
        if (lastItemView != null) {
            RecyclerView.ViewHolder childViewHolder = this.cwu.getChildViewHolder(lastItemView);
            if (childViewHolder instanceof d) {
                ((d) childViewHolder).setVisibility(false);
            }
        }
    }

    public void eR(boolean z) {
        this.cxF.setVisibility(z ? 0 : 8);
    }

    private void asf() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cxH.destroy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            this.cwH.clear();
            this.cwJ.setData(this.cwH);
            this.cxJ = "";
            this.mCurrentIndex = 0;
            this.cxI = 0;
            this.cxK = true;
            return;
        }
        this.cxK = false;
        this.mCurrentIndex = 0;
        this.cxI = 0;
        this.cxJ = editable.toString();
        qd(this.cxJ);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b((View) this.cxE, false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_search) {
            asf();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            ass();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        b(this.cxE, z);
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
    public boolean Nw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ji() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
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
