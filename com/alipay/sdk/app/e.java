package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1780a;

    public e(c cVar) {
        this.f1780a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1780a.f1777b.cancel();
        this.f1780a.f1778c.f1771b = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.f1780a.f1776a.finish();
    }
}
