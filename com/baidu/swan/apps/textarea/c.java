package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dHP;
    private static volatile c dHQ;
    private int dHN;
    private String dHO;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dHK = 0;
    private int cUR = 200;

    public static c aOg() {
        if (dHQ == null) {
            synchronized (c.class) {
                if (dHQ == null) {
                    dHQ = new c();
                }
            }
        }
        return dHQ;
    }

    private void aH(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dHP != null) {
                        c.dHP.mM(c.this.dHO);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dHN == c.this.dHK) {
                        c.this.dHN = height;
                    } else if (c.this.dHN != height) {
                        if (c.this.dHN - height > c.this.cUR) {
                            if (c.dHP != null) {
                                c.dHP.N(c.this.dHO, c.this.dHN - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dHN + " visibleHeight " + height);
                                }
                            }
                            c.this.dHN = height;
                        } else if (height - c.this.dHN > c.this.cUR) {
                            if (c.dHP != null) {
                                c.dHP.O(c.this.dHO, height - c.this.dHN);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dHN + " visibleHeight " + height);
                            }
                            c.this.dHN = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aH(view);
        this.dHO = str;
        dHP = aVar;
        this.dHN = 0;
    }

    public void aI(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dHO = "";
        dHP = null;
        this.dHN = 0;
    }

    public static void release() {
        dHP = null;
        dHQ = null;
    }
}
