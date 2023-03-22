package com.baidu.bdtask.framework.redux;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.uq;
import com.baidu.tieba.vq;
import com.baidu.tieba.wq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003B¿\u0002\u0012B\u0010'\u001a>\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(%\u0012\u0004\u0012\u00028\u00000$j\b\u0012\u0004\u0012\u00028\u0000`&\u0012\u0006\u0010%\u001a\u00028\u0000\u0012é\u0001\b\u0002\u00106\u001aâ\u0001\u0012Ý\u0001\u0012Ú\u0001\u0012A\u0012?\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0010j\u0011`\u001d¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00018\u000004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b()\u0012l\u0012j\u0012A\u0012?\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0010j\u0011`\u001d¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t\u0012#\u0012!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u001d0\u00100$j\b\u0012\u0004\u0012\u00028\u0000`503¢\u0006\u0004\b7\u00108J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0001H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ[\u0010\u0013\u001a\u00020\u0006\"\u0004\b\u0002\u0010\f\"\u000e\b\u0003\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00032,\u0010\u0012\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R@\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00158\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRA\u0010\u001e\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RR\u0010'\u001a>\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(%\u0012\u0004\u0012\u00028\u00000$j\b\u0012\u0004\u0012\u00028\u0000`&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010%\u001a\u00028\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R6\u0010-\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00028\u0001\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00069"}, d2 = {"Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/framework/redux/StateType;", "State", "Lcom/baidu/bdtask/framework/redux/Action;", "AT", "action", "", "_defaultDispatch", "(Lcom/baidu/bdtask/framework/redux/Action;)V", StatConstants.VALUE_TYPE_DISPATCH, "releaseSubscribe", "()V", "SelectedState", "Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;", ExifInterface.LATITUDE_SOUTH, "subscriber", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Subscription;", "transform", "setSubscribe", "(Lcom/baidu/bdtask/framework/redux/IStoreSubscriber;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Pair;", "value", "_state", "Lkotlin/Pair;", "set_state", "(Lkotlin/Pair;)V", "Lkotlin/ParameterName;", "name", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatchFunction", "Lkotlin/Function1;", "getDispatchFunction", "()Lkotlin/jvm/functions/Function1;", "setDispatchFunction", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "state", "Lcom/baidu/bdtask/framework/redux/Reducer;", "reducer", "Lkotlin/Function2;", "getState", "()Lcom/baidu/bdtask/framework/redux/StateType;", "Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "", IMConstants.SERVICE_TYPE_SUBSCRIPTION, "Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "getSubscription", "()Lcom/baidu/bdtask/framework/redux/SubscriptionBox;", "setSubscription", "(Lcom/baidu/bdtask/framework/redux/SubscriptionBox;)V", "", "Lkotlin/Function0;", "Lcom/baidu/bdtask/framework/redux/Middleware;", "middleware", "<init>", "(Lkotlin/jvm/functions/Function2;Lcom/baidu/bdtask/framework/redux/StateType;Ljava/util/List;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class d<State extends wq<State>, AT extends uq> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<State, Object, AT> a;
    public Pair<? extends State, ? extends AT> b;
    public Function1<? super uq, Unit> c;
    public final Function2<uq, State, State> d;

    public d(Function2<? super uq, ? super State, ? extends State> function2, State state, List<? extends Function2<? super Function1<? super uq, Unit>, ? super Function0<? extends State>, ? extends Function1<? super Function1<? super uq, Unit>, ? extends Function1<? super uq, Unit>>>> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {function2, state, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = function2;
        this.b = new Pair<>(state, null);
        e(new Pair<>(state, null));
        List<Function2> reversed = CollectionsKt___CollectionsKt.reversed(list);
        Function1<uq, Unit> function1 = new Function1<uq, Unit>(this) { // from class: com.baidu.bdtask.framework.redux.Store$dispatchFunction$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d this$0;

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

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(uq uqVar) {
                invoke2(uqVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(uq uqVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uqVar) == null) {
                    this.this$0.g(uqVar);
                }
            }
        };
        for (Function2 function22 : reversed) {
            function1 = (Function1) ((Function1) function22.invoke(new Function1<uq, Unit>(this) { // from class: com.baidu.bdtask.framework.redux.Store$$special$$inlined$fold$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d this$0;

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

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(uq uqVar) {
                    invoke2(uqVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(uq uqVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uqVar) == null) {
                        this.this$0.b(uqVar);
                    }
                }
            }, new Function0<State>(this) { // from class: com.baidu.bdtask.framework.redux.Store$$special$$inlined$fold$lambda$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Incorrect return type in method signature: ()TState; */
                @Override // kotlin.jvm.functions.Function0
                public final wq invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.this$0.a();
                    }
                    return (wq) invokeV.objValue;
                }
            })).invoke(function1);
        }
        this.c = function1;
    }

    public <SelectedState, S extends vq<SelectedState>> void c(S s, Function1<? super e<State, AT>, e<SelectedState, AT>> function1) {
        e<SelectedState, AT> eVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s, function1) != null) || this.a != null) {
            return;
        }
        e eVar2 = new e();
        if (function1 != null) {
            eVar = function1.invoke(eVar2);
        } else {
            eVar = null;
        }
        this.a = new f<>(eVar2, eVar, s);
    }

    public State a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.getFirst();
        }
        return (State) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.baidu.tieba.uq, kotlin.Unit>, kotlin.jvm.functions.Function1<com.baidu.tieba.uq, kotlin.Unit> */
    public Function1<uq, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (Function1) invokeV.objValue;
    }

    public synchronized void b(uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uqVar) == null) {
            synchronized (this) {
                DebugTrace debugTrace = DebugTrace.a;
                DebugTrace.d(debugTrace, "dispatch：" + uqVar.e(), "state", null, 4, null);
                f().invoke(uqVar);
            }
        }
    }

    public final void e(Pair<? extends State, ? extends AT> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pair) == null) {
            this.b = pair;
            f<State, Object, AT> fVar = this.a;
            if (fVar != null) {
                fVar.b(pair.getFirst(), pair.getSecond());
            }
        }
    }

    public final synchronized void g(AT at) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, at) == null) {
            synchronized (this) {
                e(new Pair<>(this.d.invoke(at, a()), at));
            }
        }
    }
}
