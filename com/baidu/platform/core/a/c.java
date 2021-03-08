package com.baidu.platform.core.a;

import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.f2867a.a("qt", "ext");
        this.f2867a.a("num", "1000");
        this.f2867a.a("l", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.f2867a.a("ie", "utf-8");
        this.f2867a.a("oue", "1");
        this.f2867a.a("res", "api");
        this.f2867a.a("fromproduct", "android_map_sdk");
        this.f2867a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
