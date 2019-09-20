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
    private static final int bmP = com.baidu.swan.games.utils.b.ad(42.0f);
    private static volatile b bmV = null;
    private int bmQ;
    private int bmR;
    private int bmS;
    private boolean bmT;
    private int bmU;
    private ViewTreeObserver.OnGlobalLayoutListener bmW = null;

    private b() {
    }

    public static b TZ() {
        if (bmV == null) {
            synchronized (b.class) {
                if (bmV == null) {
                    bmV = new b();
                }
            }
        }
        return bmV;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b GK = e.GJ().GK();
        boolean z = (GK == null || au(aVar.getContentView()) || !GK.a(aVar.getContentView(), Ua())) ? false : true;
        if (z) {
            if (!aVar.TX() || GK == null) {
                return false;
            }
            a(GK.TC(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bmU = view.getHeight();
            this.bmW = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = z.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = z.getStatusBarHeight();
                        if (!b.this.bmT) {
                            b.this.bmT = true;
                            b.this.bmS = (displayHeight - i) - statusBarHeight;
                            if (b.this.bmS < 0) {
                                b.this.bmS = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bmU || view.getHeight() - i <= 200) {
                                if (i > b.this.bmU && view.getHeight() - i < 200) {
                                    b.this.bmU = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bmU = i;
                            b.this.bmR = i - b.bmP;
                            b.this.bmQ = ((displayHeight - i) - statusBarHeight) - b.this.bmS;
                            if (b.this.bmQ > 0 && !b.this.a(aVar, b.this.bmQ, b.this.bmR)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bmW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b GK = e.GJ().GK();
        boolean z = GK != null && GK.b(aVar.getContentView(), fm(i2));
        if (z) {
            aVar.fl(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b GK = e.GJ().GK();
        if (GK == null) {
            return false;
        }
        FrameLayout TC = GK.TC();
        if (TC != null && this.bmW != null) {
            TC.getViewTreeObserver().removeOnGlobalLayoutListener(this.bmW);
        }
        aVar.hideKeyboard();
        this.bmW = null;
        this.bmQ = -1;
        this.bmR = -1;
        this.bmS = -1;
        this.bmT = false;
        this.bmU = -1;
        return GK.an(aVar.getContentView());
    }

    private boolean au(View view) {
        com.baidu.swan.games.view.b GK = e.GJ().GK();
        return GK != null && GK.as(view);
    }

    private com.baidu.swan.apps.model.a.a.b Ua() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bC(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b fm(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bC(true);
        bVar.cO(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
