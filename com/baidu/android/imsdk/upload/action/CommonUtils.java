package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonUtils() {
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

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("Utils", "getAppVersionName NameNotFoundException", e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static IMPushPb.Common getIMCommon(Context context, String str) {
        InterceptResult invokeLL;
        String appVersionName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            IMPushPb.DeviceID build = IMPushPb.DeviceID.newBuilder().setCuid(str).build();
            IMPushPb.AppInfo.Builder appName = IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName());
            if (TextUtils.isEmpty(getAppVersionName(context))) {
                appVersionName = "";
            } else {
                appVersionName = getAppVersionName(context);
            }
            return IMPushPb.Common.newBuilder().setDeviceId(build).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setAppInfo(appName.setAppVersion(appVersionName).setAppChannel("").build()).build();
        }
        return (IMPushPb.Common) invokeLL.objValue;
    }

    public static IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i3 = 0;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
                if (i > i3) {
                    i3 = i;
                    i = i3;
                }
                i2 = displayMetrics.densityDpi;
            } else {
                i = 0;
                i2 = 0;
            }
            return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setResolutionH(i3).setResolutionV(i).setPpi(i2).build();
        }
        return (IMPushPb.TerminalInfo) invokeL.objValue;
    }
}
