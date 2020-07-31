package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpRequest;
/* loaded from: classes11.dex */
public class HttpRequestFactory implements com.baidu.ar.ihttp.b {
    private volatile e qf;

    public e getExecutor() {
        if (this.qf == null) {
            synchronized (this) {
                if (this.qf == null) {
                    this.qf = new e(2, 5, 1000, 60L);
                }
            }
        }
        return this.qf;
    }

    @Override // com.baidu.ar.ihttp.b
    public IHttpRequest newRequest() {
        f fVar = new f(this);
        fVar.setCharset(d.pT);
        fVar.setConnectionTimeout(2000);
        fVar.setReadTimeout(30000);
        fVar.setUseCache(false);
        fVar.addHeaders(d.pU);
        return fVar;
    }

    @Override // com.baidu.ar.ihttp.b
    public void release() {
        if (this.qf != null) {
            this.qf.shutdown();
            this.qf = null;
        }
    }
}
