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
    private static InterfaceC0196a aZb;
    private static volatile a aZc;
    private int aYX = 0;
    private int aYY = 200;
    private int aYZ;
    private String aZa;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void eF(String str);

        void y(String str, int i);

        void z(String str, int i);
    }

    public static a OQ() {
        if (aZc == null) {
            synchronized (a.class) {
                if (aZc == null) {
                    aZc = new a();
                }
            }
        }
        return aZc;
    }

    private void ak(final View view) {
        if (this.mOnGlobalLayoutListener == null) {
            this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.aZb != null) {
                        a.aZb.eF(a.this.aZa);
                    }
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    if (a.this.aYZ == a.this.aYX) {
                        a.this.aYZ = height;
                    } else if (a.this.aYZ != height) {
                        if (a.this.aYZ - height > a.this.aYY) {
                            if (a.aZb != null) {
                                a.aZb.y(a.this.aZa, a.this.aYZ - height);
                                if (a.DEBUG) {
                                    Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.aYZ + " visibleHeight " + height);
                                }
                            }
                            a.this.aYZ = height;
                        } else if (height - a.this.aYZ > a.this.aYY) {
                            if (a.aZb != null) {
                                a.aZb.z(a.this.aZa, height - a.this.aYZ);
                            }
                            if (a.DEBUG) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.aYZ + " visibleHeight " + height);
                            }
                            a.this.aYZ = height;
                        }
                    }
                }
            };
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void a(View view, String str, InterfaceC0196a interfaceC0196a) {
        ak(view);
        this.aZa = str;
        aZb = interfaceC0196a;
        this.aYZ = 0;
    }

    public void al(@NonNull View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        this.aZa = "";
        aZb = null;
        this.aYZ = 0;
    }

    public static void release() {
        aZb = null;
        aZc = null;
    }
}
