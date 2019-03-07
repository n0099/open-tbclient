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
    private static final int bgk = com.baidu.swan.games.utils.b.ad(52.0f);
    private static volatile b bgq = null;
    private int bgl;
    private int bgm;
    private int bgn;
    private boolean bgo;
    private int bgp;
    private ViewTreeObserver.OnGlobalLayoutListener bgr = null;

    private b() {
    }

    public static b PJ() {
        if (bgq == null) {
            synchronized (b.class) {
                if (bgq == null) {
                    bgq = new b();
                }
            }
        }
        return bgq;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.b Ed = e.Ec().Ed();
        boolean z = (Ed == null || ao(aVar.getContentView()) || !Ed.a(aVar.getContentView(), PK())) ? false : true;
        if (z) {
            if (!aVar.PH() || Ed == null) {
                return false;
            }
            a(Ed.Po(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.bgp = view.getHeight();
            this.bgr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = x.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = x.getStatusBarHeight();
                        if (!b.this.bgo) {
                            b.this.bgo = true;
                            b.this.bgn = (displayHeight - i) - statusBarHeight;
                            if (b.this.bgn < 0) {
                                b.this.bgn = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.bgp || view.getHeight() - i <= 200) {
                                if (i > b.this.bgp && view.getHeight() - i < 200) {
                                    b.this.bgp = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.bgp = i;
                            b.this.bgm = i - b.bgk;
                            b.this.bgl = ((displayHeight - i) - statusBarHeight) - b.this.bgn;
                            if (b.this.bgl > 0 && !b.this.a(aVar, b.this.bgl, b.this.bgm)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bgr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.b Ed = e.Ec().Ed();
        boolean z = Ed != null && Ed.b(aVar.getContentView(), eO(i2));
        if (z) {
            aVar.eN(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.b Ed = e.Ec().Ed();
        if (Ed == null) {
            return false;
        }
        FrameLayout Po = Ed.Po();
        if (Po != null && this.bgr != null) {
            Po.getViewTreeObserver().removeOnGlobalLayoutListener(this.bgr);
        }
        aVar.hideKeyboard();
        this.bgr = null;
        this.bgl = -1;
        this.bgm = -1;
        this.bgn = -1;
        this.bgo = false;
        this.bgp = -1;
        return Ed.ai(aVar.getContentView());
    }

    private boolean ao(View view) {
        com.baidu.swan.games.view.b Ed = e.Ec().Ed();
        return Ed != null && Ed.an(view);
    }

    private com.baidu.swan.apps.model.a.a.b PK() {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.br(true);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }

    private com.baidu.swan.apps.model.a.a.b eO(int i) {
        com.baidu.swan.apps.model.a.a.b bVar = new com.baidu.swan.apps.model.a.a.b();
        bVar.br(true);
        bVar.setTop(i);
        bVar.setWidth(-1);
        bVar.setHeight(-2);
        return bVar;
    }
}
