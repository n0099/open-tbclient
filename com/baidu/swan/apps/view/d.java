package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes3.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dgo = 5;
            private long[] ciM = new long[this.dgo];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.ciM, 1, this.ciM, 0, this.ciM.length - 1);
                this.ciM[this.ciM.length - 1] = SystemClock.uptimeMillis();
                if (this.ciM[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.ciM = new long[this.dgo];
                    runnable.run();
                }
            }
        });
    }
}
