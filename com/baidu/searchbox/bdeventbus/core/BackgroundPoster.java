package com.baidu.searchbox.bdeventbus.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b%\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "Ljava/lang/Runnable;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "", "event", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "subscriptionInfo", "", "enqueue", "(Ljava/lang/Object;Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;)V", "run", "()V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "getBdEventBusCore", "()Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "setBdEventBusCore", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "Ljava/util/concurrent/BlockingQueue;", "Lkotlin/Pair;", "blockingQueue", "Ljava/util/concurrent/BlockingQueue;", "getBlockingQueue", "()Ljava/util/concurrent/BlockingQueue;", "", "executorRunning", "Z", "getExecutorRunning", "()Z", "setExecutorRunning", "(Z)V", "<init>", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BackgroundPoster implements Runnable, Poster {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public BdEventBusCore bdEventBusCore;
    public final BlockingQueue<Pair<Object, SubscriptionInfo>> blockingQueue;
    public volatile boolean executorRunning;

    public BackgroundPoster(BdEventBusCore bdEventBusCore) {
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
        this.TAG = "BackgroundPoster";
        this.blockingQueue = new LinkedBlockingQueue();
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, event, subscriptionInfo) == null) {
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
    }

    public final BdEventBusCore getBdEventBusCore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bdEventBusCore : (BdEventBusCore) invokeV.objValue;
    }

    public final BlockingQueue<Pair<Object, SubscriptionInfo>> getBlockingQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.blockingQueue : (BlockingQueue) invokeV.objValue;
    }

    public final boolean getExecutorRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.executorRunning : invokeV.booleanValue;
    }

    public final String getTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.TAG : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        while (true) {
            try {
                Pair<Object, SubscriptionInfo> poll = this.blockingQueue.poll(1000L, TimeUnit.MILLISECONDS);
                if (poll == null) {
                    synchronized (this) {
                        poll = this.blockingQueue.poll();
                        if (poll == null) {
                            this.executorRunning = false;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                Intrinsics.checkNotNull(poll);
                Action<Object> action = poll.getSecond().getAction();
                Intrinsics.checkNotNull(poll);
                action.call(poll.getFirst());
            } catch (Exception unused) {
                return;
            } finally {
                this.executorRunning = false;
            }
        }
    }

    public final void setBdEventBusCore(BdEventBusCore bdEventBusCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdEventBusCore) == null) {
            Intrinsics.checkNotNullParameter(bdEventBusCore, "<set-?>");
            this.bdEventBusCore = bdEventBusCore;
        }
    }

    public final void setExecutorRunning(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.executorRunning = z;
        }
    }
}
