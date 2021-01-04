package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3415a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f3416b;
    final /* synthetic */ String c;
    final /* synthetic */ CpuInfoManager.UrlListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.f3415a = context;
        this.f3416b = i;
        this.c = str;
        this.d = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2 = new com.baidu.mobads.production.b.c(this.f3415a.getApplicationContext(), this.f3416b, this.c).a();
        if (this.d != null) {
            new Handler(Looper.getMainLooper()).post(new k(this, a2));
        }
    }
}
