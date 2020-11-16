package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes7.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dFf = 5;
            private long[] cHK = new long[this.dFf];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cHK, 1, this.cHK, 0, this.cHK.length - 1);
                this.cHK[this.cHK.length - 1] = SystemClock.uptimeMillis();
                if (this.cHK[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cHK = new long[this.dFf];
                    runnable.run();
                }
            }
        });
    }
}
