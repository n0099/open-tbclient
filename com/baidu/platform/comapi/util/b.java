package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.C0283a f2945a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.C0283a c0283a, Object obj) {
        this.c = aVar;
        this.f2945a = c0283a;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f2945a, this.b);
    }
}
