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
    private static InterfaceC0228a bsc;
    private static volatile a bsd;
    private int brY = 0;
    private int brZ = 200;
    private int bsa;
    private String bsb;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0228a {
        void fm(String str);

        void y(String str, int i);

        void z(String str, int i);
    }

    public static a TG() {
        if (bsd == null) {
            synchronized (a.class) {
                if (bsd == null) {
                    bsd = new a();
                }
            }
        }
        return bsd;
    }

    private void aq(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.bsc != null) {
                        a.bsc.fm(a.this.bsb);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (a.this.bsa == a.this.brY) {
                        a.this.bsa = height;
                    } else if (a.this.bsa != height) {
                        if (a.this.bsa - height > a.this.brZ) {
                            if (a.bsc != null) {
                                a.bsc.y(a.this.bsb, a.this.bsa - height);
                                if (a.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.bsa + " visibleHeight " + height);
                                }
                            }
                            a.this.bsa = height;
                        } else if (height - a.this.bsa > a.this.brZ) {
                            if (a.bsc != null) {
                                a.bsc.z(a.this.bsb, height - a.this.bsa);
                            }
                            if (a.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.bsa + " visibleHeight " + height);
                            }
                            a.this.bsa = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, InterfaceC0228a interfaceC0228a) {
        aq(view);
        this.bsb = str;
        bsc = interfaceC0228a;
        this.bsa = 0;
    }

    public void ar(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.bsb = "";
        bsc = null;
        this.bsa = 0;
    }

    public static void release() {
        bsc = null;
        bsd = null;
    }
}
