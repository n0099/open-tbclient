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
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000:\u00019B\u0007¢\u0006\u0004\b7\u00108J\u000f\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\tR\u001d\u0010\u001d\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0003R\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010'\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010+R(\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050.0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u00104R(\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0.0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00100¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "Ljava/util/concurrent/ExecutorService;", "getExecutorService$lib_bd_event_bus_release", "()Ljava/util/concurrent/ExecutorService;", "getExecutorService", "", "event", "", "post$lib_bd_event_bus_release", "(Ljava/lang/Object;)V", "post", "postSingleEvent", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "subscriptionInfo", TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, "(Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;)V", "subscriber", "Ljava/lang/Class;", "eventType", "", "threadMode", "Lcom/baidu/searchbox/bdeventbus/Action;", "action", "subscribe$lib_bd_event_bus_release", "(Ljava/lang/Object;Ljava/lang/Class;ILcom/baidu/searchbox/bdeventbus/Action;)V", MiPushClient.COMMAND_UNREGISTER, "DEFAULT_EXECUTOR_SERVICE$delegate", "Lkotlin/Lazy;", "getDEFAULT_EXECUTOR_SERVICE", "DEFAULT_EXECUTOR_SERVICE", "LAZY_SUBSCRIBE_MSG", "I", "", "TAG", "Ljava/lang/String;", "Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "asyncPoster$delegate", "getAsyncPoster", "()Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "asyncPoster", "Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "backgroundPoster$delegate", "getBackgroundPoster", "()Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "backgroundPoster", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "eventBySubscriber", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "mainHandlerPoster$delegate", "getMainHandlerPoster", "()Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "mainHandlerPoster", "subscriptionsInfoByEventType", "<init>", "()V", "PostingThreadState", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore$PostingThreadState;", "", "", "eventQueue", "Ljava/util/List;", "getEventQueue", "()Ljava/util/List;", "<init>", "()V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class PostingThreadState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Object> eventQueue;

        public PostingThreadState() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.eventQueue : (List) invokeV.objValue;
        }
    }

    public BdEventBusCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.backgroundPoster$delegate = LazyKt__LazyJVMKt.lazy(new BdEventBusCore$backgroundPoster$2(this));
        this.asyncPoster$delegate = LazyKt__LazyJVMKt.lazy(new BdEventBusCore$asyncPoster$2(this));
    }

    private final AsyncPoster getAsyncPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (AsyncPoster) this.asyncPoster$delegate.getValue() : (AsyncPoster) invokeV.objValue;
    }

    private final BackgroundPoster getBackgroundPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (BackgroundPoster) this.backgroundPoster$delegate.getValue() : (BackgroundPoster) invokeV.objValue;
    }

    private final ExecutorService getDEFAULT_EXECUTOR_SERVICE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (ExecutorService) this.DEFAULT_EXECUTOR_SERVICE$delegate.getValue() : (ExecutorService) invokeV.objValue;
    }

    private final MainHandlerPoster getMainHandlerPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? (MainHandlerPoster) this.mainHandlerPoster$delegate.getValue() : (MainHandlerPoster) invokeV.objValue;
    }

    private final void postSingleEvent(Object obj) {
        CopyOnWriteArrayList<SubscriptionInfo> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, obj) == null) || (copyOnWriteArrayList = this.subscriptionsInfoByEventType.get(obj.getClass())) == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<SubscriptionInfo> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            SubscriptionInfo subscription = it.next();
            int threadMode = subscription.getThreadMode();
            if (threadMode == 0) {
                subscription.getAction().call(obj);
            } else if (threadMode != 1) {
                if (threadMode != 2) {
                    if (threadMode == 3) {
                        AsyncPoster asyncPoster = getAsyncPoster();
                        Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                        asyncPoster.enqueue(obj, subscription);
                    } else if (threadMode == 4) {
                        MainHandlerPoster mainHandlerPoster = getMainHandlerPoster();
                        Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                        mainHandlerPoster.enqueue(obj, subscription);
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
                if (copyOnWriteArrayList3.contains(subscriptionInfo.getEventType())) {
                    return;
                }
                copyOnWriteArrayList3.add(subscriptionInfo.getEventType());
                return;
            }
            CopyOnWriteArrayList<Object> copyOnWriteArrayList4 = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList4.add(subscriptionInfo.getEventType());
            this.eventBySubscriber.put(subscriptionInfo.getSubscriber(), copyOnWriteArrayList4);
        }
    }

    public final ExecutorService getExecutorService$lib_bd_event_bus_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getDEFAULT_EXECUTOR_SERVICE() : (ExecutorService) invokeV.objValue;
    }

    public final void post$lib_bd_event_bus_release(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            postSingleEvent(event);
        }
    }

    public final void subscribe$lib_bd_event_bus_release(Object subscriber, Class<?> eventType, int i2, Action<Object> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, subscriber, eventType, i2, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            subscribe(new SubscriptionInfo(subscriber, eventType, i2, action));
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
