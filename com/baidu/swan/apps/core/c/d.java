package com.baidu.swan.apps.core.c;

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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.s;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.h.b;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.ubc.Flow;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class d extends b implements a.InterfaceC0135a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final int aql = x.ad(149.0f);
    public static String aqt = LivenessStat.TYPE_STRING_DEFAULT;
    public static String aqu = aqt;
    private static String aqv;
    private Flow aqm;
    private String aqn;
    private String aqo;
    private FrameLayout aqq;
    private com.baidu.swan.apps.b.c.c aqr;
    private com.baidu.swan.apps.tabbar.b.a aqs;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqw;
    private com.baidu.swan.apps.ae.a.d aqx;
    private com.baidu.swan.apps.core.e.b aqz;
    private View mRootView;
    private Map<String, com.baidu.swan.apps.b.c.c> aqp = new TreeMap();
    private int aqy = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yw();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.as("route", "fragment create.");
    }

    private void yw() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.apT = com.baidu.swan.apps.model.c.fe(arguments.getString("ai_apps_param"));
            this.aqn = this.apT != null ? this.apT.getPage() : "";
            this.aqo = this.apT != null ? this.apT.getParams() : "";
            this.aqx = com.baidu.swan.apps.w.e.Ec().eN(TextUtils.isEmpty(this.aqn) ? "" : this.aqn);
            this.aqy = yn().getDimensionPixelSize(b.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.as("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(b.g.aiapps_fragment, viewGroup, false);
        this.aqq = (FrameLayout) inflate.findViewById(b.f.ai_apps_fragment_content);
        M(inflate);
        this.aqs = new com.baidu.swan.apps.tabbar.b.a(this);
        R(inflate);
        this.mRootView = a(yj() ? Q(inflate) : inflate, this);
        this.aqb.setRegionFactor(this.aqr.vS());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView vW() {
        if (this.aqr != null) {
            return this.aqr.vW();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        aW(yg());
        if (yz()) {
            yf();
        }
        yK();
        this.apV.setOnDoubleClickListener(new SwanAppBdActionBar.b() { // from class: com.baidu.swan.apps.core.c.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppBdActionBar.b
            public void S(View view2) {
                String we = d.this.aqr.we();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aM(we, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.Ec().a(we, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
        this.aqr.vZ();
        xW();
        this.apW.a(com.baidu.swan.apps.u.a.CT().Ds(), ys(), yt());
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void yd() {
        yu();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void ce(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.aqx)) {
            super.ce(i);
            return;
        }
        if (!yJ() && s.ck(this.mActivity)) {
            z = false;
        }
        h(i, z);
        yK();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        yK();
        return cc;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void ym() {
        super.ym();
        yK();
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.aqr.we())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.aqr.we())));
        }
    }

    public static void dT(String str) {
        aqv = str;
    }

    private void yx() {
        if (!TextUtils.equals(aqu, this.aqr.we()) || TextUtils.equals(aqv, "switchTab")) {
            int ho = this.aqs.ho(yE());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.avk = aqu;
            eVar.avl = this.aqr.we();
            eVar.aqM = aqv;
            eVar.avm = this.aqn;
            eVar.avn = String.valueOf(ho);
            aqv = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.avk + " ,toId: " + eVar.avl + " ,RouteType: " + eVar.aqM + " page:" + eVar.avm + ",TabIndex: " + eVar.avn);
            }
            com.baidu.swan.apps.w.e.Ec().a(eVar);
            aqu = this.aqr.we();
        }
    }

    private void dU(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.aqr.we());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.aqr.we());
        }
        com.baidu.swan.apps.w.e.Ec().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yv() {
        if (this.aqr == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aqr.we());
        com.baidu.swan.apps.b.c.f vX = this.aqr.vX();
        if (vX != null) {
            hashMap.put("webViewUrl", vX.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.Ec().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void R(View view) {
        com.baidu.swan.apps.performance.e.as("route", "createSlaveWebView start.");
        String DL = this.apT.DL();
        String params = this.apT.getParams();
        String page = this.apT.getPage();
        String x = aa.x(DL, page, params);
        this.aqr = com.baidu.swan.apps.core.h.b.ed(x);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + x + " is load: " + (this.aqr != null));
        }
        if (this.aqr == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.aqr = l(DL, page, params);
        }
        this.aqr.a(this.aqq, com.baidu.swan.apps.w.e.Ec().eN(page));
        a(page, this.aqr);
        a(this.aqr);
        if (xY()) {
            this.aqp.put(page, this.aqr);
            this.aqs.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.as("route", "createSlaveWebView end.");
        yL();
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aqp != null && !this.aqp.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.aqp.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.aqp.clear();
        } else if (this.aqr != null) {
            b(this.aqr);
            this.aqr.destroy();
        }
        this.aqr = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.h.b.w(com.baidu.swan.apps.w.e.Ec().DO());
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (DEBUG) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (isAdded()) {
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void resume() {
        boolean z = this.aqr == null;
        String we = z ? "" : this.aqr.we();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + we);
        }
        if (!z) {
            this.aqr.onResume();
            yx();
            dU("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.r(we, true);
        if (com.baidu.swan.apps.console.c.wL()) {
            com.baidu.swan.apps.core.b.b.xQ();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView vW;
        boolean z = this.aqr == null;
        String we = z ? "" : this.aqr.we();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + we);
        }
        if (!z) {
            this.aqr.onPause();
            dU("onHide");
        }
        if (uv() != null) {
            uv().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.r(we, false);
        if (!z && (vW = this.aqr.vW()) != null) {
            vW.bB(false);
        }
    }

    public String dV(String str) {
        if (this.aqp.containsKey(str)) {
            return this.aqp.get(str).we();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.aqs.hl(bVar.axH);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.aqp.get(bVar.axH) == null) {
            String x = aa.x(bVar.mBaseUrl, bVar.axH, bVar.mParams);
            com.baidu.swan.apps.b.c.c ed = com.baidu.swan.apps.core.h.b.ed(x);
            if (ed != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + x);
                }
                this.aqp.put(bVar.axH, ed);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                ed = l(bVar.mBaseUrl, bVar.axH, bVar.mParams);
                this.aqp.put(bVar.axH, ed);
            }
            a(bVar.axH, ed);
            a(ed);
        }
    }

    private com.baidu.swan.apps.b.c.c l(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Sy());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + x);
        }
        com.baidu.swan.apps.core.h.b.a(x, new b.InterfaceC0105b() { // from class: com.baidu.swan.apps.core.c.d.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0105b
            public void onReady() {
                com.baidu.swan.apps.core.i.b bVar = new com.baidu.swan.apps.core.i.b();
                bVar.atf = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.atl = str2 + "?" + str3;
                } else {
                    bVar.atl = str2;
                }
                bVar.atm = com.baidu.swan.apps.w.e.Ec().eN(str2).aOH;
                bVar.atj = String.valueOf(com.baidu.swan.apps.console.a.wI());
                if (com.baidu.swan.apps.ae.b.IX() != null) {
                    String gj = com.baidu.swan.apps.ae.b.IX().gj(str2);
                    if (!TextUtils.isEmpty(gj)) {
                        bVar.atn = gj;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + gj);
                        }
                    }
                }
                com.baidu.swan.apps.w.e.Ec().a(x.asE.we(), com.baidu.swan.apps.core.i.b.a(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return x.asE;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.axH;
        com.baidu.swan.apps.ae.a.d eN = com.baidu.swan.apps.w.e.Ec().eN(TextUtils.isEmpty(str) ? "" : str);
        this.aqn = str;
        this.aqo = this.aqo != null ? this.apT.getParams() : "";
        this.aqx = eN;
        if (dX(str)) {
            dW(str);
        } else {
            b(bVar);
            dW(str);
        }
        dR(eN.aOD);
        dS(eN.aOE);
        cc(eN.aOC);
        yK();
        yN();
    }

    private void dW(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.aqp.get(str);
        if (this.aqr != cVar) {
            if (!cVar.vV()) {
                cVar.a(this.aqq, com.baidu.swan.apps.w.e.Ec().eN(str));
            }
            cVar.bN(0);
            if (this.aqr != null) {
                this.aqr.bN(8);
            }
            this.aqr = cVar;
        }
    }

    public FrameLayout yy() {
        return this.aqq;
    }

    private boolean dX(String str) {
        return (this.aqp.isEmpty() || this.aqp.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.EK());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return yg() && this.aqr.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        com.baidu.swan.apps.ae.a.c DK;
        com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        if (Ec == null || (DK = Ec.DK()) == null || !DK.Js() || this.apT == null) {
            return false;
        }
        return DK.gn(this.apT.getPage());
    }

    protected final boolean yz() {
        com.baidu.swan.apps.ae.a.c DK;
        e uz = uz();
        return (uz == null || (DK = com.baidu.swan.apps.w.e.Ec().DK()) == null || a(uz, DK)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b cg = eVar.cg(0);
        if (cg == null || !(cg instanceof d)) {
            return false;
        }
        String yE = ((d) cg).yE();
        return cVar.gn(yE) || TextUtils.equals(cVar.DN(), yE);
    }

    private boolean yA() {
        com.baidu.swan.apps.ae.a.c DK = com.baidu.swan.apps.w.e.Ec().DK();
        return (DK == null || TextUtils.equals(DK.DN(), this.aqn)) ? false : true;
    }

    public String yB() {
        return this.aqr != null ? this.aqr.we() : "";
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        if (com.baidu.swan.apps.u.a.Df().vT()) {
            return true;
        }
        if (this.aqr != null) {
            if (com.baidu.swan.apps.media.b.eR(this.aqr.we())) {
                return true;
            }
            return this.aqr.vY();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    @DebugTrace
    protected void xW() {
        FragmentActivity Sy = Sy();
        if (Sy != null && this.apW == null) {
            this.apW = new com.baidu.swan.menu.h(Sy, this.apV, yA() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.apW.setStatisticSource("tool");
            this.apW.setMenuSource("swan");
            this.apW.a(com.baidu.swan.apps.u.a.CC());
            new com.baidu.swan.apps.view.coverview.c.b(this.apW, this).MU();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> yC() {
        if (this.aqr == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.aqr.wc().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    public com.baidu.swan.apps.tabbar.b.a yD() {
        return this.aqs;
    }

    public String yE() {
        return this.aqn;
    }

    public String yF() {
        return this.aqo;
    }

    public com.baidu.swan.apps.b.c.c yG() {
        return this.aqr;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0135a
    public com.baidu.swan.apps.res.widget.floatlayer.a uv() {
        if (this.aqw == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aqw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(b.f.ai_apps_fragment_base_view), yn().getDimensionPixelOffset(b.d.aiapps_normal_base_action_bar_height));
        }
        return this.aqw;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public com.baidu.swan.apps.ae.a.d yk() {
        return this.aqx;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b yH() {
        return this.apZ;
    }

    private boolean yI() {
        return this.aqx != null && this.aqx.aOI;
    }

    private void a(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            cVar.a(new com.baidu.swan.apps.core.e.a() { // from class: com.baidu.swan.apps.core.c.d.3
                @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
                public void dl(String str) {
                    d.this.apV.setTitle(str);
                }
            });
        }
    }

    private boolean yJ() {
        if (this.aqx == null) {
            return false;
        }
        return TextUtils.equals(this.aqx.aOK, "custom");
    }

    private void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null && !yJ()) {
            if (com.baidu.swan.apps.w.e.Ec().eN(TextUtils.isEmpty(str) ? "" : str).aOI) {
                if (this.aqz == null) {
                    this.aqz = new com.baidu.swan.apps.core.e.b() { // from class: com.baidu.swan.apps.core.c.d.4
                        @Override // com.baidu.swan.apps.core.e.b
                        public void onScrollChanged(int i, int i2, int i3, int i4) {
                            d.this.cf(i2);
                        }
                    };
                }
                if (DEBUG) {
                    Log.d("SwanAppFragment", "add transparent bar scroll listener: " + str);
                }
                cVar.a(this.aqz);
                cVar.a(new com.baidu.swan.apps.core.e.d() { // from class: com.baidu.swan.apps.core.c.d.5
                    @Override // com.baidu.swan.apps.core.e.d
                    public void a(com.baidu.swan.apps.b.c.f fVar) {
                        if (fVar != null) {
                            fVar.a(d.this.aqz);
                        }
                    }

                    @Override // com.baidu.swan.apps.core.e.d
                    public void b(com.baidu.swan.apps.b.c.f fVar) {
                        if (fVar != null) {
                            fVar.b(d.this.aqz);
                        }
                    }
                });
            }
        }
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.aqz != null && cVar != null) {
            cVar.b(this.aqz);
            if (cVar.vX() != null) {
                cVar.b(this.aqz);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void yK() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.apV != null) {
            if (yJ()) {
                aY(true);
                i = 0;
                z = true;
            } else if (yI()) {
                aY(false);
                if (this.aqr != null) {
                    if (this.aqr.vX() != null) {
                        dVar = this.aqr.vX().wc();
                    } else {
                        dVar = this.aqr.wc();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.aqx == null && this.aqx.aOJ) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.aqx == null) {
                }
                z = true;
            } else {
                aY(false);
                i = aql + this.aqy;
            }
            TextView titleViewCenter = this.apV.getTitleViewCenter();
            if (titleViewCenter != null) {
                titleViewCenter.setAlpha(i2);
            }
            cf(i);
            aZ(z);
        }
    }

    private void aZ(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.apZ == null || !this.apZ.MB()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = x.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = yn().getDimensionPixelSize(b.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aqq.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.aqq.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.apU.getLayoutParams();
        layoutParams2.topMargin = i;
        this.apU.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(int i) {
        TextView titleViewCenter;
        View MA;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aql) * 1.0f) / (this.aqy == 0 ? 1 : this.aqy);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.apZ != null && this.apZ.MB() && (MA = this.apZ.MA()) != null && (background = MA.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.apV.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.aqx != null && this.aqx.aOJ && (titleViewCenter = this.apV.getTitleViewCenter()) != null) {
            titleViewCenter.setAlpha(f);
        }
        Drawable background3 = this.apY.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void yL() {
        this.aqm = com.baidu.swan.apps.statistic.c.gP("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.aqm != null) {
            com.baidu.swan.apps.statistic.c.a(this.aqm, gVar);
            this.aqm = null;
        }
    }

    public void yM() {
        this.aqx.aOK = "default";
        yl();
        yK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yN() {
        if (this.apT != null) {
            this.apT.yN();
        }
    }
}
