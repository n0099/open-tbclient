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
/* loaded from: classes8.dex */
public class e extends c implements a.InterfaceC0432a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int chI = ah.H(149.0f);
    private static String chP = "-1";
    private static String chQ = chP;
    private static String chR;
    private com.baidu.swan.apps.res.widget.floatlayer.a bRF;
    private com.baidu.swan.apps.statistic.a chJ;
    private FrameLayout chM;
    private com.baidu.swan.apps.adaptation.b.c chN;
    private com.baidu.swan.apps.tabbar.b.a chO;
    private com.baidu.swan.apps.runtime.config.c chS;
    private com.baidu.swan.apps.core.f.c chU;
    private com.baidu.swan.apps.adaptation.a.ah chV;
    private View mRootView;
    private com.baidu.swan.apps.model.b chK = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> chL = new TreeMap();
    private int chT = 0;
    public boolean chW = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        agQ();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.chV = com.baidu.swan.apps.t.a.apz();
                e.this.chV.a(e.this.chm, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void agQ() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.chm = com.baidu.swan.apps.model.c.oB(arguments.getString("ai_apps_param"));
            this.chK.mPage = this.chm != null ? this.chm.getPage() : "";
            this.chK.mParams = this.chm != null ? this.chm.getParams() : "";
            this.chK.cDC = com.baidu.swan.apps.scheme.actions.k.j.qW(this.chK.getPage());
            this.chS = com.baidu.swan.apps.v.f.arY().nW(this.chK.auk());
            if (this.chS.cRO) {
                this.chS = com.baidu.swan.apps.v.f.arY().nX(this.chK.getPage());
            }
            this.chT = agF().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.h.E("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.chM = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ai(inflate);
        this.chO = new com.baidu.swan.apps.tabbar.b.a(this);
        am(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.auf() && !com.baidu.swan.apps.menu.fontsize.b.aud()) {
            com.baidu.swan.apps.menu.fontsize.a.bO(this.chN.aaU(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.auc()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.chN.aaD());
        com.baidu.swan.apps.y.f.auI().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aaK() {
        if (this.chN != null) {
            return this.chN.aaK();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        super.ai(view);
        dV(agA());
        if (agU()) {
            agz();
        }
        ahg();
        this.cho.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String aaU = e.this.chN.aaU();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cy(aaU, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.arY().a(aaU, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        this.chN.aaN();
        abt();
        dZ(true);
        if (this.chq != null) {
            this.chq.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mb(com.baidu.swan.apps.runtime.d.azE().getAppId()));
        }
        this.chp.a(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ(), this.chq, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agx() {
        agL();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e ahn = com.baidu.swan.apps.v.f.arY().ahn();
        com.baidu.swan.apps.model.c agM = ahn == null ? null : ahn.agM();
        if (agM != null && !TextUtils.isEmpty(agM.getPage())) {
            fVar.u("page", agM.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.chS)) {
            super.applyImmersion(i);
            return;
        }
        if (!ahd() && ac.cC(this.mActivity)) {
            z = false;
        }
        w(i, z);
        ahg();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean gV(int i) {
        boolean gV = super.gV(i);
        ahg();
        return gV;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        ahg();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dY(false);
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
        if (this.chp != null && this.chp.isShowing()) {
            this.chp.gZ(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.chN.aaU())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.chN.aaU())));
        }
    }

    public static void lh(String str) {
        chR = str;
    }

    private void agR() {
        if (!TextUtils.equals(chQ, this.chN.aaU()) || TextUtils.equals(chR, "switchTab")) {
            int sj = this.chO.sj(aha().auk());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cqL = chQ;
            eVar.cqM = this.chN.aaU();
            eVar.cik = chR;
            eVar.cqN = this.chK.mPage;
            eVar.cqO = String.valueOf(sj);
            chR = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cqL + " ,toId: " + eVar.cqM + " ,RouteType: " + eVar.cik + " page:" + eVar.cqN + ",TabIndex: " + eVar.cqO);
            }
            com.baidu.swan.apps.v.f.arY().b(eVar);
            chQ = this.chN.aaU();
        }
    }

    private void li(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.chN.aaU());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.chN.aaU());
        }
        com.baidu.swan.apps.v.f.arY().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        if (this.chN == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.chN.aaU());
        com.baidu.swan.apps.adaptation.b.f aaL = this.chN.aaL();
        if (aaL != null) {
            hashMap.put("webViewUrl", aaL.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void am(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String arF = this.chm.arF();
        String params = this.chm.getParams();
        String page = this.chm.getPage();
        String Q = ak.Q(arF, page, params);
        this.chN = com.baidu.swan.apps.core.slave.b.lP(Q);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Q + " is load: " + (this.chN != null));
        }
        if (this.chN == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.chN = p(arF, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c nW = com.baidu.swan.apps.v.f.arY().nW(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.chN.b(this.chM, nW);
        this.chN.a(this.chM, nW);
        lm(page);
        a(this.chN);
        if (agb()) {
            this.chL.put(page, this.chN);
            this.chO.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView end.");
        ahh();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.chL != null && !this.chL.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.chL.values()) {
                if (cVar != null) {
                    cVar.aaV();
                }
            }
        } else if (this.chN != null) {
            this.chN.aaV();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.ahl()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.agS();
                }
            });
        } else {
            agS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agS() {
        if (this.chL != null && !this.chL.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.chL.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.chL.clear();
        } else if (this.chN != null) {
            b(this.chN);
            this.chN.destroy();
        }
        this.chN = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.chW) {
            com.baidu.swan.apps.core.slave.b.bU(com.baidu.swan.apps.v.f.arY().arI());
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
                dY(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.chN == null;
        String aaU = z ? "" : this.chN.aaU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aaU);
        }
        if (!z) {
            dV(agA());
            this.chN.onResume();
            agR();
            li("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.eJ(true);
        if (com.baidu.swan.apps.console.c.adJ()) {
            com.baidu.swan.apps.core.c.b.afP();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aaK;
        boolean z = this.chN == null;
        String aaU = z ? "" : this.chN.aaU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aaU);
        }
        if (!z) {
            this.chN.onPause();
            li("onHide");
        }
        if (XS() != null && !XS().azs()) {
            XS().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.eJ(false);
        if (!z && (aaK = this.chN.aaK()) != null) {
            aaK.fr(false);
        }
    }

    public String lj(String str) {
        if (this.chL.containsKey(str)) {
            return this.chL.get(str).aaU();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.chO.sj(aha().auk()) != this.chO.sj(bVar.auk())) {
            this.chO.sg(bVar.auk());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.chL.get(bVar.cDC) == null) {
            String Q = ak.Q(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c lP = com.baidu.swan.apps.core.slave.b.lP(Q);
            if (lP != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Q);
                }
                this.chL.put(bVar.mPage, lP);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                lP = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.chL.put(bVar.mPage, lP);
            }
            lm(bVar.mPage);
            a(lP);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(aUT());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.bT("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", F.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + F);
        }
        com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0395b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0395b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cnl = F.cmK.aaP();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(F, str4);
                }
                String qW = com.baidu.swan.apps.scheme.actions.k.j.qW(str2);
                bVar.appPath = str;
                bVar.cnn = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.azJ() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.azJ().qm(qW);
                    bVar.cnp = com.baidu.swan.apps.runtime.e.azJ().qo(qW);
                }
                bVar.cnj = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.azI(), bVar.cnn);
                bVar.cno = com.baidu.swan.apps.v.f.arY().nW(qW).cno;
                bVar.cni = String.valueOf(com.baidu.swan.apps.console.a.adG());
                bVar.cnk = e.DEBUG || com.baidu.swan.apps.v.f.arY().arC();
                if (com.baidu.swan.apps.ad.a.a.axd()) {
                    bVar.cnm = com.baidu.swan.apps.console.debugger.b.adN();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cnq = str4;
                    com.baidu.swan.apps.performance.i.bT("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aEU();
                F.cmK.aaS().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                F.cmK.iJ(bVar.cnn);
                com.baidu.swan.apps.v.f.arY().a(F.cmK.aaU(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cl(F.cmK.aaU(), bVar.cnn);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.cmK;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.cDC;
        com.baidu.swan.apps.runtime.config.c nW = com.baidu.swan.apps.v.f.arY().nW(TextUtils.isEmpty(str3) ? "" : str3);
        this.chK.mPage = str2;
        this.chK.mParams = bVar != null ? bVar.getParams() : "";
        this.chK.cDC = str3;
        this.chS = nW;
        boolean z = false;
        if (ll(str3)) {
            lk(str3);
        } else {
            z = true;
            a(bVar, str);
            lk(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.T(7, str);
            } else {
                com.baidu.swan.apps.performance.j.T(6, str);
            }
            com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.pl(str);
        }
        lg(nW.cRE);
        gW(SwanAppConfigData.fn(nW.cRF));
        gV(nW.cRD);
        ahg();
        ahj();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + nW.cRE + " page:" + str2);
    }

    private void lk(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.chL.get(str);
        if (this.chN != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c nW = com.baidu.swan.apps.v.f.arY().nW(str);
            cVar.b(this.chM, nW);
            if (!cVar.aaJ()) {
                cVar.a(this.chM, nW);
            }
            cVar.gt(0);
            if (this.chN != null) {
                this.chN.gt(8);
            }
            this.chN = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.chM;
    }

    private boolean ll(String str) {
        return (this.chL.isEmpty() || this.chL.get(str) == null) ? false : true;
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
        return agA() && this.chN.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        SwanAppConfigData arD;
        com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
        if (arY == null || (arD = arY.arD()) == null || !arD.aAy() || this.chm == null) {
            return false;
        }
        return arD.qy(this.chm.getPage());
    }

    public boolean agT() {
        if (this.chO == null) {
            return false;
        }
        return this.chO.agT();
    }

    protected final boolean agU() {
        SwanAppConfigData arD;
        f XX = XX();
        if (XX == null) {
            return false;
        }
        if ((this.chS != null && this.chS.cRL) || (arD = com.baidu.swan.apps.v.f.arY().arD()) == null) {
            return false;
        }
        return a(XX, arD) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c gY = fVar.gY(0);
        if (gY == null || !(gY instanceof e)) {
            return false;
        }
        String page = ((e) gY).aha().getPage();
        return swanAppConfigData.qy(page) || TextUtils.equals(swanAppConfigData.arH(), page);
    }

    private boolean agV() {
        SwanAppConfigData arD = com.baidu.swan.apps.v.f.arY().arD();
        return (arD == null || TextUtils.equals(arD.arH(), this.chK.getPage())) ? false : true;
    }

    public String agW() {
        return this.chN != null ? this.chN.aaU() : "";
    }

    public List<String> agX() {
        ArrayList arrayList = new ArrayList();
        if (this.chL != null && !this.chL.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.chL.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aaU());
                }
            }
        }
        if (this.chN != null) {
            String aaU = this.chN.aaU();
            if (!arrayList.contains(aaU)) {
                arrayList.add(aaU);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if ((XS() == null || !XS().azs()) && !com.baidu.l.a.TM()) {
            if (this.chN != null) {
                if (com.baidu.swan.apps.media.b.oa(this.chN.aaU())) {
                    return true;
                }
                return this.chN.aaM();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (this.chq == null) {
            this.chq = new SwanAppMenuHeaderView(getContext());
        }
        if (aUT != null && this.chp == null) {
            this.chp = new com.baidu.swan.menu.h(aUT, this.cho, abu(), com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.chp, this, this.chq).atP();
            if (com.baidu.swan.apps.menu.fontsize.b.auf()) {
                this.chp.lA(50);
            }
        }
    }

    private int abu() {
        return agK() ? agV() ? 18 : 17 : agV() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> agY() {
        if (this.chN == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.chN.aaS().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a agZ() {
        return this.chO;
    }

    public com.baidu.swan.apps.model.b aha() {
        return this.chK;
    }

    public com.baidu.swan.apps.adaptation.b.c ahb() {
        return this.chN;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0432a
    public com.baidu.swan.apps.res.widget.floatlayer.a XS() {
        if (this.bRF == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bRF = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), agF().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bRF;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c agB() {
        return this.chS;
    }

    private boolean ahc() {
        return this.chS != null && this.chS.cRI;
    }

    private boolean ahd() {
        if (this.chS == null) {
            return false;
        }
        return TextUtils.equals(this.chS.cRK, "custom");
    }

    private void lm(String str) {
        if (!ahd()) {
            com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (arY.nW(str).cRI && this.chU == null) {
                this.chU = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.gX(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.chU != null) {
                cVar.a(this.chU);
            }
            cVar.a(ahe());
        }
    }

    private com.baidu.swan.apps.core.f.e ahe() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.chU);
                    fVar.a(e.this.ahf());
                    com.baidu.swan.apps.y.f.auI().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.chU);
                    com.baidu.swan.apps.y.f.auI().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a ahf() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ht(String str) {
                e.this.lg(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.chU != null && cVar != null) {
            cVar.b(this.chU);
            if (cVar.aaL() != null) {
                cVar.b(this.chU);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void ahg() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cho != null) {
            if (ahd()) {
                dW(true);
                i = 0;
                z = true;
            } else if (ahc()) {
                dW(false);
                if (this.chN != null) {
                    if (this.chN.aaL() != null) {
                        dVar = this.chN.aaL().aaS();
                    } else {
                        dVar = this.chN.aaS();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.chS == null && this.chS.cRJ) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.chS == null) {
                }
                z = true;
            } else {
                dW(false);
                i = chI + this.chT;
            }
            TextView centerTitleView = this.cho.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            gX(i);
            dX(z);
        }
    }

    private void dX(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.chu == null || !this.chu.aFP()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = agF().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.chM.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.chM.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.chn.getLayoutParams();
        layoutParams2.topMargin = i;
        this.chn.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        TextView centerTitleView;
        View aFO;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - chI) * 1.0f) / (this.chT == 0 ? 1 : this.chT);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.chu != null && this.chu.aFP() && (aFO = this.chu.aFO()) != null && (background = aFO.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cho.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.chS != null && this.chS.cRJ && (centerTitleView = this.cho.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.chs.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void ahh() {
        this.chJ = com.baidu.swan.apps.statistic.h.rn("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.chJ != null) {
            com.baidu.swan.apps.statistic.h.a(this.chJ, gVar);
            this.chJ = null;
        }
    }

    public void ahi() {
        this.chS.cRK = "default";
        applyImmersion();
        ahg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ahj() {
        if (this.chm != null) {
            this.chm.ahj();
        }
    }

    private void dY(boolean z) {
        if (com.baidu.swan.apps.x.a.eR(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cho, com.baidu.swan.apps.runtime.e.azJ().azM().ard().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.azJ() != null) {
            com.baidu.swan.apps.x.a.a(this.cho, com.baidu.swan.apps.runtime.e.azJ().aAa().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dZ(boolean z) {
        if (com.baidu.swan.apps.x.a.eR(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.chp, com.baidu.swan.apps.runtime.e.azJ().azM().ard().paNumber);
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        static int chZ = -1;

        static int ahk() {
            if (chZ < 0) {
                chZ = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + chZ);
            }
            return chZ;
        }

        static boolean ahl() {
            return ahk() > 0;
        }
    }
}
