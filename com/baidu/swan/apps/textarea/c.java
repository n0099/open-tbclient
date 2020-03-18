package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bXM;
    private static volatile c bXN;
    private int bXK;
    private String bXL;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bXH = 0;
    private int bsk = 200;

    public static c agg() {
        if (bXN == null) {
            synchronized (c.class) {
                if (bXN == null) {
                    bXN = new c();
                }
            }
        }
        return bXN;
    }

    private void as(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bXM != null) {
                        c.bXM.gr(c.this.bXL);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bXK == c.this.bXH) {
                        c.this.bXK = height;
                    } else if (c.this.bXK != height) {
                        if (c.this.bXK - height > c.this.bsk) {
                            if (c.bXM != null) {
                                c.bXM.w(c.this.bXL, c.this.bXK - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bXK + " visibleHeight " + height);
                                }
                            }
                            c.this.bXK = height;
                        } else if (height - c.this.bXK > c.this.bsk) {
                            if (c.bXM != null) {
                                c.bXM.x(c.this.bXL, height - c.this.bXK);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bXK + " visibleHeight " + height);
                            }
                            c.this.bXK = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        as(view);
        this.bXL = str;
        bXM = aVar;
        this.bXK = 0;
    }

    public void at(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bXL = "";
        bXM = null;
        this.bXK = 0;
    }

    public static void release() {
        bXM = null;
        bXN = null;
    }
}
