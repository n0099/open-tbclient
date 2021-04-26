package com.alipay.sdk.widget;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f2032a;

    public o(n nVar) {
        this.f2032a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f2032a.f2031b.w = true;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.s, "2");
        this.f2032a.f2030a.proceed();
        dialogInterface.dismiss();
    }
}
