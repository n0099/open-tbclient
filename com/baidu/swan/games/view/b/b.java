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
    private static final int ebd = e.N(42.0f);
    private static volatile b ebj = null;
    private int ebe;
    private int ebf;
    private int ebg;
    private boolean ebh;
    private int ebi;
    private ViewTreeObserver.OnGlobalLayoutListener ebk = null;

    private b() {
    }

    public static b aYD() {
        if (ebj == null) {
            synchronized (b.class) {
                if (ebj == null) {
                    ebj = new b();
                }
            }
        }
        return ebj;
    }

    public boolean f(a aVar) {
        d azR = f.azO().azR();
        boolean z = (azR == null || aO(aVar.getContentView()) || !azR.a(aVar.getContentView(), aYE())) ? false : true;
        if (z) {
            if (!aVar.aYB() || azR == null) {
                return false;
            }
            a(azR.aYc(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.ebi = view.getHeight();
            this.ebk = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.ebh) {
                            b.this.ebh = true;
                            b.this.ebg = (displayHeight - i) - statusBarHeight;
                            if (b.this.ebg < 0) {
                                b.this.ebg = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.ebi || view.getHeight() - i <= 200) {
                                if (i > b.this.ebi && view.getHeight() - i < 200) {
                                    b.this.ebi = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.ebi = i;
                            b.this.ebf = i - b.ebd;
                            b.this.ebe = ((displayHeight - i) - statusBarHeight) - b.this.ebg;
                            if (b.this.ebe > 0 && !b.this.a(aVar, b.this.ebe, b.this.ebf)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.ebk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d azR = f.azO().azR();
        boolean z = azR != null && azR.b(aVar.getContentView(), mq(i2));
        if (z) {
            aVar.mp(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d azR = f.azO().azR();
        if (azR == null) {
            return false;
        }
        FrameLayout aYc = azR.aYc();
        if (aYc != null && this.ebk != null) {
            aYc.getViewTreeObserver().removeOnGlobalLayoutListener(this.ebk);
        }
        aVar.hideKeyboard();
        this.ebk = null;
        this.ebe = -1;
        this.ebf = -1;
        this.ebg = -1;
        this.ebh = false;
        this.ebi = -1;
        return azR.removeView(aVar.getContentView());
    }

    private boolean aO(View view) {
        d azR = f.azO().azR();
        return azR != null && azR.aM(view);
    }

    private com.baidu.swan.apps.model.a.a.a aYE() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fL(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a mq(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fL(true);
        aVar.jB(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
