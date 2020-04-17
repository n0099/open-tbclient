package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
/* loaded from: classes3.dex */
class a implements l {

    /* renamed from: pl  reason: collision with root package name */
    private com.baidu.ar.ihttp.a f984pl;
    private HttpException pm;
    private Object mLock = new Object();
    private volatile boolean pn = false;

    public a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        this.pm = httpException;
        this.f984pl = aVar;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.pn) {
            return;
        }
        synchronized (this.mLock) {
            Boolean bool = true;
            this.pn = bool.booleanValue();
        }
    }

    @Override // com.baidu.ar.http.l
    public i di() {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLock) {
            if (this.pn) {
                return;
            }
            if (this.f984pl != null) {
                this.f984pl.a(this.pm);
            }
        }
    }
}
