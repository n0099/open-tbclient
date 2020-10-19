package com.baidu.lbsapi.auth;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1835a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        e eVar = this.f1835a;
        list = this.f1835a.b;
        eVar.a(list);
    }
}
