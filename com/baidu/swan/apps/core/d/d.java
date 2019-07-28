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
public class d extends b implements a.InterfaceC0172a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int aqZ = z.ad(149.0f);
    public static String arh = LivenessStat.TYPE_STRING_DEFAULT;
    public static String ari = arh;
    private static String arj;
    private Flow ara;
    private String arb;
    private String arc;
    private FrameLayout are;
    private com.baidu.swan.apps.b.c.c arf;
    private com.baidu.swan.apps.tabbar.b.a arg;
    private com.baidu.swan.apps.res.widget.floatlayer.a ark;
    private com.baidu.swan.apps.ae.a.d arl;
    private com.baidu.swan.apps.core.f.b arn;
    private View mRootView;
    private Map<String, com.baidu.swan.apps.b.c.c> ard = new TreeMap();
    private int arm = 0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zX();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        com.baidu.swan.apps.performance.e.am("route", "fragment create.");
    }

    private void zX() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aqI = com.baidu.swan.apps.model.c.fv(arguments.getString("ai_apps_param"));
            this.arb = this.aqI != null ? this.aqI.getPage() : "";
            this.arc = this.aqI != null ? this.aqI.getParams() : "";
            this.arl = com.baidu.swan.apps.w.e.GF().fd(TextUtils.isEmpty(this.arb) ? "" : this.arb);
            this.arm = zN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
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
        this.are = (FrameLayout) inflate.findViewById(a.f.ai_apps_fragment_content);
        O(inflate);
        this.arg = new com.baidu.swan.apps.tabbar.b.a(this);
        T(inflate);
        this.mRootView = a(zJ() ? S(inflate) : inflate, this);
        this.aqQ.setRegionFactor(this.arf.xj());
        return this.mRootView;
    }

    public PullToRefreshBaseWebView xn() {
        if (this.arf != null) {
            return this.arf.xn();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        super.O(view);
        bd(zG());
        if (Aa()) {
            zF();
        }
        An();
        this.aqK.setOnDoubleClickListener(new SwanAppActionBar.b() { // from class: com.baidu.swan.apps.core.d.d.1
            /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
            @Override // com.baidu.swan.apps.view.SwanAppActionBar.b
            public void U(View view2) {
                String xv = d.this.arf.xv();
                com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
                fVar.mData = com.baidu.swan.apps.view.container.c.d.aP(xv, "scrollViewBackToTop");
                com.baidu.swan.apps.w.e.GF().a(xv, fVar);
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
        this.arf.xq();
        zu();
        this.aqL.a(com.baidu.swan.apps.u.a.EF().Fe(), zS(), zT());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zD() {
        zU();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "bar";
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void cd(int i) {
        boolean z = true;
        if (!com.baidu.swan.apps.ae.a.d.a(this.arl)) {
            super.cd(i);
            return;
        }
        if (!Ak() && u.bM(this.mActivity)) {
            z = false;
        }
        l(i, z);
        An();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean cb(int i) {
        boolean cb = super.cb(i);
        An();
        return cb;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zM() {
        super.zM();
        An();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!com.baidu.swan.apps.u.a.En().wj()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!com.baidu.swan.apps.u.a.En().wj()) {
            performPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.baidu.swan.apps.u.a.En().wj()) {
            performResume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.baidu.swan.apps.u.a.En().wj()) {
            performPause();
        }
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.arf.xv())));
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
        if (DEBUG) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.arf.xv())));
        }
    }

    public static void dM(String str) {
        arj = str;
    }

    private void zY() {
        if (!TextUtils.equals(ari, this.arf.xv()) || TextUtils.equals(arj, "switchTab")) {
            int hX = this.arg.hX(Af());
            com.baidu.swan.apps.m.a.e eVar = new com.baidu.swan.apps.m.a.e();
            eVar.awn = ari;
            eVar.awo = this.arf.xv();
            eVar.arA = arj;
            eVar.awp = this.arb;
            eVar.awq = String.valueOf(hX);
            arj = "";
            if (DEBUG) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.awn + " ,toId: " + eVar.awo + " ,RouteType: " + eVar.arA + " page:" + eVar.awp + ",TabIndex: " + eVar.awq);
            }
            com.baidu.swan.apps.w.e.GF().a(eVar);
            ari = this.arf.xv();
        }
    }

    private void dN(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.arf.xv());
        com.baidu.swan.apps.m.a.c cVar = new com.baidu.swan.apps.m.a.c(hashMap);
        if (DEBUG) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.arf.xv());
        }
        com.baidu.swan.apps.w.e.GF().a(cVar);
    }

    @Override // com.baidu.swan.apps.core.d.b
    public void zV() {
        if (this.arf == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.arf.xv());
        com.baidu.swan.apps.b.c.f xo = this.arf.xo();
        if (xo != null) {
            hashMap.put("webViewUrl", xo.getCurrentPageUrl());
        }
        com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.b("sharebtn", hashMap));
    }

    private void T(View view) {
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView start.");
        String Go = this.aqI.Go();
        String params = this.aqI.getParams();
        String page = this.aqI.getPage();
        String x = ac.x(Go, page, params);
        this.arf = com.baidu.swan.apps.core.i.b.dX(x);
        if (DEBUG) {
            Log.d("SwanAppFragment", "pageUrl: " + x + " is load: " + (this.arf != null));
        }
        if (this.arf == null) {
            if (DEBUG) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.arf = l(Go, page, params);
        }
        this.arf.a(this.are, com.baidu.swan.apps.w.e.GF().fd(page));
        dR(page);
        a(this.arf);
        if (zw()) {
            this.ard.put(page, this.arf);
            this.arg.a(view, getContext(), page);
        }
        com.baidu.swan.apps.performance.e.am("route", "createSlaveWebView end.");
        Ao();
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ard != null && !this.ard.isEmpty()) {
            for (com.baidu.swan.apps.b.c.c cVar : this.ard.values()) {
                if (cVar != null) {
                    b(cVar);
                    cVar.destroy();
                }
            }
            this.ard.clear();
        } else if (this.arf != null) {
            b(this.arf);
            this.arf.destroy();
        }
        this.arf = null;
        super.onDestroy();
        if (DEBUG) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        com.baidu.swan.apps.core.i.b.z(com.baidu.swan.apps.w.e.GF().Gr());
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
        boolean z = this.arf == null;
        String xv = z ? "" : this.arf.xv();
        if (DEBUG) {
            Log.d("SwanAppFragment", "resume() wvID: " + xv);
        }
        if (!z) {
            this.arf.onResume();
            zY();
            dN("onShow");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onShow");
        com.baidu.swan.apps.media.b.r(xv, true);
        if (com.baidu.swan.apps.console.c.yg()) {
            com.baidu.swan.apps.core.c.b.zo();
        }
    }

    public void pause() {
        PullToRefreshBaseWebView xn;
        boolean z = this.arf == null;
        String xv = z ? "" : this.arf.xv();
        if (DEBUG) {
            Log.d("SwanAppFragment", "pause() wvID: " + xv);
        }
        if (!z) {
            this.arf.onPause();
            dN("onHide");
        }
        if (vF() != null) {
            vF().reset();
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "onHide");
        com.baidu.swan.apps.media.b.r(xv, false);
        if (!z && (xn = this.arf.xn()) != null) {
            xn.bN(false);
        }
    }

    public String dO(String str) {
        if (this.ard.containsKey(str)) {
            return this.ard.get(str).xv();
        }
        return null;
    }

    public void a(com.baidu.swan.apps.model.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        this.arg.hU(bVar.azs);
        c(bVar);
    }

    private void b(com.baidu.swan.apps.model.b bVar) {
        if (this.ard.get(bVar.azs) == null) {
            String x = ac.x(bVar.mBaseUrl, bVar.azs, bVar.mParams);
            com.baidu.swan.apps.b.c.c dX = com.baidu.swan.apps.core.i.b.dX(x);
            if (dX != null) {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + x);
                }
                this.ard.put(bVar.azs, dX);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                dX = l(bVar.mBaseUrl, bVar.azs, bVar.mParams);
                this.ard.put(bVar.azs, dX);
            }
            dR(bVar.azs);
            a(dX);
        }
    }

    private com.baidu.swan.apps.b.c.c l(final String str, final String str2, final String str3) {
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(Xc());
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + A);
        }
        com.baidu.swan.apps.core.i.b.a(A, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.d.d.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0139b
            public void onReady() {
                com.baidu.swan.apps.core.j.b bVar = new com.baidu.swan.apps.core.j.b();
                bVar.auc = str;
                if (!TextUtils.isEmpty(str3)) {
                    bVar.auj = str2 + "?" + str3;
                } else {
                    bVar.auj = str2;
                }
                bVar.auk = com.baidu.swan.apps.w.e.GF().fd(str2).aRz;
                bVar.aug = String.valueOf(com.baidu.swan.apps.console.a.yd());
                if (com.baidu.swan.apps.ae.b.Md() != null) {
                    String gL = com.baidu.swan.apps.ae.b.Md().gL(str2);
                    if (!TextUtils.isEmpty(gL)) {
                        bVar.aul = gL;
                        if (d.DEBUG) {
                            Log.d("SwanAppFragment", "add initData: " + gL);
                        }
                    }
                }
                bVar.aui = d.DEBUG || com.baidu.swan.apps.w.e.GF().Gm();
                com.baidu.swan.apps.w.e.GF().a(A.atB.xv(), com.baidu.swan.apps.core.j.b.b(bVar));
                if (d.DEBUG) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar);
                }
            }
        });
        if (DEBUG) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return A.atB;
    }

    public void c(com.baidu.swan.apps.model.b bVar) {
        String str = bVar.azs;
        com.baidu.swan.apps.ae.a.d fd = com.baidu.swan.apps.w.e.GF().fd(TextUtils.isEmpty(str) ? "" : str);
        this.arb = str;
        this.arc = this.arc != null ? this.aqI.getParams() : "";
        this.arl = fd;
        if (dQ(str)) {
            dP(str);
        } else {
            b(bVar);
            dP(str);
        }
        dK(fd.aRv);
        dL(fd.aRw);
        cb(fd.aRu);
        An();
        Aq();
    }

    private void dP(String str) {
        com.baidu.swan.apps.b.c.c cVar = this.ard.get(str);
        if (this.arf != cVar) {
            if (!cVar.xm()) {
                cVar.a(this.are, com.baidu.swan.apps.w.e.GF().fd(str));
            }
            cVar.bM(0);
            if (this.arf != null) {
                this.arf.bM(8);
            }
            this.arf = cVar;
        }
    }

    public FrameLayout zZ() {
        return this.are;
    }

    private boolean dQ(String str) {
        return (this.ard.isEmpty() || this.ard.get(str) == null) ? false : true;
    }

    public static d a(com.baidu.swan.apps.model.c cVar) {
        d dVar = new d();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.Hq());
            dVar.setArguments(bundle);
        }
        return dVar;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return zG() && this.arf.isSlidable();
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        com.baidu.swan.apps.ae.a.c Gn;
        com.baidu.swan.apps.w.e GF = com.baidu.swan.apps.w.e.GF();
        if (GF == null || (Gn = GF.Gn()) == null || !Gn.Mz() || this.aqI == null) {
            return false;
        }
        return Gn.gP(this.aqI.getPage());
    }

    protected final boolean Aa() {
        com.baidu.swan.apps.ae.a.c Gn;
        e vJ = vJ();
        if (vJ == null) {
            return false;
        }
        return ((this.arl != null && this.arl.aRD) || (Gn = com.baidu.swan.apps.w.e.GF().Gn()) == null || a(vJ, Gn)) ? false : true;
    }

    private boolean a(e eVar, com.baidu.swan.apps.ae.a.c cVar) {
        b cf = eVar.cf(0);
        if (cf == null || !(cf instanceof d)) {
            return false;
        }
        String Af = ((d) cf).Af();
        return cVar.gP(Af) || TextUtils.equals(cVar.Gq(), Af);
    }

    private boolean Ab() {
        com.baidu.swan.apps.ae.a.c Gn = com.baidu.swan.apps.w.e.GF().Gn();
        return (Gn == null || TextUtils.equals(Gn.Gq(), this.arb)) ? false : true;
    }

    public String Ac() {
        return this.arf != null ? this.arf.xv() : "";
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        if (com.baidu.swan.apps.aa.a.Ij()) {
            return true;
        }
        if (this.arf != null) {
            if (com.baidu.swan.apps.media.b.fh(this.arf.xv())) {
                return true;
            }
            return this.arf.xp();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    @DebugTrace
    protected void zu() {
        FragmentActivity Xc = Xc();
        if (Xc != null && this.aqL == null) {
            this.aqL = new com.baidu.swan.menu.g(Xc, this.aqK, Ab() ? 12 : 15, new com.baidu.swan.apps.view.b.b());
            this.aqL.setStatisticSource("tool");
            this.aqL.setMenuSource("swan");
            this.aqL.a(com.baidu.swan.apps.u.a.Eo());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqL, this).Qt();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.swan.apps.b.c.d] */
    @NonNull
    public Pair<Integer, Integer> Ad() {
        if (this.arf == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = this.arf.xt().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Nullable
    public com.baidu.swan.apps.tabbar.b.a Ae() {
        return this.arg;
    }

    public String Af() {
        return this.arb;
    }

    public String Ag() {
        return this.arc;
    }

    public com.baidu.swan.apps.b.c.c Ah() {
        return this.arf;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0172a
    public com.baidu.swan.apps.res.widget.floatlayer.a vF() {
        if (this.ark == null) {
            if (this.mRootView == null) {
                return null;
            }
            this.ark = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (LinearLayout) this.mRootView.findViewById(a.f.ai_apps_fragment_base_view), zN().getDimensionPixelOffset(a.d.aiapps_normal_base_action_bar_height));
        }
        return this.ark;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public com.baidu.swan.apps.ae.a.d zK() {
        return this.arl;
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Ai() {
        return this.aqO;
    }

    private boolean Aj() {
        return this.arl != null && this.arl.aRA;
    }

    private boolean Ak() {
        if (this.arl == null) {
            return false;
        }
        return TextUtils.equals(this.arl.aRC, "custom");
    }

    private void dR(String str) {
        if (!Ak()) {
            com.baidu.swan.apps.w.e GF = com.baidu.swan.apps.w.e.GF();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (GF.fd(str).aRA && this.arn == null) {
                this.arn = new com.baidu.swan.apps.core.f.b() { // from class: com.baidu.swan.apps.core.d.d.3
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
            if (this.arn != null) {
                cVar.a(this.arn);
            }
            cVar.a(Al());
        }
    }

    private com.baidu.swan.apps.core.f.d Al() {
        return new com.baidu.swan.apps.core.f.d() { // from class: com.baidu.swan.apps.core.d.d.4
            @Override // com.baidu.swan.apps.core.f.d
            public void a(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.a(d.this.arn);
                    fVar.a(d.this.Am());
                }
            }

            @Override // com.baidu.swan.apps.core.f.d
            public void b(com.baidu.swan.apps.b.c.f fVar) {
                if (fVar != null) {
                    fVar.b(d.this.arn);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.f.a Am() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.d.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public void de(String str) {
                if (d.this.aqK != null) {
                    d.this.aqK.setTitle(str);
                }
            }
        };
    }

    private void b(com.baidu.swan.apps.b.c.c cVar) {
        if (this.arn != null && cVar != null) {
            cVar.b(this.arn);
            if (cVar.xo() != null) {
                cVar.b(this.arn);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private void An() {
        int i;
        com.baidu.swan.apps.b.c.d dVar;
        int i2 = 1;
        boolean z = false;
        if (this.aqK != null) {
            if (Ak()) {
                bf(true);
                i = 0;
                z = true;
            } else if (Aj()) {
                bf(false);
                if (this.arf != null) {
                    if (this.arf.xo() != null) {
                        dVar = this.arf.xo().xt();
                    } else {
                        dVar = this.arf.xt();
                    }
                    if (dVar != null) {
                        i = dVar.getWebViewScrollY();
                        if (this.arl == null && this.arl.aRB) {
                            i2 = 0;
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                i = 0;
                if (this.arl == null) {
                }
                z = true;
            } else {
                bf(false);
                i = aqZ + this.arm;
            }
            TextView centerTitleView = this.aqK.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            ce(i);
            bg(z);
        }
    }

    private void bg(boolean z) {
        int dimensionPixelSize;
        int i = 0;
        if (z) {
            if (this.aqO == null || !this.aqO.PZ()) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = 0;
                i = z.getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = zN().getDimensionPixelSize(a.d.aiapps_normal_base_action_bar_height);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.are.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        this.are.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.aqJ.getLayoutParams();
        layoutParams2.topMargin = i;
        this.aqJ.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(int i) {
        TextView centerTitleView;
        View PY;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - aqZ) * 1.0f) / (this.arm == 0 ? 1 : this.arm);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (DEBUG && i2 != 0 && i2 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f + " : " + i2);
        }
        if (this.aqO != null && this.aqO.PZ() && (PY = this.aqO.PY()) != null && (background = PY.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.aqK.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.arl != null && this.arl.aRB && (centerTitleView = this.aqK.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f);
        }
        Drawable background3 = this.aqN.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }

    private void Ao() {
        this.ara = com.baidu.swan.apps.statistic.e.hr("805");
    }

    public void a(com.baidu.swan.apps.statistic.a.g gVar) {
        if (this.ara != null) {
            com.baidu.swan.apps.statistic.e.a(this.ara, gVar);
            this.ara = null;
        }
    }

    public void Ap() {
        this.arl.aRC = NotifyAdapterUtil.PRIMARY_CHANNEL;
        zL();
        An();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Aq() {
        if (this.aqI != null) {
            this.aqI.Aq();
        }
    }
}
