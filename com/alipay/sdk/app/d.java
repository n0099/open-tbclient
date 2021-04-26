package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1779a;

    public d(c cVar) {
        this.f1779a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1779a.f1778c.f1771b = true;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.s, "1");
        this.f1779a.f1777b.proceed();
        dialogInterface.dismiss();
    }
}
