package com.baidu.bdtask.framework.redux;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.as;
import com.baidu.tieba.bs;
import com.baidu.tieba.zr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\u0004\b\u0001\u0010\u0003*\b\b\u0002\u0010\u0005*\u00020\u0004B?\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "Lcom/baidu/bdtask/framework/redux/StateType;", "State", "SelectedState", "Lcom/baidu/bdtask/framework/redux/Action;", "AT", GameAssistConstKt.KEY_DISK_NEW_STATE, "action", "", "newValues", "(Lcom/baidu/bdtask/framework/redux/StateType;Lcom/baidu/bdtask/framework/redux/Action;)V", "Lcom/baidu/bdtask/framework/redux/Subscription;", "originalSubscription", "Lcom/baidu/bdtask/framework/redux/Subscription;", "getOriginalSubscription", "()Lcom/baidu/bdtask/framework/redux/Subscription;", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "subscriber", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "getSubscriber", "()Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", "transformedSubscription", "<init>", "(Lcom/baidu/bdtask/framework/redux/Subscription;Lcom/baidu/bdtask/framework/redux/Subscription;Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class f<State extends bs<State>, SelectedState, AT extends zr> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e<State, AT> a;
    public final as<SelectedState> b;

    public f(e<State, AT> eVar, e<SelectedState, AT> eVar2, as<SelectedState> asVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, eVar2, asVar};
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
        this.b = asVar;
        Function0<Unit> function0 = new Function0<Unit>(this) { // from class: com.baidu.bdtask.framework.redux.SubscriptionBox$forwardFromOriginalSubscription$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.a().c(new Function1<Pair<? extends State, ? extends AT>, Unit>(this) { // from class: com.baidu.bdtask.framework.redux.SubscriptionBox$forwardFromOriginalSubscription$1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SubscriptionBox$forwardFromOriginalSubscription$1 this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext2.callArgs[0]).intValue());
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke((Pair) ((Pair) obj));
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Pair<? extends State, ? extends AT> pair) {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                                this.this$0.this$0.c().a(pair.getFirst());
                            }
                        }
                    });
                }
            }
        };
        if (eVar2 != null) {
            eVar2.c(new Function1<Pair<? extends SelectedState, ? extends AT>, Unit>(this) { // from class: com.baidu.bdtask.framework.redux.SubscriptionBox$$special$$inlined$let$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
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

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((Pair) ((Pair) obj));
                    return Unit.INSTANCE;
                }

                public final void invoke(Pair<? extends SelectedState, ? extends AT> pair) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) {
                        this.this$0.c().a(pair.getFirst());
                    }
                }
            });
        } else {
            function0.invoke();
        }
    }

    public final e<State, AT> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (e) invokeV.objValue;
    }

    public final as<SelectedState> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (as) invokeV.objValue;
    }

    public final void b(State state, AT at) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, at) == null) {
            this.a.b(new Pair<>(state, at));
        }
    }
}
