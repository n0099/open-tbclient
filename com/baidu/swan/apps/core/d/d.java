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
public class d extends b implements a.InterfaceC0170a {
    private static String aqG;
    private FrameLayout aqB;
    private com.baidu.swan.apps.b.c.c aqC;
    private com.baidu.swan.apps.tabbar.b.a aqD;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqH;
    private com.baidu.swan.apps.ae.a.d aqI;
    private com.baidu.swan.apps.core.f.b aqK;
    private Flow aqx;
    private String aqy;
    private String aqz;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int aqw = z.ad(149.0f);
    public static String aqE = LivenessStat.TYPE_STRING_DEFAULT;
    public static String aqF = aqE;
    private Map<String, com.baidu.swan.apps.b.c.c> aqA = new TreeMap();
    private int aqJ = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zq();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.am("route", "fragment create.");
    }

    private void zq() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aqf = com.baidu.swan.apps.model.c.fr(arguments.getString("ai_apps_param"));
            this.aqy = this.aqf != null ? this.aqf.getPage() : "";
            this.aqz = this.aqf != null ? this.aqf.getParams() : "";
            this.aqI = com.baidu.swan.apps.w.e.FV().eZ(TextUtils.isEmpty(this.aqy) ? "" : this.aqy);
            this.aqJ = zg().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.aqB = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        M(inflate);
        this.aqD = new com.baidu.swan.apps.tabbar.b.a(this);
        R(inflate);
        this.mRootView = a(zc() ? Q(inflate) : inflate, this);
        this.aqn.setRegionFactor(this.aqC.wI());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView wM() {
        if (this.aqC != null) {
            return this.aqC.wM();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void M(View view) {
        super.M(view);
        ba(yZ());
        if (zt()) {
            yY();
        }
        zG();
        this.aqh.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void S(View view2) {
                String wU = d.this.aqC.wU();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aP(wU, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.FV().a(wU, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
        this.aqC.wP();
        yN();
        this.aqi.a(com.baidu.swan.apps.u.a.DW().Ev(), zl(), zm());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yW() {
        zn();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void cd(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.aqI)) {
            super.cd(i);
            return;
        }
        if (!zD() && u.bM(this.mActivity)) {
            z = false;
        }
        l(i, z);
        zG();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean cb(int i) {
        boolean cb = super.cb(i);
        zG();
        return cb;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zf() {
        super.zf();
        zG();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.DE().vI()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.DE().vI()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.DE().vI()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.DE().vI()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.aqC.wU())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.aqC.wU())));
        }
    }

    public static void dI(String str) {
        aqG = str;
    }

    private void zr() {
        if (!TextUtils.equals(aqF, this.aqC.wU()) || TextUtils.equals(aqG, "switchTab")) {
            int hR = this.aqD.hR(zy());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.avI = aqF;
            eVar.avJ = this.aqC.wU();
            eVar.aqX = aqG;
            eVar.avK = this.aqy;
            eVar.avL = String.valueOf(hR);
            aqG = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.avI + " ,toId: " + eVar.avJ + " ,RouteType: " + eVar.aqX + " page:" + eVar.avK + ",TabIndex: " + eVar.avL);
            }
            com.baidu.swan.apps.w.e.FV().a(eVar);
            aqF = this.aqC.wU();
        }
    }

    private void dJ(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.aqC.wU());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.aqC.wU());
        }
        com.baidu.swan.apps.w.e.FV().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zo() {
        if (this.aqC == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aqC.wU());
        com.baidu.swan.apps.b.c.f wN = this.aqC.wN();
        if (wN != null) {
            hashMap.put("webViewUrl", wN.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void R(View view) {
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView start.");
        String FE = this.aqf.FE();
        String params = this.aqf.getParams();
        String page = this.aqf.getPage();
        String x = ac.x(FE, page, params);
        this.aqC = com.baidu.swan.apps.core.i.b.dT(x);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + x + " is load: " + (this.aqC != null));
        }
        if (this.aqC == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.aqC = l(FE, page, params);
        }
        this.aqC.a(this.aqB, com.baidu.swan.apps.w.e.FV().eZ(page));
        dN(page);
        a(this.aqC);
        if (yP()) {
            this.aqA.put(page, this.aqC);
            this.aqD.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView end.");
        zH();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aqA != null && !this.aqA.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.aqA.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.aqA.clear();
        } else if (this.aqC != null) {
            b(this.aqC);
            this.aqC.destroy();
        }
        this.aqC = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.i.b.w(com.baidu.swan.apps.w.e.FV().FH());
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
        boolean z = this.aqC == null;
        String wU = z ? "" : this.aqC.wU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + wU);
        }
        if (!z) {
            this.aqC.onResume();
            zr();
            dJ("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.r(wU, true);
        if (com.baidu.swan.apps.console.c.xC()) {
            com.baidu.swan.apps.core.c.b.yH();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView wM;
        boolean z = this.aqC == null;
        String wU = z ? "" : this.aqC.wU();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + wU);
        }
        if (!z) {
            this.aqC.onPause();
            dJ("onHide");
        }
        if (ve() != null) {
            ve().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.r(wU, false);
        if (!z && (wM = this.aqC.wM()) != null) {
            wM.bK(false);
        }
    }

    public String dK(String str) {
        if (this.aqA.containsKey(str)) {
            return this.aqA.get(str).wU();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.aqD.hO(bVar.ayL);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.aqA.get(bVar.ayL) == null) {
            String x = ac.x(bVar.mBaseUrl, bVar.ayL, bVar.mParams);
            com.baidu.swan.apps.b.c.c dT = com.baidu.swan.apps.core.i.b.dT(x);
            if (dT != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + x);
                }
                this.aqA.put(bVar.ayL, dT);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                dT = l(bVar.mBaseUrl, bVar.ayL, bVar.mParams);
                this.aqA.put(bVar.ayL, dT);
            }
            dN(bVar.ayL);
            a(dT);
        }
    }

    private com.baidu.swan.apps.b.c.c l(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a x = com.baidu.swan.apps.core.i.b.x(Wi());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + x);
        }
        com.baidu.swan.apps.core.i.b.a(x, new b.InterfaceC0137b() { // from class: com.baidu.swan.apps.core.d.d.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0137b
            public void onReady() {
                com.baidu.swan.apps.core.j.b bVar = new com.baidu.swan.apps.core.j.b();
                bVar.atz = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.atG = str2 + "?" + str3;
                } else {
                    bVar.atG = str2;
                }
                bVar.atH = com.baidu.swan.apps.w.e.FV().eZ(str2).aQP;
                bVar.atD = String.valueOf(com.baidu.swan.apps.console.a.xz());
                if (com.baidu.swan.apps.ae.b.Lq() != null) {
                    String gF = com.baidu.swan.apps.ae.b.Lq().gF(str2);
                    if (!TextUtils.isEmpty(gF)) {
                        bVar.atI = gF;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + gF);
                        }
                    }
                }
                bVar.atF = d.DEBUG || com.baidu.swan.apps.w.e.FV().FC();
                com.baidu.swan.apps.w.e.FV().a(x.asY.wU(), com.baidu.swan.apps.core.j.b.b(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return x.asY;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.ayL;
        com.baidu.swan.apps.ae.a.d eZ = com.baidu.swan.apps.w.e.FV().eZ(TextUtils.isEmpty(str) ? "" : str);
        this.aqy = str;
        this.aqz = this.aqz != null ? this.aqf.getParams() : "";
        this.aqI = eZ;
        if (dM(str)) {
            dL(str);
        } else {
            b(bVar);
            dL(str);
        }
        dG(eZ.aQL);
        dH(eZ.aQM);
        cb(eZ.aQK);
        zG();
        zJ();
    }

    private void dL(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.aqA.get(str);
        if (this.aqC != cVar) {
            if (!cVar.wL()) {
                cVar.a(this.aqB, com.baidu.swan.apps.w.e.FV().eZ(str));
            }
            cVar.bM(0);
            if (this.aqC != null) {
                this.aqC.bM(8);
            }
            this.aqC = cVar;
        }
    }

    public FrameLayout zs() {
        return this.aqB;
    }

    private boolean dM(String str) {
        return (this.aqA.isEmpty() || this.aqA.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.GG());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return yZ() && this.aqC.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        com.baidu.swan.apps.ae.a.c FD;
        com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
        if (FV == null || (FD = FV.FD()) == null || !FD.LL() || this.aqf == null) {
            return false;
        }
        return FD.gJ(this.aqf.getPage());
    }

    protected final boolean zt() {
        com.baidu.swan.apps.ae.a.c FD;
        e vi = vi();
        if (vi == null) {
            return false;
        }
        return ((this.aqI != null && this.aqI.aQT) || (FD = com.baidu.swan.apps.w.e.FV().FD()) == null || a(vi, FD)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b cf = eVar.cf(0);
        if (cf == null || !(cf instanceof d)) {
            return false;
        }
        String zy = ((d) cf).zy();
        return cVar.gJ(zy) || TextUtils.equals(cVar.FG(), zy);
    }

    private boolean zu() {
        com.baidu.swan.apps.ae.a.c FD = com.baidu.swan.apps.w.e.FV().FD();
        return (FD == null || TextUtils.equals(FD.FG(), this.aqy)) ? false : true;
    }

    public String zv() {
        return this.aqC != null ? this.aqC.wU() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        if (com.baidu.swan.apps.aa.a.Hx()) {
            return true;
        }
        if (this.aqC != null) {
            if (com.baidu.swan.apps.media.b.fd(this.aqC.wU())) {
                return true;
            }
            return this.aqC.wO();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void yN() {
        FragmentActivity Wi = Wi();
        if (Wi != null && this.aqi == null) {
            this.aqi = new com.baidu.swan.menu.g(Wi, this.aqh, zu() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.aqi.setStatisticSource("tool");
            this.aqi.setMenuSource("swan");
            this.aqi.a(com.baidu.swan.apps.u.a.DF());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqi, this).PB();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> zw() {
        if (this.aqC == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.aqC.wS().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a zx() {
        return this.aqD;
    }

    public String zy() {
        return this.aqy;
    }

    public String zz() {
        return this.aqz;
    }

    public com.baidu.swan.apps.b.c.c zA() {
        return this.aqC;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0170a
    public com.baidu.swan.apps.res.widget.floatlayer.a ve() {
        if (this.aqH == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aqH = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), zg().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aqH;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.ae.a.d zd() {
        return this.aqI;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b zB() {
        return this.aql;
    }

    private boolean zC() {
        return this.aqI != null && this.aqI.aQQ;
    }

    private boolean zD() {
        if (this.aqI == null) {
            return false;
        }
        return TextUtils.equals(this.aqI.aQS, "custom");
    }

    private void dN(String str) {
        if (!zD()) {
            com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (FV.eZ(str).aQQ && this.aqK == null) {
                this.aqK = new com.baidu.swan.apps.core.f.b() { // from class: com.baidu.swan.apps.core.d.d.3
                    @Override // com.baidu.swan.apps.core.f.b
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.ce(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            if (this.aqK != null) {
                cVar.a(this.aqK);
            }
            cVar.a(zE());
        }
    }

    private com.baidu.swan.apps.core.f.d zE() {
        return new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.core.d.d.4
            @Override // com.baidu.swan.apps.core.f.d
            public void a(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.aqK);
                    fVar.a(d.this.zF());
                }
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void b(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.aqK);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a zF() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void da(String str) {
                if (d.this.aqh != null) {
                    d.this.aqh.setTitle(str);
                }
            }
        };
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.aqK != null && cVar != null) {
            cVar.b(this.aqK);
            if (cVar.wN() != null) {
                cVar.b(this.aqK);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void zG() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.aqh != null) {
            if (zD()) {
                bc(true);
                i = 0;
                z = true;
            } else if (zC()) {
                bc(false);
                if (this.aqC != null) {
                    if (this.aqC.wN() != null) {
                        dVar = this.aqC.wN().wS();
                    } else {
                        dVar = this.aqC.wS();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.aqI == null && this.aqI.aQR) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.aqI == null) {
                }
                z = true;
            } else {
                bc(false);
                i = aqw + this.aqJ;
            }
            TextView centerTitleView = this.aqh.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ce(i);
            bd(z);
        }
    }

    private void bd(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.aql == null || !this.aql.Pi()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = z.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = zg().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aqB.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.aqB.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.aqg.getLayoutParams();
        layoutParams2.topMargin = i;
        this.aqg.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(int i) {
        TextView centerTitleView;
        View Ph;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aqw) * 1.0f) / (this.aqJ == 0 ? 1 : this.aqJ);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.aql != null && this.aql.Pi() && (Ph = this.aql.Ph()) != null && (background = Ph.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.aqh.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.aqI != null && this.aqI.aQR && (centerTitleView = this.aqh.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.aqk.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void zH() {
        this.aqx = com.baidu.swan.apps.statistic.e.hl("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.aqx != null) {
            com.baidu.swan.apps.statistic.e.a(this.aqx, gVar);
            this.aqx = null;
        }
    }

    public void zI() {
        this.aqI.aQS = NotifyAdapterUtil.PRIMARY_CHANNEL;
        ze();
        zG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zJ() {
        if (this.aqf != null) {
            this.aqf.zJ();
        }
    }
}
