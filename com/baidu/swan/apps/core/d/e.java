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
public class e extends c implements a.InterfaceC0444a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cwg = ah.J(149.0f);
    private static String cwn = "-1";
    private static String cwo = cwn;
    private static String cwp;
    private com.baidu.swan.apps.res.widget.floatlayer.a cfX;
    private com.baidu.swan.apps.statistic.a cwh;
    private FrameLayout cwk;
    private com.baidu.swan.apps.adaptation.b.c cwl;
    private com.baidu.swan.apps.tabbar.b.a cwm;
    private com.baidu.swan.apps.runtime.config.c cwq;
    private com.baidu.swan.apps.core.f.c cws;
    private com.baidu.swan.apps.adaptation.a.ah cwt;
    private View mRootView;
    private com.baidu.swan.apps.model.b cwi = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cwj = new TreeMap();
    private int cwr = 0;
    public boolean cwu = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        akl();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cwt = com.baidu.swan.apps.t.a.asV();
                e.this.cwt.a(e.this.cvK, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.E("route", "fragment create.");
    }

    private void akl() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cvK = com.baidu.swan.apps.model.c.pH(arguments.getString("ai_apps_param"));
            this.cwi.mPage = this.cvK != null ? this.cvK.getPage() : "";
            this.cwi.mParams = this.cvK != null ? this.cvK.getParams() : "";
            this.cwi.cRK = com.baidu.swan.apps.scheme.actions.k.j.sc(this.cwi.getPage());
            this.cwq = com.baidu.swan.apps.v.f.avu().pe(this.cwi.axE());
            if (this.cwq.dga) {
                this.cwq = com.baidu.swan.apps.v.f.avu().pf(this.cwi.getPage());
            }
            this.cwr = aka().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cwk = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        al(inflate);
        this.cwm = new com.baidu.swan.apps.tabbar.b.a(this);
        ap(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.axz() && !com.baidu.swan.apps.menu.fontsize.b.axx()) {
            com.baidu.swan.apps.menu.fontsize.a.bT(this.cwl.aep(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.axw()));
        }
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cwl.adY());
        com.baidu.swan.apps.y.f.ayc().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aef() {
        if (this.cwl != null) {
            return this.cwl.aef();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
        super.al(view);
        eq(ajV());
        if (akp()) {
            ajU();
        }
        akB();
        this.cvM.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String aep = e.this.cwl.aep();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cD(aep, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.avu().a(aep, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
        this.cwl.aei();
        aeO();
        eu(true);
        if (this.cvO != null) {
            this.cvO.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nh(com.baidu.swan.apps.runtime.d.aCW().getAppId()));
        }
        this.cvN.a(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState(), ake(), this.cvO, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajS() {
        akg();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e akI = com.baidu.swan.apps.v.f.avu().akI();
        com.baidu.swan.apps.model.c akh = akI == null ? null : akI.akh();
        if (akh != null && !TextUtils.isEmpty(akh.getPage())) {
            fVar.u("page", akh.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cwq)) {
            super.applyImmersion(i);
            return;
        }
        if (!aky() && ac.cH(this.mActivity)) {
            z = false;
        }
        y(i, z);
        akB();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean hB(int i) {
        boolean hB = super.hB(i);
        akB();
        return hB;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        akB();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        et(false);
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
        if (this.cvN != null && this.cvN.isShowing()) {
            this.cvN.hu(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cwl.aep())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cwl.aep())));
        }
    }

    public static void mn(String str) {
        cwp = str;
    }

    private void akm() {
        if (!TextUtils.equals(cwo, this.cwl.aep()) || TextUtils.equals(cwp, "switchTab")) {
            int tq = this.cwm.tq(akv().axE());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cFd = cwo;
            eVar.cFe = this.cwl.aep();
            eVar.cwH = cwp;
            eVar.cFf = this.cwi.mPage;
            eVar.cFg = String.valueOf(tq);
            cwp = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cFd + " ,toId: " + eVar.cFe + " ,RouteType: " + eVar.cwH + " page:" + eVar.cFf + ",TabIndex: " + eVar.cFg);
            }
            com.baidu.swan.apps.v.f.avu().b(eVar);
            cwo = this.cwl.aep();
        }
    }

    private void mo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cwl.aep());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cwl.aep());
        }
        com.baidu.swan.apps.v.f.avu().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ajz() {
        if (this.cwl == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cwl.aep());
        com.baidu.swan.apps.adaptation.b.f aeg = this.cwl.aeg();
        if (aeg != null) {
            hashMap.put("webViewUrl", aeg.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void ap(View view) {
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView start.");
        String avb = this.cvK.avb();
        String params = this.cvK.getParams();
        String page = this.cvK.getPage();
        String R = ak.R(avb, page, params);
        this.cwl = com.baidu.swan.apps.core.slave.b.mV(R);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + R + " is load: " + (this.cwl != null));
        }
        if (this.cwl == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cwl = p(avb, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c pe = com.baidu.swan.apps.v.f.avu().pe(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cwl.b(this.cwk, pe);
        this.cwl.a(this.cwk, pe);
        ms(page);
        a(this.cwl);
        if (ajw()) {
            this.cwj.put(page, this.cwl);
            this.cwm.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.E("route", "createSlaveWebView end.");
        akC();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cwj != null && !this.cwj.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cwj.values()) {
                if (cVar != null) {
                    cVar.aeq();
                }
            }
        } else if (this.cwl != null) {
            this.cwl.aeq();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.akG()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.akn();
                }
            });
        } else {
            akn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akn() {
        if (this.cwj != null && !this.cwj.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cwj.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cwj.clear();
        } else if (this.cwl != null) {
            b(this.cwl);
            this.cwl.destroy();
        }
        this.cwl = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cwu) {
            com.baidu.swan.apps.core.slave.b.bZ(com.baidu.swan.apps.v.f.avu().ave());
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
                et(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cwl == null;
        String aep = z ? "" : this.cwl.aep();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aep);
        }
        if (!z) {
            eq(ajV());
            this.cwl.onResume();
            akm();
            mo("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fe(true);
        if (com.baidu.swan.apps.console.c.ahe()) {
            com.baidu.swan.apps.core.c.b.ajk();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aef;
        boolean z = this.cwl == null;
        String aep = z ? "" : this.cwl.aep();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aep);
        }
        if (!z) {
            this.cwl.onPause();
            mo("onHide");
        }
        if (abn() != null && !abn().aCK()) {
            abn().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fe(false);
        if (!z && (aef = this.cwl.aef()) != null) {
            aef.fM(false);
        }
    }

    public String mp(String str) {
        if (this.cwj.containsKey(str)) {
            return this.cwj.get(str).aep();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cwm.tq(akv().axE()) != this.cwm.tq(bVar.axE())) {
            this.cwm.tn(bVar.axE());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cwj.get(bVar.cRK) == null) {
            String R = ak.R(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c mV = com.baidu.swan.apps.core.slave.b.mV(R);
            if (mV != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + R);
                }
                this.cwj.put(bVar.mPage, mV);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                mV = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cwj.put(bVar.mPage, mV);
            }
            ms(bVar.mPage);
            a(mV);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a H = com.baidu.swan.apps.core.slave.b.H(aYo());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.bY("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).cb("preload", H.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + H);
        }
        com.baidu.swan.apps.core.slave.b.a(H, new b.InterfaceC0407b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0407b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cBH = H.cBg.aek();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(H, str4);
                }
                String sc = com.baidu.swan.apps.scheme.actions.k.j.sc(str2);
                bVar.appPath = str;
                bVar.cBJ = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aDb() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aDb().rs(sc);
                    bVar.cBL = com.baidu.swan.apps.runtime.e.aDb().ru(sc);
                }
                bVar.cBF = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aDa(), bVar.cBJ);
                bVar.cBK = com.baidu.swan.apps.v.f.avu().pe(sc).cBK;
                bVar.cBE = String.valueOf(com.baidu.swan.apps.console.a.ahb());
                bVar.cBG = e.DEBUG || com.baidu.swan.apps.v.f.avu().auY();
                if (com.baidu.swan.apps.ad.a.a.aAx()) {
                    bVar.cBI = com.baidu.swan.apps.console.debugger.b.ahi();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cBM = str4;
                    com.baidu.swan.apps.performance.i.bY("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aIn();
                H.cBg.aen().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                H.cBg.jP(bVar.cBJ);
                com.baidu.swan.apps.v.f.avu().a(H.cBg.aep(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cq(H.cBg.aep(), bVar.cBJ);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return H.cBg;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.cRK;
        com.baidu.swan.apps.runtime.config.c pe = com.baidu.swan.apps.v.f.avu().pe(TextUtils.isEmpty(str3) ? "" : str3);
        this.cwi.mPage = str2;
        this.cwi.mParams = bVar != null ? bVar.getParams() : "";
        this.cwi.cRK = str3;
        this.cwq = pe;
        boolean z = false;
        if (mr(str3)) {
            mq(str3);
        } else {
            z = true;
            a(bVar, str);
            mq(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.af(7, str);
            } else {
                com.baidu.swan.apps.performance.j.af(6, str);
            }
            com.baidu.swan.apps.performance.i.bY("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qr(str);
        }
        mm(pe.dfQ);
        hC(SwanAppConfigData.fv(pe.dfR));
        hB(pe.dfP);
        akB();
        akE();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + pe.dfQ + " page:" + str2);
    }

    private void mq(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cwj.get(str);
        if (this.cwl != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c pe = com.baidu.swan.apps.v.f.avu().pe(str);
            cVar.b(this.cwk, pe);
            if (!cVar.aee()) {
                cVar.a(this.cwk, pe);
            }
            cVar.gZ(0);
            if (this.cwl != null) {
                this.cwl.gZ(8);
            }
            this.cwl = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cwk;
    }

    private boolean mr(String str) {
        return (this.cwj.isEmpty() || this.cwj.get(str) == null) ? false : true;
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
        return ajV() && this.cwl.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        SwanAppConfigData auZ;
        com.baidu.swan.apps.v.f avu = com.baidu.swan.apps.v.f.avu();
        if (avu == null || (auZ = avu.auZ()) == null || !auZ.aDQ() || this.cvK == null) {
            return false;
        }
        return auZ.rE(this.cvK.getPage());
    }

    public boolean ako() {
        if (this.cwm == null) {
            return false;
        }
        return this.cwm.ako();
    }

    protected final boolean akp() {
        SwanAppConfigData auZ;
        f abs = abs();
        if (abs == null) {
            return false;
        }
        if ((this.cwq != null && this.cwq.dfX) || (auZ = com.baidu.swan.apps.v.f.avu().auZ()) == null) {
            return false;
        }
        return a(abs, auZ) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c hE = fVar.hE(0);
        if (hE == null || !(hE instanceof e)) {
            return false;
        }
        String page = ((e) hE).akv().getPage();
        return swanAppConfigData.rE(page) || TextUtils.equals(swanAppConfigData.avd(), page);
    }

    private boolean akq() {
        SwanAppConfigData auZ = com.baidu.swan.apps.v.f.avu().auZ();
        return (auZ == null || TextUtils.equals(auZ.avd(), this.cwi.getPage())) ? false : true;
    }

    public String akr() {
        return this.cwl != null ? this.cwl.aep() : "";
    }

    public List<String> aks() {
        ArrayList arrayList = new ArrayList();
        if (this.cwj != null && !this.cwj.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cwj.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aep());
                }
            }
        }
        if (this.cwl != null) {
            String aep = this.cwl.aep();
            if (!arrayList.contains(aep)) {
                arrayList.add(aep);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        if ((abn() == null || !abn().aCK()) && !com.baidu.l.a.Ws()) {
            if (this.cwl != null) {
                if (com.baidu.swan.apps.media.b.pi(this.cwl.aep())) {
                    return true;
                }
                return this.cwl.aeh();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void aeO() {
        FragmentActivity aYo = aYo();
        if (this.cvO == null) {
            this.cvO = new SwanAppMenuHeaderView(getContext());
        }
        if (aYo != null && this.cvN == null) {
            this.cvN = new com.baidu.swan.menu.h(aYo, this.cvM, aeP(), com.baidu.swan.apps.t.a.asj(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cvN, this, this.cvO).axj();
            if (com.baidu.swan.apps.menu.fontsize.b.axz()) {
                this.cvN.mi(50);
            }
        }
    }

    private int aeP() {
        return akf() ? akq() ? 18 : 17 : akq() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> akt() {
        if (this.cwl == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cwl.aen().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aku() {
        return this.cwm;
    }

    public com.baidu.swan.apps.model.b akv() {
        return this.cwi;
    }

    public com.baidu.swan.apps.adaptation.b.c akw() {
        return this.cwl;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0444a
    public com.baidu.swan.apps.res.widget.floatlayer.a abn() {
        if (this.cfX == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cfX = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aka().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cfX;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c ajW() {
        return this.cwq;
    }

    private boolean akx() {
        return this.cwq != null && this.cwq.dfU;
    }

    private boolean aky() {
        if (this.cwq == null) {
            return false;
        }
        return TextUtils.equals(this.cwq.dfW, "custom");
    }

    private void ms(String str) {
        if (!aky()) {
            com.baidu.swan.apps.v.f avu = com.baidu.swan.apps.v.f.avu();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (avu.pe(str).dfU && this.cws == null) {
                this.cws = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.hD(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cws != null) {
                cVar.a(this.cws);
            }
            cVar.a(akz());
        }
    }

    private com.baidu.swan.apps.core.f.e akz() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cws);
                    fVar.a(e.this.akA());
                    com.baidu.swan.apps.y.f.ayc().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cws);
                    com.baidu.swan.apps.y.f.ayc().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a akA() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ir(String str) {
                e.this.mm(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cws != null && cVar != null) {
            cVar.b(this.cws);
            if (cVar.aeg() != null) {
                cVar.b(this.cws);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void akB() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cvM != null) {
            if (aky()) {
                er(true);
                i = 0;
                z = true;
            } else if (akx()) {
                er(false);
                if (this.cwl != null) {
                    if (this.cwl.aeg() != null) {
                        dVar = this.cwl.aeg().aen();
                    } else {
                        dVar = this.cwl.aen();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cwq == null && this.cwq.dfV) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cwq == null) {
                }
                z = true;
            } else {
                er(false);
                i = cwg + this.cwr;
            }
            TextView centerTitleView = this.cvM.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            hD(i);
            es(z);
        }
    }

    private void es(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cvS == null || !this.cvS.aJi()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ah.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = aka().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cwk.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cwk.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cvL.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cvL.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(int i) {
        TextView centerTitleView;
        View aJh;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cwg) * 1.0f) / (this.cwr == 0 ? 1 : this.cwr);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cvS != null && this.cvS.aJi() && (aJh = this.cvS.aJh()) != null && (background = aJh.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cvM.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cwq != null && this.cwq.dfV && (centerTitleView = this.cvM.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cvQ.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void akC() {
        this.cwh = com.baidu.swan.apps.statistic.h.su("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cwh != null) {
            com.baidu.swan.apps.statistic.h.a(this.cwh, gVar);
            this.cwh = null;
        }
    }

    public void akD() {
        this.cwq.dfW = "default";
        applyImmersion();
        akB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void akE() {
        if (this.cvK != null) {
            this.cvK.akE();
        }
    }

    private void et(boolean z) {
        if (com.baidu.swan.apps.x.a.fm(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cvM, com.baidu.swan.apps.runtime.e.aDb().aDe().auz().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aDb() != null) {
            com.baidu.swan.apps.x.a.a(this.cvM, com.baidu.swan.apps.runtime.e.aDb().aDs().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void eu(boolean z) {
        if (com.baidu.swan.apps.x.a.fm(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cvN, com.baidu.swan.apps.runtime.e.aDb().aDe().auz().paNumber);
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        static int cwx = -1;

        static int akF() {
            if (cwx < 0) {
                cwx = com.baidu.swan.apps.t.a.asi().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cwx);
            }
            return cwx;
        }

        static boolean akG() {
            return akF() > 0;
        }
    }
}
