package com.baidu.lbsapi.auth;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2540a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        e eVar = this.f2540a;
        list = this.f2540a.f2539b;
        eVar.a(list);
    }
}
