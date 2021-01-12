package com.baidu.lcp.sdk.pb;

import android.content.Context;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class f {
    private g avL = new g();
    private h avM = new h();

    public com.baidu.lcp.sdk.connect.b f(Context context, long j) {
        return this.avL.g(context, j);
    }

    public com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, boolean z) {
        return this.avL.b(bVar, z);
    }

    public com.baidu.lcp.sdk.connect.b h(InputStream inputStream) throws Exception {
        return this.avM.i(inputStream);
    }
}
