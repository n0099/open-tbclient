package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.c;
/* loaded from: classes2.dex */
public class k implements c.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6416b;

    public k(LBSAuthManager lBSAuthManager, String str) {
        this.f6416b = lBSAuthManager;
        this.f6415a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.c.a
    public void a(String str) {
        this.f6416b.a(str, this.f6415a);
    }
}
