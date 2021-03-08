package com.baidu.lcp.sdk.b;

import android.content.Context;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.lcp.sdk.b.c;
/* loaded from: classes3.dex */
public abstract class a implements c.a, c.InterfaceC0156c {
    protected Context context;

    @Override // com.baidu.lcp.sdk.b.c.a
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public String getMediaType() {
        return HttpHelper.CONTENT_JSON;
    }
}
