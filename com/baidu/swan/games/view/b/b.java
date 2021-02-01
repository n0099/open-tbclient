package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.utils.e;
import com.baidu.swan.games.view.d;
/* loaded from: classes9.dex */
public class b {
    private static final int emO = e.P(42.0f);
    private static volatile b emU = null;
    private int emP;
    private int emQ;
    private int emR;
    private boolean emS;
    private int emT;
    private ViewTreeObserver.OnGlobalLayoutListener emV = null;

    private b() {
    }

    public static b aZN() {
        if (emU == null) {
            synchronized (b.class) {
                if (emU == null) {
                    emU = new b();
                }
            }
        }
        return emU;
    }

    public boolean f(a aVar) {
        d aAo = f.aAl().aAo();
        boolean z = (aAo == null || aV(aVar.getContentView()) || !aAo.a(aVar.getContentView(), aZO())) ? false : true;
        if (z) {
            if (!aVar.aZL() || aAo == null) {
                return false;
            }
            a(aAo.aZl(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.emT = view.getHeight();
            this.emV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.emS) {
                            b.this.emS = true;
                            b.this.emR = (displayHeight - i) - statusBarHeight;
                            if (b.this.emR < 0) {
                                b.this.emR = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.emT || view.getHeight() - i <= 200) {
                                if (i > b.this.emT && view.getHeight() - i < 200) {
                                    b.this.emT = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.emT = i;
                            b.this.emQ = i - b.emO;
                            b.this.emP = ((displayHeight - i) - statusBarHeight) - b.this.emR;
                            if (b.this.emP > 0 && !b.this.a(aVar, b.this.emP, b.this.emQ)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.emV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d aAo = f.aAl().aAo();
        boolean z = aAo != null && aAo.b(aVar.getContentView(), lp(i2));
        if (z) {
            aVar.lo(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d aAo = f.aAl().aAo();
        if (aAo == null) {
            return false;
        }
        FrameLayout aZl = aAo.aZl();
        if (aZl != null && this.emV != null) {
            aZl.getViewTreeObserver().removeOnGlobalLayoutListener(this.emV);
        }
        aVar.hideKeyboard();
        this.emV = null;
        this.emP = -1;
        this.emQ = -1;
        this.emR = -1;
        this.emS = false;
        this.emT = -1;
        return aAo.removeView(aVar.getContentView());
    }

    private boolean aV(View view) {
        d aAo = f.aAl().aAo();
        return aAo != null && aAo.aT(view);
    }

    private com.baidu.swan.apps.model.a.a.a aZO() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gk(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a lp(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gk(true);
        aVar.in(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
