package com.baidu.down.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class FailType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_TYPE_302_HIJACK = 6;
    public static final int FAIL_TYPE_INTERCEPT = 4;
    public static final int FAIL_TYPE_INVALID_URI = 5;
    public static final int FAIL_TYPE_NETWORK = 0;
    public static final int FAIL_TYPE_NOT_SUPPORT_RANGE = 1;
    public static final int FAIL_TYPE_NO_PERMISSION = 3;
    public static final int FAIL_TYPE_SHORT_STORAGE = 2;
    public static final int FAIL_TYPE_UNKOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public FailType() {
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
