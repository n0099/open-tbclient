package com.baidu.searchbox.bdeventbus.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010!\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0000¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020 H\u0002J7\u0010(\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00012\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010/H\u0000¢\u0006\u0002\b0J\u000e\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "", "()V", "DEFAULT_EXECUTOR_SERVICE", "Ljava/util/concurrent/ExecutorService;", "getDEFAULT_EXECUTOR_SERVICE", "()Ljava/util/concurrent/ExecutorService;", "DEFAULT_EXECUTOR_SERVICE$delegate", "Lkotlin/Lazy;", "LAZY_SUBSCRIBE_MSG", "", "TAG", "", "asyncPoster", "Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "getAsyncPoster", "()Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "asyncPoster$delegate", "backgroundPoster", "Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "getBackgroundPoster", "()Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "backgroundPoster$delegate", "eventBySubscriber", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mainHandlerPoster", "Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "getMainHandlerPoster", "()Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "mainHandlerPoster$delegate", "subscriptionsInfoByEventType", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getExecutorService", "getExecutorService$lib_bd_event_bus_release", "post", "", "event", "post$lib_bd_event_bus_release", "postSingleEvent", TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, "subscriptionInfo", "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "subscribe$lib_bd_event_bus_release", MiPushClient.COMMAND_UNREGISTER, "PostingThreadState", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BdEventBusCore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy DEFAULT_EXECUTOR_SERVICE$delegate;
    public final int LAZY_SUBSCRIBE_MSG;
    public final String TAG;
    public final Lazy asyncPoster$delegate;
    public final Lazy backgroundPoster$delegate;
    public ConcurrentHashMap<Object, CopyOnWriteArrayList<Object>> eventBySubscriber;
    public final Lazy mainHandlerPoster$delegate;
    public ConcurrentHashMap<Object, CopyOnWriteArrayList<SubscriptionInfo>> subscriptionsInfoByEventType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore$PostingThreadState;", "", "()V", "eventQueue", "", "getEventQueue", "()Ljava/util/List;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PostingThreadState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Object> eventQueue;

        public PostingThreadState() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.eventQueue = new ArrayList();
        }

        public final List<Object> getEventQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.eventQueue;
            }
            return (List) invokeV.objValue;
        }
    }

    public BdEventBusCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.LAZY_SUBSCRIBE_MSG = 1;
        this.TAG = "BdEventBusCore";
        this.subscriptionsInfoByEventType = new ConcurrentHashMap<>();
        this.eventBySubscriber = new ConcurrentHashMap<>();
        this.DEFAULT_EXECUTOR_SERVICE$delegate = LazyKt__LazyJVMKt.lazy(BdEventBusCore$DEFAULT_EXECUTOR_SERVICE$2.INSTANCE);
        this.mainHandlerPoster$delegate = LazyKt__LazyJVMKt.lazy(BdEventBusCore$mainHandlerPoster$2.INSTANCE);
        this.backgroundPoster$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BackgroundPoster>(this) { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$backgroundPoster$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdEventBusCore this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackgroundPoster invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new BackgroundPoster(this.this$0);
                }
                return (BackgroundPoster) invokeV.objValue;
            }
        });
        this.asyncPoster$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AsyncPoster>(this) { // from class: com.baidu.searchbox.bdeventbus.core.BdEventBusCore$asyncPoster$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdEventBusCore this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AsyncPoster invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new AsyncPoster(this.this$0);
                }
                return (AsyncPoster) invokeV.objValue;
            }
        });
    }

    private final AsyncPoster getAsyncPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return (AsyncPoster) this.asyncPoster$delegate.getValue();
        }
        return (AsyncPoster) invokeV.objValue;
    }

    private final BackgroundPoster getBackgroundPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return (BackgroundPoster) this.backgroundPoster$delegate.getValue();
        }
        return (BackgroundPoster) invokeV.objValue;
    }

    private final ExecutorService getDEFAULT_EXECUTOR_SERVICE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Object value = this.DEFAULT_EXECUTOR_SERVICE$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-DEFAULT_EXECUTOR_SERVICE>(...)");
            return (ExecutorService) value;
        }
        return (ExecutorService) invokeV.objValue;
    }

    private final MainHandlerPoster getMainHandlerPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (MainHandlerPoster) this.mainHandlerPoster$delegate.getValue();
        }
        return (MainHandlerPoster) invokeV.objValue;
    }

    public final ExecutorService getExecutorService$lib_bd_event_bus_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getDEFAULT_EXECUTOR_SERVICE();
        }
        return (ExecutorService) invokeV.objValue;
    }

    private final void postSingleEvent(Object obj) {
        CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, obj) == null) && (copyOnWriteArrayList = this.subscriptionsInfoByEventType.get(obj.getClass())) != null && !copyOnWriteArrayList.isEmpty()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, subscriptionInfo) == null) {
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
    }

    public final void post$lib_bd_event_bus_release(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            postSingleEvent(event);
        }
    }

    public final void subscribe$lib_bd_event_bus_release(Object subscriber, Class<?> eventType, int i, Action<Object> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, subscriber, eventType, i, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            subscribe(new SubscriptionInfo(subscriber, eventType, i, action));
        }
    }

    public final synchronized void unregister(Object subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
            synchronized (this) {
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
        }
    }
}
