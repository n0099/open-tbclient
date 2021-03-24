package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1810a;

    public e(c cVar) {
        this.f1810a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1810a.f1807b.cancel();
        this.f1810a.f1808c.f1801b = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.f1810a.f1806a.finish();
    }
}
