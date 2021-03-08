package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1876a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f1876a.f1875a;
        g gVar = new g(context);
        hashMap = this.f1876a.b;
        this.f1876a.a(gVar.a(hashMap));
    }
}
