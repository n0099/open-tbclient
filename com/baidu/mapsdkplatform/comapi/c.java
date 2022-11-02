package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-52719266, "Lcom/baidu/mapsdkplatform/comapi/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-52719266, "Lcom/baidu/mapsdkplatform/comapi/c;");
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            if (context != null) {
                if (context instanceof Application) {
                    b = z;
                    PermissionCheck.setPrivacyMode(z);
                    LBSAuthManager.getInstance(context).setPrivacyMode(z);
                    return;
                }
                throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
            }
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
    }

    public static void a(Context context, boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3}) != null) || a) {
            return;
        }
        if (context != null) {
            if (context instanceof Application) {
                NativeLoader.setContext(context);
                NativeLoader.a(z, str);
                JNIInitializer.setContext((Application) context);
                SysOSUtil.getInstance().init(new com.baidu.platform.comapi.util.a.b(), new com.baidu.platform.comapi.util.a.a());
                a.a().a(context);
                a.a().c();
                if (a(str2)) {
                    EnvironmentUtilities.setSDCardPath(str2);
                }
                EnvironmentUtilities.initAppDirectory(context);
                if (OpenLogUtil.isNativeLogAnalysisEnable()) {
                    com.baidu.mapsdkplatform.comapi.b.a.c.a().a(context);
                }
                a = true;
                return;
            }
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        throw new IllegalArgumentException("BDMapSDKException: context can not be null");
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                try {
                    File file = new File(str + "/check.0");
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    if (file.exists()) {
                        file.delete();
                        return true;
                    }
                    return true;
                } catch (IOException e) {
                    Log.e("SDKInitializer", "SDCard cache path invalid", e);
                    throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
