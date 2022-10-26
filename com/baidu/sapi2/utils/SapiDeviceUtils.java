package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.sapi2.ServiceManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SapiDeviceUtils {
    public static /* synthetic */ Interceptable $ic;
    public static String mImei;
    public transient /* synthetic */ FieldHolder $fh;

    public SapiDeviceUtils() {
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

    public static String getBrandName() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (TextUtils.isEmpty(Build.BRAND)) {
                    str = "";
                } else {
                    str = Build.BRAND;
                }
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean checkHosts(Context context) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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
                            } catch (Exception e) {
                                Log.e(Log.TAG, e.toString());
                            }
                            return true;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        Log.e(Log.TAG, e2.toString());
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.e(Log.TAG, th.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                Log.e(Log.TAG, e3.toString());
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                Log.e(Log.TAG, e4.toString());
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (isForbidDangerousPermissionApp(context) || Build.VERSION.SDK_INT >= 29 || !ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
                    return "";
                }
                if (!TextUtils.isEmpty(mImei)) {
                    return mImei;
                }
                if (!PassPermissions.checkRequestPermission(h.c, context)) {
                    return "";
                }
                String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
                mImei = deviceId;
                if (deviceId == null) {
                    mImei = "";
                }
                return mImei;
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
