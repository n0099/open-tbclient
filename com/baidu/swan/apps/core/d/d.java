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
public class d extends b implements a.InterfaceC0334a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bMi = af.C(149.0f);
    private static String bMp = "-1";
    private static String bMq = bMp;
    private static String bMr;
    private Flow bMj;
    private FrameLayout bMm;
    private com.baidu.swan.apps.adaptation.b.c bMn;
    private com.baidu.swan.apps.tabbar.b.a bMo;
    private com.baidu.swan.apps.runtime.config.c bMs;
    private com.baidu.swan.apps.core.f.c bMu;
    private aa bMv;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzw;
    private View mRootView;
    private com.baidu.swan.apps.model.b bMk = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bMl = new TreeMap();
    private int bMt = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VK();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bMv = com.baidu.swan.apps.w.a.acB();
                d.this.bMv.a(d.this.bLU, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.D("route", "fragment create.");
    }

    private void VK() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bLU = com.baidu.swan.apps.model.c.kI(arguments.getString("ai_apps_param"));
            this.bMk.mPage = this.bLU != null ? this.bLU.getPage() : "";
            this.bMk.mParams = this.bLU != null ? this.bLU.getParams() : "";
            this.bMs = com.baidu.swan.apps.y.f.aeJ().ke(this.bMk.getPage());
            this.bMt = VA().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.bMm = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bMo = new com.baidu.swan.apps.tabbar.b.a(this);
        ai(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bMn.Qq());
        com.baidu.swan.apps.ac.f.agW().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Qw() {
        if (this.bMn != null) {
            return this.bMn.Qw();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        dn(Vy());
        if (VN()) {
            Vx();
        }
        VZ();
        this.bLW.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String QF = d.this.bMn.QF();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bG(QF, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.aeJ().a(QF, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
        this.bMn.Qz();
        QW();
        dr(true);
        this.bLX.j(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState(), VE());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vv() {
        VG();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c VI = com.baidu.swan.apps.y.f.aeJ().We().VI();
        if (VI != null && !TextUtils.isEmpty(VI.getPage())) {
            fVar.s("page", VI.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bMs)) {
            super.applyImmersion(i);
            return;
        }
        if (!VW() && z.cg(this.mActivity)) {
            z = false;
        }
        t(i, z);
        VZ();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean ey(int i) {
        boolean ey = super.ey(i);
        VZ();
        return ey;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        VZ();
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
        if (this.bLX != null && this.bLX.isShowing()) {
            this.bLX.fR(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bMn.QF())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bMn.QF())));
        }
    }

    public static void ii(String str) {
        bMr = str;
    }

    private void VL() {
        if (!TextUtils.equals(bMq, this.bMn.QF()) || TextUtils.equals(bMr, "switchTab")) {
            int nJ = this.bMo.nJ(VS().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.bST = bMq;
            eVar.bSU = this.bMn.QF();
            eVar.bMI = bMr;
            eVar.bSV = this.bMk.mPage;
            eVar.bSW = String.valueOf(nJ);
            bMr = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.bST + " ,toId: " + eVar.bSU + " ,RouteType: " + eVar.bMI + " page:" + eVar.bSV + ",TabIndex: " + eVar.bSW);
            }
            com.baidu.swan.apps.y.f.aeJ().a(eVar);
            bMq = this.bMn.QF();
        }
    }

    private void ij(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bMn.QF());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bMn.QF());
        }
        com.baidu.swan.apps.y.f.aeJ().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void VH() {
        if (this.bMn == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bMn.QF());
        com.baidu.swan.apps.adaptation.b.f Qx = this.bMn.Qx();
        if (Qx != null) {
            hashMap.put("webViewUrl", Qx.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ai(View view) {
        com.baidu.swan.apps.performance.e.D("route", "createSlaveWebView start.");
        String aer = this.bLU.aer();
        String params = this.bLU.getParams();
        String page = this.bLU.getPage();
        String J = ai.J(aer, page, params);
        this.bMn = com.baidu.swan.apps.core.slave.b.iF(J);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + J + " is load: " + (this.bMn != null));
        }
        if (this.bMn == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bMn = o(aer, page, params, "");
        }
        this.bMn.a(this.bMm, com.baidu.swan.apps.y.f.aeJ().ke(page));
        in(page);
        a(this.bMn);
        if (Vl()) {
            this.bMl.put(page, this.bMn);
            this.bMo.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.D("route", "createSlaveWebView end.");
        Wa();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bMl != null && !this.bMl.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bMl.values()) {
                if (cVar != null) {
                    cVar.QG();
                }
            }
        } else if (this.bMn != null) {
            this.bMn.QG();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bMl != null && !this.bMl.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bMl.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bMl.clear();
        } else if (this.bMn != null) {
            b(this.bMn);
            this.bMn.destroy();
        }
        this.bMn = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.F(com.baidu.swan.apps.y.f.aeJ().aeu());
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
        boolean z = this.bMn == null;
        String QF = z ? "" : this.bMn.QF();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + QF);
        }
        if (!z) {
            this.bMn.onResume();
            VL();
            ij("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.dP(true);
        if (com.baidu.swan.apps.console.c.Tk()) {
            com.baidu.swan.apps.core.c.b.Vc();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Qw;
        boolean z = this.bMn == null;
        String QF = z ? "" : this.bMn.QF();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + QF);
        }
        if (!z) {
            this.bMn.onPause();
            ij("onHide");
        }
        if (Oo() != null) {
            Oo().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.dP(false);
        if (!z && (Qw = this.bMn.Qw()) != null) {
            Qw.er(false);
        }
    }

    public String ik(String str) {
        if (this.bMl.containsKey(str)) {
            return this.bMl.get(str).QF();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bMo.nJ(VS().getPage()) != this.bMo.nJ(bVar.mPage)) {
            this.bMo.nG(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bMl.get(bVar.mPage) == null) {
            String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c iF = com.baidu.swan.apps.core.slave.b.iF(J);
            if (iF != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + J);
                }
                this.bMl.put(bVar.mPage, iF);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                iF = o(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bMl.put(bVar.mPage, iF);
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
        com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0306b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0306b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bQL = G.bQj.QB();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(G, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bQN = str2 + "?" + str3;
                } else {
                    bVar.bQN = str2;
                }
                if (com.baidu.swan.apps.runtime.e.akN() != null) {
                    bVar.bQK = com.baidu.swan.apps.runtime.e.akN().me(str2);
                }
                bVar.bQO = com.baidu.swan.apps.y.f.aeJ().ke(str2).bQO;
                bVar.bQH = String.valueOf(com.baidu.swan.apps.console.a.Th());
                if (com.baidu.swan.apps.runtime.e.akN() != null) {
                    String mg = com.baidu.swan.apps.runtime.e.akN().mg(str2);
                    if (!TextUtils.isEmpty(mg)) {
                        bVar.bQP = mg;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + mg);
                        }
                    }
                }
                bVar.bQJ = d.DEBUG || com.baidu.swan.apps.y.f.aeJ().aeo();
                if (com.baidu.swan.apps.ah.a.a.aiK()) {
                    bVar.bQM = com.baidu.swan.apps.console.debugger.b.To();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bQQ = str4;
                    com.baidu.swan.apps.performance.f.bh("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.apb();
                com.baidu.swan.apps.y.f.aeJ().a(G.bQj.QF(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bw(G.bQj.QF(), bVar.bQN);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return G.bQj;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c ke = com.baidu.swan.apps.y.f.aeJ().ke(TextUtils.isEmpty(str2) ? "" : str2);
        this.bMk.mPage = str2;
        this.bMk.mParams = bVar != null ? bVar.getParams() : "";
        this.bMs = ke;
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
        ig(ke.cpn);
        ih(ke.cpo);
        ey(ke.cpm);
        VZ();
        Wc();
    }

    private void il(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bMl.get(str);
        if (this.bMn != cVar) {
            if (!cVar.Qv()) {
                cVar.a(this.bMm, com.baidu.swan.apps.y.f.aeJ().ke(str));
            }
            cVar.ea(0);
            if (this.bMn != null) {
                this.bMn.ea(8);
            }
            this.bMn = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bMm;
    }

    private boolean im(String str) {
        return (this.bMl.isEmpty() || this.bMl.get(str) == null) ? false : true;
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
        return Vy() && this.bMn.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        SwanAppConfigData aep;
        com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        if (aeJ == null || (aep = aeJ.aep()) == null || !aep.alB() || this.bLU == null) {
            return false;
        }
        return aep.mp(this.bLU.getPage());
    }

    public boolean VM() {
        if (this.bMo == null) {
            return false;
        }
        return this.bMo.VM();
    }

    protected final boolean VN() {
        SwanAppConfigData aep;
        e Ot = Ot();
        if (Ot == null) {
            return false;
        }
        return ((this.bMs != null && this.bMs.cpv) || (aep = com.baidu.swan.apps.y.f.aeJ().aep()) == null || a(Ot, aep)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b eB = eVar.eB(0);
        if (eB == null || !(eB instanceof d)) {
            return false;
        }
        String page = ((d) eB).VS().getPage();
        return swanAppConfigData.mp(page) || TextUtils.equals(swanAppConfigData.aet(), page);
    }

    private boolean VO() {
        SwanAppConfigData aep = com.baidu.swan.apps.y.f.aeJ().aep();
        return (aep == null || TextUtils.equals(aep.aet(), this.bMk.getPage())) ? false : true;
    }

    public String VP() {
        return this.bMn != null ? this.bMn.QF() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        if (com.baidu.g.a.KJ()) {
            return true;
        }
        if (this.bMn != null) {
            if (com.baidu.swan.apps.media.b.kh(this.bMn.QF())) {
                return true;
            }
            return this.bMn.Qy();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void QW() {
        FragmentActivity aCO = aCO();
        if (aCO != null && this.bLX == null) {
            this.bLX = new com.baidu.swan.menu.h(aCO, this.bLW, QX(), com.baidu.swan.apps.w.a.abR(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLX, this).ags();
        }
    }

    private int QX() {
        return VF() ? VO() ? 18 : 17 : VO() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> VQ() {
        if (this.bMn == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bMn.QD().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a VR() {
        return this.bMo;
    }

    public com.baidu.swan.apps.model.b VS() {
        return this.bMk;
    }

    public com.baidu.swan.apps.adaptation.b.c VT() {
        return this.bMn;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0334a
    public com.baidu.swan.apps.res.widget.floatlayer.a Oo() {
        if (this.bzw == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bzw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), VA().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bzw;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c Vz() {
        return this.bMs;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b VU() {
        return this.bMb;
    }

    private boolean VV() {
        return this.bMs != null && this.bMs.cpr;
    }

    private boolean VW() {
        if (this.bMs == null) {
            return false;
        }
        return TextUtils.equals(this.bMs.cpt, "custom");
    }

    private void in(String str) {
        if (!VW()) {
            com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aeJ.ke(str).cpr && this.bMu == null) {
                this.bMu = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
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
            if (this.bMu != null) {
                cVar.a(this.bMu);
            }
            cVar.a(VX());
        }
    }

    private com.baidu.swan.apps.core.f.e VX() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bMu);
                    fVar.a(d.this.VY());
                    com.baidu.swan.apps.ac.f.agW().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bMu);
                    com.baidu.swan.apps.ac.f.agW().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a VY() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ff(String str) {
                d.this.ig(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bMu != null && cVar != null) {
            cVar.b(this.bMu);
            if (cVar.Qx() != null) {
                cVar.b(this.bMu);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void VZ() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bLW != null) {
            if (VW()) {
                m27do(true);
                i = 0;
                z = true;
            } else if (VV()) {
                m27do(false);
                if (this.bMn != null) {
                    if (this.bMn.Qx() != null) {
                        dVar = this.bMn.Qx().QD();
                    } else {
                        dVar = this.bMn.QD();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bMs == null && this.bMs.cps) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bMs == null) {
                }
                z = true;
            } else {
                m27do(false);
                i = bMi + this.bMt;
            }
            TextView centerTitleView = this.bLW.getCenterTitleView();
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
            if (this.bMb == null || !this.bMb.apG()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = VA().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMm.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bMm.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bLV.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bLV.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(int i) {
        TextView centerTitleView;
        View apF;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bMi) * 1.0f) / (this.bMt == 0 ? 1 : this.bMt);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bMb != null && this.bMb.apG() && (apF = this.bMb.apF()) != null && (background = apF.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bLW.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bMs != null && this.bMs.cps && (centerTitleView = this.bLW.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bLZ.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Wa() {
        this.bMj = com.baidu.swan.apps.statistic.f.mT("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bMj != null) {
            com.baidu.swan.apps.statistic.f.a(this.bMj, gVar);
            this.bMj = null;
        }
    }

    public void Wb() {
        this.bMs.cpt = "default";
        applyImmersion();
        VZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wc() {
        if (this.bLU != null) {
            this.bLU.Wc();
        }
    }

    private void dq(boolean z) {
        if (com.baidu.swan.apps.ab.a.dW(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bLW, com.baidu.swan.apps.runtime.e.akN().akP().adQ().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.akN() != null) {
            com.baidu.swan.apps.ab.a.a(this.bLW, com.baidu.swan.apps.runtime.e.akN().alc().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dr(boolean z) {
        if (com.baidu.swan.apps.ab.a.dW(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bLX, com.baidu.swan.apps.runtime.e.akN().akP().adQ().paNumber);
        }
    }
}
