package com.baidu.bdtask.ui.components.buoy;

import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.vs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "onChanged"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskBuoyView$onViewModelBind$1<T> implements vs<TaskBuoyViewData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TaskBuoyView a;

    public TaskBuoyView$onViewModelBind$1(TaskBuoyView taskBuoyView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskBuoyView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = taskBuoyView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vs
    /* renamed from: a */
    public final void onChanged(final TaskBuoyViewData it) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, it) == null) && it != null) {
            DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "update enable:" + this.this$0.a.S();
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (!this.a.S()) {
                DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        boolean Q;
                        boolean z3;
                        boolean z4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("TaskBuoyView:isReady:");
                            Q = this.this$0.a.Q();
                            sb.append(Q);
                            sb.append(":isAttached:");
                            z3 = this.this$0.a.o;
                            sb.append(z3);
                            sb.append(":isDetached:");
                            z4 = this.this$0.a.p;
                            sb.append(z4);
                            return sb.toString();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                DebugTrace.a.c(new Function0<String>(it) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$1$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyViewData $it;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {it};
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
                        this.$it = it;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            JSONObject json = this.$it.getTaskStatus().toJson();
                            return "TaskBuoyView:message:" + this.$it + ".message status:" + json;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
            TaskStatus taskStatus = it.getTaskStatus();
            if (taskStatus.isRegistered()) {
                TaskBuoyView taskBuoyView = this.a;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                taskBuoyView.F(it, new Function0<Unit>(it, this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyViewData $it;
                    public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {it, this};
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
                        this.$it = it;
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
                        boolean z3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                            return;
                        }
                        z3 = this.this$0.a.n;
                        if (!z3) {
                            this.this$0.a.n = true;
                            this.this$0.a.c0(new Function0<Unit>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
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
                                    String J;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null && interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                                        return;
                                    }
                                    ProgressBar progressBar = this.this$0.this$0.a.h;
                                    if (progressBar != null) {
                                        progressBar.setVisibility(8);
                                    }
                                    this.this$0.this$0.a.c.setVisibility(0);
                                    TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 = this.this$0;
                                    TaskBuoyView taskBuoyView2 = taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3.this$0.a;
                                    J = taskBuoyView2.J(taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3.$it.getCurProcessRate(), this.this$0.$it.getMessage(), this.this$0.$it.getTotal());
                                    taskBuoyView2.Y(J);
                                }
                            });
                        }
                    }
                });
            } else if (!taskStatus.isRunning()) {
                if (taskStatus.isFinished()) {
                    z = this.a.n;
                    if (!z) {
                        this.a.c0(new Function0<Unit>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                                    return;
                                }
                                ProgressBar progressBar = this.this$0.a.h;
                                if (progressBar != null) {
                                    progressBar.setVisibility(8);
                                }
                                this.this$0.a.getContentView().setVisibility(0);
                            }
                        });
                        TaskBuoyView taskBuoyView2 = this.a;
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        taskBuoyView2.F(it, new Function0<Unit>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$7
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                                    this.this$0.a.n = true;
                                    TaskBuoyView.d0(this.this$0.a, null, 1, null);
                                }
                            }
                        });
                    }
                    this.a.c0(new Function0<Unit>(it, this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskBuoyViewData $it;
                        public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {it, this};
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
                            this.$it = it;
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
                            String J;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.a.S()) {
                                this.this$0.a.u = false;
                                this.this$0.a.getContentView().setVisibility(0);
                                ProgressBar progressBar = this.this$0.a.h;
                                if (progressBar != null) {
                                    progressBar.setVisibility(8);
                                }
                                this.this$0.a.Z(this.$it.getTxtColor());
                                TaskBuoyView taskBuoyView3 = this.this$0.a;
                                J = taskBuoyView3.J(this.$it.getCurProcessRate(), this.$it.getMessage(), this.$it.getTotal());
                                taskBuoyView3.Y(J);
                                TaskBuoyView.W(this.this$0.a, this.$it.getBgUrl(), null, 2, null);
                            }
                        }
                    });
                }
            } else {
                z2 = this.a.n;
                if (!z2) {
                    TaskBuoyView taskBuoyView3 = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    taskBuoyView3.F(it, new Function0<Unit>(this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                                this.this$0.a.n = true;
                                TaskBuoyView.d0(this.this$0.a, null, 1, null);
                            }
                        }
                    });
                }
                this.a.c0(new Function0<Unit>(it, this) { // from class: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyViewData $it;
                    public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {it, this};
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
                        this.$it = it;
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
                        boolean P;
                        boolean z3;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.this$0.a.S()) {
                            return;
                        }
                        if (Float.compare(this.$it.getCurProcessRate(), 0.0f) > 0) {
                            P = this.this$0.a.P(8);
                            if (!P) {
                                this.this$0.a.u = false;
                                this.this$0.a.getContentView().setVisibility(0);
                            }
                            z3 = this.this$0.a.u;
                            if (z3) {
                                this.this$0.a.getContentView().setVisibility(4);
                            } else {
                                this.this$0.a.getContentView().setVisibility(0);
                            }
                            ProgressBar progressBar = this.this$0.a.h;
                            if (progressBar != null) {
                                progressBar.setVisibility(0);
                            }
                            this.this$0.a.Z(this.$it.getTxtColor());
                            this.this$0.a.a0(this.$it.getPBackColor(), this.$it.getPForeColor());
                            this.this$0.a.b0(this.$it.getCurProcessRate(), this.$it.getTotal(), this.$it.getMessage());
                            return;
                        }
                        DebugTrace debugTrace = DebugTrace.a;
                        debugTrace.a("curProcessRate:" + this.$it.getCurProcessRate());
                    }
                });
            }
            this.a.E(taskStatus.getCurStatus());
        }
    }
}
