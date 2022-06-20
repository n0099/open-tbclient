package com.baidu.searchbox.bsdiff;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PATCH_FAIL = 1;
    public static final int PATCH_FAIL_MD5 = 2;
    public static final int PATCH_FAIL_SOURCE = 3;
    public static final int PATCH_FAIL_UNKNOWN = -1;
    public static final int PATCH_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public Constants() {
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
}
