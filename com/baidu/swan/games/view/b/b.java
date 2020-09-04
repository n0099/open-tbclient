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
/* loaded from: classes8.dex */
public class b {
    private static final int dyM = e.H(42.0f);
    private static volatile b dyS = null;
    private int dyN;
    private int dyO;
    private int dyP;
    private boolean dyQ;
    private int dyR;
    private ViewTreeObserver.OnGlobalLayoutListener dyT = null;

    private b() {
    }

    public static b aQO() {
        if (dyS == null) {
            synchronized (b.class) {
                if (dyS == null) {
                    dyS = new b();
                }
            }
        }
        return dyS;
    }

    public boolean f(a aVar) {
        d asb = f.arY().asb();
        boolean z = (asb == null || aG(aVar.getContentView()) || !asb.a(aVar.getContentView(), aQP())) ? false : true;
        if (z) {
            if (!aVar.aQM() || asb == null) {
                return false;
            }
            a(asb.aQn(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.dyR = view.getHeight();
            this.dyT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dyQ) {
                            b.this.dyQ = true;
                            b.this.dyP = (displayHeight - i) - statusBarHeight;
                            if (b.this.dyP < 0) {
                                b.this.dyP = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dyR || view.getHeight() - i <= 200) {
                                if (i > b.this.dyR && view.getHeight() - i < 200) {
                                    b.this.dyR = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dyR = i;
                            b.this.dyO = i - b.dyM;
                            b.this.dyN = ((displayHeight - i) - statusBarHeight) - b.this.dyP;
                            if (b.this.dyN > 0 && !b.this.a(aVar, b.this.dyN, b.this.dyO)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dyT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d asb = f.arY().asb();
        boolean z = asb != null && asb.b(aVar.getContentView(), ln(i2));
        if (z) {
            aVar.lm(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d asb = f.arY().asb();
        if (asb == null) {
            return false;
        }
        FrameLayout aQn = asb.aQn();
        if (aQn != null && this.dyT != null) {
            aQn.getViewTreeObserver().removeOnGlobalLayoutListener(this.dyT);
        }
        aVar.hideKeyboard();
        this.dyT = null;
        this.dyN = -1;
        this.dyO = -1;
        this.dyP = -1;
        this.dyQ = false;
        this.dyR = -1;
        return asb.removeView(aVar.getContentView());
    }

    private boolean aG(View view) {
        d asb = f.arY().asb();
        return asb != null && asb.aE(view);
    }

    private com.baidu.swan.apps.model.a.a.a aQP() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eV(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ln(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eV(true);
        aVar.iz(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
