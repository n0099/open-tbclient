package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.sapi2.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class SapiDeviceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SapiDeviceUtils() {
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

    public static boolean checkHosts(Context context) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return invokeL.booleanValue;
        }
        if (context == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream("/system/etc/hosts");
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains("passport.baidu.com")) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            Log.e(Log.TAG, e2.toString());
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                    Log.e(Log.TAG, e3.toString());
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.e(Log.TAG, th.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            Log.e(Log.TAG, e4.toString());
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            Log.e(Log.TAG, e5.toString());
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static String getBrandName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (!isForbidDangerousPermissionApp(context) && Build.VERSION.SDK_INT < 29 && ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol() && PassPermissions.checkRequestPermission(s.f55242c, context)) {
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    return deviceId == null ? "" : deviceId;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isForbidDangerousPermissionApp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("com.baidu.(.*)input(.*)");
            String packageName = context.getPackageName();
            for (String str : arrayList) {
                if (packageName.matches(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
