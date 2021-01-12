package com.baidu.platform.comapi.wnplatform.o;

import android.view.View;
/* loaded from: classes6.dex */
public abstract class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static long f4463a = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f4463a > 300) {
            f4463a = currentTimeMillis;
            a(view);
        }
    }
}
