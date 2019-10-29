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
    private static final int bFB = com.baidu.swan.games.utils.b.S(42.0f);
    private static volatile b bFH = null;
    private int bFC;
    private int bFD;
    private int bFE;
    private boolean bFF;
    private int bFG;
    private ViewTreeObserver.OnGlobalLayoutListener bFI = null;

    private b() {
    }

    public static b YQ() {
        if (bFH == null) {
            synchronized (b.class) {
                if (bFH == null) {
                    bFH = new b();
                }
            }
        }
        return bFH;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b LE = e.LD().LE();
        boolean z = (LE == null || aA(aVar.getContentView()) || !LE.a(aVar.getContentView(), YR())) ? false : true;
        if (z) {
            if (!aVar.YO() || LE == null) {
                return false;
            }
            a(LE.Yt(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bFG = view.getHeight();
            this.bFI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = z.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = z.getStatusBarHeight();
                        if (!b.this.bFF) {
                            b.this.bFF = true;
                            b.this.bFE = (displayHeight - i) - statusBarHeight;
                            if (b.this.bFE < 0) {
                                b.this.bFE = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bFG || view.getHeight() - i <= 200) {
                                if (i > b.this.bFG && view.getHeight() - i < 200) {
                                    b.this.bFG = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bFG = i;
                            b.this.bFD = i - b.bFB;
                            b.this.bFC = ((displayHeight - i) - statusBarHeight) - b.this.bFE;
                            if (b.this.bFC > 0 && !b.this.a(aVar, b.this.bFC, b.this.bFD)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bFI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b LE = e.LD().LE();
        boolean z = LE != null && LE.b(aVar.getContentView(), gh(i2));
        if (z) {
            aVar.gg(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b LE = e.LD().LE();
        if (LE == null) {
            return false;
        }
        FrameLayout Yt = LE.Yt();
        if (Yt != null && this.bFI != null) {
            Yt.getViewTreeObserver().removeOnGlobalLayoutListener(this.bFI);
        }
        aVar.hideKeyboard();
        this.bFI = null;
        this.bFC = -1;
        this.bFD = -1;
        this.bFE = -1;
        this.bFF = false;
        this.bFG = -1;
        return LE.at(aVar.getContentView());
    }

    private boolean aA(View view) {
        com.baidu.swan.games.view.b LE = e.LD().LE();
        return LE != null && LE.ay(view);
    }

    private com.baidu.swan.apps.model.a.a.b YR() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bU(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b gh(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bU(true);
        bVar.dJ(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
