package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes9.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int brp = 5;
            private long[] cRa = new long[this.brp];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cRa, 1, this.cRa, 0, this.cRa.length - 1);
                this.cRa[this.cRa.length - 1] = SystemClock.uptimeMillis();
                if (this.cRa[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cRa = new long[this.brp];
                    runnable.run();
                }
            }
        });
    }
}
