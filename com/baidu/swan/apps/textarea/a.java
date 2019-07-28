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
    private static InterfaceC0187a aYD;
    private static volatile a aYE;
    private int aYB;
    private String aYC;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int aYz = 0;
    private int aYA = 200;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0187a {
        void eD(String str);

        void y(String str, int i);

        void z(String str, int i);
    }

    public static a OM() {
        if (aYE == null) {
            synchronized (a.class) {
                if (aYE == null) {
                    aYE = new a();
                }
            }
        }
        return aYE;
    }

    private void ak(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.aYD != null) {
                        a.aYD.eD(a.this.aYC);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (a.this.aYB == a.this.aYz) {
                        a.this.aYB = height;
                    } else if (a.this.aYB != height) {
                        if (a.this.aYB - height > a.this.aYA) {
                            if (a.aYD != null) {
                                a.aYD.y(a.this.aYC, a.this.aYB - height);
                                if (a.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.aYB + " visibleHeight " + height);
                                }
                            }
                            a.this.aYB = height;
                        } else if (height - a.this.aYB > a.this.aYA) {
                            if (a.aYD != null) {
                                a.aYD.z(a.this.aYC, height - a.this.aYB);
                            }
                            if (a.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.aYB + " visibleHeight " + height);
                            }
                            a.this.aYB = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, InterfaceC0187a interfaceC0187a) {
        ak(view);
        this.aYC = str;
        aYD = interfaceC0187a;
        this.aYB = 0;
    }

    public void al(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aYC = "";
        aYD = null;
        this.aYB = 0;
    }

    public static void release() {
        aYD = null;
        aYE = null;
    }
}
