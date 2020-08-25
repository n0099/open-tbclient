package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes8.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dej = 5;
            private long[] cgG = new long[this.dej];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cgG, 1, this.cgG, 0, this.cgG.length - 1);
                this.cgG[this.cgG.length - 1] = SystemClock.uptimeMillis();
                if (this.cgG[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cgG = new long[this.dej];
                    runnable.run();
                }
            }
        });
    }
}
