package com.baidu.searchbox.retrieve.inter.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ValueConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSSINESS_EXPIRED = "1";
    public static final String DATA_KEY_MISS = "1";
    public static final String DATA_NULL = "0";
    public static final String FETCH_DONE = "0";
    public static final String FETCH_NO_FILE = "1";
    public static final String FETCH_UPLOAD_FAIL = "2";
    public static final String NO_TYPE = "2";
    public static final String SUCCESS = "0";
    public static final String VALUE_BUS_DONE = "4";
    public static final String VALUE_BUS_PARAMES_ERROR = "2";
    public static final String VALUE_BUS_START = "3";
    public static final String VALUE_DISPATCH_SUCCESS = "1";
    public static final String VALUE_SERVER_PARAMES_ERROR = "-1";
    public transient /* synthetic */ FieldHolder $fh;

    public ValueConstants() {
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
