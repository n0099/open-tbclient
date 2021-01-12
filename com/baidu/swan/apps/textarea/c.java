package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dLI;
    private static volatile c dLJ;
    private int dLG;
    private String dLH;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dLD = 0;
    private int cVb = 200;

    public static c aME() {
        if (dLJ == null) {
            synchronized (c.class) {
                if (dLJ == null) {
                    dLJ = new c();
                }
            }
        }
        return dLJ;
    }

    private void aQ(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dLI != null) {
                        c.dLI.lu(c.this.dLH);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dLG == c.this.dLD) {
                        c.this.dLG = height;
                    } else if (c.this.dLG != height) {
                        if (c.this.dLG - height > c.this.cVb) {
                            if (c.dLI != null) {
                                c.dLI.O(c.this.dLH, c.this.dLG - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dLG + " visibleHeight " + height);
                                }
                            }
                            c.this.dLG = height;
                        } else if (height - c.this.dLG > c.this.cVb) {
                            if (c.dLI != null) {
                                c.dLI.P(c.this.dLH, height - c.this.dLG);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dLG + " visibleHeight " + height);
                            }
                            c.this.dLG = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aQ(view);
        this.dLH = str;
        dLI = aVar;
        this.dLG = 0;
    }

    public void aR(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dLH = "";
        dLI = null;
        this.dLG = 0;
    }

    public static void release() {
        dLI = null;
        dLJ = null;
    }
}
