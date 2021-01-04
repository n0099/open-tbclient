package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2546a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f2547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LBSAuthManager lBSAuthManager, String str) {
        this.f2547b = lBSAuthManager;
        this.f2546a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.f2547b.a(str, this.f2546a);
    }
}
