package com.baidu.platform.comapi.wnplatform.p;

import android.view.View;
/* loaded from: classes26.dex */
public abstract class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static long f3155a = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f3155a > 300) {
            f3155a = currentTimeMillis;
            a(view);
        }
    }
}
