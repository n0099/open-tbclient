package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cZQ;
    private static volatile c cZR;
    private int cZO;
    private String cZP;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cZL = 0;
    private int cmX = 200;

    public static c aDU() {
        if (cZR == null) {
            synchronized (c.class) {
                if (cZR == null) {
                    cZR = new c();
                }
            }
        }
        return cZR;
    }

    private void ax(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cZQ != null) {
                        c.cZQ.kx(c.this.cZP);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cZO == c.this.cZL) {
                        c.this.cZO = height;
                    } else if (c.this.cZO != height) {
                        if (c.this.cZO - height > c.this.cmX) {
                            if (c.cZQ != null) {
                                c.cZQ.J(c.this.cZP, c.this.cZO - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cZO + " visibleHeight " + height);
                                }
                            }
                            c.this.cZO = height;
                        } else if (height - c.this.cZO > c.this.cmX) {
                            if (c.cZQ != null) {
                                c.cZQ.K(c.this.cZP, height - c.this.cZO);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cZO + " visibleHeight " + height);
                            }
                            c.this.cZO = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        ax(view);
        this.cZP = str;
        cZQ = aVar;
        this.cZO = 0;
    }

    public void ay(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cZP = "";
        cZQ = null;
        this.cZO = 0;
    }

    public static void release() {
        cZQ = null;
        cZR = null;
    }
}
