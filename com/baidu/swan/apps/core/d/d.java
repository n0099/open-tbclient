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
import com.baidu.swan.apps.adaptation.a.aa;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.as.z;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.ubc.Flow;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class d extends b implements a.InterfaceC0283a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int bnI = af.S(149.0f);
    private static String bnP = "-1";
    private static String bnQ = bnP;
    private static String bnR;
    private com.baidu.swan.apps.res.widget.floatlayer.a baO;
    private Flow bnJ;
    private FrameLayout bnM;
    private com.baidu.swan.apps.adaptation.b.c bnN;
    private com.baidu.swan.apps.tabbar.b.a bnO;
    private com.baidu.swan.apps.runtime.config.c bnS;
    private com.baidu.swan.apps.core.f.c bnU;
    private aa bnV;
    private View mRootView;
    private com.baidu.swan.apps.model.b bnK = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> bnL = new TreeMap();
    private int bnT = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NS();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.bnV = com.baidu.swan.apps.w.a.UI();
                d.this.bnV.a(d.this.bnt, d.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.e.z("route", "fragment create.");
    }

    private void NS() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bnt = com.baidu.swan.apps.model.c.jw(arguments.getString("ai_apps_param"));
            this.bnK.mPage = this.bnt != null ? this.bnt.getPage() : "";
            this.bnK.mParams = this.bnt != null ? this.bnt.getParams() : "";
            this.bnS = com.baidu.swan.apps.y.f.WQ().iS(this.bnK.getPage());
            this.bnT = NI().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.z("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.bnM = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ae(inflate);
        this.bnO = new com.baidu.swan.apps.tabbar.b.a(this);
        ah(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.bnN.IA());
        com.baidu.swan.apps.ac.f.YM().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView IG() {
        if (this.bnN != null) {
            return this.bnN.IG();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        cq(NG());
        if (NV()) {
            NF();
        }
        Oh();
        this.bnv.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String IP = d.this.bnN.IP();
                com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
                fVar.mData = com.baidu.swan.apps.view.b.b.a.bw(IP, "scrollViewBackToTop");
                com.baidu.swan.apps.y.f.WQ().a(IP, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
        this.bnN.IJ();
        Jg();
        cu(true);
        this.bnw.i(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState(), NM());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void NE() {
        NO();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        com.baidu.swan.apps.model.c NQ = com.baidu.swan.apps.y.f.WQ().Om().NQ();
        if (NQ != null && !TextUtils.isEmpty(NQ.getPage())) {
            fVar.n("page", NQ.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.bnS)) {
            super.applyImmersion(i);
            return;
        }
        if (!Oe() && z.cF(this.mActivity)) {
            z = false;
        }
        p(i, z);
        Oh();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean et(int i) {
        boolean et = super.et(i);
        Oh();
        return et;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        Oh();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        ct(false);
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
        if (this.bnw != null && this.bnw.isShowing()) {
            this.bnw.eT(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.bnN.IP())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.bnN.IP())));
        }
    }

    public static void gV(String str) {
        bnR = str;
    }

    private void NT() {
        if (!TextUtils.equals(bnQ, this.bnN.IP()) || TextUtils.equals(bnR, "switchTab")) {
            int mx = this.bnO.mx(Oa().getPage());
            com.baidu.swan.apps.n.a.e eVar = new com.baidu.swan.apps.n.a.e();
            eVar.but = bnQ;
            eVar.buu = this.bnN.IP();
            eVar.boi = bnR;
            eVar.buv = this.bnK.mPage;
            eVar.buw = String.valueOf(mx);
            bnR = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.but + " ,toId: " + eVar.buu + " ,RouteType: " + eVar.boi + " page:" + eVar.buv + ",TabIndex: " + eVar.buw);
            }
            com.baidu.swan.apps.y.f.WQ().a(eVar);
            bnQ = this.bnN.IP();
        }
    }

    private void gW(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.bnN.IP());
        com.baidu.swan.apps.n.a.c cVar = new com.baidu.swan.apps.n.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.bnN.IP());
        }
        com.baidu.swan.apps.y.f.WQ().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void NP() {
        if (this.bnN == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.bnN.IP());
        com.baidu.swan.apps.adaptation.b.f IH = this.bnN.IH();
        if (IH != null) {
            hashMap.put("webViewUrl", IH.getCurrentPageUrl());
        }
        com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.b("sharebtn", hashMap));
    }

    private void ah(View view) {
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView start.");
        String Wy = this.bnt.Wy();
        String params = this.bnt.getParams();
        String page = this.bnt.getPage();
        String J = ai.J(Wy, page, params);
        this.bnN = com.baidu.swan.apps.core.slave.b.hs(J);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + J + " is load: " + (this.bnN != null));
        }
        if (this.bnN == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.bnN = o(Wy, page, params, "");
        }
        this.bnN.a(this.bnM, com.baidu.swan.apps.y.f.WQ().iS(page));
        ha(page);
        a(this.bnN);
        if (Nu()) {
            this.bnL.put(page, this.bnN);
            this.bnO.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.z("route", "createSlaveWebView end.");
        Oi();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.bnL != null && !this.bnL.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnL.values()) {
                if (cVar != null) {
                    cVar.IQ();
                }
            }
        } else if (this.bnN != null) {
            this.bnN.IQ();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bnL != null && !this.bnL.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.bnL.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.bnL.clear();
        } else if (this.bnN != null) {
            b(this.bnN);
            this.bnN.destroy();
        }
        this.bnN = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.J(com.baidu.swan.apps.y.f.WQ().WB());
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
                ct(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.bnN == null;
        String IP = z ? "" : this.bnN.IP();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + IP);
        }
        if (!z) {
            this.bnN.onResume();
            NT();
            gW("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.cS(true);
        if (com.baidu.swan.apps.console.c.Ls()) {
            com.baidu.swan.apps.core.c.b.Nl();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView IG;
        boolean z = this.bnN == null;
        String IP = z ? "" : this.bnN.IP();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + IP);
        }
        if (!z) {
            this.bnN.onPause();
            gW("onHide");
        }
        if (Gv() != null) {
            Gv().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.cS(false);
        if (!z && (IG = this.bnN.IG()) != null) {
            IG.du(false);
        }
    }

    public String gX(String str) {
        if (this.bnL.containsKey(str)) {
            return this.bnL.get(str).IP();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.bnO.mx(Oa().getPage()) != this.bnO.mx(bVar.mPage)) {
            this.bnO.mu(bVar.mPage);
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.bnL.get(bVar.mPage) == null) {
            String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c hs = com.baidu.swan.apps.core.slave.b.hs(J);
            if (hs != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + J);
                }
                this.bnL.put(bVar.mPage, hs);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                hs = o(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.bnL.put(bVar.mPage, hs);
            }
            ha(bVar.mPage);
            a(hs);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c o(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a K = com.baidu.swan.apps.core.slave.b.K(auy());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.f.aY("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bb("preload", K.brK ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + K);
        }
        com.baidu.swan.apps.core.slave.b.a(K, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.core.d.d.3
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                com.baidu.swan.apps.core.k.b bVar = new com.baidu.swan.apps.core.k.b();
                bVar.bsm = K.brJ.IL();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.g.a(K, str4);
                }
                bVar.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.bso = str2 + "?" + str3;
                } else {
                    bVar.bso = str2;
                }
                if (com.baidu.swan.apps.runtime.e.acE() != null) {
                    bVar.bsl = com.baidu.swan.apps.runtime.e.acE().kS(str2);
                }
                bVar.bsp = com.baidu.swan.apps.y.f.WQ().iS(str2).bsp;
                bVar.bsi = String.valueOf(com.baidu.swan.apps.console.a.Lp());
                if (com.baidu.swan.apps.runtime.e.acE() != null) {
                    String kU = com.baidu.swan.apps.runtime.e.acE().kU(str2);
                    if (!TextUtils.isEmpty(kU)) {
                        bVar.bsq = kU;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + kU);
                        }
                    }
                }
                bVar.bsk = d.DEBUG || com.baidu.swan.apps.y.f.WQ().Wv();
                if (com.baidu.swan.apps.ah.a.a.aaB()) {
                    bVar.bsn = com.baidu.swan.apps.console.debugger.b.Lw();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.bsr = str4;
                    com.baidu.swan.apps.performance.f.aY("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                y.agQ();
                com.baidu.swan.apps.y.f.WQ().a(K.brJ.IP(), com.baidu.swan.apps.core.k.b.b(bVar));
                com.baidu.swan.apps.statistic.c.bn(K.brJ.IP(), bVar.bso);
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return K.brJ;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        com.baidu.swan.apps.runtime.config.c iS = com.baidu.swan.apps.y.f.WQ().iS(TextUtils.isEmpty(str2) ? "" : str2);
        this.bnK.mPage = str2;
        this.bnK.mParams = bVar != null ? bVar.getParams() : "";
        this.bnS = iS;
        boolean z = false;
        if (gZ(str2)) {
            gY(str2);
        } else {
            z = true;
            a(bVar, str);
            gY(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.g.A(7, str);
            } else {
                com.baidu.swan.apps.performance.g.A(6, str);
            }
            com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.kc(str);
        }
        gT(iS.bQi);
        gU(iS.bQj);
        et(iS.bQh);
        Oh();
        Ok();
    }

    private void gY(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.bnL.get(str);
        if (this.bnN != cVar) {
            if (!cVar.IF()) {
                cVar.a(this.bnM, com.baidu.swan.apps.y.f.WQ().iS(str));
            }
            cVar.dV(0);
            if (this.bnN != null) {
                this.bnN.dV(8);
            }
            this.bnN = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.bnM;
    }

    private boolean gZ(String str) {
        return (this.bnL.isEmpty() || this.bnL.get(str) == null) ? false : true;
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
        return NG() && this.bnN.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        SwanAppConfigData Ww;
        com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
        if (WQ == null || (Ww = WQ.Ww()) == null || !Ww.ads() || this.bnt == null) {
            return false;
        }
        return Ww.ld(this.bnt.getPage());
    }

    public boolean NU() {
        if (this.bnO == null) {
            return false;
        }
        return this.bnO.NU();
    }

    protected final boolean NV() {
        SwanAppConfigData Ww;
        e GA = GA();
        if (GA == null) {
            return false;
        }
        return ((this.bnS != null && this.bnS.bQp) || (Ww = com.baidu.swan.apps.y.f.WQ().Ww()) == null || a(GA, Ww)) ? false : true;
    }

    private boolean a(e eVar, SwanAppConfigData swanAppConfigData) {
        b ew = eVar.ew(0);
        if (ew == null || !(ew instanceof d)) {
            return false;
        }
        String page = ((d) ew).Oa().getPage();
        return swanAppConfigData.ld(page) || TextUtils.equals(swanAppConfigData.WA(), page);
    }

    private boolean NW() {
        SwanAppConfigData Ww = com.baidu.swan.apps.y.f.WQ().Ww();
        return (Ww == null || TextUtils.equals(Ww.WA(), this.bnK.getPage())) ? false : true;
    }

    public String NX() {
        return this.bnN != null ? this.bnN.IP() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        if (com.baidu.j.a.Eq()) {
            return true;
        }
        if (this.bnN != null) {
            if (com.baidu.swan.apps.media.b.iV(this.bnN.IP())) {
                return true;
            }
            return this.bnN.II();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Jg() {
        FragmentActivity auy = auy();
        if (auy != null && this.bnw == null) {
            this.bnw = new com.baidu.swan.menu.h(auy, this.bnv, Jh(), com.baidu.swan.apps.w.a.TY(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnw, this).Yi();
        }
    }

    private int Jh() {
        return NN() ? NW() ? 18 : 17 : NW() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> NY() {
        if (this.bnN == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.bnN.IN().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a NZ() {
        return this.bnO;
    }

    public com.baidu.swan.apps.model.b Oa() {
        return this.bnK;
    }

    public com.baidu.swan.apps.adaptation.b.c Ob() {
        return this.bnN;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    public com.baidu.swan.apps.res.widget.floatlayer.a Gv() {
        if (this.baO == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.baO = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), NI().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.baO;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.runtime.config.c NH() {
        return this.bnS;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Oc() {
        return this.bnA;
    }

    private boolean Od() {
        return this.bnS != null && this.bnS.bQm;
    }

    private boolean Oe() {
        if (this.bnS == null) {
            return false;
        }
        return TextUtils.equals(this.bnS.bQo, "custom");
    }

    private void ha(String str) {
        if (!Oe()) {
            com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (WQ.iS(str).bQm && this.bnU == null) {
                this.bnU = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.d.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.ev(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.bnU != null) {
                cVar.a(this.bnU);
            }
            cVar.a(Of());
        }
    }

    private com.baidu.swan.apps.core.f.e Of() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.bnU);
                    fVar.a(d.this.Og());
                    com.baidu.swan.apps.ac.f.YM().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.bnU);
                    com.baidu.swan.apps.ac.f.YM().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Og() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void en(String str) {
                d.this.gT(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.bnU != null && cVar != null) {
            cVar.b(this.bnU);
            if (cVar.IH() != null) {
                cVar.b(this.bnU);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Oh() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.bnv != null) {
            if (Oe()) {
                cr(true);
                i = 0;
                z = true;
            } else if (Od()) {
                cr(false);
                if (this.bnN != null) {
                    if (this.bnN.IH() != null) {
                        dVar = this.bnN.IH().IN();
                    } else {
                        dVar = this.bnN.IN();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.bnS == null && this.bnS.bQn) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.bnS == null) {
                }
                z = true;
            } else {
                cr(false);
                i = bnI + this.bnT;
            }
            TextView centerTitleView = this.bnv.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ev(i);
            cs(z);
        }
    }

    private void cs(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.bnA == null || !this.bnA.ahu()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = af.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = NI().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bnM.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.bnM.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bnu.getLayoutParams();
        layoutParams2.topMargin = i;
        this.bnu.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        TextView centerTitleView;
        View aht;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - bnI) * 1.0f) / (this.bnT == 0 ? 1 : this.bnT);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.bnA != null && this.bnA.ahu() && (aht = this.bnA.aht()) != null && (background = aht.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.bnv.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.bnS != null && this.bnS.bQn && (centerTitleView = this.bnv.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.bny.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Oi() {
        this.bnJ = com.baidu.swan.apps.statistic.f.lH("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.bnJ != null) {
            com.baidu.swan.apps.statistic.f.a(this.bnJ, gVar);
            this.bnJ = null;
        }
    }

    public void Oj() {
        this.bnS.bQo = "default";
        applyImmersion();
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ok() {
        if (this.bnt != null) {
            this.bnt.Ok();
        }
    }

    private void ct(boolean z) {
        if (com.baidu.swan.apps.ab.a.cZ(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bnv, com.baidu.swan.apps.runtime.e.acE().acG().VX().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.acE() != null) {
            com.baidu.swan.apps.ab.a.a(this.bnv, com.baidu.swan.apps.runtime.e.acE().acT().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void cu(boolean z) {
        if (com.baidu.swan.apps.ab.a.cZ(z)) {
            com.baidu.swan.apps.ab.a.a(getContext(), this.bnw, com.baidu.swan.apps.runtime.e.acE().acG().VX().paNumber);
        }
    }
}
