package com.baidu.searchbox.bdeventbus.core;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010!\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0000¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020 H\u0002J7\u0010(\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00012\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010/H\u0000¢\u0006\u0002\b0J\u000e\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "", "()V", "DEFAULT_EXECUTOR_SERVICE", "Ljava/util/concurrent/ExecutorService;", "getDEFAULT_EXECUTOR_SERVICE", "()Ljava/util/concurrent/ExecutorService;", "DEFAULT_EXECUTOR_SERVICE$delegate", "Lkotlin/Lazy;", "LAZY_SUBSCRIBE_MSG", "", "TAG", "", "asyncPoster", "Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "getAsyncPoster", "()Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "asyncPoster$delegate", "backgroundPoster", "Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "getBackgroundPoster", "()Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "backgroundPoster$delegate", "eventBySubscriber", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mainHandlerPoster", "Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "getMainHandlerPoster", "()Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "mainHandlerPoster$delegate", "subscriptionsInfoByEventType", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getExecutorService", "getExecutorService$lib_bd_event_bus_release", CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, "", "event", "post$lib_bd_event_bus_release", "postSingleEvent", TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, "subscriptionInfo", "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "subscribe$lib_bd_event_bus_release", "unregister", "PostingThreadState", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BdEventBusCore {
    public final int LAZY_SUBSCRIBE_MSG = 1;
    public final String TAG = "BdEventBusCore";
    public ConcurrentHashMap<Object, CopyOnWriteArrayList<SubscriptionInfo>> subscriptionsInfoByEventType = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Object, CopyOnWriteArrayList<Object>> eventBySubscriber = new ConcurrentHashMap<>();
    public final Lazy DEFAULT_EXECUTOR_SERVICE$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ExecutorService>() { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$DEFAULT_EXECUTOR_SERVICE$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final ExecutorService invoke() {
            return Executors.newCachedThreadPool();
        }
    });
    public final Lazy mainHandlerPoster$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MainHandlerPoster>() { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$mainHandlerPoster$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MainHandlerPoster invoke() {
            return new MainHandlerPoster();
        }
    });
    public final Lazy backgroundPoster$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BackgroundPoster>() { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$backgroundPoster$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BackgroundPoster invoke() {
            return new BackgroundPoster(BdEventBusCore.this);
        }
    });
    public final Lazy asyncPoster$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AsyncPoster>() { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$asyncPoster$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AsyncPoster invoke() {
            return new AsyncPoster(BdEventBusCore.this);
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore$PostingThreadState;", "", "()V", "eventQueue", "", "getEventQueue", "()Ljava/util/List;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PostingThreadState {
        public final List<Object> eventQueue = new ArrayList();

        public final List<Object> getEventQueue() {
            return this.eventQueue;
        }
    }

    private final AsyncPoster getAsyncPoster() {
        return (AsyncPoster) this.asyncPoster$delegate.getValue();
    }

    private final BackgroundPoster getBackgroundPoster() {
        return (BackgroundPoster) this.backgroundPoster$delegate.getValue();
    }

    private final ExecutorService getDEFAULT_EXECUTOR_SERVICE() {
        Object value = this.DEFAULT_EXECUTOR_SERVICE$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-DEFAULT_EXECUTOR_SERVICE>(...)");
        return (ExecutorService) value;
    }

    private final MainHandlerPoster getMainHandlerPoster() {
        return (MainHandlerPoster) this.mainHandlerPoster$delegate.getValue();
    }

    public final ExecutorService getExecutorService$lib_bd_event_bus_release() {
        return getDEFAULT_EXECUTOR_SERVICE();
    }

    private final void postSingleEvent(Object obj) {
        CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList = this.subscriptionsInfoByEventType.get(obj.getClass());
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<SubscriptionInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                SubscriptionInfo subscription = it.next();
                int threadMode = subscription.getThreadMode();
                if (threadMode != 0) {
                    if (threadMode != 1) {
                        if (threadMode != 2) {
                            if (threadMode != 3) {
                                if (threadMode == 4) {
                                    MainHandlerPoster mainHandlerPoster = getMainHandlerPoster();
                                    Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                                    mainHandlerPoster.enqueue(obj, subscription);
                                }
                            } else {
                                AsyncPoster asyncPoster = getAsyncPoster();
                                Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                                asyncPoster.enqueue(obj, subscription);
                            }
                        } else if (UiThreadUtils.isOnUiThread()) {
                            BackgroundPoster backgroundPoster = getBackgroundPoster();
                            Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                            backgroundPoster.enqueue(obj, subscription);
                        } else {
                            subscription.getAction().call(obj);
                        }
                    } else if (UiThreadUtils.isOnUiThread()) {
                        subscription.getAction().call(obj);
                    } else {
                        MainHandlerPoster mainHandlerPoster2 = getMainHandlerPoster();
                        Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                        mainHandlerPoster2.enqueue(obj, subscription);
                    }
                } else {
                    subscription.getAction().call(obj);
                }
            }
        }
    }

    private final void subscribe(SubscriptionInfo subscriptionInfo) {
        CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList = this.subscriptionsInfoByEventType.get(subscriptionInfo.getEventType());
        if (copyOnWriteArrayList != null) {
            if (!copyOnWriteArrayList.contains(subscriptionInfo)) {
                copyOnWriteArrayList.add(subscriptionInfo);
            }
        } else {
            CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList2.add(subscriptionInfo);
            this.subscriptionsInfoByEventType.put(subscriptionInfo.getEventType(), copyOnWriteArrayList2);
        }
        CopyOnWriteArrayList<Object> copyOnWriteArrayList3 = this.eventBySubscriber.get(subscriptionInfo.getSubscriber());
        if (copyOnWriteArrayList3 != null) {
            if (!copyOnWriteArrayList3.contains(subscriptionInfo.getEventType())) {
                copyOnWriteArrayList3.add(subscriptionInfo.getEventType());
                return;
            }
            return;
        }
        CopyOnWriteArrayList<Object> copyOnWriteArrayList4 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList4.add(subscriptionInfo.getEventType());
        this.eventBySubscriber.put(subscriptionInfo.getSubscriber(), copyOnWriteArrayList4);
    }

    public final synchronized void unregister(Object subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = this.eventBySubscriber.get(subscriber);
        if (copyOnWriteArrayList != null) {
            Iterator<Object> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList2 = this.subscriptionsInfoByEventType.get(it.next());
                if (copyOnWriteArrayList2 != null) {
                    for (SubscriptionInfo subscriptionInfo : copyOnWriteArrayList2) {
                        if (Intrinsics.areEqual(subscriptionInfo.getSubscriber(), subscriber)) {
                            copyOnWriteArrayList2.remove(subscriptionInfo);
                        }
                    }
                }
            }
            this.eventBySubscriber.remove(subscriber);
        }
    }

    public final void post$lib_bd_event_bus_release(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        postSingleEvent(event);
    }

    public final void subscribe$lib_bd_event_bus_release(Object subscriber, Class<?> eventType, int i, Action<Object> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        subscribe(new SubscriptionInfo(subscriber, eventType, i, action));
    }
}
