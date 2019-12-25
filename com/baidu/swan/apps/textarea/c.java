package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bTj;
    private static volatile c bTk;
    private int bTh;
    private String bTi;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bTe = 0;
    private int bmZ = 200;

    public static c adu() {
        if (bTk == null) {
            synchronized (c.class) {
                if (bTk == null) {
                    bTk = new c();
                }
            }
        }
        return bTk;
    }

    private void ao(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bTj != null) {
                        c.bTj.ga(c.this.bTi);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bTh == c.this.bTe) {
                        c.this.bTh = height;
                    } else if (c.this.bTh != height) {
                        if (c.this.bTh - height > c.this.bmZ) {
                            if (c.bTj != null) {
                                c.bTj.y(c.this.bTi, c.this.bTh - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bTh + " visibleHeight " + height);
                                }
                            }
                            c.this.bTh = height;
                        } else if (height - c.this.bTh > c.this.bmZ) {
                            if (c.bTj != null) {
                                c.bTj.z(c.this.bTi, height - c.this.bTh);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bTh + " visibleHeight " + height);
                            }
                            c.this.bTh = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        ao(view);
        this.bTi = str;
        bTj = aVar;
        this.bTh = 0;
    }

    public void ap(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bTi = "";
        bTj = null;
        this.bTh = 0;
    }

    public static void release() {
        bTj = null;
        bTk = null;
    }
}
