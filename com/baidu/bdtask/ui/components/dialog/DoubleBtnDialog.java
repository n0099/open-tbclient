package com.baidu.bdtask.ui.components.dialog;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.tieba.R;
import com.baidu.tieba.bu;
import com.baidu.tieba.cu;
import com.baidu.tieba.hs;
import com.baidu.tieba.wq;
import com.baidu.tieba.xq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/bdtask/ui/components/dialog/DoubleBtnDialog;", "Lcom/baidu/bdtask/ui/components/dialog/a;", "", "getBtnLayout", "()I", "", "initExtraView", "()V", "<init>", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DoubleBtnDialog extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.bdtask.ui.components.dialog.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.sdk_activity_dialog_two_btn : invokeV.intValue;
    }

    public DoubleBtnDialog() {
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

    @Override // com.baidu.bdtask.ui.components.dialog.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.f();
            final TaskDialogViewData a = a();
            if (a != null) {
                TextView btn = (TextView) findViewById(R.id.dialog_positive_btn);
                ImageView btnImage = (ImageView) findViewById(R.id.dialog_positive_btn_image);
                Intrinsics.checkExpressionValueIsNotNull(btn, "btn");
                Intrinsics.checkExpressionValueIsNotNull(btnImage, "btnImage");
                b(btn, btnImage, a.getBackBtnTxt(), a.getBackBtnTxtColor(), a.getBackBtnBgUrl(), new Function0<Unit>(this, a) { // from class: com.baidu.bdtask.ui.components.dialog.DoubleBtnDialog$initExtraView$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ TaskDialogViewData $data;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DoubleBtnDialog this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a};
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
                        this.$data = a;
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
                        hs b;
                        cu d;
                        cu d2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            bu v = BDPTask.m.v();
                            if (v != null && (d2 = v.d()) != null) {
                                d2.b(this.$data.getTaskInfoSingleKey(), xq.c.a());
                            }
                            bu v2 = BDPTask.m.v();
                            if (v2 != null && (d = v2.d()) != null) {
                                d.a(this.$data.getTaskInfoSingleKey());
                            }
                            bu v3 = BDPTask.m.v();
                            if (v3 != null && (b = v3.b()) != null) {
                                b.a(this.$data.getBackBtnSchema(), 1);
                            }
                            this.this$0.h();
                            this.this$0.d();
                        }
                    }
                });
                TextView cancelBtn = (TextView) findViewById(R.id.dialog_negative_btn);
                ImageView cancelBtnImage = (ImageView) findViewById(R.id.dialog_negative_btn_image);
                Intrinsics.checkExpressionValueIsNotNull(cancelBtn, "cancelBtn");
                Intrinsics.checkExpressionValueIsNotNull(cancelBtnImage, "cancelBtnImage");
                b(cancelBtn, cancelBtnImage, a.getCancelBtnTxt(), a.getCancelBtnTxtColor(), a.getCancelBtnBgUrl(), new Function0<Unit>(this, a) { // from class: com.baidu.bdtask.ui.components.dialog.DoubleBtnDialog$initExtraView$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ TaskDialogViewData $data;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DoubleBtnDialog this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a};
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
                        this.$data = a;
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
                        bu v;
                        hs b;
                        cu d;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            bu v2 = BDPTask.m.v();
                            if (v2 != null && (d = v2.d()) != null) {
                                d.b(this.$data.getTaskInfoSingleKey(), wq.c.a());
                            }
                            if (!TextUtils.isEmpty(this.$data.getCancelBtnSchema()) && (v = BDPTask.m.v()) != null && (b = v.b()) != null) {
                                b.a(this.$data.getCancelBtnSchema(), 1);
                            }
                            this.this$0.i();
                            this.this$0.d();
                        }
                    }
                });
            }
        }
    }
}
