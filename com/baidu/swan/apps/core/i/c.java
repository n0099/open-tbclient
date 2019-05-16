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
    private static int atb = 10;
    private FrameLayout aqB;
    private String atc;
    private d atd;
    protected PullToRefreshSysWebView ate;
    private List<g> atf;
    private com.baidu.swan.apps.view.d.a<SystemWebViewImpl> atg;
    private com.baidu.swan.apps.core.f.d ath;
    private com.baidu.swan.apps.core.f.c ati;
    protected Context mContext;

    public c(Context context) {
        super(context);
        this.atf = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aoF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void yl() {
        super.yl();
        AY();
        k kVar = new k(this.aov);
        kVar.f(this);
        this.aov.a(kVar);
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.DM().c(this);
        if (this.atd != null) {
            this.atd.onResume();
        }
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            com.baidu.swan.apps.ae.b.Lq().Lz().bt(true);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.DM().d(this);
        if (this.atd != null) {
            this.atd.onPause();
        }
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            com.baidu.swan.apps.ae.b.Lq().Lz().bt(false);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.swan.apps.b.b.m
    public double wI() {
        return 0.1d;
    }

    @Override // com.baidu.swan.apps.core.b
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.xG()) {
            str = com.baidu.swan.apps.console.a.d.xI();
        }
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.xC()) {
            com.baidu.swan.apps.core.c.b.yH();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean wL() {
        return wS().getParent() != null;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.ae.a.d dVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(dVar.mBackgroundColor);
            if (dVar.aQO) {
                this.ate = new PullToRefreshSysWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                a(this.ate);
                a(frameLayout, this.ate);
            } else {
                a(frameLayout, wS());
            }
            this.aqB = frameLayout;
            if (this.atg == null) {
                this.atg = new com.baidu.swan.apps.view.d.a<>(this.mContext, this, frameLayout);
            }
        }
    }

    protected void a(PullToRefreshSysWebView pullToRefreshSysWebView) {
        if (pullToRefreshSysWebView != null) {
            this.ate.setOnRefreshListener(new PullToRefreshBase.a<SystemWebViewImpl>() { // from class: com.baidu.swan.apps.core.i.c.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                    com.baidu.swan.apps.w.e.FV().a(c.this.wU(), new com.baidu.swan.apps.m.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<SystemWebViewImpl> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public PullToRefreshBaseWebView wM() {
        return this.ate;
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

    private void AY() {
        this.atc = String.valueOf(atb);
        atb++;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String wU() {
        return this.atc;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean a(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (dVar == null || this.aqB == null) {
            return false;
        }
        if (this.ate != null) {
            this.ate.bK(false);
            this.ate.setPullRefreshEnabled(false);
        }
        if (this.atd == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSysSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.atd = aV(this.mActivity != null ? this.mActivity : this.mContext);
            if (dVar.aDo == null) {
                dVar.aDo = com.baidu.swan.apps.model.a.a.b.GK();
            }
            a(this.aqB, this.atd.wS());
            if (this.atd.wS() != null) {
                this.atd.wS().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.atd.loadUrl(dVar.mSrc);
            this.atd.d(dVar);
            if (this.ath != null) {
                this.ath.a(this.atd);
            }
            if (this.ati != null) {
                this.atd.a(this.ati);
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
        if (this.atd != null) {
            this.atd.loadUrl(dVar.mSrc);
            this.atd.d(dVar);
            if (dVar.aDo == null) {
                dVar.aDo = com.baidu.swan.apps.model.a.a.b.GK();
            }
            if (this.atd.wS() != null) {
                this.atd.wS().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean c(com.baidu.swan.apps.scheme.actions.k.d dVar) {
        if (this.atd != null) {
            if (this.ath != null) {
                this.ath.b(this.atd);
            }
            if (this.ati != null) {
                this.ati = null;
            }
            c(this.aqB, this.atd.wS());
            this.atd.d(dVar);
            this.atd.destroy();
            this.atd = null;
            if (this.ate != null) {
                this.ate.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean wO() {
        if (this.atd == null || !this.atd.wS().canGoBack()) {
            return false;
        }
        this.atd.wS().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(g gVar) {
        if (gVar != null) {
            this.atf.add(gVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void b(g gVar) {
        if (gVar != null) {
            this.atf.remove(gVar);
            gVar.release();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public g cY(String str) {
        g gVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<g> it = this.atf.iterator();
        while (true) {
            if (!it.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it.next();
            if (gVar != null && TextUtils.equals(str, gVar.amM)) {
                break;
            }
        }
        return gVar;
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.k.d) null);
        wP();
        com.baidu.swan.apps.camera.a.xe().df(this.atc);
        AZ();
        super.destroy();
        this.atf.clear();
        com.baidu.swan.apps.u.a.DM().e(this);
        com.baidu.swan.apps.media.b.fe(this.atc);
        if (this.atg != null) {
            this.atg.destroy();
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void wP() {
        Activity activity;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && (activity = Lq.getActivity()) != null) {
            p.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void AZ() {
        com.baidu.swan.apps.textarea.c.b hU = com.baidu.swan.apps.textarea.c.a.NZ().hU(this.atc);
        if (hU != null) {
            hU.hW(this.atc);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void bM(int i) {
        wS().setVisibility(i);
        if (this.atg != null) {
            this.atg.eJ(i);
        }
        if (wM() != null) {
            wM().setVisibility(i);
        }
        if (this.atd != null && this.atd.wS() != null) {
            com.baidu.swan.apps.scheme.actions.k.d wV = this.atd.wV();
            this.atd.wS().setVisibility(i == 0 && wV != null && !wV.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.b.c.c
    public com.baidu.swan.apps.view.d.a wQ() {
        return this.atg;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.ath = dVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.ati = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.c
    public boolean bN(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.ate.getHeaderLoadingLayout();
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
    /* renamed from: Ba */
    public d wN() {
        return this.atd;
    }
}
