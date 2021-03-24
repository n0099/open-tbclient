package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f8538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f8539c;

    public i(h hVar, Context context, Intent intent) {
        this.f8539c = hVar;
        this.f8537a = context;
        this.f8538b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8537a.startActivity(this.f8538b);
    }
}
