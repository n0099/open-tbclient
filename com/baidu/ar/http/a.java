package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
/* loaded from: classes11.dex */
class a implements l {
    private com.baidu.ar.ihttp.a qp;
    private HttpException qq;
    private Object mLock = new Object();
    private volatile boolean qr = false;

    public a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        this.qq = httpException;
        this.qp = aVar;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.qr) {
            return;
        }
        synchronized (this.mLock) {
            Boolean bool = true;
            this.qr = bool.booleanValue();
        }
    }

    @Override // com.baidu.ar.http.l
    public i eI() {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLock) {
            if (this.qr) {
                return;
            }
            if (this.qp != null) {
                this.qp.a(this.qq);
            }
        }
    }
}
