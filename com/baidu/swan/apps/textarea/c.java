package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dbW;
    private static volatile c dbX;
    private int dbU;
    private String dbV;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dbR = 0;
    private int cpe = 200;

    public static c aEE() {
        if (dbX == null) {
            synchronized (c.class) {
                if (dbX == null) {
                    dbX = new c();
                }
            }
        }
        return dbX;
    }

    private void az(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dbW != null) {
                        c.dbW.kR(c.this.dbV);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dbU == c.this.dbR) {
                        c.this.dbU = height;
                    } else if (c.this.dbU != height) {
                        if (c.this.dbU - height > c.this.cpe) {
                            if (c.dbW != null) {
                                c.dbW.J(c.this.dbV, c.this.dbU - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dbU + " visibleHeight " + height);
                                }
                            }
                            c.this.dbU = height;
                        } else if (height - c.this.dbU > c.this.cpe) {
                            if (c.dbW != null) {
                                c.dbW.K(c.this.dbV, height - c.this.dbU);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dbU + " visibleHeight " + height);
                            }
                            c.this.dbU = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        az(view);
        this.dbV = str;
        dbW = aVar;
        this.dbU = 0;
    }

    public void aA(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dbV = "";
        dbW = null;
        this.dbU = 0;
    }

    public static void release() {
        dbW = null;
        dbX = null;
    }
}
