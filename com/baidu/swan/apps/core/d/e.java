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
/* loaded from: classes3.dex */
public class e extends c implements a.InterfaceC0427a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cjO = ah.H(149.0f);
    private static String cjV = "-1";
    private static String cjW = cjV;
    private static String cjX;
    private com.baidu.swan.apps.res.widget.floatlayer.a bTJ;
    private com.baidu.swan.apps.statistic.a cjP;
    private FrameLayout cjS;
    private com.baidu.swan.apps.adaptation.b.c cjT;
    private com.baidu.swan.apps.tabbar.b.a cjU;
    private com.baidu.swan.apps.runtime.config.c cjY;
    private com.baidu.swan.apps.core.f.c cka;
    private com.baidu.swan.apps.adaptation.a.ah ckb;
    private View mRootView;
    private com.baidu.swan.apps.model.b cjQ = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cjR = new TreeMap();
    private int cjZ = 0;
    public boolean ckc = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ahA();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.ckb = com.baidu.swan.apps.t.a.aqj();
                e.this.ckb.a(e.this.cjs, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void ahA() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cjs = com.baidu.swan.apps.model.c.oV(arguments.getString("ai_apps_param"));
            this.cjQ.mPage = this.cjs != null ? this.cjs.getPage() : "";
            this.cjQ.mParams = this.cjs != null ? this.cjs.getParams() : "";
            this.cjQ.cFG = com.baidu.swan.apps.scheme.actions.k.j.rq(this.cjQ.getPage());
            this.cjY = com.baidu.swan.apps.v.f.asJ().os(this.cjQ.auT());
            if (this.cjY.cTS) {
                this.cjY = com.baidu.swan.apps.v.f.asJ().ot(this.cjQ.getPage());
            }
            this.cjZ = ahp().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cjS = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ak(inflate);
        this.cjU = new com.baidu.swan.apps.tabbar.b.a(this);
        ao(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.auO() && !com.baidu.swan.apps.menu.fontsize.b.auM()) {
            com.baidu.swan.apps.menu.fontsize.a.bO(this.cjT.abD(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.auL()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cjT.abm());
        com.baidu.swan.apps.y.f.avr().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView abt() {
        if (this.cjT != null) {
            return this.cjT.abt();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
        super.ak(view);
        dU(ahk());
        if (ahE()) {
            ahj();
        }
        ahQ();
        this.cju.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String abD = e.this.cjT.abD();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cy(abD, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.asJ().a(abD, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
        this.cjT.abw();
        acc();
        dY(true);
        if (this.cjw != null) {
            this.cjw.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mv(com.baidu.swan.apps.runtime.d.aAn().getAppId()));
        }
        this.cjv.a(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState(), aht(), this.cjw, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ahh() {
        ahv();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e ahX = com.baidu.swan.apps.v.f.asJ().ahX();
        com.baidu.swan.apps.model.c ahw = ahX == null ? null : ahX.ahw();
        if (ahw != null && !TextUtils.isEmpty(ahw.getPage())) {
            fVar.u("page", ahw.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cjY)) {
            super.applyImmersion(i);
            return;
        }
        if (!ahN() && ac.cB(this.mActivity)) {
            z = false;
        }
        w(i, z);
        ahQ();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean he(int i) {
        boolean he = super.he(i);
        ahQ();
        return he;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        ahQ();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dX(false);
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
        if (this.cjv != null && this.cjv.isShowing()) {
            this.cjv.gY(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cjT.abD())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cjT.abD())));
        }
    }

    public static void lB(String str) {
        cjX = str;
    }

    private void ahB() {
        if (!TextUtils.equals(cjW, this.cjT.abD()) || TextUtils.equals(cjX, "switchTab")) {
            int sE = this.cjU.sE(ahK().auT());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.csS = cjW;
            eVar.csT = this.cjT.abD();
            eVar.ckp = cjX;
            eVar.csU = this.cjQ.mPage;
            eVar.csV = String.valueOf(sE);
            cjX = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.csS + " ,toId: " + eVar.csT + " ,RouteType: " + eVar.ckp + " page:" + eVar.csU + ",TabIndex: " + eVar.csV);
            }
            com.baidu.swan.apps.v.f.asJ().b(eVar);
            cjW = this.cjT.abD();
        }
    }

    private void lC(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cjT.abD());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cjT.abD());
        }
        com.baidu.swan.apps.v.f.asJ().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void agO() {
        if (this.cjT == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cjT.abD());
        com.baidu.swan.apps.adaptation.b.f abu = this.cjT.abu();
        if (abu != null) {
            hashMap.put("webViewUrl", abu.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void ao(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String asq = this.cjs.asq();
        String params = this.cjs.getParams();
        String page = this.cjs.getPage();
        String Q = ak.Q(asq, page, params);
        this.cjT = com.baidu.swan.apps.core.slave.b.mj(Q);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Q + " is load: " + (this.cjT != null));
        }
        if (this.cjT == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cjT = p(asq, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c os = com.baidu.swan.apps.v.f.asJ().os(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cjT.b(this.cjS, os);
        this.cjT.a(this.cjS, os);
        lG(page);
        a(this.cjT);
        if (agL()) {
            this.cjR.put(page, this.cjT);
            this.cjU.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView end.");
        ahR();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cjR != null && !this.cjR.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cjR.values()) {
                if (cVar != null) {
                    cVar.abE();
                }
            }
        } else if (this.cjT != null) {
            this.cjT.abE();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.ahV()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ahC();
                }
            });
        } else {
            ahC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        if (this.cjR != null && !this.cjR.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cjR.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cjR.clear();
        } else if (this.cjT != null) {
            b(this.cjT);
            this.cjT.destroy();
        }
        this.cjT = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.ckc) {
            com.baidu.swan.apps.core.slave.b.bT(com.baidu.swan.apps.v.f.asJ().ast());
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
                dX(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cjT == null;
        String abD = z ? "" : this.cjT.abD();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + abD);
        }
        if (!z) {
            dU(ahk());
            this.cjT.onResume();
            ahB();
            lC("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.eI(true);
        if (com.baidu.swan.apps.console.c.aet()) {
            com.baidu.swan.apps.core.c.b.agz();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView abt;
        boolean z = this.cjT == null;
        String abD = z ? "" : this.cjT.abD();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + abD);
        }
        if (!z) {
            this.cjT.onPause();
            lC("onHide");
        }
        if (YB() != null && !YB().aAb()) {
            YB().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.eI(false);
        if (!z && (abt = this.cjT.abt()) != null) {
            abt.fq(false);
        }
    }

    public String lD(String str) {
        if (this.cjR.containsKey(str)) {
            return this.cjR.get(str).abD();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cjU.sE(ahK().auT()) != this.cjU.sE(bVar.auT())) {
            this.cjU.sB(bVar.auT());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cjR.get(bVar.cFG) == null) {
            String Q = ak.Q(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c mj = com.baidu.swan.apps.core.slave.b.mj(Q);
            if (mj != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Q);
                }
                this.cjR.put(bVar.mPage, mj);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                mj = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cjR.put(bVar.mPage, mj);
            }
            lG(bVar.mPage);
            a(mj);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(aVF());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.bT("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", G.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + G);
        }
        com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0390b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0390b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cps = G.coR.aby();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(G, str4);
                }
                String rq = com.baidu.swan.apps.scheme.actions.k.j.rq(str2);
                bVar.appPath = str;
                bVar.cpv = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aAs() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aAs().qG(rq);
                    bVar.cpx = com.baidu.swan.apps.runtime.e.aAs().qI(rq);
                }
                bVar.cpq = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aAr(), bVar.cpv);
                bVar.cpw = com.baidu.swan.apps.v.f.asJ().os(rq).cpw;
                bVar.cpp = String.valueOf(com.baidu.swan.apps.console.a.aeq());
                bVar.cpr = e.DEBUG || com.baidu.swan.apps.v.f.asJ().asn();
                if (com.baidu.swan.apps.ad.a.a.axM()) {
                    bVar.cpt = com.baidu.swan.apps.console.debugger.b.aex();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cpy = str4;
                    com.baidu.swan.apps.performance.i.bT("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aFE();
                G.coR.abB().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                G.coR.jd(bVar.cpv);
                com.baidu.swan.apps.v.f.asJ().a(G.coR.abD(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cl(G.coR.abD(), bVar.cpv);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return G.coR;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.cFG;
        com.baidu.swan.apps.runtime.config.c os = com.baidu.swan.apps.v.f.asJ().os(TextUtils.isEmpty(str3) ? "" : str3);
        this.cjQ.mPage = str2;
        this.cjQ.mParams = bVar != null ? bVar.getParams() : "";
        this.cjQ.cFG = str3;
        this.cjY = os;
        boolean z = false;
        if (lF(str3)) {
            lE(str3);
        } else {
            z = true;
            a(bVar, str);
            lE(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.U(7, str);
            } else {
                com.baidu.swan.apps.performance.j.U(6, str);
            }
            com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.pF(str);
        }
        lA(os.cTI);
        hf(SwanAppConfigData.fq(os.cTJ));
        he(os.cTH);
        ahQ();
        ahT();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + os.cTI + " page:" + str2);
    }

    private void lE(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cjR.get(str);
        if (this.cjT != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c os = com.baidu.swan.apps.v.f.asJ().os(str);
            cVar.b(this.cjS, os);
            if (!cVar.abs()) {
                cVar.a(this.cjS, os);
            }
            cVar.gC(0);
            if (this.cjT != null) {
                this.cjT.gC(8);
            }
            this.cjT = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cjS;
    }

    private boolean lF(String str) {
        return (this.cjR.isEmpty() || this.cjR.get(str) == null) ? false : true;
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
        return ahk() && this.cjT.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        SwanAppConfigData aso;
        com.baidu.swan.apps.v.f asJ = com.baidu.swan.apps.v.f.asJ();
        if (asJ == null || (aso = asJ.aso()) == null || !aso.aBh() || this.cjs == null) {
            return false;
        }
        return aso.qS(this.cjs.getPage());
    }

    public boolean ahD() {
        if (this.cjU == null) {
            return false;
        }
        return this.cjU.ahD();
    }

    protected final boolean ahE() {
        SwanAppConfigData aso;
        f YG = YG();
        if (YG == null) {
            return false;
        }
        if ((this.cjY != null && this.cjY.cTP) || (aso = com.baidu.swan.apps.v.f.asJ().aso()) == null) {
            return false;
        }
        return a(YG, aso) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c hh = fVar.hh(0);
        if (hh == null || !(hh instanceof e)) {
            return false;
        }
        String page = ((e) hh).ahK().getPage();
        return swanAppConfigData.qS(page) || TextUtils.equals(swanAppConfigData.ass(), page);
    }

    private boolean ahF() {
        SwanAppConfigData aso = com.baidu.swan.apps.v.f.asJ().aso();
        return (aso == null || TextUtils.equals(aso.ass(), this.cjQ.getPage())) ? false : true;
    }

    public String ahG() {
        return this.cjT != null ? this.cjT.abD() : "";
    }

    public List<String> ahH() {
        ArrayList arrayList = new ArrayList();
        if (this.cjR != null && !this.cjR.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cjR.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().abD());
                }
            }
        }
        if (this.cjT != null) {
            String abD = this.cjT.abD();
            if (!arrayList.contains(abD)) {
                arrayList.add(abD);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        if ((YB() == null || !YB().aAb()) && !com.baidu.l.a.Uv()) {
            if (this.cjT != null) {
                if (com.baidu.swan.apps.media.b.ow(this.cjT.abD())) {
                    return true;
                }
                return this.cjT.abv();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void acc() {
        FragmentActivity aVF = aVF();
        if (this.cjw == null) {
            this.cjw = new SwanAppMenuHeaderView(getContext());
        }
        if (aVF != null && this.cjv == null) {
            this.cjv = new com.baidu.swan.menu.h(aVF, this.cju, acd(), com.baidu.swan.apps.t.a.apy(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cjv, this, this.cjw).auy();
            if (com.baidu.swan.apps.menu.fontsize.b.auO()) {
                this.cjv.lL(50);
            }
        }
    }

    private int acd() {
        return ahu() ? ahF() ? 18 : 17 : ahF() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> ahI() {
        if (this.cjT == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cjT.abB().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a ahJ() {
        return this.cjU;
    }

    public com.baidu.swan.apps.model.b ahK() {
        return this.cjQ;
    }

    public com.baidu.swan.apps.adaptation.b.c ahL() {
        return this.cjT;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0427a
    public com.baidu.swan.apps.res.widget.floatlayer.a YB() {
        if (this.bTJ == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bTJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), ahp().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bTJ;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c ahl() {
        return this.cjY;
    }

    private boolean ahM() {
        return this.cjY != null && this.cjY.cTM;
    }

    private boolean ahN() {
        if (this.cjY == null) {
            return false;
        }
        return TextUtils.equals(this.cjY.cTO, "custom");
    }

    private void lG(String str) {
        if (!ahN()) {
            com.baidu.swan.apps.v.f asJ = com.baidu.swan.apps.v.f.asJ();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (asJ.os(str).cTM && this.cka == null) {
                this.cka = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.hg(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cka != null) {
                cVar.a(this.cka);
            }
            cVar.a(ahO());
        }
    }

    private com.baidu.swan.apps.core.f.e ahO() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cka);
                    fVar.a(e.this.ahP());
                    com.baidu.swan.apps.y.f.avr().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cka);
                    com.baidu.swan.apps.y.f.avr().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a ahP() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hQ(String str) {
                e.this.lA(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cka != null && cVar != null) {
            cVar.b(this.cka);
            if (cVar.abu() != null) {
                cVar.b(this.cka);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void ahQ() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cju != null) {
            if (ahN()) {
                dV(true);
                i = 0;
                z = true;
            } else if (ahM()) {
                dV(false);
                if (this.cjT != null) {
                    if (this.cjT.abu() != null) {
                        dVar = this.cjT.abu().abB();
                    } else {
                        dVar = this.cjT.abB();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cjY == null && this.cjY.cTN) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cjY == null) {
                }
                z = true;
            } else {
                dV(false);
                i = cjO + this.cjZ;
            }
            TextView centerTitleView = this.cju.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            hg(i);
            dW(z);
        }
    }

    private void dW(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cjA == null || !this.cjA.aGz()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = ahp().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cjS.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cjS.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cjt.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cjt.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(int i) {
        TextView centerTitleView;
        View aGy;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cjO) * 1.0f) / (this.cjZ == 0 ? 1 : this.cjZ);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cjA != null && this.cjA.aGz() && (aGy = this.cjA.aGy()) != null && (background = aGy.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cju.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cjY != null && this.cjY.cTN && (centerTitleView = this.cju.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cjy.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void ahR() {
        this.cjP = com.baidu.swan.apps.statistic.h.rH("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cjP != null) {
            com.baidu.swan.apps.statistic.h.a(this.cjP, gVar);
            this.cjP = null;
        }
    }

    public void ahS() {
        this.cjY.cTO = "default";
        applyImmersion();
        ahQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ahT() {
        if (this.cjs != null) {
            this.cjs.ahT();
        }
    }

    private void dX(boolean z) {
        if (com.baidu.swan.apps.x.a.eQ(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cju, com.baidu.swan.apps.runtime.e.aAs().aAv().arN().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aAs() != null) {
            com.baidu.swan.apps.x.a.a(this.cju, com.baidu.swan.apps.runtime.e.aAs().aAJ().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dY(boolean z) {
        if (com.baidu.swan.apps.x.a.eQ(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cjv, com.baidu.swan.apps.runtime.e.aAs().aAv().arN().paNumber);
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        static int ckf = -1;

        static int ahU() {
            if (ckf < 0) {
                ckf = com.baidu.swan.apps.t.a.apx().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + ckf);
            }
            return ckf;
        }

        static boolean ahV() {
            return ahU() > 0;
        }
    }
}
