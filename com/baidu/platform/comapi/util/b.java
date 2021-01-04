package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.C0294a f4385a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f4386b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.C0294a c0294a, Object obj) {
        this.c = aVar;
        this.f4385a = c0294a;
        this.f4386b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f4385a, this.f4386b);
    }
}
