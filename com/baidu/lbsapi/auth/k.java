package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1844a;
    final /* synthetic */ LBSAuthManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f1844a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.b.a(str, this.f1844a);
    }
}
