package com.baidu.swan.apps.textarea;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static InterfaceC0185a aXT;
    private static volatile a aXU;
    private int aXP = 0;
    private int aXQ = 200;
    private int aXR;
    private String aXS;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0185a {
        void ez(String str);

        void y(String str, int i);

        void z(String str, int i);
    }

    public static a NX() {
        if (aXU == null) {
            synchronized (a.class) {
                if (aXU == null) {
                    aXU = new a();
                }
            }
        }
        return aXU;
    }

    private void ai(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.aXT != null) {
                        a.aXT.ez(a.this.aXS);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (a.this.aXR == a.this.aXP) {
                        a.this.aXR = height;
                    } else if (a.this.aXR != height) {
                        if (a.this.aXR - height > a.this.aXQ) {
                            if (a.aXT != null) {
                                a.aXT.y(a.this.aXS, a.this.aXR - height);
                                if (a.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.aXR + " visibleHeight " + height);
                                }
                            }
                            a.this.aXR = height;
                        } else if (height - a.this.aXR > a.this.aXQ) {
                            if (a.aXT != null) {
                                a.aXT.z(a.this.aXS, height - a.this.aXR);
                            }
                            if (a.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.aXR + " visibleHeight " + height);
                            }
                            a.this.aXR = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, InterfaceC0185a interfaceC0185a) {
        ai(view);
        this.aXS = str;
        aXT = interfaceC0185a;
        this.aXR = 0;
    }

    public void aj(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aXS = "";
        aXT = null;
        this.aXR = 0;
    }

    public static void release() {
        aXT = null;
        aXU = null;
    }
}
