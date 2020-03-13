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
public class d extends b implements a.InterfaceC0283a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bnK = af.S(149.0f);
    private static String bnR = "-1";
    private static String bnS = bnR;
    private static String bnT;
    private com.baidu.swan.apps.res.widget.floatlayer.a baQ;
    private Flow bnL;
    private FrameLayout bnO;
    private com.baidu.swan.apps.adaptation.b.c bnP;
    private com.baidu.swan.apps.tabbar.b.a bnQ;
    private com.baidu.swan.apps.runtime.config.c bnU;
    private com.baidu.swan.apps.core.f.c bnW;
    private aa bnX;
    private View mRootView;
    private com.baidu.swan.apps.model.b bnM = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bnN = new TreeMap();
    private int bnV = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bnX = com.baidu.swan.apps.w.a.UK();
                d.this.bnX.a(d.this.bnv, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.z("route", "fragment create.");
    }

    private void NU() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bnv = com.baidu.swan.apps.model.c.jw(arguments.getString("ai_apps_param"));
            this.bnM.mPage = this.bnv != null ? this.bnv.getPage() : "";
            this.bnM.mParams = this.bnv != null ? this.bnv.getParams() : "";
            this.bnU = com.baidu.swan.apps.y.f.WS().iS(this.bnM.getPage());
            this.bnV = NK().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.z("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.bnO = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bnQ = new com.baidu.swan.apps.tabbar.b.a(this);
        ah(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bnP.IC());
        com.baidu.swan.apps.ac.f.YO().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView II() {
        if (this.bnP != null) {
            return this.bnP.II();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        cq(NI());
        if (NX()) {
            NH();
        }
        Oj();
        this.bnx.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String IR = d.this.bnP.IR();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bw(IR, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.WS().a(IR, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
        this.bnP.IL();
        Ji();
        cu(true);
        this.bny.i(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState(), NO());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void NG() {
        NQ();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c NS = com.baidu.swan.apps.y.f.WS().Oo().NS();
        if (NS != null && !TextUtils.isEmpty(NS.getPage())) {
            fVar.n("page", NS.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bnU)) {
            super.applyImmersion(i);
            return;
        }
        if (!Og() && z.cF(this.mActivity)) {
            z = false;
        }
        p(i, z);
        Oj();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean et(int i) {
        boolean et = super.et(i);
        Oj();
        return et;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        Oj();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        ct(false);
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
        if (this.bny != null && this.bny.isShowing()) {
            this.bny.eT(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bnP.IR())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bnP.IR())));
        }
    }

    public static void gV(String str) {
        bnT = str;
    }

    private void NV() {
        if (!TextUtils.equals(bnS, this.bnP.IR()) || TextUtils.equals(bnT, "switchTab")) {
            int mx = this.bnQ.mx(Oc().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.buv = bnS;
            eVar.buw = this.bnP.IR();
            eVar.bok = bnT;
            eVar.bux = this.bnM.mPage;
            eVar.buy = String.valueOf(mx);
            bnT = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.buv + " ,toId: " + eVar.buw + " ,RouteType: " + eVar.bok + " page:" + eVar.bux + ",TabIndex: " + eVar.buy);
            }
            com.baidu.swan.apps.y.f.WS().a(eVar);
            bnS = this.bnP.IR();
        }
    }

    private void gW(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bnP.IR());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bnP.IR());
        }
        com.baidu.swan.apps.y.f.WS().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NR() {
        if (this.bnP == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bnP.IR());
        com.baidu.swan.apps.adaptation.b.f IJ = this.bnP.IJ();
        if (IJ != null) {
            hashMap.put("webViewUrl", IJ.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ah(View view) {
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView start.");
        String WA = this.bnv.WA();
        String params = this.bnv.getParams();
        String page = this.bnv.getPage();
        String J = ai.J(WA, page, params);
        this.bnP = com.baidu.swan.apps.core.slave.b.hs(J);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + J + " is load: " + (this.bnP != null));
        }
        if (this.bnP == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bnP = o(WA, page, params, "");
        }
        this.bnP.a(this.bnO, com.baidu.swan.apps.y.f.WS().iS(page));
        ha(page);
        a(this.bnP);
        if (Nw()) {
            this.bnN.put(page, this.bnP);
            this.bnQ.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView end.");
        Ok();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bnN != null && !this.bnN.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnN.values()) {
                if (cVar != null) {
                    cVar.IS();
                }
            }
        } else if (this.bnP != null) {
            this.bnP.IS();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bnN != null && !this.bnN.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnN.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bnN.clear();
        } else if (this.bnP != null) {
            b(this.bnP);
            this.bnP.destroy();
        }
        this.bnP = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.J(com.baidu.swan.apps.y.f.WS().WD());
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
                ct(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bnP == null;
        String IR = z ? "" : this.bnP.IR();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + IR);
        }
        if (!z) {
            this.bnP.onResume();
            NV();
            gW("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.cS(true);
        if (com.baidu.swan.apps.console.c.Lu()) {
            com.baidu.swan.apps.core.c.b.Nn();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView II;
        boolean z = this.bnP == null;
        String IR = z ? "" : this.bnP.IR();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + IR);
        }
        if (!z) {
            this.bnP.onPause();
            gW("onHide");
        }
        if (Gx() != null) {
            Gx().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.cS(false);
        if (!z && (II = this.bnP.II()) != null) {
            II.du(false);
        }
    }

    public String gX(String str) {
        if (this.bnN.containsKey(str)) {
            return this.bnN.get(str).IR();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bnQ.mx(Oc().getPage()) != this.bnQ.mx(bVar.mPage)) {
            this.bnQ.mu(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bnN.get(bVar.mPage) == null) {
            String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c hs = com.baidu.swan.apps.core.slave.b.hs(J);
            if (hs != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + J);
                }
                this.bnN.put(bVar.mPage, hs);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                hs = o(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bnN.put(bVar.mPage, hs);
            }
            ha(bVar.mPage);
            a(hs);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c o(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a K = com.baidu.swan.apps.core.slave.b.K(auA());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.aY("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bb("preload", K.brM ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + K);
        }
        com.baidu.swan.apps.core.slave.b.a(K, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bso = K.brL.IN();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(K, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bsq = str2 + "?" + str3;
                } else {
                    bVar.bsq = str2;
                }
                if (com.baidu.swan.apps.runtime.e.acG() != null) {
                    bVar.bsn = com.baidu.swan.apps.runtime.e.acG().kS(str2);
                }
                bVar.bsr = com.baidu.swan.apps.y.f.WS().iS(str2).bsr;
                bVar.bsk = String.valueOf(com.baidu.swan.apps.console.a.Lr());
                if (com.baidu.swan.apps.runtime.e.acG() != null) {
                    String kU = com.baidu.swan.apps.runtime.e.acG().kU(str2);
                    if (!TextUtils.isEmpty(kU)) {
                        bVar.bss = kU;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + kU);
                        }
                    }
                }
                bVar.bsm = d.DEBUG || com.baidu.swan.apps.y.f.WS().Wx();
                if (com.baidu.swan.apps.ah.a.a.aaD()) {
                    bVar.bsp = com.baidu.swan.apps.console.debugger.b.Ly();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bst = str4;
                    com.baidu.swan.apps.performance.f.aY("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.agS();
                com.baidu.swan.apps.y.f.WS().a(K.brL.IR(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bn(K.brL.IR(), bVar.bsq);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return K.brL;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c iS = com.baidu.swan.apps.y.f.WS().iS(TextUtils.isEmpty(str2) ? "" : str2);
        this.bnM.mPage = str2;
        this.bnM.mParams = bVar != null ? bVar.getParams() : "";
        this.bnU = iS;
        boolean z = false;
        if (gZ(str2)) {
            gY(str2);
        } else {
            z = true;
            a(bVar, str);
            gY(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.A(7, str);
            } else {
                com.baidu.swan.apps.performance.g.A(6, str);
            }
            com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.kc(str);
        }
        gT(iS.bQk);
        gU(iS.bQl);
        et(iS.bQj);
        Oj();
        Om();
    }

    private void gY(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bnN.get(str);
        if (this.bnP != cVar) {
            if (!cVar.IH()) {
                cVar.a(this.bnO, com.baidu.swan.apps.y.f.WS().iS(str));
            }
            cVar.dV(0);
            if (this.bnP != null) {
                this.bnP.dV(8);
            }
            this.bnP = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bnO;
    }

    private boolean gZ(String str) {
        return (this.bnN.isEmpty() || this.bnN.get(str) == null) ? false : true;
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
        return NI() && this.bnP.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nw() {
        SwanAppConfigData Wy;
        com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        if (WS == null || (Wy = WS.Wy()) == null || !Wy.adu() || this.bnv == null) {
            return false;
        }
        return Wy.ld(this.bnv.getPage());
    }

    public boolean NW() {
        if (this.bnQ == null) {
            return false;
        }
        return this.bnQ.NW();
    }

    protected final boolean NX() {
        SwanAppConfigData Wy;
        e GC = GC();
        if (GC == null) {
            return false;
        }
        return ((this.bnU != null && this.bnU.bQr) || (Wy = com.baidu.swan.apps.y.f.WS().Wy()) == null || a(GC, Wy)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b ew = eVar.ew(0);
        if (ew == null || !(ew instanceof d)) {
            return false;
        }
        String page = ((d) ew).Oc().getPage();
        return swanAppConfigData.ld(page) || TextUtils.equals(swanAppConfigData.WC(), page);
    }

    private boolean NY() {
        SwanAppConfigData Wy = com.baidu.swan.apps.y.f.WS().Wy();
        return (Wy == null || TextUtils.equals(Wy.WC(), this.bnM.getPage())) ? false : true;
    }

    public String NZ() {
        return this.bnP != null ? this.bnP.IR() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        if (com.baidu.j.a.Es()) {
            return true;
        }
        if (this.bnP != null) {
            if (com.baidu.swan.apps.media.b.iV(this.bnP.IR())) {
                return true;
            }
            return this.bnP.IK();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Ji() {
        FragmentActivity auA = auA();
        if (auA != null && this.bny == null) {
            this.bny = new com.baidu.swan.menu.h(auA, this.bnx, Jj(), com.baidu.swan.apps.w.a.Ua(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bny, this).Yk();
        }
    }

    private int Jj() {
        return NP() ? NY() ? 18 : 17 : NY() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> Oa() {
        if (this.bnP == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bnP.IP().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Ob() {
        return this.bnQ;
    }

    public com.baidu.swan.apps.model.b Oc() {
        return this.bnM;
    }

    public com.baidu.swan.apps.adaptation.b.c Od() {
        return this.bnP;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a Gx() {
        if (this.baQ == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.baQ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), NK().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.baQ;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c NJ() {
        return this.bnU;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Oe() {
        return this.bnC;
    }

    private boolean Of() {
        return this.bnU != null && this.bnU.bQo;
    }

    private boolean Og() {
        if (this.bnU == null) {
            return false;
        }
        return TextUtils.equals(this.bnU.bQq, "custom");
    }

    private void ha(String str) {
        if (!Og()) {
            com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (WS.iS(str).bQo && this.bnW == null) {
                this.bnW = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.ev(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.bnW != null) {
                cVar.a(this.bnW);
            }
            cVar.a(Oh());
        }
    }

    private com.baidu.swan.apps.core.f.e Oh() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bnW);
                    fVar.a(d.this.Oi());
                    com.baidu.swan.apps.ac.f.YO().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bnW);
                    com.baidu.swan.apps.ac.f.YO().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Oi() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void en(String str) {
                d.this.gT(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bnW != null && cVar != null) {
            cVar.b(this.bnW);
            if (cVar.IJ() != null) {
                cVar.b(this.bnW);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Oj() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bnx != null) {
            if (Og()) {
                cr(true);
                i = 0;
                z = true;
            } else if (Of()) {
                cr(false);
                if (this.bnP != null) {
                    if (this.bnP.IJ() != null) {
                        dVar = this.bnP.IJ().IP();
                    } else {
                        dVar = this.bnP.IP();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bnU == null && this.bnU.bQp) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bnU == null) {
                }
                z = true;
            } else {
                cr(false);
                i = bnK + this.bnV;
            }
            TextView centerTitleView = this.bnx.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ev(i);
            cs(z);
        }
    }

    private void cs(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bnC == null || !this.bnC.ahw()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = NK().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bnO.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bnO.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bnw.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bnw.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        TextView centerTitleView;
        View ahv;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bnK) * 1.0f) / (this.bnV == 0 ? 1 : this.bnV);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bnC != null && this.bnC.ahw() && (ahv = this.bnC.ahv()) != null && (background = ahv.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bnx.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bnU != null && this.bnU.bQp && (centerTitleView = this.bnx.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bnA.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Ok() {
        this.bnL = com.baidu.swan.apps.statistic.f.lH("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bnL != null) {
            com.baidu.swan.apps.statistic.f.a(this.bnL, gVar);
            this.bnL = null;
        }
    }

    public void Ol() {
        this.bnU.bQq = "default";
        applyImmersion();
        Oj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Om() {
        if (this.bnv != null) {
            this.bnv.Om();
        }
    }

    private void ct(boolean z) {
        if (com.baidu.swan.apps.ab.a.cZ(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bnx, com.baidu.swan.apps.runtime.e.acG().acI().VZ().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.acG() != null) {
            com.baidu.swan.apps.ab.a.a(this.bnx, com.baidu.swan.apps.runtime.e.acG().acV().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void cu(boolean z) {
        if (com.baidu.swan.apps.ab.a.cZ(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bny, com.baidu.swan.apps.runtime.e.acG().acI().VZ().paNumber);
        }
    }
}
