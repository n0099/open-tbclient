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
    private static final int ctX = d.S(42.0f);
    private static volatile b ctZ = null;
    private int ctY;
    private ViewTreeObserver.OnGlobalLayoutListener cua = null;
    private int mBottomNavigationKeyHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private int mLastVisibleHeight;

    private b() {
    }

    public static b aqW() {
        if (ctZ == null) {
            synchronized (b.class) {
                if (ctZ == null) {
                    ctZ = new b();
                }
            }
        }
        return ctZ;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d WX = f.WV().WX();
        boolean z = (WX == null || az(aVar.getContentView()) || !WX.a(aVar.getContentView(), aqX())) ? false : true;
        if (z) {
            if (!aVar.aqU() || WX == null) {
                return false;
            }
            a(WX.aqv(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.mLastVisibleHeight = view.getHeight();
            this.cua = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
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
                            b.this.ctY = i - b.ctX;
                            b.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - b.this.mBottomNavigationKeyHeight;
                            if (b.this.mInputMethodHeight > 0 && !b.this.a(aVar, b.this.mInputMethodHeight, b.this.ctY)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.cua);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d WX = f.WV().WX();
        boolean z = WX != null && WX.b(aVar.getContentView(), ic(i2));
        if (z) {
            aVar.ib(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d WX = f.WV().WX();
        if (WX == null) {
            return false;
        }
        FrameLayout aqv = WX.aqv();
        if (aqv != null && this.cua != null) {
            aqv.getViewTreeObserver().removeOnGlobalLayoutListener(this.cua);
        }
        aVar.hideKeyboard();
        this.cua = null;
        this.mInputMethodHeight = -1;
        this.ctY = -1;
        this.mBottomNavigationKeyHeight = -1;
        this.mIsFirstGlobalLayout = false;
        this.mLastVisibleHeight = -1;
        return WX.au(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d WX = f.WV().WX();
        return WX != null && WX.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aqX() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dd(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a ic(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.dd(true);
        aVar.fz(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
