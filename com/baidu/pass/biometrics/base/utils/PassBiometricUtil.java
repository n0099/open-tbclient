package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes2.dex */
public class PassBiometricUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";
    public static final String a = "PassBiometricUtil";
    public static final int b = 480;
    public static final int c = 480;
    public static final int d = 192;
    public static final int e = 480;
    public static final int f = 620;
    public static final int g = 250;
    public static final int h = 250;
    public static final int i = 728;
    public static final int j = 194;
    public static final int k = 750;
    public static final int l = 1335;
    public transient /* synthetic */ FieldHolder $fh;

    public PassBiometricUtil() {
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

    public static String getOSModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (!TextUtils.isEmpty(Build.MODEL)) {
                return Build.MODEL;
            }
            return "-1";
        }
        return (String) invokeV.objValue;
    }

    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (!TextUtils.isEmpty(Build.VERSION.RELEASE)) {
                return Build.VERSION.RELEASE;
            }
            return "-1";
        }
        return (String) invokeV.objValue;
    }

    public static String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            if (!TextUtils.isEmpty(uuid)) {
                return uuid.replace("-", "");
            }
            return uuid;
        }
        return (String) invokeV.objValue;
    }

    public static Rect a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iArr)) == null) {
            Point point = new Point();
            Point point2 = new Point();
            if (iArr.length > 2) {
                point.x = iArr[0];
                point.y = iArr[1];
                point2.x = iArr[0];
                point2.y = iArr[1];
            }
            for (int i2 = 0; i2 < iArr.length / 2; i2++) {
                int i3 = i2 << 1;
                float f2 = iArr[i3];
                float f3 = iArr[i3 + 1];
                if (f2 < point.x) {
                    point.x = (int) f2;
                }
                if (f3 < point.y) {
                    point.y = (int) f3;
                }
                if (f2 > point2.x) {
                    point2.x = (int) f2;
                }
                if (f3 > point2.y) {
                    point2.y = (int) f3;
                }
            }
            return new Rect(point.x, point.y, point2.x, point2.y);
        }
        return (Rect) invokeL.objValue;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 <= i3 && i5 <= i2) {
                return 1;
            }
            int round = Math.round(i4 / i3);
            int round2 = Math.round(i5 / i2);
            if (round < round2) {
                return round;
            }
            return round2;
        }
        return invokeLII.intValue;
    }

    public static boolean checkRequestPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if ((Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) == 0) || (Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isFaceInsideRound(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iArr, iArr2)) == null) {
            if (iArr2 == null || iArr2.length != 2) {
                return false;
            }
            Rect a2 = a(iArr);
            Rect faceInsideRoundRect = getFaceInsideRoundRect(iArr2);
            if (faceInsideRoundRect.bottom <= a2.bottom || faceInsideRoundRect.top >= a2.top) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isTooFarFromCamera(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect a2 = a(iArr);
                if (a2.right - a2.left < (iArr2[0] * 192) / k) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isTooNearFromCamera(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect a2 = a(iArr);
                if (a2.right - a2.left > (iArr2[0] * 480) / k) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String getAppName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Rect getFaceInsideRoundRect(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iArr)) == null) {
            if (iArr != null && iArr.length == 2) {
                int i2 = ((iArr[0] * 480) / k) / 2;
                int i3 = ((iArr[1] * f) / 1335) / 2;
                Point point = new Point();
                point.set(iArr[0] / 2, (iArr[1] * i) / 1335);
                int i4 = point.x;
                int i5 = point.y;
                return new Rect(i4 - i2, i5 - i3, i4 + i2, i5 + i3);
            }
            return new Rect(0, 0, 0, 0);
        }
        return (Rect) invokeL.objValue;
    }

    public static String getPackageSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo.signatures.length <= 0) {
                    return "";
                }
                return SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false);
            } catch (Throwable th) {
                Log.e(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getUA(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            return "pass_bio-p-android-p-" + str + "-p-" + getVersionCode(context) + "-p-" + getVersionName(context) + "-p-" + PassBiometricDefaultFactory.VERSION_NAME + "-p-" + getOSModel() + "-p-" + getOSVersion();
        }
        return (String) invokeLL.objValue;
    }
}
