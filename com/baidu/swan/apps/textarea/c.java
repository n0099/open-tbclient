package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bTv;
    private static volatile c bTw;
    private int bTt;
    private String bTu;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int bTq = 0;
    private int bnN = 200;

    public static c adN() {
        if (bTw == null) {
            synchronized (c.class) {
                if (bTw == null) {
                    bTw = new c();
                }
            }
        }
        return bTw;
    }

    private void as(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (c.bTv != null) {
                        c.bTv.gd(c.this.bTu);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (c.this.bTt == c.this.bTq) {
                        c.this.bTt = height;
                    } else if (c.this.bTt != height) {
                        if (c.this.bTt - height > c.this.bnN) {
                            if (c.bTv != null) {
                                c.bTv.y(c.this.bTu, c.this.bTt - height);
                                if (c.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + c.this.bTt + " visibleHeight " + height);
                                }
                            }
                            c.this.bTt = height;
                        } else if (height - c.this.bTt > c.this.bnN) {
                            if (c.bTv != null) {
                                c.bTv.z(c.this.bTu, height - c.this.bTt);
                            }
                            if (c.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + c.this.bTt + " visibleHeight " + height);
                            }
                            c.this.bTt = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, a aVar) {
        as(view);
        this.bTu = str;
        bTv = aVar;
        this.bTt = 0;
    }

    public void at(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bTu = "";
        bTv = null;
        this.bTt = 0;
    }

    public static void release() {
        bTv = null;
        bTw = null;
    }
}
