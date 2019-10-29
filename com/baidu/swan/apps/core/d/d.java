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
public class d extends b implements a.InterfaceC0213a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int aKO = z.S(149.0f);
    public static String aKW = LivenessStat.TYPE_STRING_DEFAULT;
    public static String aKX = aKW;
    private static String aKY;
    private Flow aKP;
    private String aKQ;
    private String aKR;
    private FrameLayout aKT;
    private com.baidu.swan.apps.b.c.c aKU;
    private com.baidu.swan.apps.tabbar.b.a aKV;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKZ;
    private com.baidu.swan.apps.ae.a.d aLa;
    private com.baidu.swan.apps.core.f.b aLc;
    private View mRootView;
    private Map<String, com.baidu.swan.apps.b.c.c> aKS = new TreeMap();
    private int aLb = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EW();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.au("route", "fragment create.");
    }

    private void EW() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aKw = com.baidu.swan.apps.model.c.gb(arguments.getString("ai_apps_param"));
            this.aKQ = this.aKw != null ? this.aKw.getPage() : "";
            this.aKR = this.aKw != null ? this.aKw.getParams() : "";
            this.aLa = com.baidu.swan.apps.w.e.LD().fM(TextUtils.isEmpty(this.aKQ) ? "" : this.aKQ);
            this.aLb = EM().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.aKT = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        U(inflate);
        this.aKV = new com.baidu.swan.apps.tabbar.b.a(this);
        Z(inflate);
        this.mRootView = a(EI() ? Y(inflate) : inflate, this);
        this.aKE.setRegionFactor(this.aKU.Ch());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView Cl() {
        if (this.aKU != null) {
            return this.aKU.Cl();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        bv(EF());
        if (EZ()) {
            EE();
        }
        Fm();
        this.aKy.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void aa(View view2) {
                String Ct = d.this.aKU.Ct();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aW(Ct, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.LD().a(Ct, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        this.aKU.Co();
        Et();
        this.aKz.a(com.baidu.swan.apps.u.a.JD().Kc(), ER(), ES());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void EC() {
        ET();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void da(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.aLa)) {
            super.da(i);
            return;
        }
        if (!Fj() && u.bN(this.mActivity)) {
            z = false;
        }
        n(i, z);
        Fm();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean cY(int i) {
        boolean cY = super.cY(i);
        Fm();
        return cY;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EL() {
        super.EL();
        Fm();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.Jl().Bh()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Jl().Bh()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.Jl().Bh()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.Jl().Bh()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.aKU.Ct())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.aKU.Ct())));
        }
    }

    public static void ew(String str) {
        aKY = str;
    }

    private void EX() {
        if (!TextUtils.equals(aKX, this.aKU.Ct()) || TextUtils.equals(aKY, "switchTab")) {
            int iD = this.aKV.iD(Fe());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.aQa = aKX;
            eVar.aQb = this.aKU.Ct();
            eVar.aLp = aKY;
            eVar.aQc = this.aKQ;
            eVar.aQd = String.valueOf(iD);
            aKY = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.aQa + " ,toId: " + eVar.aQb + " ,RouteType: " + eVar.aLp + " page:" + eVar.aQc + ",TabIndex: " + eVar.aQd);
            }
            com.baidu.swan.apps.w.e.LD().a(eVar);
            aKX = this.aKU.Ct();
        }
    }

    private void ex(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.aKU.Ct());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.aKU.Ct());
        }
        com.baidu.swan.apps.w.e.LD().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void EU() {
        if (this.aKU == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.aKU.Ct());
        com.baidu.swan.apps.b.c.f Cm = this.aKU.Cm();
        if (Cm != null) {
            hashMap.put("webViewUrl", Cm.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void Z(View view) {
        com.baidu.swan.apps.performance.e.au("route", "createSlaveWebView start.");
        String Lm = this.aKw.Lm();
        String params = this.aKw.getParams();
        String page = this.aKw.getPage();
        String B = ac.B(Lm, page, params);
        this.aKU = com.baidu.swan.apps.core.i.b.eG(B);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + B + " is load: " + (this.aKU != null));
        }
        if (this.aKU == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.aKU = p(Lm, page, params);
        }
        this.aKU.a(this.aKT, com.baidu.swan.apps.w.e.LD().fM(page));
        eB(page);
        a(this.aKU);
        if (Ev()) {
            this.aKS.put(page, this.aKU);
            this.aKV.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.au("route", "createSlaveWebView end.");
        Fn();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aKS != null && !this.aKS.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.aKS.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.aKS.clear();
        } else if (this.aKU != null) {
            b(this.aKU);
            this.aKU.destroy();
        }
        this.aKU = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.i.b.y(com.baidu.swan.apps.w.e.LD().Lp());
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
        boolean z = this.aKU == null;
        String Ct = z ? "" : this.aKU.Ct();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + Ct);
        }
        if (!z) {
            this.aKU.onResume();
            EX();
            ex("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.u(Ct, true);
        if (com.baidu.swan.apps.console.c.Df()) {
            com.baidu.swan.apps.core.c.b.En();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView Cl;
        boolean z = this.aKU == null;
        String Ct = z ? "" : this.aKU.Ct();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + Ct);
        }
        if (!z) {
            this.aKU.onPause();
            ex("onHide");
        }
        if (AD() != null) {
            AD().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.u(Ct, false);
        if (!z && (Cl = this.aKU.Cl()) != null) {
            Cl.ce(false);
        }
    }

    public String ey(String str) {
        if (this.aKS.containsKey(str)) {
            return this.aKS.get(str).Ct();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.aKV.iA(bVar.aTe);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.aKS.get(bVar.aTe) == null) {
            String B = ac.B(bVar.mBaseUrl, bVar.aTe, bVar.mParams);
            com.baidu.swan.apps.b.c.c eG = com.baidu.swan.apps.core.i.b.eG(B);
            if (eG != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + B);
                }
                this.aKS.put(bVar.aTe, eG);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                eG = p(bVar.mBaseUrl, bVar.aTe, bVar.mParams);
                this.aKS.put(bVar.aTe, eG);
            }
            eB(bVar.aTe);
            a(eG);
        }
    }

    private com.baidu.swan.apps.b.c.c p(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a z = com.baidu.swan.apps.core.i.b.z(abV());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + z);
        }
        com.baidu.swan.apps.core.i.b.a(z, new b.InterfaceC0180b() { // from class: com.baidu.swan.apps.core.d.d.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0180b
            public void onReady() {
                com.baidu.swan.apps.core.j.b bVar = new com.baidu.swan.apps.core.j.b();
                bVar.aNR = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.aNY = str2 + "?" + str3;
                } else {
                    bVar.aNY = str2;
                }
                bVar.aNZ = com.baidu.swan.apps.w.e.LD().fM(str2).blb;
                bVar.aNV = String.valueOf(com.baidu.swan.apps.console.a.Dc());
                if (com.baidu.swan.apps.ae.b.QZ() != null) {
                    String hr = com.baidu.swan.apps.ae.b.QZ().hr(str2);
                    if (!TextUtils.isEmpty(hr)) {
                        bVar.aOa = hr;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + hr);
                        }
                    }
                }
                bVar.aNX = d.DEBUG || com.baidu.swan.apps.w.e.LD().Lk();
                com.baidu.swan.apps.w.e.LD().a(z.aNq.Ct(), com.baidu.swan.apps.core.j.b.b(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return z.aNq;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.aTe;
        com.baidu.swan.apps.ae.a.d fM = com.baidu.swan.apps.w.e.LD().fM(TextUtils.isEmpty(str) ? "" : str);
        this.aKQ = str;
        this.aKR = this.aKR != null ? this.aKw.getParams() : "";
        this.aLa = fM;
        if (eA(str)) {
            ez(str);
        } else {
            b(bVar);
            ez(str);
        }
        eu(fM.bkX);
        ev(fM.bkY);
        cY(fM.bkW);
        Fm();
        Fp();
    }

    private void ez(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.aKS.get(str);
        if (this.aKU != cVar) {
            if (!cVar.Ck()) {
                cVar.a(this.aKT, com.baidu.swan.apps.w.e.LD().fM(str));
            }
            cVar.cJ(0);
            if (this.aKU != null) {
                this.aKU.cJ(8);
            }
            this.aKU = cVar;
        }
    }

    public FrameLayout EY() {
        return this.aKT;
    }

    private boolean eA(String str) {
        return (this.aKS.isEmpty() || this.aKS.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.Mo());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return EF() && this.aKU.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        com.baidu.swan.apps.ae.a.c Ll;
        com.baidu.swan.apps.w.e LD = com.baidu.swan.apps.w.e.LD();
        if (LD == null || (Ll = LD.Ll()) == null || !Ll.Rv() || this.aKw == null) {
            return false;
        }
        return Ll.hv(this.aKw.getPage());
    }

    protected final boolean EZ() {
        com.baidu.swan.apps.ae.a.c Ll;
        e AH = AH();
        if (AH == null) {
            return false;
        }
        return ((this.aLa != null && this.aLa.blf) || (Ll = com.baidu.swan.apps.w.e.LD().Ll()) == null || a(AH, Ll)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b dc = eVar.dc(0);
        if (dc == null || !(dc instanceof d)) {
            return false;
        }
        String Fe = ((d) dc).Fe();
        return cVar.hv(Fe) || TextUtils.equals(cVar.Lo(), Fe);
    }

    private boolean Fa() {
        com.baidu.swan.apps.ae.a.c Ll = com.baidu.swan.apps.w.e.LD().Ll();
        return (Ll == null || TextUtils.equals(Ll.Lo(), this.aKQ)) ? false : true;
    }

    public String Fb() {
        return this.aKU != null ? this.aKU.Ct() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        if (com.baidu.swan.apps.aa.a.Nh()) {
            return true;
        }
        if (this.aKU != null) {
            if (com.baidu.swan.apps.media.b.fQ(this.aKU.Ct())) {
                return true;
            }
            return this.aKU.Cn();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void Et() {
        FragmentActivity abV = abV();
        if (abV != null && this.aKz == null) {
            this.aKz = new com.baidu.swan.menu.g(abV, this.aKy, Fa() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.aKz.setStatisticSource("tool");
            this.aKz.setMenuSource("swan");
            this.aKz.a(com.baidu.swan.apps.u.a.Jm());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKz, this).Vn();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> Fc() {
        if (this.aKU == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.aKU.Cr().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Fd() {
        return this.aKV;
    }

    public String Fe() {
        return this.aKQ;
    }

    public String Ff() {
        return this.aKR;
    }

    public com.baidu.swan.apps.b.c.c Fg() {
        return this.aKU;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0213a
    public com.baidu.swan.apps.res.widget.floatlayer.a AD() {
        if (this.aKZ == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.aKZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), EM().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.aKZ;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.ae.a.d EJ() {
        return this.aLa;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Fh() {
        return this.aKC;
    }

    private boolean Fi() {
        return this.aLa != null && this.aLa.blc;
    }

    private boolean Fj() {
        if (this.aLa == null) {
            return false;
        }
        return TextUtils.equals(this.aLa.ble, "custom");
    }

    private void eB(String str) {
        if (!Fj()) {
            com.baidu.swan.apps.w.e LD = com.baidu.swan.apps.w.e.LD();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (LD.fM(str).blc && this.aLc == null) {
                this.aLc = new com.baidu.swan.apps.core.f.b() { // from class: com.baidu.swan.apps.core.d.d.3
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
            if (this.aLc != null) {
                cVar.a(this.aLc);
            }
            cVar.a(Fk());
        }
    }

    private com.baidu.swan.apps.core.f.d Fk() {
        return new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.core.d.d.4
            @Override // com.baidu.swan.apps.core.f.d
            public void a(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.aLc);
                    fVar.a(d.this.Fl());
                }
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void b(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.aLc);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Fl() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void dc(String str) {
                if (d.this.aKy != null) {
                    d.this.aKy.setTitle(str);
                }
            }
        };
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.aLc != null && cVar != null) {
            cVar.b(this.aLc);
            if (cVar.Cm() != null) {
                cVar.b(this.aLc);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void Fm() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.aKy != null) {
            if (Fj()) {
                bx(true);
                i = 0;
                z = true;
            } else if (Fi()) {
                bx(false);
                if (this.aKU != null) {
                    if (this.aKU.Cm() != null) {
                        dVar = this.aKU.Cm().Cr();
                    } else {
                        dVar = this.aKU.Cr();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.aLa == null && this.aLa.bld) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.aLa == null) {
                }
                z = true;
            } else {
                bx(false);
                i = aKO + this.aLb;
            }
            TextView centerTitleView = this.aKy.getCenterTitleView();
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
            if (this.aKC == null || !this.aKC.UT()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = z.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = EM().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aKT.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.aKT.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.aKx.getLayoutParams();
        layoutParams2.topMargin = i;
        this.aKx.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i) {
        TextView centerTitleView;
        View US;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aKO) * 1.0f) / (this.aLb == 0 ? 1 : this.aLb);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.aKC != null && this.aKC.UT() && (US = this.aKC.US()) != null && (background = US.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.aKy.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.aLa != null && this.aLa.bld && (centerTitleView = this.aKy.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.aKB.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Fn() {
        this.aKP = com.baidu.swan.apps.statistic.e.hW("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.aKP != null) {
            com.baidu.swan.apps.statistic.e.a(this.aKP, gVar);
            this.aKP = null;
        }
    }

    public void Fo() {
        this.aLa.ble = "default";
        EK();
        Fm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Fp() {
        if (this.aKw != null) {
            this.aKw.Fp();
        }
    }
}
