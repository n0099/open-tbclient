package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes5.dex */
public class PassBiometricUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";

    /* renamed from: a  reason: collision with root package name */
    public static final String f44018a = "PassBiometricUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f44019b = 480;

    /* renamed from: c  reason: collision with root package name */
    public static final int f44020c = 480;

    /* renamed from: d  reason: collision with root package name */
    public static final int f44021d = 192;

    /* renamed from: e  reason: collision with root package name */
    public static final int f44022e = 480;

    /* renamed from: f  reason: collision with root package name */
    public static final int f44023f = 620;

    /* renamed from: g  reason: collision with root package name */
    public static final int f44024g = 250;

    /* renamed from: h  reason: collision with root package name */
    public static final int f44025h = 250;

    /* renamed from: i  reason: collision with root package name */
    public static final int f44026i = 728;

    /* renamed from: j  reason: collision with root package name */
    public static final int f44027j = 194;
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
            if (i4 > i3 || i5 > i2) {
                int round = Math.round(i4 / i3);
                int round2 = Math.round(i5 / i2);
                return round < round2 ? round : round2;
            }
            return 1;
        }
        return invokeLII.intValue;
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) == 0) || (Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0) : invokeLL.booleanValue;
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

    public static Rect getFaceInsideRoundRect(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iArr)) == null) {
            if (iArr != null && iArr.length == 2) {
                int i2 = ((iArr[0] * 480) / 750) / 2;
                int i3 = ((iArr[1] * 620) / 1335) / 2;
                Point point = new Point();
                point.set(iArr[0] / 2, (iArr[1] * 728) / 1335);
                int i4 = point.x;
                int i5 = point.y;
                return new Rect(i4 - i2, i5 - i3, i4 + i2, i5 + i3);
            }
            return new Rect(0, 0, 0, 0);
        }
        return (Rect) invokeL.objValue;
    }

    public static String getOSModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "-1" : (String) invokeV.objValue;
    }

    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "-1" : (String) invokeV.objValue;
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
                return packageInfo.signatures.length > 0 ? SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false) : "";
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
            return "pass_bio-p-android-p-" + str + "-p-" + getVersionCode(context) + "-p-" + PassBiometricDefaultFactory.VERSION_NAME + "-p-" + getOSModel() + "-p-" + getOSVersion();
        }
        return (String) invokeLL.objValue;
    }

    public static String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
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

    public static boolean isFaceInsideRound(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, iArr, iArr2)) == null) {
            if (iArr2 == null || iArr2.length != 2) {
                return false;
            }
            Rect a2 = a(iArr);
            Rect faceInsideRoundRect = getFaceInsideRoundRect(iArr2);
            return faceInsideRoundRect.bottom > a2.bottom && faceInsideRoundRect.top < a2.top;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isTooFarFromCamera(int[] iArr, int[] iArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect a2 = a(iArr);
                if (a2.right - a2.left < (iArr2[0] * 192) / 750) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, iArr, iArr2)) == null) {
            if (iArr2 != null && iArr2.length == 2) {
                Rect a2 = a(iArr);
                if (a2.right - a2.left > (iArr2[0] * 480) / 750) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
