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
    private static final int diL = d.D(42.0f);
    private static volatile b diR = null;
    private int diM;
    private int diN;
    private int diO;
    private boolean diP;
    private int diQ;
    private ViewTreeObserver.OnGlobalLayoutListener diS = null;

    private b() {
    }

    public static b aEf() {
        if (diR == null) {
            synchronized (b.class) {
                if (diR == null) {
                    diR = new b();
                }
            }
        }
        return diR;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d aje = f.ajb().aje();
        boolean z = (aje == null || az(aVar.getContentView()) || !aje.a(aVar.getContentView(), aEg())) ? false : true;
        if (z) {
            if (!aVar.aEd() || aje == null) {
                return false;
            }
            a(aje.aDF(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.diQ = view.getHeight();
            this.diS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ag.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ag.getStatusBarHeight();
                        if (!b.this.diP) {
                            b.this.diP = true;
                            b.this.diO = (displayHeight - i) - statusBarHeight;
                            if (b.this.diO < 0) {
                                b.this.diO = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.diQ || view.getHeight() - i <= 200) {
                                if (i > b.this.diQ && view.getHeight() - i < 200) {
                                    b.this.diQ = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.diQ = i;
                            b.this.diN = i - b.diL;
                            b.this.diM = ((displayHeight - i) - statusBarHeight) - b.this.diO;
                            if (b.this.diM > 0 && !b.this.a(aVar, b.this.diM, b.this.diN)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.diS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d aje = f.ajb().aje();
        boolean z = aje != null && aje.b(aVar.getContentView(), iN(i2));
        if (z) {
            aVar.iM(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d aje = f.ajb().aje();
        if (aje == null) {
            return false;
        }
        FrameLayout aDF = aje.aDF();
        if (aDF != null && this.diS != null) {
            aDF.getViewTreeObserver().removeOnGlobalLayoutListener(this.diS);
        }
        aVar.hideKeyboard();
        this.diS = null;
        this.diM = -1;
        this.diN = -1;
        this.diO = -1;
        this.diP = false;
        this.diQ = -1;
        return aje.av(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d aje = f.ajb().aje();
        return aje != null && aje.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aEg() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.ev(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a iN(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.ev(true);
        aVar.gi(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
