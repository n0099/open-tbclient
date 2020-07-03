package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cNv;
    private static volatile c cNw;
    private int cNt;
    private String cNu;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cNq = 0;
    private int ceX = 200;

    public static c atK() {
        if (cNw == null) {
            synchronized (c.class) {
                if (cNw == null) {
                    cNw = new c();
                }
            }
        }
        return cNw;
    }

    private void at(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cNv != null) {
                        c.cNv.iN(c.this.cNu);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cNt == c.this.cNq) {
                        c.this.cNt = height;
                    } else if (c.this.cNt != height) {
                        if (c.this.cNt - height > c.this.ceX) {
                            if (c.cNv != null) {
                                c.cNv.I(c.this.cNu, c.this.cNt - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cNt + " visibleHeight " + height);
                                }
                            }
                            c.this.cNt = height;
                        } else if (height - c.this.cNt > c.this.ceX) {
                            if (c.cNv != null) {
                                c.cNv.J(c.this.cNu, height - c.this.cNt);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cNt + " visibleHeight " + height);
                            }
                            c.this.cNt = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        at(view);
        this.cNu = str;
        cNv = aVar;
        this.cNt = 0;
    }

    public void au(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cNu = "";
        cNv = null;
        this.cNt = 0;
    }

    public static void release() {
        cNv = null;
        cNw = null;
    }
}
