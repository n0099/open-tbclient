package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2547a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f2548b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LBSAuthManager lBSAuthManager, String str) {
        this.f2548b = lBSAuthManager;
        this.f2547a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.f2548b.a(str, this.f2547a);
    }
}
