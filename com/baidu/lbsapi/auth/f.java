package com.baidu.lbsapi.auth;

import java.util.List;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f6402a;

    public f(e eVar) {
        this.f6402a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        e eVar = this.f6402a;
        list = eVar.f6400b;
        eVar.a(list);
    }
}
