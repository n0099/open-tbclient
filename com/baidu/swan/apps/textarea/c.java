package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dQu;
    private static volatile c dQv;
    private int dQs;
    private String dQt;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dQp = 0;
    private int cZN = 200;

    public static c aQx() {
        if (dQv == null) {
            synchronized (c.class) {
                if (dQv == null) {
                    dQv = new c();
                }
            }
        }
        return dQv;
    }

    private void aQ(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dQu != null) {
                        c.dQu.mF(c.this.dQt);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dQs == c.this.dQp) {
                        c.this.dQs = height;
                    } else if (c.this.dQs != height) {
                        if (c.this.dQs - height > c.this.cZN) {
                            if (c.dQu != null) {
                                c.dQu.O(c.this.dQt, c.this.dQs - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dQs + " visibleHeight " + height);
                                }
                            }
                            c.this.dQs = height;
                        } else if (height - c.this.dQs > c.this.cZN) {
                            if (c.dQu != null) {
                                c.dQu.P(c.this.dQt, height - c.this.dQs);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dQs + " visibleHeight " + height);
                            }
                            c.this.dQs = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aQ(view);
        this.dQt = str;
        dQu = aVar;
        this.dQs = 0;
    }

    public void aR(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dQt = "";
        dQu = null;
        this.dQs = 0;
    }

    public static void release() {
        dQu = null;
        dQv = null;
    }
}
