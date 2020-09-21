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
/* loaded from: classes3.dex */
public class b {
    private static final int dAN = e.H(42.0f);
    private static volatile b dAT = null;
    private int dAO;
    private int dAP;
    private int dAQ;
    private boolean dAR;
    private int dAS;
    private ViewTreeObserver.OnGlobalLayoutListener dAU = null;

    private b() {
    }

    public static b aRA() {
        if (dAT == null) {
            synchronized (b.class) {
                if (dAT == null) {
                    dAT = new b();
                }
            }
        }
        return dAT;
    }

    public boolean f(a aVar) {
        d asM = f.asJ().asM();
        boolean z = (asM == null || aI(aVar.getContentView()) || !asM.a(aVar.getContentView(), aRB())) ? false : true;
        if (z) {
            if (!aVar.aRy() || asM == null) {
                return false;
            }
            a(asM.aQZ(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.dAS = view.getHeight();
            this.dAU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dAR) {
                            b.this.dAR = true;
                            b.this.dAQ = (displayHeight - i) - statusBarHeight;
                            if (b.this.dAQ < 0) {
                                b.this.dAQ = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dAS || view.getHeight() - i <= 200) {
                                if (i > b.this.dAS && view.getHeight() - i < 200) {
                                    b.this.dAS = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dAS = i;
                            b.this.dAP = i - b.dAN;
                            b.this.dAO = ((displayHeight - i) - statusBarHeight) - b.this.dAQ;
                            if (b.this.dAO > 0 && !b.this.a(aVar, b.this.dAO, b.this.dAP)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dAU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d asM = f.asJ().asM();
        boolean z = asM != null && asM.b(aVar.getContentView(), ly(i2));
        if (z) {
            aVar.lx(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d asM = f.asJ().asM();
        if (asM == null) {
            return false;
        }
        FrameLayout aQZ = asM.aQZ();
        if (aQZ != null && this.dAU != null) {
            aQZ.getViewTreeObserver().removeOnGlobalLayoutListener(this.dAU);
        }
        aVar.hideKeyboard();
        this.dAU = null;
        this.dAO = -1;
        this.dAP = -1;
        this.dAQ = -1;
        this.dAR = false;
        this.dAS = -1;
        return asM.removeView(aVar.getContentView());
    }

    private boolean aI(View view) {
        d asM = f.asJ().asM();
        return asM != null && asM.aG(view);
    }

    private com.baidu.swan.apps.model.a.a.a aRB() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eT(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ly(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eT(true);
        aVar.iJ(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
