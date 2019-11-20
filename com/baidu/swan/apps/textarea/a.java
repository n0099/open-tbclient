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
    private static InterfaceC0228a brl;
    private static volatile a brm;
    private int brh = 0;
    private int bri = 200;
    private int brj;
    private String brk;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0228a {
        void fm(String str);

        void y(String str, int i);

        void z(String str, int i);
    }

    public static a TE() {
        if (brm == null) {
            synchronized (a.class) {
                if (brm == null) {
                    brm = new a();
                }
            }
        }
        return brm;
    }

    private void aq(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.brl != null) {
                        a.brl.fm(a.this.brk);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (a.this.brj == a.this.brh) {
                        a.this.brj = height;
                    } else if (a.this.brj != height) {
                        if (a.this.brj - height > a.this.bri) {
                            if (a.brl != null) {
                                a.brl.y(a.this.brk, a.this.brj - height);
                                if (a.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.brj + " visibleHeight " + height);
                                }
                            }
                            a.this.brj = height;
                        } else if (height - a.this.brj > a.this.bri) {
                            if (a.brl != null) {
                                a.brl.z(a.this.brk, height - a.this.brj);
                            }
                            if (a.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.brj + " visibleHeight " + height);
                            }
                            a.this.brj = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, InterfaceC0228a interfaceC0228a) {
        aq(view);
        this.brk = str;
        brl = interfaceC0228a;
        this.brj = 0;
    }

    public void ar(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.brk = "";
        brl = null;
        this.brj = 0;
    }

    public static void release() {
        brl = null;
        brm = null;
    }
}
