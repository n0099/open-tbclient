package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(Utils.TAG, "getAppVersionName NameNotFoundException", e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static IMPushPb.Common getIMCommon(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return IMPushPb.Common.newBuilder().setDeviceId(IMPushPb.DeviceID.newBuilder().setCuid(str).build()).setTimestamp(-1L).setUserTimestamp(System.currentTimeMillis()).setTerminalInfo(getTerminalInfo(context)).setNetInfo(getNetInfo(context)).setAppInfo(IMPushPb.AppInfo.newBuilder().setAppName(context.getPackageName()).setAppVersion(TextUtils.isEmpty(getAppVersionName(context)) ? "" : getAppVersionName(context)).setAppChannel("").build()).build();
        }
        return (IMPushPb.Common) invokeLL.objValue;
    }

    public static IMPushPb.NetInfo getNetInfo(Context context) {
        InterceptResult invokeL;
        String str;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String str2 = "";
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                str = "";
            } else {
                String str3 = "" + activeNetworkInfo.getTypeName();
                str = "" + activeNetworkInfo.getExtraInfo();
                str2 = str3;
            }
            return IMPushPb.NetInfo.newBuilder().setNetType(str2).setNetApn(str).build();
        }
        return (IMPushPb.NetInfo) invokeL.objValue;
    }

    public static IMPushPb.TerminalInfo getTerminalInfo(Context context) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
            return IMPushPb.TerminalInfo.newBuilder().setOs(IMPushPb.OSType.ANDROID).setOsVersion(Build.VERSION.RELEASE).setManufacturer(Build.MANUFACTURER).setTerminalType(Build.MODEL).setResolutionH(i3).setResolutionV(i).setPpi(i2).build();
        }
        return (IMPushPb.TerminalInfo) invokeL.objValue;
    }
}
