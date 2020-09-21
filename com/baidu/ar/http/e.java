package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
class e {
    private ExecutorService qA;
    private int qB;
    private int qC;
    private int qD;
    private long qE;

    public e(int i, int i2, int i3, long j) {
        this.qB = i;
        this.qC = i2;
        this.qD = i3;
        this.qE = j;
    }

    private ExecutorService eL() {
        if (this.qA == null) {
            this.qA = new ThreadPoolExecutor(this.qB, this.qC, this.qE, TimeUnit.SECONDS, new LinkedBlockingQueue(this.qD), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.baidu.ar.http.e.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    com.baidu.ar.g.b.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                }
            });
        }
        return this.qA;
    }

    public l a(g gVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar);
        cVar.setProgressCallback(iProgressCallback);
        cVar.eK();
        return cVar;
    }

    public l a(g gVar, com.baidu.ar.ihttp.a aVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar, aVar);
        cVar.setProgressCallback(iProgressCallback);
        eL().submit(cVar);
        return cVar;
    }

    public l a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        a aVar2 = new a(httpException, aVar);
        eL().submit(aVar2);
        return aVar2;
    }

    public void shutdown() {
        if (this.qA != null) {
            this.qA.shutdown();
        }
    }
}
