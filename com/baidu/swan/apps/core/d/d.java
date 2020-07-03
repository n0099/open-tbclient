package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.ac;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class d extends b implements a.InterfaceC0383a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int caf = ag.D(149.0f);
    private static String cam = "-1";
    private static String can = cam;
    private static String cao;
    private com.baidu.swan.apps.res.widget.floatlayer.a bLN;
    private com.baidu.swan.apps.statistic.a cag;
    private FrameLayout caj;
    private com.baidu.swan.apps.adaptation.b.c cak;
    private com.baidu.swan.apps.tabbar.b.a cal;
    private com.baidu.swan.apps.runtime.config.c cap;
    private com.baidu.swan.apps.core.f.c car;
    private ac cas;
    private View mRootView;
    private com.baidu.swan.apps.model.b cah = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cai = new TreeMap();
    private int caq = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ZC();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.cas = com.baidu.swan.apps.u.a.agK();
                d.this.cas.a(d.this.bZM, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.f.D("route", "fragment create.");
    }

    private void ZC() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bZM = com.baidu.swan.apps.model.c.me(arguments.getString("ai_apps_param"));
            this.cah.mPage = this.bZM != null ? this.bZM.getPage() : "";
            this.cah.mParams = this.bZM != null ? this.bZM.getParams() : "";
            this.cah.ctH = j.oq(this.cah.getPage());
            this.cap = com.baidu.swan.apps.w.f.ajb().ly(this.cah.akX());
            if (this.cap.cFX) {
                this.cap = com.baidu.swan.apps.w.f.ajb().lz(this.cah.getPage());
            }
            this.caq = Zr().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (DEBUG) {
            Log.d("SwanAppFragment", "onAttach() obj: " + this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.swan.apps.performance.f.D("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.caj = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.cal = new com.baidu.swan.apps.tabbar.b.a(this);
        ai(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cak.Ua());
        com.baidu.swan.apps.aa.f.alv().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Ug() {
        if (this.cak != null) {
            return this.cak.Ug();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        dH(Zm());
        if (ZF()) {
            Zl();
        }
        ZR();
        this.bZO.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String Up = d.this.cak.Up();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.ce(Up, "scrollViewBackToTop");
                com.baidu.swan.apps.w.f.ajb().a(Up, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
        this.cak.Uj();
        UI();
        dL(true);
        this.bZP.n(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), Zv());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Zj() {
        Zx();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        d ZW = com.baidu.swan.apps.w.f.ajb().ZW();
        com.baidu.swan.apps.model.c Zz = ZW == null ? null : ZW.Zz();
        if (Zz != null && !TextUtils.isEmpty(Zz.getPage())) {
            fVar.v("page", Zz.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cap)) {
            super.applyImmersion(i);
            return;
        }
        if (!ZO() && aa.ct(this.mActivity)) {
            z = false;
        }
        v(i, z);
        ZR();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean eU(int i) {
        boolean eU = super.eU(i);
        ZR();
        return eU;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        ZR();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dK(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        performPause();
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (this.bZP != null && this.bZP.isShowing()) {
            this.bZP.gh(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cak.Up())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cak.Up())));
        }
    }

    public static void jr(String str) {
        cao = str;
    }

    private void ZD() {
        if (!TextUtils.equals(can, this.cak.Up()) || TextUtils.equals(cao, "switchTab")) {
            int py = this.cal.py(ZL().akX());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.chz = can;
            eVar.chA = this.cak.Up();
            eVar.caF = cao;
            eVar.chB = this.cah.mPage;
            eVar.chC = String.valueOf(py);
            cao = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.chz + " ,toId: " + eVar.chA + " ,RouteType: " + eVar.caF + " page:" + eVar.chB + ",TabIndex: " + eVar.chC);
            }
            com.baidu.swan.apps.w.f.ajb().a(eVar);
            can = this.cak.Up();
        }
    }

    private void js(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cak.Up());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cak.Up());
        }
        com.baidu.swan.apps.w.f.ajb().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Zy() {
        if (this.cak == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cak.Up());
        com.baidu.swan.apps.adaptation.b.f Uh = this.cak.Uh();
        if (Uh != null) {
            hashMap.put("webViewUrl", Uh.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void ai(View view) {
        com.baidu.swan.apps.performance.f.D("route", "createSlaveWebView start.");
        String aiI = this.bZM.aiI();
        String params = this.bZM.getParams();
        String page = this.bZM.getPage();
        String N = aj.N(aiI, page, params);
        this.cak = com.baidu.swan.apps.core.slave.b.jT(N);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + N + " is load: " + (this.cak != null));
        }
        if (this.cak == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cak = p(aiI, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c ly = com.baidu.swan.apps.w.f.ajb().ly(page);
        this.cak.b(this.caj, ly);
        this.cak.a(this.caj, ly);
        jw(page);
        a(this.cak);
        if (YW()) {
            this.cai.put(page, this.cak);
            this.cal.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.f.D("route", "createSlaveWebView end.");
        ZS();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cai != null && !this.cai.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cai.values()) {
                if (cVar != null) {
                    cVar.Uq();
                }
            }
        } else if (this.cak != null) {
            this.cak.Uq();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cai != null && !this.cai.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cai.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cai.clear();
        } else if (this.cak != null) {
            b(this.cak);
            this.cak.destroy();
        }
        this.cak = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.bK(com.baidu.swan.apps.w.f.ajb().aiL());
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded()) {
            super.setUserVisibleHint(z);
            if (DEBUG) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                dK(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cak == null;
        String Up = z ? "" : this.cak.Up();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + Up);
        }
        if (!z) {
            dH(Zm());
            this.cak.onResume();
            ZD();
            js("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.el(true);
        if (com.baidu.swan.apps.console.c.WX()) {
            com.baidu.swan.apps.core.c.b.YO();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Ug;
        boolean z = this.cak == null;
        String Up = z ? "" : this.cak.Up();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + Up);
        }
        if (!z) {
            this.cak.onPause();
            js("onHide");
        }
        if (RI() != null) {
            RI().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.el(false);
        if (!z && (Ug = this.cak.Ug()) != null) {
            Ug.eP(false);
        }
    }

    public String jt(String str) {
        if (this.cai.containsKey(str)) {
            return this.cai.get(str).Up();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cal.py(ZL().akX()) != this.cal.py(bVar.akX())) {
            this.cal.pv(bVar.akX());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cai.get(bVar.ctH) == null) {
            String N = aj.N(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c jT = com.baidu.swan.apps.core.slave.b.jT(N);
            if (jT != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + N);
                }
                this.cai.put(bVar.mPage, jT);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                jT = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cai.put(bVar.mPage, jT);
            }
            jw(bVar.mPage);
            a(jT);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(aIB());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.g.bC("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bF("preload", F.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + F);
        }
        com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0352b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0352b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cfm = F.ceL.Ul();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.h.a(F, str4);
                }
                String oq = j.oq(str2);
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.cfo = str2 + "?" + str3;
                } else {
                    bVar.cfo = str2;
                }
                if (com.baidu.swan.apps.runtime.e.apN() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.apN().nH(oq);
                }
                bVar.cfk = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.apM(), bVar.cfo);
                bVar.cfp = com.baidu.swan.apps.w.f.ajb().ly(oq).cfp;
                bVar.cfj = String.valueOf(com.baidu.swan.apps.console.a.WU());
                if (com.baidu.swan.apps.runtime.e.apN() != null) {
                    String nJ = com.baidu.swan.apps.runtime.e.apN().nJ(oq);
                    if (!TextUtils.isEmpty(nJ)) {
                        bVar.cfq = nJ;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + nJ);
                        }
                    }
                }
                bVar.cfl = d.DEBUG || com.baidu.swan.apps.w.f.ajb().aiF();
                if (com.baidu.swan.apps.af.a.a.anx()) {
                    bVar.cfn = com.baidu.swan.apps.console.debugger.b.Xb();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cfr = str4;
                    com.baidu.swan.apps.performance.g.bC("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                z.auI();
                com.baidu.swan.apps.w.f.ajb().a(F.ceL.Up(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.bT(F.ceL.Up(), bVar.cfo);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.ceL;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.ctH;
        com.baidu.swan.apps.runtime.config.c ly = com.baidu.swan.apps.w.f.ajb().ly(TextUtils.isEmpty(str3) ? "" : str3);
        this.cah.mPage = str2;
        this.cah.mParams = bVar != null ? bVar.getParams() : "";
        this.cah.ctH = str3;
        this.cap = ly;
        boolean z = false;
        if (jv(str3)) {
            ju(str3);
        } else {
            z = true;
            a(bVar, str);
            ju(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.h.U(7, str);
            } else {
                com.baidu.swan.apps.performance.h.U(6, str);
            }
            com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.h.mL(str);
        }
        jq(ly.cFN);
        eV(SwanAppConfigData.dV(ly.cFO));
        eU(ly.cFM);
        ZR();
        ZU();
    }

    private void ju(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cai.get(str);
        if (this.cak != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c ly = com.baidu.swan.apps.w.f.ajb().ly(str);
            cVar.b(this.caj, ly);
            if (!cVar.Uf()) {
                cVar.a(this.caj, ly);
            }
            cVar.et(0);
            if (this.cak != null) {
                this.cak.et(8);
            }
            this.cak = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.caj;
    }

    private boolean jv(String str) {
        return (this.cai.isEmpty() || this.cai.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.toJSONString());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return Zm() && this.cak.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        SwanAppConfigData aiG;
        com.baidu.swan.apps.w.f ajb = com.baidu.swan.apps.w.f.ajb();
        if (ajb == null || (aiG = ajb.aiG()) == null || !aiG.aqE() || this.bZM == null) {
            return false;
        }
        return aiG.nT(this.bZM.getPage());
    }

    public boolean ZE() {
        if (this.cal == null) {
            return false;
        }
        return this.cal.ZE();
    }

    protected final boolean ZF() {
        SwanAppConfigData aiG;
        e RN = RN();
        if (RN == null) {
            return false;
        }
        return ((this.cap != null && this.cap.cFU) || (aiG = com.baidu.swan.apps.w.f.ajb().aiG()) == null || a(RN, aiG)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b eX = eVar.eX(0);
        if (eX == null || !(eX instanceof d)) {
            return false;
        }
        String page = ((d) eX).ZL().getPage();
        return swanAppConfigData.nT(page) || TextUtils.equals(swanAppConfigData.aiK(), page);
    }

    private boolean ZG() {
        SwanAppConfigData aiG = com.baidu.swan.apps.w.f.ajb().aiG();
        return (aiG == null || TextUtils.equals(aiG.aiK(), this.cah.getPage())) ? false : true;
    }

    public String ZH() {
        return this.cak != null ? this.cak.Up() : "";
    }

    public List<String> ZI() {
        ArrayList arrayList = new ArrayList();
        if (this.cai != null && !this.cai.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cai.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().Up());
                }
            }
        }
        if (this.cak != null) {
            String Up = this.cak.Up();
            if (!arrayList.contains(Up)) {
                arrayList.add(Up);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        if (com.baidu.g.a.NM()) {
            return true;
        }
        if (this.cak != null) {
            if (com.baidu.swan.apps.media.b.lC(this.cak.Up())) {
                return true;
            }
            return this.cak.Ui();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void UI() {
        FragmentActivity aIB = aIB();
        if (aIB != null && this.bZP == null) {
            this.bZP = new com.baidu.swan.menu.h(aIB, this.bZO, UJ(), com.baidu.swan.apps.u.a.agb(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bZP, this).akM();
        }
    }

    private int UJ() {
        return Zw() ? ZG() ? 18 : 17 : ZG() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> ZJ() {
        if (this.cak == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cak.Un().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a ZK() {
        return this.cal;
    }

    public com.baidu.swan.apps.model.b ZL() {
        return this.cah;
    }

    public com.baidu.swan.apps.adaptation.b.c ZM() {
        return this.cak;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0383a
    public com.baidu.swan.apps.res.widget.floatlayer.a RI() {
        if (this.bLN == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bLN = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), Zr().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bLN;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c Zn() {
        return this.cap;
    }

    private boolean ZN() {
        return this.cap != null && this.cap.cFR;
    }

    private boolean ZO() {
        if (this.cap == null) {
            return false;
        }
        return TextUtils.equals(this.cap.cFT, "custom");
    }

    private void jw(String str) {
        if (!ZO()) {
            com.baidu.swan.apps.w.f ajb = com.baidu.swan.apps.w.f.ajb();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (ajb.ly(str).cFR && this.car == null) {
                this.car = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.eW(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.car != null) {
                cVar.a(this.car);
            }
            cVar.a(ZP());
        }
    }

    private com.baidu.swan.apps.core.f.e ZP() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.car);
                    fVar.a(d.this.ZQ());
                    com.baidu.swan.apps.aa.f.alv().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.car);
                    com.baidu.swan.apps.aa.f.alv().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a ZQ() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fZ(String str) {
                d.this.jq(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.car != null && cVar != null) {
            cVar.b(this.car);
            if (cVar.Uh() != null) {
                cVar.b(this.car);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void ZR() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bZO != null) {
            if (ZO()) {
                dI(true);
                i = 0;
                z = true;
            } else if (ZN()) {
                dI(false);
                if (this.cak != null) {
                    if (this.cak.Uh() != null) {
                        dVar = this.cak.Uh().Un();
                    } else {
                        dVar = this.cak.Un();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cap == null && this.cap.cFS) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cap == null) {
                }
                z = true;
            } else {
                dI(false);
                i = caf + this.caq;
            }
            TextView centerTitleView = this.bZO.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            eW(i);
            dJ(z);
        }
    }

    private void dJ(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bZT == null || !this.bZT.avt()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ag.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = Zr().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.caj.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.caj.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bZN.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bZN.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(int i) {
        TextView centerTitleView;
        View avs;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - caf) * 1.0f) / (this.caq == 0 ? 1 : this.caq);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bZT != null && this.bZT.avt() && (avs = this.bZT.avs()) != null && (background = avs.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bZO.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cap != null && this.cap.cFS && (centerTitleView = this.bZO.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bZR.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void ZS() {
        this.cag = com.baidu.swan.apps.statistic.h.oE("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cag != null) {
            com.baidu.swan.apps.statistic.h.a(this.cag, gVar);
            this.cag = null;
        }
    }

    public void ZT() {
        this.cap.cFT = "default";
        applyImmersion();
        ZR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ZU() {
        if (this.bZM != null) {
            this.bZM.ZU();
        }
    }

    private void dK(boolean z) {
        if (com.baidu.swan.apps.z.a.es(z)) {
            com.baidu.swan.apps.z.a.a(getContext(), this.bZO, com.baidu.swan.apps.runtime.e.apN().apQ().aig().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.apN() != null) {
            com.baidu.swan.apps.z.a.a(this.bZO, com.baidu.swan.apps.runtime.e.apN().aqe().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dL(boolean z) {
        if (com.baidu.swan.apps.z.a.es(z)) {
            com.baidu.swan.apps.z.a.a(getContext(), this.bZP, com.baidu.swan.apps.runtime.e.apN().apQ().aig().paNumber);
        }
    }
}
