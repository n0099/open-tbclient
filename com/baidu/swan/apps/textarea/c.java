package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cQQ;
    private static volatile c cQR;
    private int cQO;
    private String cQP;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cQL = 0;
    private int cgI = 200;

    public static c avL() {
        if (cQR == null) {
            synchronized (c.class) {
                if (cQR == null) {
                    cQR = new c();
                }
            }
        }
        return cQR;
    }

    private void aw(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cQQ != null) {
                        c.cQQ.iX(c.this.cQP);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cQO == c.this.cQL) {
                        c.this.cQO = height;
                    } else if (c.this.cQO != height) {
                        if (c.this.cQO - height > c.this.cgI) {
                            if (c.cQQ != null) {
                                c.cQQ.I(c.this.cQP, c.this.cQO - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cQO + " visibleHeight " + height);
                                }
                            }
                            c.this.cQO = height;
                        } else if (height - c.this.cQO > c.this.cgI) {
                            if (c.cQQ != null) {
                                c.cQQ.J(c.this.cQP, height - c.this.cQO);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cQO + " visibleHeight " + height);
                            }
                            c.this.cQO = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aw(view);
        this.cQP = str;
        cQQ = aVar;
        this.cQO = 0;
    }

    public void ax(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cQP = "";
        cQQ = null;
        this.cQO = 0;
    }

    public static void release() {
        cQQ = null;
        cQR = null;
    }
}
