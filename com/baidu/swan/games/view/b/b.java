package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.utils.d;
/* loaded from: classes11.dex */
public class b {
    private static final int ddY = d.B(42.0f);
    private static volatile b dee = null;
    private int ddZ;
    private int dea;
    private int deb;
    private boolean dec;
    private int ded;
    private ViewTreeObserver.OnGlobalLayoutListener def = null;

    private b() {
    }

    public static b aCZ() {
        if (dee == null) {
            synchronized (b.class) {
                if (dee == null) {
                    dee = new b();
                }
            }
        }
        return dee;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d ahY = f.ahV().ahY();
        boolean z = (ahY == null || az(aVar.getContentView()) || !ahY.a(aVar.getContentView(), aDa())) ? false : true;
        if (z) {
            if (!aVar.aCX() || ahY == null) {
                return false;
            }
            a(ahY.aCz(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.ded = view.getHeight();
            this.def = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ag.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ag.getStatusBarHeight();
                        if (!b.this.dec) {
                            b.this.dec = true;
                            b.this.deb = (displayHeight - i) - statusBarHeight;
                            if (b.this.deb < 0) {
                                b.this.deb = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.ded || view.getHeight() - i <= 200) {
                                if (i > b.this.ded && view.getHeight() - i < 200) {
                                    b.this.ded = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.ded = i;
                            b.this.dea = i - b.ddY;
                            b.this.ddZ = ((displayHeight - i) - statusBarHeight) - b.this.deb;
                            if (b.this.ddZ > 0 && !b.this.a(aVar, b.this.ddZ, b.this.dea)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.def);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d ahY = f.ahV().ahY();
        boolean z = ahY != null && ahY.b(aVar.getContentView(), iC(i2));
        if (z) {
            aVar.iB(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d ahY = f.ahV().ahY();
        if (ahY == null) {
            return false;
        }
        FrameLayout aCz = ahY.aCz();
        if (aCz != null && this.def != null) {
            aCz.getViewTreeObserver().removeOnGlobalLayoutListener(this.def);
        }
        aVar.hideKeyboard();
        this.def = null;
        this.ddZ = -1;
        this.dea = -1;
        this.deb = -1;
        this.dec = false;
        this.ded = -1;
        return ahY.av(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d ahY = f.ahV().ahY();
        return ahY != null && ahY.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aDa() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eq(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a iC(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eq(true);
        aVar.fX(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
