package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cZU;
    private static volatile c cZV;
    private int cZS;
    private String cZT;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cZP = 0;
    private int cnb = 200;

    public static c aDU() {
        if (cZV == null) {
            synchronized (c.class) {
                if (cZV == null) {
                    cZV = new c();
                }
            }
        }
        return cZV;
    }

    private void ax(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cZU != null) {
                        c.cZU.ky(c.this.cZT);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cZS == c.this.cZP) {
                        c.this.cZS = height;
                    } else if (c.this.cZS != height) {
                        if (c.this.cZS - height > c.this.cnb) {
                            if (c.cZU != null) {
                                c.cZU.J(c.this.cZT, c.this.cZS - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cZS + " visibleHeight " + height);
                                }
                            }
                            c.this.cZS = height;
                        } else if (height - c.this.cZS > c.this.cnb) {
                            if (c.cZU != null) {
                                c.cZU.K(c.this.cZT, height - c.this.cZS);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cZS + " visibleHeight " + height);
                            }
                            c.this.cZS = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        ax(view);
        this.cZT = str;
        cZU = aVar;
        this.cZS = 0;
    }

    public void ay(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cZT = "";
        cZU = null;
        this.cZS = 0;
    }

    public static void release() {
        cZU = null;
        cZV = null;
    }
}
