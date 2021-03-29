package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8538a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f8539b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f8540c;

    public i(h hVar, Context context, Intent intent) {
        this.f8540c = hVar;
        this.f8538a = context;
        this.f8539b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8538a.startActivity(this.f8539b);
    }
}
