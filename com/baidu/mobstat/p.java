package com.baidu.mobstat;

import android.content.Context;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f791a;
    private long b;
    private long c;
    private WeakReference d;

    public p(m mVar, long j, long j2, Context context) {
        this.f791a = mVar;
        this.b = j;
        this.c = j2;
        this.d = new WeakReference(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        k kVar2;
        k kVar3;
        if (this.c - this.b < 30000 || this.b <= 0 || this.d.get() == null) {
            return;
        }
        kVar = this.f791a.f;
        kVar.b(this.b);
        kVar2 = this.f791a.f;
        String jSONObject = kVar2.c().toString();
        com.baidu.mobstat.a.b.a("stat", "new session:" + jSONObject);
        b.a().c(jSONObject);
        b.a().b((Context) this.d.get());
        kVar3 = this.f791a.f;
        kVar3.b();
        this.f791a.a((Context) this.d.get());
    }
}
