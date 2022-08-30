package com.baidu.bdtask;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.b;
import com.baidu.bdtask.framework.redux.e;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.kq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/baidu/bdtask/framework/redux/Subscription;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BDPTask$subscribeStore$3 extends Lambda implements Function1<e<b, kq>, e<SubTaskState, kq>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BDPTask this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "<anonymous parameter 0>", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "action", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.BDPTask$subscribeStore$3$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function2<b, kq, Pair<? extends SubTaskState, ? extends kq>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDPTask$subscribeStore$3 this$0;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.BDPTask$subscribeStore$3$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00621 extends Lambda implements Function0<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SubTaskState $subState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00621(SubTaskState subTaskState) {
                super(0);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {subTaskState};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$subState = subTaskState;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("subscribeStore:subState:");
                    SubTaskState subTaskState = this.$subState;
                    sb.append(subTaskState != null ? subTaskState.getTaskInfo() : null);
                    sb.append("\n ");
                    SubTaskState subTaskState2 = this.$subState;
                    sb.append(subTaskState2 != null ? subTaskState2.getTaskStatus() : null);
                    return sb.toString();
                }
                return (String) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BDPTask$subscribeStore$3 bDPTask$subscribeStore$3) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDPTask$subscribeStore$3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDPTask$subscribeStore$3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function2
        public final Pair<SubTaskState, kq> invoke(b bVar, kq kqVar) {
            InterceptResult invokeLL;
            b O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, kqVar)) == null) {
                if (kqVar != null) {
                    O = this.this$0.this$0.O();
                    SubTaskState k = O.k(kqVar.f());
                    DebugTrace.a.c(new C00621(k));
                    return new Pair<>(k, kqVar);
                }
                return new Pair<>(null, kqVar);
            }
            return (Pair) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDPTask$subscribeStore$3(BDPTask bDPTask) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDPTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = bDPTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.bdtask.framework.redux.e<Substate, com.baidu.tieba.kq>, com.baidu.bdtask.framework.redux.e<com.baidu.bdtask.ctrl.SubTaskState, com.baidu.tieba.kq> */
    @Override // kotlin.jvm.functions.Function1
    public final e<SubTaskState, kq> invoke(e<b, kq> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? eVar.a(new AnonymousClass1(this)) : (e) invokeL.objValue;
    }
}
