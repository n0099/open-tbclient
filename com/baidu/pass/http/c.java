package com.baidu.pass.http;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f9256a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "pass_net_thread#" + this.f9256a.getAndIncrement());
    }
}
