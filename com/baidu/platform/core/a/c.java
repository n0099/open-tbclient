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
        this.f9317a.a("qt", "ext");
        this.f9317a.a("num", Constants.DEFAULT_UIN);
        this.f9317a.a("l", "10");
        this.f9317a.a("ie", "utf-8");
        this.f9317a.a("oue", "1");
        this.f9317a.a(UriUtil.LOCAL_RESOURCE_SCHEME, RetrieveTaskManager.KEY);
        this.f9317a.a("fromproduct", "android_map_sdk");
        this.f9317a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
