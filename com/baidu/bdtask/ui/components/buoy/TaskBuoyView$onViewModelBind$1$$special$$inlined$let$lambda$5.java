package com.baidu.bdtask.ui.components.buoy;

import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TaskBuoyViewData $it;
    public final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5(TaskBuoyViewData taskBuoyViewData, TaskBuoyView$onViewModelBind$1 taskBuoyView$onViewModelBind$1) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskBuoyViewData, taskBuoyView$onViewModelBind$1};
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
        boolean P;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.this$0.a.S()) {
            return;
        }
        if (Float.compare(this.$it.getCurProcessRate(), 0.0f) > 0) {
            P = this.this$0.a.P(8);
            if (!P) {
                this.this$0.a.u = false;
                this.this$0.a.getContentView().setVisibility(0);
            }
            z = this.this$0.a.u;
            if (z) {
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
}
