package com.baidu.bdtask.framework.redux;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.zl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001aB7\b\u0012\u0012,\u0010\u001b\u001a(\u0012\u001e\u0012\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006\u0012\u0004\u0012\u00020\u000b0\u000e\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0019\u0010\u0018JK\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010\u00042(\u0010\u0007\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00060\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00020\u000b2 \u0010\u000f\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006\u0012\u0004\u0012\u00020\u000b0\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010\u00042(\u0010\u0007\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00060\u0005¢\u0006\u0004\b\u0013\u0010\tR>\u0010\u000f\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/baidu/bdtask/framework/redux/Subscription;", "State", "Lcom/baidu/bdtask/framework/redux/Action;", "AT", "Substate", "Lkotlin/Function2;", "Lkotlin/Pair;", "selector", "_select", "(Lkotlin/Function2;)Lcom/baidu/bdtask/framework/redux/Subscription;", GameAssistConstKt.KEY_DISK_NEW_STATE, "", "newValues", "(Lkotlin/Pair;)V", "Lkotlin/Function1;", "observer", "observe$lib_bdtask_business_build_release", "(Lkotlin/Function1;)V", "observe", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlin/Function1;", "getObserver", "()Lkotlin/jvm/functions/Function1;", "setObserver", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "sink", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class e<State, AT extends zl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function1<? super Pair<? extends State, ? extends AT>, Unit> a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public e(Function1<? super Function1<? super Pair<? extends State, ? extends AT>, Unit>, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {function1};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        function1.invoke(new Function1<Pair<? extends State, ? extends AT>, Unit>(this) { // from class: com.baidu.bdtask.framework.redux.Subscription$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e this$0;

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

            public final void invoke(Pair<? extends State, ? extends AT> pair) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) {
                    this.this$0.b(pair);
                }
            }
        });
    }

    public final <Substate> e<Substate, AT> a(Function2<? super State, ? super AT, ? extends Pair<? extends Substate, ? extends AT>> function2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, function2)) == null) {
            return d(function2);
        }
        return (e) invokeL.objValue;
    }

    public final void b(Pair<? extends State, ? extends AT> pair) {
        Function1<? super Pair<? extends State, ? extends AT>, Unit> function1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && (function1 = this.a) != null) {
            function1.invoke(pair);
        }
    }

    public final void c(Function1<? super Pair<? extends State, ? extends AT>, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, function1) == null) {
            this.a = function1;
        }
    }

    public final <Substate> e<Substate, AT> d(final Function2<? super State, ? super AT, ? extends Pair<? extends Substate, ? extends AT>> function2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, function2)) == null) {
            return new e<>(new Function1<Function1<? super Pair<? extends Substate, ? extends AT>, ? extends Unit>, Unit>(this, function2) { // from class: com.baidu.bdtask.framework.redux.Subscription$_select$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function2 $selector;
                public final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, function2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$selector = function2;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke((Function1) ((Function1) obj));
                    return Unit.INSTANCE;
                }

                public final void invoke(Function1<? super Pair<? extends Substate, ? extends AT>, Unit> function1) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1) == null) {
                        this.this$0.c(new Function1<Pair<? extends State, ? extends AT>, Unit>(this, function1) { // from class: com.baidu.bdtask.framework.redux.Subscription$_select$1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Function1 $sink;
                            public final /* synthetic */ Subscription$_select$1 this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, function1};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.$sink = function1;
                            }

                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Pair) ((Pair) obj));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Pair<? extends State, ? extends AT> pair) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) {
                                    this.$sink.invoke(this.this$0.$selector.invoke(pair.getFirst(), pair.getSecond()));
                                }
                            }
                        });
                    }
                }
            });
        }
        return (e) invokeL.objValue;
    }
}
