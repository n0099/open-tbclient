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
    private boolean epA;
    private int epB;
    private ViewTreeObserver.OnGlobalLayoutListener epD = null;
    private int epx;
    private int epy;
    private int epz;
    private static final int epw = e.O(42.0f);
    private static volatile b epC = null;

    private b() {
    }

    public static b bdu() {
        if (epC == null) {
            synchronized (b.class) {
                if (epC == null) {
                    epC = new b();
                }
            }
        }
        return epC;
    }

    public boolean f(a aVar) {
        d aDK = f.aDH().aDK();
        boolean z = (aDK == null || aZ(aVar.getContentView()) || !aDK.a(aVar.getContentView(), bdv())) ? false : true;
        if (z) {
            if (!aVar.bds() || aDK == null) {
                return false;
            }
            a(aDK.bcT(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.epB = view.getHeight();
            this.epD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.epA) {
                            b.this.epA = true;
                            b.this.epz = (displayHeight - i) - statusBarHeight;
                            if (b.this.epz < 0) {
                                b.this.epz = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.epB || view.getHeight() - i <= 200) {
                                if (i > b.this.epB && view.getHeight() - i < 200) {
                                    b.this.epB = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.epB = i;
                            b.this.epy = i - b.epw;
                            b.this.epx = ((displayHeight - i) - statusBarHeight) - b.this.epz;
                            if (b.this.epx > 0 && !b.this.a(aVar, b.this.epx, b.this.epy)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.epD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d aDK = f.aDH().aDK();
        boolean z = aDK != null && aDK.b(aVar.getContentView(), mS(i2));
        if (z) {
            aVar.mR(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d aDK = f.aDH().aDK();
        if (aDK == null) {
            return false;
        }
        FrameLayout bcT = aDK.bcT();
        if (bcT != null && this.epD != null) {
            bcT.getViewTreeObserver().removeOnGlobalLayoutListener(this.epD);
        }
        aVar.hideKeyboard();
        this.epD = null;
        this.epx = -1;
        this.epy = -1;
        this.epz = -1;
        this.epA = false;
        this.epB = -1;
        return aDK.removeView(aVar.getContentView());
    }

    private boolean aZ(View view) {
        d aDK = f.aDH().aDK();
        return aDK != null && aDK.aX(view);
    }

    private com.baidu.swan.apps.model.a.a.a bdv() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gm(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a mS(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gm(true);
        aVar.jQ(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
