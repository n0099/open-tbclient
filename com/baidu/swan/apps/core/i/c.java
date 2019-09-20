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
    private static int auc = 10;
    private FrameLayout arC;
    private String aud;
    private d aue;
    protected PullToRefreshSysWebView auf;
    private List<g> aug;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> auh;
    private com.baidu.swan.apps.core.f.d aui;
    private com.baidu.swan.apps.core.f.c auj;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.aug = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.apH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void yU() {
        super.yU();
        BK();
        k kVar = new k(this.apx);
        kVar.f(this);
        this.apx.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.Ez().c(this);
        if (this.aue != null) {
            this.aue.onResume();
        }
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            com.baidu.swan.apps.ae.b.Mh().Mq().bw(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.Ez().d(this);
        if (this.aue != null) {
            this.aue.onPause();
        }
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            com.baidu.swan.apps.ae.b.Mh().Mq().bw(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.m
    public double xn() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.yp()) {
            str = com.baidu.swan.apps.console.a.d.yr();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.yk()) {
            com.baidu.swan.apps.core.c.b.zs();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean xq() {
        return xx().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.aRW) {
                this.auf = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.auf);
                a(frameLayout, this.auf);
            } else {
                a(frameLayout, xx());
            }
            this.arC = frameLayout;
            if (this.auh == null) {
                this.auh = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.auf.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.i.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.GJ().a(c.this.xz(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView xr() {
        return this.auf;
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

    private void BK() {
        this.aud = String.valueOf(auc);
        auc++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String xz() {
        return this.aud;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (dVar == null || this.arC == null) {
            return false;
        }
        if (this.auf != null) {
            this.auf.bN(false);
            this.auf.setPullRefreshEnabled(false);
        }
        if (this.aue == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.aue = aV(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aEu == null) {
                dVar.aEu = com.baidu.swan.apps.model.a.a.b.Hy();
            }
            a(this.arC, this.aue.xx());
            if (this.aue.xx() != null) {
                this.aue.xx().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.aue.loadUrl(dVar.mSrc);
            this.aue.d(dVar);
            if (this.aui != null) {
                this.aui.a(this.aue);
            }
            if (this.auj != null) {
                this.aue.a(this.auj);
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
        if (this.aue != null) {
            this.aue.loadUrl(dVar.mSrc);
            this.aue.d(dVar);
            if (dVar.aEu == null) {
                dVar.aEu = com.baidu.swan.apps.model.a.a.b.Hy();
            }
            if (this.aue.xx() != null) {
                this.aue.xx().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.aue != null) {
            if (this.aui != null) {
                this.aui.b(this.aue);
            }
            if (this.auj != null) {
                this.auj = null;
            }
            c(this.arC, this.aue.xx());
            this.aue.d(dVar);
            this.aue.destroy();
            this.aue = null;
            if (this.auf != null) {
                this.auf.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean xt() {
        if (this.aue == null || !this.aue.xx().canGoBack()) {
            return false;
        }
        this.aue.xx().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.aug.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.aug.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g de(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.aug.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.anN)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.k.d) null);
        xu();
        com.baidu.swan.apps.camera.a.xJ().dl(this.aud);
        BL();
        super.destroy();
        this.aug.clear();
        com.baidu.swan.apps.u.a.Ez().e(this);
        com.baidu.swan.apps.media.b.fk(this.aud);
        if (this.auh != null) {
            this.auh.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void xu() {
        Activity activity;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && (activity = Mh.getActivity()) != null) {
            p.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void BL() {
        com.baidu.swan.apps.textarea.c.b ic = com.baidu.swan.apps.textarea.c.a.OS().ic(this.aud);
        if (ic != null) {
            ic.m16if(this.aud);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void bN(int i) {
        xx().setVisibility(i);
        if (this.auh != null) {
            this.auh.eN(i);
        }
        if (xr() != null) {
            xr().setVisibility(i);
        }
        if (this.aue != null && this.aue.xx() != null) {
            com.baidu.swan.apps.scheme.actions.k.d xA = this.aue.xA();
            this.aue.xx().setVisibility(i == 0 && xA != null && !xA.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a xv() {
        return this.auh;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.aui = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.auj = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean bO(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.auf.getHeaderLoadingLayout();
        if (neutralHeaderLoadingLayout == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.bO(i);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.j.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.c
    @Nullable
    /* renamed from: BM */
    public d xs() {
        return this.aue;
    }
}
