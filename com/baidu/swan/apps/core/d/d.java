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
/* loaded from: classes10.dex */
public class d extends b implements a.InterfaceC0273a {
    private static String bjH;
    private com.baidu.swan.apps.res.widget.floatlayer.a aWD;
    private FrameLayout bjC;
    private com.baidu.swan.apps.adaptation.b.c bjD;
    private com.baidu.swan.apps.tabbar.b.a bjE;
    private com.baidu.swan.apps.runtime.config.c bjI;
    private com.baidu.swan.apps.core.f.c bjK;
    private aa bjL;
    private Flow bjz;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bjy = af.S(149.0f);
    private static String bjF = "-1";
    private static String bjG = bjF;
    private com.baidu.swan.apps.model.b bjA = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bjB = new TreeMap();
    private int bjJ = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LE();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bjL = com.baidu.swan.apps.w.a.Su();
                d.this.bjL.a(d.this.bjj, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.aK("route", "fragment create.");
    }

    private void LE() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bjj = com.baidu.swan.apps.model.c.jh(arguments.getString("ai_apps_param"));
            this.bjA.mPage = this.bjj != null ? this.bjj.getPage() : "";
            this.bjA.mParams = this.bjj != null ? this.bjj.getParams() : "";
            this.bjI = com.baidu.swan.apps.y.f.UC().iD(this.bjA.getPage());
            this.bjJ = Lu().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.aK("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.bjC = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bjE = new com.baidu.swan.apps.tabbar.b.a(this);
        ah(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bjD.Gl());
        com.baidu.swan.apps.ac.f.Wy().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Gr() {
        if (this.bjD != null) {
            return this.bjD.Gr();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        cj(Ls());
        if (LH()) {
            Lr();
        }
        LT();
        this.bjl.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String GA = d.this.bjD.GA();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bn(GA, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.UC().a(GA, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
        this.bjD.Gu();
        GR();
        cn(true);
        this.bjm.h(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState(), Ly());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Lq() {
        LA();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c LC = com.baidu.swan.apps.y.f.UC().LY().LC();
        if (LC != null && !TextUtils.isEmpty(LC.getPage())) {
            fVar.n("page", LC.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bjI)) {
            super.applyImmersion(i);
            return;
        }
        if (!LQ() && z.cB(this.mActivity)) {
            z = false;
        }
        p(i, z);
        LT();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean ed(int i) {
        boolean ed = super.ed(i);
        LT();
        return ed;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        LT();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        cm(false);
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
        if (this.bjm != null && this.bjm.isShowing()) {
            this.bjm.eM(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bjD.GA())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bjD.GA())));
        }
    }

    public static void gG(String str) {
        bjH = str;
    }

    private void LF() {
        if (!TextUtils.equals(bjG, this.bjD.GA()) || TextUtils.equals(bjH, "switchTab")) {
            int mi = this.bjE.mi(LM().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.bqj = bjG;
            eVar.bqk = this.bjD.GA();
            eVar.bjY = bjH;
            eVar.bql = this.bjA.mPage;
            eVar.bqm = String.valueOf(mi);
            bjH = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.bqj + " ,toId: " + eVar.bqk + " ,RouteType: " + eVar.bjY + " page:" + eVar.bql + ",TabIndex: " + eVar.bqm);
            }
            com.baidu.swan.apps.y.f.UC().a(eVar);
            bjG = this.bjD.GA();
        }
    }

    private void gH(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bjD.GA());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bjD.GA());
        }
        com.baidu.swan.apps.y.f.UC().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void LB() {
        if (this.bjD == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bjD.GA());
        com.baidu.swan.apps.adaptation.b.f Gs = this.bjD.Gs();
        if (Gs != null) {
            hashMap.put("webViewUrl", Gs.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ah(View view) {
        com.baidu.swan.apps.performance.e.aK("route", "createSlaveWebView start.");
        String Uk = this.bjj.Uk();
        String params = this.bjj.getParams();
        String page = this.bjj.getPage();
        String I = ai.I(Uk, page, params);
        this.bjD = com.baidu.swan.apps.core.slave.b.hd(I);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + I + " is load: " + (this.bjD != null));
        }
        if (this.bjD == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bjD = l(Uk, page, params, "");
        }
        this.bjD.a(this.bjC, com.baidu.swan.apps.y.f.UC().iD(page));
        gL(page);
        a(this.bjD);
        if (Lf()) {
            this.bjB.put(page, this.bjD);
            this.bjE.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.aK("route", "createSlaveWebView end.");
        LU();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bjB != null && !this.bjB.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bjB.values()) {
                if (cVar != null) {
                    cVar.GB();
                }
            }
        } else if (this.bjD != null) {
            this.bjD.GB();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bjB != null && !this.bjB.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bjB.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bjB.clear();
        } else if (this.bjD != null) {
            b(this.bjD);
            this.bjD.destroy();
        }
        this.bjD = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.I(com.baidu.swan.apps.y.f.UC().Un());
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
                cm(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bjD == null;
        String GA = z ? "" : this.bjD.GA();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + GA);
        }
        if (!z) {
            this.bjD.onResume();
            LF();
            gH("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.cL(true);
        if (com.baidu.swan.apps.console.c.Jd()) {
            com.baidu.swan.apps.core.c.b.KW();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Gr;
        boolean z = this.bjD == null;
        String GA = z ? "" : this.bjD.GA();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + GA);
        }
        if (!z) {
            this.bjD.onPause();
            gH("onHide");
        }
        if (Eg() != null) {
            Eg().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.cL(false);
        if (!z && (Gr = this.bjD.Gr()) != null) {
            Gr.dn(false);
        }
    }

    public String gI(String str) {
        if (this.bjB.containsKey(str)) {
            return this.bjB.get(str).GA();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bjE.mi(LM().getPage()) != this.bjE.mi(bVar.mPage)) {
            this.bjE.mf(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bjB.get(bVar.mPage) == null) {
            String I = ai.I(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c hd = com.baidu.swan.apps.core.slave.b.hd(I);
            if (hd != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + I);
                }
                this.bjB.put(bVar.mPage, hd);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                hd = l(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bjB.put(bVar.mPage, hd);
            }
            gL(bVar.mPage);
            a(hd);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c l(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a J = com.baidu.swan.apps.core.slave.b.J(ask());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.aP("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).aS("preload", J.bnB ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + J);
        }
        com.baidu.swan.apps.core.slave.b.a(J, new b.InterfaceC0245b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0245b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bod = J.bnA.Gw();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(J, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bof = str2 + "?" + str3;
                } else {
                    bVar.bof = str2;
                }
                if (com.baidu.swan.apps.runtime.e.aaq() != null) {
                    bVar.boc = com.baidu.swan.apps.runtime.e.aaq().kD(str2);
                }
                bVar.bog = com.baidu.swan.apps.y.f.UC().iD(str2).bog;
                bVar.bnZ = String.valueOf(com.baidu.swan.apps.console.a.Ja());
                if (com.baidu.swan.apps.runtime.e.aaq() != null) {
                    String kF = com.baidu.swan.apps.runtime.e.aaq().kF(str2);
                    if (!TextUtils.isEmpty(kF)) {
                        bVar.boh = kF;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + kF);
                        }
                    }
                }
                bVar.bob = d.DEBUG || com.baidu.swan.apps.y.f.UC().Uh();
                if (com.baidu.swan.apps.ah.a.a.Yn()) {
                    bVar.boe = com.baidu.swan.apps.console.debugger.b.Jh();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.boi = str4;
                    com.baidu.swan.apps.performance.f.aP("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.aeC();
                com.baidu.swan.apps.y.f.UC().a(J.bnA.GA(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.be(J.bnA.GA(), bVar.bof);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return J.bnA;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c iD = com.baidu.swan.apps.y.f.UC().iD(TextUtils.isEmpty(str2) ? "" : str2);
        this.bjA.mPage = str2;
        this.bjA.mParams = bVar != null ? bVar.getParams() : "";
        this.bjI = iD;
        boolean z = false;
        if (gK(str2)) {
            gJ(str2);
        } else {
            z = true;
            a(bVar, str);
            gJ(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.y(7, str);
            } else {
                com.baidu.swan.apps.performance.g.y(6, str);
            }
            com.baidu.swan.apps.performance.f.aP("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.jN(str);
        }
        gE(iD.bMd);
        gF(iD.bMe);
        ed(iD.bMc);
        LT();
        LW();
    }

    private void gJ(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bjB.get(str);
        if (this.bjD != cVar) {
            if (!cVar.Gq()) {
                cVar.a(this.bjC, com.baidu.swan.apps.y.f.UC().iD(str));
            }
            cVar.dF(0);
            if (this.bjD != null) {
                this.bjD.dF(8);
            }
            this.bjD = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bjC;
    }

    private boolean gK(String str) {
        return (this.bjB.isEmpty() || this.bjB.get(str) == null) ? false : true;
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
        return Ls() && this.bjD.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        SwanAppConfigData Ui;
        com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        if (UC == null || (Ui = UC.Ui()) == null || !Ui.abe() || this.bjj == null) {
            return false;
        }
        return Ui.kO(this.bjj.getPage());
    }

    public boolean LG() {
        if (this.bjE == null) {
            return false;
        }
        return this.bjE.LG();
    }

    protected final boolean LH() {
        SwanAppConfigData Ui;
        e El = El();
        if (El == null) {
            return false;
        }
        return ((this.bjI != null && this.bjI.bMk) || (Ui = com.baidu.swan.apps.y.f.UC().Ui()) == null || a(El, Ui)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b eg = eVar.eg(0);
        if (eg == null || !(eg instanceof d)) {
            return false;
        }
        String page = ((d) eg).LM().getPage();
        return swanAppConfigData.kO(page) || TextUtils.equals(swanAppConfigData.Um(), page);
    }

    private boolean LI() {
        SwanAppConfigData Ui = com.baidu.swan.apps.y.f.UC().Ui();
        return (Ui == null || TextUtils.equals(Ui.Um(), this.bjA.getPage())) ? false : true;
    }

    public String LJ() {
        return this.bjD != null ? this.bjD.GA() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        if (com.baidu.j.a.BU()) {
            return true;
        }
        if (this.bjD != null) {
            if (com.baidu.swan.apps.media.b.iG(this.bjD.GA())) {
                return true;
            }
            return this.bjD.Gt();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void GR() {
        FragmentActivity ask = ask();
        if (ask != null && this.bjm == null) {
            this.bjm = new com.baidu.swan.menu.h(ask, this.bjl, GS(), com.baidu.swan.apps.w.a.RK(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bjm, this).VU();
        }
    }

    private int GS() {
        return Lz() ? LI() ? 18 : 17 : LI() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> LK() {
        if (this.bjD == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bjD.Gy().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a LL() {
        return this.bjE;
    }

    public com.baidu.swan.apps.model.b LM() {
        return this.bjA;
    }

    public com.baidu.swan.apps.adaptation.b.c LN() {
        return this.bjD;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0273a
    public com.baidu.swan.apps.res.widget.floatlayer.a Eg() {
        if (this.aWD == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aWD = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), Lu().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aWD;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c Lt() {
        return this.bjI;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b LO() {
        return this.bjq;
    }

    private boolean LP() {
        return this.bjI != null && this.bjI.bMh;
    }

    private boolean LQ() {
        if (this.bjI == null) {
            return false;
        }
        return TextUtils.equals(this.bjI.bMj, "custom");
    }

    private void gL(String str) {
        if (!LQ()) {
            com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (UC.iD(str).bMh && this.bjK == null) {
                this.bjK = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.ef(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.bjK != null) {
                cVar.a(this.bjK);
            }
            cVar.a(LR());
        }
    }

    private com.baidu.swan.apps.core.f.e LR() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bjK);
                    fVar.a(d.this.LS());
                    com.baidu.swan.apps.ac.f.Wy().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bjK);
                    com.baidu.swan.apps.ac.f.Wy().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a LS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void dY(String str) {
                d.this.gE(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bjK != null && cVar != null) {
            cVar.b(this.bjK);
            if (cVar.Gs() != null) {
                cVar.b(this.bjK);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void LT() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bjl != null) {
            if (LQ()) {
                ck(true);
                i = 0;
                z = true;
            } else if (LP()) {
                ck(false);
                if (this.bjD != null) {
                    if (this.bjD.Gs() != null) {
                        dVar = this.bjD.Gs().Gy();
                    } else {
                        dVar = this.bjD.Gy();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bjI == null && this.bjI.bMi) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bjI == null) {
                }
                z = true;
            } else {
                ck(false);
                i = bjy + this.bjJ;
            }
            TextView centerTitleView = this.bjl.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ef(i);
            cl(z);
        }
    }

    private void cl(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bjq == null || !this.bjq.afg()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = Lu().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bjC.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bjC.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bjk.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bjk.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(int i) {
        TextView centerTitleView;
        View aff;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bjy) * 1.0f) / (this.bjJ == 0 ? 1 : this.bjJ);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bjq != null && this.bjq.afg() && (aff = this.bjq.aff()) != null && (background = aff.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bjl.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bjI != null && this.bjI.bMi && (centerTitleView = this.bjl.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bjo.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void LU() {
        this.bjz = com.baidu.swan.apps.statistic.f.ls("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bjz != null) {
            com.baidu.swan.apps.statistic.f.a(this.bjz, gVar);
            this.bjz = null;
        }
    }

    public void LV() {
        this.bjI.bMj = "default";
        applyImmersion();
        LT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LW() {
        if (this.bjj != null) {
            this.bjj.LW();
        }
    }

    private void cm(boolean z) {
        if (com.baidu.swan.apps.ab.a.cS(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bjl, com.baidu.swan.apps.runtime.e.aaq().aas().TJ().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aaq() != null) {
            com.baidu.swan.apps.ab.a.a(this.bjl, com.baidu.swan.apps.runtime.e.aaq().aaF().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void cn(boolean z) {
        if (com.baidu.swan.apps.ab.a.cS(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bjm, com.baidu.swan.apps.runtime.e.aaq().aas().TJ().paNumber);
        }
    }
}
