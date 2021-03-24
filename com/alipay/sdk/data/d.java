package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f1888b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f1889c;

    public d(c cVar, Context context, HashMap hashMap) {
        this.f1889c = cVar;
        this.f1887a = context;
        this.f1888b = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String a2;
        a2 = this.f1889c.a(this.f1887a, this.f1888b);
        return a2;
    }
}
