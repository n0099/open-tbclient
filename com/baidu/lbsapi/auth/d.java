package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2536a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f2536a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f2536a.f2534a;
        g gVar = new g(context);
        hashMap = this.f2536a.f2535b;
        this.f2536a.a(gVar.a(hashMap));
    }
}
