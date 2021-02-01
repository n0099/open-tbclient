package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3391a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f3392b;
    final /* synthetic */ String c;
    final /* synthetic */ CpuInfoManager.UrlListener d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.f3391a = context;
        this.f3392b = i;
        this.c = str;
        this.d = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2 = new com.baidu.mobads.production.cpu.d(this.f3391a.getApplicationContext(), this.f3392b, this.c).a();
        if (this.d != null) {
            new Handler(Looper.getMainLooper()).post(new l(this, a2));
        }
    }
}
