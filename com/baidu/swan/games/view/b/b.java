package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b {
    private static final int bEK = com.baidu.swan.games.utils.b.S(42.0f);
    private static volatile b bEQ = null;
    private int bEL;
    private int bEM;
    private int bEN;
    private boolean bEO;
    private int bEP;
    private ViewTreeObserver.OnGlobalLayoutListener bER = null;

    private b() {
    }

    public static b YO() {
        if (bEQ == null) {
            synchronized (b.class) {
                if (bEQ == null) {
                    bEQ = new b();
                }
            }
        }
        return bEQ;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b LF = e.LE().LF();
        boolean z = (LF == null || aA(aVar.getContentView()) || !LF.a(aVar.getContentView(), YP())) ? false : true;
        if (z) {
            if (!aVar.YM() || LF == null) {
                return false;
            }
            a(LF.Yr(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bEP = view.getHeight();
            this.bER = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = z.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = z.getStatusBarHeight();
                        if (!b.this.bEO) {
                            b.this.bEO = true;
                            b.this.bEN = (displayHeight - i) - statusBarHeight;
                            if (b.this.bEN < 0) {
                                b.this.bEN = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bEP || view.getHeight() - i <= 200) {
                                if (i > b.this.bEP && view.getHeight() - i < 200) {
                                    b.this.bEP = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bEP = i;
                            b.this.bEM = i - b.bEK;
                            b.this.bEL = ((displayHeight - i) - statusBarHeight) - b.this.bEN;
                            if (b.this.bEL > 0 && !b.this.a(aVar, b.this.bEL, b.this.bEM)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b LF = e.LE().LF();
        boolean z = LF != null && LF.b(aVar.getContentView(), gg(i2));
        if (z) {
            aVar.gf(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b LF = e.LE().LF();
        if (LF == null) {
            return false;
        }
        FrameLayout Yr = LF.Yr();
        if (Yr != null && this.bER != null) {
            Yr.getViewTreeObserver().removeOnGlobalLayoutListener(this.bER);
        }
        aVar.hideKeyboard();
        this.bER = null;
        this.bEL = -1;
        this.bEM = -1;
        this.bEN = -1;
        this.bEO = false;
        this.bEP = -1;
        return LF.at(aVar.getContentView());
    }

    private boolean aA(View view) {
        com.baidu.swan.games.view.b LF = e.LE().LF();
        return LF != null && LF.ay(view);
    }

    private com.baidu.swan.apps.model.a.a.b YP() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bU(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b gg(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bU(true);
        bVar.dJ(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
