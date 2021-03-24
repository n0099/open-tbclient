package com.alipay.sdk.widget;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f2048a;

    public p(n nVar) {
        this.f2048a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2048a.f2045a.cancel();
        this.f2048a.f2046b.w = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "2");
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f2048a.f2046b.f2027a.finish();
    }
}
