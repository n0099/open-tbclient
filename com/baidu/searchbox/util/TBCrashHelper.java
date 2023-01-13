package com.baidu.searchbox.util;

import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.cz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes3.dex */
public class TBCrashHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CRASH_UPLOAD_PER_DAY = 100;
    public static final String SP_KEY_CRASH_UPLOAD_COUNT = "SP_MAX_CRASH_UPLOAD_COUNT";
    public static final String SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP = "SP_LAST_CRASH_UPLOAD_TIMESTAMP";
    public transient /* synthetic */ FieldHolder $fh;

    public TBCrashHelper() {
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

    public static boolean checkIsUploadOverMax() {
        InterceptResult invokeV;
        int m;
        long n;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                m = cz4.l().m(SP_KEY_CRASH_UPLOAD_COUNT, 0);
                n = cz4.l().n(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, 0L);
                currentTimeMillis = System.currentTimeMillis();
                cz4.l().K(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, currentTimeMillis);
            } catch (Exception unused) {
            }
            if (TimeHelper.isSameDay(new Date(n), new Date(currentTimeMillis))) {
                int i = m + 1;
                cz4.l().J(SP_KEY_CRASH_UPLOAD_COUNT, i);
                if (i <= 100) {
                    return false;
                }
                return true;
            }
            cz4.l().J(SP_KEY_CRASH_UPLOAD_COUNT, 1);
            return false;
        }
        return invokeV.booleanValue;
    }
}
