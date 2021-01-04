package com.baidu.swan.apps.view;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes9.dex */
public class d {
    public static void a(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.d.1
            private int bsA = 5;
            private long[] cTy = new long[this.bsA];

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                System.arraycopy(this.cTy, 1, this.cTy, 0, this.cTy.length - 1);
                this.cTy[this.cTy.length - 1] = SystemClock.uptimeMillis();
                if (this.cTy[0] >= SystemClock.uptimeMillis() - 1000) {
                    this.cTy = new long[this.bsA];
                    runnable.run();
                }
            }
        });
    }
}
