package com.baidu.android.imsdk.db;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DBResponseCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CREATE_TABLE = -7009;
    public static final int ERROR_DB_OPEN = -70003;
    public static final int ERROR_EXECUTION_EXCEPTION = -7007;
    public static final int ERROR_GROUP_NOT_EXIST = -7008;
    public static final int ERROR_INSERT = -7002;
    public static final int ERROR_INTERRUPTED = -7006;
    public static final int ERROR_PARAMETER = -7001;
    public static final int ERROR_SQLEXCEPTION = -7004;
    public static final int ERROR_SQLITECONSTRAINT_EXCEPTION = -7200;
    public static final int ERROR_TIMEOUT = -7005;
    public static final int ERROR_UNKNOWN = -7100;
    public static final int SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public DBResponseCode() {
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
