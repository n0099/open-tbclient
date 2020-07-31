package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes7.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int cVg = 5;
            private long[] caN = new long[this.cVg];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.caN, 1, this.caN, 0, this.caN.length - 1);
                this.caN[this.caN.length - 1] = SystemClock.uptimeMillis();
                if (this.caN[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.caN = new long[this.cVg];
                    runnable.run();
                }
            }
        });
    }
}
