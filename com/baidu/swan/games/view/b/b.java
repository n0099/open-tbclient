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
    private static final int ctK = d.S(42.0f);
    private static volatile b ctM = null;
    private int ctL;
    private ViewTreeObserver.OnGlobalLayoutListener ctN = null;
    private int mBottomNavigationKeyHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private int mLastVisibleHeight;

    private b() {
    }

    public static b aqR() {
        if (ctM == null) {
            synchronized (b.class) {
                if (ctM == null) {
                    ctM = new b();
                }
            }
        }
        return ctM;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d WS = f.WQ().WS();
        boolean z = (WS == null || az(aVar.getContentView()) || !WS.a(aVar.getContentView(), aqS())) ? false : true;
        if (z) {
            if (!aVar.aqP() || WS == null) {
                return false;
            }
            a(WS.aqq(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.mLastVisibleHeight = view.getHeight();
            this.ctN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
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
                            b.this.ctL = i - b.ctK;
                            b.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - b.this.mBottomNavigationKeyHeight;
                            if (b.this.mInputMethodHeight > 0 && !b.this.a(aVar, b.this.mInputMethodHeight, b.this.ctL)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.ctN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d WS = f.WQ().WS();
        boolean z = WS != null && WS.b(aVar.getContentView(), ic(i2));
        if (z) {
            aVar.ib(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d WS = f.WQ().WS();
        if (WS == null) {
            return false;
        }
        FrameLayout aqq = WS.aqq();
        if (aqq != null && this.ctN != null) {
            aqq.getViewTreeObserver().removeOnGlobalLayoutListener(this.ctN);
        }
        aVar.hideKeyboard();
        this.ctN = null;
        this.mInputMethodHeight = -1;
        this.ctL = -1;
        this.mBottomNavigationKeyHeight = -1;
        this.mIsFirstGlobalLayout = false;
        this.mLastVisibleHeight = -1;
        return WS.au(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d WS = f.WQ().WS();
        return WS != null && WS.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aqS() {
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
