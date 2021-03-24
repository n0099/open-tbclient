package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1809a;

    public d(c cVar) {
        this.f1809a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1809a.f1808c.f1801b = true;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.s, "1");
        this.f1809a.f1807b.proceed();
        dialogInterface.dismiss();
    }
}
