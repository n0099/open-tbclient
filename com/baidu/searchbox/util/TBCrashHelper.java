package com.baidu.searchbox.util;

import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.p35;
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
        int n;
        long o;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                n = p35.m().n(SP_KEY_CRASH_UPLOAD_COUNT, 0);
                o = p35.m().o(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, 0L);
                currentTimeMillis = System.currentTimeMillis();
                p35.m().N(SP_KEY_LAST_CRASH_UPLOAD_TIMESTAMP, currentTimeMillis);
            } catch (Exception unused) {
            }
            if (TimeHelper.isSameDay(new Date(o), new Date(currentTimeMillis))) {
                int i = n + 1;
                p35.m().M(SP_KEY_CRASH_UPLOAD_COUNT, i);
                if (i <= 100) {
                    return false;
                }
                return true;
            }
            p35.m().M(SP_KEY_CRASH_UPLOAD_COUNT, 1);
            return false;
        }
        return invokeV.booleanValue;
    }
}
