package com.baidu.lcp.sdk.pb;

import android.content.Context;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class f {
    private g avA = new g();
    private h avB = new h();

    public com.baidu.lcp.sdk.connect.b f(Context context, long j) {
        return this.avA.g(context, j);
    }

    public com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, boolean z) {
        return this.avA.b(bVar, z);
    }

    public com.baidu.lcp.sdk.connect.b h(InputStream inputStream) throws Exception {
        return this.avB.i(inputStream);
    }
}
