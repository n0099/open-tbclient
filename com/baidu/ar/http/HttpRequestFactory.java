package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpRequest;
/* loaded from: classes3.dex */
public class HttpRequestFactory implements com.baidu.ar.ihttp.b {
    private volatile e pG;

    public e getExecutor() {
        if (this.pG == null) {
            synchronized (this) {
                if (this.pG == null) {
                    this.pG = new e(2, 5, 1000, 60L);
                }
            }
        }
        return this.pG;
    }

    @Override // com.baidu.ar.ihttp.b
    public IHttpRequest newRequest() {
        f fVar = new f(this);
        fVar.setCharset(d.pu);
        fVar.setConnectionTimeout(2000);
        fVar.setReadTimeout(30000);
        fVar.setUseCache(false);
        fVar.addHeaders(d.pv);
        return fVar;
    }

    @Override // com.baidu.ar.ihttp.b
    public void release() {
        if (this.pG != null) {
            this.pG.shutdown();
            this.pG = null;
        }
    }
}
