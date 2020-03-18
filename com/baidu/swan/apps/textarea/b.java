package com.baidu.swan.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class b {
    private a bXI;
    private View rootView;
    private int rootViewVisibleHeight;
    private int bXH = 0;
    private int bsk = 200;

    private b(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.textarea.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (b.this.bXI != null) {
                    b.this.bXI.gr(str);
                }
                Rect rect = new Rect();
                b.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (b.this.rootViewVisibleHeight == b.this.bXH) {
                    b.this.rootViewVisibleHeight = height;
                } else if (b.this.rootViewVisibleHeight != height) {
                    if (b.this.rootViewVisibleHeight - height > b.this.bsk) {
                        if (b.this.bXI != null) {
                            b.this.bXI.w(str, b.this.rootViewVisibleHeight - height);
                        }
                        b.this.rootViewVisibleHeight = height;
                    } else if (height - b.this.rootViewVisibleHeight > b.this.bsk) {
                        if (b.this.bXI != null) {
                            b.this.bXI.x(str, height - b.this.rootViewVisibleHeight);
                        }
                        b.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void a(a aVar) {
        this.bXI = aVar;
    }

    public static void a(String str, Activity activity, a aVar) {
        new b(str, activity).a(aVar);
    }
}
