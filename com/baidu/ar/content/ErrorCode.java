package com.baidu.ar.content;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_ERROR = 104;
    public static final int DOWNLOAD_ERROR = 102;
    public static final int HTTP_ERRCODE_VERSION_LOW = 1044;
    public static final int NO_ERROR = 0;
    public static final int PARSE_ERROR = 103;
    public static final int QUERY_ERROR = 101;
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorCode() {
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
