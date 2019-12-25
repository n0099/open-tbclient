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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
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
/* loaded from: classes9.dex */
public class d extends b implements a.InterfaceC0271a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int biJ = af.T(149.0f);
    private static String biQ = "-1";
    private static String biR = biQ;
    private static String biS;
    private com.baidu.swan.apps.res.widget.floatlayer.a aVL;
    private Flow biK;
    private FrameLayout biN;
    private com.baidu.swan.apps.adaptation.b.c biO;
    private com.baidu.swan.apps.tabbar.b.a biP;
    private com.baidu.swan.apps.runtime.config.c biT;
    private com.baidu.swan.apps.core.f.c biV;
    private aa biW;
    private View mRootView;
    private com.baidu.swan.apps.model.b biL = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> biM = new TreeMap();
    private int biU = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Li();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.biW = com.baidu.swan.apps.w.a.RY();
                d.this.biW.a(d.this.biu, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.aJ("route", "fragment create.");
    }

    private void Li() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.biu = com.baidu.swan.apps.model.c.je(arguments.getString("ai_apps_param"));
            this.biL.mPage = this.biu != null ? this.biu.getPage() : "";
            this.biL.mParams = this.biu != null ? this.biu.getParams() : "";
            this.biT = com.baidu.swan.apps.y.f.Uf().iA(this.biL.getPage());
            this.biU = KY().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.aJ("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.biN = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        aa(inflate);
        this.biP = new com.baidu.swan.apps.tabbar.b.a(this);
        ad(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.biO.FP());
        com.baidu.swan.apps.ac.f.Wb().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView FV() {
        if (this.biO != null) {
            return this.biO.FV();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void aa(View view) {
        super.aa(view);
        ce(KW());
        if (Ll()) {
            KV();
        }
        Lx();
        this.biw.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String Ge = d.this.biO.Ge();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bm(Ge, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.Uf().a(Ge, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KI() {
        this.biO.FY();
        Gv();
        ci(true);
        this.bix.g(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState(), Lc());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KU() {
        Le();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c Lg = com.baidu.swan.apps.y.f.Uf().LC().Lg();
        if (Lg != null && !TextUtils.isEmpty(Lg.getPage())) {
            fVar.n("page", Lg.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.biT)) {
            super.applyImmersion(i);
            return;
        }
        if (!Lu() && z.cB(this.mActivity)) {
            z = false;
        }
        p(i, z);
        Lx();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean ec(int i) {
        boolean ec = super.ec(i);
        Lx();
        return ec;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        Lx();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        ch(false);
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
        if (this.bix != null && this.bix.isShowing()) {
            this.bix.eH(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.biO.Ge())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.biO.Ge())));
        }
    }

    public static void gD(String str) {
        biS = str;
    }

    private void Lj() {
        if (!TextUtils.equals(biR, this.biO.Ge()) || TextUtils.equals(biS, "switchTab")) {
            int mf = this.biP.mf(Lq().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.bpv = biR;
            eVar.bpw = this.biO.Ge();
            eVar.bjj = biS;
            eVar.bpx = this.biL.mPage;
            eVar.bpy = String.valueOf(mf);
            biS = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.bpv + " ,toId: " + eVar.bpw + " ,RouteType: " + eVar.bjj + " page:" + eVar.bpx + ",TabIndex: " + eVar.bpy);
            }
            com.baidu.swan.apps.y.f.Uf().a(eVar);
            biR = this.biO.Ge();
        }
    }

    private void gE(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.biO.Ge());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.biO.Ge());
        }
        com.baidu.swan.apps.y.f.Uf().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Lf() {
        if (this.biO == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.biO.Ge());
        com.baidu.swan.apps.adaptation.b.f FW = this.biO.FW();
        if (FW != null) {
            hashMap.put("webViewUrl", FW.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ad(View view) {
        com.baidu.swan.apps.performance.e.aJ("route", "createSlaveWebView start.");
        String TN = this.biu.TN();
        String params = this.biu.getParams();
        String page = this.biu.getPage();
        String I = ai.I(TN, page, params);
        this.biO = com.baidu.swan.apps.core.slave.b.ha(I);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + I + " is load: " + (this.biO != null));
        }
        if (this.biO == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.biO = l(TN, page, params, "");
        }
        this.biO.a(this.biN, com.baidu.swan.apps.y.f.Uf().iA(page));
        gI(page);
        a(this.biO);
        if (KJ()) {
            this.biM.put(page, this.biO);
            this.biP.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.aJ("route", "createSlaveWebView end.");
        Ly();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.biM != null && !this.biM.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.biM.values()) {
                if (cVar != null) {
                    cVar.Gf();
                }
            }
        } else if (this.biO != null) {
            this.biO.Gf();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.biM != null && !this.biM.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.biM.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.biM.clear();
        } else if (this.biO != null) {
            b(this.biO);
            this.biO.destroy();
        }
        this.biO = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.H(com.baidu.swan.apps.y.f.Uf().TQ());
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
                ch(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.biO == null;
        String Ge = z ? "" : this.biO.Ge();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + Ge);
        }
        if (!z) {
            this.biO.onResume();
            Lj();
            gE("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.cG(true);
        if (com.baidu.swan.apps.console.c.IH()) {
            com.baidu.swan.apps.core.c.b.KA();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView FV;
        boolean z = this.biO == null;
        String Ge = z ? "" : this.biO.Ge();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + Ge);
        }
        if (!z) {
            this.biO.onPause();
            gE("onHide");
        }
        if (DK() != null) {
            DK().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.cG(false);
        if (!z && (FV = this.biO.FV()) != null) {
            FV.di(false);
        }
    }

    public String gF(String str) {
        if (this.biM.containsKey(str)) {
            return this.biM.get(str).Ge();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.biP.mf(Lq().getPage()) != this.biP.mf(bVar.mPage)) {
            this.biP.mc(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.biM.get(bVar.mPage) == null) {
            String I = ai.I(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c ha = com.baidu.swan.apps.core.slave.b.ha(I);
            if (ha != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + I);
                }
                this.biM.put(bVar.mPage, ha);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                ha = l(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.biM.put(bVar.mPage, ha);
            }
            gI(bVar.mPage);
            a(ha);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c l(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a I = com.baidu.swan.apps.core.slave.b.I(arR());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.aO("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).aR("preload", I.bmN ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + I);
        }
        com.baidu.swan.apps.core.slave.b.a(I, new b.InterfaceC0243b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0243b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bnp = I.bmM.Ga();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(I, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bnr = str2 + "?" + str3;
                } else {
                    bVar.bnr = str2;
                }
                if (com.baidu.swan.apps.runtime.e.ZT() != null) {
                    bVar.bno = com.baidu.swan.apps.runtime.e.ZT().kA(str2);
                }
                bVar.bns = com.baidu.swan.apps.y.f.Uf().iA(str2).bns;
                bVar.bnl = String.valueOf(com.baidu.swan.apps.console.a.IE());
                if (com.baidu.swan.apps.runtime.e.ZT() != null) {
                    String kC = com.baidu.swan.apps.runtime.e.ZT().kC(str2);
                    if (!TextUtils.isEmpty(kC)) {
                        bVar.bnt = kC;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + kC);
                        }
                    }
                }
                bVar.bnn = d.DEBUG || com.baidu.swan.apps.y.f.Uf().TK();
                if (com.baidu.swan.apps.ah.a.a.XQ()) {
                    bVar.bnq = com.baidu.swan.apps.console.debugger.b.IL();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bnu = str4;
                    com.baidu.swan.apps.performance.f.aO("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.aej();
                com.baidu.swan.apps.y.f.Uf().a(I.bmM.Ge(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bd(I.bmM.Ge(), bVar.bnr);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return I.bmM;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c iA = com.baidu.swan.apps.y.f.Uf().iA(TextUtils.isEmpty(str2) ? "" : str2);
        this.biL.mPage = str2;
        this.biL.mParams = bVar != null ? bVar.getParams() : "";
        this.biT = iA;
        boolean z = false;
        if (gH(str2)) {
            gG(str2);
        } else {
            z = true;
            a(bVar, str);
            gG(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.v(7, str);
            } else {
                com.baidu.swan.apps.performance.g.v(6, str);
            }
            com.baidu.swan.apps.performance.f.aO("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.jK(str);
        }
        gB(iA.bLt);
        gC(iA.bLu);
        ec(iA.bLs);
        Lx();
        LA();
    }

    private void gG(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.biM.get(str);
        if (this.biO != cVar) {
            if (!cVar.FU()) {
                cVar.a(this.biN, com.baidu.swan.apps.y.f.Uf().iA(str));
            }
            cVar.dE(0);
            if (this.biO != null) {
                this.biO.dE(8);
            }
            this.biO = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.biN;
    }

    private boolean gH(String str) {
        return (this.biM.isEmpty() || this.biM.get(str) == null) ? false : true;
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
        return KW() && this.biO.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean KJ() {
        SwanAppConfigData TL;
        com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        if (Uf == null || (TL = Uf.TL()) == null || !TL.aaH() || this.biu == null) {
            return false;
        }
        return TL.kL(this.biu.getPage());
    }

    public boolean Lk() {
        if (this.biP == null) {
            return false;
        }
        return this.biP.Lk();
    }

    protected final boolean Ll() {
        SwanAppConfigData TL;
        e DP = DP();
        if (DP == null) {
            return false;
        }
        return ((this.biT != null && this.biT.bLA) || (TL = com.baidu.swan.apps.y.f.Uf().TL()) == null || a(DP, TL)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b ef = eVar.ef(0);
        if (ef == null || !(ef instanceof d)) {
            return false;
        }
        String page = ((d) ef).Lq().getPage();
        return swanAppConfigData.kL(page) || TextUtils.equals(swanAppConfigData.TP(), page);
    }

    private boolean Lm() {
        SwanAppConfigData TL = com.baidu.swan.apps.y.f.Uf().TL();
        return (TL == null || TextUtils.equals(TL.TP(), this.biL.getPage())) ? false : true;
    }

    public String Ln() {
        return this.biO != null ? this.biO.Ge() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean FX() {
        if (com.baidu.j.a.By()) {
            return true;
        }
        if (this.biO != null) {
            if (com.baidu.swan.apps.media.b.iD(this.biO.Ge())) {
                return true;
            }
            return this.biO.FX();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Gv() {
        FragmentActivity arR = arR();
        if (arR != null && this.bix == null) {
            this.bix = new com.baidu.swan.menu.h(arR, this.biw, Gw(), com.baidu.swan.apps.w.a.Ro(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bix, this).Vx();
        }
    }

    private int Gw() {
        return Ld() ? Lm() ? 18 : 17 : Lm() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> Lo() {
        if (this.biO == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.biO.Gc().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Lp() {
        return this.biP;
    }

    public com.baidu.swan.apps.model.b Lq() {
        return this.biL;
    }

    public com.baidu.swan.apps.adaptation.b.c Lr() {
        return this.biO;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0271a
    public com.baidu.swan.apps.res.widget.floatlayer.a DK() {
        if (this.aVL == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aVL = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), KY().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aVL;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c KX() {
        return this.biT;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Ls() {
        return this.biB;
    }

    private boolean Lt() {
        return this.biT != null && this.biT.bLx;
    }

    private boolean Lu() {
        if (this.biT == null) {
            return false;
        }
        return TextUtils.equals(this.biT.bLz, "custom");
    }

    private void gI(String str) {
        if (!Lu()) {
            com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (Uf.iA(str).bLx && this.biV == null) {
                this.biV = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.ee(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.biV != null) {
                cVar.a(this.biV);
            }
            cVar.a(Lv());
        }
    }

    private com.baidu.swan.apps.core.f.e Lv() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.biV);
                    fVar.a(d.this.Lw());
                    com.baidu.swan.apps.ac.f.Wb().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.biV);
                    com.baidu.swan.apps.ac.f.Wb().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Lw() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void dW(String str) {
                d.this.gB(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.biV != null && cVar != null) {
            cVar.b(this.biV);
            if (cVar.FW() != null) {
                cVar.b(this.biV);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Lx() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.biw != null) {
            if (Lu()) {
                cf(true);
                i = 0;
                z = true;
            } else if (Lt()) {
                cf(false);
                if (this.biO != null) {
                    if (this.biO.FW() != null) {
                        dVar = this.biO.FW().Gc();
                    } else {
                        dVar = this.biO.Gc();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.biT == null && this.biT.bLy) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.biT == null) {
                }
                z = true;
            } else {
                cf(false);
                i = biJ + this.biU;
            }
            TextView centerTitleView = this.biw.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ee(i);
            cg(z);
        }
    }

    private void cg(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.biB == null || !this.biB.aeN()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = KY().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.biN.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.biN.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.biv.getLayoutParams();
        layoutParams2.topMargin = i;
        this.biv.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(int i) {
        TextView centerTitleView;
        View aeM;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - biJ) * 1.0f) / (this.biU == 0 ? 1 : this.biU);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.biB != null && this.biB.aeN() && (aeM = this.biB.aeM()) != null && (background = aeM.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.biw.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.biT != null && this.biT.bLy && (centerTitleView = this.biw.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.biz.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Ly() {
        this.biK = com.baidu.swan.apps.statistic.f.lp("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.biK != null) {
            com.baidu.swan.apps.statistic.f.a(this.biK, gVar);
            this.biK = null;
        }
    }

    public void Lz() {
        this.biT.bLz = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        applyImmersion();
        Lx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LA() {
        if (this.biu != null) {
            this.biu.LA();
        }
    }

    private void ch(boolean z) {
        if (com.baidu.swan.apps.ab.a.cN(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.biw, com.baidu.swan.apps.runtime.e.ZT().ZV().Tm().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.ZT() != null) {
            com.baidu.swan.apps.ab.a.a(this.biw, com.baidu.swan.apps.runtime.e.ZT().aai().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void ci(boolean z) {
        if (com.baidu.swan.apps.ab.a.cN(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bix, com.baidu.swan.apps.runtime.e.ZT().ZV().Tm().paNumber);
        }
    }
}
