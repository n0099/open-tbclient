package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes25.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dMd = 5;
            private long[] cOD = new long[this.dMd];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cOD, 1, this.cOD, 0, this.cOD.length - 1);
                this.cOD[this.cOD.length - 1] = SystemClock.uptimeMillis();
                if (this.cOD[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cOD = new long[this.dMd];
                    runnable.run();
                }
            }
        });
    }
}
