package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes8.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int bnO = 5;
            private long[] cOM = new long[this.bnO];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cOM, 1, this.cOM, 0, this.cOM.length - 1);
                this.cOM[this.cOM.length - 1] = SystemClock.uptimeMillis();
                if (this.cOM[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cOM = new long[this.bnO];
                    runnable.run();
                }
            }
        });
    }
}
