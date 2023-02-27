package com.baidu.searchbox.bdeventbus.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.bdeventbus.Action;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "Landroid/os/Handler;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "concurrentLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getConcurrentLinkedQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "handlerActive", "", "maxMillisInsideHandleMessage", "", "getMaxMillisInsideHandleMessage", "()I", "enqueue", "", "event", "subscriptionInfo", "handleMessage", "msg", "Landroid/os/Message;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainHandlerPoster extends Handler implements Poster {
    public final String TAG;
    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> concurrentLinkedQueue;
    public boolean handlerActive;
    public final int maxMillisInsideHandleMessage;

    public MainHandlerPoster() {
        super(Looper.getMainLooper());
        this.TAG = "MainHandlerPoster";
        this.concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.maxMillisInsideHandleMessage = 10;
    }

    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> getConcurrentLinkedQueue() {
        return this.concurrentLinkedQueue;
    }

    public final int getMaxMillisInsideHandleMessage() {
        return this.maxMillisInsideHandleMessage;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(subscriptionInfo, "subscriptionInfo");
        synchronized (this) {
            this.concurrentLinkedQueue.offer(new Pair<>(event, subscriptionInfo));
            if (!this.handlerActive) {
                this.handlerActive = true;
                sendMessage(obtainMessage());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.lang.Object] */
    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.handleMessage(msg);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? poll = this.concurrentLinkedQueue.poll();
                objectRef.element = poll;
                if (poll == 0) {
                    synchronized (this) {
                        ?? poll2 = this.concurrentLinkedQueue.poll();
                        objectRef.element = poll2;
                        if (poll2 == 0) {
                            this.handlerActive = false;
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
            } while (System.currentTimeMillis() - currentTimeMillis < this.maxMillisInsideHandleMessage);
            sendMessage(obtainMessage());
            this.handlerActive = true;
        } finally {
            this.handlerActive = false;
        }
    }
}
