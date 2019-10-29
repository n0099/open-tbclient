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
    private static int aNt = 10;
    private FrameLayout aKT;
    private com.baidu.swan.apps.core.f.c aNA;
    private String aNu;
    private d aNv;
    protected PullToRefreshSysWebView aNw;
    private List<g> aNx;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> aNy;
    private com.baidu.swan.apps.core.f.d aNz;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.aNx = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aIX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void DP() {
        super.DP();
        GE();
        k kVar = new k(this.aIN);
        kVar.f(this);
        this.aIN.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.Jt().c(this);
        if (this.aNv != null) {
            this.aNv.onResume();
        }
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            com.baidu.swan.apps.ae.b.QZ().Ri().bO(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.Jt().d(this);
        if (this.aNv != null) {
            this.aNv.onPause();
        }
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            com.baidu.swan.apps.ae.b.QZ().Ri().bO(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.m
    public double Ch() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.Dk()) {
            str = com.baidu.swan.apps.console.a.d.Dm();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Df()) {
            com.baidu.swan.apps.core.c.b.En();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean Ck() {
        return Cr().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.bla) {
                this.aNw = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.aNw);
                a(frameLayout, this.aNw);
            } else {
                a(frameLayout, Cr());
            }
            this.aKT = frameLayout;
            if (this.aNy == null) {
                this.aNy = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.aNw.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.i.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.LD().a(c.this.Ct(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView Cl() {
        return this.aNw;
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

    private void GE() {
        this.aNu = String.valueOf(aNt);
        aNt++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String Ct() {
        return this.aNu;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (dVar == null || this.aKT == null) {
            return false;
        }
        if (this.aNw != null) {
            this.aNw.ce(false);
            this.aNw.setPullRefreshEnabled(false);
        }
        if (this.aNv == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.aNv = aX(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aXJ == null) {
                dVar.aXJ = com.baidu.swan.apps.model.a.a.b.Ms();
            }
            a(this.aKT, this.aNv.Cr());
            if (this.aNv.Cr() != null) {
                this.aNv.Cr().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.aNv.loadUrl(dVar.mSrc);
            this.aNv.d(dVar);
            if (this.aNz != null) {
                this.aNz.a(this.aNv);
            }
            if (this.aNA != null) {
                this.aNv.a(this.aNA);
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
        if (this.aNv != null) {
            this.aNv.loadUrl(dVar.mSrc);
            this.aNv.d(dVar);
            if (dVar.aXJ == null) {
                dVar.aXJ = com.baidu.swan.apps.model.a.a.b.Ms();
            }
            if (this.aNv.Cr() != null) {
                this.aNv.Cr().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.aNv != null) {
            if (this.aNz != null) {
                this.aNz.b(this.aNv);
            }
            if (this.aNA != null) {
                this.aNA = null;
            }
            c(this.aKT, this.aNv.Cr());
            this.aNv.d(dVar);
            this.aNv.destroy();
            this.aNv = null;
            if (this.aNw != null) {
                this.aNw.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean Cn() {
        if (this.aNv == null || !this.aNv.Cr().canGoBack()) {
            return false;
        }
        this.aNv.Cr().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.aNx.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.aNx.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g dO(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.aNx.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.aHe)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.k.d) null);
        Co();
        com.baidu.swan.apps.camera.a.CD().dU(this.aNu);
        GF();
        super.destroy();
        this.aNx.clear();
        com.baidu.swan.apps.u.a.Jt().e(this);
        com.baidu.swan.apps.media.b.cI(this.aNu);
        if (this.aNy != null) {
            this.aNy.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void Co() {
        Activity activity;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && (activity = QZ.getActivity()) != null) {
            p.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void GF() {
        com.baidu.swan.apps.textarea.c.b iG = com.baidu.swan.apps.textarea.c.a.TI().iG(this.aNu);
        if (iG != null) {
            iG.iI(this.aNu);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void cJ(int i) {
        Cr().setVisibility(i);
        if (this.aNy != null) {
            this.aNy.fI(i);
        }
        if (Cl() != null) {
            Cl().setVisibility(i);
        }
        if (this.aNv != null && this.aNv.Cr() != null) {
            com.baidu.swan.apps.scheme.actions.k.d Cu = this.aNv.Cu();
            this.aNv.Cr().setVisibility(i == 0 && Cu != null && !Cu.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a Cp() {
        return this.aNy;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.aNz = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.aNA = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean cK(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.aNw.getHeaderLoadingLayout();
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
    /* renamed from: GG */
    public d Cm() {
        return this.aNv;
    }
}
