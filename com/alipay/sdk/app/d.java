package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1792a;

    public d(c cVar) {
        this.f1792a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1792a.f1791c.f1784b = true;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.s, "1");
        this.f1792a.f1790b.proceed();
        dialogInterface.dismiss();
    }
}
