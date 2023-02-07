package com.baidu.nadcore.webpanel.proxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.webview.container.NadBrowserContainer;
import com.baidu.tieba.l81;
import com.baidu.tieba.t71;
import com.baidu.tieba.u91;
import com.baidu.tieba.x81;
import com.baidu.tieba.y81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WebPanelBrowserContainer extends NadBrowserContainer implements t71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebPanelBrowserContainer(@NonNull x81 x81Var, @NonNull y81 y81Var, @Nullable u91 u91Var) {
        super(x81Var, y81Var, u91Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x81Var, y81Var, u91Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((x81) objArr2[0], (y81) objArr2[1], (u91) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.NadBrowserContainer, com.baidu.tieba.t71
    public void n(@NonNull l81 l81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l81Var) == null) {
            super.n(l81Var);
        }
    }
}
