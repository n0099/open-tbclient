package com.baidu.swan.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes9.dex */
public class b {
    private a dQq;
    private View rootView;
    private int rootViewVisibleHeight;
    private int dQp = 0;
    private int cZN = 200;

    private b(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (b.this.dQq != null) {
                    b.this.dQq.mF(str);
                }
                Rect rect = new Rect();
                b.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (b.this.rootViewVisibleHeight == b.this.dQp) {
                    b.this.rootViewVisibleHeight = height;
                } else if (b.this.rootViewVisibleHeight != height) {
                    if (b.this.rootViewVisibleHeight - height > b.this.cZN) {
                        if (b.this.dQq != null) {
                            b.this.dQq.O(str, b.this.rootViewVisibleHeight - height);
                        }
                        b.this.rootViewVisibleHeight = height;
                    } else if (height - b.this.rootViewVisibleHeight > b.this.cZN) {
                        if (b.this.dQq != null) {
                            b.this.dQq.P(str, height - b.this.rootViewVisibleHeight);
                        }
                        b.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void a(a aVar) {
        this.dQq = aVar;
    }

    public static void a(String str, Activity activity, a aVar) {
        new b(str, activity).a(aVar);
    }
}
