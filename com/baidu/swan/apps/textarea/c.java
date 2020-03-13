package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bXB;
    private static volatile c bXC;
    private String bXA;
    private int bXz;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bXw = 0;
    private int brY = 200;

    public static c agd() {
        if (bXC == null) {
            synchronized (c.class) {
                if (bXC == null) {
                    bXC = new c();
                }
            }
        }
        return bXC;
    }

    private void as(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bXB != null) {
                        c.bXB.gt(c.this.bXA);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bXz == c.this.bXw) {
                        c.this.bXz = height;
                    } else if (c.this.bXz != height) {
                        if (c.this.bXz - height > c.this.brY) {
                            if (c.bXB != null) {
                                c.bXB.w(c.this.bXA, c.this.bXz - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bXz + " visibleHeight " + height);
                                }
                            }
                            c.this.bXz = height;
                        } else if (height - c.this.bXz > c.this.brY) {
                            if (c.bXB != null) {
                                c.bXB.x(c.this.bXA, height - c.this.bXz);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bXz + " visibleHeight " + height);
                            }
                            c.this.bXz = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        as(view);
        this.bXA = str;
        bXB = aVar;
        this.bXz = 0;
    }

    public void at(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bXA = "";
        bXB = null;
        this.bXz = 0;
    }

    public static void release() {
        bXB = null;
        bXC = null;
    }
}
