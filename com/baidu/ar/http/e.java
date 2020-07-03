package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
class e {
    private ExecutorService pV;
    private int pW;
    private int pX;
    private int pY;
    private long pZ;

    public e(int i, int i2, int i3, long j) {
        this.pW = i;
        this.pX = i2;
        this.pY = i3;
        this.pZ = j;
    }

    private ExecutorService dB() {
        if (this.pV == null) {
            this.pV = new ThreadPoolExecutor(this.pW, this.pX, this.pZ, TimeUnit.SECONDS, new LinkedBlockingQueue(this.pY), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.baidu.ar.http.e.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    com.baidu.ar.f.b.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                }
            });
        }
        return this.pV;
    }

    public l a(g gVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar);
        cVar.setProgressCallback(iProgressCallback);
        cVar.dA();
        return cVar;
    }

    public l a(g gVar, com.baidu.ar.ihttp.a aVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar, aVar);
        cVar.setProgressCallback(iProgressCallback);
        dB().submit(cVar);
        return cVar;
    }

    public l a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        a aVar2 = new a(httpException, aVar);
        dB().submit(aVar2);
        return aVar2;
    }

    public void shutdown() {
        if (this.pV != null) {
            this.pV.shutdown();
        }
    }
}
