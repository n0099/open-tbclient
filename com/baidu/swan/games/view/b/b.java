package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b {
    private static final int bgp = com.baidu.swan.games.utils.b.ad(52.0f);
    private static volatile b bgw = null;
    private int bgq;
    private int bgr;
    private int bgt;
    private boolean bgu;
    private int bgv;
    private ViewTreeObserver.OnGlobalLayoutListener bgx = null;

    private b() {
    }

    public static b PH() {
        if (bgw == null) {
            synchronized (b.class) {
                if (bgw == null) {
                    bgw = new b();
                }
            }
        }
        return bgw;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b Eb = e.Ea().Eb();
        boolean z = (Eb == null || ao(aVar.getContentView()) || !Eb.a(aVar.getContentView(), PI())) ? false : true;
        if (z) {
            if (!aVar.PF() || Eb == null) {
                return false;
            }
            a(Eb.Pm(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bgv = view.getHeight();
            this.bgx = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = x.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = x.getStatusBarHeight();
                        if (!b.this.bgu) {
                            b.this.bgu = true;
                            b.this.bgt = (displayHeight - i) - statusBarHeight;
                            if (b.this.bgt < 0) {
                                b.this.bgt = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bgv || view.getHeight() - i <= 200) {
                                if (i > b.this.bgv && view.getHeight() - i < 200) {
                                    b.this.bgv = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bgv = i;
                            b.this.bgr = i - b.bgp;
                            b.this.bgq = ((displayHeight - i) - statusBarHeight) - b.this.bgt;
                            if (b.this.bgq > 0 && !b.this.a(aVar, b.this.bgq, b.this.bgr)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bgx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b Eb = e.Ea().Eb();
        boolean z = Eb != null && Eb.b(aVar.getContentView(), eN(i2));
        if (z) {
            aVar.eM(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b Eb = e.Ea().Eb();
        if (Eb == null) {
            return false;
        }
        FrameLayout Pm = Eb.Pm();
        if (Pm != null && this.bgx != null) {
            Pm.getViewTreeObserver().removeOnGlobalLayoutListener(this.bgx);
        }
        aVar.hideKeyboard();
        this.bgx = null;
        this.bgq = -1;
        this.bgr = -1;
        this.bgt = -1;
        this.bgu = false;
        this.bgv = -1;
        return Eb.ai(aVar.getContentView());
    }

    private boolean ao(View view) {
        com.baidu.swan.games.view.b Eb = e.Ea().Eb();
        return Eb != null && Eb.an(view);
    }

    private com.baidu.swan.apps.model.a.a.b PI() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.br(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b eN(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.br(true);
        bVar.setTop(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
