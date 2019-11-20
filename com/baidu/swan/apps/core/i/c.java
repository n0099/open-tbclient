package com.baidu.swan.apps.core.i;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.p;
import com.baidu.swan.apps.canvas.c.g;
import com.baidu.swan.apps.core.b;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshSysWebView;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.scheme.actions.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.core.b implements com.baidu.swan.apps.b.c.c<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aNb = 10;
    private FrameLayout aKB;
    private String aNc;
    private d aNd;
    protected PullToRefreshSysWebView aNe;
    private List<g> aNf;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> aNg;
    private com.baidu.swan.apps.core.f.d aNh;
    private com.baidu.swan.apps.core.f.c aNi;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.aNf = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aIF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void DQ() {
        super.DQ();
        GF();
        k kVar = new k(this.aIv);
        kVar.f(this);
        this.aIv.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.Ju().c(this);
        if (this.aNd != null) {
            this.aNd.onResume();
        }
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            com.baidu.swan.apps.ae.b.Ra().Rk().bO(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.Ju().d(this);
        if (this.aNd != null) {
            this.aNd.onPause();
        }
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            com.baidu.swan.apps.ae.b.Ra().Rk().bO(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.m
    public double Ci() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.Dl()) {
            str = com.baidu.swan.apps.console.a.d.Dn();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Dg()) {
            com.baidu.swan.apps.core.c.b.Eo();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean Cl() {
        return Cs().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.bkI) {
                this.aNe = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.aNe);
                a(frameLayout, this.aNe);
            } else {
                a(frameLayout, Cs());
            }
            this.aKB = frameLayout;
            if (this.aNg == null) {
                this.aNg = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.aNe.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.i.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.LE().a(c.this.Cu(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView Cm() {
        return this.aNe;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !b(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void c(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && b(viewGroup, view)) {
            viewGroup.removeView(view);
        }
    }

    private boolean b(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    private void GF() {
        this.aNc = String.valueOf(aNb);
        aNb++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String Cu() {
        return this.aNc;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (dVar == null || this.aKB == null) {
            return false;
        }
        if (this.aNe != null) {
            this.aNe.ce(false);
            this.aNe.setPullRefreshEnabled(false);
        }
        if (this.aNd == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.aNd = aX(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aXr == null) {
                dVar.aXr = com.baidu.swan.apps.model.a.a.b.Mt();
            }
            a(this.aKB, this.aNd.Cs());
            if (this.aNd.Cs() != null) {
                this.aNd.Cs().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.aNd.loadUrl(dVar.mSrc);
            this.aNd.d(dVar);
            if (this.aNh != null) {
                this.aNh.a(this.aNd);
            }
            if (this.aNi != null) {
                this.aNd.a(this.aNi);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected d aX(Context context) {
        return new d(context);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean b(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.aNd != null) {
            this.aNd.loadUrl(dVar.mSrc);
            this.aNd.d(dVar);
            if (dVar.aXr == null) {
                dVar.aXr = com.baidu.swan.apps.model.a.a.b.Mt();
            }
            if (this.aNd.Cs() != null) {
                this.aNd.Cs().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.aNd != null) {
            if (this.aNh != null) {
                this.aNh.b(this.aNd);
            }
            if (this.aNi != null) {
                this.aNi = null;
            }
            c(this.aKB, this.aNd.Cs());
            this.aNd.d(dVar);
            this.aNd.destroy();
            this.aNd = null;
            if (this.aNe != null) {
                this.aNe.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean Co() {
        if (this.aNd == null || !this.aNd.Cs().canGoBack()) {
            return false;
        }
        this.aNd.Cs().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.aNf.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.aNf.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g dO(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.aNf.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.aGM)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.k.d) null);
        Cp();
        com.baidu.swan.apps.camera.a.CE().dU(this.aNc);
        GG();
        super.destroy();
        this.aNf.clear();
        com.baidu.swan.apps.u.a.Ju().e(this);
        com.baidu.swan.apps.media.b.cI(this.aNc);
        if (this.aNg != null) {
            this.aNg.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void Cp() {
        Activity activity;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && (activity = Ra.getActivity()) != null) {
            p.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void GG() {
        com.baidu.swan.apps.textarea.c.b iG = com.baidu.swan.apps.textarea.c.a.TG().iG(this.aNc);
        if (iG != null) {
            iG.iI(this.aNc);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void cJ(int i) {
        Cs().setVisibility(i);
        if (this.aNg != null) {
            this.aNg.fH(i);
        }
        if (Cm() != null) {
            Cm().setVisibility(i);
        }
        if (this.aNd != null && this.aNd.Cs() != null) {
            com.baidu.swan.apps.scheme.actions.k.d Cv = this.aNd.Cv();
            this.aNd.Cs().setVisibility(i == 0 && Cv != null && !Cv.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a Cq() {
        return this.aNg;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.aNh = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.aNi = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean cK(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.aNe.getHeaderLoadingLayout();
        if (neutralHeaderLoadingLayout == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.cK(i);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.j.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.c
    @Nullable
    /* renamed from: GH */
    public d Cn() {
        return this.aNd;
    }
}
