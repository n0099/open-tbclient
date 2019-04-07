package com.baidu.swan.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes2.dex */
public class a {
    private int aUS = 0;
    private int aUT = 200;
    private InterfaceC0178a aUU;
    private View rootView;
    private int rootViewVisibleHeight;

    /* renamed from: com.baidu.swan.apps.textarea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0178a {
        void B(String str, int i);

        void C(String str, int i);

        void eK(String str);
    }

    private a(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.aUU != null) {
                    a.this.aUU.eK(str);
                }
                Rect rect = new Rect();
                a.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (a.this.rootViewVisibleHeight == a.this.aUS) {
                    a.this.rootViewVisibleHeight = height;
                } else if (a.this.rootViewVisibleHeight != height) {
                    if (a.this.rootViewVisibleHeight - height > a.this.aUT) {
                        if (a.this.aUU != null) {
                            a.this.aUU.B(str, a.this.rootViewVisibleHeight - height);
                        }
                        a.this.rootViewVisibleHeight = height;
                    } else if (height - a.this.rootViewVisibleHeight > a.this.aUT) {
                        if (a.this.aUU != null) {
                            a.this.aUU.C(str, height - a.this.rootViewVisibleHeight);
                        }
                        a.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void a(InterfaceC0178a interfaceC0178a) {
        this.aUU = interfaceC0178a;
    }

    public static void a(String str, Activity activity, InterfaceC0178a interfaceC0178a) {
        new a(str, activity).a(interfaceC0178a);
    }
}
