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
    private static final int bmr = com.baidu.swan.games.utils.b.ad(42.0f);
    private static volatile b bmx = null;
    private int bms;
    private int bmt;
    private int bmu;
    private boolean bmv;
    private int bmw;
    private ViewTreeObserver.OnGlobalLayoutListener bmy = null;

    private b() {
    }

    public static b TV() {
        if (bmx == null) {
            synchronized (b.class) {
                if (bmx == null) {
                    bmx = new b();
                }
            }
        }
        return bmx;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b GG = e.GF().GG();
        boolean z = (GG == null || au(aVar.getContentView()) || !GG.a(aVar.getContentView(), TW())) ? false : true;
        if (z) {
            if (!aVar.TT() || GG == null) {
                return false;
            }
            a(GG.Ty(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bmw = view.getHeight();
            this.bmy = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = z.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = z.getStatusBarHeight();
                        if (!b.this.bmv) {
                            b.this.bmv = true;
                            b.this.bmu = (displayHeight - i) - statusBarHeight;
                            if (b.this.bmu < 0) {
                                b.this.bmu = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bmw || view.getHeight() - i <= 200) {
                                if (i > b.this.bmw && view.getHeight() - i < 200) {
                                    b.this.bmw = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bmw = i;
                            b.this.bmt = i - b.bmr;
                            b.this.bms = ((displayHeight - i) - statusBarHeight) - b.this.bmu;
                            if (b.this.bms > 0 && !b.this.a(aVar, b.this.bms, b.this.bmt)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bmy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b GG = e.GF().GG();
        boolean z = GG != null && GG.b(aVar.getContentView(), fl(i2));
        if (z) {
            aVar.fk(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b GG = e.GF().GG();
        if (GG == null) {
            return false;
        }
        FrameLayout Ty = GG.Ty();
        if (Ty != null && this.bmy != null) {
            Ty.getViewTreeObserver().removeOnGlobalLayoutListener(this.bmy);
        }
        aVar.hideKeyboard();
        this.bmy = null;
        this.bms = -1;
        this.bmt = -1;
        this.bmu = -1;
        this.bmv = false;
        this.bmw = -1;
        return GG.an(aVar.getContentView());
    }

    private boolean au(View view) {
        com.baidu.swan.games.view.b GG = e.GF().GG();
        return GG != null && GG.as(view);
    }

    private com.baidu.swan.apps.model.a.a.b TW() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bC(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b fl(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.bC(true);
        bVar.cN(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
