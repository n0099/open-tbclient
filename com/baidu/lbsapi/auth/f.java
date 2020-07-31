package com.baidu.lbsapi.auth;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class f implements Runnable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        e eVar = this.a;
        list = this.a.b;
        eVar.a(list);
    }
}
