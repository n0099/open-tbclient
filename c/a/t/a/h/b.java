package c.a.t.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t.a.a.e;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.down.utils.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Long.valueOf(j2), str, str2}) == null) {
            try {
                e.c cVar = new e.c(context);
                cVar.e(str);
                cVar.f("1");
                cVar.c(j2);
                cVar.d(str2);
                cVar.a(501112L);
                cVar.b();
            } catch (Exception e2) {
                e.c("LCPCommon", "businessEvent exception ", e2);
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e.c("LCPCommon", "getAppVersionName NameNotFoundException", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object c(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            String b2 = TextUtils.isEmpty(b(context)) ? "" : b(context);
            long currentTimeMillis = System.currentTimeMillis();
            String b3 = f.b(context);
            String e2 = f.e(context);
            try {
                if (z) {
                    if (!TextUtils.isEmpty(b3) && !TextUtils.isEmpty(e2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, valueOf);
                        jSONObject.put("cuid", e2);
                        jSONObject.put("device_type", "android");
                        jSONObject.put(HttpConstants.OS_VERSION, str);
                        jSONObject.put("manufacture", str2);
                        jSONObject.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, str3);
                        jSONObject.put("app_id", f.b(context));
                        jSONObject.put("app_version", b2);
                        jSONObject.put("sdk_version", "2280016");
                        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
                        jSONObject.put("sign", f(b3, e2, "android", currentTimeMillis));
                        return jSONObject;
                    }
                    e.b("LCPCommon", "getData appId : " + b3 + ", cuid :" + e2);
                    return null;
                }
                String str4 = "nonNet";
                if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                    str4 = RequsetNetworkUtils.isWifiConnected(context) ? "wifi" : RequsetNetworkUtils.getMobileType(context);
                }
                LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder();
                newBuilder.w(e2);
                newBuilder.x("android");
                newBuilder.B(str);
                newBuilder.y(str2);
                newBuilder.z(str3);
                newBuilder.u(b3);
                newBuilder.v(b2);
                newBuilder.D("2280016");
                newBuilder.A(str4);
                newBuilder.C(d(context));
                return newBuilder.build();
            } catch (Exception e3) {
                e.c("LCPCommon", "getData :", e3);
                return null;
            }
        }
        return invokeLZ.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            String str3 = "";
            if (upperCase.contains("XIAOMI")) {
                str = "ro.miui.ui.version.code";
            } else if (upperCase.contains("HUAWEI")) {
                str = "ro.build.version.emui";
            } else if (upperCase.contains("MEIZU")) {
                str = "ro.build.display.id";
            } else if (upperCase.contains("OPPO")) {
                str = "ro.build.version.opporom";
            } else {
                str = upperCase.contains("VIVO") ? "ro.vivo.os.version" : "";
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str2 = SystemProperties.get(str);
                } else {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
                }
                str3 = str2;
            } catch (Throwable unused) {
                if (Build.VERSION.SDK_INT >= 21 && upperCase.contains("HUAWEI")) {
                    return Constants.SDK_VER;
                }
                if (upperCase.contains("HUAWEI")) {
                    return "1.0";
                }
                if (upperCase.contains("XIAOMI")) {
                    return "4.0";
                }
                if (upperCase.contains("MEIZU")) {
                    return "6.0";
                }
                if (upperCase.contains("OPPO")) {
                    return "3.0";
                }
                if (upperCase.contains("VIVO")) {
                    return "3.2";
                }
            }
            if (upperCase.contains("HUAWEI") && !TextUtils.isEmpty(str3)) {
                String substring = str3.substring(str3.indexOf("_") + 1, str3.length());
                return (substring.matches("\\d+\\.\\d+$") || Build.VERSION.SDK_INT < 21) ? substring : Constants.SDK_VER;
            }
            if (upperCase.contains("MEIZU")) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = Build.DISPLAY;
                }
                Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str3);
                if (matcher.find()) {
                    str3 = matcher.group();
                }
            } else if (upperCase.contains("OPPO") && !TextUtils.isEmpty(str3)) {
                Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str3);
                if (matcher2.find()) {
                    str3 = matcher2.group(1);
                }
            } else if (upperCase.contains("VIVO") && !TextUtils.isEmpty(str3)) {
                Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str3);
                if (matcher3.find()) {
                    return matcher3.group();
                }
            }
            return str3;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i2));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String f(String str, String str2, String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, Long.valueOf(j2)})) == null) ? e(String.format("%s%s%s%d", str, str2, str3, Long.valueOf(j2))) : (String) invokeCommon.objValue;
    }
}
