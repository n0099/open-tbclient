package com.baidu.searchbox.common.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class SecurityUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SecurityUtils() {
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

    public static boolean checkActivityRefuseServiceAndFinish(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity != null && checkIntentRefuseService(activity.getIntent())) {
                try {
                    activity.finish();
                } catch (Exception unused) {
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkIntentRefuseService(Intent intent) {
        InterceptResult invokeL;
        Bundle extras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            if (intent != null && (extras = intent.getExtras()) != null) {
                try {
                    extras.isEmpty();
                    return false;
                } catch (Exception unused) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
