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
/* loaded from: classes7.dex */
public class e extends c implements a.InterfaceC0468a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cIL = ah.M(149.0f);
    private static String cIS = "-1";
    private static String cIT = cIS;
    private static String cIU;
    private com.baidu.swan.apps.statistic.a cIM;
    private FrameLayout cIP;
    private com.baidu.swan.apps.adaptation.b.c cIQ;
    private com.baidu.swan.apps.tabbar.b.a cIR;
    private com.baidu.swan.apps.runtime.config.c cIV;
    private com.baidu.swan.apps.core.f.c cIX;
    private com.baidu.swan.apps.adaptation.a.ah cIY;
    private com.baidu.swan.apps.res.widget.floatlayer.a csI;
    private View mRootView;
    private com.baidu.swan.apps.model.b cIN = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cIO = new TreeMap();
    private int cIW = 0;
    public boolean cIZ = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        anX();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cIY = com.baidu.swan.apps.t.a.awH();
                e.this.cIY.a(e.this.cIp, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.D("route", "fragment create.");
    }

    private void anX() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cIp = com.baidu.swan.apps.model.c.qi(arguments.getString("ai_apps_param"));
            this.cIN.mPage = this.cIp != null ? this.cIp.getPage() : "";
            this.cIN.mParams = this.cIp != null ? this.cIp.getParams() : "";
            this.cIN.dew = com.baidu.swan.apps.scheme.actions.k.j.sF(this.cIN.getPage());
            this.cIV = com.baidu.swan.apps.v.f.azg().pF(this.cIN.aBq());
            if (this.cIV.dsP) {
                this.cIV = com.baidu.swan.apps.v.f.azg().pG(this.cIN.getPage());
            }
            this.cIW = anM().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cIP = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ar(inflate);
        this.cIR = new com.baidu.swan.apps.tabbar.b.a(this);
        au(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aBl() && !com.baidu.swan.apps.menu.fontsize.b.aBj()) {
            com.baidu.swan.apps.menu.fontsize.a.bZ(this.cIQ.aib(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBi()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cIQ.ahK());
        com.baidu.swan.apps.y.f.aBO().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView ahR() {
        if (this.cIQ != null) {
            return this.cIQ.ahR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        super.ar(view);
        eP(anH());
        if (aob()) {
            anG();
        }
        aon();
        this.cIr.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String aib = e.this.cIQ.aib();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cJ(aib, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.azg().a(aib, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
        this.cIQ.ahU();
        aiA();
        eT(true);
        if (this.cIt != null) {
            this.cIt.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nI(com.baidu.swan.apps.runtime.d.aGI().getAppId()));
        }
        this.cIs.a(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState(), anQ(), this.cIt, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anE() {
        anS();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e aou = com.baidu.swan.apps.v.f.azg().aou();
        com.baidu.swan.apps.model.c anT = aou == null ? null : aou.anT();
        if (anT != null && !TextUtils.isEmpty(anT.getPage())) {
            fVar.u("page", anT.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cIV)) {
            super.applyImmersion(i);
            return;
        }
        if (!aok() && ac.cH(this.mActivity)) {
            z = false;
        }
        y(i, z);
        aon();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean hS(int i) {
        boolean hS = super.hS(i);
        aon();
        return hS;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        aon();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        eS(false);
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
        if (this.cIs != null && this.cIs.isShowing()) {
            this.cIs.hT(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cIQ.aib())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cIQ.aib())));
        }
    }

    public static void mP(String str) {
        cIU = str;
    }

    private void anY() {
        if (!TextUtils.equals(cIT, this.cIQ.aib()) || TextUtils.equals(cIU, "switchTab")) {
            int tS = this.cIR.tS(aoh().aBq());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cRI = cIT;
            eVar.cRJ = this.cIQ.aib();
            eVar.cJm = cIU;
            eVar.cRK = this.cIN.mPage;
            eVar.cRL = String.valueOf(tS);
            cIU = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cRI + " ,toId: " + eVar.cRJ + " ,RouteType: " + eVar.cJm + " page:" + eVar.cRK + ",TabIndex: " + eVar.cRL);
            }
            com.baidu.swan.apps.v.f.azg().b(eVar);
            cIT = this.cIQ.aib();
        }
    }

    private void mQ(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cIQ.aib());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cIQ.aib());
        }
        com.baidu.swan.apps.v.f.azg().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anl() {
        if (this.cIQ == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cIQ.aib());
        com.baidu.swan.apps.adaptation.b.f ahS = this.cIQ.ahS();
        if (ahS != null) {
            hashMap.put("webViewUrl", ahS.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void au(View view) {
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView start.");
        String ayN = this.cIp.ayN();
        String params = this.cIp.getParams();
        String page = this.cIp.getPage();
        String Y = ak.Y(ayN, page, params);
        this.cIQ = com.baidu.swan.apps.core.slave.b.nx(Y);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Y + " is load: " + (this.cIQ != null));
        }
        if (this.cIQ == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cIQ = q(ayN, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c pF = com.baidu.swan.apps.v.f.azg().pF(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cIQ.b(this.cIP, pF);
        this.cIQ.a(this.cIP, pF);
        mU(page);
        a(this.cIQ);
        if (ani()) {
            this.cIO.put(page, this.cIQ);
            this.cIR.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView end.");
        aoo();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cIO != null && !this.cIO.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cIO.values()) {
                if (cVar != null) {
                    cVar.aic();
                }
            }
        } else if (this.cIQ != null) {
            this.cIQ.aic();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.aos()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.anZ();
                }
            });
        } else {
            anZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anZ() {
        if (this.cIO != null && !this.cIO.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cIO.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cIO.clear();
        } else if (this.cIQ != null) {
            b(this.cIQ);
            this.cIQ.destroy();
        }
        this.cIQ = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cIZ) {
            com.baidu.swan.apps.core.slave.b.bZ(com.baidu.swan.apps.v.f.azg().ayQ());
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
                eS(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cIQ == null;
        String aib = z ? "" : this.cIQ.aib();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aib);
        }
        if (!z) {
            eP(anH());
            this.cIQ.onResume();
            anY();
            mQ("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fD(true);
        if (com.baidu.swan.apps.console.c.akQ()) {
            com.baidu.swan.apps.core.c.b.amW();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView ahR;
        boolean z = this.cIQ == null;
        String aib = z ? "" : this.cIQ.aib();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aib);
        }
        if (!z) {
            this.cIQ.onPause();
            mQ("onHide");
        }
        if (aeZ() != null && !aeZ().aGw()) {
            aeZ().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fD(false);
        if (!z && (ahR = this.cIQ.ahR()) != null) {
            ahR.gl(false);
        }
    }

    public String mR(String str) {
        if (this.cIO.containsKey(str)) {
            return this.cIO.get(str).aib();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cIR.tS(aoh().aBq()) != this.cIR.tS(bVar.aBq())) {
            this.cIR.tP(bVar.aBq());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cIO.get(bVar.dew) == null) {
            String Y = ak.Y(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c nx = com.baidu.swan.apps.core.slave.b.nx(Y);
            if (nx != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Y);
                }
                this.cIO.put(bVar.mPage, nx);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                nx = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cIO.put(bVar.mPage, nx);
            }
            mU(bVar.mPage);
            a(nx);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(bca());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.ce("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).ch("preload", G.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + G);
        }
        com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0431b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0431b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cOm = G.cNL.ahW();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(G, str4);
                }
                String sF = com.baidu.swan.apps.scheme.actions.k.j.sF(str2);
                bVar.appPath = str;
                bVar.cOo = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aGN() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aGN().rT(sF);
                    bVar.cOq = com.baidu.swan.apps.runtime.e.aGN().rV(sF);
                }
                bVar.cOk = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aGM(), bVar.cOo);
                bVar.cOp = com.baidu.swan.apps.v.f.azg().pF(sF).cOp;
                bVar.cOj = String.valueOf(com.baidu.swan.apps.console.a.akN());
                bVar.cOl = e.DEBUG || com.baidu.swan.apps.v.f.azg().ayK();
                if (com.baidu.swan.apps.ad.a.a.aEj()) {
                    bVar.cOn = com.baidu.swan.apps.console.debugger.b.akU();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cOr = str4;
                    com.baidu.swan.apps.performance.i.ce("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aLZ();
                G.cNL.ahZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                G.cNL.kr(bVar.cOo);
                com.baidu.swan.apps.v.f.azg().a(G.cNL.aib(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cw(G.cNL.aib(), bVar.cOo);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return G.cNL;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dew;
        com.baidu.swan.apps.runtime.config.c pF = com.baidu.swan.apps.v.f.azg().pF(TextUtils.isEmpty(str3) ? "" : str3);
        this.cIN.mPage = str2;
        this.cIN.mParams = bVar != null ? bVar.getParams() : "";
        this.cIN.dew = str3;
        this.cIV = pF;
        boolean z = false;
        if (mT(str3)) {
            mS(str3);
        } else {
            z = true;
            a(bVar, str);
            mS(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.al(7, str);
            } else {
                com.baidu.swan.apps.performance.j.al(6, str);
            }
            com.baidu.swan.apps.performance.i.ce("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qS(str);
        }
        mO(pF.dsF);
        hT(SwanAppConfigData.sa(pF.dsG));
        hS(pF.dsE);
        aon();
        aoq();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + pF.dsF + " page:" + str2);
    }

    private void mS(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cIO.get(str);
        if (this.cIQ != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c pF = com.baidu.swan.apps.v.f.azg().pF(str);
            cVar.b(this.cIP, pF);
            if (!cVar.ahQ()) {
                cVar.a(this.cIP, pF);
            }
            cVar.hq(0);
            if (this.cIQ != null) {
                this.cIQ.hq(8);
            }
            this.cIQ = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cIP;
    }

    private boolean mT(String str) {
        return (this.cIO.isEmpty() || this.cIO.get(str) == null) ? false : true;
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
        return anH() && this.cIQ.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        SwanAppConfigData ayL;
        com.baidu.swan.apps.v.f azg = com.baidu.swan.apps.v.f.azg();
        if (azg == null || (ayL = azg.ayL()) == null || !ayL.aHC() || this.cIp == null) {
            return false;
        }
        return ayL.sg(this.cIp.getPage());
    }

    public boolean aoa() {
        if (this.cIR == null) {
            return false;
        }
        return this.cIR.aoa();
    }

    protected final boolean aob() {
        SwanAppConfigData ayL;
        f afe = afe();
        if (afe == null) {
            return false;
        }
        if ((this.cIV != null && this.cIV.dsM) || (ayL = com.baidu.swan.apps.v.f.azg().ayL()) == null) {
            return false;
        }
        return a(afe, ayL) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c hV = fVar.hV(0);
        if (hV == null || !(hV instanceof e)) {
            return false;
        }
        String page = ((e) hV).aoh().getPage();
        return swanAppConfigData.sg(page) || TextUtils.equals(swanAppConfigData.ayP(), page);
    }

    private boolean aoc() {
        SwanAppConfigData ayL = com.baidu.swan.apps.v.f.azg().ayL();
        return (ayL == null || TextUtils.equals(ayL.ayP(), this.cIN.getPage())) ? false : true;
    }

    public String aod() {
        return this.cIQ != null ? this.cIQ.aib() : "";
    }

    public List<String> aoe() {
        ArrayList arrayList = new ArrayList();
        if (this.cIO != null && !this.cIO.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cIO.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aib());
                }
            }
        }
        if (this.cIQ != null) {
            String aib = this.cIQ.aib();
            if (!arrayList.contains(aib)) {
                arrayList.add(aib);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        if ((aeZ() == null || !aeZ().aGw()) && !com.baidu.l.a.aac()) {
            if (this.cIQ != null) {
                if (com.baidu.swan.apps.media.b.pJ(this.cIQ.aib())) {
                    return true;
                }
                return this.cIQ.ahT();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void aiA() {
        FragmentActivity bca = bca();
        if (this.cIt == null) {
            this.cIt = new SwanAppMenuHeaderView(getContext());
        }
        if (bca != null && this.cIs == null) {
            this.cIs = new com.baidu.swan.menu.h(bca, this.cIr, aiB(), com.baidu.swan.apps.t.a.avW(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cIs, this, this.cIt).aAV();
            if (com.baidu.swan.apps.menu.fontsize.b.aBl()) {
                this.cIs.mz(50);
            }
        }
    }

    private int aiB() {
        return anR() ? aoc() ? 18 : 17 : aoc() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> aof() {
        if (this.cIQ == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cIQ.ahZ().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aog() {
        return this.cIR;
    }

    public com.baidu.swan.apps.model.b aoh() {
        return this.cIN;
    }

    public com.baidu.swan.apps.adaptation.b.c aoi() {
        return this.cIQ;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0468a
    public com.baidu.swan.apps.res.widget.floatlayer.a aeZ() {
        if (this.csI == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.csI = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), anM().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.csI;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c anI() {
        return this.cIV;
    }

    private boolean aoj() {
        return this.cIV != null && this.cIV.dsJ;
    }

    private boolean aok() {
        if (this.cIV == null) {
            return false;
        }
        return TextUtils.equals(this.cIV.dsL, "custom");
    }

    private void mU(String str) {
        if (!aok()) {
            com.baidu.swan.apps.v.f azg = com.baidu.swan.apps.v.f.azg();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (azg.pF(str).dsJ && this.cIX == null) {
                this.cIX = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.hU(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cIX != null) {
                cVar.a(this.cIX);
            }
            cVar.a(aol());
        }
    }

    private com.baidu.swan.apps.core.f.e aol() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cIX);
                    fVar.a(e.this.aom());
                    com.baidu.swan.apps.y.f.aBO().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cIX);
                    com.baidu.swan.apps.y.f.aBO().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a aom() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iJ(String str) {
                e.this.mO(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cIX != null && cVar != null) {
            cVar.b(this.cIX);
            if (cVar.ahS() != null) {
                cVar.b(this.cIX);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void aon() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cIr != null) {
            if (aok()) {
                eQ(true);
                i = 0;
                z = true;
            } else if (aoj()) {
                eQ(false);
                if (this.cIQ != null) {
                    if (this.cIQ.ahS() != null) {
                        dVar = this.cIQ.ahS().ahZ();
                    } else {
                        dVar = this.cIQ.ahZ();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cIV == null && this.cIV.dsK) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cIV == null) {
                }
                z = true;
            } else {
                eQ(false);
                i = cIL + this.cIW;
            }
            TextView centerTitleView = this.cIr.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            hU(i);
            eR(z);
        }
    }

    private void eR(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cIx == null || !this.cIx.aMU()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = anM().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cIP.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cIP.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cIq.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cIq.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(int i) {
        TextView centerTitleView;
        View aMT;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cIL) * 1.0f) / (this.cIW == 0 ? 1 : this.cIW);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cIx != null && this.cIx.aMU() && (aMT = this.cIx.aMT()) != null && (background = aMT.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cIr.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cIV != null && this.cIV.dsK && (centerTitleView = this.cIr.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cIv.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void aoo() {
        this.cIM = com.baidu.swan.apps.statistic.h.sW("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cIM != null) {
            com.baidu.swan.apps.statistic.h.a(this.cIM, gVar);
            this.cIM = null;
        }
    }

    public void aop() {
        this.cIV.dsL = "default";
        applyImmersion();
        aon();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoq() {
        if (this.cIp != null) {
            this.cIp.aoq();
        }
    }

    private void eS(boolean z) {
        if (com.baidu.swan.apps.x.a.fL(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cIr, com.baidu.swan.apps.runtime.e.aGN().aGQ().ayl().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aGN() != null) {
            com.baidu.swan.apps.x.a.a(this.cIr, com.baidu.swan.apps.runtime.e.aGN().aHe().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void eT(boolean z) {
        if (com.baidu.swan.apps.x.a.fL(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cIs, com.baidu.swan.apps.runtime.e.aGN().aGQ().ayl().paNumber);
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        static int cJc = -1;

        static int aor() {
            if (cJc < 0) {
                cJc = com.baidu.swan.apps.t.a.avV().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cJc);
            }
            return cJc;
        }

        static boolean aos() {
            return aor() > 0;
        }
    }
}
