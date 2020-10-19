package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes10.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dsw = 5;
            private long[] cvf = new long[this.dsw];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cvf, 1, this.cvf, 0, this.cvf.length - 1);
                this.cvf[this.cvf.length - 1] = SystemClock.uptimeMillis();
                if (this.cvf[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cvf = new long[this.dsw];
                    runnable.run();
                }
            }
        });
    }
}
