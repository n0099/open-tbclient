package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
/* loaded from: classes11.dex */
class a implements l {
    private com.baidu.ar.ihttp.a pK;
    private HttpException pL;
    private Object mLock = new Object();
    private volatile boolean pM = false;

    public a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        this.pL = httpException;
        this.pK = aVar;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.pM) {
            return;
        }
        synchronized (this.mLock) {
            Boolean bool = true;
            this.pM = bool.booleanValue();
        }
    }

    @Override // com.baidu.ar.http.l
    public i dy() {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLock) {
            if (this.pM) {
                return;
            }
            if (this.pK != null) {
                this.pK.a(this.pL);
            }
        }
    }
}
