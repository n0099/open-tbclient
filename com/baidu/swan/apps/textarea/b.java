package com.baidu.swan.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes8.dex */
public class b {
    private a cZM;
    private View rootView;
    private int rootViewVisibleHeight;
    private int cZL = 0;
    private int cmX = 200;

    private b(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (b.this.cZM != null) {
                    b.this.cZM.kx(str);
                }
                Rect rect = new Rect();
                b.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (b.this.rootViewVisibleHeight == b.this.cZL) {
                    b.this.rootViewVisibleHeight = height;
                } else if (b.this.rootViewVisibleHeight != height) {
                    if (b.this.rootViewVisibleHeight - height > b.this.cmX) {
                        if (b.this.cZM != null) {
                            b.this.cZM.J(str, b.this.rootViewVisibleHeight - height);
                        }
                        b.this.rootViewVisibleHeight = height;
                    } else if (height - b.this.rootViewVisibleHeight > b.this.cmX) {
                        if (b.this.cZM != null) {
                            b.this.cZM.K(str, height - b.this.rootViewVisibleHeight);
                        }
                        b.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void a(a aVar) {
        this.cZM = aVar;
    }

    public static void a(String str, Activity activity, a aVar) {
        new b(str, activity).a(aVar);
    }
}
