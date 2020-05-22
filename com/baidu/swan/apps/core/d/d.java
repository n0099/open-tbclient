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
import com.baidu.swan.apps.adaptation.a.ac;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class d extends b implements a.InterfaceC0377a {
    private static String bVA;
    private com.baidu.swan.apps.res.widget.floatlayer.a bGZ;
    private com.baidu.swan.apps.runtime.config.c bVB;
    private com.baidu.swan.apps.core.f.c bVD;
    private ac bVE;
    private com.baidu.swan.apps.statistic.a bVs;
    private FrameLayout bVv;
    private com.baidu.swan.apps.adaptation.b.c bVw;
    private com.baidu.swan.apps.tabbar.b.a bVx;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bVr = ag.B(149.0f);
    private static String bVy = "-1";
    private static String bVz = bVy;
    private com.baidu.swan.apps.model.b bVt = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bVu = new TreeMap();
    private int bVC = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Yw();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bVE = com.baidu.swan.apps.u.a.afE();
                d.this.bVE.a(d.this.bUY, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.f.D("route", "fragment create.");
    }

    private void Yw() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bUY = com.baidu.swan.apps.model.c.lW(arguments.getString("ai_apps_param"));
            this.bVt.mPage = this.bUY != null ? this.bUY.getPage() : "";
            this.bVt.mParams = this.bUY != null ? this.bUY.getParams() : "";
            this.bVt.coT = j.oh(this.bVt.getPage());
            this.bVB = com.baidu.swan.apps.w.f.ahV().lq(this.bVt.ajR());
            if (this.bVB.cBn) {
                this.bVB = com.baidu.swan.apps.w.f.ahV().lr(this.bVt.getPage());
            }
            this.bVC = Yl().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.f.D("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.bVv = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bVx = new com.baidu.swan.apps.tabbar.b.a(this);
        ai(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bVw.SU());
        com.baidu.swan.apps.aa.f.akp().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Ta() {
        if (this.bVw != null) {
            return this.bVw.Ta();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        dC(Yg());
        if (Yz()) {
            Yf();
        }
        YL();
        this.bVa.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String Tj = d.this.bVw.Tj();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cc(Tj, "scrollViewBackToTop");
                com.baidu.swan.apps.w.f.ahV().a(Tj, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
        this.bVw.Td();
        TC();
        dG(true);
        this.bVb.n(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState(), Yp());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Yd() {
        Yr();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
        com.baidu.swan.apps.model.c Yt = YQ == null ? null : YQ.Yt();
        if (Yt != null && !TextUtils.isEmpty(Yt.getPage())) {
            fVar.v("page", Yt.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bVB)) {
            super.applyImmersion(i);
            return;
        }
        if (!YI() && aa.cs(this.mActivity)) {
            z = false;
        }
        u(i, z);
        YL();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean eH(int i) {
        boolean eH = super.eH(i);
        YL();
        return eH;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        YL();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dF(false);
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
        if (this.bVb != null && this.bVb.isShowing()) {
            this.bVb.gc(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bVw.Tj())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bVw.Tj())));
        }
    }

    public static void jj(String str) {
        bVA = str;
    }

    private void Yx() {
        if (!TextUtils.equals(bVz, this.bVw.Tj()) || TextUtils.equals(bVA, "switchTab")) {
            int pq = this.bVx.pq(YF().ajR());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.ccL = bVz;
            eVar.ccM = this.bVw.Tj();
            eVar.bVR = bVA;
            eVar.ccN = this.bVt.mPage;
            eVar.ccO = String.valueOf(pq);
            bVA = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.ccL + " ,toId: " + eVar.ccM + " ,RouteType: " + eVar.bVR + " page:" + eVar.ccN + ",TabIndex: " + eVar.ccO);
            }
            com.baidu.swan.apps.w.f.ahV().a(eVar);
            bVz = this.bVw.Tj();
        }
    }

    private void jk(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bVw.Tj());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bVw.Tj());
        }
        com.baidu.swan.apps.w.f.ahV().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void Ys() {
        if (this.bVw == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bVw.Tj());
        com.baidu.swan.apps.adaptation.b.f Tb = this.bVw.Tb();
        if (Tb != null) {
            hashMap.put("webViewUrl", Tb.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void ai(View view) {
        com.baidu.swan.apps.performance.f.D("route", "createSlaveWebView start.");
        String ahC = this.bUY.ahC();
        String params = this.bUY.getParams();
        String page = this.bUY.getPage();
        String M = aj.M(ahC, page, params);
        this.bVw = com.baidu.swan.apps.core.slave.b.jL(M);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + M + " is load: " + (this.bVw != null));
        }
        if (this.bVw == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bVw = p(ahC, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c lq = com.baidu.swan.apps.w.f.ahV().lq(page);
        this.bVw.b(this.bVv, lq);
        this.bVw.a(this.bVv, lq);
        jo(page);
        a(this.bVw);
        if (XQ()) {
            this.bVu.put(page, this.bVw);
            this.bVx.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.f.D("route", "createSlaveWebView end.");
        YM();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bVu != null && !this.bVu.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bVu.values()) {
                if (cVar != null) {
                    cVar.Tk();
                }
            }
        } else if (this.bVw != null) {
            this.bVw.Tk();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bVu != null && !this.bVu.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bVu.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bVu.clear();
        } else if (this.bVw != null) {
            b(this.bVw);
            this.bVw.destroy();
        }
        this.bVw = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.bJ(com.baidu.swan.apps.w.f.ahV().ahF());
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded()) {
            super.setUserVisibleHint(z);
            if (DEBUG) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                dF(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bVw == null;
        String Tj = z ? "" : this.bVw.Tj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + Tj);
        }
        if (!z) {
            dC(Yg());
            this.bVw.onResume();
            Yx();
            jk("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.eg(true);
        if (com.baidu.swan.apps.console.c.VR()) {
            com.baidu.swan.apps.core.c.b.XI();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Ta;
        boolean z = this.bVw == null;
        String Tj = z ? "" : this.bVw.Tj();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + Tj);
        }
        if (!z) {
            this.bVw.onPause();
            jk("onHide");
        }
        if (QC() != null) {
            QC().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.eg(false);
        if (!z && (Ta = this.bVw.Ta()) != null) {
            Ta.eK(false);
        }
    }

    public String jl(String str) {
        if (this.bVu.containsKey(str)) {
            return this.bVu.get(str).Tj();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bVx.pq(YF().ajR()) != this.bVx.pq(bVar.ajR())) {
            this.bVx.pn(bVar.ajR());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bVu.get(bVar.coT) == null) {
            String M = aj.M(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c jL = com.baidu.swan.apps.core.slave.b.jL(M);
            if (jL != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + M);
                }
                this.bVu.put(bVar.mPage, jL);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                jL = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bVu.put(bVar.mPage, jL);
            }
            jo(bVar.mPage);
            a(jL);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(aHv());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.g.bA("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bD("preload", F.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + F);
        }
        com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0346b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0346b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cax = F.bZV.Tf();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.h.a(F, str4);
                }
                String oh = j.oh(str2);
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.caz = str2 + "?" + str3;
                } else {
                    bVar.caz = str2;
                }
                if (com.baidu.swan.apps.runtime.e.aoG() != null) {
                    bVar.caw = com.baidu.swan.apps.runtime.e.aoG().nz(oh);
                }
                bVar.cau = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aoF(), bVar.caz);
                bVar.caA = com.baidu.swan.apps.w.f.ahV().lq(oh).caA;
                bVar.cat = String.valueOf(com.baidu.swan.apps.console.a.VO());
                if (com.baidu.swan.apps.runtime.e.aoG() != null) {
                    String nB = com.baidu.swan.apps.runtime.e.aoG().nB(oh);
                    if (!TextUtils.isEmpty(nB)) {
                        bVar.caB = nB;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + nB);
                        }
                    }
                }
                bVar.cav = d.DEBUG || com.baidu.swan.apps.w.f.ahV().ahz();
                if (com.baidu.swan.apps.af.a.a.amr()) {
                    bVar.cay = com.baidu.swan.apps.console.debugger.b.VV();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.caC = str4;
                    com.baidu.swan.apps.performance.g.bA("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                z.atC();
                com.baidu.swan.apps.w.f.ahV().a(F.bZV.Tj(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.bR(F.bZV.Tj(), bVar.caz);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return F.bZV;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.coT;
        com.baidu.swan.apps.runtime.config.c lq = com.baidu.swan.apps.w.f.ahV().lq(TextUtils.isEmpty(str3) ? "" : str3);
        this.bVt.mPage = str2;
        this.bVt.mParams = bVar != null ? bVar.getParams() : "";
        this.bVt.coT = str3;
        this.bVB = lq;
        boolean z = false;
        if (jn(str3)) {
            jm(str3);
        } else {
            z = true;
            a(bVar, str);
            jm(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.h.S(7, str);
            } else {
                com.baidu.swan.apps.performance.h.S(6, str);
            }
            com.baidu.swan.apps.performance.g.bA("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.h.mD(str);
        }
        ji(lq.cBd);
        eI(SwanAppConfigData.dT(lq.cBe));
        eH(lq.cBc);
        YL();
        YO();
    }

    private void jm(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bVu.get(str);
        if (this.bVw != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c lq = com.baidu.swan.apps.w.f.ahV().lq(str);
            cVar.b(this.bVv, lq);
            if (!cVar.SZ()) {
                cVar.a(this.bVv, lq);
            }
            cVar.eg(0);
            if (this.bVw != null) {
                this.bVw.eg(8);
            }
            this.bVw = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bVv;
    }

    private boolean jn(String str) {
        return (this.bVu.isEmpty() || this.bVu.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.toJSONString());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return Yg() && this.bVw.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        SwanAppConfigData ahA;
        com.baidu.swan.apps.w.f ahV = com.baidu.swan.apps.w.f.ahV();
        if (ahV == null || (ahA = ahV.ahA()) == null || !ahA.apy() || this.bUY == null) {
            return false;
        }
        return ahA.nL(this.bUY.getPage());
    }

    public boolean Yy() {
        if (this.bVx == null) {
            return false;
        }
        return this.bVx.Yy();
    }

    protected final boolean Yz() {
        SwanAppConfigData ahA;
        e QH = QH();
        if (QH == null) {
            return false;
        }
        return ((this.bVB != null && this.bVB.cBk) || (ahA = com.baidu.swan.apps.w.f.ahV().ahA()) == null || a(QH, ahA)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b eK = eVar.eK(0);
        if (eK == null || !(eK instanceof d)) {
            return false;
        }
        String page = ((d) eK).YF().getPage();
        return swanAppConfigData.nL(page) || TextUtils.equals(swanAppConfigData.ahE(), page);
    }

    private boolean YA() {
        SwanAppConfigData ahA = com.baidu.swan.apps.w.f.ahV().ahA();
        return (ahA == null || TextUtils.equals(ahA.ahE(), this.bVt.getPage())) ? false : true;
    }

    public String YB() {
        return this.bVw != null ? this.bVw.Tj() : "";
    }

    public List<String> YC() {
        ArrayList arrayList = new ArrayList();
        if (this.bVu != null && !this.bVu.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.bVu.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().Tj());
                }
            }
        }
        if (this.bVw != null) {
            String Tj = this.bVw.Tj();
            if (!arrayList.contains(Tj)) {
                arrayList.add(Tj);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        if (com.baidu.g.a.MD()) {
            return true;
        }
        if (this.bVw != null) {
            if (com.baidu.swan.apps.media.b.lu(this.bVw.Tj())) {
                return true;
            }
            return this.bVw.Tc();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void TC() {
        FragmentActivity aHv = aHv();
        if (aHv != null && this.bVb == null) {
            this.bVb = new com.baidu.swan.menu.h(aHv, this.bVa, TD(), com.baidu.swan.apps.u.a.aeV(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bVb, this).ajG();
        }
    }

    private int TD() {
        return Yq() ? YA() ? 18 : 17 : YA() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> YD() {
        if (this.bVw == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bVw.Th().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a YE() {
        return this.bVx;
    }

    public com.baidu.swan.apps.model.b YF() {
        return this.bVt;
    }

    public com.baidu.swan.apps.adaptation.b.c YG() {
        return this.bVw;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0377a
    public com.baidu.swan.apps.res.widget.floatlayer.a QC() {
        if (this.bGZ == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bGZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), Yl().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bGZ;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c Yh() {
        return this.bVB;
    }

    private boolean YH() {
        return this.bVB != null && this.bVB.cBh;
    }

    private boolean YI() {
        if (this.bVB == null) {
            return false;
        }
        return TextUtils.equals(this.bVB.cBj, "custom");
    }

    private void jo(String str) {
        if (!YI()) {
            com.baidu.swan.apps.w.f ahV = com.baidu.swan.apps.w.f.ahV();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (ahV.lq(str).cBh && this.bVD == null) {
                this.bVD = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.eJ(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.bVD != null) {
                cVar.a(this.bVD);
            }
            cVar.a(YJ());
        }
    }

    private com.baidu.swan.apps.core.f.e YJ() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bVD);
                    fVar.a(d.this.YK());
                    com.baidu.swan.apps.aa.f.akp().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bVD);
                    com.baidu.swan.apps.aa.f.akp().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a YK() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fR(String str) {
                d.this.ji(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bVD != null && cVar != null) {
            cVar.b(this.bVD);
            if (cVar.Tb() != null) {
                cVar.b(this.bVD);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void YL() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bVa != null) {
            if (YI()) {
                dD(true);
                i = 0;
                z = true;
            } else if (YH()) {
                dD(false);
                if (this.bVw != null) {
                    if (this.bVw.Tb() != null) {
                        dVar = this.bVw.Tb().Th();
                    } else {
                        dVar = this.bVw.Th();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bVB == null && this.bVB.cBi) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bVB == null) {
                }
                z = true;
            } else {
                dD(false);
                i = bVr + this.bVC;
            }
            TextView centerTitleView = this.bVa.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            eJ(i);
            dE(z);
        }
    }

    private void dE(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bVf == null || !this.bVf.aun()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ag.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = Yl().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bVv.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bVv.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bUZ.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bUZ.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        TextView centerTitleView;
        View aum;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bVr) * 1.0f) / (this.bVC == 0 ? 1 : this.bVC);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bVf != null && this.bVf.aun() && (aum = this.bVf.aum()) != null && (background = aum.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bVa.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bVB != null && this.bVB.cBi && (centerTitleView = this.bVa.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bVd.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void YM() {
        this.bVs = com.baidu.swan.apps.statistic.h.ow("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bVs != null) {
            com.baidu.swan.apps.statistic.h.a(this.bVs, gVar);
            this.bVs = null;
        }
    }

    public void YN() {
        this.bVB.cBj = "default";
        applyImmersion();
        YL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void YO() {
        if (this.bUY != null) {
            this.bUY.YO();
        }
    }

    private void dF(boolean z) {
        if (com.baidu.swan.apps.z.a.en(z)) {
            com.baidu.swan.apps.z.a.a(getContext(), this.bVa, com.baidu.swan.apps.runtime.e.aoG().aoJ().aha().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.aoG() != null) {
            com.baidu.swan.apps.z.a.a(this.bVa, com.baidu.swan.apps.runtime.e.aoG().aoX().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dG(boolean z) {
        if (com.baidu.swan.apps.z.a.en(z)) {
            com.baidu.swan.apps.z.a.a(getContext(), this.bVb, com.baidu.swan.apps.runtime.e.aoG().aoJ().aha().paNumber);
        }
    }
}
