package c.a.p0.f.a.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import c.a.p0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import org.apache.commons.lang3.StringUtils;
@Singleton
@Service
@SuppressLint({"MissingPermission", "HardwareIds"})
/* loaded from: classes.dex */
public class a implements c.a.p0.f.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-456354968, "Lc/a/p0/f/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-456354968, "Lc/a/p0/f/a/a/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.p0.f.a.b.a
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID) : (String) invokeL.objValue;
    }

    @Override // c.a.p0.f.a.b.a
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // c.a.p0.f.a.b.a
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    String meid = telephonyManager == null ? "" : telephonyManager.getMeid();
                    return TextUtils.isEmpty(meid) ? "" : meid;
                } catch (Exception e2) {
                    d.o("DeviceInfoImpl", "getMeid: catch " + e2 + StringUtils.LF + Log.getStackTraceString(e2));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.f.a.b.a
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (TextUtils.isEmpty(deviceId)) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            deviceId = telephonyManager.getImei();
                        }
                        return TextUtils.isEmpty(deviceId) ? "" : deviceId;
                    }
                    return deviceId;
                }
            } catch (Exception e2) {
                d.o("DeviceInfoImpl", "getImei: catch " + e2 + StringUtils.LF + Log.getStackTraceString(e2));
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.f.a.b.a
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = a;
                return "";
            }
            Application c2 = c.a.p0.a.s0.a.c();
            if (ContextCompat.checkSelfPermission(c2, s.f53804c) != 0) {
                return "";
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) c2.getSystemService("phone");
                String deviceId = telephonyManager == null ? "" : telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
