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
import com.baidu.swan.apps.adaptation.a.ah;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ac;
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
/* loaded from: classes10.dex */
public class e extends c implements a.InterfaceC0470a {
    private static String cKE;
    private com.baidu.swan.apps.adaptation.b.c cKA;
    private com.baidu.swan.apps.tabbar.b.a cKB;
    private com.baidu.swan.apps.runtime.config.c cKF;
    private com.baidu.swan.apps.core.f.c cKH;
    private ah cKI;
    private com.baidu.swan.apps.statistic.a cKw;
    private FrameLayout cKz;
    private com.baidu.swan.apps.res.widget.floatlayer.a cuw;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cKv = com.baidu.swan.apps.ap.ah.N(149.0f);
    private static String cKC = "-1";
    private static String cKD = cKC;
    private com.baidu.swan.apps.model.b cKx = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cKy = new TreeMap();
    private int cKG = 0;
    public boolean cKJ = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoF();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cKI = com.baidu.swan.apps.t.a.axp();
                e.this.cKI.a(e.this.cJZ, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void aoF() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cJZ = com.baidu.swan.apps.model.c.qo(arguments.getString("ai_apps_param"));
            this.cKx.mPage = this.cJZ != null ? this.cJZ.getPage() : "";
            this.cKx.mParams = this.cJZ != null ? this.cJZ.getParams() : "";
            this.cKx.dgd = com.baidu.swan.apps.scheme.actions.k.j.sK(this.cKx.getPage());
            this.cKF = com.baidu.swan.apps.v.f.azO().pL(this.cKx.aBY());
            if (this.cKF.dux) {
                this.cKF = com.baidu.swan.apps.v.f.azO().pM(this.cKx.getPage());
            }
            this.cKG = aou().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cKz = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ar(inflate);
        this.cKB = new com.baidu.swan.apps.tabbar.b.a(this);
        au(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aBT() && !com.baidu.swan.apps.menu.fontsize.b.aBR()) {
            com.baidu.swan.apps.menu.fontsize.a.ca(this.cKA.aiJ(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBQ()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cKA.ais());
        com.baidu.swan.apps.y.f.aCw().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aiz() {
        if (this.cKA != null) {
            return this.cKA.aiz();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        super.ar(view);
        eM(aop());
        if (aoJ()) {
            aoo();
        }
        aoV();
        this.cKb.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String aiJ = e.this.cKA.aiJ();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cK(aiJ, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.azO().a(aiJ, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
        this.cKA.aiC();
        aji();
        eQ(true);
        if (this.cKd != null) {
            this.cKd.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nO(com.baidu.swan.apps.runtime.d.aHq().getAppId()));
        }
        this.cKc.a(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState(), aoy(), this.cKd, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aom() {
        aoA();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e apc = com.baidu.swan.apps.v.f.azO().apc();
        com.baidu.swan.apps.model.c aoB = apc == null ? null : apc.aoB();
        if (aoB != null && !TextUtils.isEmpty(aoB.getPage())) {
            fVar.u("page", aoB.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cKF)) {
            super.applyImmersion(i);
            return;
        }
        if (!aoS() && ac.cH(this.mActivity)) {
            z = false;
        }
        y(i, z);
        aoV();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean hW(int i) {
        boolean hW = super.hW(i);
        aoV();
        return hW;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        aoV();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        eP(false);
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
        if (this.cKc != null && this.cKc.isShowing()) {
            this.cKc.hQ(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cKA.aiJ())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cKA.aiJ())));
        }
    }

    public static void mV(String str) {
        cKE = str;
    }

    private void aoG() {
        if (!TextUtils.equals(cKD, this.cKA.aiJ()) || TextUtils.equals(cKE, "switchTab")) {
            int tX = this.cKB.tX(aoP().aBY());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cTs = cKD;
            eVar.cTt = this.cKA.aiJ();
            eVar.cKW = cKE;
            eVar.cTu = this.cKx.mPage;
            eVar.cTv = String.valueOf(tX);
            cKE = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cTs + " ,toId: " + eVar.cTt + " ,RouteType: " + eVar.cKW + " page:" + eVar.cTu + ",TabIndex: " + eVar.cTv);
            }
            com.baidu.swan.apps.v.f.azO().b(eVar);
            cKD = this.cKA.aiJ();
        }
    }

    private void mW(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cKA.aiJ());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cKA.aiJ());
        }
        com.baidu.swan.apps.v.f.azO().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anT() {
        if (this.cKA == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cKA.aiJ());
        com.baidu.swan.apps.adaptation.b.f aiA = this.cKA.aiA();
        if (aiA != null) {
            hashMap.put("webViewUrl", aiA.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void au(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String azv = this.cJZ.azv();
        String params = this.cJZ.getParams();
        String page = this.cJZ.getPage();
        String Y = ak.Y(azv, page, params);
        this.cKA = com.baidu.swan.apps.core.slave.b.nD(Y);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Y + " is load: " + (this.cKA != null));
        }
        if (this.cKA == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cKA = q(azv, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c pL = com.baidu.swan.apps.v.f.azO().pL(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cKA.b(this.cKz, pL);
        this.cKA.a(this.cKz, pL);
        na(page);
        a(this.cKA);
        if (anQ()) {
            this.cKy.put(page, this.cKA);
            this.cKB.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView end.");
        aoW();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cKy != null && !this.cKy.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cKy.values()) {
                if (cVar != null) {
                    cVar.aiK();
                }
            }
        } else if (this.cKA != null) {
            this.cKA.aiK();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.apa()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.aoH();
                }
            });
        } else {
            aoH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoH() {
        if (this.cKy != null && !this.cKy.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cKy.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cKy.clear();
        } else if (this.cKA != null) {
            b(this.cKA);
            this.cKA.destroy();
        }
        this.cKA = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cKJ) {
            com.baidu.swan.apps.core.slave.b.bZ(com.baidu.swan.apps.v.f.azO().azy());
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
                eP(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cKA == null;
        String aiJ = z ? "" : this.cKA.aiJ();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aiJ);
        }
        if (!z) {
            eM(aop());
            this.cKA.onResume();
            aoG();
            mW("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fA(true);
        if (com.baidu.swan.apps.console.c.aly()) {
            com.baidu.swan.apps.core.c.b.anE();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aiz;
        boolean z = this.cKA == null;
        String aiJ = z ? "" : this.cKA.aiJ();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aiJ);
        }
        if (!z) {
            this.cKA.onPause();
            mW("onHide");
        }
        if (afH() != null && !afH().aHe()) {
            afH().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fA(false);
        if (!z && (aiz = this.cKA.aiz()) != null) {
            aiz.gi(false);
        }
    }

    public String mX(String str) {
        if (this.cKy.containsKey(str)) {
            return this.cKy.get(str).aiJ();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cKB.tX(aoP().aBY()) != this.cKB.tX(bVar.aBY())) {
            this.cKB.tU(bVar.aBY());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cKy.get(bVar.dgd) == null) {
            String Y = ak.Y(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c nD = com.baidu.swan.apps.core.slave.b.nD(Y);
            if (nD != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Y);
                }
                this.cKy.put(bVar.mPage, nD);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                nD = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cKy.put(bVar.mPage, nD);
            }
            na(bVar.mPage);
            a(nD);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a H = com.baidu.swan.apps.core.slave.b.H(bcH());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cf("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).ci("preload", H.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + H);
        }
        com.baidu.swan.apps.core.slave.b.a(H, new b.InterfaceC0433b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0433b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cPW = H.cPv.aiE();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(H, str4);
                }
                String sK = com.baidu.swan.apps.scheme.actions.k.j.sK(str2);
                bVar.appPath = str;
                bVar.cPY = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aHv() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aHv().rZ(sK);
                    bVar.cQa = com.baidu.swan.apps.runtime.e.aHv().sb(sK);
                }
                bVar.cPU = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aHu(), bVar.cPY);
                bVar.cPZ = com.baidu.swan.apps.v.f.azO().pL(sK).cPZ;
                bVar.cPT = String.valueOf(com.baidu.swan.apps.console.a.alv());
                bVar.cPV = e.DEBUG || com.baidu.swan.apps.v.f.azO().azs();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    bVar.cPX = com.baidu.swan.apps.console.debugger.b.alC();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cQb = str4;
                    com.baidu.swan.apps.performance.i.cf("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aMH();
                H.cPv.aiH().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                H.cPv.kx(bVar.cPY);
                com.baidu.swan.apps.v.f.azO().a(H.cPv.aiJ(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cx(H.cPv.aiJ(), bVar.cPY);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return H.cPv;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dgd;
        com.baidu.swan.apps.runtime.config.c pL = com.baidu.swan.apps.v.f.azO().pL(TextUtils.isEmpty(str3) ? "" : str3);
        this.cKx.mPage = str2;
        this.cKx.mParams = bVar != null ? bVar.getParams() : "";
        this.cKx.dgd = str3;
        this.cKF = pL;
        boolean z = false;
        if (mZ(str3)) {
            mY(str3);
        } else {
            z = true;
            a(bVar, str);
            mY(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.al(7, str);
            } else {
                com.baidu.swan.apps.performance.j.al(6, str);
            }
            com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qY(str);
        }
        mU(pL.dun);
        hX(SwanAppConfigData.fv(pL.duo));
        hW(pL.dum);
        aoV();
        aoY();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + pL.dun + " page:" + str2);
    }

    private void mY(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cKy.get(str);
        if (this.cKA != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c pL = com.baidu.swan.apps.v.f.azO().pL(str);
            cVar.b(this.cKz, pL);
            if (!cVar.aiy()) {
                cVar.a(this.cKz, pL);
            }
            cVar.hu(0);
            if (this.cKA != null) {
                this.cKA.hu(8);
            }
            this.cKA = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cKz;
    }

    private boolean mZ(String str) {
        return (this.cKy.isEmpty() || this.cKy.get(str) == null) ? false : true;
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
        return aop() && this.cKA.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        SwanAppConfigData azt;
        com.baidu.swan.apps.v.f azO = com.baidu.swan.apps.v.f.azO();
        if (azO == null || (azt = azO.azt()) == null || !azt.aIk() || this.cJZ == null) {
            return false;
        }
        return azt.sl(this.cJZ.getPage());
    }

    public boolean aoI() {
        if (this.cKB == null) {
            return false;
        }
        return this.cKB.aoI();
    }

    protected final boolean aoJ() {
        SwanAppConfigData azt;
        f afM = afM();
        if (afM == null) {
            return false;
        }
        if ((this.cKF != null && this.cKF.duu) || (azt = com.baidu.swan.apps.v.f.azO().azt()) == null) {
            return false;
        }
        return a(afM, azt) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c hZ = fVar.hZ(0);
        if (hZ == null || !(hZ instanceof e)) {
            return false;
        }
        String page = ((e) hZ).aoP().getPage();
        return swanAppConfigData.sl(page) || TextUtils.equals(swanAppConfigData.azx(), page);
    }

    private boolean aoK() {
        SwanAppConfigData azt = com.baidu.swan.apps.v.f.azO().azt();
        return (azt == null || TextUtils.equals(azt.azx(), this.cKx.getPage())) ? false : true;
    }

    public String aoL() {
        return this.cKA != null ? this.cKA.aiJ() : "";
    }

    public List<String> aoM() {
        ArrayList arrayList = new ArrayList();
        if (this.cKy != null && !this.cKy.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cKy.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aiJ());
                }
            }
        }
        if (this.cKA != null) {
            String aiJ = this.cKA.aiJ();
            if (!arrayList.contains(aiJ)) {
                arrayList.add(aiJ);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        if ((afH() == null || !afH().aHe()) && !com.baidu.l.a.aaL()) {
            if (this.cKA != null) {
                if (com.baidu.swan.apps.media.b.pP(this.cKA.aiJ())) {
                    return true;
                }
                return this.cKA.aiB();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void aji() {
        FragmentActivity bcH = bcH();
        if (this.cKd == null) {
            this.cKd = new SwanAppMenuHeaderView(getContext());
        }
        if (bcH != null && this.cKc == null) {
            this.cKc = new com.baidu.swan.menu.h(bcH, this.cKb, ajj(), com.baidu.swan.apps.t.a.awE(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cKc, this, this.cKd).aBD();
            if (com.baidu.swan.apps.menu.fontsize.b.aBT()) {
                this.cKc.mD(50);
            }
        }
    }

    private int ajj() {
        return aoz() ? aoK() ? 18 : 17 : aoK() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> aoN() {
        if (this.cKA == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cKA.aiH().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aoO() {
        return this.cKB;
    }

    public com.baidu.swan.apps.model.b aoP() {
        return this.cKx;
    }

    public com.baidu.swan.apps.adaptation.b.c aoQ() {
        return this.cKA;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0470a
    public com.baidu.swan.apps.res.widget.floatlayer.a afH() {
        if (this.cuw == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cuw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aou().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cuw;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aoq() {
        return this.cKF;
    }

    private boolean aoR() {
        return this.cKF != null && this.cKF.dur;
    }

    private boolean aoS() {
        if (this.cKF == null) {
            return false;
        }
        return TextUtils.equals(this.cKF.dut, "custom");
    }

    private void na(String str) {
        if (!aoS()) {
            com.baidu.swan.apps.v.f azO = com.baidu.swan.apps.v.f.azO();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (azO.pL(str).dur && this.cKH == null) {
                this.cKH = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.hY(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cKH != null) {
                cVar.a(this.cKH);
            }
            cVar.a(aoT());
        }
    }

    private com.baidu.swan.apps.core.f.e aoT() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cKH);
                    fVar.a(e.this.aoU());
                    com.baidu.swan.apps.y.f.aCw().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cKH);
                    com.baidu.swan.apps.y.f.aCw().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a aoU() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iP(String str) {
                e.this.mU(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cKH != null && cVar != null) {
            cVar.b(this.cKH);
            if (cVar.aiA() != null) {
                cVar.b(this.cKH);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void aoV() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cKb != null) {
            if (aoS()) {
                eN(true);
                i = 0;
                z = true;
            } else if (aoR()) {
                eN(false);
                if (this.cKA != null) {
                    if (this.cKA.aiA() != null) {
                        dVar = this.cKA.aiA().aiH();
                    } else {
                        dVar = this.cKA.aiH();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cKF == null && this.cKF.dus) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cKF == null) {
                }
                z = true;
            } else {
                eN(false);
                i = cKv + this.cKG;
            }
            TextView centerTitleView = this.cKb.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            hY(i);
            eO(z);
        }
    }

    private void eO(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cKh == null || !this.cKh.aNC()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = com.baidu.swan.apps.ap.ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = aou().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cKz.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cKz.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cKa.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cKa.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(int i) {
        TextView centerTitleView;
        View aNB;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cKv) * 1.0f) / (this.cKG == 0 ? 1 : this.cKG);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cKh != null && this.cKh.aNC() && (aNB = this.cKh.aNB()) != null && (background = aNB.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cKb.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cKF != null && this.cKF.dus && (centerTitleView = this.cKb.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cKf.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void aoW() {
        this.cKw = com.baidu.swan.apps.statistic.h.tb("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cKw != null) {
            com.baidu.swan.apps.statistic.h.a(this.cKw, gVar);
            this.cKw = null;
        }
    }

    public void aoX() {
        this.cKF.dut = "default";
        applyImmersion();
        aoV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoY() {
        if (this.cJZ != null) {
            this.cJZ.aoY();
        }
    }

    private void eP(boolean z) {
        if (com.baidu.swan.apps.x.a.fI(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cKb, com.baidu.swan.apps.runtime.e.aHv().aHy().ayT().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aHv() != null) {
            com.baidu.swan.apps.x.a.a(this.cKb, com.baidu.swan.apps.runtime.e.aHv().aHM().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void eQ(boolean z) {
        if (com.baidu.swan.apps.x.a.fI(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cKc, com.baidu.swan.apps.runtime.e.aHv().aHy().ayT().paNumber);
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        static int cKM = -1;

        static int aoZ() {
            if (cKM < 0) {
                cKM = com.baidu.swan.apps.t.a.awD().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cKM);
            }
            return cKM;
        }

        static boolean apa() {
            return aoZ() > 0;
        }
    }
}
