package com.baidu.platform.comapi.wnplatform.o;

import android.view.View;
/* loaded from: classes6.dex */
public abstract class m implements View.OnClickListener {
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
