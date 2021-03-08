package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes8.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int bsP = 5;
            private long[] cSA = new long[this.bsP];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cSA, 1, this.cSA, 0, this.cSA.length - 1);
                this.cSA[this.cSA.length - 1] = SystemClock.uptimeMillis();
                if (this.cSA[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cSA = new long[this.bsP];
                    runnable.run();
                }
            }
        });
    }
}
