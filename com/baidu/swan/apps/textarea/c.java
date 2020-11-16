package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dAR;
    private static volatile c dAS;
    private int dAP;
    private String dAQ;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dAM = 0;
    private int cNY = 200;

    public static c aKZ() {
        if (dAS == null) {
            synchronized (c.class) {
                if (dAS == null) {
                    dAS = new c();
                }
            }
        }
        return dAS;
    }

    private void aF(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dAR != null) {
                        c.dAR.mf(c.this.dAQ);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dAP == c.this.dAM) {
                        c.this.dAP = height;
                    } else if (c.this.dAP != height) {
                        if (c.this.dAP - height > c.this.cNY) {
                            if (c.dAR != null) {
                                c.dAR.M(c.this.dAQ, c.this.dAP - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dAP + " visibleHeight " + height);
                                }
                            }
                            c.this.dAP = height;
                        } else if (height - c.this.dAP > c.this.cNY) {
                            if (c.dAR != null) {
                                c.dAR.N(c.this.dAQ, height - c.this.dAP);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dAP + " visibleHeight " + height);
                            }
                            c.this.dAP = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aF(view);
        this.dAQ = str;
        dAR = aVar;
        this.dAP = 0;
    }

    public void aG(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dAQ = "";
        dAR = null;
        this.dAP = 0;
    }

    public static void release() {
        dAR = null;
        dAS = null;
    }
}
