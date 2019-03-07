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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static int asH = 10;
    private FrameLayout aqq;
    private String asI;
    private d asJ;
    protected PullToRefreshSysWebView asK;
    private List<g> asL;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> asM;
    private com.baidu.swan.apps.core.e.d asN;
    private com.baidu.swan.apps.core.e.c asO;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.asL = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aon = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void xu() {
        super.xu();
        zQ();
        k kVar = new k(this.aod);
        kVar.f(this);
        this.aod.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.CJ().c(this);
        if (this.asJ != null) {
            this.asJ.onResume();
        }
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().Jg().bk(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.CJ().d(this);
        if (this.asJ != null) {
            this.asJ.onPause();
        }
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().Jg().bk(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.l
    public double vS() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.wP()) {
            str = com.baidu.swan.apps.console.a.d.wR();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.wL()) {
            com.baidu.swan.apps.core.b.b.xQ();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean vV() {
        return wc().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.aOG) {
                this.asK = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.asK);
                a(frameLayout, this.asK);
            } else {
                a(frameLayout, wc());
            }
            this.aqq = frameLayout;
            if (this.asM == null) {
                this.asM = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.asK.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.h.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.Ec().a(c.this.we(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView vW() {
        return this.asK;
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

    private void zQ() {
        this.asI = String.valueOf(asH);
        asH++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String we() {
        return this.asI;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.j.d dVar) {
        if (dVar == null || this.aqq == null) {
            return false;
        }
        if (this.asK != null) {
            this.asK.bB(false);
            this.asK.setPullRefreshEnabled(false);
        }
        if (this.asJ == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.asJ = bC(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aBE == null) {
                dVar.aBE = com.baidu.swan.apps.model.a.a.b.EO();
            }
            a(this.aqq, this.asJ.wc());
            if (this.asJ.wc() != null) {
                this.asJ.wc().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.asJ.loadUrl(dVar.mSrc);
            this.asJ.d(dVar);
            if (this.asN != null) {
                this.asN.a(this.asJ);
            }
            if (this.asO != null) {
                this.asJ.a(this.asO);
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
        if (this.asJ != null) {
            this.asJ.loadUrl(dVar.mSrc);
            this.asJ.d(dVar);
            if (dVar.aBE == null) {
                dVar.aBE = com.baidu.swan.apps.model.a.a.b.EO();
            }
            if (this.asJ.wc() != null) {
                this.asJ.wc().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.j.d dVar) {
        if (this.asJ != null) {
            if (this.asN != null) {
                this.asN.b(this.asJ);
            }
            if (this.asO != null) {
                this.asO = null;
            }
            c(this.aqq, this.asJ.wc());
            this.asJ.d(dVar);
            this.asJ.destroy();
            this.asJ = null;
            if (this.asK != null) {
                this.asK.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean vY() {
        if (this.asJ == null || !this.asJ.wc().canGoBack()) {
            return false;
        }
        this.asJ.wc().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.asL.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.asL.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g dj(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.asL.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.amu)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.j.d) null);
        vZ();
        com.baidu.swan.apps.camera.a.wn().dq(this.asI);
        zR();
        super.destroy();
        this.asL.clear();
        com.baidu.swan.apps.u.a.CJ().e(this);
        com.baidu.swan.apps.media.b.eS(this.asI);
        if (this.asM != null) {
            this.asM.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void vZ() {
        Activity activity;
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && (activity = IX.getActivity()) != null) {
            o.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void zR() {
        com.baidu.swan.apps.textarea.c.b hr = com.baidu.swan.apps.textarea.c.a.Lw().hr(this.asI);
        if (hr != null) {
            hr.ht(this.asI);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void bN(int i) {
        wc().setVisibility(i);
        if (this.asM != null) {
            this.asM.ey(i);
        }
        if (vW() != null) {
            vW().setVisibility(i);
        }
        if (this.asJ != null && this.asJ.wc() != null) {
            com.baidu.swan.apps.scheme.actions.j.d wf = this.asJ.wf();
            this.asJ.wc().setVisibility(i == 0 && wf != null && !wf.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a wa() {
        return this.asM;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.d dVar) {
        this.asN = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.c cVar) {
        this.asO = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean bO(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.asK.getHeaderLoadingLayout();
        if (neutralHeaderLoadingLayout == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.bO(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.c
    @Nullable
    /* renamed from: zS */
    public d vX() {
        return this.asJ;
    }
}
