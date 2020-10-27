package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dwG;
    private static volatile c dwH;
    private int dwE;
    private String dwF;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int dwB = 0;
    private int cJP = 200;

    public static c aJh() {
        if (dwH == null) {
            synchronized (c.class) {
                if (dwH == null) {
                    dwH = new c();
                }
            }
        }
        return dwH;
    }

    private void aB(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.dwG != null) {
                        c.dwG.lW(c.this.dwF);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.dwE == c.this.dwB) {
                        c.this.dwE = height;
                    } else if (c.this.dwE != height) {
                        if (c.this.dwE - height > c.this.cJP) {
                            if (c.dwG != null) {
                                c.dwG.K(c.this.dwF, c.this.dwE - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.dwE + " visibleHeight " + height);
                                }
                            }
                            c.this.dwE = height;
                        } else if (height - c.this.dwE > c.this.cJP) {
                            if (c.dwG != null) {
                                c.dwG.L(c.this.dwF, height - c.this.dwE);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.dwE + " visibleHeight " + height);
                            }
                            c.this.dwE = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        aB(view);
        this.dwF = str;
        dwG = aVar;
        this.dwE = 0;
    }

    public void aC(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.dwF = "";
        dwG = null;
        this.dwE = 0;
    }

    public static void release() {
        dwG = null;
        dwH = null;
    }
}
