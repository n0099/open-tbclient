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
import com.baidu.swan.apps.adaptation.a.ad;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ab;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
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
/* loaded from: classes7.dex */
public class e extends c implements a.InterfaceC0386a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int cbN = ai.D(149.0f);
    private static String cbU = "-1";
    private static String cbV = cbU;
    private static String cbW;
    private com.baidu.swan.apps.res.widget.floatlayer.a bMj;
    private com.baidu.swan.apps.statistic.a cbO;
    private FrameLayout cbR;
    private com.baidu.swan.apps.adaptation.b.c cbS;
    private com.baidu.swan.apps.tabbar.b.a cbT;
    private com.baidu.swan.apps.runtime.config.c cbX;
    private com.baidu.swan.apps.core.f.c cbZ;
    private ad cca;
    private View mRootView;
    private com.baidu.swan.apps.model.b cbP = new com.baidu.swan.apps.model.b();
    private Map<String, com.baidu.swan.apps.adaptation.b.c> cbQ = new TreeMap();
    private int cbY = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aaG();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.cca = com.baidu.swan.apps.t.a.ahX();
                e.this.cca.a(e.this.cbr, e.this.getContext());
            }
        }, "SwanAppPageHistory");
        com.baidu.swan.apps.performance.h.C("route", "fragment create.");
    }

    private void aaG() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cbr = com.baidu.swan.apps.model.c.mC(arguments.getString("ai_apps_param"));
            this.cbP.mPage = this.cbr != null ? this.cbr.getPage() : "";
            this.cbP.mParams = this.cbr != null ? this.cbr.getParams() : "";
            this.cbP.cvJ = com.baidu.swan.apps.scheme.actions.k.j.oZ(this.cbP.getPage());
            this.cbX = com.baidu.swan.apps.v.f.akr().lZ(this.cbP.amo());
            if (this.cbX.cIP) {
                this.cbX = com.baidu.swan.apps.v.f.akr().ma(this.cbP.getPage());
            }
            this.cbY = aav().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.h.C("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.cbR = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        ah(inflate);
        this.cbT = new com.baidu.swan.apps.tabbar.b.a(this);
        al(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        this.mSlideHelper.setRegionFactor(this.cbS.UB());
        com.baidu.swan.apps.z.f.amM().start();
        return this.mRootView;
    }

    public PullToRefreshBaseWebView UH() {
        if (this.cbS != null) {
            return this.cbS.UH();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        super.ah(view);
        dL(aaq());
        if (aaJ()) {
            aap();
        }
        aaV();
        this.cbt.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.e.2
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void onDoubleClick(View view2) {
                String UR = e.this.cbS.UR();
                com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
                gVar.mData = com.baidu.swan.apps.view.b.b.a.cf(UR, "scrollViewBackToTop");
                com.baidu.swan.apps.v.f.akr().a(UR, gVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
        this.cbS.UK();
        Vn();
        dP(true);
        this.cbu.a(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), aaz(), this.cbv, false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aan() {
        aaB();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        e aba = com.baidu.swan.apps.v.f.akr().aba();
        com.baidu.swan.apps.model.c aaC = aba == null ? null : aba.aaC();
        if (aaC != null && !TextUtils.isEmpty(aaC.getPage())) {
            fVar.v("page", aaC.getPage());
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void applyImmersion(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.runtime.config.c.a(this.cbX)) {
            super.applyImmersion(i);
            return;
        }
        if (!aaS() && ab.cv(this.mActivity)) {
            z = false;
        }
        u(i, z);
        aaV();
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean eZ(int i) {
        boolean eZ = super.eZ(i);
        aaV();
        return eZ;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        aaV();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        performResume();
        dO(false);
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
        if (this.cbu != null && this.cbu.isShowing()) {
            this.cbu.gD(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.cbS.UR())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.cbS.UR())));
        }
    }

    public static void jI(String str) {
        cbW = str;
    }

    private void aaH() {
        if (!TextUtils.equals(cbV, this.cbS.UR()) || TextUtils.equals(cbW, "switchTab")) {
            int qj = this.cbT.qj(aaP().amo());
            com.baidu.swan.apps.event.a.e eVar = new com.baidu.swan.apps.event.a.e();
            eVar.cjy = cbV;
            eVar.cjz = this.cbS.UR();
            eVar.ccm = cbW;
            eVar.cjA = this.cbP.mPage;
            eVar.cjB = String.valueOf(qj);
            cbW = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.cjy + " ,toId: " + eVar.cjz + " ,RouteType: " + eVar.ccm + " page:" + eVar.cjA + ",TabIndex: " + eVar.cjB);
            }
            com.baidu.swan.apps.v.f.akr().a(eVar);
            cbV = this.cbS.UR();
        }
    }

    private void jJ(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.cbS.UR());
        com.baidu.swan.apps.event.a.c cVar = new com.baidu.swan.apps.event.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.cbS.UR());
        }
        com.baidu.swan.apps.v.f.akr().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ZU() {
        if (this.cbS == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.cbS.UR());
        com.baidu.swan.apps.adaptation.b.f UI = this.cbS.UI();
        if (UI != null) {
            hashMap.put("webViewUrl", UI.getCurrentPageUrl());
        }
        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
    }

    private void al(View view) {
        com.baidu.swan.apps.performance.h.C("route", "createSlaveWebView start.");
        String ajY = this.cbr.ajY();
        String params = this.cbr.getParams();
        String page = this.cbr.getPage();
        String N = al.N(ajY, page, params);
        this.cbS = com.baidu.swan.apps.core.slave.b.km(N);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + N + " is load: " + (this.cbS != null));
        }
        if (this.cbS == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.cbS = p(ajY, page, params, "");
        }
        com.baidu.swan.apps.runtime.config.c lZ = com.baidu.swan.apps.v.f.akr().lZ(page);
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "create slave webview: " + page);
        this.cbS.b(this.cbR, lZ);
        this.cbS.a(this.cbR, lZ);
        jN(page);
        a(this.cbS);
        if (ZR()) {
            this.cbQ.put(page, this.cbS);
            this.cbT.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.h.C("route", "createSlaveWebView end.");
        aaW();
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.cbQ != null && !this.cbQ.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cbQ.values()) {
                if (cVar != null) {
                    cVar.US();
                }
            }
        } else if (this.cbS != null) {
            this.cbS.US();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cbQ != null && !this.cbQ.isEmpty()) {
            for (com.baidu.swan.apps.adaptation.b.c cVar : this.cbQ.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.cbQ.clear();
        } else if (this.cbS != null) {
            b(this.cbS);
            this.cbS.destroy();
        }
        this.cbS = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.slave.b.bN(com.baidu.swan.apps.v.f.akr().akb());
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
                dO(false);
                return;
            }
            pause();
        }
    }

    public void resume() {
        boolean z = this.cbS == null;
        String UR = z ? "" : this.cbS.UR();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + UR);
        }
        if (!z) {
            dL(aaq());
            this.cbS.onResume();
            aaH();
            jJ("onShow");
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.et(true);
        if (com.baidu.swan.apps.console.c.XD()) {
            com.baidu.swan.apps.core.c.b.ZG();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView UH;
        boolean z = this.cbS == null;
        String UR = z ? "" : this.cbS.UR();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + UR);
        }
        if (!z) {
            this.cbS.onPause();
            jJ("onHide");
        }
        if (RX() != null) {
            RX().reset();
        }
        com.baidu.swan.apps.console.c.i("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.et(false);
        if (!z && (UH = this.cbS.UH()) != null) {
            UH.eY(false);
        }
    }

    public String jK(String str) {
        if (this.cbQ.containsKey(str)) {
            return this.cbQ.get(str).UR();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.cbT.qj(aaP().amo()) != this.cbT.qj(bVar.amo())) {
            this.cbT.qg(bVar.amo());
            onPause();
            b(bVar, "");
        }
    }

    private void a(com.baidu.swan.apps.model.b bVar, String str) {
        if (this.cbQ.get(bVar.cvJ) == null) {
            String N = al.N(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
            com.baidu.swan.apps.adaptation.b.c km = com.baidu.swan.apps.core.slave.b.km(N);
            if (km != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + N);
                }
                this.cbQ.put(bVar.mPage, km);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                km = p(bVar.mBaseUrl, bVar.mPage, bVar.mParams, str);
                this.cbQ.put(bVar.mPage, km);
            }
            jN(bVar.mPage);
            a(km);
        }
    }

    private com.baidu.swan.apps.adaptation.b.c p(final String str, final String str2, final String str3, final String str4) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a E = com.baidu.swan.apps.core.slave.b.E(aMt());
        if (!TextUtils.isEmpty(str4)) {
            com.baidu.swan.apps.performance.i.bE("route", str4).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", E.isReady ? "1" : "0");
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + E);
        }
        com.baidu.swan.apps.core.slave.b.a(E, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.core.d.e.3
            /* JADX WARN: Type inference failed for: r0v31, types: [com.baidu.swan.apps.adaptation.b.d] */
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
            public void onReady() {
                com.baidu.swan.apps.core.turbo.b bVar = new com.baidu.swan.apps.core.turbo.b();
                bVar.cgW = E.cgw.UM();
                if (!TextUtils.isEmpty(str4)) {
                    com.baidu.swan.apps.performance.j.a(E, str4);
                }
                String oZ = com.baidu.swan.apps.scheme.actions.k.j.oZ(str2);
                bVar.appPath = str;
                bVar.cgY = TextUtils.isEmpty(str3) ? str2 : str2 + "?" + str3;
                if (com.baidu.swan.apps.runtime.e.arw() != null) {
                    bVar.pageType = com.baidu.swan.apps.runtime.e.arw().op(oZ);
                    bVar.cha = com.baidu.swan.apps.runtime.e.arw().or(oZ);
                }
                bVar.cgU = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.arv(), bVar.cgY);
                bVar.cgZ = com.baidu.swan.apps.v.f.akr().lZ(oZ).cgZ;
                bVar.cgT = String.valueOf(com.baidu.swan.apps.console.a.XA());
                bVar.cgV = e.DEBUG || com.baidu.swan.apps.v.f.akr().ajV();
                if (com.baidu.swan.apps.ae.a.a.apg()) {
                    bVar.cgX = com.baidu.swan.apps.console.debugger.b.XH();
                }
                if (!TextUtils.isEmpty(str4)) {
                    bVar.chb = str4;
                    com.baidu.swan.apps.performance.i.bE("route", str4).f(new UbcFlowEvent("slave_dispatch_start"));
                }
                aa.awK();
                E.cgw.UP().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, str2);
                E.cgw.ho(bVar.cgY);
                com.baidu.swan.apps.v.f.akr().a(E.cgw.UR(), com.baidu.swan.apps.core.turbo.b.b(bVar));
                com.baidu.swan.apps.statistic.e.bU(E.cgw.UR(), bVar.cgY);
                if (e.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return E.cgw;
    }

    public void b(com.baidu.swan.apps.model.b bVar, String str) {
        String str2 = bVar.mPage;
        String str3 = bVar.cvJ;
        com.baidu.swan.apps.runtime.config.c lZ = com.baidu.swan.apps.v.f.akr().lZ(TextUtils.isEmpty(str3) ? "" : str3);
        this.cbP.mPage = str2;
        this.cbP.mParams = bVar != null ? bVar.getParams() : "";
        this.cbP.cvJ = str3;
        this.cbX = lZ;
        boolean z = false;
        if (jM(str3)) {
            jL(str3);
        } else {
            z = true;
            a(bVar, str);
            jL(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                com.baidu.swan.apps.performance.j.U(7, str);
            } else {
                com.baidu.swan.apps.performance.j.U(6, str);
            }
            com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.j.nn(str);
        }
        jH(lZ.cIF);
        fa(SwanAppConfigData.dU(lZ.cIG));
        eZ(lZ.cIE);
        aaV();
        aaY();
        com.baidu.swan.apps.console.c.i("SwanAppFragment", "switch tab title: " + lZ.cIF + " page:" + str2);
    }

    private void jL(String str) {
        com.baidu.swan.apps.adaptation.b.c cVar = this.cbQ.get(str);
        if (this.cbS != cVar && cVar != null) {
            com.baidu.swan.apps.runtime.config.c lZ = com.baidu.swan.apps.v.f.akr().lZ(str);
            cVar.b(this.cbR, lZ);
            if (!cVar.UG()) {
                cVar.a(this.cbR, lZ);
            }
            cVar.ev(0);
            if (this.cbS != null) {
                this.cbS.ev(8);
            }
            this.cbS = cVar;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.cbR;
    }

    private boolean jM(String str) {
        return (this.cbQ.isEmpty() || this.cbQ.get(str) == null) ? false : true;
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
        return aaq() && this.cbS.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        SwanAppConfigData ajW;
        com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        if (akr == null || (ajW = akr.ajW()) == null || !ajW.asl() || this.cbr == null) {
            return false;
        }
        return ajW.oB(this.cbr.getPage());
    }

    public boolean aaI() {
        if (this.cbT == null) {
            return false;
        }
        return this.cbT.aaI();
    }

    protected final boolean aaJ() {
        SwanAppConfigData ajW;
        f Sc = Sc();
        if (Sc == null) {
            return false;
        }
        if ((this.cbX != null && this.cbX.cIM) || (ajW = com.baidu.swan.apps.v.f.akr().ajW()) == null) {
            return false;
        }
        return a(Sc, ajW) ? false : true;
    }

    private boolean a(f fVar, SwanAppConfigData swanAppConfigData) {
        c fc = fVar.fc(0);
        if (fc == null || !(fc instanceof e)) {
            return false;
        }
        String page = ((e) fc).aaP().getPage();
        return swanAppConfigData.oB(page) || TextUtils.equals(swanAppConfigData.aka(), page);
    }

    private boolean aaK() {
        SwanAppConfigData ajW = com.baidu.swan.apps.v.f.akr().ajW();
        return (ajW == null || TextUtils.equals(ajW.aka(), this.cbP.getPage())) ? false : true;
    }

    public String aaL() {
        return this.cbS != null ? this.cbS.UR() : "";
    }

    public List<String> aaM() {
        ArrayList arrayList = new ArrayList();
        if (this.cbQ != null && !this.cbQ.isEmpty()) {
            for (Map.Entry<String, com.baidu.swan.apps.adaptation.b.c> entry : this.cbQ.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().UR());
                }
            }
        }
        if (this.cbS != null) {
            String UR = this.cbS.UR();
            if (!arrayList.contains(UR)) {
                arrayList.add(UR);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        if (com.baidu.h.a.NS()) {
            return true;
        }
        if (this.cbS != null) {
            if (com.baidu.swan.apps.media.b.md(this.cbS.UR())) {
                return true;
            }
            return this.cbS.UJ();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    @DebugTrace
    protected void Vn() {
        FragmentActivity aMt = aMt();
        if (this.cbv == null) {
            this.cbv = new SwanAppMenuHeaderView(getContext());
        }
        if (aMt != null && this.cbu == null) {
            this.cbu = new com.baidu.swan.menu.h(aMt, this.cbt, Vo(), com.baidu.swan.apps.t.a.ahn(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.x.a(this.cbu, this, this.cbv).amc();
        }
    }

    private int Vo() {
        return aaA() ? aaK() ? 18 : 17 : aaK() ? 12 : 15;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.adaptation.b.d] */
    @NonNull
    public Pair<Integer, Integer> aaN() {
        if (this.cbS == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.cbS.UP().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a aaO() {
        return this.cbT;
    }

    public com.baidu.swan.apps.model.b aaP() {
        return this.cbP;
    }

    public com.baidu.swan.apps.adaptation.b.c aaQ() {
        return this.cbS;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0386a
    public com.baidu.swan.apps.res.widget.floatlayer.a RX() {
        if (this.bMj == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.bMj = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), aav().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.bMj;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public com.baidu.swan.apps.runtime.config.c aar() {
        return this.cbX;
    }

    private boolean aaR() {
        return this.cbX != null && this.cbX.cIJ;
    }

    private boolean aaS() {
        if (this.cbX == null) {
            return false;
        }
        return TextUtils.equals(this.cbX.cIL, "custom");
    }

    private void jN(String str) {
        if (!aaS()) {
            com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (akr.lZ(str).cIJ && this.cbZ == null) {
                this.cbZ = new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.core.d.e.4
                    @Override // com.baidu.swan.apps.core.f.c
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        e.this.fb(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            if (this.cbZ != null) {
                cVar.a(this.cbZ);
            }
            cVar.a(aaT());
        }
    }

    private com.baidu.swan.apps.core.f.e aaT() {
        return new com.baidu.swan.apps.core.f.e() { // from class: com.baidu.swan.apps.core.d.e.5
            @Override // com.baidu.swan.apps.core.f.e
            public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.a(e.this.cbZ);
                    fVar.a(e.this.aaU());
                    com.baidu.swan.apps.z.f.amM().a(fVar);
                }
            }

            @Override // com.baidu.swan.apps.core.f.e
            public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
                if (fVar != null) {
                    fVar.b(e.this.cbZ);
                    com.baidu.swan.apps.z.f.amM().b(fVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a aaU() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.e.6
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fY(String str) {
                e.this.jH(str);
            }
        };
    }

    private void b(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (this.cbZ != null && cVar != null) {
            cVar.b(this.cbZ);
            if (cVar.UI() != null) {
                cVar.b(this.cbZ);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void aaV() {
        int i;
        com.baidu.swan.apps.adaptation.b.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.cbt != null) {
            if (aaS()) {
                dM(true);
                i = 0;
                z = true;
            } else if (aaR()) {
                dM(false);
                if (this.cbS != null) {
                    if (this.cbS.UI() != null) {
                        dVar = this.cbS.UI().UP();
                    } else {
                        dVar = this.cbS.UP();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.cbX == null && this.cbX.cIK) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.cbX == null) {
                }
                z = true;
            } else {
                dM(false);
                i = cbN + this.cbY;
            }
            TextView centerTitleView = this.cbt.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            fb(i);
            dN(z);
        }
    }

    private void dN(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.cbz == null || !this.cbz.axH()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = ai.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = aav().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cbR.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.cbR.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cbs.getLayoutParams();
        layoutParams2.topMargin = i;
        this.cbs.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        TextView centerTitleView;
        View axG;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - cbN) * 1.0f) / (this.cbY == 0 ? 1 : this.cbY);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.cbz != null && this.cbz.axH() && (axG = this.cbz.axG()) != null && (background = axG.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.cbt.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.cbX != null && this.cbX.cIK && (centerTitleView = this.cbt.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.cbx.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void aaW() {
        this.cbO = com.baidu.swan.apps.statistic.h.pn("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.cbO != null) {
            com.baidu.swan.apps.statistic.h.a(this.cbO, gVar);
            this.cbO = null;
        }
    }

    public void aaX() {
        this.cbX.cIL = "default";
        applyImmersion();
        aaV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aaY() {
        if (this.cbr != null) {
            this.cbr.aaY();
        }
    }

    private void dO(boolean z) {
        if (com.baidu.swan.apps.y.a.eA(z)) {
            com.baidu.swan.apps.y.a.a(getContext(), this.cbt, com.baidu.swan.apps.runtime.e.arw().arz().ajw().paNumber);
        } else if (com.baidu.swan.apps.runtime.e.arw() != null) {
            com.baidu.swan.apps.y.a.a(this.cbt, com.baidu.swan.apps.runtime.e.arw().arN().b("key_unread_counts_message", (Integer) 0).intValue());
        }
    }

    private void dP(boolean z) {
        if (com.baidu.swan.apps.y.a.eA(z)) {
            com.baidu.swan.apps.y.a.a(getContext(), this.cbu, com.baidu.swan.apps.runtime.e.arw().arz().ajw().paNumber);
        }
    }
}
