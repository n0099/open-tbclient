package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bs {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "PackageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public bs() {
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

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    return false;
                }
                if (!str.equals(applicationInfo.packageName)) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (packageManager.queryIntentActivities(intent, 65536).size() <= 0) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
