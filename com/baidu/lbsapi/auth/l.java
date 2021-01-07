package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l implements e.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2549a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f2550b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LBSAuthManager lBSAuthManager, String str) {
        this.f2550b = lBSAuthManager;
        this.f2549a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.f2550b.a(str, this.f2549a);
    }
}
