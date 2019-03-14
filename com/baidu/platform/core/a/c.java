package com.baidu.platform.core.a;

import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.a.a("qt", "ext");
        this.a.a("num", Constants.DEFAULT_UIN);
        this.a.a("l", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.a.a("ie", "utf-8");
        this.a.a("oue", "1");
        this.a.a("res", "api");
        this.a.a("fromproduct", "android_map_sdk");
        this.a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
