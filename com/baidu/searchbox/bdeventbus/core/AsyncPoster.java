package com.baidu.searchbox.bdeventbus.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "Ljava/lang/Runnable;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "", "event", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "subscriptionInfo", "", "enqueue", "(Ljava/lang/Object;Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;)V", "run", "()V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "getBdEventBusCore", "()Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "setBdEventBusCore", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "concurrentLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getConcurrentLinkedQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "<init>", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class AsyncPoster implements Runnable, Poster {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public BdEventBusCore bdEventBusCore;
    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> concurrentLinkedQueue;

    public AsyncPoster(BdEventBusCore bdEventBusCore) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdEventBusCore};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bdEventBusCore, "bdEventBusCore");
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "AsyncPoster";
        this.concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, event, subscriptionInfo) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(subscriptionInfo, "subscriptionInfo");
            synchronized (this) {
                this.concurrentLinkedQueue.offer(new Pair<>(event, subscriptionInfo));
                this.bdEventBusCore.getExecutorService$lib_bd_event_bus_release().execute(this);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final BdEventBusCore getBdEventBusCore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bdEventBusCore : (BdEventBusCore) invokeV.objValue;
    }

    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> getConcurrentLinkedQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.concurrentLinkedQueue : (ConcurrentLinkedQueue) invokeV.objValue;
    }

    public final String getTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.TAG : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair<Object, SubscriptionInfo> poll;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (poll = this.concurrentLinkedQueue.poll()) == null) {
            return;
        }
        poll.getSecond().getAction().call(poll.getFirst());
    }

    public final void setBdEventBusCore(BdEventBusCore bdEventBusCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdEventBusCore) == null) {
            Intrinsics.checkNotNullParameter(bdEventBusCore, "<set-?>");
            this.bdEventBusCore = bdEventBusCore;
        }
    }
}
