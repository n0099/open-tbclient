package com.baidu.bdtask.framework.redux;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sq;
import com.repackage.tq;
import com.repackage.uq;
import kotlin.Metadata;
import kotlin.Pair;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\u0004\b\u0001\u0010\u0003*\b\b\u0002\u0010\u0005*\u00020\u0004B?\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "Lcom/baidu/bdtask/framework/redux/StateType;", "State", "SelectedState", "Lcom/baidu/bdtask/framework/redux/Action;", "AT", "newState", "action", "", "newValues", "(Lcom/baidu/bdtask/framework/redux/StateType;Lcom/baidu/bdtask/framework/redux/Action;)V", "Lcom/baidu/bdtask/framework/redux/Subscription;", "originalSubscription", "Lcom/baidu/bdtask/framework/redux/Subscription;", "getOriginalSubscription", "()Lcom/baidu/bdtask/framework/redux/Subscription;", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "subscriber", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "getSubscriber", "()Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "transformedSubscription", "<init>", "(Lcom/baidu/bdtask/framework/redux/Subscription;Lcom/baidu/bdtask/framework/redux/Subscription;Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class f<State extends uq<State>, SelectedState, AT extends sq> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e<State, AT> a;
    public final tq<SelectedState> b;

    public f(e<State, AT> eVar, e<SelectedState, AT> eVar2, tq<SelectedState> tqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, eVar2, tqVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.b = tqVar;
        SubscriptionBox$forwardFromOriginalSubscription$1 subscriptionBox$forwardFromOriginalSubscription$1 = new SubscriptionBox$forwardFromOriginalSubscription$1(this);
        if (eVar2 != null) {
            eVar2.c(new SubscriptionBox$$special$$inlined$let$lambda$1(this));
        } else {
            subscriptionBox$forwardFromOriginalSubscription$1.invoke();
        }
    }

    public final e<State, AT> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (e) invokeV.objValue;
    }

    public final void b(State state, AT at) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, at) == null) {
            this.a.b(new Pair<>(state, at));
        }
    }

    public final tq<SelectedState> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (tq) invokeV.objValue;
    }
}
