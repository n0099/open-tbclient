package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public final class j implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ CpuInfoManager.UrlListener bxV;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.a = context;
        this.b = i;
        this.c = str;
        this.bxV = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a = new com.baidu.mobads.production.b.c(this.a.getApplicationContext(), this.b, this.c).a();
        if (this.bxV != null) {
            new Handler(Looper.getMainLooper()).post(new k(this, a));
        }
    }
}
