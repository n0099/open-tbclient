package com.baidu.android.imsdk.retrieve.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RetrieveUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long RETRIEVE_PAUID_ONLINE = 17592197488700L;
    public static final long RETRIEVE_PAUID_TEST = 17592186068166L;
    public transient /* synthetic */ FieldHolder $fh;

    public RetrieveUtil() {
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

    public static boolean isRetrievePaUid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, context, j2)) == null) {
            int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if ((readIntData != 1 && readIntData != 2 && readIntData != 3) || j2 != RETRIEVE_PAUID_TEST) {
                    return false;
                }
            } else if (j2 != RETRIEVE_PAUID_ONLINE) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }
}
