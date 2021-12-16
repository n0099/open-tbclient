package com.baidu.fsg.base.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.fsg.base.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PermissionManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PERMISSION_REQUEST_CODE_BASE = 0;
    public static final int REQUEST_CODE_CALL_PHONE = 2;
    public static final int REQUEST_CODE_READ_CONTRACT = 3;
    public static final int REQUEST_CODE_READ_SMS = 1;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 4;
    public transient /* synthetic */ FieldHolder $fh;

    public PermissionManager() {
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

    @TargetApi(23)
    public static void checkCallingPermission(Activity activity, String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, activity, strArr, i2) == null) || activity == null || strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && activity.checkCallingPermission(str) == -1) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activity.requestPermissions(strArr, i2);
                } else {
                    activity.checkSelfPermission(str);
                }
            }
        }
    }

    public static boolean checkCallingPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0 : invokeLL.booleanValue;
    }
}
