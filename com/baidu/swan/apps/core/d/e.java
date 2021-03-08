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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
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
/* loaded from: classes8.dex */
public class e extends c implements a.InterfaceC0459a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cTC = ah.T(149.0f);
    private static String cTJ = "-1";
    private static String cTK = cTJ;
    private static String cTL;
    private com.baidu.swan.apps.res.widget.floatlayer.a cDC;
    private com.baidu.swan.apps.statistic.a cTD;
    private FrameLayout cTG;
    private com.baidu.swan.apps.adaptation.b.c cTH;
    private com.baidu.swan.apps.tabbar.b.a cTI;
    private com.baidu.swan.apps.runtime.config.c cTM;
    private com.baidu.swan.apps.core.f.c cTO;
    private com.baidu.swan.apps.adaptation.a.ah cTP;
    private View mRootView;
    private com.baidu.swan.apps.model.b cTE = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cTF = new TreeMap();
    private int cTN = 0;
    public boolean cTQ = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        apd();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cTP = com.baidu.swan.apps.t.a.axO();
                e.this.cTP.a(e.this.cTf, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.B("route", "fragment create.");
    }

    private void apd() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cTf = com.baidu.swan.apps.model.c.pX(arguments.getString("ai_apps_param"));
            this.cTE.mPage = this.cTf != null ? this.cTf.getPage() : "";
            this.cTE.mParams = this.cTf != null ? this.cTf.getParams() : "";
            this.cTE.dps = com.baidu.swan.apps.scheme.actions.k.j.sy(this.cTE.getPage());
            this.cTM = com.baidu.swan.apps.v.f.aAo().pt(this.cTE.aCz());
            if (this.cTM.dHn) {
                this.cTM = com.baidu.swan.apps.v.f.aAo().pu(this.cTE.getPage());
            }
            this.cTN = aoS().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.h.B("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.cTG = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        aq(inflate);
        this.cTI = new com.baidu.swan.apps.tabbar.b.a(this);
        aw(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aCu() && !com.baidu.swan.apps.menu.fontsize.b.aCs()) {
            com.baidu.swan.apps.menu.fontsize.a.bY(this.cTH.ajb(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCr()));
        }
        this.mRootView = a(aoL() ? av(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cTH.aiK());
        com.baidu.swan.apps.y.f.aCX().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aiR() {
        if (this.cTH != null) {
            return this.cTH.aiR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        super.aq(view);
        fl(aoI());
        if (aph()) {
            aoH();
        }
        apu();
        this.cTh.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void ax(View view2) {
                String ajb = e.this.cTH.ajb();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cI(ajb, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.aAo().a(ajb, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
        this.cTH.aiU();
        ajA();
        fp(true);
        if (this.cTj != null) {
            this.cTj.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nw(com.baidu.swan.apps.runtime.d.aIJ().getAppId()));
        }
        this.cTi.a(com.baidu.swan.apps.t.a.axv().ail(), aoW(), this.cTj, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoF() {
        aoY();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e apB = com.baidu.swan.apps.v.f.aAo().apB();
        com.baidu.swan.apps.model.c aoZ = apB == null ? null : apB.aoZ();
        if (aoZ != null && !TextUtils.isEmpty(aoZ.getPage())) {
            fVar.s("page", aoZ.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void gK(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cTM)) {
            super.gK(i);
            return;
        }
        if (!apr() && ac.dA(this.mActivity)) {
            z = false;
        }
        y(i, z);
        apu();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean gI(int i) {
        boolean gI = super.gI(i);
        apu();
        return gI;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aoO() {
        super.aoO();
        apu();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        fo(false);
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
        if (this.cTi != null && this.cTi.isShowing()) {
            this.cTi.iA(com.baidu.swan.apps.t.a.axv().ail());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cTH.ajb())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cTH.ajb())));
        }
    }

    public static void mD(String str) {
        cTL = str;
    }

    private void ape() {
        if (!TextUtils.equals(cTK, this.cTH.ajb()) || TextUtils.equals(cTL, "switchTab")) {
            int tL = this.cTI.tL(apo().aCz());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.dcv = cTK;
            eVar.dcw = this.cTH.ajb();
            eVar.cUd = cTL;
            eVar.dcx = this.cTE.mPage;
            eVar.dcy = String.valueOf(tL);
            cTL = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.dcv + " ,toId: " + eVar.dcw + " ,RouteType: " + eVar.cUd + " page:" + eVar.dcx + ",TabIndex: " + eVar.dcy);
            }
            com.baidu.swan.apps.v.f.aAo().b(eVar);
            cTK = this.cTH.ajb();
        }
    }

    private void mE(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cTH.ajb());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cTH.ajb());
        }
        com.baidu.swan.apps.v.f.aAo().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aom() {
        if (this.cTH == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cTH.ajb());
        com.baidu.swan.apps.adaptation.b.f aiS = this.cTH.aiS();
        if (aiS != null) {
            hashMap.put("webViewUrl", aiS.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aw(View view) {
        com.baidu.swan.apps.performance.h.B("route", "createSlaveWebView start.");
        String azV = this.cTf.azV();
        String params = this.cTf.getParams();
        String page = this.cTf.getPage();
        String ae = ak.ae(azV, page, params);
        this.cTH = com.baidu.swan.apps.core.slave.b.nl(ae);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + ae + " is load: " + (this.cTH != null));
        }
        if (this.cTH == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cTH = q(azV, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c pt = com.baidu.swan.apps.v.f.aAo().pt(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cTH.b(this.cTG, pt);
        this.cTH.a(this.cTG, pt);
        mI(page);
        a(this.cTH);
        if (aoj()) {
            this.cTF.put(page, this.cTH);
            this.cTI.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.B("route", "createSlaveWebView end.");
        apv();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cTF != null && !this.cTF.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cTF.values()) {
                if (cVar != null) {
                    cVar.ajc();
                }
            }
        } else if (this.cTH != null) {
            this.cTH.ajc();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.apz()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.apf();
                }
            });
        } else {
            apf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apf() {
        if (this.cTF != null && !this.cTF.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cTF.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cTF.clear();
        } else if (this.cTH != null) {
            b(this.cTH);
            this.cTH.destroy();
        }
        this.cTH = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cTQ) {
            com.baidu.swan.apps.core.slave.b.cK(com.baidu.swan.apps.v.f.aAo().azY());
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
                fo(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cTH == null;
        String ajb = z ? "" : this.cTH.ajb();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + ajb);
        }
        if (!z) {
            fl(aoI());
            this.cTH.onResume();
            ape();
            mE("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fZ(true);
        if (com.baidu.swan.apps.console.c.alR()) {
            com.baidu.swan.apps.core.c.b.anX();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aiR;
        boolean z = this.cTH == null;
        String ajb = z ? "" : this.cTH.ajb();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + ajb);
        }
        if (!z) {
            this.cTH.onPause();
            mE("onHide");
        }
        if (afV() != null && !afV().aIg()) {
            afV().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fZ(false);
        if (!z && (aiR = this.cTH.aiR()) != null) {
            aiR.gH(false);
        }
    }

    public String mF(String str) {
        if (this.cTF.containsKey(str)) {
            return this.cTF.get(str).ajb();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cTI.tL(apo().aCz()) != this.cTI.tL(bVar.aCz())) {
            this.cTI.tI(bVar.aCz());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cTF.get(bVar.dps) == null) {
            String ae = ak.ae(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c nl = com.baidu.swan.apps.core.slave.b.nl(ae);
            if (nl != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + ae);
                }
                this.cTF.put(bVar.mPage, nl);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                nl = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cTF.put(bVar.mPage, nl);
            }
            mI(bVar.mPage);
            a(nl);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a z = com.baidu.swan.apps.core.slave.b.z(bdW());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cd("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).cg("preload", z.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(z, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cZb = z.cYB.aiW();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(z, str4);
                }
                String sy = com.baidu.swan.apps.scheme.actions.k.j.sy(str2);
                bVar.appPath = str;
                bVar.cZd = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aIO() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aIO().rM(sy);
                    bVar.cZf = com.baidu.swan.apps.runtime.e.aIO().rO(sy);
                }
                bVar.cYZ = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIN(), bVar.cZd);
                bVar.cZe = com.baidu.swan.apps.v.f.aAo().pt(sy).cZe;
                bVar.cYY = String.valueOf(com.baidu.swan.apps.console.a.alO());
                bVar.cZa = e.DEBUG || com.baidu.swan.apps.v.f.aAo().azS();
                if (com.baidu.swan.apps.ad.a.a.aFp()) {
                    bVar.cZc = com.baidu.swan.apps.console.debugger.b.alW();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cZg = str4;
                    com.baidu.swan.apps.performance.i.cd("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aOa();
                z.cYB.aiZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                z.cYB.kf(bVar.cZd);
                com.baidu.swan.apps.v.f.aAo().a(z.cYB.ajb(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cv(z.cYB.ajb(), bVar.cZd);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return z.cYB;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dps;
        com.baidu.swan.apps.runtime.config.c pt = com.baidu.swan.apps.v.f.aAo().pt(TextUtils.isEmpty(str3) ? "" : str3);
        this.cTE.mPage = str2;
        this.cTE.mParams = bVar != null ? bVar.getParams() : "";
        this.cTE.dps = str3;
        this.cTM = pt;
        boolean z = false;
        if (mH(str3)) {
            mG(str3);
        } else {
            z = true;
            a(bVar, str);
            mG(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.as(7, str);
            } else {
                com.baidu.swan.apps.performance.j.as(6, str);
            }
            com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qG(str);
        }
        mC(pt.dHd);
        gJ(SwanAppConfigData.rT(pt.dHe));
        gI(pt.dHc);
        apu();
        apx();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + pt.dHd + " page:" + str2);
    }

    private void mG(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cTF.get(str);
        if (this.cTH != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c pt = com.baidu.swan.apps.v.f.aAo().pt(str);
            cVar.b(this.cTG, pt);
            if (!cVar.aiQ()) {
                cVar.a(this.cTG, pt);
            }
            cVar.gf(0);
            if (this.cTH != null) {
                this.cTH.gf(8);
            }
            this.cTH = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cTG;
    }

    private boolean mH(String str) {
        return (this.cTF.isEmpty() || this.cTF.get(str) == null) ? false : true;
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
        return aoI() && this.cTH.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        SwanAppConfigData azT;
        com.baidu.swan.apps.v.f aAo = com.baidu.swan.apps.v.f.aAo();
        if (aAo == null || (azT = aAo.azT()) == null || !azT.aJD() || this.cTf == null) {
            return false;
        }
        return azT.rZ(this.cTf.getPage());
    }

    public boolean apg() {
        if (this.cTI == null) {
            return false;
        }
        return this.cTI.apg();
    }

    protected final boolean aph() {
        SwanAppConfigData azT;
        f aga = aga();
        if (aga == null) {
            return false;
        }
        if ((this.cTM != null && this.cTM.dHk) || (azT = com.baidu.swan.apps.v.f.aAo().azT()) == null) {
            return false;
        }
        return a(aga, azT) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c gM = fVar.gM(0);
        if (gM == null || !(gM instanceof e)) {
            return false;
        }
        String page = ((e) gM).apo().getPage();
        return swanAppConfigData.rZ(page) || TextUtils.equals(swanAppConfigData.azX(), page);
    }

    private boolean apj() {
        SwanAppConfigData azT = com.baidu.swan.apps.v.f.aAo().azT();
        return (azT == null || TextUtils.equals(azT.azX(), this.cTE.getPage())) ? false : true;
    }

    public String apk() {
        return this.cTH != null ? this.cTH.ajb() : "";
    }

    public List<String> apl() {
        ArrayList arrayList = new ArrayList();
        if (this.cTF != null && !this.cTF.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cTF.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().ajb());
                }
            }
        }
        if (this.cTH != null) {
            String ajb = this.cTH.ajb();
            if (!arrayList.contains(ajb)) {
                arrayList.add(ajb);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        if ((afV() == null || !afV().aIg()) && !com.baidu.k.a.adf()) {
            if (this.cTH != null) {
                if (com.baidu.swan.apps.media.b.px(this.cTH.ajb())) {
                    return true;
                }
                return this.cTH.aiT();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void ajA() {
        FragmentActivity bdW = bdW();
        if (this.cTj == null) {
            this.cTj = new SwanAppMenuHeaderView(getContext());
        }
        if (bdW != null && this.cTi == null) {
            this.cTi = new com.baidu.swan.menu.g(bdW, this.cTh, ajB(), com.baidu.swan.apps.t.a.axd(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cTi, this, this.cTj).aCe();
            if (com.baidu.swan.apps.menu.fontsize.b.aCu()) {
                this.cTi.lE(50);
            }
        }
    }

    private int ajB() {
        return aoX() ? apj() ? 18 : 17 : apj() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> apm() {
        if (this.cTH == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cTH.aiZ().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a apn() {
        return this.cTI;
    }

    public com.baidu.swan.apps.model.b apo() {
        return this.cTE;
    }

    public com.baidu.swan.apps.adaptation.b.c app() {
        return this.cTH;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0459a
    public com.baidu.swan.apps.res.widget.floatlayer.a afV() {
        if (this.cDC == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cDC = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aoS().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cDC;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aoM() {
        return this.cTM;
    }

    private boolean apq() {
        return this.cTM != null && this.cTM.dHh;
    }

    private boolean apr() {
        if (this.cTM == null) {
            return false;
        }
        return TextUtils.equals(this.cTM.dHj, "custom");
    }

    private void mI(String str) {
        if (!apr()) {
            com.baidu.swan.apps.v.f aAo = com.baidu.swan.apps.v.f.aAo();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aAo.pt(str).dHh && this.cTO == null) {
                this.cTO = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.gL(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cTO != null) {
                cVar.a(this.cTO);
            }
            cVar.a(aps());
        }
    }

    private com.baidu.swan.apps.core.f.e aps() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cTO);
                    fVar.a(e.this.apt());
                    com.baidu.swan.apps.y.f.aCX().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cTO);
                    com.baidu.swan.apps.y.f.aCX().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a apt() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iB(String str) {
                e.this.mC(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cTO != null && cVar != null) {
            cVar.b(this.cTO);
            if (cVar.aiS() != null) {
                cVar.b(this.cTO);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void apu() {
        int i;
        boolean z;
        int i2;
        com.baidu.swan.apps.adaptation.b.d dVar;
        if (this.cTh != null) {
            if (apr()) {
                fm(true);
                z = true;
                i2 = 1;
                i = 0;
            } else if (apq()) {
                fm(false);
                if (this.cTH != null) {
                    if (this.cTH.aiS() != null) {
                        dVar = this.cTH.aiS().aiZ();
                    } else {
                        dVar = this.cTH.aiZ();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cTM == null && this.cTM.dHi) {
                            z = true;
                            i2 = 0;
                        } else {
                            z = true;
                            i2 = 1;
                        }
                    }
                }
                i = 0;
                if (this.cTM == null) {
                }
                z = true;
                i2 = 1;
            } else {
                fm(false);
                i = cTC + this.cTN;
                z = false;
                i2 = 1;
            }
            TextView centerTitleView = this.cTh.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            gL(i);
            fn(z);
        }
    }

    private void fn(boolean z) {
        int i;
        int dimensionPixelSize;
        if (z) {
            if (this.cTn == null || !this.cTn.aOW()) {
                i = 0;
                dimensionPixelSize = 0;
            } else {
                i = ah.getStatusBarHeight();
                dimensionPixelSize = 0;
            }
        } else {
            i = 0;
            dimensionPixelSize = aoS().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cTG.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cTG.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cTg.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cTg.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(int i) {
        TextView centerTitleView;
        View aOV;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cTC) * 1.0f) / (this.cTN == 0 ? 1 : this.cTN);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cTn != null && this.cTn.aOW() && (aOV = this.cTn.aOV()) != null && (background = aOV.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cTh.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cTM != null && this.cTM.dHi && (centerTitleView = this.cTh.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cTl.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void apv() {
        this.cTD = com.baidu.swan.apps.statistic.h.sP("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cTD != null) {
            com.baidu.swan.apps.statistic.h.a(this.cTD, gVar);
            this.cTD = null;
        }
    }

    public void apw() {
        this.cTM.dHj = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        aoN();
        apu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apx() {
        if (this.cTf != null) {
            this.cTf.apx();
        }
    }

    private void fo(boolean z) {
        if (com.baidu.swan.apps.x.a.gh(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cTh, com.baidu.swan.apps.runtime.e.aIO().aIR().azt().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aIO() != null) {
            com.baidu.swan.apps.x.a.a(this.cTh, com.baidu.swan.apps.runtime.e.aIO().aJf().c("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void fp(boolean z) {
        if (com.baidu.swan.apps.x.a.gh(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cTi, com.baidu.swan.apps.runtime.e.aIO().aIR().azt().paNumber);
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        static int cTT = -1;

        static int apy() {
            if (cTT < 0) {
                cTT = com.baidu.swan.apps.t.a.axc().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cTT);
            }
            return cTT;
        }

        static boolean apz() {
            return apy() > 0;
        }
    }
}
