package com.baidu.searchbox.logsystem.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DebugUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SS";
    public static final String LOG_FILE = "loki.log";
    public transient /* synthetic */ FieldHolder $fh;

    public DebugUtil() {
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

    public static final synchronized void saveLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (DebugUtil.class) {
            }
        }
    }
}
