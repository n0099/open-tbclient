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
/* loaded from: classes25.dex */
public class b {
    private int egA;
    private ViewTreeObserver.OnGlobalLayoutListener egC = null;
    private int egw;
    private int egx;
    private int egy;
    private boolean egz;
    private static final int egv = e.M(42.0f);
    private static volatile b egB = null;

    private b() {
    }

    public static b bbb() {
        if (egB == null) {
            synchronized (b.class) {
                if (egB == null) {
                    egB = new b();
                }
            }
        }
        return egB;
    }

    public boolean f(a aVar) {
        d aCs = f.aCp().aCs();
        boolean z = (aCs == null || aQ(aVar.getContentView()) || !aCs.a(aVar.getContentView(), bbc())) ? false : true;
        if (z) {
            if (!aVar.baZ() || aCs == null) {
                return false;
            }
            a(aCs.baz(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.egA = view.getHeight();
            this.egC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.egz) {
                            b.this.egz = true;
                            b.this.egy = (displayHeight - i) - statusBarHeight;
                            if (b.this.egy < 0) {
                                b.this.egy = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.egA || view.getHeight() - i <= 200) {
                                if (i > b.this.egA && view.getHeight() - i < 200) {
                                    b.this.egA = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.egA = i;
                            b.this.egx = i - b.egv;
                            b.this.egw = ((displayHeight - i) - statusBarHeight) - b.this.egy;
                            if (b.this.egw > 0 && !b.this.a(aVar, b.this.egw, b.this.egx)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.egC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d aCs = f.aCp().aCs();
        boolean z = aCs != null && aCs.b(aVar.getContentView(), mK(i2));
        if (z) {
            aVar.mJ(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d aCs = f.aCp().aCs();
        if (aCs == null) {
            return false;
        }
        FrameLayout baz = aCs.baz();
        if (baz != null && this.egC != null) {
            baz.getViewTreeObserver().removeOnGlobalLayoutListener(this.egC);
        }
        aVar.hideKeyboard();
        this.egC = null;
        this.egw = -1;
        this.egx = -1;
        this.egy = -1;
        this.egz = false;
        this.egA = -1;
        return aCs.removeView(aVar.getContentView());
    }

    private boolean aQ(View view) {
        d aCs = f.aCp().aCs();
        return aCs != null && aCs.aO(view);
    }

    private com.baidu.swan.apps.model.a.a.a bbc() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gd(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a mK(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gd(true);
        aVar.jV(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
