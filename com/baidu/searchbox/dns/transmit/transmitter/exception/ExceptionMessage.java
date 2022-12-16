package com.baidu.searchbox.dns.transmit.transmitter.exception;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ExceptionMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANCEL = "request canceled";
    public static final int CANCEL_ERROR = 10002;
    public static final int SERVER_ERROR = 10001;
    public static final String URL_EMPTY = "url is empty";
    public static final String WRITE_CONTENT_FAIL = "write content fail";
    public transient /* synthetic */ FieldHolder $fh;

    public ExceptionMessage() {
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
