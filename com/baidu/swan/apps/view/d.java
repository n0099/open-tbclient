package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes10.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int dGM = 5;
            private long[] cJu = new long[this.dGM];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cJu, 1, this.cJu, 0, this.cJu.length - 1);
                this.cJu[this.cJu.length - 1] = SystemClock.uptimeMillis();
                if (this.cJu[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cJu = new long[this.dGM];
                    runnable.run();
                }
            }
        });
    }
}
