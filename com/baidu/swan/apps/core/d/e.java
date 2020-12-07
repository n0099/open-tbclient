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
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ac;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes25.dex */
public class e extends c implements a.InterfaceC0480a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cPE = ah.M(149.0f);
    private static String cPL = "-1";
    private static String cPM = cPL;
    private static String cPN;
    private com.baidu.swan.apps.statistic.a cPF;
    private FrameLayout cPI;
    private com.baidu.swan.apps.adaptation.b.c cPJ;
    private com.baidu.swan.apps.tabbar.b.a cPK;
    private com.baidu.swan.apps.runtime.config.c cPO;
    private com.baidu.swan.apps.core.f.c cPQ;
    private com.baidu.swan.apps.adaptation.a.ah cPR;
    private com.baidu.swan.apps.res.widget.floatlayer.a czE;
    private View mRootView;
    private com.baidu.swan.apps.model.b cPG = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cPH = new TreeMap();
    private int cPP = 0;
    public boolean cPS = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        arf();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cPR = com.baidu.swan.apps.t.a.azP();
                e.this.cPR.a(e.this.cPi, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.D("route", "fragment create.");
    }

    private void arf() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cPi = com.baidu.swan.apps.model.c.qP(arguments.getString("ai_apps_param"));
            this.cPG.mPage = this.cPi != null ? this.cPi.getPage() : "";
            this.cPG.mParams = this.cPi != null ? this.cPi.getParams() : "";
            this.cPG.dlu = com.baidu.swan.apps.scheme.actions.k.j.tm(this.cPG.getPage());
            this.cPO = com.baidu.swan.apps.v.f.aCp().qm(this.cPG.aEz());
            if (this.cPO.dzP) {
                this.cPO = com.baidu.swan.apps.v.f.aCp().qn(this.cPG.getPage());
            }
            this.cPP = aqU().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.h.D("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.cPI = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        at(inflate);
        this.cPK = new com.baidu.swan.apps.tabbar.b.a(this);
        aw(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aEu() && !com.baidu.swan.apps.menu.fontsize.b.aEs()) {
            com.baidu.swan.apps.menu.fontsize.a.cg(this.cPJ.alj(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aEr()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cPJ.akS());
        com.baidu.swan.apps.y.f.aEX().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView akZ() {
        if (this.cPJ != null) {
            return this.cPJ.akZ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
        super.at(view);
        fe(aqP());
        if (arj()) {
            aqO();
        }
        arv();
        this.cPk.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String alj = e.this.cPJ.alj();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cQ(alj, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.aCp().a(alj, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
        this.cPJ.alc();
        alI();
        fi(true);
        if (this.cPm != null) {
            this.cPm.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.or(com.baidu.swan.apps.runtime.d.aJQ().getAppId()));
        }
        this.cPl.a(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState(), aqY(), this.cPm, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqM() {
        ara();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e arC = com.baidu.swan.apps.v.f.aCp().arC();
        com.baidu.swan.apps.model.c arb = arC == null ? null : arC.arb();
        if (arb != null && !TextUtils.isEmpty(arb.getPage())) {
            fVar.t("page", arb.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cPO)) {
            super.applyImmersion(i);
            return;
        }
        if (!ars() && ac.dn(this.mActivity)) {
            z = false;
        }
        y(i, z);
        arv();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean iq(int i) {
        boolean iq = super.iq(i);
        arv();
        return iq;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        arv();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        fh(false);
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
        if (this.cPl != null && this.cPl.isShowing()) {
            this.cPl.ii(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cPJ.alj())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cPJ.alj())));
        }
    }

    public static void nw(String str) {
        cPN = str;
    }

    private void arg() {
        if (!TextUtils.equals(cPM, this.cPJ.alj()) || TextUtils.equals(cPN, "switchTab")) {
            int uz = this.cPK.uz(arp().aEz());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cYB = cPM;
            eVar.cYC = this.cPJ.alj();
            eVar.cQf = cPN;
            eVar.cYD = this.cPG.mPage;
            eVar.cYE = String.valueOf(uz);
            cPN = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cYB + " ,toId: " + eVar.cYC + " ,RouteType: " + eVar.cQf + " page:" + eVar.cYD + ",TabIndex: " + eVar.cYE);
            }
            com.baidu.swan.apps.v.f.aCp().b(eVar);
            cPM = this.cPJ.alj();
        }
    }

    private void nx(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cPJ.alj());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cPJ.alj());
        }
        com.baidu.swan.apps.v.f.aCp().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aqt() {
        if (this.cPJ == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cPJ.alj());
        com.baidu.swan.apps.adaptation.b.f ala = this.cPJ.ala();
        if (ala != null) {
            hashMap.put("webViewUrl", ala.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aw(View view) {
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView start.");
        String aBW = this.cPi.aBW();
        String params = this.cPi.getParams();
        String page = this.cPi.getPage();
        String ab = ak.ab(aBW, page, params);
        this.cPJ = com.baidu.swan.apps.core.slave.b.oe(ab);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + ab + " is load: " + (this.cPJ != null));
        }
        if (this.cPJ == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cPJ = q(aBW, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c qm = com.baidu.swan.apps.v.f.aCp().qm(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cPJ.b(this.cPI, qm);
        this.cPJ.a(this.cPI, qm);
        nB(page);
        a(this.cPJ);
        if (aqq()) {
            this.cPH.put(page, this.cPJ);
            this.cPK.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView end.");
        arw();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cPH != null && !this.cPH.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cPH.values()) {
                if (cVar != null) {
                    cVar.alk();
                }
            }
        } else if (this.cPJ != null) {
            this.cPJ.alk();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.arA()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.arh();
                }
            });
        } else {
            arh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arh() {
        if (this.cPH != null && !this.cPH.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cPH.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cPH.clear();
        } else if (this.cPJ != null) {
            b(this.cPJ);
            this.cPJ.destroy();
        }
        this.cPJ = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cPS) {
            com.baidu.swan.apps.core.slave.b.cF(com.baidu.swan.apps.v.f.aCp().aBZ());
        }
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded()) {
            super.setUserVisibleHint(z);
            if (DEBUG) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                fh(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cPJ == null;
        String alj = z ? "" : this.cPJ.alj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + alj);
        }
        if (!z) {
            fe(aqP());
            this.cPJ.onResume();
            arg();
            nx("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fS(true);
        if (com.baidu.swan.apps.console.c.anY()) {
            com.baidu.swan.apps.core.c.b.aqe();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView akZ;
        boolean z = this.cPJ == null;
        String alj = z ? "" : this.cPJ.alj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + alj);
        }
        if (!z) {
            this.cPJ.onPause();
            nx("onHide");
        }
        if (aih() != null && !aih().aJE()) {
            aih().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fS(false);
        if (!z && (akZ = this.cPJ.akZ()) != null) {
            akZ.gA(false);
        }
    }

    public String ny(String str) {
        if (this.cPH.containsKey(str)) {
            return this.cPH.get(str).alj();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cPK.uz(arp().aEz()) != this.cPK.uz(bVar.aEz())) {
            this.cPK.uw(bVar.aEz());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cPH.get(bVar.dlu) == null) {
            String ab = ak.ab(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c oe = com.baidu.swan.apps.core.slave.b.oe(ab);
            if (oe != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + ab);
                }
                this.cPH.put(bVar.mPage, oe);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                oe = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cPH.put(bVar.mPage, oe);
            }
            nB(bVar.mPage);
            a(oe);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(bff());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cl("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).co("preload", G.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + G);
        }
        com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0443b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0443b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cVf = G.cUE.ale();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(G, str4);
                }
                String tm = com.baidu.swan.apps.scheme.actions.k.j.tm(str2);
                bVar.appPath = str;
                bVar.cVh = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aJV() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aJV().sB(tm);
                    bVar.cVj = com.baidu.swan.apps.runtime.e.aJV().sD(tm);
                }
                bVar.cVd = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aJU(), bVar.cVh);
                bVar.cVi = com.baidu.swan.apps.v.f.aCp().qm(tm).cVi;
                bVar.cVc = String.valueOf(com.baidu.swan.apps.console.a.anV());
                bVar.cVe = e.DEBUG || com.baidu.swan.apps.v.f.aCp().aBT();
                if (com.baidu.swan.apps.ad.a.a.aHr()) {
                    bVar.cVg = com.baidu.swan.apps.console.debugger.b.aoc();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cVk = str4;
                    com.baidu.swan.apps.performance.i.cl("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aPg();
                G.cUE.alh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                G.cUE.kY(bVar.cVh);
                com.baidu.swan.apps.v.f.aCp().a(G.cUE.alj(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cD(G.cUE.alj(), bVar.cVh);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return G.cUE;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dlu;
        com.baidu.swan.apps.runtime.config.c qm = com.baidu.swan.apps.v.f.aCp().qm(TextUtils.isEmpty(str3) ? "" : str3);
        this.cPG.mPage = str2;
        this.cPG.mParams = bVar != null ? bVar.getParams() : "";
        this.cPG.dlu = str3;
        this.cPO = qm;
        boolean z = false;
        if (nA(str3)) {
            nz(str3);
        } else {
            z = true;
            a(bVar, str);
            nz(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.al(7, str);
            } else {
                com.baidu.swan.apps.performance.j.al(6, str);
            }
            com.baidu.swan.apps.performance.i.cl("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.rz(str);
        }
        nv(qm.dzF);
        ir(SwanAppConfigData.sI(qm.dzG));
        iq(qm.dzE);
        arv();
        ary();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + qm.dzF + " page:" + str2);
    }

    private void nz(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cPH.get(str);
        if (this.cPJ != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c qm = com.baidu.swan.apps.v.f.aCp().qm(str);
            cVar.b(this.cPI, qm);
            if (!cVar.akY()) {
                cVar.a(this.cPI, qm);
            }
            cVar.hO(0);
            if (this.cPJ != null) {
                this.cPJ.hO(8);
            }
            this.cPJ = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cPI;
    }

    private boolean nA(String str) {
        return (this.cPH.isEmpty() || this.cPH.get(str) == null) ? false : true;
    }

    public static e a(com.baidu.swan.apps.model.c cVar) {
        e eVar = new e();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.toJSONString());
            eVar.setArguments(bundle);
        }
        return eVar;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return aqP() && this.cPJ.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        SwanAppConfigData aBU;
        com.baidu.swan.apps.v.f aCp = com.baidu.swan.apps.v.f.aCp();
        if (aCp == null || (aBU = aCp.aBU()) == null || !aBU.aKK() || this.cPi == null) {
            return false;
        }
        return aBU.sO(this.cPi.getPage());
    }

    public boolean ari() {
        if (this.cPK == null) {
            return false;
        }
        return this.cPK.ari();
    }

    protected final boolean arj() {
        SwanAppConfigData aBU;
        f aim = aim();
        if (aim == null) {
            return false;
        }
        if ((this.cPO != null && this.cPO.dzM) || (aBU = com.baidu.swan.apps.v.f.aCp().aBU()) == null) {
            return false;
        }
        return a(aim, aBU) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c it = fVar.it(0);
        if (it == null || !(it instanceof e)) {
            return false;
        }
        String page = ((e) it).arp().getPage();
        return swanAppConfigData.sO(page) || TextUtils.equals(swanAppConfigData.aBY(), page);
    }

    private boolean ark() {
        SwanAppConfigData aBU = com.baidu.swan.apps.v.f.aCp().aBU();
        return (aBU == null || TextUtils.equals(aBU.aBY(), this.cPG.getPage())) ? false : true;
    }

    public String arl() {
        return this.cPJ != null ? this.cPJ.alj() : "";
    }

    public List<String> arm() {
        ArrayList arrayList = new ArrayList();
        if (this.cPH != null && !this.cPH.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cPH.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().alj());
                }
            }
        }
        if (this.cPJ != null) {
            String alj = this.cPJ.alj();
            if (!arrayList.contains(alj)) {
                arrayList.add(alj);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        if ((aih() == null || !aih().aJE()) && !com.baidu.m.a.adk()) {
            if (this.cPJ != null) {
                if (com.baidu.swan.apps.media.b.qq(this.cPJ.alj())) {
                    return true;
                }
                return this.cPJ.alb();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void alI() {
        FragmentActivity bff = bff();
        if (this.cPm == null) {
            this.cPm = new SwanAppMenuHeaderView(getContext());
        }
        if (bff != null && this.cPl == null) {
            this.cPl = new com.baidu.swan.menu.h(bff, this.cPk, alJ(), com.baidu.swan.apps.t.a.aze(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPl, this, this.cPm).aEe();
            if (com.baidu.swan.apps.menu.fontsize.b.aEu()) {
                this.cPl.mX(50);
            }
        }
    }

    private int alJ() {
        return aqZ() ? ark() ? 18 : 17 : ark() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> arn() {
        if (this.cPJ == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cPJ.alh().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aro() {
        return this.cPK;
    }

    public com.baidu.swan.apps.model.b arp() {
        return this.cPG;
    }

    public com.baidu.swan.apps.adaptation.b.c arq() {
        return this.cPJ;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0480a
    public com.baidu.swan.apps.res.widget.floatlayer.a aih() {
        if (this.czE == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.czE = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aqU().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.czE;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aqQ() {
        return this.cPO;
    }

    private boolean arr() {
        return this.cPO != null && this.cPO.dzJ;
    }

    private boolean ars() {
        if (this.cPO == null) {
            return false;
        }
        return TextUtils.equals(this.cPO.dzL, "custom");
    }

    private void nB(String str) {
        if (!ars()) {
            com.baidu.swan.apps.v.f aCp = com.baidu.swan.apps.v.f.aCp();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aCp.qm(str).dzJ && this.cPQ == null) {
                this.cPQ = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.is(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cPQ != null) {
                cVar.a(this.cPQ);
            }
            cVar.a(art());
        }
    }

    private com.baidu.swan.apps.core.f.e art() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cPQ);
                    fVar.a(e.this.aru());
                    com.baidu.swan.apps.y.f.aEX().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cPQ);
                    com.baidu.swan.apps.y.f.aEX().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a aru() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void jn(String str) {
                e.this.nv(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cPQ != null && cVar != null) {
            cVar.b(this.cPQ);
            if (cVar.ala() != null) {
                cVar.b(this.cPQ);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void arv() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cPk != null) {
            if (ars()) {
                ff(true);
                i = 0;
                z = true;
            } else if (arr()) {
                ff(false);
                if (this.cPJ != null) {
                    if (this.cPJ.ala() != null) {
                        dVar = this.cPJ.ala().alh();
                    } else {
                        dVar = this.cPJ.alh();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cPO == null && this.cPO.dzK) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cPO == null) {
                }
                z = true;
            } else {
                ff(false);
                i = cPE + this.cPP;
            }
            TextView centerTitleView = this.cPk.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            is(i);
            fg(z);
        }
    }

    private void fg(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cPq == null || !this.cPq.aQa()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = aqU().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cPI.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cPI.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cPj.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cPj.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void is(int i) {
        TextView centerTitleView;
        View aPZ;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cPE) * 1.0f) / (this.cPP == 0 ? 1 : this.cPP);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cPq != null && this.cPq.aQa() && (aPZ = this.cPq.aPZ()) != null && (background = aPZ.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cPk.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cPO != null && this.cPO.dzK && (centerTitleView = this.cPk.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cPo.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void arw() {
        this.cPF = com.baidu.swan.apps.statistic.h.tD("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cPF != null) {
            com.baidu.swan.apps.statistic.h.a(this.cPF, gVar);
            this.cPF = null;
        }
    }

    public void arx() {
        this.cPO.dzL = "default";
        applyImmersion();
        arv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ary() {
        if (this.cPi != null) {
            this.cPi.ary();
        }
    }

    private void fh(boolean z) {
        if (com.baidu.swan.apps.x.a.ga(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cPk, com.baidu.swan.apps.runtime.e.aJV().aJY().aBu().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aJV() != null) {
            com.baidu.swan.apps.x.a.a(this.cPk, com.baidu.swan.apps.runtime.e.aJV().aKm().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void fi(boolean z) {
        if (com.baidu.swan.apps.x.a.ga(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cPl, com.baidu.swan.apps.runtime.e.aJV().aJY().aBu().paNumber);
        }
    }

    /* loaded from: classes25.dex */
    private static class a {
        static int cPV = -1;

        static int arz() {
            if (cPV < 0) {
                cPV = com.baidu.swan.apps.t.a.azd().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cPV);
            }
            return cPV;
        }

        static boolean arA() {
            return arz() > 0;
        }
    }
}
