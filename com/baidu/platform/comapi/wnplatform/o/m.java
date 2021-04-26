package com.baidu.platform.comapi.wnplatform.o;

import android.view.View;
/* loaded from: classes2.dex */
public abstract class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static long f10302a;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f10302a > 300) {
            f10302a = currentTimeMillis;
            a(view);
        }
    }
}
