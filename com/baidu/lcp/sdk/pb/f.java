package com.baidu.lcp.sdk.pb;

import android.content.Context;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class f {
    private g axa = new g();
    private h axb = new h();

    public com.baidu.lcp.sdk.connect.b d(Context context, long j) {
        return this.axa.e(context, j);
    }

    public com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, boolean z) {
        return this.axa.b(bVar, z);
    }

    public com.baidu.lcp.sdk.connect.b h(InputStream inputStream) throws Exception {
        return this.axb.i(inputStream);
    }
}
