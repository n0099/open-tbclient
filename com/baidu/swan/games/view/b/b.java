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
/* loaded from: classes7.dex */
public class b {
    private int dZA;
    private ViewTreeObserver.OnGlobalLayoutListener dZC = null;
    private int dZw;
    private int dZx;
    private int dZy;
    private boolean dZz;
    private static final int dZv = e.M(42.0f);
    private static volatile b dZB = null;

    private b() {
    }

    public static b aXW() {
        if (dZB == null) {
            synchronized (b.class) {
                if (dZB == null) {
                    dZB = new b();
                }
            }
        }
        return dZB;
    }

    public boolean f(a aVar) {
        d azj = f.azg().azj();
        boolean z = (azj == null || aO(aVar.getContentView()) || !azj.a(aVar.getContentView(), aXX())) ? false : true;
        if (z) {
            if (!aVar.aXU() || azj == null) {
                return false;
            }
            a(azj.aXu(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.dZA = view.getHeight();
            this.dZC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dZz) {
                            b.this.dZz = true;
                            b.this.dZy = (displayHeight - i) - statusBarHeight;
                            if (b.this.dZy < 0) {
                                b.this.dZy = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dZA || view.getHeight() - i <= 200) {
                                if (i > b.this.dZA && view.getHeight() - i < 200) {
                                    b.this.dZA = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dZA = i;
                            b.this.dZx = i - b.dZv;
                            b.this.dZw = ((displayHeight - i) - statusBarHeight) - b.this.dZy;
                            if (b.this.dZw > 0 && !b.this.a(aVar, b.this.dZw, b.this.dZx)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dZC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d azj = f.azg().azj();
        boolean z = azj != null && azj.b(aVar.getContentView(), mm(i2));
        if (z) {
            aVar.ml(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d azj = f.azg().azj();
        if (azj == null) {
            return false;
        }
        FrameLayout aXu = azj.aXu();
        if (aXu != null && this.dZC != null) {
            aXu.getViewTreeObserver().removeOnGlobalLayoutListener(this.dZC);
        }
        aVar.hideKeyboard();
        this.dZC = null;
        this.dZw = -1;
        this.dZx = -1;
        this.dZy = -1;
        this.dZz = false;
        this.dZA = -1;
        return azj.removeView(aVar.getContentView());
    }

    private boolean aO(View view) {
        d azj = f.azg().azj();
        return azj != null && azj.aM(view);
    }

    private com.baidu.swan.apps.model.a.a.a aXX() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fO(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a mm(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fO(true);
        aVar.jx(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
