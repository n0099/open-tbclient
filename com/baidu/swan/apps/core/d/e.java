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
    private static final int chM = ah.H(149.0f);
    private static String chT = "-1";
    private static String chU = chT;
    private static String chV;
    private com.baidu.swan.apps.res.widget.floatlayer.a bRJ;
    private com.baidu.swan.apps.statistic.a chN;
    private FrameLayout chQ;
    private com.baidu.swan.apps.adaptation.b.c chR;
    private com.baidu.swan.apps.tabbar.b.a chS;
    private com.baidu.swan.apps.runtime.config.c chW;
    private com.baidu.swan.apps.core.f.c chY;
    private com.baidu.swan.apps.adaptation.a.ah chZ;
    private View mRootView;
    private com.baidu.swan.apps.model.b chO = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> chP = new TreeMap();
    private int chX = 0;
    public boolean cia = false;

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
                e.this.chZ = com.baidu.swan.apps.t.a.apz();
                e.this.chZ.a(e.this.chq, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void agQ() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.chq = com.baidu.swan.apps.model.c.oC(arguments.getString("ai_apps_param"));
            this.chO.mPage = this.chq != null ? this.chq.getPage() : "";
            this.chO.mParams = this.chq != null ? this.chq.getParams() : "";
            this.chO.cDG = com.baidu.swan.apps.scheme.actions.k.j.qX(this.chO.getPage());
            this.chW = com.baidu.swan.apps.v.f.arY().nX(this.chO.auk());
            if (this.chW.cRS) {
                this.chW = com.baidu.swan.apps.v.f.arY().nY(this.chO.getPage());
            }
            this.chX = agF().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.chQ = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ai(inflate);
        this.chS = new com.baidu.swan.apps.tabbar.b.a(this);
        am(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.auf() && !com.baidu.swan.apps.menu.fontsize.b.aud()) {
            com.baidu.swan.apps.menu.fontsize.a.bO(this.chR.aaU(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.auc()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.chR.aaD());
        com.baidu.swan.apps.y.f.auI().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aaK() {
        if (this.chR != null) {
            return this.chR.aaK();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        super.ai(view);
        dW(agA());
        if (agU()) {
            agz();
        }
        ahg();
        this.chs.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String aaU = e.this.chR.aaU();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cy(aaU, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.arY().a(aaU, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        this.chR.aaN();
        abt();
        ea(true);
        if (this.chu != null) {
            this.chu.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mc(com.baidu.swan.apps.runtime.d.azE().getAppId()));
        }
        this.cht.a(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ(), this.chu, false);
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
        if (!com.baidu.swan.apps.runtime.config.c.a(this.chW)) {
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
        dZ(false);
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
        if (this.cht != null && this.cht.isShowing()) {
            this.cht.ha(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.chR.aaU())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.chR.aaU())));
        }
    }

    public static void li(String str) {
        chV = str;
    }

    private void agR() {
        if (!TextUtils.equals(chU, this.chR.aaU()) || TextUtils.equals(chV, "switchTab")) {
            int sk = this.chS.sk(aha().auk());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cqP = chU;
            eVar.cqQ = this.chR.aaU();
            eVar.cio = chV;
            eVar.cqR = this.chO.mPage;
            eVar.cqS = String.valueOf(sk);
            chV = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cqP + " ,toId: " + eVar.cqQ + " ,RouteType: " + eVar.cio + " page:" + eVar.cqR + ",TabIndex: " + eVar.cqS);
            }
            com.baidu.swan.apps.v.f.arY().b(eVar);
            chU = this.chR.aaU();
        }
    }

    private void lj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.chR.aaU());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.chR.aaU());
        }
        com.baidu.swan.apps.v.f.arY().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        if (this.chR == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.chR.aaU());
        com.baidu.swan.apps.adaptation.b.f aaL = this.chR.aaL();
        if (aaL != null) {
            hashMap.put("webViewUrl", aaL.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void am(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String arF = this.chq.arF();
        String params = this.chq.getParams();
        String page = this.chq.getPage();
        String Q = ak.Q(arF, page, params);
        this.chR = com.baidu.swan.apps.core.slave.b.lQ(Q);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Q + " is load: " + (this.chR != null));
        }
        if (this.chR == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.chR = p(arF, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c nX = com.baidu.swan.apps.v.f.arY().nX(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.chR.b(this.chQ, nX);
        this.chR.a(this.chQ, nX);
        ln(page);
        a(this.chR);
        if (agb()) {
            this.chP.put(page, this.chR);
            this.chS.a(view, getContext(), page);
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
        if (this.chP != null && !this.chP.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.chP.values()) {
                if (cVar != null) {
                    cVar.aaV();
                }
            }
        } else if (this.chR != null) {
            this.chR.aaV();
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
        if (this.chP != null && !this.chP.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.chP.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.chP.clear();
        } else if (this.chR != null) {
            b(this.chR);
            this.chR.destroy();
        }
        this.chR = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cia) {
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
                dZ(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.chR == null;
        String aaU = z ? "" : this.chR.aaU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aaU);
        }
        if (!z) {
            dW(agA());
            this.chR.onResume();
            agR();
            lj("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.eK(true);
        if (com.baidu.swan.apps.console.c.adJ()) {
            com.baidu.swan.apps.core.c.b.afP();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aaK;
        boolean z = this.chR == null;
        String aaU = z ? "" : this.chR.aaU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aaU);
        }
        if (!z) {
            this.chR.onPause();
            lj("onHide");
        }
        if (XS() != null && !XS().azs()) {
            XS().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.eK(false);
        if (!z && (aaK = this.chR.aaK()) != null) {
            aaK.fs(false);
        }
    }

    public String lk(String str) {
        if (this.chP.containsKey(str)) {
            return this.chP.get(str).aaU();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.chS.sk(aha().auk()) != this.chS.sk(bVar.auk())) {
            this.chS.sh(bVar.auk());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.chP.get(bVar.cDG) == null) {
            String Q = ak.Q(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c lQ = com.baidu.swan.apps.core.slave.b.lQ(Q);
            if (lQ != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Q);
                }
                this.chP.put(bVar.mPage, lQ);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                lQ = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.chP.put(bVar.mPage, lQ);
            }
            ln(bVar.mPage);
            a(lQ);
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
                bVar.cnp = F.cmO.aaP();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(F, str4);
                }
                String qX = com.baidu.swan.apps.scheme.actions.k.j.qX(str2);
                bVar.appPath = str;
                bVar.cnr = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.azJ() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.azJ().qn(qX);
                    bVar.cnu = com.baidu.swan.apps.runtime.e.azJ().qp(qX);
                }
                bVar.cnn = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.azI(), bVar.cnr);
                bVar.cns = com.baidu.swan.apps.v.f.arY().nX(qX).cns;
                bVar.cnm = String.valueOf(com.baidu.swan.apps.console.a.adG());
                bVar.cno = e.DEBUG || com.baidu.swan.apps.v.f.arY().arC();
                if (com.baidu.swan.apps.ad.a.a.axd()) {
                    bVar.cnq = com.baidu.swan.apps.console.debugger.b.adN();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cnv = str4;
                    com.baidu.swan.apps.performance.i.bT("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aEU();
                F.cmO.aaS().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                F.cmO.iK(bVar.cnr);
                com.baidu.swan.apps.v.f.arY().a(F.cmO.aaU(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cl(F.cmO.aaU(), bVar.cnr);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.cmO;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.cDG;
        com.baidu.swan.apps.runtime.config.c nX = com.baidu.swan.apps.v.f.arY().nX(TextUtils.isEmpty(str3) ? "" : str3);
        this.chO.mPage = str2;
        this.chO.mParams = bVar != null ? bVar.getParams() : "";
        this.chO.cDG = str3;
        this.chW = nX;
        boolean z = false;
        if (lm(str3)) {
            ll(str3);
        } else {
            z = true;
            a(bVar, str);
            ll(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.T(7, str);
            } else {
                com.baidu.swan.apps.performance.j.T(6, str);
            }
            com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.pm(str);
        }
        lh(nX.cRI);
        gW(SwanAppConfigData.fo(nX.cRJ));
        gV(nX.cRH);
        ahg();
        ahj();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + nX.cRI + " page:" + str2);
    }

    private void ll(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.chP.get(str);
        if (this.chR != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c nX = com.baidu.swan.apps.v.f.arY().nX(str);
            cVar.b(this.chQ, nX);
            if (!cVar.aaJ()) {
                cVar.a(this.chQ, nX);
            }
            cVar.gt(0);
            if (this.chR != null) {
                this.chR.gt(8);
            }
            this.chR = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.chQ;
    }

    private boolean lm(String str) {
        return (this.chP.isEmpty() || this.chP.get(str) == null) ? false : true;
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
        return agA() && this.chR.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        SwanAppConfigData arD;
        com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
        if (arY == null || (arD = arY.arD()) == null || !arD.aAy() || this.chq == null) {
            return false;
        }
        return arD.qz(this.chq.getPage());
    }

    public boolean agT() {
        if (this.chS == null) {
            return false;
        }
        return this.chS.agT();
    }

    protected final boolean agU() {
        SwanAppConfigData arD;
        f XX = XX();
        if (XX == null) {
            return false;
        }
        if ((this.chW != null && this.chW.cRP) || (arD = com.baidu.swan.apps.v.f.arY().arD()) == null) {
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
        return swanAppConfigData.qz(page) || TextUtils.equals(swanAppConfigData.arH(), page);
    }

    private boolean agV() {
        SwanAppConfigData arD = com.baidu.swan.apps.v.f.arY().arD();
        return (arD == null || TextUtils.equals(arD.arH(), this.chO.getPage())) ? false : true;
    }

    public String agW() {
        return this.chR != null ? this.chR.aaU() : "";
    }

    public List<String> agX() {
        ArrayList arrayList = new ArrayList();
        if (this.chP != null && !this.chP.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.chP.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aaU());
                }
            }
        }
        if (this.chR != null) {
            String aaU = this.chR.aaU();
            if (!arrayList.contains(aaU)) {
                arrayList.add(aaU);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if ((XS() == null || !XS().azs()) && !com.baidu.l.a.TM()) {
            if (this.chR != null) {
                if (com.baidu.swan.apps.media.b.ob(this.chR.aaU())) {
                    return true;
                }
                return this.chR.aaM();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (this.chu == null) {
            this.chu = new SwanAppMenuHeaderView(getContext());
        }
        if (aUT != null && this.cht == null) {
            this.cht = new com.baidu.swan.menu.h(aUT, this.chs, abu(), com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cht, this, this.chu).atP();
            if (com.baidu.swan.apps.menu.fontsize.b.auf()) {
                this.cht.lA(50);
            }
        }
    }

    private int abu() {
        return agK() ? agV() ? 18 : 17 : agV() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> agY() {
        if (this.chR == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.chR.aaS().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a agZ() {
        return this.chS;
    }

    public com.baidu.swan.apps.model.b aha() {
        return this.chO;
    }

    public com.baidu.swan.apps.adaptation.b.c ahb() {
        return this.chR;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0432a
    public com.baidu.swan.apps.res.widget.floatlayer.a XS() {
        if (this.bRJ == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bRJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), agF().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bRJ;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c agB() {
        return this.chW;
    }

    private boolean ahc() {
        return this.chW != null && this.chW.cRM;
    }

    private boolean ahd() {
        if (this.chW == null) {
            return false;
        }
        return TextUtils.equals(this.chW.cRO, "custom");
    }

    private void ln(String str) {
        if (!ahd()) {
            com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (arY.nX(str).cRM && this.chY == null) {
                this.chY = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
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
            if (this.chY != null) {
                cVar.a(this.chY);
            }
            cVar.a(ahe());
        }
    }

    private com.baidu.swan.apps.core.f.e ahe() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.chY);
                    fVar.a(e.this.ahf());
                    com.baidu.swan.apps.y.f.auI().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.chY);
                    com.baidu.swan.apps.y.f.auI().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a ahf() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hu(String str) {
                e.this.lh(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.chY != null && cVar != null) {
            cVar.b(this.chY);
            if (cVar.aaL() != null) {
                cVar.b(this.chY);
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
        if (this.chs != null) {
            if (ahd()) {
                dX(true);
                i = 0;
                z = true;
            } else if (ahc()) {
                dX(false);
                if (this.chR != null) {
                    if (this.chR.aaL() != null) {
                        dVar = this.chR.aaL().aaS();
                    } else {
                        dVar = this.chR.aaS();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.chW == null && this.chW.cRN) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.chW == null) {
                }
                z = true;
            } else {
                dX(false);
                i = chM + this.chX;
            }
            TextView centerTitleView = this.chs.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            gX(i);
            dY(z);
        }
    }

    private void dY(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.chy == null || !this.chy.aFP()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = agF().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.chQ.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.chQ.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.chr.getLayoutParams();
        layoutParams2.topMargin = i;
        this.chr.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        TextView centerTitleView;
        View aFO;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - chM) * 1.0f) / (this.chX == 0 ? 1 : this.chX);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.chy != null && this.chy.aFP() && (aFO = this.chy.aFO()) != null && (background = aFO.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.chs.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.chW != null && this.chW.cRN && (centerTitleView = this.chs.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.chw.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void ahh() {
        this.chN = com.baidu.swan.apps.statistic.h.ro("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.chN != null) {
            com.baidu.swan.apps.statistic.h.a(this.chN, gVar);
            this.chN = null;
        }
    }

    public void ahi() {
        this.chW.cRO = "default";
        applyImmersion();
        ahg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ahj() {
        if (this.chq != null) {
            this.chq.ahj();
        }
    }

    private void dZ(boolean z) {
        if (com.baidu.swan.apps.x.a.eS(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.chs, com.baidu.swan.apps.runtime.e.azJ().azM().ard().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.azJ() != null) {
            com.baidu.swan.apps.x.a.a(this.chs, com.baidu.swan.apps.runtime.e.azJ().aAa().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void ea(boolean z) {
        if (com.baidu.swan.apps.x.a.eS(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cht, com.baidu.swan.apps.runtime.e.azJ().azM().ard().paNumber);
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        static int cie = -1;

        static int ahk() {
            if (cie < 0) {
                cie = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cie);
            }
            return cie;
        }

        static boolean ahl() {
            return ahk() > 0;
        }
    }
}
