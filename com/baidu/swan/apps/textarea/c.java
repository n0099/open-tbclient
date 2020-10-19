package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dog;
    private static volatile c doh;
    private int doe;
    private String dof;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int doa = 0;
    private int cBt = 200;

    public static c aHn() {
        if (doh == null) {
            synchronized (c.class) {
                if (doh == null) {
                    doh = new c();
                }
            }
        }
        return doh;
    }

    private void aA(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dog != null) {
                        c.dog.lD(c.this.dof);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.doe == c.this.doa) {
                        c.this.doe = height;
                    } else if (c.this.doe != height) {
                        if (c.this.doe - height > c.this.cBt) {
                            if (c.dog != null) {
                                c.dog.K(c.this.dof, c.this.doe - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.doe + " visibleHeight " + height);
                                }
                            }
                            c.this.doe = height;
                        } else if (height - c.this.doe > c.this.cBt) {
                            if (c.dog != null) {
                                c.dog.L(c.this.dof, height - c.this.doe);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.doe + " visibleHeight " + height);
                            }
                            c.this.doe = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aA(view);
        this.dof = str;
        dog = aVar;
        this.doe = 0;
    }

    public void aB(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dof = "";
        dog = null;
        this.doe = 0;
    }

    public static void release() {
        dog = null;
        doh = null;
    }
}
