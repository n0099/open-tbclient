package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1876a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f1877b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f1878c;

    public d(c cVar, Context context, HashMap hashMap) {
        this.f1878c = cVar;
        this.f1876a = context;
        this.f1877b = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String a2;
        a2 = this.f1878c.a(this.f1876a, this.f1877b);
        return a2;
    }
}
