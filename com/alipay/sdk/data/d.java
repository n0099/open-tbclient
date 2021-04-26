package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1863a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f1864b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f1865c;

    public d(c cVar, Context context, HashMap hashMap) {
        this.f1865c = cVar;
        this.f1863a = context;
        this.f1864b = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String a2;
        a2 = this.f1865c.a(this.f1863a, this.f1864b);
        return a2;
    }
}
