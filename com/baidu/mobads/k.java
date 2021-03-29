package com.baidu.mobads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.CpuInfoManager;
/* loaded from: classes2.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f8360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8361c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CpuInfoManager.UrlListener f8362d;

    public k(Context context, int i, String str, CpuInfoManager.UrlListener urlListener) {
        this.f8359a = context;
        this.f8360b = i;
        this.f8361c = str;
        this.f8362d = urlListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a2 = new com.baidu.mobads.production.cpu.d(this.f8359a.getApplicationContext(), this.f8360b, this.f8361c).a();
        if (this.f8362d != null) {
            new Handler(Looper.getMainLooper()).post(new l(this, a2));
        }
    }
}
