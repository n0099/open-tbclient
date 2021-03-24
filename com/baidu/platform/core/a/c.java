package com.baidu.platform.core.a;

import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.facebook.common.util.UriUtil;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.f9820a.a("qt", "ext");
        this.f9820a.a("num", Constants.DEFAULT_UIN);
        this.f9820a.a("l", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.f9820a.a("ie", "utf-8");
        this.f9820a.a("oue", "1");
        this.f9820a.a(UriUtil.LOCAL_RESOURCE_SCHEME, RetrieveTaskManager.KEY);
        this.f9820a.a("fromproduct", "android_map_sdk");
        this.f9820a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
