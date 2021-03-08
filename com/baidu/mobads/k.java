package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2418a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ CpuInfoManager.UrlListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.f2418a = context;
        this.b = i;
        this.c = str;
        this.d = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2 = new com.baidu.mobads.production.cpu.d(this.f2418a.getApplicationContext(), this.b, this.c).a();
        if (this.d != null) {
            new Handler(Looper.getMainLooper()).post(new l(this, a2));
        }
    }
}
