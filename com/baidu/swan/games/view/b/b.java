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
    private static final int cSW = d.C(42.0f);
    private static volatile b cTc = null;
    private int cSX;
    private int cSY;
    private int cSZ;
    private boolean cTa;
    private int cTb;
    private ViewTreeObserver.OnGlobalLayoutListener cTd = null;

    private b() {
    }

    public static b azh() {
        if (cTc == null) {
            synchronized (b.class) {
                if (cTc == null) {
                    cTc = new b();
                }
            }
        }
        return cTc;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d aeM = f.aeJ().aeM();
        boolean z = (aeM == null || aA(aVar.getContentView()) || !aeM.a(aVar.getContentView(), azi())) ? false : true;
        if (z) {
            if (!aVar.azf() || aeM == null) {
                return false;
            }
            a(aeM.ayH(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.cTb = view.getHeight();
            this.cTd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = af.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = af.getStatusBarHeight();
                        if (!b.this.cTa) {
                            b.this.cTa = true;
                            b.this.cSZ = (displayHeight - i) - statusBarHeight;
                            if (b.this.cSZ < 0) {
                                b.this.cSZ = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.cTb || view.getHeight() - i <= 200) {
                                if (i > b.this.cTb && view.getHeight() - i < 200) {
                                    b.this.cTb = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.cTb = i;
                            b.this.cSY = i - b.cSW;
                            b.this.cSX = ((displayHeight - i) - statusBarHeight) - b.this.cSZ;
                            if (b.this.cSX > 0 && !b.this.a(aVar, b.this.cSX, b.this.cSY)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.cTd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d aeM = f.aeJ().aeM();
        boolean z = aeM != null && aeM.b(aVar.getContentView(), ij(i2));
        if (z) {
            aVar.ii(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d aeM = f.aeJ().aeM();
        if (aeM == null) {
            return false;
        }
        FrameLayout ayH = aeM.ayH();
        if (ayH != null && this.cTd != null) {
            ayH.getViewTreeObserver().removeOnGlobalLayoutListener(this.cTd);
        }
        aVar.hideKeyboard();
        this.cTd = null;
        this.cSX = -1;
        this.cSY = -1;
        this.cSZ = -1;
        this.cTa = false;
        this.cTb = -1;
        return aeM.av(aVar.getContentView());
    }

    private boolean aA(View view) {
        com.baidu.swan.games.view.d aeM = f.aeJ().aeM();
        return aeM != null && aeM.ay(view);
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
