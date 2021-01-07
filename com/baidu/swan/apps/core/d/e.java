package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.ao.ac;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes9.dex */
public class e extends c implements a.InterfaceC0473a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cUB = ah.O(149.0f);
    private static String cUI = "-1";
    private static String cUJ = cUI;
    private static String cUK;
    private com.baidu.swan.apps.res.widget.floatlayer.a cEs;
    private com.baidu.swan.apps.statistic.a cUC;
    private FrameLayout cUF;
    private com.baidu.swan.apps.adaptation.b.c cUG;
    private com.baidu.swan.apps.tabbar.b.a cUH;
    private com.baidu.swan.apps.runtime.config.c cUL;
    private com.baidu.swan.apps.core.f.c cUN;
    private com.baidu.swan.apps.adaptation.a.ah cUO;
    private View mRootView;
    private com.baidu.swan.apps.model.b cUD = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cUE = new TreeMap();
    private int cUM = 0;
    public boolean cUP = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        asy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cUO = com.baidu.swan.apps.t.a.aBh();
                e.this.cUO.a(e.this.cUd, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.D("route", "fragment create.");
    }

    private void asy() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cUd = com.baidu.swan.apps.model.c.qJ(arguments.getString("ai_apps_param"));
            this.cUD.mPage = this.cUd != null ? this.cUd.getPage() : "";
            this.cUD.mParams = this.cUd != null ? this.cUd.getParams() : "";
            this.cUD.dqt = com.baidu.swan.apps.scheme.actions.k.j.tj(this.cUD.getPage());
            this.cUL = com.baidu.swan.apps.v.f.aDH().qf(this.cUD.aFT());
            if (this.cUL.dIu) {
                this.cUL = com.baidu.swan.apps.v.f.aDH().qg(this.cUD.getPage());
            }
            this.cUM = asn().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cUF = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        av(inflate);
        this.cUH = new com.baidu.swan.apps.tabbar.b.a(this);
        aA(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aFO() && !com.baidu.swan.apps.menu.fontsize.b.aFM()) {
            com.baidu.swan.apps.menu.fontsize.a.cf(this.cUG.amu(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aFL()));
        }
        this.mRootView = a(asf() ? az(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cUG.amd());
        com.baidu.swan.apps.y.f.aGs().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView amk() {
        if (this.cUG != null) {
            return this.cUG.amk();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        super.av(view);
        fn(asc());
        if (asC()) {
            asb();
        }
        asO();
        this.cUf.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void aB(View view2) {
                String amu = e.this.cUG.amu();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cP(amu, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.aDH().a(amu, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arC() {
        this.cUG.amn();
        amT();
        fr(true);
        if (this.cUh != null) {
            this.cUh.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.oj(com.baidu.swan.apps.runtime.d.aMh().getAppId()));
        }
        this.cUg.a(com.baidu.swan.apps.t.a.aAO().alE(), asr(), this.cUh, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amN() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arZ() {
        ast();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e asV = com.baidu.swan.apps.v.f.aDH().asV();
        com.baidu.swan.apps.model.c asu = asV == null ? null : asV.asu();
        if (asu != null && !TextUtils.isEmpty(asu.getPage())) {
            fVar.t("page", asu.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void im(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cUL)) {
            super.im(i);
            return;
        }
        if (!asL() && ac.dD(this.mActivity)) {
            z = false;
        }
        y(i, z);
        asO();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ik(int i) {
        boolean ik = super.ik(i);
        asO();
        return ik;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void asi() {
        super.asi();
        asO();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        fq(false);
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
        if (this.cUg != null && this.cUg.isShowing()) {
            this.cUg.iC(com.baidu.swan.apps.t.a.aAO().alE());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cUG.amu())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cUG.amu())));
        }
    }

    public static void np(String str) {
        cUK = str;
    }

    private void asz() {
        if (!TextUtils.equals(cUJ, this.cUG.amu()) || TextUtils.equals(cUK, "switchTab")) {
            int uw = this.cUH.uw(asI().aFT());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.ddx = cUJ;
            eVar.ddy = this.cUG.amu();
            eVar.cVc = cUK;
            eVar.ddz = this.cUD.mPage;
            eVar.ddA = String.valueOf(uw);
            cUK = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.ddx + " ,toId: " + eVar.ddy + " ,RouteType: " + eVar.cVc + " page:" + eVar.ddz + ",TabIndex: " + eVar.ddA);
            }
            com.baidu.swan.apps.v.f.aDH().b(eVar);
            cUJ = this.cUG.amu();
        }
    }

    private void nq(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cUG.amu());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cUG.amu());
        }
        com.baidu.swan.apps.v.f.aDH().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void arG() {
        if (this.cUG == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cUG.amu());
        com.baidu.swan.apps.adaptation.b.f aml = this.cUG.aml();
        if (aml != null) {
            hashMap.put("webViewUrl", aml.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aA(View view) {
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView start.");
        String aDo = this.cUd.aDo();
        String params = this.cUd.getParams();
        String page = this.cUd.getPage();
        String ae = ak.ae(aDo, page, params);
        this.cUG = com.baidu.swan.apps.core.slave.b.nX(ae);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + ae + " is load: " + (this.cUG != null));
        }
        if (this.cUG == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cUG = q(aDo, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c qf = com.baidu.swan.apps.v.f.aDH().qf(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cUG.b(this.cUF, qf);
        this.cUG.a(this.cUF, qf);
        nu(page);
        a(this.cUG);
        if (arD()) {
            this.cUE.put(page, this.cUG);
            this.cUH.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView end.");
        asP();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cUE != null && !this.cUE.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cUE.values()) {
                if (cVar != null) {
                    cVar.amv();
                }
            }
        } else if (this.cUG != null) {
            this.cUG.amv();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.asT()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.asA();
                }
            });
        } else {
            asA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asA() {
        if (this.cUE != null && !this.cUE.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cUE.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cUE.clear();
        } else if (this.cUG != null) {
            b(this.cUG);
            this.cUG.destroy();
        }
        this.cUG = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cUP) {
            com.baidu.swan.apps.core.slave.b.cN(com.baidu.swan.apps.v.f.aDH().aDr());
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
                fq(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cUG == null;
        String amu = z ? "" : this.cUG.amu();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + amu);
        }
        if (!z) {
            fn(asc());
            this.cUG.onResume();
            asz();
            nq("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.gb(true);
        if (com.baidu.swan.apps.console.c.apl()) {
            com.baidu.swan.apps.core.c.b.arr();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView amk;
        boolean z = this.cUG == null;
        String amu = z ? "" : this.cUG.amu();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + amu);
        }
        if (!z) {
            this.cUG.onPause();
            nq("onHide");
        }
        if (ajo() != null && !ajo().aLE()) {
            ajo().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.gb(false);
        if (!z && (amk = this.cUG.amk()) != null) {
            amk.gJ(false);
        }
    }

    public String nr(String str) {
        if (this.cUE.containsKey(str)) {
            return this.cUE.get(str).amu();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cUH.uw(asI().aFT()) != this.cUH.uw(bVar.aFT())) {
            this.cUH.ut(bVar.aFT());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cUE.get(bVar.dqt) == null) {
            String ae = ak.ae(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c nX = com.baidu.swan.apps.core.slave.b.nX(ae);
            if (nX != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + ae);
                }
                this.cUE.put(bVar.mPage, nX);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                nX = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cUE.put(bVar.mPage, nX);
            }
            nu(bVar.mPage);
            a(nX);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(bhB());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.ck("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).cn("preload", F.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + F);
        }
        com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0435b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0435b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.dab = F.cZA.amp();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(F, str4);
                }
                String tj = com.baidu.swan.apps.scheme.actions.k.j.tj(str2);
                bVar.appPath = str;
                bVar.dad = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aMm() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aMm().sy(tj);
                    bVar.daf = com.baidu.swan.apps.runtime.e.aMm().sA(tj);
                }
                bVar.cZZ = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aMl(), bVar.dad);
                bVar.dae = com.baidu.swan.apps.v.f.aDH().qf(tj).dae;
                bVar.cZY = String.valueOf(com.baidu.swan.apps.console.a.aph());
                bVar.daa = e.DEBUG || com.baidu.swan.apps.v.f.aDH().aDl();
                if (com.baidu.swan.apps.ad.a.a.aIL()) {
                    bVar.dac = com.baidu.swan.apps.console.debugger.b.apq();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.dag = str4;
                    com.baidu.swan.apps.performance.i.ck("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aRy();
                F.cZA.ams().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                F.cZA.kR(bVar.dad);
                com.baidu.swan.apps.v.f.aDH().a(F.cZA.amu(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cC(F.cZA.amu(), bVar.dad);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.cZA;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dqt;
        com.baidu.swan.apps.runtime.config.c qf = com.baidu.swan.apps.v.f.aDH().qf(TextUtils.isEmpty(str3) ? "" : str3);
        this.cUD.mPage = str2;
        this.cUD.mParams = bVar != null ? bVar.getParams() : "";
        this.cUD.dqt = str3;
        this.cUL = qf;
        boolean z = false;
        if (nt(str3)) {
            ns(str3);
        } else {
            z = true;
            a(bVar, str);
            ns(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.an(7, str);
            } else {
                com.baidu.swan.apps.performance.j.an(6, str);
            }
            com.baidu.swan.apps.performance.i.ck("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.rs(str);
        }
        no(qf.dIk);
        il(SwanAppConfigData.sF(qf.dIl));
        ik(qf.dIj);
        asO();
        asR();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + qf.dIk + " page:" + str2);
    }

    private void ns(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cUE.get(str);
        if (this.cUG != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c qf = com.baidu.swan.apps.v.f.aDH().qf(str);
            cVar.b(this.cUF, qf);
            if (!cVar.amj()) {
                cVar.a(this.cUF, qf);
            }
            cVar.hI(0);
            if (this.cUG != null) {
                this.cUG.hI(8);
            }
            this.cUG = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cUF;
    }

    private boolean nt(String str) {
        return (this.cUE.isEmpty() || this.cUE.get(str) == null) ? false : true;
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
        return asc() && this.cUG.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean arD() {
        SwanAppConfigData aDm;
        com.baidu.swan.apps.v.f aDH = com.baidu.swan.apps.v.f.aDH();
        if (aDH == null || (aDm = aDH.aDm()) == null || !aDm.aNb() || this.cUd == null) {
            return false;
        }
        return aDm.sL(this.cUd.getPage());
    }

    public boolean asB() {
        if (this.cUH == null) {
            return false;
        }
        return this.cUH.asB();
    }

    protected final boolean asC() {
        SwanAppConfigData aDm;
        f ajt = ajt();
        if (ajt == null) {
            return false;
        }
        if ((this.cUL != null && this.cUL.dIr) || (aDm = com.baidu.swan.apps.v.f.aDH().aDm()) == null) {
            return false;
        }
        return a(ajt, aDm) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c io2 = fVar.io(0);
        if (io2 == null || !(io2 instanceof e)) {
            return false;
        }
        String page = ((e) io2).asI().getPage();
        return swanAppConfigData.sL(page) || TextUtils.equals(swanAppConfigData.aDq(), page);
    }

    private boolean asD() {
        SwanAppConfigData aDm = com.baidu.swan.apps.v.f.aDH().aDm();
        return (aDm == null || TextUtils.equals(aDm.aDq(), this.cUD.getPage())) ? false : true;
    }

    public String asE() {
        return this.cUG != null ? this.cUG.amu() : "";
    }

    public List<String> asF() {
        ArrayList arrayList = new ArrayList();
        if (this.cUE != null && !this.cUE.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cUE.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().amu());
                }
            }
        }
        if (this.cUG != null) {
            String amu = this.cUG.amu();
            if (!arrayList.contains(amu)) {
                arrayList.add(amu);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean amm() {
        if ((ajo() == null || !ajo().aLE()) && !com.baidu.m.a.afh()) {
            if (this.cUG != null) {
                if (com.baidu.swan.apps.media.b.qj(this.cUG.amu())) {
                    return true;
                }
                return this.cUG.amm();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void amT() {
        FragmentActivity bhB = bhB();
        if (this.cUh == null) {
            this.cUh = new SwanAppMenuHeaderView(getContext());
        }
        if (bhB != null && this.cUg == null) {
            this.cUg = new com.baidu.swan.menu.g(bhB, this.cUf, amU(), com.baidu.swan.apps.t.a.aAw(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cUg, this, this.cUh).aFy();
            if (com.baidu.swan.apps.menu.fontsize.b.aFO()) {
                this.cUg.ng(50);
            }
        }
    }

    private int amU() {
        return ass() ? asD() ? 18 : 17 : asD() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> asG() {
        if (this.cUG == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cUG.ams().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a asH() {
        return this.cUH;
    }

    public com.baidu.swan.apps.model.b asI() {
        return this.cUD;
    }

    public com.baidu.swan.apps.adaptation.b.c asJ() {
        return this.cUG;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0473a
    public com.baidu.swan.apps.res.widget.floatlayer.a ajo() {
        if (this.cEs == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cEs = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), asn().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cEs;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c asg() {
        return this.cUL;
    }

    private boolean asK() {
        return this.cUL != null && this.cUL.dIo;
    }

    private boolean asL() {
        if (this.cUL == null) {
            return false;
        }
        return TextUtils.equals(this.cUL.dIq, "custom");
    }

    private void nu(String str) {
        if (!asL()) {
            com.baidu.swan.apps.v.f aDH = com.baidu.swan.apps.v.f.aDH();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aDH.qf(str).dIo && this.cUN == null) {
                this.cUN = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.in(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cUN != null) {
                cVar.a(this.cUN);
            }
            cVar.a(asM());
        }
    }

    private com.baidu.swan.apps.core.f.e asM() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cUN);
                    fVar.a(e.this.asN());
                    com.baidu.swan.apps.y.f.aGs().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cUN);
                    com.baidu.swan.apps.y.f.aGs().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a asN() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void jg(String str) {
                e.this.no(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cUN != null && cVar != null) {
            cVar.b(this.cUN);
            if (cVar.aml() != null) {
                cVar.b(this.cUN);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void asO() {
        int i;
        boolean z;
        int i2;
        com.baidu.swan.apps.adaptation.b.d dVar;
        if (this.cUf != null) {
            if (asL()) {
                fo(true);
                z = true;
                i2 = 1;
                i = 0;
            } else if (asK()) {
                fo(false);
                if (this.cUG != null) {
                    if (this.cUG.aml() != null) {
                        dVar = this.cUG.aml().ams();
                    } else {
                        dVar = this.cUG.ams();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cUL == null && this.cUL.dIp) {
                            z = true;
                            i2 = 0;
                        } else {
                            z = true;
                            i2 = 1;
                        }
                    }
                }
                i = 0;
                if (this.cUL == null) {
                }
                z = true;
                i2 = 1;
            } else {
                fo(false);
                i = cUB + this.cUM;
                z = false;
                i2 = 1;
            }
            TextView centerTitleView = this.cUf.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            in(i);
            fp(z);
        }
    }

    private void fp(boolean z) {
        int i;
        int dimensionPixelSize;
        if (z) {
            if (this.cUl == null || !this.cUl.aSu()) {
                i = 0;
                dimensionPixelSize = 0;
            } else {
                i = ah.getStatusBarHeight();
                dimensionPixelSize = 0;
            }
        } else {
            i = 0;
            dimensionPixelSize = asn().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cUF.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cUF.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cUe.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cUe.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(int i) {
        TextView centerTitleView;
        View aSt;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cUB) * 1.0f) / (this.cUM == 0 ? 1 : this.cUM);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cUl != null && this.cUl.aSu() && (aSt = this.cUl.aSt()) != null && (background = aSt.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cUf.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cUL != null && this.cUL.dIp && (centerTitleView = this.cUf.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cUj.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void asP() {
        this.cUC = com.baidu.swan.apps.statistic.h.tA("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cUC != null) {
            com.baidu.swan.apps.statistic.h.a(this.cUC, gVar);
            this.cUC = null;
        }
    }

    public void asQ() {
        this.cUL.dIq = "default";
        ash();
        asO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asR() {
        if (this.cUd != null) {
            this.cUd.asR();
        }
    }

    private void fq(boolean z) {
        if (com.baidu.swan.apps.x.a.gj(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cUf, com.baidu.swan.apps.runtime.e.aMm().aMp().aCM().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aMm() != null) {
            com.baidu.swan.apps.x.a.a(this.cUf, com.baidu.swan.apps.runtime.e.aMm().aMD().c("key_unread_counts_message", 0).intValue());
        }
    }

    private void fr(boolean z) {
        if (com.baidu.swan.apps.x.a.gj(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cUg, com.baidu.swan.apps.runtime.e.aMm().aMp().aCM().paNumber);
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        static int cUS = -1;

        static int asS() {
            if (cUS < 0) {
                cUS = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cUS);
            }
            return cUS;
        }

        static boolean asT() {
            return asS() > 0;
        }
    }
}
