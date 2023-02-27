package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public ExecutorService qQ;
    public int qR;
    public int qS;
    public int qT;
    public long qU;

    public e(int i, int i2, int i3, long j) {
        this.qR = i;
        this.qS = i2;
        this.qT = i3;
        this.qU = j;
    }

    private ExecutorService eK() {
        if (this.qQ == null) {
            this.qQ = new ThreadPoolExecutor(this.qR, this.qS, this.qU, TimeUnit.SECONDS, new LinkedBlockingQueue(this.qT), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.baidu.ar.http.e.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    com.baidu.ar.h.b.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                }
            });
        }
        return this.qQ;
    }

    public l a(g gVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar);
        cVar.setProgressCallback(iProgressCallback);
        cVar.eJ();
        return cVar;
    }

    public l a(g gVar, com.baidu.ar.ihttp.a aVar, IProgressCallback iProgressCallback) {
        c cVar = new c(gVar, aVar);
        cVar.setProgressCallback(iProgressCallback);
        eK().submit(cVar);
        return cVar;
    }

    public l a(HttpException httpException, com.baidu.ar.ihttp.a aVar) {
        a aVar2 = new a(httpException, aVar);
        eK().submit(aVar2);
        return aVar2;
    }

    public void shutdown() {
        ExecutorService executorService = this.qQ;
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
