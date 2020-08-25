package com.baidu.pass.http;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
class a implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "pass_net_work_request_thread # " + this.a.getAndIncrement());
    }
}
