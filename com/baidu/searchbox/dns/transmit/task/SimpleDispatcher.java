package com.baidu.searchbox.dns.transmit.task;

import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes2.dex */
public class SimpleDispatcher extends Dispatcher {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.task.Dispatcher
    public Deque<AsyncTask> getReadyDeque() {
        return new ArrayDeque();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.task.Dispatcher
    public Deque<AsyncTask> getRunningDeque() {
        return new ArrayDeque();
    }
}
