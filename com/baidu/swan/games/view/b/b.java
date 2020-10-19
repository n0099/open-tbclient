package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.utils.e;
import com.baidu.swan.games.view.d;
/* loaded from: classes10.dex */
public class b {
    private static final int dMO = e.J(42.0f);
    private static volatile b dMU = null;
    private int dMP;
    private int dMQ;
    private int dMR;
    private boolean dMS;
    private int dMT;
    private ViewTreeObserver.OnGlobalLayoutListener dMV = null;

    private b() {
    }

    public static b aUj() {
        if (dMU == null) {
            synchronized (b.class) {
                if (dMU == null) {
                    dMU = new b();
                }
            }
        }
        return dMU;
    }

    public boolean f(a aVar) {
        d avx = f.avu().avx();
        boolean z = (avx == null || aJ(aVar.getContentView()) || !avx.a(aVar.getContentView(), aUk())) ? false : true;
        if (z) {
            if (!aVar.aUh() || avx == null) {
                return false;
            }
            a(avx.aTI(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.dMT = view.getHeight();
            this.dMV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dMS) {
                            b.this.dMS = true;
                            b.this.dMR = (displayHeight - i) - statusBarHeight;
                            if (b.this.dMR < 0) {
                                b.this.dMR = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dMT || view.getHeight() - i <= 200) {
                                if (i > b.this.dMT && view.getHeight() - i < 200) {
                                    b.this.dMT = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dMT = i;
                            b.this.dMQ = i - b.dMO;
                            b.this.dMP = ((displayHeight - i) - statusBarHeight) - b.this.dMR;
                            if (b.this.dMP > 0 && !b.this.a(aVar, b.this.dMP, b.this.dMQ)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dMV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d avx = f.avu().avx();
        boolean z = avx != null && avx.b(aVar.getContentView(), lV(i2));
        if (z) {
            aVar.lU(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d avx = f.avu().avx();
        if (avx == null) {
            return false;
        }
        FrameLayout aTI = avx.aTI();
        if (aTI != null && this.dMV != null) {
            aTI.getViewTreeObserver().removeOnGlobalLayoutListener(this.dMV);
        }
        aVar.hideKeyboard();
        this.dMV = null;
        this.dMP = -1;
        this.dMQ = -1;
        this.dMR = -1;
        this.dMS = false;
        this.dMT = -1;
        return avx.removeView(aVar.getContentView());
    }

    private boolean aJ(View view) {
        d avx = f.avu().avx();
        return avx != null && avx.aH(view);
    }

    private com.baidu.swan.apps.model.a.a.a aUk() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fp(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a lV(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fp(true);
        aVar.jg(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
