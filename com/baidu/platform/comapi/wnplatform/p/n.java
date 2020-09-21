package com.baidu.platform.comapi.wnplatform.p;

import android.view.View;
/* loaded from: classes3.dex */
public abstract class n implements View.OnClickListener {
    private static long a = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a > 300) {
            a = currentTimeMillis;
            a(view);
        }
    }
}
