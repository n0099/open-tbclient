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
/* loaded from: classes9.dex */
public class e extends c implements a.InterfaceC0453a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cSc = ah.P(149.0f);
    private static String cSj = "-1";
    private static String cSk = cSj;
    private static String cSl;
    private com.baidu.swan.apps.res.widget.floatlayer.a cCc;
    private com.baidu.swan.apps.statistic.a cSd;
    private FrameLayout cSg;
    private com.baidu.swan.apps.adaptation.b.c cSh;
    private com.baidu.swan.apps.tabbar.b.a cSi;
    private com.baidu.swan.apps.runtime.config.c cSm;
    private com.baidu.swan.apps.core.f.c cSo;
    private com.baidu.swan.apps.adaptation.a.ah cSp;
    private View mRootView;
    private com.baidu.swan.apps.model.b cSe = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cSf = new TreeMap();
    private int cSn = 0;
    public boolean cSq = false;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        apa();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cSp = com.baidu.swan.apps.t.a.axL();
                e.this.cSp.a(e.this.cRF, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.B("route", "fragment create.");
    }

    private void apa() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cRF = com.baidu.swan.apps.model.c.pQ(arguments.getString("ai_apps_param"));
            this.cSe.mPage = this.cRF != null ? this.cRF.getPage() : "";
            this.cSe.mParams = this.cRF != null ? this.cRF.getParams() : "";
            this.cSe.dnO = com.baidu.swan.apps.scheme.actions.k.j.sq(this.cSe.getPage());
            this.cSm = com.baidu.swan.apps.v.f.aAl().pm(this.cSe.aCw());
            if (this.cSm.dFM) {
                this.cSm = com.baidu.swan.apps.v.f.aAl().pn(this.cSe.getPage());
            }
            this.cSn = aoP().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.cSg = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        aq(inflate);
        this.cSi = new com.baidu.swan.apps.tabbar.b.a(this);
        aw(inflate);
        if (!com.baidu.swan.apps.menu.fontsize.b.aCr() && !com.baidu.swan.apps.menu.fontsize.b.aCp()) {
            com.baidu.swan.apps.menu.fontsize.a.bY(this.cSh.aiY(), String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCo()));
        }
        this.mRootView = a(aoI() ? av(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cSh.aiH());
        com.baidu.swan.apps.y.f.aCU().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView aiO() {
        if (this.cSh != null) {
            return this.cSh.aiO();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        super.aq(view);
        fl(aoF());
        if (ape()) {
            aoE();
        }
        apr();
        this.cRH.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void ax(View view2) {
                String aiY = e.this.cSh.aiY();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cI(aiY, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.aAl().a(aiY, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
        this.cSh.aiR();
        ajx();
        fp(true);
        if (this.cRJ != null) {
            this.cRJ.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.np(com.baidu.swan.apps.runtime.d.aIG().getAppId()));
        }
        this.cRI.a(com.baidu.swan.apps.t.a.axs().aii(), aoT(), this.cRJ, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoC() {
        aoV();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e apy = com.baidu.swan.apps.v.f.aAl().apy();
        com.baidu.swan.apps.model.c aoW = apy == null ? null : apy.aoW();
        if (aoW != null && !TextUtils.isEmpty(aoW.getPage())) {
            fVar.r("page", aoW.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void gJ(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cSm)) {
            super.gJ(i);
            return;
        }
        if (!apo() && ac.dB(this.mActivity)) {
            z = false;
        }
        y(i, z);
        apr();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean gH(int i) {
        boolean gH = super.gH(i);
        apr();
        return gH;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aoL() {
        super.aoL();
        apr();
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
        if (this.cRI != null && this.cRI.isShowing()) {
            this.cRI.iA(com.baidu.swan.apps.t.a.axs().aii());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cSh.aiY())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cSh.aiY())));
        }
    }

    public static void mw(String str) {
        cSl = str;
    }

    private void apb() {
        if (!TextUtils.equals(cSk, this.cSh.aiY()) || TextUtils.equals(cSl, "switchTab")) {
            int tE = this.cSi.tE(apl().aCw());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.daT = cSk;
            eVar.daU = this.cSh.aiY();
            eVar.cSD = cSl;
            eVar.daV = this.cSe.mPage;
            eVar.daW = String.valueOf(tE);
            cSl = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.daT + " ,toId: " + eVar.daU + " ,RouteType: " + eVar.cSD + " page:" + eVar.daV + ",TabIndex: " + eVar.daW);
            }
            com.baidu.swan.apps.v.f.aAl().b(eVar);
            cSk = this.cSh.aiY();
        }
    }

    private void mx(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cSh.aiY());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cSh.aiY());
        }
        com.baidu.swan.apps.v.f.aAl().b(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aoj() {
        if (this.cSh == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cSh.aiY());
        com.baidu.swan.apps.adaptation.b.f aiP = this.cSh.aiP();
        if (aiP != null) {
            hashMap.put("webViewUrl", aiP.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void aw(View view) {
        com.baidu.swan.apps.performance.h.B("route", "createSlaveWebView start.");
        String azS = this.cRF.azS();
        String params = this.cRF.getParams();
        String page = this.cRF.getPage();
        String ae = ak.ae(azS, page, params);
        this.cSh = com.baidu.swan.apps.core.slave.b.ne(ae);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + ae + " is load: " + (this.cSh != null));
        }
        if (this.cSh == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cSh = q(azS, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c pm = com.baidu.swan.apps.v.f.aAl().pm(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cSh.b(this.cSg, pm);
        this.cSh.a(this.cSg, pm);
        mB(page);
        a(this.cSh);
        if (aog()) {
            this.cSf.put(page, this.cSh);
            this.cSi.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.B("route", "createSlaveWebView end.");
        aps();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cSf != null && !this.cSf.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cSf.values()) {
                if (cVar != null) {
                    cVar.aiZ();
                }
            }
        } else if (this.cSh != null) {
            this.cSh.aiZ();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.apw()) {
            ak.getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.3
                @Override // java.lang.Runnable
                public void run() {
                    e.this.apc();
                }
            });
        } else {
            apc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apc() {
        if (this.cSf != null && !this.cSf.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cSf.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cSf.clear();
        } else if (this.cSh != null) {
            b(this.cSh);
            this.cSh.destroy();
        }
        this.cSh = null;
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (!this.cSq) {
            com.baidu.swan.apps.core.slave.b.cL(com.baidu.swan.apps.v.f.aAl().azV());
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
        boolean z = this.cSh == null;
        String aiY = z ? "" : this.cSh.aiY();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + aiY);
        }
        if (!z) {
            fl(aoF());
            this.cSh.onResume();
            apb();
            mx("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.fZ(true);
        if (com.baidu.swan.apps.console.c.alO()) {
            com.baidu.swan.apps.core.c.b.anU();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView aiO;
        boolean z = this.cSh == null;
        String aiY = z ? "" : this.cSh.aiY();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + aiY);
        }
        if (!z) {
            this.cSh.onPause();
            mx("onHide");
        }
        if (afS() != null && !afS().aId()) {
            afS().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.fZ(false);
        if (!z && (aiO = this.cSh.aiO()) != null) {
            aiO.gH(false);
        }
    }

    public String my(String str) {
        if (this.cSf.containsKey(str)) {
            return this.cSf.get(str).aiY();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cSi.tE(apl().aCw()) != this.cSi.tE(bVar.aCw())) {
            this.cSi.tB(bVar.aCw());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cSf.get(bVar.dnO) == null) {
            String ae = ak.ae(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c ne = com.baidu.swan.apps.core.slave.b.ne(ae);
            if (ne != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + ae);
                }
                this.cSf.put(bVar.mPage, ne);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                ne = q(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cSf.put(bVar.mPage, ne);
            }
            mB(bVar.mPage);
            a(ne);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c q(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a z = com.baidu.swan.apps.core.slave.b.z(bdU());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.cd("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).cg("preload", z.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(z, new b.InterfaceC0415b() { // from class: com.baidu.swan.apps.core.d.e.4
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0415b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cXB = z.cXb.aiT();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(z, str4);
                }
                String sq = com.baidu.swan.apps.scheme.actions.k.j.sq(str2);
                bVar.appPath = str;
                bVar.cXD = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.aIL() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.aIL().rF(sq);
                    bVar.cXF = com.baidu.swan.apps.runtime.e.aIL().rH(sq);
                }
                bVar.cXz = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIK(), bVar.cXD);
                bVar.cXE = com.baidu.swan.apps.v.f.aAl().pm(sq).cXE;
                bVar.cXy = String.valueOf(com.baidu.swan.apps.console.a.alL());
                bVar.cXA = e.DEBUG || com.baidu.swan.apps.v.f.aAl().azP();
                if (com.baidu.swan.apps.ad.a.a.aFm()) {
                    bVar.cXC = com.baidu.swan.apps.console.debugger.b.alT();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.cXG = str4;
                    com.baidu.swan.apps.performance.i.cd("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                ab.aNX();
                z.cXb.aiW().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                z.cXb.jY(bVar.cXD);
                com.baidu.swan.apps.v.f.aAl().a(z.cXb.aiY(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.cv(z.cXb.aiY(), bVar.cXD);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return z.cXb;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.dnO;
        com.baidu.swan.apps.runtime.config.c pm = com.baidu.swan.apps.v.f.aAl().pm(TextUtils.isEmpty(str3) ? "" : str3);
        this.cSe.mPage = str2;
        this.cSe.mParams = bVar != null ? bVar.getParams() : "";
        this.cSe.dnO = str3;
        this.cSm = pm;
        boolean z = false;
        if (mA(str3)) {
            mz(str3);
        } else {
            z = true;
            a(bVar, str);
            mz(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.as(7, str);
            } else {
                com.baidu.swan.apps.performance.j.as(6, str);
            }
            com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.qz(str);
        }
        mv(pm.dFC);
        gI(SwanAppConfigData.rM(pm.dFD));
        gH(pm.dFB);
        apr();
        apu();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + pm.dFC + " page:" + str2);
    }

    private void mz(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cSf.get(str);
        if (this.cSh != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c pm = com.baidu.swan.apps.v.f.aAl().pm(str);
            cVar.b(this.cSg, pm);
            if (!cVar.aiN()) {
                cVar.a(this.cSg, pm);
            }
            cVar.ge(0);
            if (this.cSh != null) {
                this.cSh.ge(8);
            }
            this.cSh = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cSg;
    }

    private boolean mA(String str) {
        return (this.cSf.isEmpty() || this.cSf.get(str) == null) ? false : true;
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
        return aoF() && this.cSh.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aog() {
        SwanAppConfigData azQ;
        com.baidu.swan.apps.v.f aAl = com.baidu.swan.apps.v.f.aAl();
        if (aAl == null || (azQ = aAl.azQ()) == null || !azQ.aJA() || this.cRF == null) {
            return false;
        }
        return azQ.rS(this.cRF.getPage());
    }

    public boolean apd() {
        if (this.cSi == null) {
            return false;
        }
        return this.cSi.apd();
    }

    protected final boolean ape() {
        SwanAppConfigData azQ;
        f afX = afX();
        if (afX == null) {
            return false;
        }
        if ((this.cSm != null && this.cSm.dFJ) || (azQ = com.baidu.swan.apps.v.f.aAl().azQ()) == null) {
            return false;
        }
        return a(afX, azQ) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c gL = fVar.gL(0);
        if (gL == null || !(gL instanceof e)) {
            return false;
        }
        String page = ((e) gL).apl().getPage();
        return swanAppConfigData.rS(page) || TextUtils.equals(swanAppConfigData.azU(), page);
    }

    private boolean apf() {
        SwanAppConfigData azQ = com.baidu.swan.apps.v.f.aAl().azQ();
        return (azQ == null || TextUtils.equals(azQ.azU(), this.cSe.getPage())) ? false : true;
    }

    public String apg() {
        return this.cSh != null ? this.cSh.aiY() : "";
    }

    public List<String> aph() {
        ArrayList arrayList = new ArrayList();
        if (this.cSf != null && !this.cSf.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cSf.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().aiY());
                }
            }
        }
        if (this.cSh != null) {
            String aiY = this.cSh.aiY();
            if (!arrayList.contains(aiY)) {
                arrayList.add(aiY);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        if ((afS() == null || !afS().aId()) && !com.baidu.k.a.adc()) {
            if (this.cSh != null) {
                if (com.baidu.swan.apps.media.b.pq(this.cSh.aiY())) {
                    return true;
                }
                return this.cSh.aiQ();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void ajx() {
        FragmentActivity bdU = bdU();
        if (this.cRJ == null) {
            this.cRJ = new SwanAppMenuHeaderView(getContext());
        }
        if (bdU != null && this.cRI == null) {
            this.cRI = new com.baidu.swan.menu.g(bdU, this.cRH, ajy(), com.baidu.swan.apps.t.a.axa(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cRI, this, this.cRJ).aCb();
            if (com.baidu.swan.apps.menu.fontsize.b.aCr()) {
                this.cRI.lD(50);
            }
        }
    }

    private int ajy() {
        return aoU() ? apf() ? 18 : 17 : apf() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> apj() {
        if (this.cSh == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cSh.aiW().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a apk() {
        return this.cSi;
    }

    public com.baidu.swan.apps.model.b apl() {
        return this.cSe;
    }

    public com.baidu.swan.apps.adaptation.b.c apm() {
        return this.cSh;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0453a
    public com.baidu.swan.apps.res.widget.floatlayer.a afS() {
        if (this.cCc == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.cCc = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aoP().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.cCc;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aoJ() {
        return this.cSm;
    }

    private boolean apn() {
        return this.cSm != null && this.cSm.dFG;
    }

    private boolean apo() {
        if (this.cSm == null) {
            return false;
        }
        return TextUtils.equals(this.cSm.dFI, "custom");
    }

    private void mB(String str) {
        if (!apo()) {
            com.baidu.swan.apps.v.f aAl = com.baidu.swan.apps.v.f.aAl();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aAl.pm(str).dFG && this.cSo == null) {
                this.cSo = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.5
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.gK(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cSo != null) {
                cVar.a(this.cSo);
            }
            cVar.a(app());
        }
    }

    private com.baidu.swan.apps.core.f.e app() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cSo);
                    fVar.a(e.this.apq());
                    com.baidu.swan.apps.y.f.aCU().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cSo);
                    com.baidu.swan.apps.y.f.aCU().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a apq() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.7
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iv(String str) {
                e.this.mv(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cSo != null && cVar != null) {
            cVar.b(this.cSo);
            if (cVar.aiP() != null) {
                cVar.b(this.cSo);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void apr() {
        int i;
        boolean z;
        int i2;
        com.baidu.swan.apps.adaptation.b.d dVar;
        if (this.cRH != null) {
            if (apo()) {
                fm(true);
                z = true;
                i2 = 1;
                i = 0;
            } else if (apn()) {
                fm(false);
                if (this.cSh != null) {
                    if (this.cSh.aiP() != null) {
                        dVar = this.cSh.aiP().aiW();
                    } else {
                        dVar = this.cSh.aiW();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cSm == null && this.cSm.dFH) {
                            z = true;
                            i2 = 0;
                        } else {
                            z = true;
                            i2 = 1;
                        }
                    }
                }
                i = 0;
                if (this.cSm == null) {
                }
                z = true;
                i2 = 1;
            } else {
                fm(false);
                i = cSc + this.cSn;
                z = false;
                i2 = 1;
            }
            TextView centerTitleView = this.cRH.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            gK(i);
            fn(z);
        }
    }

    private void fn(boolean z) {
        int i;
        int dimensionPixelSize;
        if (z) {
            if (this.cRN == null || !this.cRN.aOT()) {
                i = 0;
                dimensionPixelSize = 0;
            } else {
                i = ah.getStatusBarHeight();
                dimensionPixelSize = 0;
            }
        } else {
            i = 0;
            dimensionPixelSize = aoP().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cSg.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cSg.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cRG.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cRG.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(int i) {
        TextView centerTitleView;
        View aOS;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cSc) * 1.0f) / (this.cSn == 0 ? 1 : this.cSn);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cRN != null && this.cRN.aOT() && (aOS = this.cRN.aOS()) != null && (background = aOS.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cRH.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cSm != null && this.cSm.dFH && (centerTitleView = this.cRH.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cRL.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void aps() {
        this.cSd = com.baidu.swan.apps.statistic.h.sI("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cSd != null) {
            com.baidu.swan.apps.statistic.h.a(this.cSd, gVar);
            this.cSd = null;
        }
    }

    public void apt() {
        this.cSm.dFI = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
        aoK();
        apr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apu() {
        if (this.cRF != null) {
            this.cRF.apu();
        }
    }

    private void fo(boolean z) {
        if (com.baidu.swan.apps.x.a.gh(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cRH, com.baidu.swan.apps.runtime.e.aIL().aIO().azq().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aIL() != null) {
            com.baidu.swan.apps.x.a.a(this.cRH, com.baidu.swan.apps.runtime.e.aIL().aJc().c("key_unread_counts_message", 0).intValue());
        }
    }

    private void fp(boolean z) {
        if (com.baidu.swan.apps.x.a.gh(z)) {
            com.baidu.swan.apps.x.a.a(getContext(), this.cRI, com.baidu.swan.apps.runtime.e.aIL().aIO().azq().paNumber);
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        static int cSt = -1;

        static int apv() {
            if (cSt < 0) {
                cSt = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_app_fragment_destroy_switch", 1);
            }
            if (e.DEBUG) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + cSt);
            }
            return cSt;
        }

        static boolean apw() {
            return apv() > 0;
        }
    }
}
