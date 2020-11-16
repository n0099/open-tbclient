package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpRequest;
/* loaded from: classes12.dex */
public class HttpRequestFactory implements com.baidu.ar.ihttp.b {
    private volatile e qK;

    public e getExecutor() {
        if (this.qK == null) {
            synchronized (this) {
                if (this.qK == null) {
                    this.qK = new e(2, 5, 1000, 60L);
                }
            }
        }
        return this.qK;
    }

    @Override // com.baidu.ar.ihttp.b
    public IHttpRequest newRequest() {
        f fVar = new f(this);
        fVar.setCharset(d.qy);
        fVar.setConnectionTimeout(2000);
        fVar.setReadTimeout(30000);
        fVar.setUseCache(false);
        fVar.addHeaders(d.qz);
        return fVar;
    }

    @Override // com.baidu.ar.ihttp.b
    public void release() {
        if (this.qK != null) {
            this.qK.shutdown();
            this.qK = null;
        }
    }
}
