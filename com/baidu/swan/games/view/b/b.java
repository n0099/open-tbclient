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
    private static final int dyI = e.H(42.0f);
    private static volatile b dyO = null;
    private int dyJ;
    private int dyK;
    private int dyL;
    private boolean dyM;
    private int dyN;
    private ViewTreeObserver.OnGlobalLayoutListener dyP = null;

    private b() {
    }

    public static b aQO() {
        if (dyO == null) {
            synchronized (b.class) {
                if (dyO == null) {
                    dyO = new b();
                }
            }
        }
        return dyO;
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
            this.dyN = view.getHeight();
            this.dyP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dyM) {
                            b.this.dyM = true;
                            b.this.dyL = (displayHeight - i) - statusBarHeight;
                            if (b.this.dyL < 0) {
                                b.this.dyL = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dyN || view.getHeight() - i <= 200) {
                                if (i > b.this.dyN && view.getHeight() - i < 200) {
                                    b.this.dyN = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dyN = i;
                            b.this.dyK = i - b.dyI;
                            b.this.dyJ = ((displayHeight - i) - statusBarHeight) - b.this.dyL;
                            if (b.this.dyJ > 0 && !b.this.a(aVar, b.this.dyJ, b.this.dyK)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dyP);
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
        if (aQn != null && this.dyP != null) {
            aQn.getViewTreeObserver().removeOnGlobalLayoutListener(this.dyP);
        }
        aVar.hideKeyboard();
        this.dyP = null;
        this.dyJ = -1;
        this.dyK = -1;
        this.dyL = -1;
        this.dyM = false;
        this.dyN = -1;
        return asb.removeView(aVar.getContentView());
    }

    private boolean aG(View view) {
        d asb = f.arY().asb();
        return asb != null && asb.aE(view);
    }

    private com.baidu.swan.apps.model.a.a.a aQP() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eU(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ln(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eU(true);
        aVar.iz(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
