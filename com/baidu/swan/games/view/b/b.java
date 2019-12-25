package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.utils.d;
/* loaded from: classes9.dex */
public class b {
    private static final int cpx = d.T(42.0f);
    private static volatile b cpz = null;
    private ViewTreeObserver.OnGlobalLayoutListener cpA = null;
    private int cpy;
    private int mBottomNavigationKeyHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private int mLastVisibleHeight;

    private b() {
    }

    public static b aok() {
        if (cpz == null) {
            synchronized (b.class) {
                if (cpz == null) {
                    cpz = new b();
                }
            }
        }
        return cpz;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d Uh = f.Uf().Uh();
        boolean z = (Uh == null || av(aVar.getContentView()) || !Uh.a(aVar.getContentView(), aol())) ? false : true;
        if (z) {
            if (!aVar.aoi() || Uh == null) {
                return false;
            }
            a(Uh.anJ(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.mLastVisibleHeight = view.getHeight();
            this.cpA = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
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
                            b.this.cpy = i - b.cpx;
                            b.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - b.this.mBottomNavigationKeyHeight;
                            if (b.this.mInputMethodHeight > 0 && !b.this.a(aVar, b.this.mInputMethodHeight, b.this.cpy)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.cpA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d Uh = f.Uf().Uh();
        boolean z = Uh != null && Uh.b(aVar.getContentView(), hL(i2));
        if (z) {
            aVar.hK(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d Uh = f.Uf().Uh();
        if (Uh == null) {
            return false;
        }
        FrameLayout anJ = Uh.anJ();
        if (anJ != null && this.cpA != null) {
            anJ.getViewTreeObserver().removeOnGlobalLayoutListener(this.cpA);
        }
        aVar.hideKeyboard();
        this.cpA = null;
        this.mInputMethodHeight = -1;
        this.cpy = -1;
        this.mBottomNavigationKeyHeight = -1;
        this.mIsFirstGlobalLayout = false;
        this.mLastVisibleHeight = -1;
        return Uh.aq(aVar.getContentView());
    }

    private boolean av(View view) {
        com.baidu.swan.games.view.d Uh = f.Uf().Uh();
        return Uh != null && Uh.at(view);
    }

    private com.baidu.swan.apps.model.a.a.a aol() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.cQ(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a hL(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.cQ(true);
        aVar.fi(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
