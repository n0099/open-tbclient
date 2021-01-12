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
/* loaded from: classes8.dex */
public class b {
    private static final int ekH = e.O(42.0f);
    private static volatile b ekN = null;
    private int ekI;
    private int ekJ;
    private int ekK;
    private boolean ekL;
    private int ekM;
    private ViewTreeObserver.OnGlobalLayoutListener ekO = null;

    private b() {
    }

    public static b aZA() {
        if (ekN == null) {
            synchronized (b.class) {
                if (ekN == null) {
                    ekN = new b();
                }
            }
        }
        return ekN;
    }

    public boolean f(a aVar) {
        d azQ = f.azN().azQ();
        boolean z = (azQ == null || aZ(aVar.getContentView()) || !azQ.a(aVar.getContentView(), aZB())) ? false : true;
        if (z) {
            if (!aVar.aZy() || azQ == null) {
                return false;
            }
            a(azQ.aYZ(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.ekM = view.getHeight();
            this.ekO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.ekL) {
                            b.this.ekL = true;
                            b.this.ekK = (displayHeight - i) - statusBarHeight;
                            if (b.this.ekK < 0) {
                                b.this.ekK = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.ekM || view.getHeight() - i <= 200) {
                                if (i > b.this.ekM && view.getHeight() - i < 200) {
                                    b.this.ekM = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.ekM = i;
                            b.this.ekJ = i - b.ekH;
                            b.this.ekI = ((displayHeight - i) - statusBarHeight) - b.this.ekK;
                            if (b.this.ekI > 0 && !b.this.a(aVar, b.this.ekI, b.this.ekJ)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.ekO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d azQ = f.azN().azQ();
        boolean z = azQ != null && azQ.b(aVar.getContentView(), lm(i2));
        if (z) {
            aVar.ll(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d azQ = f.azN().azQ();
        if (azQ == null) {
            return false;
        }
        FrameLayout aYZ = azQ.aYZ();
        if (aYZ != null && this.ekO != null) {
            aYZ.getViewTreeObserver().removeOnGlobalLayoutListener(this.ekO);
        }
        aVar.hideKeyboard();
        this.ekO = null;
        this.ekI = -1;
        this.ekJ = -1;
        this.ekK = -1;
        this.ekL = false;
        this.ekM = -1;
        return azQ.removeView(aVar.getContentView());
    }

    private boolean aZ(View view) {
        d azQ = f.azN().azQ();
        return azQ != null && azQ.aX(view);
    }

    private com.baidu.swan.apps.model.a.a.a aZB() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gi(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a lm(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gi(true);
        aVar.ik(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
