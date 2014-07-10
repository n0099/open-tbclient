package com.baidu.mobstat;

import android.content.Context;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ q a;
    private long b;
    private long c;
    private WeakReference<Context> d;
    private WeakReference<Fragment> e;
    private WeakReference<Object> f;
    private int g;

    public x(q qVar, long j, long j2, Context context, Fragment fragment, Object obj, int i) {
        this.a = qVar;
        this.g = 1;
        this.b = j;
        this.c = j2;
        this.d = new WeakReference<>(context);
        this.e = new WeakReference<>(fragment);
        this.f = new WeakReference<>(obj);
        this.g = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        o oVar2;
        o oVar3;
        if (this.c - this.b < this.a.a() || this.b <= 0) {
            return;
        }
        if (this.d.get() == null && this.e.get() == null && this.f.get() == null) {
            return;
        }
        oVar = this.a.k;
        oVar.b(this.b);
        oVar2 = this.a.k;
        String jSONObject = oVar2.c().toString();
        com.baidu.mobstat.a.e.a("statsdk", "new session:" + jSONObject);
        DataCore.getInstance().putSession(jSONObject);
        Context context = null;
        if (this.g == 1) {
            Context context2 = this.d.get();
            DataCore.getInstance().flush(context2);
            context = context2;
        } else if (this.g == 2) {
            DataCore.getInstance().flush(this.e.get().getActivity());
        } else if (this.g == 3) {
            Context a = q.a(this.f.get());
            DataCore.getInstance().flush(a);
            context = a;
        }
        oVar3 = this.a.k;
        oVar3.b();
        if (this.g == 1) {
            this.a.a(this.d.get());
        } else if (this.g == 2) {
            this.a.a((Context) this.e.get().getActivity());
        } else {
            this.a.a(context);
        }
        k.a().b(context);
    }
}
