package com.baidu.bdtask.ui.components.dialog;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/bdtask/ui/components/dialog/SingleBtnDialog;", "Lcom/baidu/bdtask/ui/components/dialog/a;", "", "getBtnLayout", "()I", "", "initExtraView", "()V", "<init>", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SingleBtnDialog extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SingleBtnDialog() {
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
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d072c : invokeV.intValue;
    }

    @Override // com.baidu.bdtask.ui.components.dialog.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            TaskDialogViewData a = a();
            if (a != null) {
                TextView btn = (TextView) findViewById(R.id.obfuscated_res_0x7f09079b);
                ImageView btnImage = (ImageView) findViewById(R.id.obfuscated_res_0x7f09079c);
                Intrinsics.checkExpressionValueIsNotNull(btn, "btn");
                Intrinsics.checkExpressionValueIsNotNull(btnImage, "btnImage");
                a(btn, btnImage, a.getBackBtnTxt(), a.getBackBtnTxtColor(), a.getBackBtnBgUrl(), new SingleBtnDialog$initExtraView$1(this, a));
            }
        }
    }
}
