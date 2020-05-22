package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cIL;
    private static volatile c cIM;
    private int cIJ;
    private String cIK;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cIG = 0;
    private int cah = 200;

    public static c asE() {
        if (cIM == null) {
            synchronized (c.class) {
                if (cIM == null) {
                    cIM = new c();
                }
            }
        }
        return cIM;
    }

    private void at(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cIL != null) {
                        c.cIL.iF(c.this.cIK);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cIJ == c.this.cIG) {
                        c.this.cIJ = height;
                    } else if (c.this.cIJ != height) {
                        if (c.this.cIJ - height > c.this.cah) {
                            if (c.cIL != null) {
                                c.cIL.I(c.this.cIK, c.this.cIJ - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cIJ + " visibleHeight " + height);
                                }
                            }
                            c.this.cIJ = height;
                        } else if (height - c.this.cIJ > c.this.cah) {
                            if (c.cIL != null) {
                                c.cIL.J(c.this.cIK, height - c.this.cIJ);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cIJ + " visibleHeight " + height);
                            }
                            c.this.cIJ = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        at(view);
        this.cIK = str;
        cIL = aVar;
        this.cIJ = 0;
    }

    public void au(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cIK = "";
        cIL = null;
        this.cIJ = 0;
    }

    public static void release() {
        cIL = null;
        cIM = null;
    }
}
