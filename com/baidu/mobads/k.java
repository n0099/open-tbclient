package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* loaded from: classes2.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f8359b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8360c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CpuInfoManager.UrlListener f8361d;

    public k(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.f8358a = context;
        this.f8359b = i;
        this.f8360c = str;
        this.f8361d = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2 = new com.baidu.mobads.production.cpu.d(this.f8358a.getApplicationContext(), this.f8359b, this.f8360c).a();
        if (this.f8361d != null) {
            new Handler(Looper.getMainLooper()).post(new l(this, a2));
        }
    }
}
