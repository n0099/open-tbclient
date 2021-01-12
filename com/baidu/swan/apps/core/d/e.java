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
public class e extends c implements a.InterfaceC0456a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cPP = ah.O(149.0f);
    private static String cPW = "-1";
    private static String cPX = cPW;
    private static String cPY;
    private com.baidu.swan.apps.statistic.a cPQ;
    private FrameLayout cPT;
    private com.baidu.swan.apps.adaptation.b.c cPU;
    private com.baidu.swan.apps.tabbar.b.a cPV;
    private com.baidu.swan.apps.runtime.config.c cPZ;
    private com.baidu.swan.apps.core.f.c cQb;
    private com.baidu.swan.apps.adaptation.a.ah cQc;
    private com.baidu.swan.apps.res.widget.floatlayer.a czG;
    private View mRootView;
    private com.baidu.swan.apps.model.b cPR = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cPS = new TreeMap();
    private int cQa = 0;
    public boolean cQd = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoC();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cQc = com.baidu.swan.apps.t.a.axn();
                e.this.cQc.a(e.this.cPr, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.D("route", "fragment create.");
    }

    private void aoC() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cPr = com.baidu.swan.apps.model.c.py(arguments.getString("ai_apps_param"));
            this.cPR.mPage = this.cPr != null ? this.cPr.getPage() : "";
            this.cPR.mParams = this.cPr != null ? this.cPr.getParams() : "";
            this.cPR.dlD = com.baidu.swan.apps.scheme.actions.k.j.rX(this.cPR.getPage());
            this.cPZ = com.baidu.swan.apps.v.f.azN().oU(this.cPR.aBZ());
            if (this.cPZ.dDI) {
                this.cPZ = com.baidu.swan.apps.v.f.azN().oV(this.cPR.getPage());
            }
            this.cQa = aor().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cPT = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        av(inflate);
        this.cPV = new com.baidu.swan.apps.tabbar.b.a(this);
        aA(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aBU() && !com.baidu.swan.apps.menu.fontsize.b.aBS()) {
            com.baidu.swan.apps.menu.fontsize.a.ce(this.cPU.aiA(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBR()));
        }
        this.mRootView = a(aok() ? az(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cPU.aij());
        com.baidu.swan.apps.y.f.aCy().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aiq() {
        if (this.cPU != null) {
            return this.cPU.aiq();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        super.av(view);
        fj(aoh());
        if (aoG()) {
            aog();
        }
        aoS();
        this.cPt.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void aB(View view2) {
                String aiA = e.this.cPU.aiA();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cO(aiA, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.azN().a(aiA, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
        this.cPU.ait();
        aiZ();
        fn(true);
        if (this.cPv != null) {
            this.cPv.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mX(com.baidu.swan.apps.runtime.d.aIn().getAppId()));
        }
        this.cPu.a(com.baidu.swan.apps.t.a.awU().ahK(), aov(), this.cPv, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoe() {
        aox();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e aoZ = com.baidu.swan.apps.v.f.azN().aoZ();
        com.baidu.swan.apps.model.c aoy = aoZ == null ? null : aoZ.aoy();
        if (aoy != null && !TextUtils.isEmpty(aoy.getPage())) {
            fVar.t("page", aoy.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void gG(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cPZ)) {
            super.gG(i);
            return;
        }
        if (!aoP() && ac.dC(this.mActivity)) {
            z = false;
        }
        y(i, z);
        aoS();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean gE(int i) {
        boolean gE = super.gE(i);
        aoS();
        return gE;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aon() {
        super.aon();
        aoS();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        fm(false);
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
        if (this.cPu != null && this.cPu.isShowing()) {
            this.cPu.iy(com.baidu.swan.apps.t.a.awU().ahK());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cPU.aiA())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cPU.aiA())));
        }
    }

    public static void me(String str) {
        cPY = str;
    }

    private void aoD() {
        if (!TextUtils.equals(cPX, this.cPU.aiA()) || TextUtils.equals(cPY, "switchTab")) {
            int tl = this.cPV.tl(aoM().aBZ());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cYH = cPX;
            eVar.cYI = this.cPU.aiA();
            eVar.cQq = cPY;
            eVar.cYJ = this.cPR.mPage;
            eVar.cYK = String.valueOf(tl);
            cPY = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cYH + " ,toId: " + eVar.cYI + " ,RouteType: " + eVar.cQq + " page:" + eVar.cYJ + ",TabIndex: " + eVar.cYK);
            }
            com.baidu.swan.apps.v.f.azN().b(eVar);
            cPX = this.cPU.aiA();
        }
    }

    private void mf(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cPU.aiA());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cPU.aiA());
        }
        com.baidu.swan.apps.v.f.azN().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anL() {
        if (this.cPU == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cPU.aiA());
        com.baidu.swan.apps.adaptation.b.f air = this.cPU.air();
        if (air != null) {
            hashMap.put("webViewUrl", air.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aA(View view) {
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView start.");
        String azu = this.cPr.azu();
        String params = this.cPr.getParams();
        String page = this.cPr.getPage();
        String ad = ak.ad(azu, page, params);
        this.cPU = com.baidu.swan.apps.core.slave.b.mM(ad);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + ad + " is load: " + (this.cPU != null));
        }
        if (this.cPU == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cPU = q(azu, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c oU = com.baidu.swan.apps.v.f.azN().oU(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cPU.b(this.cPT, oU);
        this.cPU.a(this.cPT, oU);
        mj(page);
        a(this.cPU);
        if (anI()) {
            this.cPS.put(page, this.cPU);
            this.cPV.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.D("route", "createSlaveWebView end.");
        aoT();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cPS != null && !this.cPS.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cPS.values()) {
                if (cVar != null) {
                    cVar.aiB();
                }
            }
        } else if (this.cPU != null) {
            this.cPU.aiB();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.aoX()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.aoE();
                }
            });
        } else {
            aoE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoE() {
        if (this.cPS != null && !this.cPS.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cPS.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cPS.clear();
        } else if (this.cPU != null) {
            b(this.cPU);
            this.cPU.destroy();
        }
        this.cPU = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cQd) {
            com.baidu.swan.apps.core.slave.b.cM(com.baidu.swan.apps.v.f.azN().azx());
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
                fm(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cPU == null;
        String aiA = z ? "" : this.cPU.aiA();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aiA);
        }
        if (!z) {
            fj(aoh());
            this.cPU.onResume();
            aoD();
            mf("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fX(true);
        if (com.baidu.swan.apps.console.c.alq()) {
            com.baidu.swan.apps.core.c.b.anw();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aiq;
        boolean z = this.cPU == null;
        String aiA = z ? "" : this.cPU.aiA();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aiA);
        }
        if (!z) {
            this.cPU.onPause();
            mf("onHide");
        }
        if (afu() != null && !afu().aHK()) {
            afu().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fX(false);
        if (!z && (aiq = this.cPU.aiq()) != null) {
            aiq.gF(false);
        }
    }

    public String mg(String str) {
        if (this.cPS.containsKey(str)) {
            return this.cPS.get(str).aiA();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cPV.tl(aoM().aBZ()) != this.cPV.tl(bVar.aBZ())) {
            this.cPV.ti(bVar.aBZ());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cPS.get(bVar.dlD) == null) {
            String ad = ak.ad(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c mM = com.baidu.swan.apps.core.slave.b.mM(ad);
            if (mM != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + ad);
                }
                this.cPS.put(bVar.mPage, mM);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                mM = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cPS.put(bVar.mPage, mM);
            }
            mj(bVar.mPage);
            a(mM);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(bdH());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cj("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).cm("preload", F.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + F);
        }
        com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0418b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0418b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cVp = F.cUO.aiv();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(F, str4);
                }
                String rX = com.baidu.swan.apps.scheme.actions.k.j.rX(str2);
                bVar.appPath = str;
                bVar.cVr = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aIs() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aIs().rm(rX);
                    bVar.cVt = com.baidu.swan.apps.runtime.e.aIs().ro(rX);
                }
                bVar.cVn = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIr(), bVar.cVr);
                bVar.cVs = com.baidu.swan.apps.v.f.azN().oU(rX).cVs;
                bVar.cVm = String.valueOf(com.baidu.swan.apps.console.a.aln());
                bVar.cVo = e.DEBUG || com.baidu.swan.apps.v.f.azN().azr();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    bVar.cVq = com.baidu.swan.apps.console.debugger.b.alv();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cVu = str4;
                    com.baidu.swan.apps.performance.i.cj("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aNE();
                F.cUO.aiy().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                F.cUO.jG(bVar.cVr);
                com.baidu.swan.apps.v.f.azN().a(F.cUO.aiA(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cB(F.cUO.aiA(), bVar.cVr);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.cUO;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dlD;
        com.baidu.swan.apps.runtime.config.c oU = com.baidu.swan.apps.v.f.azN().oU(TextUtils.isEmpty(str3) ? "" : str3);
        this.cPR.mPage = str2;
        this.cPR.mParams = bVar != null ? bVar.getParams() : "";
        this.cPR.dlD = str3;
        this.cPZ = oU;
        boolean z = false;
        if (mi(str3)) {
            mh(str3);
        } else {
            z = true;
            a(bVar, str);
            mh(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.ao(7, str);
            } else {
                com.baidu.swan.apps.performance.j.ao(6, str);
            }
            com.baidu.swan.apps.performance.i.cj("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qh(str);
        }
        md(oU.dDy);
        gF(SwanAppConfigData.rt(oU.dDz));
        gE(oU.dDx);
        aoS();
        aoV();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + oU.dDy + " page:" + str2);
    }

    private void mh(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cPS.get(str);
        if (this.cPU != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c oU = com.baidu.swan.apps.v.f.azN().oU(str);
            cVar.b(this.cPT, oU);
            if (!cVar.aip()) {
                cVar.a(this.cPT, oU);
            }
            cVar.gb(0);
            if (this.cPU != null) {
                this.cPU.gb(8);
            }
            this.cPU = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cPT;
    }

    private boolean mi(String str) {
        return (this.cPS.isEmpty() || this.cPS.get(str) == null) ? false : true;
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
        return aoh() && this.cPU.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        SwanAppConfigData azs;
        com.baidu.swan.apps.v.f azN = com.baidu.swan.apps.v.f.azN();
        if (azN == null || (azs = azN.azs()) == null || !azs.aJh() || this.cPr == null) {
            return false;
        }
        return azs.rz(this.cPr.getPage());
    }

    public boolean aoF() {
        if (this.cPV == null) {
            return false;
        }
        return this.cPV.aoF();
    }

    protected final boolean aoG() {
        SwanAppConfigData azs;
        f afz = afz();
        if (afz == null) {
            return false;
        }
        if ((this.cPZ != null && this.cPZ.dDF) || (azs = com.baidu.swan.apps.v.f.azN().azs()) == null) {
            return false;
        }
        return a(afz, azs) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c gI = fVar.gI(0);
        if (gI == null || !(gI instanceof e)) {
            return false;
        }
        String page = ((e) gI).aoM().getPage();
        return swanAppConfigData.rz(page) || TextUtils.equals(swanAppConfigData.azw(), page);
    }

    private boolean aoH() {
        SwanAppConfigData azs = com.baidu.swan.apps.v.f.azN().azs();
        return (azs == null || TextUtils.equals(azs.azw(), this.cPR.getPage())) ? false : true;
    }

    public String aoI() {
        return this.cPU != null ? this.cPU.aiA() : "";
    }

    public List<String> aoJ() {
        ArrayList arrayList = new ArrayList();
        if (this.cPS != null && !this.cPS.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cPS.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aiA());
                }
            }
        }
        if (this.cPU != null) {
            String aiA = this.cPU.aiA();
            if (!arrayList.contains(aiA)) {
                arrayList.add(aiA);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        if ((afu() == null || !afu().aHK()) && !com.baidu.k.a.abo()) {
            if (this.cPU != null) {
                if (com.baidu.swan.apps.media.b.oY(this.cPU.aiA())) {
                    return true;
                }
                return this.cPU.ais();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void aiZ() {
        FragmentActivity bdH = bdH();
        if (this.cPv == null) {
            this.cPv = new SwanAppMenuHeaderView(getContext());
        }
        if (bdH != null && this.cPu == null) {
            this.cPu = new com.baidu.swan.menu.g(bdH, this.cPt, aja(), com.baidu.swan.apps.t.a.awC(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPu, this, this.cPv).aBE();
            if (com.baidu.swan.apps.menu.fontsize.b.aBU()) {
                this.cPu.lA(50);
            }
        }
    }

    private int aja() {
        return aow() ? aoH() ? 18 : 17 : aoH() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> aoK() {
        if (this.cPU == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cPU.aiy().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aoL() {
        return this.cPV;
    }

    public com.baidu.swan.apps.model.b aoM() {
        return this.cPR;
    }

    public com.baidu.swan.apps.adaptation.b.c aoN() {
        return this.cPU;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0456a
    public com.baidu.swan.apps.res.widget.floatlayer.a afu() {
        if (this.czG == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.czG = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aor().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.czG;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aol() {
        return this.cPZ;
    }

    private boolean aoO() {
        return this.cPZ != null && this.cPZ.dDC;
    }

    private boolean aoP() {
        if (this.cPZ == null) {
            return false;
        }
        return TextUtils.equals(this.cPZ.dDE, "custom");
    }

    private void mj(String str) {
        if (!aoP()) {
            com.baidu.swan.apps.v.f azN = com.baidu.swan.apps.v.f.azN();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (azN.oU(str).dDC && this.cQb == null) {
                this.cQb = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.gH(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cQb != null) {
                cVar.a(this.cQb);
            }
            cVar.a(aoQ());
        }
    }

    private com.baidu.swan.apps.core.f.e aoQ() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cQb);
                    fVar.a(e.this.aoR());
                    com.baidu.swan.apps.y.f.aCy().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cQb);
                    com.baidu.swan.apps.y.f.aCy().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a aoR() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hV(String str) {
                e.this.md(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cQb != null && cVar != null) {
            cVar.b(this.cQb);
            if (cVar.air() != null) {
                cVar.b(this.cQb);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void aoS() {
        int i;
        boolean z;
        int i2;
        com.baidu.swan.apps.adaptation.b.d dVar;
        if (this.cPt != null) {
            if (aoP()) {
                fk(true);
                z = true;
                i2 = 1;
                i = 0;
            } else if (aoO()) {
                fk(false);
                if (this.cPU != null) {
                    if (this.cPU.air() != null) {
                        dVar = this.cPU.air().aiy();
                    } else {
                        dVar = this.cPU.aiy();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cPZ == null && this.cPZ.dDD) {
                            z = true;
                            i2 = 0;
                        } else {
                            z = true;
                            i2 = 1;
                        }
                    }
                }
                i = 0;
                if (this.cPZ == null) {
                }
                z = true;
                i2 = 1;
            } else {
                fk(false);
                i = cPP + this.cQa;
                z = false;
                i2 = 1;
            }
            TextView centerTitleView = this.cPt.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            gH(i);
            fl(z);
        }
    }

    private void fl(boolean z) {
        int i;
        int dimensionPixelSize;
        if (z) {
            if (this.cPz == null || !this.cPz.aOA()) {
                i = 0;
                dimensionPixelSize = 0;
            } else {
                i = ah.getStatusBarHeight();
                dimensionPixelSize = 0;
            }
        } else {
            i = 0;
            dimensionPixelSize = aor().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cPT.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cPT.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cPs.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cPs.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH(int i) {
        TextView centerTitleView;
        View aOz;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cPP) * 1.0f) / (this.cQa == 0 ? 1 : this.cQa);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cPz != null && this.cPz.aOA() && (aOz = this.cPz.aOz()) != null && (background = aOz.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cPt.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cPZ != null && this.cPZ.dDD && (centerTitleView = this.cPt.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cPx.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void aoT() {
        this.cPQ = com.baidu.swan.apps.statistic.h.so("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cPQ != null) {
            com.baidu.swan.apps.statistic.h.a(this.cPQ, gVar);
            this.cPQ = null;
        }
    }

    public void aoU() {
        this.cPZ.dDE = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        aom();
        aoS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoV() {
        if (this.cPr != null) {
            this.cPr.aoV();
        }
    }

    private void fm(boolean z) {
        if (com.baidu.swan.apps.x.a.gf(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cPt, com.baidu.swan.apps.runtime.e.aIs().aIv().ayS().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aIs() != null) {
            com.baidu.swan.apps.x.a.a(this.cPt, com.baidu.swan.apps.runtime.e.aIs().aIJ().c("key_unread_counts_message", 0).intValue());
        }
    }

    private void fn(boolean z) {
        if (com.baidu.swan.apps.x.a.gf(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cPu, com.baidu.swan.apps.runtime.e.aIs().aIv().ayS().paNumber);
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        static int cQg = -1;

        static int aoW() {
            if (cQg < 0) {
                cQg = com.baidu.swan.apps.t.a.awB().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cQg);
            }
            return cQg;
        }

        static boolean aoX() {
            return aoW() > 0;
        }
    }
}
