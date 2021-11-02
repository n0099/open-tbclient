package com.baidu.pass.permissions;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PermissionsDTO implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cancleBtnTxt;
    public Context context;
    public String dialogMsg;
    public String dialogTitle;
    public boolean isDarkMode;
    public String okBtnTxt;
    public String[] permissions;
    public boolean showExplainDialogAfterForbid;

    public PermissionsDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.okBtnTxt = "继续";
        this.cancleBtnTxt = "关闭";
        this.showExplainDialogAfterForbid = true;
    }
}
