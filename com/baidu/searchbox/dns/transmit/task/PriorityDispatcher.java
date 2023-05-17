package com.baidu.searchbox.dns.transmit.task;

import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes3.dex */
public class PriorityDispatcher extends Dispatcher {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.task.Dispatcher
    public PriorityBlockingQueue<AsyncTask> getReadyDeque() {
        return new PriorityBlockingQueue<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.task.Dispatcher
    public PriorityBlockingQueue<AsyncTask> getRunningDeque() {
        return new PriorityBlockingQueue<>();
    }
}
