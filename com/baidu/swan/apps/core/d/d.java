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
    private static final int bnW = af.S(149.0f);
    private static String bod = "-1";
    private static String boe = bod;
    private static String bof;
    private com.baidu.swan.apps.res.widget.floatlayer.a bbd;
    private Flow bnX;
    private FrameLayout boa;
    private com.baidu.swan.apps.adaptation.b.c bob;
    private com.baidu.swan.apps.tabbar.b.a boc;
    private com.baidu.swan.apps.runtime.config.c bog;
    private com.baidu.swan.apps.core.f.c boi;
    private aa boj;
    private View mRootView;
    private com.baidu.swan.apps.model.b bnY = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bnZ = new TreeMap();
    private int boh = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NX();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.boj = com.baidu.swan.apps.w.a.UN();
                d.this.boj.a(d.this.bnI, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.z("route", "fragment create.");
    }

    private void NX() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bnI = com.baidu.swan.apps.model.c.jv(arguments.getString("ai_apps_param"));
            this.bnY.mPage = this.bnI != null ? this.bnI.getPage() : "";
            this.bnY.mParams = this.bnI != null ? this.bnI.getParams() : "";
            this.bog = com.baidu.swan.apps.y.f.WV().iR(this.bnY.getPage());
            this.boh = NN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.boa = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.boc = new com.baidu.swan.apps.tabbar.b.a(this);
        ah(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bob.IF());
        com.baidu.swan.apps.ac.f.YR().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView IL() {
        if (this.bob != null) {
            return this.bob.IL();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        cr(NL());
        if (Oa()) {
            NK();
        }
        Om();
        this.bnK.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String IU = d.this.bob.IU();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bv(IU, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.WV().a(IU, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
        this.bob.IO();
        Jl();
        cv(true);
        this.bnL.i(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState(), NR());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void NJ() {
        NT();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c NV = com.baidu.swan.apps.y.f.WV().Or().NV();
        if (NV != null && !TextUtils.isEmpty(NV.getPage())) {
            fVar.n("page", NV.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bog)) {
            super.applyImmersion(i);
            return;
        }
        if (!Oj() && z.cE(this.mActivity)) {
            z = false;
        }
        p(i, z);
        Om();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean et(int i) {
        boolean et = super.et(i);
        Om();
        return et;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        Om();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        cu(false);
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
        if (this.bnL != null && this.bnL.isShowing()) {
            this.bnL.eU(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bob.IU())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bob.IU())));
        }
    }

    public static void gU(String str) {
        bof = str;
    }

    private void NY() {
        if (!TextUtils.equals(boe, this.bob.IU()) || TextUtils.equals(bof, "switchTab")) {
            int mw = this.boc.mw(Of().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.buH = boe;
            eVar.buI = this.bob.IU();
            eVar.bow = bof;
            eVar.buJ = this.bnY.mPage;
            eVar.buK = String.valueOf(mw);
            bof = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.buH + " ,toId: " + eVar.buI + " ,RouteType: " + eVar.bow + " page:" + eVar.buJ + ",TabIndex: " + eVar.buK);
            }
            com.baidu.swan.apps.y.f.WV().a(eVar);
            boe = this.bob.IU();
        }
    }

    private void gV(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bob.IU());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bob.IU());
        }
        com.baidu.swan.apps.y.f.WV().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NU() {
        if (this.bob == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bob.IU());
        com.baidu.swan.apps.adaptation.b.f IM = this.bob.IM();
        if (IM != null) {
            hashMap.put("webViewUrl", IM.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ah(View view) {
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView start.");
        String WD = this.bnI.WD();
        String params = this.bnI.getParams();
        String page = this.bnI.getPage();
        String J = ai.J(WD, page, params);
        this.bob = com.baidu.swan.apps.core.slave.b.hr(J);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + J + " is load: " + (this.bob != null));
        }
        if (this.bob == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bob = o(WD, page, params, "");
        }
        this.bob.a(this.boa, com.baidu.swan.apps.y.f.WV().iR(page));
        gZ(page);
        a(this.bob);
        if (Nz()) {
            this.bnZ.put(page, this.bob);
            this.boc.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView end.");
        On();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bnZ != null && !this.bnZ.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnZ.values()) {
                if (cVar != null) {
                    cVar.IV();
                }
            }
        } else if (this.bob != null) {
            this.bob.IV();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bnZ != null && !this.bnZ.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnZ.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bnZ.clear();
        } else if (this.bob != null) {
            b(this.bob);
            this.bob.destroy();
        }
        this.bob = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.J(com.baidu.swan.apps.y.f.WV().WG());
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
                cu(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bob == null;
        String IU = z ? "" : this.bob.IU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + IU);
        }
        if (!z) {
            this.bob.onResume();
            NY();
            gV("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.cT(true);
        if (com.baidu.swan.apps.console.c.Lx()) {
            com.baidu.swan.apps.core.c.b.Nq();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView IL;
        boolean z = this.bob == null;
        String IU = z ? "" : this.bob.IU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + IU);
        }
        if (!z) {
            this.bob.onPause();
            gV("onHide");
        }
        if (GC() != null) {
            GC().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.cT(false);
        if (!z && (IL = this.bob.IL()) != null) {
            IL.dv(false);
        }
    }

    public String gW(String str) {
        if (this.bnZ.containsKey(str)) {
            return this.bnZ.get(str).IU();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.boc.mw(Of().getPage()) != this.boc.mw(bVar.mPage)) {
            this.boc.mt(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bnZ.get(bVar.mPage) == null) {
            String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c hr = com.baidu.swan.apps.core.slave.b.hr(J);
            if (hr != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + J);
                }
                this.bnZ.put(bVar.mPage, hr);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                hr = o(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bnZ.put(bVar.mPage, hr);
            }
            gZ(bVar.mPage);
            a(hr);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c o(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a K = com.baidu.swan.apps.core.slave.b.K(auD());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.aX("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).ba("preload", K.brY ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + K);
        }
        com.baidu.swan.apps.core.slave.b.a(K, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bsA = K.brX.IQ();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(K, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bsC = str2 + "?" + str3;
                } else {
                    bVar.bsC = str2;
                }
                if (com.baidu.swan.apps.runtime.e.acJ() != null) {
                    bVar.bsz = com.baidu.swan.apps.runtime.e.acJ().kR(str2);
                }
                bVar.bsD = com.baidu.swan.apps.y.f.WV().iR(str2).bsD;
                bVar.bsw = String.valueOf(com.baidu.swan.apps.console.a.Lu());
                if (com.baidu.swan.apps.runtime.e.acJ() != null) {
                    String kT = com.baidu.swan.apps.runtime.e.acJ().kT(str2);
                    if (!TextUtils.isEmpty(kT)) {
                        bVar.bsE = kT;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + kT);
                        }
                    }
                }
                bVar.bsy = d.DEBUG || com.baidu.swan.apps.y.f.WV().WA();
                if (com.baidu.swan.apps.ah.a.a.aaG()) {
                    bVar.bsB = com.baidu.swan.apps.console.debugger.b.LB();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bsF = str4;
                    com.baidu.swan.apps.performance.f.aX("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.agV();
                com.baidu.swan.apps.y.f.WV().a(K.brX.IU(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bm(K.brX.IU(), bVar.bsC);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return K.brX;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c iR = com.baidu.swan.apps.y.f.WV().iR(TextUtils.isEmpty(str2) ? "" : str2);
        this.bnY.mPage = str2;
        this.bnY.mParams = bVar != null ? bVar.getParams() : "";
        this.bog = iR;
        boolean z = false;
        if (gY(str2)) {
            gX(str2);
        } else {
            z = true;
            a(bVar, str);
            gX(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.A(7, str);
            } else {
                com.baidu.swan.apps.performance.g.A(6, str);
            }
            com.baidu.swan.apps.performance.f.aX("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.kb(str);
        }
        gS(iR.bQv);
        gT(iR.bQw);
        et(iR.bQu);
        Om();
        Op();
    }

    private void gX(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bnZ.get(str);
        if (this.bob != cVar) {
            if (!cVar.IK()) {
                cVar.a(this.boa, com.baidu.swan.apps.y.f.WV().iR(str));
            }
            cVar.dV(0);
            if (this.bob != null) {
                this.bob.dV(8);
            }
            this.bob = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.boa;
    }

    private boolean gY(String str) {
        return (this.bnZ.isEmpty() || this.bnZ.get(str) == null) ? false : true;
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
        return NL() && this.bob.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nz() {
        SwanAppConfigData WB;
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        if (WV == null || (WB = WV.WB()) == null || !WB.adx() || this.bnI == null) {
            return false;
        }
        return WB.lc(this.bnI.getPage());
    }

    public boolean NZ() {
        if (this.boc == null) {
            return false;
        }
        return this.boc.NZ();
    }

    protected final boolean Oa() {
        SwanAppConfigData WB;
        e GH = GH();
        if (GH == null) {
            return false;
        }
        return ((this.bog != null && this.bog.bQC) || (WB = com.baidu.swan.apps.y.f.WV().WB()) == null || a(GH, WB)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b ew = eVar.ew(0);
        if (ew == null || !(ew instanceof d)) {
            return false;
        }
        String page = ((d) ew).Of().getPage();
        return swanAppConfigData.lc(page) || TextUtils.equals(swanAppConfigData.WF(), page);
    }

    private boolean Ob() {
        SwanAppConfigData WB = com.baidu.swan.apps.y.f.WV().WB();
        return (WB == null || TextUtils.equals(WB.WF(), this.bnY.getPage())) ? false : true;
    }

    public String Oc() {
        return this.bob != null ? this.bob.IU() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        if (com.baidu.j.a.Ez()) {
            return true;
        }
        if (this.bob != null) {
            if (com.baidu.swan.apps.media.b.iU(this.bob.IU())) {
                return true;
            }
            return this.bob.IN();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Jl() {
        FragmentActivity auD = auD();
        if (auD != null && this.bnL == null) {
            this.bnL = new com.baidu.swan.menu.h(auD, this.bnK, Jm(), com.baidu.swan.apps.w.a.Ud(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnL, this).Yn();
        }
    }

    private int Jm() {
        return NS() ? Ob() ? 18 : 17 : Ob() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> Od() {
        if (this.bob == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bob.IS().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Oe() {
        return this.boc;
    }

    public com.baidu.swan.apps.model.b Of() {
        return this.bnY;
    }

    public com.baidu.swan.apps.adaptation.b.c Og() {
        return this.bob;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a GC() {
        if (this.bbd == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bbd = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), NN().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bbd;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c NM() {
        return this.bog;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Oh() {
        return this.bnP;
    }

    private boolean Oi() {
        return this.bog != null && this.bog.bQz;
    }

    private boolean Oj() {
        if (this.bog == null) {
            return false;
        }
        return TextUtils.equals(this.bog.bQB, "custom");
    }

    private void gZ(String str) {
        if (!Oj()) {
            com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (WV.iR(str).bQz && this.boi == null) {
                this.boi = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
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
            if (this.boi != null) {
                cVar.a(this.boi);
            }
            cVar.a(Ok());
        }
    }

    private com.baidu.swan.apps.core.f.e Ok() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.boi);
                    fVar.a(d.this.Ol());
                    com.baidu.swan.apps.ac.f.YR().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.boi);
                    com.baidu.swan.apps.ac.f.YR().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Ol() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void em(String str) {
                d.this.gS(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.boi != null && cVar != null) {
            cVar.b(this.boi);
            if (cVar.IM() != null) {
                cVar.b(this.boi);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Om() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bnK != null) {
            if (Oj()) {
                cs(true);
                i = 0;
                z = true;
            } else if (Oi()) {
                cs(false);
                if (this.bob != null) {
                    if (this.bob.IM() != null) {
                        dVar = this.bob.IM().IS();
                    } else {
                        dVar = this.bob.IS();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bog == null && this.bog.bQA) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bog == null) {
                }
                z = true;
            } else {
                cs(false);
                i = bnW + this.boh;
            }
            TextView centerTitleView = this.bnK.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ev(i);
            ct(z);
        }
    }

    private void ct(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bnP == null || !this.bnP.ahz()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = NN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.boa.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.boa.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bnJ.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bnJ.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        TextView centerTitleView;
        View ahy;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bnW) * 1.0f) / (this.boh == 0 ? 1 : this.boh);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bnP != null && this.bnP.ahz() && (ahy = this.bnP.ahy()) != null && (background = ahy.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bnK.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bog != null && this.bog.bQA && (centerTitleView = this.bnK.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bnN.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void On() {
        this.bnX = com.baidu.swan.apps.statistic.f.lG("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bnX != null) {
            com.baidu.swan.apps.statistic.f.a(this.bnX, gVar);
            this.bnX = null;
        }
    }

    public void Oo() {
        this.bog.bQB = "default";
        applyImmersion();
        Om();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Op() {
        if (this.bnI != null) {
            this.bnI.Op();
        }
    }

    private void cu(boolean z) {
        if (com.baidu.swan.apps.ab.a.da(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bnK, com.baidu.swan.apps.runtime.e.acJ().acL().Wc().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.acJ() != null) {
            com.baidu.swan.apps.ab.a.a(this.bnK, com.baidu.swan.apps.runtime.e.acJ().acY().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void cv(boolean z) {
        if (com.baidu.swan.apps.ab.a.da(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bnL, com.baidu.swan.apps.runtime.e.acJ().acL().Wc().paNumber);
        }
    }
}
