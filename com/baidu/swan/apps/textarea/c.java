package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cwJ;
    private static volatile c cwK;
    private int cwH;
    private String cwI;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int cwE = 0;
    private int bQv = 200;

    public static c aok() {
        if (cwK == null) {
            synchronized (c.class) {
                if (cwK == null) {
                    cwK = new c();
                }
            }
        }
        return cwK;
    }

    private void at(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.cwJ != null) {
                        c.cwJ.hF(c.this.cwI);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.cwH == c.this.cwE) {
                        c.this.cwH = height;
                    } else if (c.this.cwH != height) {
                        if (c.this.cwH - height > c.this.bQv) {
                            if (c.cwJ != null) {
                                c.cwJ.E(c.this.cwI, c.this.cwH - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.cwH + " visibleHeight " + height);
                                }
                            }
                            c.this.cwH = height;
                        } else if (height - c.this.cwH > c.this.bQv) {
                            if (c.cwJ != null) {
                                c.cwJ.F(c.this.cwI, height - c.this.cwH);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.cwH + " visibleHeight " + height);
                            }
                            c.this.cwH = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        at(view);
        this.cwI = str;
        cwJ = aVar;
        this.cwH = 0;
    }

    public void au(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.cwI = "";
        cwJ = null;
        this.cwH = 0;
    }

    public static void release() {
        cwJ = null;
        cwK = null;
    }
}
