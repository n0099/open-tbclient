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
import com.baidu.swan.apps.adaptation.a.aa;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.as.z;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.ubc.Flow;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class d extends b implements a.InterfaceC0313a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bMd = af.C(149.0f);
    private static String bMk = "-1";
    private static String bMl = bMk;
    private static String bMm;
    private Flow bMe;
    private FrameLayout bMh;
    private com.baidu.swan.apps.adaptation.b.c bMi;
    private com.baidu.swan.apps.tabbar.b.a bMj;
    private com.baidu.swan.apps.runtime.config.c bMn;
    private com.baidu.swan.apps.core.f.c bMp;
    private aa bMq;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzr;
    private View mRootView;
    private com.baidu.swan.apps.model.b bMf = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bMg = new TreeMap();
    private int bMo = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VL();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bMq = com.baidu.swan.apps.w.a.acC();
                d.this.bMq.a(d.this.bLP, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.D("route", "fragment create.");
    }

    private void VL() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bLP = com.baidu.swan.apps.model.c.kI(arguments.getString("ai_apps_param"));
            this.bMf.mPage = this.bLP != null ? this.bLP.getPage() : "";
            this.bMf.mParams = this.bLP != null ? this.bLP.getParams() : "";
            this.bMn = com.baidu.swan.apps.y.f.aeK().ke(this.bMf.getPage());
            this.bMo = VB().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.D("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.bMh = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bMj = new com.baidu.swan.apps.tabbar.b.a(this);
        ai(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bMi.Qr());
        com.baidu.swan.apps.ac.f.agX().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Qx() {
        if (this.bMi != null) {
            return this.bMi.Qx();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        dn(Vz());
        if (VO()) {
            Vy();
        }
        Wa();
        this.bLR.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String QG = d.this.bMi.QG();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bG(QG, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.aeK().a(QG, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
        this.bMi.QA();
        QX();
        dr(true);
        this.bLS.j(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState(), VF());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vw() {
        VH();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c VJ = com.baidu.swan.apps.y.f.aeK().Wf().VJ();
        if (VJ != null && !TextUtils.isEmpty(VJ.getPage())) {
            fVar.s("page", VJ.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bMn)) {
            super.applyImmersion(i);
            return;
        }
        if (!VX() && z.cs(this.mActivity)) {
            z = false;
        }
        t(i, z);
        Wa();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean ey(int i) {
        boolean ey = super.ey(i);
        Wa();
        return ey;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        Wa();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dq(false);
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
        if (this.bLS != null && this.bLS.isShowing()) {
            this.bLS.fR(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bMi.QG())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bMi.QG())));
        }
    }

    public static void ii(String str) {
        bMm = str;
    }

    private void VM() {
        if (!TextUtils.equals(bMl, this.bMi.QG()) || TextUtils.equals(bMm, "switchTab")) {
            int nJ = this.bMj.nJ(VT().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.bSN = bMl;
            eVar.bSO = this.bMi.QG();
            eVar.bMD = bMm;
            eVar.bSP = this.bMf.mPage;
            eVar.bSQ = String.valueOf(nJ);
            bMm = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.bSN + " ,toId: " + eVar.bSO + " ,RouteType: " + eVar.bMD + " page:" + eVar.bSP + ",TabIndex: " + eVar.bSQ);
            }
            com.baidu.swan.apps.y.f.aeK().a(eVar);
            bMl = this.bMi.QG();
        }
    }

    private void ij(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bMi.QG());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bMi.QG());
        }
        com.baidu.swan.apps.y.f.aeK().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VI() {
        if (this.bMi == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bMi.QG());
        com.baidu.swan.apps.adaptation.b.f Qy = this.bMi.Qy();
        if (Qy != null) {
            hashMap.put("webViewUrl", Qy.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ai(View view) {
        com.baidu.swan.apps.performance.e.D("route", "createSlaveWebView start.");
        String aes = this.bLP.aes();
        String params = this.bLP.getParams();
        String page = this.bLP.getPage();
        String J = ai.J(aes, page, params);
        this.bMi = com.baidu.swan.apps.core.slave.b.iF(J);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + J + " is load: " + (this.bMi != null));
        }
        if (this.bMi == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bMi = o(aes, page, params, "");
        }
        this.bMi.a(this.bMh, com.baidu.swan.apps.y.f.aeK().ke(page));
        in(page);
        a(this.bMi);
        if (Vm()) {
            this.bMg.put(page, this.bMi);
            this.bMj.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.D("route", "createSlaveWebView end.");
        Wb();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bMg != null && !this.bMg.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bMg.values()) {
                if (cVar != null) {
                    cVar.QH();
                }
            }
        } else if (this.bMi != null) {
            this.bMi.QH();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bMg != null && !this.bMg.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bMg.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bMg.clear();
        } else if (this.bMi != null) {
            b(this.bMi);
            this.bMi.destroy();
        }
        this.bMi = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.F(com.baidu.swan.apps.y.f.aeK().aev());
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
                dq(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bMi == null;
        String QG = z ? "" : this.bMi.QG();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + QG);
        }
        if (!z) {
            this.bMi.onResume();
            VM();
            ij("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.dP(true);
        if (com.baidu.swan.apps.console.c.Tl()) {
            com.baidu.swan.apps.core.c.b.Vd();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Qx;
        boolean z = this.bMi == null;
        String QG = z ? "" : this.bMi.QG();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + QG);
        }
        if (!z) {
            this.bMi.onPause();
            ij("onHide");
        }
        if (Op() != null) {
            Op().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.dP(false);
        if (!z && (Qx = this.bMi.Qx()) != null) {
            Qx.er(false);
        }
    }

    public String ik(String str) {
        if (this.bMg.containsKey(str)) {
            return this.bMg.get(str).QG();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bMj.nJ(VT().getPage()) != this.bMj.nJ(bVar.mPage)) {
            this.bMj.nG(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bMg.get(bVar.mPage) == null) {
            String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c iF = com.baidu.swan.apps.core.slave.b.iF(J);
            if (iF != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + J);
                }
                this.bMg.put(bVar.mPage, iF);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                iF = o(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bMg.put(bVar.mPage, iF);
            }
            in(bVar.mPage);
            a(iF);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c o(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(aCO());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.bh("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bk("preload", G.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + G);
        }
        com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0285b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0285b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bQG = G.bQe.QC();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(G, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bQI = str2 + "?" + str3;
                } else {
                    bVar.bQI = str2;
                }
                if (com.baidu.swan.apps.runtime.e.akO() != null) {
                    bVar.bQF = com.baidu.swan.apps.runtime.e.akO().me(str2);
                }
                bVar.bQJ = com.baidu.swan.apps.y.f.aeK().ke(str2).bQJ;
                bVar.bQC = String.valueOf(com.baidu.swan.apps.console.a.Ti());
                if (com.baidu.swan.apps.runtime.e.akO() != null) {
                    String mg = com.baidu.swan.apps.runtime.e.akO().mg(str2);
                    if (!TextUtils.isEmpty(mg)) {
                        bVar.bQK = mg;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + mg);
                        }
                    }
                }
                bVar.bQE = d.DEBUG || com.baidu.swan.apps.y.f.aeK().aep();
                if (com.baidu.swan.apps.ah.a.a.aiL()) {
                    bVar.bQH = com.baidu.swan.apps.console.debugger.b.Tp();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bQL = str4;
                    com.baidu.swan.apps.performance.f.bh("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.apc();
                com.baidu.swan.apps.y.f.aeK().a(G.bQe.QG(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bw(G.bQe.QG(), bVar.bQI);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return G.bQe;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c ke = com.baidu.swan.apps.y.f.aeK().ke(TextUtils.isEmpty(str2) ? "" : str2);
        this.bMf.mPage = str2;
        this.bMf.mParams = bVar != null ? bVar.getParams() : "";
        this.bMn = ke;
        boolean z = false;
        if (im(str2)) {
            il(str2);
        } else {
            z = true;
            a(bVar, str);
            il(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.R(7, str);
            } else {
                com.baidu.swan.apps.performance.g.R(6, str);
            }
            com.baidu.swan.apps.performance.f.bh("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.lo(str);
        }
        ig(ke.cph);
        ih(ke.cpi);
        ey(ke.cpg);
        Wa();
        Wd();
    }

    private void il(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bMg.get(str);
        if (this.bMi != cVar) {
            if (!cVar.Qw()) {
                cVar.a(this.bMh, com.baidu.swan.apps.y.f.aeK().ke(str));
            }
            cVar.ea(0);
            if (this.bMi != null) {
                this.bMi.ea(8);
            }
            this.bMi = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bMh;
    }

    private boolean im(String str) {
        return (this.bMg.isEmpty() || this.bMg.get(str) == null) ? false : true;
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
        return Vz() && this.bMi.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vm() {
        SwanAppConfigData aeq;
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        if (aeK == null || (aeq = aeK.aeq()) == null || !aeq.alC() || this.bLP == null) {
            return false;
        }
        return aeq.mp(this.bLP.getPage());
    }

    public boolean VN() {
        if (this.bMj == null) {
            return false;
        }
        return this.bMj.VN();
    }

    protected final boolean VO() {
        SwanAppConfigData aeq;
        e Ou = Ou();
        if (Ou == null) {
            return false;
        }
        return ((this.bMn != null && this.bMn.cpo) || (aeq = com.baidu.swan.apps.y.f.aeK().aeq()) == null || a(Ou, aeq)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b eB = eVar.eB(0);
        if (eB == null || !(eB instanceof d)) {
            return false;
        }
        String page = ((d) eB).VT().getPage();
        return swanAppConfigData.mp(page) || TextUtils.equals(swanAppConfigData.aeu(), page);
    }

    private boolean VP() {
        SwanAppConfigData aeq = com.baidu.swan.apps.y.f.aeK().aeq();
        return (aeq == null || TextUtils.equals(aeq.aeu(), this.bMf.getPage())) ? false : true;
    }

    public String VQ() {
        return this.bMi != null ? this.bMi.QG() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        if (com.baidu.g.a.KK()) {
            return true;
        }
        if (this.bMi != null) {
            if (com.baidu.swan.apps.media.b.kh(this.bMi.QG())) {
                return true;
            }
            return this.bMi.Qz();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void QX() {
        FragmentActivity aCO = aCO();
        if (aCO != null && this.bLS == null) {
            this.bLS = new com.baidu.swan.menu.h(aCO, this.bLR, QY(), com.baidu.swan.apps.w.a.abS(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLS, this).agt();
        }
    }

    private int QY() {
        return VG() ? VP() ? 18 : 17 : VP() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> VR() {
        if (this.bMi == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bMi.QE().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a VS() {
        return this.bMj;
    }

    public com.baidu.swan.apps.model.b VT() {
        return this.bMf;
    }

    public com.baidu.swan.apps.adaptation.b.c VU() {
        return this.bMi;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0313a
    public com.baidu.swan.apps.res.widget.floatlayer.a Op() {
        if (this.bzr == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bzr = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), VB().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bzr;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c VA() {
        return this.bMn;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b VV() {
        return this.bLW;
    }

    private boolean VW() {
        return this.bMn != null && this.bMn.cpl;
    }

    private boolean VX() {
        if (this.bMn == null) {
            return false;
        }
        return TextUtils.equals(this.bMn.cpn, "custom");
    }

    private void in(String str) {
        if (!VX()) {
            com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aeK.ke(str).cpl && this.bMp == null) {
                this.bMp = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.eA(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.bMp != null) {
                cVar.a(this.bMp);
            }
            cVar.a(VY());
        }
    }

    private com.baidu.swan.apps.core.f.e VY() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bMp);
                    fVar.a(d.this.VZ());
                    com.baidu.swan.apps.ac.f.agX().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bMp);
                    com.baidu.swan.apps.ac.f.agX().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a VZ() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ff(String str) {
                d.this.ig(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bMp != null && cVar != null) {
            cVar.b(this.bMp);
            if (cVar.Qy() != null) {
                cVar.b(this.bMp);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Wa() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bLR != null) {
            if (VX()) {
                m27do(true);
                i = 0;
                z = true;
            } else if (VW()) {
                m27do(false);
                if (this.bMi != null) {
                    if (this.bMi.Qy() != null) {
                        dVar = this.bMi.Qy().QE();
                    } else {
                        dVar = this.bMi.QE();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bMn == null && this.bMn.cpm) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bMn == null) {
                }
                z = true;
            } else {
                m27do(false);
                i = bMd + this.bMo;
            }
            TextView centerTitleView = this.bLR.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            eA(i);
            dp(z);
        }
    }

    private void dp(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bLW == null || !this.bLW.apH()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = VB().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMh.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bMh.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bLQ.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bLQ.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(int i) {
        TextView centerTitleView;
        View apG;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bMd) * 1.0f) / (this.bMo == 0 ? 1 : this.bMo);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bLW != null && this.bLW.apH() && (apG = this.bLW.apG()) != null && (background = apG.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bLR.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bMn != null && this.bMn.cpm && (centerTitleView = this.bLR.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bLU.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Wb() {
        this.bMe = com.baidu.swan.apps.statistic.f.mT("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bMe != null) {
            com.baidu.swan.apps.statistic.f.a(this.bMe, gVar);
            this.bMe = null;
        }
    }

    public void Wc() {
        this.bMn.cpn = "default";
        applyImmersion();
        Wa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wd() {
        if (this.bLP != null) {
            this.bLP.Wd();
        }
    }

    private void dq(boolean z) {
        if (com.baidu.swan.apps.ab.a.dW(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bLR, com.baidu.swan.apps.runtime.e.akO().akQ().adR().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.akO() != null) {
            com.baidu.swan.apps.ab.a.a(this.bLR, com.baidu.swan.apps.runtime.e.akO().ald().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dr(boolean z) {
        if (com.baidu.swan.apps.ab.a.dW(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bLS, com.baidu.swan.apps.runtime.e.akO().akQ().adR().paNumber);
        }
    }
}
