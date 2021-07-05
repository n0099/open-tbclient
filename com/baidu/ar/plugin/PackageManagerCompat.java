package com.baidu.ar.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PackageManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    public static final int DELETE_SUCCEEDED = 1;
    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    public static final int INSTALL_FAILED_INVALID_APK = -2;
    public static final int INSTALL_FAILED_NOT_SUPPORT_ABI = -3;
    public static final int INSTALL_REPLACE_EXISTING = 2;
    public static final int INSTALL_SUCCEEDED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public PackageManagerCompat() {
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
}
