package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dPn;
    private static volatile c dPo;
    private int dPl;
    private String dPm;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dPi = 0;
    private int cYO = 200;

    public static c aNa() {
        if (dPo == null) {
            synchronized (c.class) {
                if (dPo == null) {
                    dPo = new c();
                }
            }
        }
        return dPo;
    }

    private void aM(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dPn != null) {
                        c.dPn.lT(c.this.dPm);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dPl == c.this.dPi) {
                        c.this.dPl = height;
                    } else if (c.this.dPl != height) {
                        if (c.this.dPl - height > c.this.cYO) {
                            if (c.dPn != null) {
                                c.dPn.R(c.this.dPm, c.this.dPl - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dPl + " visibleHeight " + height);
                                }
                            }
                            c.this.dPl = height;
                        } else if (height - c.this.dPl > c.this.cYO) {
                            if (c.dPn != null) {
                                c.dPn.S(c.this.dPm, height - c.this.dPl);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dPl + " visibleHeight " + height);
                            }
                            c.this.dPl = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aM(view);
        this.dPm = str;
        dPn = aVar;
        this.dPl = 0;
    }

    public void aN(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dPm = "";
        dPn = null;
        this.dPl = 0;
    }

    public static void release() {
        dPn = null;
        dPo = null;
    }
}
