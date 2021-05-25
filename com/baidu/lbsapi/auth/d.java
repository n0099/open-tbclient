package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f6298a;

    public d(c cVar) {
        this.f6298a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f6298a.f6295a;
        g gVar = new g(context);
        hashMap = this.f6298a.f6296b;
        this.f6298a.a(gVar.a(hashMap));
    }
}
