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
/* loaded from: classes10.dex */
public class b {
    private static final int dVl = e.L(42.0f);
    private static volatile b dVr = null;
    private int dVm;
    private int dVn;
    private int dVo;
    private boolean dVp;
    private int dVq;
    private ViewTreeObserver.OnGlobalLayoutListener dVs = null;

    private b() {
    }

    public static b aWd() {
        if (dVr == null) {
            synchronized (b.class) {
                if (dVr == null) {
                    dVr = new b();
                }
            }
        }
        return dVr;
    }

    public boolean f(a aVar) {
        d axr = f.axo().axr();
        boolean z = (axr == null || aK(aVar.getContentView()) || !axr.a(aVar.getContentView(), aWe())) ? false : true;
        if (z) {
            if (!aVar.aWb() || axr == null) {
                return false;
            }
            a(axr.aVC(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.dVq = view.getHeight();
            this.dVs = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ah.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ah.getStatusBarHeight();
                        if (!b.this.dVp) {
                            b.this.dVp = true;
                            b.this.dVo = (displayHeight - i) - statusBarHeight;
                            if (b.this.dVo < 0) {
                                b.this.dVo = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.dVq || view.getHeight() - i <= 200) {
                                if (i > b.this.dVq && view.getHeight() - i < 200) {
                                    b.this.dVq = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.dVq = i;
                            b.this.dVn = i - b.dVl;
                            b.this.dVm = ((displayHeight - i) - statusBarHeight) - b.this.dVo;
                            if (b.this.dVm > 0 && !b.this.a(aVar, b.this.dVm, b.this.dVn)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.dVs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        d axr = f.axo().axr();
        boolean z = axr != null && axr.b(aVar.getContentView(), mg(i2));
        if (z) {
            aVar.mf(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        d axr = f.axo().axr();
        if (axr == null) {
            return false;
        }
        FrameLayout aVC = axr.aVC();
        if (aVC != null && this.dVs != null) {
            aVC.getViewTreeObserver().removeOnGlobalLayoutListener(this.dVs);
        }
        aVar.hideKeyboard();
        this.dVs = null;
        this.dVm = -1;
        this.dVn = -1;
        this.dVo = -1;
        this.dVp = false;
        this.dVq = -1;
        return axr.removeView(aVar.getContentView());
    }

    private boolean aK(View view) {
        d axr = f.axo().axr();
        return axr != null && axr.aI(view);
    }

    private com.baidu.swan.apps.model.a.a.a aWe() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fC(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a mg(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.fC(true);
        aVar.jr(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
