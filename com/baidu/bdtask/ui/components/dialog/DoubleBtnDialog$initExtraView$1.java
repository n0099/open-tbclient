package com.baidu.bdtask.ui.components.dialog;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.au;
import com.repackage.fs;
import com.repackage.vq;
import com.repackage.zt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class DoubleBtnDialog$initExtraView$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ TaskDialogViewData $data;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DoubleBtnDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubleBtnDialog$initExtraView$1(DoubleBtnDialog doubleBtnDialog, TaskDialogViewData taskDialogViewData) {
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

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        fs b;
        au d;
        au d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zt v = BDPTask.m.v();
            if (v != null && (d2 = v.d()) != null) {
                d2.b(this.$data.getTaskInfoSingleKey(), vq.c.a());
            }
            zt v2 = BDPTask.m.v();
            if (v2 != null && (d = v2.d()) != null) {
                d.a(this.$data.getTaskInfoSingleKey());
            }
            zt v3 = BDPTask.m.v();
            if (v3 != null && (b = v3.b()) != null) {
                b.a(this.$data.getBackBtnSchema(), 1);
            }
            this.this$0.h();
            this.this$0.d();
        }
    }
}
