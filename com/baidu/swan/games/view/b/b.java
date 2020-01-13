package com.baidu.swan.games.view.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.utils.d;
/* loaded from: classes10.dex */
public class b {
    private static final int cpJ = d.S(42.0f);
    private static volatile b cpL = null;
    private int cpK;
    private ViewTreeObserver.OnGlobalLayoutListener cpM = null;
    private int mBottomNavigationKeyHeight;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    private int mLastVisibleHeight;

    private b() {
    }

    public static b aoD() {
        if (cpL == null) {
            synchronized (b.class) {
                if (cpL == null) {
                    cpL = new b();
                }
            }
        }
        return cpL;
    }

    public boolean f(a aVar) {
        com.baidu.swan.games.view.d UE = f.UC().UE();
        boolean z = (UE == null || az(aVar.getContentView()) || !UE.a(aVar.getContentView(), aoE())) ? false : true;
        if (z) {
            if (!aVar.aoB() || UE == null) {
                return false;
            }
            a(UE.aoc(), aVar);
        }
        return z;
    }

    private void a(final View view, final a aVar) {
        if (view != null && aVar != null) {
            this.mLastVisibleHeight = view.getHeight();
            this.cpM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.games.view.b.b.1
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
                            b.this.cpK = i - b.cpJ;
                            b.this.mInputMethodHeight = ((displayHeight - i) - statusBarHeight) - b.this.mBottomNavigationKeyHeight;
                            if (b.this.mInputMethodHeight > 0 && !b.this.a(aVar, b.this.mInputMethodHeight, b.this.cpK)) {
                                b.this.g(aVar);
                            }
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.cpM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a aVar, int i, int i2) {
        com.baidu.swan.games.view.d UE = f.UC().UE();
        boolean z = UE != null && UE.b(aVar.getContentView(), hL(i2));
        if (z) {
            aVar.hK(i);
        }
        return z;
    }

    public boolean g(a aVar) {
        com.baidu.swan.games.view.d UE = f.UC().UE();
        if (UE == null) {
            return false;
        }
        FrameLayout aoc = UE.aoc();
        if (aoc != null && this.cpM != null) {
            aoc.getViewTreeObserver().removeOnGlobalLayoutListener(this.cpM);
        }
        aVar.hideKeyboard();
        this.cpM = null;
        this.mInputMethodHeight = -1;
        this.cpK = -1;
        this.mBottomNavigationKeyHeight = -1;
        this.mIsFirstGlobalLayout = false;
        this.mLastVisibleHeight = -1;
        return UE.au(aVar.getContentView());
    }

    private boolean az(View view) {
        com.baidu.swan.games.view.d UE = f.UC().UE();
        return UE != null && UE.ax(view);
    }

    private com.baidu.swan.apps.model.a.a.a aoE() {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.cV(true);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }

    private com.baidu.swan.apps.model.a.a.a hL(int i) {
        com.baidu.swan.apps.model.a.a.a aVar = new com.baidu.swan.apps.model.a.a.a();
        aVar.cV(true);
        aVar.fj(i);
        aVar.setWidth(-1);
        aVar.setHeight(-2);
        return aVar;
    }
}
