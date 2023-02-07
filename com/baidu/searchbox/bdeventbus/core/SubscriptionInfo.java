package com.baidu.searchbox.bdeventbus.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "", "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "(Ljava/lang/Object;Ljava/lang/Class;ILcom/baidu/searchbox/bdeventbus/Action;)V", "getAction", "()Lcom/baidu/searchbox/bdeventbus/Action;", "setAction", "(Lcom/baidu/searchbox/bdeventbus/Action;)V", "getEventType", "()Ljava/lang/Class;", "setEventType", "(Ljava/lang/Class;)V", "getSubscriber", "()Ljava/lang/Object;", "getThreadMode$annotations", "()V", "getThreadMode", "()I", "setThreadMode", "(I)V", "equals", "", ImageViewerConfig.FROM_OTHER, TTDownloadField.TT_HASHCODE, "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubscriptionInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Action<Object> action;
    public Class<?> eventType;
    public final Object subscriber;
    public int threadMode;

    public static /* synthetic */ void getThreadMode$annotations() {
    }

    public SubscriptionInfo(Object subscriber, Class<?> eventType, int i, Action<Object> action) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber, eventType, Integer.valueOf(i), action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.subscriber = subscriber;
        this.eventType = eventType;
        this.threadMode = i;
        this.action = action;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof SubscriptionInfo)) {
                return false;
            }
            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) obj;
            if (!Intrinsics.areEqual(this.subscriber, subscriptionInfo.subscriber) || !Intrinsics.areEqual(this.eventType.getClass(), subscriptionInfo.eventType.getClass())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final Action<Object> getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.action;
        }
        return (Action) invokeV.objValue;
    }

    public final Class<?> getEventType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.eventType;
        }
        return (Class) invokeV.objValue;
    }

    public final Object getSubscriber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.subscriber;
        }
        return invokeV.objValue;
    }

    public final int getThreadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.threadMode;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.subscriber.hashCode() + this.eventType.getClass().hashCode();
        }
        return invokeV.intValue;
    }

    public final void setAction(Action<Object> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "<set-?>");
            this.action = action;
        }
    }

    public final void setEventType(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cls) == null) {
            Intrinsics.checkNotNullParameter(cls, "<set-?>");
            this.eventType = cls;
        }
    }

    public final void setThreadMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.threadMode = i;
        }
    }
}
