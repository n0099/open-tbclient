package com.baidu.prologue.business.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ParseError extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_INVALID_DATA = 2;
    public static final int ERROR_INVALID_JSON_ROOT = 1;
    public static final int ERROR_OK = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int errorCode;
    public final String errorMessage;

    public ParseError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.errorCode = i2;
        this.errorMessage = str;
    }
}
