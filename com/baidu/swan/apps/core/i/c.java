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
    private static int atE = 10;
    private FrameLayout are;
    private String atF;
    private d atG;
    protected PullToRefreshSysWebView atH;
    private List<g> atI;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> atJ;
    private com.baidu.swan.apps.core.f.d atK;
    private com.baidu.swan.apps.core.f.c atL;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.atI = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.api = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void yQ() {
        super.yQ();
        BG();
        k kVar = new k(this.aoY);
        kVar.f(this);
        this.aoY.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.Ev().c(this);
        if (this.atG != null) {
            this.atG.onResume();
        }
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            com.baidu.swan.apps.ae.b.Md().Mm().bw(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.Ev().d(this);
        if (this.atG != null) {
            this.atG.onPause();
        }
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            com.baidu.swan.apps.ae.b.Md().Mm().bw(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.m
    public double xj() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.yl()) {
            str = com.baidu.swan.apps.console.a.d.yn();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.yg()) {
            com.baidu.swan.apps.core.c.b.zo();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean xm() {
        return xt().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.aRy) {
                this.atH = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.atH);
                a(frameLayout, this.atH);
            } else {
                a(frameLayout, xt());
            }
            this.are = frameLayout;
            if (this.atJ == null) {
                this.atJ = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.atH.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.i.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.GF().a(c.this.xv(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView xn() {
        return this.atH;
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

    private void BG() {
        this.atF = String.valueOf(atE);
        atE++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String xv() {
        return this.atF;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (dVar == null || this.are == null) {
            return false;
        }
        if (this.atH != null) {
            this.atH.bN(false);
            this.atH.setPullRefreshEnabled(false);
        }
        if (this.atG == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.atG = aV(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aDW == null) {
                dVar.aDW = com.baidu.swan.apps.model.a.a.b.Hu();
            }
            a(this.are, this.atG.xt());
            if (this.atG.xt() != null) {
                this.atG.xt().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.atG.loadUrl(dVar.mSrc);
            this.atG.d(dVar);
            if (this.atK != null) {
                this.atK.a(this.atG);
            }
            if (this.atL != null) {
                this.atG.a(this.atL);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected d aV(Context context) {
        return new d(context);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean b(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.atG != null) {
            this.atG.loadUrl(dVar.mSrc);
            this.atG.d(dVar);
            if (dVar.aDW == null) {
                dVar.aDW = com.baidu.swan.apps.model.a.a.b.Hu();
            }
            if (this.atG.xt() != null) {
                this.atG.xt().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.atG != null) {
            if (this.atK != null) {
                this.atK.b(this.atG);
            }
            if (this.atL != null) {
                this.atL = null;
            }
            c(this.are, this.atG.xt());
            this.atG.d(dVar);
            this.atG.destroy();
            this.atG = null;
            if (this.atH != null) {
                this.atH.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean xp() {
        if (this.atG == null || !this.atG.xt().canGoBack()) {
            return false;
        }
        this.atG.xt().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.atI.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.atI.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g dc(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.atI.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.anp)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.k.d) null);
        xq();
        com.baidu.swan.apps.camera.a.xF().dj(this.atF);
        BH();
        super.destroy();
        this.atI.clear();
        com.baidu.swan.apps.u.a.Ev().e(this);
        com.baidu.swan.apps.media.b.fi(this.atF);
        if (this.atJ != null) {
            this.atJ.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void xq() {
        Activity activity;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && (activity = Md.getActivity()) != null) {
            p.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void BH() {
        com.baidu.swan.apps.textarea.c.b ia = com.baidu.swan.apps.textarea.c.a.OO().ia(this.atF);
        if (ia != null) {
            ia.ic(this.atF);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void bM(int i) {
        xt().setVisibility(i);
        if (this.atJ != null) {
            this.atJ.eM(i);
        }
        if (xn() != null) {
            xn().setVisibility(i);
        }
        if (this.atG != null && this.atG.xt() != null) {
            com.baidu.swan.apps.scheme.actions.k.d xw = this.atG.xw();
            this.atG.xt().setVisibility(i == 0 && xw != null && !xw.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a xr() {
        return this.atJ;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.atK = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.atL = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean bN(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.atH.getHeaderLoadingLayout();
        if (neutralHeaderLoadingLayout == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.bN(i);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.j.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.c
    @Nullable
    /* renamed from: BI */
    public d xo() {
        return this.atG;
    }
}
