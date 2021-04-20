package com.alipay.sdk.app;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f1835a;

    public e(c cVar) {
        this.f1835a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1835a.f1832b.cancel();
        this.f1835a.f1833c.f1826b = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.f1835a.f1831a.finish();
    }
}
