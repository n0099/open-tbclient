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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.u;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.i.b;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.ubc.Flow;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class d extends b implements a.InterfaceC0181a {
    private static String arH;
    private String arA;
    private FrameLayout arC;
    private com.baidu.swan.apps.b.c.c arD;
    private com.baidu.swan.apps.tabbar.b.a arE;
    private com.baidu.swan.apps.res.widget.floatlayer.a arI;
    private com.baidu.swan.apps.ae.a.d arJ;
    private com.baidu.swan.apps.core.f.b arL;
    private Flow ary;
    private String arz;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int arx = z.ad(149.0f);
    public static String arF = LivenessStat.TYPE_STRING_DEFAULT;
    public static String arG = arF;
    private Map<String, com.baidu.swan.apps.b.c.c> arB = new TreeMap();
    private int arK = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ab();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.am("route", "fragment create.");
    }

    private void Ab() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.arg = com.baidu.swan.apps.model.c.fx(arguments.getString("ai_apps_param"));
            this.arz = this.arg != null ? this.arg.getPage() : "";
            this.arA = this.arg != null ? this.arg.getParams() : "";
            this.arJ = com.baidu.swan.apps.w.e.GJ().ff(TextUtils.isEmpty(this.arz) ? "" : this.arz);
            this.arK = zR().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.am("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.arC = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        O(inflate);
        this.arE = new com.baidu.swan.apps.tabbar.b.a(this);
        T(inflate);
        this.mRootView = a(zN() ? S(inflate) : inflate, this);
        this.aro.setRegionFactor(this.arD.xn());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView xr() {
        if (this.arD != null) {
            return this.arD.xr();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        super.O(view);
        bd(zK());
        if (Ae()) {
            zJ();
        }
        Ar();
        this.ari.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void U(View view2) {
                String xz = d.this.arD.xz();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aP(xz, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.GJ().a(xz, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
        this.arD.xu();
        zy();
        this.arj.a(com.baidu.swan.apps.u.a.EJ().Fi(), zW(), zX());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zH() {
        zY();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ce(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.arJ)) {
            super.ce(i);
            return;
        }
        if (!Ao() && u.bM(this.mActivity)) {
            z = false;
        }
        l(i, z);
        Ar();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        Ar();
        return cc;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zQ() {
        super.zQ();
        Ar();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.Er().wn()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Er().wn()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.Er().wn()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.Er().wn()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.arD.xz())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.arD.xz())));
        }
    }

    public static void dO(String str) {
        arH = str;
    }

    private void Ac() {
        if (!TextUtils.equals(arG, this.arD.xz()) || TextUtils.equals(arH, "switchTab")) {
            int hZ = this.arE.hZ(Aj());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.awL = arG;
            eVar.awM = this.arD.xz();
            eVar.arY = arH;
            eVar.awN = this.arz;
            eVar.awO = String.valueOf(hZ);
            arH = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.awL + " ,toId: " + eVar.awM + " ,RouteType: " + eVar.arY + " page:" + eVar.awN + ",TabIndex: " + eVar.awO);
            }
            com.baidu.swan.apps.w.e.GJ().a(eVar);
            arG = this.arD.xz();
        }
    }

    private void dP(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.arD.xz());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.arD.xz());
        }
        com.baidu.swan.apps.w.e.GJ().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zZ() {
        if (this.arD == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.arD.xz());
        com.baidu.swan.apps.b.c.f xs = this.arD.xs();
        if (xs != null) {
            hashMap.put("webViewUrl", xs.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void T(View view) {
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView start.");
        String Gs = this.arg.Gs();
        String params = this.arg.getParams();
        String page = this.arg.getPage();
        String x = ac.x(Gs, page, params);
        this.arD = com.baidu.swan.apps.core.i.b.dZ(x);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + x + " is load: " + (this.arD != null));
        }
        if (this.arD == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.arD = l(Gs, page, params);
        }
        this.arD.a(this.arC, com.baidu.swan.apps.w.e.GJ().ff(page));
        dT(page);
        a(this.arD);
        if (zA()) {
            this.arB.put(page, this.arD);
            this.arE.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView end.");
        As();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.arB != null && !this.arB.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.arB.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.arB.clear();
        } else if (this.arD != null) {
            b(this.arD);
            this.arD.destroy();
        }
        this.arD = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.i.b.z(com.baidu.swan.apps.w.e.GJ().Gv());
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
            } else {
                pause();
            }
        }
    }

    public void resume() {
        boolean z = this.arD == null;
        String xz = z ? "" : this.arD.xz();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + xz);
        }
        if (!z) {
            this.arD.onResume();
            Ac();
            dP("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.r(xz, true);
        if (com.baidu.swan.apps.console.c.yk()) {
            com.baidu.swan.apps.core.c.b.zs();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView xr;
        boolean z = this.arD == null;
        String xz = z ? "" : this.arD.xz();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + xz);
        }
        if (!z) {
            this.arD.onPause();
            dP("onHide");
        }
        if (vJ() != null) {
            vJ().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.r(xz, false);
        if (!z && (xr = this.arD.xr()) != null) {
            xr.bN(false);
        }
    }

    public String dQ(String str) {
        if (this.arB.containsKey(str)) {
            return this.arB.get(str).xz();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.arE.hW(bVar.azQ);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.arB.get(bVar.azQ) == null) {
            String x = ac.x(bVar.mBaseUrl, bVar.azQ, bVar.mParams);
            com.baidu.swan.apps.b.c.c dZ = com.baidu.swan.apps.core.i.b.dZ(x);
            if (dZ != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + x);
                }
                this.arB.put(bVar.azQ, dZ);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                dZ = l(bVar.mBaseUrl, bVar.azQ, bVar.mParams);
                this.arB.put(bVar.azQ, dZ);
            }
            dT(bVar.azQ);
            a(dZ);
        }
    }

    private com.baidu.swan.apps.b.c.c l(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(Xg());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + A);
        }
        com.baidu.swan.apps.core.i.b.a(A, new b.InterfaceC0148b() { // from class: com.baidu.swan.apps.core.d.d.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0148b
            public void onReady() {
                com.baidu.swan.apps.core.j.b bVar = new com.baidu.swan.apps.core.j.b();
                bVar.auA = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.auH = str2 + "?" + str3;
                } else {
                    bVar.auH = str2;
                }
                bVar.auI = com.baidu.swan.apps.w.e.GJ().ff(str2).aRX;
                bVar.auE = String.valueOf(com.baidu.swan.apps.console.a.yh());
                if (com.baidu.swan.apps.ae.b.Mh() != null) {
                    String gN = com.baidu.swan.apps.ae.b.Mh().gN(str2);
                    if (!TextUtils.isEmpty(gN)) {
                        bVar.auJ = gN;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + gN);
                        }
                    }
                }
                bVar.auG = d.DEBUG || com.baidu.swan.apps.w.e.GJ().Gq();
                com.baidu.swan.apps.w.e.GJ().a(A.atZ.xz(), com.baidu.swan.apps.core.j.b.b(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return A.atZ;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.azQ;
        com.baidu.swan.apps.ae.a.d ff = com.baidu.swan.apps.w.e.GJ().ff(TextUtils.isEmpty(str) ? "" : str);
        this.arz = str;
        this.arA = this.arA != null ? this.arg.getParams() : "";
        this.arJ = ff;
        if (dS(str)) {
            dR(str);
        } else {
            b(bVar);
            dR(str);
        }
        dM(ff.aRT);
        dN(ff.aRU);
        cc(ff.aRS);
        Ar();
        Au();
    }

    private void dR(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.arB.get(str);
        if (this.arD != cVar) {
            if (!cVar.xq()) {
                cVar.a(this.arC, com.baidu.swan.apps.w.e.GJ().ff(str));
            }
            cVar.bN(0);
            if (this.arD != null) {
                this.arD.bN(8);
            }
            this.arD = cVar;
        }
    }

    public FrameLayout Ad() {
        return this.arC;
    }

    private boolean dS(String str) {
        return (this.arB.isEmpty() || this.arB.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.Hu());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return zK() && this.arD.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean zA() {
        com.baidu.swan.apps.ae.a.c Gr;
        com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        if (GJ == null || (Gr = GJ.Gr()) == null || !Gr.MD() || this.arg == null) {
            return false;
        }
        return Gr.gR(this.arg.getPage());
    }

    protected final boolean Ae() {
        com.baidu.swan.apps.ae.a.c Gr;
        e vN = vN();
        if (vN == null) {
            return false;
        }
        return ((this.arJ != null && this.arJ.aSb) || (Gr = com.baidu.swan.apps.w.e.GJ().Gr()) == null || a(vN, Gr)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b cg = eVar.cg(0);
        if (cg == null || !(cg instanceof d)) {
            return false;
        }
        String Aj = ((d) cg).Aj();
        return cVar.gR(Aj) || TextUtils.equals(cVar.Gu(), Aj);
    }

    private boolean Af() {
        com.baidu.swan.apps.ae.a.c Gr = com.baidu.swan.apps.w.e.GJ().Gr();
        return (Gr == null || TextUtils.equals(Gr.Gu(), this.arz)) ? false : true;
    }

    public String Ag() {
        return this.arD != null ? this.arD.xz() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        if (com.baidu.swan.apps.aa.a.In()) {
            return true;
        }
        if (this.arD != null) {
            if (com.baidu.swan.apps.media.b.fj(this.arD.xz())) {
                return true;
            }
            return this.arD.xt();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void zy() {
        FragmentActivity Xg = Xg();
        if (Xg != null && this.arj == null) {
            this.arj = new com.baidu.swan.menu.g(Xg, this.ari, Af() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.arj.setStatisticSource("tool");
            this.arj.setMenuSource("swan");
            this.arj.a(com.baidu.swan.apps.u.a.Es());
            new com.baidu.swan.apps.view.coverview.c.b(this.arj, this).Qx();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> Ah() {
        if (this.arD == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.arD.xx().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Ai() {
        return this.arE;
    }

    public String Aj() {
        return this.arz;
    }

    public String Ak() {
        return this.arA;
    }

    public com.baidu.swan.apps.b.c.c Al() {
        return this.arD;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0181a
    public com.baidu.swan.apps.res.widget.floatlayer.a vJ() {
        if (this.arI == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.arI = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), zR().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.arI;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.ae.a.d zO() {
        return this.arJ;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Am() {
        return this.arm;
    }

    private boolean An() {
        return this.arJ != null && this.arJ.aRY;
    }

    private boolean Ao() {
        if (this.arJ == null) {
            return false;
        }
        return TextUtils.equals(this.arJ.aSa, "custom");
    }

    private void dT(String str) {
        if (!Ao()) {
            com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (GJ.ff(str).aRY && this.arL == null) {
                this.arL = new com.baidu.swan.apps.core.f.b() { // from class: com.baidu.swan.apps.core.d.d.3
                    @Override // com.baidu.swan.apps.core.f.b
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.cf(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            if (this.arL != null) {
                cVar.a(this.arL);
            }
            cVar.a(Ap());
        }
    }

    private com.baidu.swan.apps.core.f.d Ap() {
        return new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.core.d.d.4
            @Override // com.baidu.swan.apps.core.f.d
            public void a(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.arL);
                    fVar.a(d.this.Aq());
                }
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void b(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.arL);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Aq() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void dg(String str) {
                if (d.this.ari != null) {
                    d.this.ari.setTitle(str);
                }
            }
        };
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.arL != null && cVar != null) {
            cVar.b(this.arL);
            if (cVar.xs() != null) {
                cVar.b(this.arL);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Ar() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.ari != null) {
            if (Ao()) {
                bf(true);
                i = 0;
                z = true;
            } else if (An()) {
                bf(false);
                if (this.arD != null) {
                    if (this.arD.xs() != null) {
                        dVar = this.arD.xs().xx();
                    } else {
                        dVar = this.arD.xx();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.arJ == null && this.arJ.aRZ) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.arJ == null) {
                }
                z = true;
            } else {
                bf(false);
                i = arx + this.arK;
            }
            TextView centerTitleView = this.ari.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            cf(i);
            bg(z);
        }
    }

    private void bg(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.arm == null || !this.arm.Qd()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = z.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = zR().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.arC.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.arC.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.arh.getLayoutParams();
        layoutParams2.topMargin = i;
        this.arh.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(int i) {
        TextView centerTitleView;
        View Qc;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - arx) * 1.0f) / (this.arK == 0 ? 1 : this.arK);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.arm != null && this.arm.Qd() && (Qc = this.arm.Qc()) != null && (background = Qc.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.ari.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.arJ != null && this.arJ.aRZ && (centerTitleView = this.ari.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.arl.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void As() {
        this.ary = com.baidu.swan.apps.statistic.e.ht("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.ary != null) {
            com.baidu.swan.apps.statistic.e.a(this.ary, gVar);
            this.ary = null;
        }
    }

    public void At() {
        this.arJ.aSa = NotifyAdapterUtil.PRIMARY_CHANNEL;
        zP();
        Ar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Au() {
        if (this.arg != null) {
            this.arg.Au();
        }
    }
}
