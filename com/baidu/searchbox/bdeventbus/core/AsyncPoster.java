package com.baidu.searchbox.bdeventbus.core;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "Ljava/lang/Runnable;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBdEventBusCore", "()Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "setBdEventBusCore", "concurrentLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getConcurrentLinkedQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "enqueue", "", "event", "subscriptionInfo", "run", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsyncPoster implements Runnable, Poster {
    public final String TAG;
    public BdEventBusCore bdEventBusCore;
    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> concurrentLinkedQueue;

    public AsyncPoster(BdEventBusCore bdEventBusCore) {
        Intrinsics.checkNotNullParameter(bdEventBusCore, "bdEventBusCore");
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "AsyncPoster";
        this.concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    public final void setBdEventBusCore(BdEventBusCore bdEventBusCore) {
        Intrinsics.checkNotNullParameter(bdEventBusCore, "<set-?>");
        this.bdEventBusCore = bdEventBusCore;
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(subscriptionInfo, "subscriptionInfo");
        synchronized (this) {
            this.concurrentLinkedQueue.offer(new Pair<>(event, subscriptionInfo));
            this.bdEventBusCore.getExecutorService$lib_bd_event_bus_release().execute(this);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final BdEventBusCore getBdEventBusCore() {
        return this.bdEventBusCore;
    }

    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> getConcurrentLinkedQueue() {
        return this.concurrentLinkedQueue;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair<Object, SubscriptionInfo> poll = this.concurrentLinkedQueue.poll();
        if (poll != null) {
            poll.getSecond().getAction().call(poll.getFirst());
        }
    }
}
