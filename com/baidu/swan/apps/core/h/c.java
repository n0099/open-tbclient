package com.baidu.swan.apps.core.h;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.o;
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
    private static int asM = 10;
    private FrameLayout aqv;
    private String asN;
    private d asO;
    protected PullToRefreshSysWebView asP;
    private List<g> asQ;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> asR;
    private com.baidu.swan.apps.core.e.d asS;
    private com.baidu.swan.apps.core.e.c asT;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.asQ = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aos = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void xt() {
        super.xt();
        zP();
        k kVar = new k(this.aoi);
        kVar.f(this);
        this.aoi.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.CH().c(this);
        if (this.asO != null) {
            this.asO.onResume();
        }
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            com.baidu.swan.apps.ae.b.IV().Je().bk(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.CH().d(this);
        if (this.asO != null) {
            this.asO.onPause();
        }
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            com.baidu.swan.apps.ae.b.IV().Je().bk(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.l
    public double vR() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.wO()) {
            str = com.baidu.swan.apps.console.a.d.wQ();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.wK()) {
            com.baidu.swan.apps.core.b.b.xP();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean vU() {
        return wb().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.aOK) {
                this.asP = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.asP);
                a(frameLayout, this.asP);
            } else {
                a(frameLayout, wb());
            }
            this.aqv = frameLayout;
            if (this.asR == null) {
                this.asR = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.asP.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.h.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.Ea().a(c.this.wd(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView vV() {
        return this.asP;
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

    private void zP() {
        this.asN = String.valueOf(asM);
        asM++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String wd() {
        return this.asN;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.j.d dVar) {
        if (dVar == null || this.aqv == null) {
            return false;
        }
        if (this.asP != null) {
            this.asP.bB(false);
            this.asP.setPullRefreshEnabled(false);
        }
        if (this.asO == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.asO = bC(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aBI == null) {
                dVar.aBI = com.baidu.swan.apps.model.a.a.b.EM();
            }
            a(this.aqv, this.asO.wb());
            if (this.asO.wb() != null) {
                this.asO.wb().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.asO.loadUrl(dVar.mSrc);
            this.asO.d(dVar);
            if (this.asS != null) {
                this.asS.a(this.asO);
            }
            if (this.asT != null) {
                this.asO.a(this.asT);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected d bC(Context context) {
        return new d(context);
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean b(com.baidu.swan.apps.scheme.actions.j.d dVar) {
        if (this.asO != null) {
            this.asO.loadUrl(dVar.mSrc);
            this.asO.d(dVar);
            if (dVar.aBI == null) {
                dVar.aBI = com.baidu.swan.apps.model.a.a.b.EM();
            }
            if (this.asO.wb() != null) {
                this.asO.wb().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.j.d dVar) {
        if (this.asO != null) {
            if (this.asS != null) {
                this.asS.b(this.asO);
            }
            if (this.asT != null) {
                this.asT = null;
            }
            c(this.aqv, this.asO.wb());
            this.asO.d(dVar);
            this.asO.destroy();
            this.asO = null;
            if (this.asP != null) {
                this.asP.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean vX() {
        if (this.asO == null || !this.asO.wb().canGoBack()) {
            return false;
        }
        this.asO.wb().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.asQ.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.asQ.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g dl(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.asQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.amz)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.j.d) null);
        vY();
        com.baidu.swan.apps.camera.a.wm().ds(this.asN);
        zQ();
        super.destroy();
        this.asQ.clear();
        com.baidu.swan.apps.u.a.CH().e(this);
        com.baidu.swan.apps.media.b.eT(this.asN);
        if (this.asR != null) {
            this.asR.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void vY() {
        Activity activity;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && (activity = IV.getActivity()) != null) {
            o.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void zQ() {
        com.baidu.swan.apps.textarea.c.b hs = com.baidu.swan.apps.textarea.c.a.Lu().hs(this.asN);
        if (hs != null) {
            hs.hu(this.asN);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void bM(int i) {
        wb().setVisibility(i);
        if (this.asR != null) {
            this.asR.ex(i);
        }
        if (vV() != null) {
            vV().setVisibility(i);
        }
        if (this.asO != null && this.asO.wb() != null) {
            com.baidu.swan.apps.scheme.actions.j.d we = this.asO.we();
            this.asO.wb().setVisibility(i == 0 && we != null && !we.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a vZ() {
        return this.asR;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.d dVar) {
        this.asS = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.c cVar) {
        this.asT = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean bN(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.asP.getHeaderLoadingLayout();
        if (neutralHeaderLoadingLayout == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.bN(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.c
    @Nullable
    /* renamed from: zR */
    public d vW() {
        return this.asO;
    }
}
