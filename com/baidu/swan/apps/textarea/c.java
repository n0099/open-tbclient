package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dCy;
    private static volatile c dCz;
    private int dCw;
    private String dCx;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dCt = 0;
    private int cPI = 200;

    public static c aLH() {
        if (dCz == null) {
            synchronized (c.class) {
                if (dCz == null) {
                    dCz = new c();
                }
            }
        }
        return dCz;
    }

    private void aF(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dCy != null) {
                        c.dCy.ml(c.this.dCx);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dCw == c.this.dCt) {
                        c.this.dCw = height;
                    } else if (c.this.dCw != height) {
                        if (c.this.dCw - height > c.this.cPI) {
                            if (c.dCy != null) {
                                c.dCy.M(c.this.dCx, c.this.dCw - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dCw + " visibleHeight " + height);
                                }
                            }
                            c.this.dCw = height;
                        } else if (height - c.this.dCw > c.this.cPI) {
                            if (c.dCy != null) {
                                c.dCy.N(c.this.dCx, height - c.this.dCw);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dCw + " visibleHeight " + height);
                            }
                            c.this.dCw = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aF(view);
        this.dCx = str;
        dCy = aVar;
        this.dCw = 0;
    }

    public void aG(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dCx = "";
        dCy = null;
        this.dCw = 0;
    }

    public static void release() {
        dCy = null;
        dCz = null;
    }
}
