package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1835a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f1835a.f1834a;
        g gVar = new g(context);
        hashMap = this.f1835a.b;
        this.f1835a.a(gVar.a(hashMap));
    }
}
