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
    private static final int ctM = d.S(42.0f);
    private static volatile b ctO = null;
    private int ctN;
    private ViewTreeObserver.OnGlobalLayoutListener ctP = null;
    private int mBottomNavigationKeyHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private int mLastVisibleHeight;

    private b() {
    }

    public static b aqT() {
        if (ctO == null) {
            synchronized (b.class) {
                if (ctO == null) {
                    ctO = new b();
                }
            }
        }
        return ctO;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d WU = f.WS().WU();
        boolean z = (WU == null || az(aVar.getContentView()) || !WU.a(aVar.getContentView(), aqU())) ? false : true;
        if (z) {
            if (!aVar.aqR() || WU == null) {
                return false;
            }
            a(WU.aqs(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.mLastVisibleHeight = view.getHeight();
            this.ctP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    if (view != null) {
                        view.getWindowVisibleDisplayFrame(rect);
                        int i = rect.bottom - rect.top;
                        int displayHeight = af.getDisplayHeight(AppRuntime.getAppContext());
                        int statusBarHeight = af.getStatusBarHeight();
                        if (!b.this.mIsFirstGlobalLayout) {
                            b.this.mIsFirstGlobalLayout = true;
                            b.this.mBottomNavigationKeyHeight = (displayHeight - i) - statusBarHeight;
                            if (b.this.mBottomNavigationKeyHeight < 0) {
                                b.this.mBottomNavigationKeyHeight = 0;
                            }
                        }
                        if (i > 0) {
                            if (i >= b.this.mLastVisibleHeight || view.getHeight() - i <= 200) {
                                if (i > b.this.mLastVisibleHeight && view.getHeight() - i < 200) {
                                    b.this.mLastVisibleHeight = i;
                                    b.this.g(aVar);
                                    return;
                                }
                                return;
                            }
                            b.this.mLastVisibleHeight = i;
                            b.this.ctN = i - b.ctM;
                            b.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - b.this.mBottomNavigationKeyHeight;
                            if (b.this.mInputMethodHeight > 0 && !b.this.a(aVar, b.this.mInputMethodHeight, b.this.ctN)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.ctP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d WU = f.WS().WU();
        boolean z = WU != null && WU.b(aVar.getContentView(), ic(i2));
        if (z) {
            aVar.ib(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d WU = f.WS().WU();
        if (WU == null) {
            return false;
        }
        FrameLayout aqs = WU.aqs();
        if (aqs != null && this.ctP != null) {
            aqs.getViewTreeObserver().removeOnGlobalLayoutListener(this.ctP);
        }
        aVar.hideKeyboard();
        this.ctP = null;
        this.mInputMethodHeight = -1;
        this.ctN = -1;
        this.mBottomNavigationKeyHeight = -1;
        this.mIsFirstGlobalLayout = false;
        this.mLastVisibleHeight = -1;
        return WU.au(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d WU = f.WS().WU();
        return WU != null && WU.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aqU() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dc(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ic(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dc(true);
        aVar.fz(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
