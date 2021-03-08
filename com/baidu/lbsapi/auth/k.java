package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1883a;
    final /* synthetic */ LBSAuthManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f1883a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.b.a(str, this.f1883a);
    }
}
