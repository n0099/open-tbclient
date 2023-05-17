package com.baidu.searchbox.bdeventbus.core;

import com.baidu.searchbox.bdeventbus.Action;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "Ljava/lang/Runnable;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBdEventBusCore", "()Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "setBdEventBusCore", "blockingQueue", "Ljava/util/concurrent/BlockingQueue;", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getBlockingQueue", "()Ljava/util/concurrent/BlockingQueue;", "executorRunning", "", "getExecutorRunning", "()Z", "setExecutorRunning", "(Z)V", "enqueue", "", "event", "subscriptionInfo", "run", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackgroundPoster implements Runnable, Poster {
    public final String TAG;
    public BdEventBusCore bdEventBusCore;
    public final BlockingQueue<Pair<Object, SubscriptionInfo>> blockingQueue;
    public volatile boolean executorRunning;

    public BackgroundPoster(BdEventBusCore bdEventBusCore) {
        Intrinsics.checkNotNullParameter(bdEventBusCore, "bdEventBusCore");
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "BackgroundPoster";
        this.blockingQueue = new LinkedBlockingQueue();
    }

    public final void setBdEventBusCore(BdEventBusCore bdEventBusCore) {
        Intrinsics.checkNotNullParameter(bdEventBusCore, "<set-?>");
        this.bdEventBusCore = bdEventBusCore;
    }

    public final void setExecutorRunning(boolean z) {
        this.executorRunning = z;
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(subscriptionInfo, "subscriptionInfo");
        synchronized (this) {
            this.blockingQueue.offer(new Pair<>(event, subscriptionInfo));
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.bdEventBusCore.getExecutorService$lib_bd_event_bus_release().execute(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final BdEventBusCore getBdEventBusCore() {
        return this.bdEventBusCore;
    }

    public final BlockingQueue<Pair<Object, SubscriptionInfo>> getBlockingQueue() {
        return this.blockingQueue;
    }

    public final boolean getExecutorRunning() {
        return this.executorRunning;
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.Object] */
    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? poll = this.blockingQueue.poll(1000L, TimeUnit.MILLISECONDS);
                objectRef.element = poll;
                if (poll == 0) {
                    synchronized (this) {
                        ?? poll2 = this.blockingQueue.poll();
                        objectRef.element = poll2;
                        if (poll2 == 0) {
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                T t = objectRef.element;
                Intrinsics.checkNotNull(t);
                Action<Object> action = ((SubscriptionInfo) ((Pair) t).getSecond()).getAction();
                T t2 = objectRef.element;
                Intrinsics.checkNotNull(t2);
                action.call(((Pair) t2).getFirst());
            } catch (Exception unused) {
                return;
            } finally {
                this.executorRunning = false;
            }
        }
    }
}
