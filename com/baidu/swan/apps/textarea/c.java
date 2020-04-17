package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cwD;
    private static volatile c cwE;
    private int cwB;
    private String cwC;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cwy = 0;
    private int bQq = 200;

    public static c aol() {
        if (cwE == null) {
            synchronized (c.class) {
                if (cwE == null) {
                    cwE = new c();
                }
            }
        }
        return cwE;
    }

    private void at(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cwD != null) {
                        c.cwD.hF(c.this.cwC);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cwB == c.this.cwy) {
                        c.this.cwB = height;
                    } else if (c.this.cwB != height) {
                        if (c.this.cwB - height > c.this.bQq) {
                            if (c.cwD != null) {
                                c.cwD.E(c.this.cwC, c.this.cwB - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cwB + " visibleHeight " + height);
                                }
                            }
                            c.this.cwB = height;
                        } else if (height - c.this.cwB > c.this.bQq) {
                            if (c.cwD != null) {
                                c.cwD.F(c.this.cwC, height - c.this.cwB);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cwB + " visibleHeight " + height);
                            }
                            c.this.cwB = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        at(view);
        this.cwC = str;
        cwD = aVar;
        this.cwB = 0;
    }

    public void au(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cwC = "";
        cwD = null;
        this.cwB = 0;
    }

    public static void release() {
        cwD = null;
        cwE = null;
    }
}
