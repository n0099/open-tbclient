package com.baidu.bdtask.ui.components.dialog;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.tieba.kr;
import com.baidu.tieba.pu;
import com.baidu.tieba.qu;
import com.baidu.tieba.vs;
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
public final class DoubleBtnDialog$initExtraView$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ TaskDialogViewData $data;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DoubleBtnDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubleBtnDialog$initExtraView$2(DoubleBtnDialog doubleBtnDialog, TaskDialogViewData taskDialogViewData) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {doubleBtnDialog, taskDialogViewData};
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
        this.this$0 = doubleBtnDialog;
        this.$data = taskDialogViewData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        pu v;
        vs b;
        qu d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            pu v2 = BDPTask.m.v();
            if (v2 != null && (d = v2.d()) != null) {
                d.b(this.$data.getTaskInfoSingleKey(), kr.c.a());
            }
            if (!TextUtils.isEmpty(this.$data.getCancelBtnSchema()) && (v = BDPTask.m.v()) != null && (b = v.b()) != null) {
                b.a(this.$data.getCancelBtnSchema(), 1);
            }
            this.this$0.i();
            this.this$0.d();
        }
    }
}
