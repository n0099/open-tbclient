package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1793a;

    public e(c cVar) {
        this.f1793a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1793a.f1790b.cancel();
        this.f1793a.f1791c.f1784b = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.f1793a.f1789a.finish();
    }
}
