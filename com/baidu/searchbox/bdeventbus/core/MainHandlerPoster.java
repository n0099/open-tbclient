package com.baidu.searchbox.bdeventbus.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "Lcom/baidu/searchbox/bdeventbus/core/Poster;", "Landroid/os/Handler;", "", "event", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "subscriptionInfo", "", "enqueue", "(Ljava/lang/Object;Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;)V", "Landroid/os/Message;", "msg", "handleMessage", "(Landroid/os/Message;)V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "concurrentLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getConcurrentLinkedQueue", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "handlerActive", "Z", "", "maxMillisInsideHandleMessage", "I", "getMaxMillisInsideHandleMessage", "()I", "<init>", "()V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class MainHandlerPoster extends Handler implements Poster {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> concurrentLinkedQueue;
    public boolean handlerActive;
    public final int maxMillisInsideHandleMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainHandlerPoster() {
        super(Looper.getMainLooper());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "MainHandlerPoster";
        this.concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.maxMillisInsideHandleMessage = 10;
    }

    @Override // com.baidu.searchbox.bdeventbus.core.Poster
    public void enqueue(Object event, SubscriptionInfo subscriptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, event, subscriptionInfo) == null) {
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
    }

    public final ConcurrentLinkedQueue<Pair<Object, SubscriptionInfo>> getConcurrentLinkedQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.concurrentLinkedQueue : (ConcurrentLinkedQueue) invokeV.objValue;
    }

    public final int getMaxMillisInsideHandleMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.maxMillisInsideHandleMessage : invokeV.intValue;
    }

    public final String getTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.TAG : (String) invokeV.objValue;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                do {
                    Pair<Object, SubscriptionInfo> poll = this.concurrentLinkedQueue.poll();
                    if (poll == null) {
                        synchronized (this) {
                            poll = this.concurrentLinkedQueue.poll();
                            if (poll == null) {
                                this.handlerActive = false;
                                return;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    Intrinsics.checkNotNull(poll);
                    Action<Object> action = poll.getSecond().getAction();
                    Intrinsics.checkNotNull(poll);
                    action.call(poll.getFirst());
                } while (System.currentTimeMillis() - currentTimeMillis < this.maxMillisInsideHandleMessage);
                sendMessage(obtainMessage());
                this.handlerActive = true;
            } finally {
                this.handlerActive = false;
            }
        }
    }
}
