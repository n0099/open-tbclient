package com.baidu.pass.permissions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class PermissionsCallback implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CANCLE = -2;
    public static final int ERROR_FORBID_FOREVER = -3;
    public static final int ERROR_NO_PERMISSION = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public PermissionsCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void onFailure(int i2);

    public abstract void onSuccess();
}
