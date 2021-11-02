package com.baidu.down.common.intercepter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class InterceptResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RET_CANCEL = 3;
    public static final int RET_CONTINUE = 0;
    public static final int RET_ERROR = 2;
    public static final int RET_PAUSE = 1;
    public static final int RET_RETRY = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public String interceptMsg;
    public int retCode;

    public InterceptResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interceptMsg = null;
        this.retCode = 0;
        this.retCode = i2;
    }
}
