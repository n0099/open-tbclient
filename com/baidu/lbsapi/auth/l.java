package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;
/* loaded from: classes2.dex */
public class l implements e.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6417a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6418b;

    public l(LBSAuthManager lBSAuthManager, String str) {
        this.f6418b = lBSAuthManager;
        this.f6417a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.f6418b.a(str, this.f6417a);
    }
}
