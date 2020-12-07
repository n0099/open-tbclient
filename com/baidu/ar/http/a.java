package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
/* loaded from: classes10.dex */
class a implements l {
    private com.baidu.ar.ihttp.a qF;
    private HttpException qG;
    private Object mLock = new Object();
    private volatile boolean qH = false;

    public a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        this.qG = httpException;
        this.qF = aVar;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.qH) {
            return;
        }
        synchronized (this.mLock) {
            Boolean bool = true;
            this.qH = bool.booleanValue();
        }
    }

    @Override // com.baidu.ar.http.l
    public i eH() {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLock) {
            if (this.qH) {
                return;
            }
            if (this.qF != null) {
                this.qF.a(this.qG);
            }
        }
    }
}
