package c.a.l0.h;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.m.c;
import c.a.l0.m.k;
import com.baidu.android.common.util.DeviceId;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3636b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f3637c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f3638d = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                return !c.a.l0.b.a.f(context).d() ? "" : DeviceId.getCUID(context);
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
            } catch (Throwable th) {
                c.d(th);
            }
            if (f(context)) {
                return d(DeviceInfoManager.INSTANCE.getAndroidId(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
            }
            if (!c.a.l0.b.a.f(context).d()) {
                return f3638d;
            }
            if (!TextUtils.isEmpty(f3638d)) {
                return f3638d;
            }
            if (c.n(context)) {
                String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                f3638d = string;
                if (TextUtils.isEmpty(string)) {
                    f3638d = "";
                }
                return f3638d;
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getOAID(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                if (!c.a.l0.b.a.f(context).d()) {
                    return k.b(String.valueOf(-1000), z2);
                }
                if (z && !TextUtils.isEmpty(f3637c)) {
                    return f3637c;
                }
                if (!c.n(context)) {
                    return k.b(String.valueOf(-1002), z2);
                }
                String a2 = c.a.l0.n.a.b().a();
                if (TextUtils.isEmpty(a2)) {
                    return k.b(String.valueOf(-1003), z2);
                }
                f3637c = a2;
                return a2;
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(DeviceIdBag deviceIdBag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, deviceIdBag)) == null) {
            if (deviceIdBag == null) {
                return "";
            }
            if (deviceIdBag.errorCode == 3) {
                return String.valueOf(-1004);
            }
            return TextUtils.isEmpty(deviceIdBag.deviceId) ? "" : deviceIdBag.deviceId;
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getManufacturer(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                return Build.MANUFACTURER;
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!a) {
                if ("com.baidu.searchbox".equals(context.getPackageName())) {
                    f3636b = true;
                }
                a = true;
            }
            return f3636b;
        }
        return invokeL.booleanValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getModel(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                return Build.MODEL;
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getOperator(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str, true));
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
                return String.valueOf(-1003);
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
