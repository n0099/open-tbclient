package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes10.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dAU = 5;
            private long[] cDB = new long[this.dAU];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cDB, 1, this.cDB, 0, this.cDB.length - 1);
                this.cDB[this.cDB.length - 1] = SystemClock.uptimeMillis();
                if (this.cDB[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cDB = new long[this.dAU];
                    runnable.run();
                }
            }
        });
    }
}
