package com.baidu.bdtask.ui.components.buoy;

import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TaskBuoyViewData $it;
    public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ui.components.buoy.TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String J;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ProgressBar progressBar = this.this$0.this$0.a.f31633h;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.this$0.this$0.a.f31628c.setVisibility(0);
                TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3 = this.this$0;
                TaskBuoyView taskBuoyView = taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3.this$0.a;
                J = taskBuoyView.J(taskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3.$it.getCurProcessRate(), this.this$0.$it.getMessage(), this.this$0.$it.getTotal());
                taskBuoyView.Y(J);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3(TaskBuoyViewData taskBuoyViewData, TaskBuoyView$onViewModelBind$1 taskBuoyView$onViewModelBind$1) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskBuoyViewData, taskBuoyView$onViewModelBind$1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$it = taskBuoyViewData;
        this.this$0 = taskBuoyView$onViewModelBind$1;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            z = this.this$0.a.n;
            if (z) {
                return;
            }
            this.this$0.a.n = true;
            this.this$0.a.c0(new AnonymousClass1(this));
        }
    }
}
