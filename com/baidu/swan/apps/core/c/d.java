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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.s;
import com.baidu.swan.apps.an.x;
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
public class d extends b implements a.InterfaceC0164a {
    private static String aqA;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqB;
    private com.baidu.swan.apps.ae.a.d aqC;
    private com.baidu.swan.apps.core.e.b aqE;
    private Flow aqr;
    private String aqs;
    private String aqt;
    private FrameLayout aqv;
    private com.baidu.swan.apps.b.c.c aqw;
    private com.baidu.swan.apps.tabbar.b.a aqx;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int aqq = x.ad(149.0f);
    public static String aqy = LivenessStat.TYPE_STRING_DEFAULT;
    public static String aqz = aqy;
    private Map<String, com.baidu.swan.apps.b.c.c> aqu = new TreeMap();
    private int aqD = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yv();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.as("route", "fragment create.");
    }

    private void yv() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.apY = com.baidu.swan.apps.model.c.ff(arguments.getString("ai_apps_param"));
            this.aqs = this.apY != null ? this.apY.getPage() : "";
            this.aqt = this.apY != null ? this.apY.getParams() : "";
            this.aqC = com.baidu.swan.apps.w.e.Ea().eO(TextUtils.isEmpty(this.aqs) ? "" : this.aqs);
            this.aqD = ym().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.aqv = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        M(inflate);
        this.aqx = new com.baidu.swan.apps.tabbar.b.a(this);
        R(inflate);
        this.mRootView = a(yi() ? Q(inflate) : inflate, this);
        this.aqg.setRegionFactor(this.aqw.vR());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView vV() {
        if (this.aqw != null) {
            return this.aqw.vV();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        aW(yf());
        if (yy()) {
            ye();
        }
        yJ();
        this.aqa.setOnDoubleClickListener(new SwanAppBdActionBar.b() { // from class: com.baidu.swan.apps.core.c.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppBdActionBar.b
            public void S(View view2) {
                String wd = d.this.aqw.wd();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aM(wd, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.Ea().a(wd, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        this.aqw.vY();
        xV();
        this.aqb.a(com.baidu.swan.apps.u.a.CR().Dq(), yr(), ys());
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void yc() {
        yt();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void cd(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.aqC)) {
            super.cd(i);
            return;
        }
        if (!yI() && s.ck(this.mActivity)) {
            z = false;
        }
        h(i, z);
        yJ();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean cb(int i) {
        boolean cb = super.cb(i);
        yJ();
        return cb;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yl() {
        super.yl();
        yJ();
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.Cz().vg()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Cz().vg()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.Cz().vg()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.Cz().vg()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.aqw.wd())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.aqw.wd())));
        }
    }

    public static void dV(String str) {
        aqA = str;
    }

    private void yw() {
        if (!TextUtils.equals(aqz, this.aqw.wd()) || TextUtils.equals(aqA, "switchTab")) {
            int hp = this.aqx.hp(yD());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.avo = aqz;
            eVar.avp = this.aqw.wd();
            eVar.aqR = aqA;
            eVar.avq = this.aqs;
            eVar.avr = String.valueOf(hp);
            aqA = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.avo + " ,toId: " + eVar.avp + " ,RouteType: " + eVar.aqR + " page:" + eVar.avq + ",TabIndex: " + eVar.avr);
            }
            com.baidu.swan.apps.w.e.Ea().a(eVar);
            aqz = this.aqw.wd();
        }
    }

    private void dW(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.aqw.wd());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.aqw.wd());
        }
        com.baidu.swan.apps.w.e.Ea().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.c.b
    public void yu() {
        if (this.aqw == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aqw.wd());
        com.baidu.swan.apps.b.c.f vW = this.aqw.vW();
        if (vW != null) {
            hashMap.put("webViewUrl", vW.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.Ea().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void R(View view) {
        com.baidu.swan.apps.performance.e.as("route", "createSlaveWebView start.");
        String DJ = this.apY.DJ();
        String params = this.apY.getParams();
        String page = this.apY.getPage();
        String x = aa.x(DJ, page, params);
        this.aqw = com.baidu.swan.apps.core.h.b.ef(x);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + x + " is load: " + (this.aqw != null));
        }
        if (this.aqw == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.aqw = l(DJ, page, params);
        }
        this.aqw.a(this.aqv, com.baidu.swan.apps.w.e.Ea().eO(page));
        a(page, this.aqw);
        a(this.aqw);
        if (xX()) {
            this.aqu.put(page, this.aqw);
            this.aqx.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.as("route", "createSlaveWebView end.");
        yK();
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aqu != null && !this.aqu.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.aqu.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.aqu.clear();
        } else if (this.aqw != null) {
            b(this.aqw);
            this.aqw.destroy();
        }
        this.aqw = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.h.b.w(com.baidu.swan.apps.w.e.Ea().DM());
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
        boolean z = this.aqw == null;
        String wd = z ? "" : this.aqw.wd();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + wd);
        }
        if (!z) {
            this.aqw.onResume();
            yw();
            dW("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.r(wd, true);
        if (com.baidu.swan.apps.console.c.wK()) {
            com.baidu.swan.apps.core.b.b.xP();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView vV;
        boolean z = this.aqw == null;
        String wd = z ? "" : this.aqw.wd();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + wd);
        }
        if (!z) {
            this.aqw.onPause();
            dW("onHide");
        }
        if (uu() != null) {
            uu().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.r(wd, false);
        if (!z && (vV = this.aqw.vV()) != null) {
            vV.bB(false);
        }
    }

    public String dX(String str) {
        if (this.aqu.containsKey(str)) {
            return this.aqu.get(str).wd();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.aqx.hm(bVar.axL);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.aqu.get(bVar.axL) == null) {
            String x = aa.x(bVar.mBaseUrl, bVar.axL, bVar.mParams);
            com.baidu.swan.apps.b.c.c ef = com.baidu.swan.apps.core.h.b.ef(x);
            if (ef != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + x);
                }
                this.aqu.put(bVar.axL, ef);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                ef = l(bVar.mBaseUrl, bVar.axL, bVar.mParams);
                this.aqu.put(bVar.axL, ef);
            }
            a(bVar.axL, ef);
            a(ef);
        }
    }

    private com.baidu.swan.apps.b.c.c l(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Sw());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + x);
        }
        com.baidu.swan.apps.core.h.b.a(x, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.core.c.d.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                com.baidu.swan.apps.core.i.b bVar = new com.baidu.swan.apps.core.i.b();
                bVar.atk = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.atq = str2 + "?" + str3;
                } else {
                    bVar.atq = str2;
                }
                bVar.atr = com.baidu.swan.apps.w.e.Ea().eO(str2).aOL;
                bVar.ato = String.valueOf(com.baidu.swan.apps.console.a.wH());
                if (com.baidu.swan.apps.ae.b.IV() != null) {
                    String gk = com.baidu.swan.apps.ae.b.IV().gk(str2);
                    if (!TextUtils.isEmpty(gk)) {
                        bVar.ats = gk;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + gk);
                        }
                    }
                }
                com.baidu.swan.apps.w.e.Ea().a(x.asJ.wd(), com.baidu.swan.apps.core.i.b.a(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return x.asJ;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.axL;
        com.baidu.swan.apps.ae.a.d eO = com.baidu.swan.apps.w.e.Ea().eO(TextUtils.isEmpty(str) ? "" : str);
        this.aqs = str;
        this.aqt = this.aqt != null ? this.apY.getParams() : "";
        this.aqC = eO;
        if (dZ(str)) {
            dY(str);
        } else {
            b(bVar);
            dY(str);
        }
        dT(eO.aOH);
        dU(eO.aOI);
        cb(eO.aOG);
        yJ();
        yM();
    }

    private void dY(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.aqu.get(str);
        if (this.aqw != cVar) {
            if (!cVar.vU()) {
                cVar.a(this.aqv, com.baidu.swan.apps.w.e.Ea().eO(str));
            }
            cVar.bM(0);
            if (this.aqw != null) {
                this.aqw.bM(8);
            }
            this.aqw = cVar;
        }
    }

    public FrameLayout yx() {
        return this.aqv;
    }

    private boolean dZ(String str) {
        return (this.aqu.isEmpty() || this.aqu.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.EI());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return yf() && this.aqw.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        com.baidu.swan.apps.ae.a.c DI;
        com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        if (Ea == null || (DI = Ea.DI()) == null || !DI.Jq() || this.apY == null) {
            return false;
        }
        return DI.go(this.apY.getPage());
    }

    protected final boolean yy() {
        com.baidu.swan.apps.ae.a.c DI;
        e uy = uy();
        return (uy == null || (DI = com.baidu.swan.apps.w.e.Ea().DI()) == null || a(uy, DI)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b cf = eVar.cf(0);
        if (cf == null || !(cf instanceof d)) {
            return false;
        }
        String yD = ((d) cf).yD();
        return cVar.go(yD) || TextUtils.equals(cVar.DL(), yD);
    }

    private boolean yz() {
        com.baidu.swan.apps.ae.a.c DI = com.baidu.swan.apps.w.e.Ea().DI();
        return (DI == null || TextUtils.equals(DI.DL(), this.aqs)) ? false : true;
    }

    public String yA() {
        return this.aqw != null ? this.aqw.wd() : "";
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        if (com.baidu.swan.apps.u.a.Dd().vS()) {
            return true;
        }
        if (this.aqw != null) {
            if (com.baidu.swan.apps.media.b.eS(this.aqw.wd())) {
                return true;
            }
            return this.aqw.vX();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    @DebugTrace
    protected void xV() {
        FragmentActivity Sw = Sw();
        if (Sw != null && this.aqb == null) {
            this.aqb = new com.baidu.swan.menu.h(Sw, this.aqa, yz() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.aqb.setStatisticSource("tool");
            this.aqb.setMenuSource("swan");
            this.aqb.a(com.baidu.swan.apps.u.a.CA());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqb, this).MS();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> yB() {
        if (this.aqw == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.aqw.wb().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    public com.baidu.swan.apps.tabbar.b.a yC() {
        return this.aqx;
    }

    public String yD() {
        return this.aqs;
    }

    public String yE() {
        return this.aqt;
    }

    public com.baidu.swan.apps.b.c.c yF() {
        return this.aqw;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0164a
    public com.baidu.swan.apps.res.widget.floatlayer.a uu() {
        if (this.aqB == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aqB = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), ym().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aqB;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public com.baidu.swan.apps.ae.a.d yj() {
        return this.aqC;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b yG() {
        return this.aqe;
    }

    private boolean yH() {
        return this.aqC != null && this.aqC.aOM;
    }

    private void a(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            cVar.a(new com.baidu.swan.apps.core.e.a() { // from class: com.baidu.swan.apps.core.c.d.3
                @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
                public void dn(String str) {
                    d.this.aqa.setTitle(str);
                }
            });
        }
    }

    private boolean yI() {
        if (this.aqC == null) {
            return false;
        }
        return TextUtils.equals(this.aqC.aOO, "custom");
    }

    private void a(String str, com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null && !yI()) {
            if (com.baidu.swan.apps.w.e.Ea().eO(TextUtils.isEmpty(str) ? "" : str).aOM) {
                if (this.aqE == null) {
                    this.aqE = new com.baidu.swan.apps.core.e.b() { // from class: com.baidu.swan.apps.core.c.d.4
                        @Override // com.baidu.swan.apps.core.e.b
                        public void onScrollChanged(int i, int i2, int i3, int i4) {
                            d.this.ce(i2);
                        }
                    };
                }
                if (DEBUG) {
                    Log.d("SwanAppFragment", "add transparent bar scroll listener: " + str);
                }
                cVar.a(this.aqE);
                cVar.a(new com.baidu.swan.apps.core.e.d() { // from class: com.baidu.swan.apps.core.c.d.5
                    @Override // com.baidu.swan.apps.core.e.d
                    public void a(com.baidu.swan.apps.b.c.f fVar) {
                        if (fVar != null) {
                            fVar.a(d.this.aqE);
                        }
                    }

                    @Override // com.baidu.swan.apps.core.e.d
                    public void b(com.baidu.swan.apps.b.c.f fVar) {
                        if (fVar != null) {
                            fVar.b(d.this.aqE);
                        }
                    }
                });
            }
        }
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.aqE != null && cVar != null) {
            cVar.b(this.aqE);
            if (cVar.vW() != null) {
                cVar.b(this.aqE);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void yJ() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.aqa != null) {
            if (yI()) {
                aY(true);
                i = 0;
                z = true;
            } else if (yH()) {
                aY(false);
                if (this.aqw != null) {
                    if (this.aqw.vW() != null) {
                        dVar = this.aqw.vW().wb();
                    } else {
                        dVar = this.aqw.wb();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.aqC == null && this.aqC.aON) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.aqC == null) {
                }
                z = true;
            } else {
                aY(false);
                i = aqq + this.aqD;
            }
            TextView titleViewCenter = this.aqa.getTitleViewCenter();
            if (titleViewCenter != null) {
                titleViewCenter.setAlpha(i2);
            }
            ce(i);
            aZ(z);
        }
    }

    private void aZ(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.aqe == null || !this.aqe.Mz()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = x.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = ym().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aqv.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.aqv.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.apZ.getLayoutParams();
        layoutParams2.topMargin = i;
        this.apZ.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(int i) {
        TextView titleViewCenter;
        View My;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aqq) * 1.0f) / (this.aqD == 0 ? 1 : this.aqD);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.aqe != null && this.aqe.Mz() && (My = this.aqe.My()) != null && (background = My.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.aqa.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.aqC != null && this.aqC.aON && (titleViewCenter = this.aqa.getTitleViewCenter()) != null) {
            titleViewCenter.setAlpha(f);
        }
        Drawable background3 = this.aqd.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void yK() {
        this.aqr = com.baidu.swan.apps.statistic.c.gQ("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.aqr != null) {
            com.baidu.swan.apps.statistic.c.a(this.aqr, gVar);
            this.aqr = null;
        }
    }

    public void yL() {
        this.aqC.aOO = "default";
        yk();
        yJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yM() {
        if (this.apY != null) {
            this.apY.yM();
        }
    }
}
