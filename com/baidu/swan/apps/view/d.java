package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes8.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int den = 5;
            private long[] cgK = new long[this.den];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cgK, 1, this.cgK, 0, this.cgK.length - 1);
                this.cgK[this.cgK.length - 1] = SystemClock.uptimeMillis();
                if (this.cgK[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cgK = new long[this.den];
                    runnable.run();
                }
            }
        });
    }
}
