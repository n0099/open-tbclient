package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* loaded from: classes2.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6359b;

    public k(LBSAuthManager lBSAuthManager, String str) {
        this.f6359b = lBSAuthManager;
        this.f6358a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.f6359b.a(str, this.f6358a);
    }
}
