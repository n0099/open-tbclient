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
/* loaded from: classes10.dex */
public class e extends c implements a.InterfaceC0458a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cEC = ah.L(149.0f);
    private static String cEJ = "-1";
    private static String cEK = cEJ;
    private static String cEL;
    private com.baidu.swan.apps.statistic.a cED;
    private FrameLayout cEG;
    private com.baidu.swan.apps.adaptation.b.c cEH;
    private com.baidu.swan.apps.tabbar.b.a cEI;
    private com.baidu.swan.apps.runtime.config.c cEM;
    private com.baidu.swan.apps.core.f.c cEO;
    private com.baidu.swan.apps.adaptation.a.ah cEP;
    private com.baidu.swan.apps.res.widget.floatlayer.a cox;
    private View mRootView;
    private com.baidu.swan.apps.model.b cEE = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cEF = new TreeMap();
    private int cEN = 0;
    public boolean cEQ = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        amf();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cEP = com.baidu.swan.apps.t.a.auP();
                e.this.cEP.a(e.this.cEg, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void amf() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cEg = com.baidu.swan.apps.model.c.qa(arguments.getString("ai_apps_param"));
            this.cEE.mPage = this.cEg != null ? this.cEg.getPage() : "";
            this.cEE.mParams = this.cEg != null ? this.cEg.getParams() : "";
            this.cEE.dag = com.baidu.swan.apps.scheme.actions.k.j.sw(this.cEE.getPage());
            this.cEM = com.baidu.swan.apps.v.f.axo().px(this.cEE.azy());
            if (this.cEM.doC) {
                this.cEM = com.baidu.swan.apps.v.f.axo().py(this.cEE.getPage());
            }
            this.cEN = alU().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cEG = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        an(inflate);
        this.cEI = new com.baidu.swan.apps.tabbar.b.a(this);
        aq(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.azt() && !com.baidu.swan.apps.menu.fontsize.b.azr()) {
            com.baidu.swan.apps.menu.fontsize.a.ca(this.cEH.agj(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.azq()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cEH.afS());
        com.baidu.swan.apps.y.f.azW().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView afZ() {
        if (this.cEH != null) {
            return this.cEH.afZ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
        super.an(view);
        eD(alP());
        if (amj()) {
            alO();
        }
        amv();
        this.cEi.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String agj = e.this.cEH.agj();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cK(agj, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.axo().a(agj, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
        this.cEH.agc();
        agI();
        eH(true);
        if (this.cEk != null) {
            this.cEk.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nA(com.baidu.swan.apps.runtime.d.aEQ().getAppId()));
        }
        this.cEj.a(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState(), alY(), this.cEk, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alM() {
        ama();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e amC = com.baidu.swan.apps.v.f.axo().amC();
        com.baidu.swan.apps.model.c amb = amC == null ? null : amC.amb();
        if (amb != null && !TextUtils.isEmpty(amb.getPage())) {
            fVar.u("page", amb.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cEM)) {
            super.applyImmersion(i);
            return;
        }
        if (!ams() && ac.cH(this.mActivity)) {
            z = false;
        }
        y(i, z);
        amv();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean hM(int i) {
        boolean hM = super.hM(i);
        amv();
        return hM;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        amv();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        eG(false);
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
        if (this.cEj != null && this.cEj.isShowing()) {
            this.cEj.hH(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cEH.agj())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cEH.agj())));
        }
    }

    public static void mG(String str) {
        cEL = str;
    }

    private void amg() {
        if (!TextUtils.equals(cEK, this.cEH.agj()) || TextUtils.equals(cEL, "switchTab")) {
            int tJ = this.cEI.tJ(amp().azy());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cNz = cEK;
            eVar.cNA = this.cEH.agj();
            eVar.cFd = cEL;
            eVar.cNB = this.cEE.mPage;
            eVar.cNC = String.valueOf(tJ);
            cEL = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cNz + " ,toId: " + eVar.cNA + " ,RouteType: " + eVar.cFd + " page:" + eVar.cNB + ",TabIndex: " + eVar.cNC);
            }
            com.baidu.swan.apps.v.f.axo().b(eVar);
            cEK = this.cEH.agj();
        }
    }

    private void mH(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cEH.agj());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cEH.agj());
        }
        com.baidu.swan.apps.v.f.axo().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void alt() {
        if (this.cEH == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cEH.agj());
        com.baidu.swan.apps.adaptation.b.f aga = this.cEH.aga();
        if (aga != null) {
            hashMap.put("webViewUrl", aga.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aq(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String awV = this.cEg.awV();
        String params = this.cEg.getParams();
        String page = this.cEg.getPage();
        String Y = ak.Y(awV, page, params);
        this.cEH = com.baidu.swan.apps.core.slave.b.no(Y);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + Y + " is load: " + (this.cEH != null));
        }
        if (this.cEH == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cEH = q(awV, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c px = com.baidu.swan.apps.v.f.axo().px(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cEH.b(this.cEG, px);
        this.cEH.a(this.cEG, px);
        mL(page);
        a(this.cEH);
        if (alq()) {
            this.cEF.put(page, this.cEH);
            this.cEI.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView end.");
        amw();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cEF != null && !this.cEF.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cEF.values()) {
                if (cVar != null) {
                    cVar.agk();
                }
            }
        } else if (this.cEH != null) {
            this.cEH.agk();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.amA()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.amh();
                }
            });
        } else {
            amh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amh() {
        if (this.cEF != null && !this.cEF.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cEF.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cEF.clear();
        } else if (this.cEH != null) {
            b(this.cEH);
            this.cEH.destroy();
        }
        this.cEH = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cEQ) {
            com.baidu.swan.apps.core.slave.b.bZ(com.baidu.swan.apps.v.f.axo().awY());
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
                eG(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cEH == null;
        String agj = z ? "" : this.cEH.agj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + agj);
        }
        if (!z) {
            eD(alP());
            this.cEH.onResume();
            amg();
            mH("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fr(true);
        if (com.baidu.swan.apps.console.c.aiY()) {
            com.baidu.swan.apps.core.c.b.ale();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView afZ;
        boolean z = this.cEH == null;
        String agj = z ? "" : this.cEH.agj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + agj);
        }
        if (!z) {
            this.cEH.onPause();
            mH("onHide");
        }
        if (adh() != null && !adh().aEE()) {
            adh().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fr(false);
        if (!z && (afZ = this.cEH.afZ()) != null) {
            afZ.fZ(false);
        }
    }

    public String mI(String str) {
        if (this.cEF.containsKey(str)) {
            return this.cEF.get(str).agj();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cEI.tJ(amp().azy()) != this.cEI.tJ(bVar.azy())) {
            this.cEI.tG(bVar.azy());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cEF.get(bVar.dag) == null) {
            String Y = ak.Y(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c no = com.baidu.swan.apps.core.slave.b.no(Y);
            if (no != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + Y);
                }
                this.cEF.put(bVar.mPage, no);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                no = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cEF.put(bVar.mPage, no);
            }
            mL(bVar.mPage);
            a(no);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a H = com.baidu.swan.apps.core.slave.b.H(bah());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cf("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).ci("preload", H.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + H);
        }
        com.baidu.swan.apps.core.slave.b.a(H, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cKd = H.cJC.age();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(H, str4);
                }
                String sw = com.baidu.swan.apps.scheme.actions.k.j.sw(str2);
                bVar.appPath = str;
                bVar.cKf = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aEV() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aEV().rL(sw);
                    bVar.cKh = com.baidu.swan.apps.runtime.e.aEV().rN(sw);
                }
                bVar.cKb = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aEU(), bVar.cKf);
                bVar.cKg = com.baidu.swan.apps.v.f.axo().px(sw).cKg;
                bVar.cKa = String.valueOf(com.baidu.swan.apps.console.a.aiV());
                bVar.cKc = e.DEBUG || com.baidu.swan.apps.v.f.axo().awS();
                if (com.baidu.swan.apps.ad.a.a.aCr()) {
                    bVar.cKe = com.baidu.swan.apps.console.debugger.b.ajc();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cKi = str4;
                    com.baidu.swan.apps.performance.i.cf("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aKh();
                H.cJC.agh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                H.cJC.ki(bVar.cKf);
                com.baidu.swan.apps.v.f.axo().a(H.cJC.agj(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cx(H.cJC.agj(), bVar.cKf);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return H.cJC;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dag;
        com.baidu.swan.apps.runtime.config.c px = com.baidu.swan.apps.v.f.axo().px(TextUtils.isEmpty(str3) ? "" : str3);
        this.cEE.mPage = str2;
        this.cEE.mParams = bVar != null ? bVar.getParams() : "";
        this.cEE.dag = str3;
        this.cEM = px;
        boolean z = false;
        if (mK(str3)) {
            mJ(str3);
        } else {
            z = true;
            a(bVar, str);
            mJ(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.ah(7, str);
            } else {
                com.baidu.swan.apps.performance.j.ah(6, str);
            }
            com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qK(str);
        }
        mF(px.dor);
        hN(SwanAppConfigData.fv(px.dos));
        hM(px.doq);
        amv();
        amy();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + px.dor + " page:" + str2);
    }

    private void mJ(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cEF.get(str);
        if (this.cEH != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c px = com.baidu.swan.apps.v.f.axo().px(str);
            cVar.b(this.cEG, px);
            if (!cVar.afY()) {
                cVar.a(this.cEG, px);
            }
            cVar.hk(0);
            if (this.cEH != null) {
                this.cEH.hk(8);
            }
            this.cEH = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cEG;
    }

    private boolean mK(String str) {
        return (this.cEF.isEmpty() || this.cEF.get(str) == null) ? false : true;
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
        return alP() && this.cEH.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        SwanAppConfigData awT;
        com.baidu.swan.apps.v.f axo = com.baidu.swan.apps.v.f.axo();
        if (axo == null || (awT = axo.awT()) == null || !awT.aFK() || this.cEg == null) {
            return false;
        }
        return awT.rX(this.cEg.getPage());
    }

    public boolean ami() {
        if (this.cEI == null) {
            return false;
        }
        return this.cEI.ami();
    }

    protected final boolean amj() {
        SwanAppConfigData awT;
        f adm = adm();
        if (adm == null) {
            return false;
        }
        if ((this.cEM != null && this.cEM.doz) || (awT = com.baidu.swan.apps.v.f.axo().awT()) == null) {
            return false;
        }
        return a(adm, awT) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c hP = fVar.hP(0);
        if (hP == null || !(hP instanceof e)) {
            return false;
        }
        String page = ((e) hP).amp().getPage();
        return swanAppConfigData.rX(page) || TextUtils.equals(swanAppConfigData.awX(), page);
    }

    private boolean amk() {
        SwanAppConfigData awT = com.baidu.swan.apps.v.f.axo().awT();
        return (awT == null || TextUtils.equals(awT.awX(), this.cEE.getPage())) ? false : true;
    }

    public String aml() {
        return this.cEH != null ? this.cEH.agj() : "";
    }

    public List<String> amm() {
        ArrayList arrayList = new ArrayList();
        if (this.cEF != null && !this.cEF.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cEF.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().agj());
                }
            }
        }
        if (this.cEH != null) {
            String agj = this.cEH.agj();
            if (!arrayList.contains(agj)) {
                arrayList.add(agj);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        if ((adh() == null || !adh().aEE()) && !com.baidu.l.a.Ym()) {
            if (this.cEH != null) {
                if (com.baidu.swan.apps.media.b.pB(this.cEH.agj())) {
                    return true;
                }
                return this.cEH.agb();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void agI() {
        FragmentActivity bah = bah();
        if (this.cEk == null) {
            this.cEk = new SwanAppMenuHeaderView(getContext());
        }
        if (bah != null && this.cEj == null) {
            this.cEj = new com.baidu.swan.menu.h(bah, this.cEi, agJ(), com.baidu.swan.apps.t.a.aue(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cEj, this, this.cEk).azd();
            if (com.baidu.swan.apps.menu.fontsize.b.azt()) {
                this.cEj.mt(50);
            }
        }
    }

    private int agJ() {
        return alZ() ? amk() ? 18 : 17 : amk() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> amn() {
        if (this.cEH == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cEH.agh().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a amo() {
        return this.cEI;
    }

    public com.baidu.swan.apps.model.b amp() {
        return this.cEE;
    }

    public com.baidu.swan.apps.adaptation.b.c amq() {
        return this.cEH;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0458a
    public com.baidu.swan.apps.res.widget.floatlayer.a adh() {
        if (this.cox == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cox = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), alU().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cox;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c alQ() {
        return this.cEM;
    }

    private boolean amr() {
        return this.cEM != null && this.cEM.dow;
    }

    private boolean ams() {
        if (this.cEM == null) {
            return false;
        }
        return TextUtils.equals(this.cEM.doy, "custom");
    }

    private void mL(String str) {
        if (!ams()) {
            com.baidu.swan.apps.v.f axo = com.baidu.swan.apps.v.f.axo();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (axo.px(str).dow && this.cEO == null) {
                this.cEO = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.hO(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cEO != null) {
                cVar.a(this.cEO);
            }
            cVar.a(amt());
        }
    }

    private com.baidu.swan.apps.core.f.e amt() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cEO);
                    fVar.a(e.this.amu());
                    com.baidu.swan.apps.y.f.azW().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cEO);
                    com.baidu.swan.apps.y.f.azW().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a amu() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iC(String str) {
                e.this.mF(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cEO != null && cVar != null) {
            cVar.b(this.cEO);
            if (cVar.aga() != null) {
                cVar.b(this.cEO);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void amv() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cEi != null) {
            if (ams()) {
                eE(true);
                i = 0;
                z = true;
            } else if (amr()) {
                eE(false);
                if (this.cEH != null) {
                    if (this.cEH.aga() != null) {
                        dVar = this.cEH.aga().agh();
                    } else {
                        dVar = this.cEH.agh();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cEM == null && this.cEM.dox) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cEM == null) {
                }
                z = true;
            } else {
                eE(false);
                i = cEC + this.cEN;
            }
            TextView centerTitleView = this.cEi.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            hO(i);
            eF(z);
        }
    }

    private void eF(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cEo == null || !this.cEo.aLc()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = alU().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cEG.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cEG.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cEh.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cEh.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        TextView centerTitleView;
        View aLb;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cEC) * 1.0f) / (this.cEN == 0 ? 1 : this.cEN);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cEo != null && this.cEo.aLc() && (aLb = this.cEo.aLb()) != null && (background = aLb.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cEi.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cEM != null && this.cEM.dox && (centerTitleView = this.cEi.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cEm.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void amw() {
        this.cED = com.baidu.swan.apps.statistic.h.sN("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cED != null) {
            com.baidu.swan.apps.statistic.h.a(this.cED, gVar);
            this.cED = null;
        }
    }

    public void amx() {
        this.cEM.doy = "default";
        applyImmersion();
        amv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void amy() {
        if (this.cEg != null) {
            this.cEg.amy();
        }
    }

    private void eG(boolean z) {
        if (com.baidu.swan.apps.x.a.fz(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cEi, com.baidu.swan.apps.runtime.e.aEV().aEY().awt().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aEV() != null) {
            com.baidu.swan.apps.x.a.a(this.cEi, com.baidu.swan.apps.runtime.e.aEV().aFm().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void eH(boolean z) {
        if (com.baidu.swan.apps.x.a.fz(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cEj, com.baidu.swan.apps.runtime.e.aEV().aEY().awt().paNumber);
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        static int cET = -1;

        static int amz() {
            if (cET < 0) {
                cET = com.baidu.swan.apps.t.a.aud().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cET);
            }
            return cET;
        }

        static boolean amA() {
            return amz() > 0;
        }
    }
}
