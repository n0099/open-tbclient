package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f1913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f1914c;

    public d(c cVar, Context context, HashMap hashMap) {
        this.f1914c = cVar;
        this.f1912a = context;
        this.f1913b = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String a2;
        a2 = this.f1914c.a(this.f1912a, this.f1913b);
        return a2;
    }
}
