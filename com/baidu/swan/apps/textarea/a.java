package com.baidu.swan.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes2.dex */
public class a {
    private int aUO = 0;
    private int aUP = 200;
    private InterfaceC0149a aUQ;
    private View rootView;
    private int rootViewVisibleHeight;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0149a {
        void B(String str, int i);

        void C(String str, int i);

        void eJ(String str);
    }

    private a(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.aUQ != null) {
                    a.this.aUQ.eJ(str);
                }
                Rect rect = new Rect();
                a.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (a.this.rootViewVisibleHeight == a.this.aUO) {
                    a.this.rootViewVisibleHeight = height;
                } else if (a.this.rootViewVisibleHeight != height) {
                    if (a.this.rootViewVisibleHeight - height > a.this.aUP) {
                        if (a.this.aUQ != null) {
                            a.this.aUQ.B(str, a.this.rootViewVisibleHeight - height);
                        }
                        a.this.rootViewVisibleHeight = height;
                    } else if (height - a.this.rootViewVisibleHeight > a.this.aUP) {
                        if (a.this.aUQ != null) {
                            a.this.aUQ.C(str, height - a.this.rootViewVisibleHeight);
                        }
                        a.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void a(InterfaceC0149a interfaceC0149a) {
        this.aUQ = interfaceC0149a;
    }

    public static void a(String str, Activity activity, InterfaceC0149a interfaceC0149a) {
        new a(str, activity).a(interfaceC0149a);
    }
}
