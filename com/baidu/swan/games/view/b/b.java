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
    private static final int blD = com.baidu.swan.games.utils.b.ad(42.0f);
    private static volatile b blJ = null;
    private int blE;
    private int blF;
    private int blG;
    private boolean blH;
    private int blI;
    private ViewTreeObserver.OnGlobalLayoutListener blK = null;

    private b() {
    }

    public static b Tc() {
        if (blJ == null) {
            synchronized (b.class) {
                if (blJ == null) {
                    blJ = new b();
                }
            }
        }
        return blJ;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b FW = e.FV().FW();
        boolean z = (FW == null || as(aVar.getContentView()) || !FW.a(aVar.getContentView(), Td())) ? false : true;
        if (z) {
            if (!aVar.Ta() || FW == null) {
                return false;
            }
            a(FW.SF(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.blI = view.getHeight();
            this.blK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = z.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = z.getStatusBarHeight();
                        if (!b.this.blH) {
                            b.this.blH = true;
                            b.this.blG = (displayHeight - i) - statusBarHeight;
                            if (b.this.blG < 0) {
                                b.this.blG = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.blI || view.getHeight() - i <= 200) {
                                if (i > b.this.blI && view.getHeight() - i < 200) {
                                    b.this.blI = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.blI = i;
                            b.this.blF = i - b.blD;
                            b.this.blE = ((displayHeight - i) - statusBarHeight) - b.this.blG;
                            if (b.this.blE > 0 && !b.this.a(aVar, b.this.blE, b.this.blF)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.blK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b FW = e.FV().FW();
        boolean z = FW != null && FW.b(aVar.getContentView(), fh(i2));
        if (z) {
            aVar.fg(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b FW = e.FV().FW();
        if (FW == null) {
            return false;
        }
        FrameLayout SF = FW.SF();
        if (SF != null && this.blK != null) {
            SF.getViewTreeObserver().removeOnGlobalLayoutListener(this.blK);
        }
        aVar.hideKeyboard();
        this.blK = null;
        this.blE = -1;
        this.blF = -1;
        this.blG = -1;
        this.blH = false;
        this.blI = -1;
        return FW.al(aVar.getContentView());
    }

    private boolean as(View view) {
        com.baidu.swan.games.view.b FW = e.FV().FW();
        return FW != null && FW.aq(view);
    }

    private com.baidu.swan.apps.model.a.a.b Td() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bz(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b fh(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bz(true);
        bVar.setTop(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
