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
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class d extends b implements a.InterfaceC0208a {
    private static String aKG;
    private FrameLayout aKB;
    private com.baidu.swan.apps.b.c.c aKC;
    private com.baidu.swan.apps.tabbar.b.a aKD;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKH;
    private com.baidu.swan.apps.ae.a.d aKI;
    private com.baidu.swan.apps.core.f.b aKK;
    private Flow aKx;
    private String aKy;
    private String aKz;
    private View mRootView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int aKw = z.S(149.0f);
    public static String aKE = LivenessStat.TYPE_STRING_DEFAULT;
    public static String aKF = aKE;
    private Map<String, com.baidu.swan.apps.b.c.c> aKA = new TreeMap();
    private int aKJ = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EX();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.au("route", "fragment create.");
    }

    private void EX() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aKe = com.baidu.swan.apps.model.c.gb(arguments.getString("ai_apps_param"));
            this.aKy = this.aKe != null ? this.aKe.getPage() : "";
            this.aKz = this.aKe != null ? this.aKe.getParams() : "";
            this.aKI = com.baidu.swan.apps.w.e.LE().fM(TextUtils.isEmpty(this.aKy) ? "" : this.aKy);
            this.aKJ = EN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        com.baidu.swan.apps.performance.e.au("route", "fragment onCreateView.");
        View inflate = layoutInflater.inflate(a.g.aiapps_fragment, viewGroup, false);
        this.aKB = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        U(inflate);
        this.aKD = new com.baidu.swan.apps.tabbar.b.a(this);
        Z(inflate);
        this.mRootView = a(EJ() ? Y(inflate) : inflate, this);
        this.aKm.setRegionFactor(this.aKC.Ci());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Cm() {
        if (this.aKC != null) {
            return this.aKC.Cm();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        bv(EG());
        if (Fa()) {
            EF();
        }
        Fn();
        this.aKg.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void aa(View view2) {
                String Cu = d.this.aKC.Cu();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aW(Cu, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.LE().a(Cu, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
        this.aKC.Cp();
        Eu();
        this.aKh.a(com.baidu.swan.apps.u.a.JE().Kd(), ES(), ET());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void ED() {
        EU();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void da(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.aKI)) {
            super.da(i);
            return;
        }
        if (!Fk() && u.bN(this.mActivity)) {
            z = false;
        }
        n(i, z);
        Fn();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean cY(int i) {
        boolean cY = super.cY(i);
        Fn();
        return cY;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EM() {
        super.EM();
        Fn();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.Jm().Bi()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Jm().Bi()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.Jm().Bi()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.Jm().Bi()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.aKC.Cu())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.aKC.Cu())));
        }
    }

    public static void ew(String str) {
        aKG = str;
    }

    private void EY() {
        if (!TextUtils.equals(aKF, this.aKC.Cu()) || TextUtils.equals(aKG, "switchTab")) {
            int iD = this.aKD.iD(Ff());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.aPI = aKF;
            eVar.aPJ = this.aKC.Cu();
            eVar.aKX = aKG;
            eVar.aPK = this.aKy;
            eVar.aPL = String.valueOf(iD);
            aKG = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.aPI + " ,toId: " + eVar.aPJ + " ,RouteType: " + eVar.aKX + " page:" + eVar.aPK + ",TabIndex: " + eVar.aPL);
            }
            com.baidu.swan.apps.w.e.LE().a(eVar);
            aKF = this.aKC.Cu();
        }
    }

    private void ex(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.aKC.Cu());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.aKC.Cu());
        }
        com.baidu.swan.apps.w.e.LE().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EV() {
        if (this.aKC == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aKC.Cu());
        com.baidu.swan.apps.b.c.f Cn = this.aKC.Cn();
        if (Cn != null) {
            hashMap.put("webViewUrl", Cn.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void Z(View view) {
        com.baidu.swan.apps.performance.e.au("route", "createSlaveWebView start.");
        String Ln = this.aKe.Ln();
        String params = this.aKe.getParams();
        String page = this.aKe.getPage();
        String B = ac.B(Ln, page, params);
        this.aKC = com.baidu.swan.apps.core.i.b.eG(B);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + B + " is load: " + (this.aKC != null));
        }
        if (this.aKC == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.aKC = p(Ln, page, params);
        }
        this.aKC.a(this.aKB, com.baidu.swan.apps.w.e.LE().fM(page));
        eB(page);
        a(this.aKC);
        if (Ew()) {
            this.aKA.put(page, this.aKC);
            this.aKD.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.au("route", "createSlaveWebView end.");
        Fo();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aKA != null && !this.aKA.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.aKA.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.aKA.clear();
        } else if (this.aKC != null) {
            b(this.aKC);
            this.aKC.destroy();
        }
        this.aKC = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.i.b.y(com.baidu.swan.apps.w.e.LE().Lq());
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
        boolean z = this.aKC == null;
        String Cu = z ? "" : this.aKC.Cu();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + Cu);
        }
        if (!z) {
            this.aKC.onResume();
            EY();
            ex("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.u(Cu, true);
        if (com.baidu.swan.apps.console.c.Dg()) {
            com.baidu.swan.apps.core.c.b.Eo();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Cm;
        boolean z = this.aKC == null;
        String Cu = z ? "" : this.aKC.Cu();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + Cu);
        }
        if (!z) {
            this.aKC.onPause();
            ex("onHide");
        }
        if (AE() != null) {
            AE().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.u(Cu, false);
        if (!z && (Cm = this.aKC.Cm()) != null) {
            Cm.ce(false);
        }
    }

    public String ey(String str) {
        if (this.aKA.containsKey(str)) {
            return this.aKA.get(str).Cu();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.aKD.iA(bVar.aSM);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.aKA.get(bVar.aSM) == null) {
            String B = ac.B(bVar.mBaseUrl, bVar.aSM, bVar.mParams);
            com.baidu.swan.apps.b.c.c eG = com.baidu.swan.apps.core.i.b.eG(B);
            if (eG != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + B);
                }
                this.aKA.put(bVar.aSM, eG);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                eG = p(bVar.mBaseUrl, bVar.aSM, bVar.mParams);
                this.aKA.put(bVar.aSM, eG);
            }
            eB(bVar.aSM);
            a(eG);
        }
    }

    private com.baidu.swan.apps.b.c.c p(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a z = com.baidu.swan.apps.core.i.b.z(abT());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + z);
        }
        com.baidu.swan.apps.core.i.b.a(z, new b.InterfaceC0175b() { // from class: com.baidu.swan.apps.core.d.d.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0175b
            public void onReady() {
                com.baidu.swan.apps.core.j.b bVar = new com.baidu.swan.apps.core.j.b();
                bVar.aNz = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.aNG = str2 + "?" + str3;
                } else {
                    bVar.aNG = str2;
                }
                bVar.aNH = com.baidu.swan.apps.w.e.LE().fM(str2).bkJ;
                bVar.aND = String.valueOf(com.baidu.swan.apps.console.a.Dd());
                if (com.baidu.swan.apps.ae.b.Ra() != null) {
                    String hr = com.baidu.swan.apps.ae.b.Ra().hr(str2);
                    if (!TextUtils.isEmpty(hr)) {
                        bVar.aNI = hr;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + hr);
                        }
                    }
                }
                bVar.aNF = d.DEBUG || com.baidu.swan.apps.w.e.LE().Ll();
                com.baidu.swan.apps.w.e.LE().a(z.aMY.Cu(), com.baidu.swan.apps.core.j.b.b(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return z.aMY;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.aSM;
        com.baidu.swan.apps.ae.a.d fM = com.baidu.swan.apps.w.e.LE().fM(TextUtils.isEmpty(str) ? "" : str);
        this.aKy = str;
        this.aKz = this.aKz != null ? this.aKe.getParams() : "";
        this.aKI = fM;
        if (eA(str)) {
            ez(str);
        } else {
            b(bVar);
            ez(str);
        }
        eu(fM.bkF);
        ev(fM.bkG);
        cY(fM.bkE);
        Fn();
        Fq();
    }

    private void ez(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.aKA.get(str);
        if (this.aKC != cVar) {
            if (!cVar.Cl()) {
                cVar.a(this.aKB, com.baidu.swan.apps.w.e.LE().fM(str));
            }
            cVar.cJ(0);
            if (this.aKC != null) {
                this.aKC.cJ(8);
            }
            this.aKC = cVar;
        }
    }

    public FrameLayout EZ() {
        return this.aKB;
    }

    private boolean eA(String str) {
        return (this.aKA.isEmpty() || this.aKA.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.Mp());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return EG() && this.aKC.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        com.baidu.swan.apps.ae.a.c Lm;
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        if (LE == null || (Lm = LE.Lm()) == null || !Lm.Rx() || this.aKe == null) {
            return false;
        }
        return Lm.hv(this.aKe.getPage());
    }

    protected final boolean Fa() {
        com.baidu.swan.apps.ae.a.c Lm;
        e AI = AI();
        if (AI == null) {
            return false;
        }
        return ((this.aKI != null && this.aKI.bkN) || (Lm = com.baidu.swan.apps.w.e.LE().Lm()) == null || a(AI, Lm)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b dc = eVar.dc(0);
        if (dc == null || !(dc instanceof d)) {
            return false;
        }
        String Ff = ((d) dc).Ff();
        return cVar.hv(Ff) || TextUtils.equals(cVar.Lp(), Ff);
    }

    private boolean Fb() {
        com.baidu.swan.apps.ae.a.c Lm = com.baidu.swan.apps.w.e.LE().Lm();
        return (Lm == null || TextUtils.equals(Lm.Lp(), this.aKy)) ? false : true;
    }

    public String Fc() {
        return this.aKC != null ? this.aKC.Cu() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        if (com.baidu.swan.apps.aa.a.Ni()) {
            return true;
        }
        if (this.aKC != null) {
            if (com.baidu.swan.apps.media.b.fQ(this.aKC.Cu())) {
                return true;
            }
            return this.aKC.Co();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Eu() {
        FragmentActivity abT = abT();
        if (abT != null && this.aKh == null) {
            this.aKh = new com.baidu.swan.menu.g(abT, this.aKg, Fb() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.aKh.setStatisticSource("tool");
            this.aKh.setMenuSource("swan");
            this.aKh.a(com.baidu.swan.apps.u.a.Jn());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKh, this).Vl();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> Fd() {
        if (this.aKC == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.aKC.Cs().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Fe() {
        return this.aKD;
    }

    public String Ff() {
        return this.aKy;
    }

    public String Fg() {
        return this.aKz;
    }

    public com.baidu.swan.apps.b.c.c Fh() {
        return this.aKC;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0208a
    public com.baidu.swan.apps.res.widget.floatlayer.a AE() {
        if (this.aKH == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aKH = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), EN().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aKH;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.ae.a.d EK() {
        return this.aKI;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Fi() {
        return this.aKk;
    }

    private boolean Fj() {
        return this.aKI != null && this.aKI.bkK;
    }

    private boolean Fk() {
        if (this.aKI == null) {
            return false;
        }
        return TextUtils.equals(this.aKI.bkM, "custom");
    }

    private void eB(String str) {
        if (!Fk()) {
            com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (LE.fM(str).bkK && this.aKK == null) {
                this.aKK = new com.baidu.swan.apps.core.f.b() { // from class: com.baidu.swan.apps.core.d.d.3
                    @Override // com.baidu.swan.apps.core.f.b
                    public void onScrollChanged(int i, int i2, int i3, int i4) {
                        d.this.db(i2);
                    }
                };
            }
        }
    }

    private void a(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            if (this.aKK != null) {
                cVar.a(this.aKK);
            }
            cVar.a(Fl());
        }
    }

    private com.baidu.swan.apps.core.f.d Fl() {
        return new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.core.d.d.4
            @Override // com.baidu.swan.apps.core.f.d
            public void a(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.aKK);
                    fVar.a(d.this.Fm());
                }
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void b(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.aKK);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Fm() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void dc(String str) {
                if (d.this.aKg != null) {
                    d.this.aKg.setTitle(str);
                }
            }
        };
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.aKK != null && cVar != null) {
            cVar.b(this.aKK);
            if (cVar.Cn() != null) {
                cVar.b(this.aKK);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Fn() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.aKg != null) {
            if (Fk()) {
                bx(true);
                i = 0;
                z = true;
            } else if (Fj()) {
                bx(false);
                if (this.aKC != null) {
                    if (this.aKC.Cn() != null) {
                        dVar = this.aKC.Cn().Cs();
                    } else {
                        dVar = this.aKC.Cs();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.aKI == null && this.aKI.bkL) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.aKI == null) {
                }
                z = true;
            } else {
                bx(false);
                i = aKw + this.aKJ;
            }
            TextView centerTitleView = this.aKg.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            db(i);
            by(z);
        }
    }

    private void by(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.aKk == null || !this.aKk.UR()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = z.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = EN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aKB.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.aKB.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.aKf.getLayoutParams();
        layoutParams2.topMargin = i;
        this.aKf.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i) {
        TextView centerTitleView;
        View UQ;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aKw) * 1.0f) / (this.aKJ == 0 ? 1 : this.aKJ);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.aKk != null && this.aKk.UR() && (UQ = this.aKk.UQ()) != null && (background = UQ.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.aKg.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.aKI != null && this.aKI.bkL && (centerTitleView = this.aKg.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.aKj.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Fo() {
        this.aKx = com.baidu.swan.apps.statistic.e.hW("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.aKx != null) {
            com.baidu.swan.apps.statistic.e.a(this.aKx, gVar);
            this.aKx = null;
        }
    }

    public void Fp() {
        this.aKI.bkM = "default";
        EL();
        Fn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Fq() {
        if (this.aKe != null) {
            this.aKe.Fq();
        }
    }
}
