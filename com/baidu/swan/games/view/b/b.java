package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.utils.d;
/* loaded from: classes7.dex */
public class b {
    private static final int doG = d.D(42.0f);
    private static volatile b doM = null;
    private int doH;
    private int doI;
    private int doJ;
    private boolean doK;
    private int doL;
    private ViewTreeObserver.OnGlobalLayoutListener doN = null;

    private b() {
    }

    public static b aHY() {
        if (doM == null) {
            synchronized (b.class) {
                if (doM == null) {
                    doM = new b();
                }
            }
        }
        return doM;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d aku = f.akr().aku();
        boolean z = (aku == null || aE(aVar.getContentView()) || !aku.a(aVar.getContentView(), aHZ())) ? false : true;
        if (z) {
            if (!aVar.aHW() || aku == null) {
                return false;
            }
            a(aku.aHv(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.doL = view.getHeight();
            this.doN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = ai.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = ai.getStatusBarHeight();
                        if (!b.this.doK) {
                            b.this.doK = true;
                            b.this.doJ = (displayHeight - i) - statusBarHeight;
                            if (b.this.doJ < 0) {
                                b.this.doJ = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.doL || view.getHeight() - i <= 200) {
                                if (i > b.this.doL && view.getHeight() - i < 200) {
                                    b.this.doL = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.doL = i;
                            b.this.doI = i - b.doG;
                            b.this.doH = ((displayHeight - i) - statusBarHeight) - b.this.doJ;
                            if (b.this.doH > 0 && !b.this.a(aVar, b.this.doH, b.this.doI)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.doN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d aku = f.akr().aku();
        boolean z = aku != null && aku.b(aVar.getContentView(), je(i2));
        if (z) {
            aVar.jd(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d aku = f.akr().aku();
        if (aku == null) {
            return false;
        }
        FrameLayout aHv = aku.aHv();
        if (aHv != null && this.doN != null) {
            aHv.getViewTreeObserver().removeOnGlobalLayoutListener(this.doN);
        }
        aVar.hideKeyboard();
        this.doN = null;
        this.doH = -1;
        this.doI = -1;
        this.doJ = -1;
        this.doK = false;
        this.doL = -1;
        return aku.ay(aVar.getContentView());
    }

    private boolean aE(View view) {
        com.baidu.swan.games.view.d aku = f.akr().aku();
        return aku != null && aku.aC(view);
    }

    private com.baidu.swan.apps.model.a.a.a aHZ() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eD(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a je(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.eD(true);
        aVar.gt(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
