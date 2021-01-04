package com.baidu.lbsapi.auth;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2539a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        e eVar = this.f2539a;
        list = this.f2539a.f2538b;
        eVar.a(list);
    }
}
