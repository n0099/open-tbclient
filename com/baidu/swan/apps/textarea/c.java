package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bXA;
    private static a bXz;
    private int bXx;
    private String bXy;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bXu = 0;
    private int brW = 200;

    public static c agb() {
        if (bXA == null) {
            synchronized (c.class) {
                if (bXA == null) {
                    bXA = new c();
                }
            }
        }
        return bXA;
    }

    private void as(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bXz != null) {
                        c.bXz.gt(c.this.bXy);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bXx == c.this.bXu) {
                        c.this.bXx = height;
                    } else if (c.this.bXx != height) {
                        if (c.this.bXx - height > c.this.brW) {
                            if (c.bXz != null) {
                                c.bXz.w(c.this.bXy, c.this.bXx - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bXx + " visibleHeight " + height);
                                }
                            }
                            c.this.bXx = height;
                        } else if (height - c.this.bXx > c.this.brW) {
                            if (c.bXz != null) {
                                c.bXz.x(c.this.bXy, height - c.this.bXx);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bXx + " visibleHeight " + height);
                            }
                            c.this.bXx = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        as(view);
        this.bXy = str;
        bXz = aVar;
        this.bXx = 0;
    }

    public void at(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bXy = "";
        bXz = null;
        this.bXx = 0;
    }

    public static void release() {
        bXz = null;
        bXA = null;
    }
}
