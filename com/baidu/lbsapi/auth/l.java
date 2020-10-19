package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l implements e.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1841a;
    final /* synthetic */ LBSAuthManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f1841a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.b.a(str, this.f1841a);
    }
}
