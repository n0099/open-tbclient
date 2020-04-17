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
    private long pA;
    private ExecutorService pw;
    private int px;
    private int py;
    private int pz;

    public e(int i, int i2, int i3, long j) {
        this.px = i;
        this.py = i2;
        this.pz = i3;
        this.pA = j;
    }

    private ExecutorService dl() {
        if (this.pw == null) {
            this.pw = new ThreadPoolExecutor(this.px, this.py, this.pA, TimeUnit.SECONDS, new LinkedBlockingQueue(this.pz), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.baidu.ar.http.e.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    com.baidu.ar.f.b.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                }
            });
        }
        return this.pw;
    }

    public l a(g gVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar);
        cVar.setProgressCallback(iProgressCallback);
        cVar.dk();
        return cVar;
    }

    public l a(g gVar, com.baidu.ar.ihttp.a aVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar, aVar);
        cVar.setProgressCallback(iProgressCallback);
        dl().submit(cVar);
        return cVar;
    }

    public l a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        a aVar2 = new a(httpException, aVar);
        dl().submit(aVar2);
        return aVar2;
    }

    public void shutdown() {
        if (this.pw != null) {
            this.pw.shutdown();
        }
    }
}
