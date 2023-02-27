package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
/* loaded from: classes.dex */
public class a implements l {
    public com.baidu.ar.ihttp.a qF;
    public HttpException qG;
    public Object mLock = new Object();
    public volatile boolean qH = false;

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
            this.qH = true;
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
            com.baidu.ar.ihttp.a aVar = this.qF;
            if (aVar != null) {
                aVar.a(this.qG);
            }
        }
    }
}
