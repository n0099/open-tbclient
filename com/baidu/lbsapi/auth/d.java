package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f2485a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.f2485a.f2483a;
        g gVar = new g(context);
        hashMap = this.f2485a.f2484b;
        this.f2485a.a(gVar.a(hashMap));
    }
}
