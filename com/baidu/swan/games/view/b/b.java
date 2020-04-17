package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.utils.d;
/* loaded from: classes11.dex */
public class b {
    private static final int cSR = d.C(42.0f);
    private static volatile b cSX = null;
    private int cSS;
    private int cST;
    private int cSU;
    private boolean cSV;
    private int cSW;
    private ViewTreeObserver.OnGlobalLayoutListener cSY = null;

    private b() {
    }

    public static b azh() {
        if (cSX == null) {
            synchronized (b.class) {
                if (cSX == null) {
                    cSX = new b();
                }
            }
        }
        return cSX;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d aeN = f.aeK().aeN();
        boolean z = (aeN == null || aA(aVar.getContentView()) || !aeN.a(aVar.getContentView(), azi())) ? false : true;
        if (z) {
            if (!aVar.azf() || aeN == null) {
                return false;
            }
            a(aeN.ayH(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.cSW = view.getHeight();
            this.cSY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = af.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = af.getStatusBarHeight();
                        if (!b.this.cSV) {
                            b.this.cSV = true;
                            b.this.cSU = (displayHeight - i) - statusBarHeight;
                            if (b.this.cSU < 0) {
                                b.this.cSU = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.cSW || view.getHeight() - i <= 200) {
                                if (i > b.this.cSW && view.getHeight() - i < 200) {
                                    b.this.cSW = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.cSW = i;
                            b.this.cST = i - b.cSR;
                            b.this.cSS = ((displayHeight - i) - statusBarHeight) - b.this.cSU;
                            if (b.this.cSS > 0 && !b.this.a(aVar, b.this.cSS, b.this.cST)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.cSY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d aeN = f.aeK().aeN();
        boolean z = aeN != null && aeN.b(aVar.getContentView(), ij(i2));
        if (z) {
            aVar.ii(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d aeN = f.aeK().aeN();
        if (aeN == null) {
            return false;
        }
        FrameLayout ayH = aeN.ayH();
        if (ayH != null && this.cSY != null) {
            ayH.getViewTreeObserver().removeOnGlobalLayoutListener(this.cSY);
        }
        aVar.hideKeyboard();
        this.cSY = null;
        this.cSS = -1;
        this.cST = -1;
        this.cSU = -1;
        this.cSV = false;
        this.cSW = -1;
        return aeN.av(aVar.getContentView());
    }

    private boolean aA(View view) {
        com.baidu.swan.games.view.d aeN = f.aeK().aeN();
        return aeN != null && aeN.ay(view);
    }

    private com.baidu.swan.apps.model.a.a.a azi() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dZ(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ij(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dZ(true);
        aVar.fG(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
