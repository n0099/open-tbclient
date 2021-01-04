package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpRequest;
/* loaded from: classes6.dex */
public class HttpRequestFactory implements com.baidu.ar.ihttp.b {
    private volatile e ra;

    public e getExecutor() {
        if (this.ra == null) {
            synchronized (this) {
                if (this.ra == null) {
                    this.ra = new e(2, 5, 1000, 60L);
                }
            }
        }
        return this.ra;
    }

    @Override // com.baidu.ar.ihttp.b
    public IHttpRequest newRequest() {
        f fVar = new f(this);
        fVar.setCharset(d.qO);
        fVar.setConnectionTimeout(2000);
        fVar.setReadTimeout(30000);
        fVar.setUseCache(false);
        fVar.addHeaders(d.qP);
        return fVar;
    }

    @Override // com.baidu.ar.ihttp.b
    public void release() {
        if (this.ra != null) {
            this.ra.shutdown();
            this.ra = null;
        }
    }
}
