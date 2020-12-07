package com.baidu.lcp.sdk.pb;

import android.content.Context;
import java.io.InputStream;
/* loaded from: classes14.dex */
public class f {
    private g aAi = new g();
    private h aAj = new h();

    public com.baidu.lcp.sdk.connect.b d(Context context, long j) {
        return this.aAi.e(context, j);
    }

    public com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, boolean z) {
        return this.aAi.b(bVar, z);
    }

    public com.baidu.lcp.sdk.connect.b h(InputStream inputStream) throws Exception {
        return this.aAj.i(inputStream);
    }
}
