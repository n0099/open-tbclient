package com.baidu.lcp.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.utils.Constants;
import com.baidu.lcp.sdk.a.a;
import com.baidu.lcp.sdk.pb.LcmPb;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.SapiContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    public static Object h(Context context, boolean z) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String appVersionName = TextUtils.isEmpty(getAppVersionName(context)) ? "" : getAppVersionName(context);
        long currentTimeMillis = System.currentTimeMillis();
        String appId = e.getAppId(context);
        String aO = e.aO(context);
        try {
            if (z) {
                if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(aO)) {
                    d.e("LCPCommon", "getData appId : " + appId + ", cuid :" + aO);
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_id", valueOf);
                jSONObject.put("cuid", aO);
                jSONObject.put(HttpConstants.DEVICE_TYPE, "android");
                jSONObject.put("os_version", str);
                jSONObject.put("manufacture", str2);
                jSONObject.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, str3);
                jSONObject.put("app_id", e.getAppId(context));
                jSONObject.put("app_version", appVersionName);
                jSONObject.put(SapiContext.KEY_SDK_VERSION, "2240016");
                jSONObject.put("ts", currentTimeMillis);
                jSONObject.put("sign", b(appId, aO, "android", currentTimeMillis));
                return jSONObject;
            }
            String str4 = "nonNet";
            if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                if (RequsetNetworkUtils.isWifiConnected(context)) {
                    str4 = "wifi";
                } else {
                    str4 = RequsetNetworkUtils.getMobileType(context);
                }
            }
            return LcmPb.Common.newBuilder().fM(aO).fN("android").fO(str).fP(str2).fQ(str3).fR(appId).fS(appVersionName).fT("2240016").fU(str4).fV(aI(context)).build();
        } catch (Exception e) {
            d.e("LCPCommon", "getData :", e);
            return null;
        }
    }

    private static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            d.e("LCPCommon", "getAppVersionName NameNotFoundException", e);
            return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String b(String str, String str2, String str3, long j) {
        return md5(String.format("%s%s%s%d", str, str2, str3, Long.valueOf(j)));
    }

    private static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static String aI(Context context) {
        String str;
        String str2;
        String str3 = "";
        String upperCase = Build.MANUFACTURER.toUpperCase();
        if (upperCase.contains("XIAOMI")) {
            str3 = "ro.miui.ui.version.code";
        } else if (upperCase.contains("HUAWEI")) {
            str3 = "ro.build.version.emui";
        } else if (upperCase.contains("MEIZU")) {
            str3 = RomUtils.PROP_RO_BUILD_DISPLAY_ID;
        } else if (upperCase.contains(RomUtils.ROM_OPPO)) {
            str3 = "ro.build.version.opporom";
        } else if (upperCase.contains(RomUtils.ROM_VIVO)) {
            str3 = "ro.vivo.os.version";
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str2 = SystemProperties.get(str3);
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str3);
            }
            if (upperCase.contains("HUAWEI") && !TextUtils.isEmpty(str2)) {
                String substring = str2.substring(str2.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1, str2.length());
                if (!substring.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21) {
                    return Constants.SDK_VER;
                }
                return substring;
            } else if (upperCase.contains("MEIZU")) {
                str = TextUtils.isEmpty(str2) ? Build.DISPLAY : str2;
                try {
                    Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str);
                    if (matcher.find()) {
                        return matcher.group();
                    }
                    return str;
                } catch (Throwable th) {
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
                    if (upperCase.contains(RomUtils.ROM_OPPO)) {
                        return "3.0";
                    }
                    if (upperCase.contains(RomUtils.ROM_VIVO)) {
                        return "3.2";
                    }
                    return str;
                }
            } else {
                if (upperCase.contains(RomUtils.ROM_OPPO) && !TextUtils.isEmpty(str2)) {
                    Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str2);
                    if (matcher2.find()) {
                        return matcher2.group(1);
                    }
                } else if (upperCase.contains(RomUtils.ROM_VIVO) && !TextUtils.isEmpty(str2)) {
                    Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str2);
                    if (matcher3.find()) {
                        return matcher3.group();
                    }
                }
                return str2;
            }
        } catch (Throwable th2) {
            str = "";
        }
    }

    public static void a(Context context, long j, String str, String str2) {
        try {
            new a.b(context).fH(str).fI("1").Z(j).fJ(str2).aa(501112L).build();
        } catch (Exception e) {
            d.e("LCPCommon", "businessEvent exception ", e);
        }
    }
}
