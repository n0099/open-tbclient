package com.baidu.pass.http;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f2792a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "pass_net_work_request_thread # " + this.f2792a.getAndIncrement());
    }
}
