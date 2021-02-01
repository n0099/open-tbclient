package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dNM;
    private static volatile c dNN;
    private int dNK;
    private String dNL;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dNH = 0;
    private int cXo = 200;

    public static c aMX() {
        if (dNN == null) {
            synchronized (c.class) {
                if (dNN == null) {
                    dNN = new c();
                }
            }
        }
        return dNN;
    }

    private void aM(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dNM != null) {
                        c.dNM.lM(c.this.dNL);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dNK == c.this.dNH) {
                        c.this.dNK = height;
                    } else if (c.this.dNK != height) {
                        if (c.this.dNK - height > c.this.cXo) {
                            if (c.dNM != null) {
                                c.dNM.Q(c.this.dNL, c.this.dNK - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dNK + " visibleHeight " + height);
                                }
                            }
                            c.this.dNK = height;
                        } else if (height - c.this.dNK > c.this.cXo) {
                            if (c.dNM != null) {
                                c.dNM.R(c.this.dNL, height - c.this.dNK);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dNK + " visibleHeight " + height);
                            }
                            c.this.dNK = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aM(view);
        this.dNL = str;
        dNM = aVar;
        this.dNK = 0;
    }

    public void aN(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dNL = "";
        dNM = null;
        this.dNK = 0;
    }

    public static void release() {
        dNM = null;
        dNN = null;
    }
}
