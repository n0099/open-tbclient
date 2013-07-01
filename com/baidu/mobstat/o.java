package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f588a;
    private long b;
    private WeakReference c;
    private long d;
    private WeakReference e;

    public o(m mVar, long j, Context context, long j2, Context context2) {
        this.f588a = mVar;
        this.b = j;
        this.c = new WeakReference(context);
        this.d = j2;
        this.e = new WeakReference(context2);
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        if (this.c.get() != this.e.get()) {
            com.baidu.mobstat.a.b.b("stat", "onPause() 或 onResume()安放错误||onPause() or onResume() install error.");
            return;
        }
        long j = this.b - this.d;
        Activity activity = (Activity) this.c.get();
        if (activity == null) {
            com.baidu.mobstat.a.b.b("stat", "onPause,WeakReference is already been released");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getComponentName().getShortClassName());
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        com.baidu.mobstat.a.b.a("stat", "new page view, page name = " + sb.toString() + ",stay time = " + j + "(ms)");
        kVar = this.f588a.f;
        kVar.a(sb.toString(), j);
        this.f588a.c((Context) this.c.get(), this.b);
    }
}
