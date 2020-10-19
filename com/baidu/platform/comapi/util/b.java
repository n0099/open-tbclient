package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.C0259a f2943a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.C0259a c0259a, Object obj) {
        this.c = aVar;
        this.f2943a = c0259a;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f2943a, this.b);
    }
}
