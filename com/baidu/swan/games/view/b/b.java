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
    private static final int eos = e.T(42.0f);
    private static volatile b eoy = null;
    private int eot;
    private int eou;
    private int eov;
    private boolean eow;
    private int eox;
    private ViewTreeObserver.OnGlobalLayoutListener eoz = null;

    private b() {
    }

    public static b aZQ() {
        if (eoy == null) {
            synchronized (b.class) {
                if (eoy == null) {
                    eoy = new b();
                }
            }
        }
        return eoy;
    }

    public boolean f(a aVar) {
        d aAr = f.aAo().aAr();
        boolean z = (aAr == null || aV(aVar.getContentView()) || !aAr.a(aVar.getContentView(), aZR())) ? false : true;
        if (z) {
            if (!aVar.aZO() || aAr == null) {
                return false;
            }
            a(aAr.aZo(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.eox = view.getHeight();
            this.eoz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.eow) {
                            b.this.eow = true;
                            b.this.eov = (displayHeight - i) - statusBarHeight;
                            if (b.this.eov < 0) {
                                b.this.eov = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.eox || view.getHeight() - i <= 200) {
                                if (i > b.this.eox && view.getHeight() - i < 200) {
                                    b.this.eox = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.eox = i;
                            b.this.eou = i - b.eos;
                            b.this.eot = ((displayHeight - i) - statusBarHeight) - b.this.eov;
                            if (b.this.eot > 0 && !b.this.a(aVar, b.this.eot, b.this.eou)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.eoz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d aAr = f.aAo().aAr();
        boolean z = aAr != null && aAr.b(aVar.getContentView(), lq(i2));
        if (z) {
            aVar.lp(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d aAr = f.aAo().aAr();
        if (aAr == null) {
            return false;
        }
        FrameLayout aZo = aAr.aZo();
        if (aZo != null && this.eoz != null) {
            aZo.getViewTreeObserver().removeOnGlobalLayoutListener(this.eoz);
        }
        aVar.hideKeyboard();
        this.eoz = null;
        this.eot = -1;
        this.eou = -1;
        this.eov = -1;
        this.eow = false;
        this.eox = -1;
        return aAr.removeView(aVar.getContentView());
    }

    private boolean aV(View view) {
        d aAr = f.aAo().aAr();
        return aAr != null && aAr.aT(view);
    }

    private com.baidu.swan.apps.model.a.a.a aZR() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gk(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a lq(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.gk(true);
        aVar.io(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
