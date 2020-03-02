package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bXA;
    private static volatile c bXB;
    private int bXy;
    private String bXz;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bXv = 0;
    private int brX = 200;

    public static c agd() {
        if (bXB == null) {
            synchronized (c.class) {
                if (bXB == null) {
                    bXB = new c();
                }
            }
        }
        return bXB;
    }

    private void as(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bXA != null) {
                        c.bXA.gt(c.this.bXz);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bXy == c.this.bXv) {
                        c.this.bXy = height;
                    } else if (c.this.bXy != height) {
                        if (c.this.bXy - height > c.this.brX) {
                            if (c.bXA != null) {
                                c.bXA.w(c.this.bXz, c.this.bXy - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bXy + " visibleHeight " + height);
                                }
                            }
                            c.this.bXy = height;
                        } else if (height - c.this.bXy > c.this.brX) {
                            if (c.bXA != null) {
                                c.bXA.x(c.this.bXz, height - c.this.bXy);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bXy + " visibleHeight " + height);
                            }
                            c.this.bXy = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        as(view);
        this.bXz = str;
        bXA = aVar;
        this.bXy = 0;
    }

    public void at(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bXz = "";
        bXA = null;
        this.bXy = 0;
    }

    public static void release() {
        bXA = null;
        bXB = null;
    }
}
