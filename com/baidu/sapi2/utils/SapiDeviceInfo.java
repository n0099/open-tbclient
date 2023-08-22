package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SapiDeviceInfo implements NoProguard {
    public static final String OS_TYPE = "android";
    public static final int VERSION = 11;
    public static final String DELIMITER = Character.toString(1);
    public static final String AES_KEY = TextUtils.join("", new String[]{"O", "a", "L", "h", "z", "O", "K", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_DIRECTION_TRUE, "Q", "G", "L", "w", "8", "h", "P"});

    /* loaded from: classes3.dex */
    public static final class DeviceInfoCookieManager {
        public static Map<String, String> cookiesMap = new HashMap();

        public static List<String> getCookiesKeyList() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("PackageName");
            arrayList.add("AppVersion");
            arrayList.add("SdkVersion");
            arrayList.add("PhoneModel");
            arrayList.add("SystemVersion");
            arrayList.add("SystemType");
            arrayList.add("cuid");
            arrayList.add("tpl");
            arrayList.add("uid_count");
            arrayList.add("uid_list");
            arrayList.add("usetype");
            arrayList.add("used_times");
            arrayList.add("cur_uid");
            arrayList.add("net_type");
            arrayList.add("is_root");
            arrayList.add("wifi");
            arrayList.add("imei");
            arrayList.add("emulator");
            arrayList.add("mac_address");
            arrayList.add("cpu_info");
            arrayList.add("ram");
            arrayList.add("internal_memory");
            arrayList.add("internal_avail_memory");
            arrayList.add("up_time");
            arrayList.add("gps");
            arrayList.add("package_list");
            arrayList.add("ip");
            arrayList.add("device_name");
            arrayList.add(SuggestAddrField.KEY_MAP_LOCATION);
            arrayList.add("device_sn");
            arrayList.add("device_uuid");
            arrayList.add("mtj_cuid");
            arrayList.add("idfa");
            arrayList.add("baidumap_cuid");
            arrayList.add("sf_zid");
            arrayList.add("hostver");
            arrayList.add("iccid");
            arrayList.add("pass_bio_ver");
            arrayList.add("t_cuid");
            arrayList.add("t_appname");
            return arrayList;
        }

        public static void updateCookiesMap(List<String> list) {
            List<String> cookiesKeyList = getCookiesKeyList();
            for (int i = 0; i < cookiesKeyList.size() && i < list.size(); i++) {
                cookiesMap.put(cookiesKeyList.get(i), list.get(i));
            }
        }
    }

    public static String getOSModel() {
        if (!TextUtils.isEmpty(Build.MODEL)) {
            return Build.MODEL;
        }
        return "";
    }

    public static String getOSVersion() {
        if (!TextUtils.isEmpty(Build.VERSION.RELEASE)) {
            return Build.VERSION.RELEASE;
        }
        return "";
    }

    public static int getOsSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List<Integer> diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
        JSONArray grayControlParams = ParamsUtil.getGrayControlParams();
        ArrayList arrayList = new ArrayList();
        String str25 = "";
        if (diExceptIndex.contains(0) || !ParamsUtil.checkDiUpload(grayControlParams, 0)) {
            str2 = "";
        } else {
            str2 = context.getPackageName();
        }
        arrayList.add(str2);
        if (diExceptIndex.contains(1) || !ParamsUtil.checkDiUpload(grayControlParams, 1)) {
            str3 = "";
        } else {
            str3 = SapiUtils.getVersionName(context);
        }
        arrayList.add(str3);
        if (diExceptIndex.contains(2) || !ParamsUtil.checkDiUpload(grayControlParams, 2)) {
            str4 = "";
        } else {
            str4 = isAccountManager.getVersionName();
        }
        arrayList.add(str4);
        if (diExceptIndex.contains(3) || !ParamsUtil.checkDiUpload(grayControlParams, 3)) {
            str5 = "";
        } else {
            str5 = getOSModel();
        }
        arrayList.add(str5);
        if (diExceptIndex.contains(4) || !ParamsUtil.checkDiUpload(grayControlParams, 4)) {
            str6 = "";
        } else {
            str6 = getOSVersion();
        }
        arrayList.add(str6);
        String str26 = "android";
        if (diExceptIndex.contains(5) || !ParamsUtil.checkDiUpload(grayControlParams, 5)) {
            obj = "";
        } else {
            obj = "android";
        }
        arrayList.add(obj);
        if (diExceptIndex.contains(6) || !ParamsUtil.checkDiUpload(grayControlParams, 6)) {
            str7 = "";
        } else {
            str7 = SapiUtils.getClientId(context);
        }
        arrayList.add(str7);
        if (diExceptIndex.contains(7) || !ParamsUtil.checkDiUpload(grayControlParams, 7)) {
            str8 = "";
        } else {
            str8 = confignation.tpl;
        }
        arrayList.add(str8);
        arrayList.add("");
        arrayList.add("");
        arrayList.add((diExceptIndex.contains(10) || !ParamsUtil.checkDiUpload(grayControlParams, 10) || str == null) ? "" : "");
        if (diExceptIndex.contains(11) || !ParamsUtil.checkDiUpload(grayControlParams, 11)) {
            str9 = "";
        } else {
            str9 = String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes());
        }
        arrayList.add(str9);
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (diExceptIndex.contains(12) || !ParamsUtil.checkDiUpload(grayControlParams, 12) || currentAccount == null) {
            str10 = "";
        } else {
            str10 = currentAccount.uid;
        }
        arrayList.add(str10);
        if (diExceptIndex.contains(13) || !ParamsUtil.checkDiUpload(grayControlParams, 13)) {
            str11 = "";
        } else {
            str11 = SapiUtils.getNetworkClass(context);
        }
        arrayList.add(str11);
        if (diExceptIndex.contains(14) || !ParamsUtil.checkDiUpload(grayControlParams, 14)) {
            str12 = "";
        } else {
            str12 = SapiContext.getInstance().getRootStatus();
            if (TextUtils.isEmpty(str12)) {
                str12 = String.valueOf(SapiUtils.isRoot());
                SapiContext.getInstance().setRootStatus(str12);
            }
        }
        arrayList.add(str12);
        if (diExceptIndex.contains(15) || !ParamsUtil.checkDiUpload(grayControlParams, 15)) {
            str13 = "";
        } else {
            str13 = SapiUtils.getWifiInfo(context);
        }
        arrayList.add(str13);
        if (diExceptIndex.contains(16) || !ParamsUtil.checkDiUpload(grayControlParams, 16)) {
            str14 = "";
        } else {
            str14 = SapiDeviceUtils.getIMEI(context);
        }
        arrayList.add(str14);
        if (diExceptIndex.contains(17) || !ParamsUtil.checkDiUpload(grayControlParams, 17)) {
            str26 = "";
        } else if (SapiUtils.isEmulator(context)) {
            str26 = "emulator";
        }
        arrayList.add(str26);
        arrayList.add("");
        if (diExceptIndex.contains(19) || !ParamsUtil.checkDiUpload(grayControlParams, 19) || SapiUtils.getCpuName() == null) {
            str15 = "";
        } else {
            str15 = SapiUtils.getCpuName();
        }
        arrayList.add(str15);
        if (diExceptIndex.contains(20) || !ParamsUtil.checkDiUpload(grayControlParams, 20)) {
            str16 = "";
        } else {
            str16 = SapiUtils.getRamMemorySize();
        }
        arrayList.add(str16);
        if (diExceptIndex.contains(21) || !ParamsUtil.checkDiUpload(grayControlParams, 21)) {
            str17 = "";
        } else {
            str17 = SapiUtils.getInternalMemorySize() + "";
        }
        arrayList.add(str17);
        if (diExceptIndex.contains(22) || !ParamsUtil.checkDiUpload(grayControlParams, 22)) {
            str18 = "";
        } else {
            str18 = SapiUtils.getInternalAvailableMemorySize() + "";
        }
        arrayList.add(str18);
        if (diExceptIndex.contains(23) || !ParamsUtil.checkDiUpload(grayControlParams, 23)) {
            str19 = "";
        } else {
            str19 = SapiUtils.getTimeSinceBoot() + "";
        }
        arrayList.add(str19);
        if (!diExceptIndex.contains(24)) {
            ParamsUtil.checkDiUpload(grayControlParams, 24);
        }
        arrayList.add("");
        if (diExceptIndex.contains(25) || !ParamsUtil.checkDiUpload(grayControlParams, 25)) {
            str20 = "";
        } else {
            str20 = TextUtils.join(",", SapiUtils.getPackageList(context));
        }
        arrayList.add(str20);
        arrayList.add((diExceptIndex.contains(26) || !ParamsUtil.checkDiUpload(grayControlParams, 26) || SapiUtils.getLocalIpAddress() == null) ? "" : "");
        String deviceName = SapiUtils.getDeviceName();
        if (TextUtils.isEmpty(deviceName)) {
            deviceName = SapiUtils.getBlueToothDeviceName(context);
        }
        arrayList.add((diExceptIndex.contains(27) || !ParamsUtil.checkDiUpload(grayControlParams, 27)) ? "" : "");
        if (!diExceptIndex.contains(28)) {
            ParamsUtil.checkDiUpload(grayControlParams, 28);
        }
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        if (diExceptIndex.contains(34) || !ParamsUtil.checkDiUpload(grayControlParams, 34)) {
            str21 = "";
        } else {
            str21 = isAccountManager.getCurrentZid(context);
        }
        arrayList.add(str21);
        if (!diExceptIndex.contains(35)) {
            ParamsUtil.checkDiUpload(grayControlParams, 35);
        }
        arrayList.add("");
        if (diExceptIndex.contains(36) || !ParamsUtil.checkDiUpload(grayControlParams, 36)) {
            str22 = "";
        } else {
            str22 = SapiUtils.getIccid(context);
        }
        arrayList.add(str22);
        if (diExceptIndex.contains(37) || !ParamsUtil.checkDiUpload(grayControlParams, 37)) {
            str23 = "";
        } else {
            str23 = "9.7.5.1";
        }
        arrayList.add(str23);
        if (!diExceptIndex.contains(38) && ParamsUtil.checkDiUpload(grayControlParams, 38)) {
            str24 = confignation.mTPLCuid;
            if (str24 == null) {
                if (ParamsUtil.checkDiUpload(grayControlParams, 6)) {
                    str24 = SapiUtils.getClientId(context);
                }
            }
            arrayList.add(str24);
            if (!diExceptIndex.contains(39) && ParamsUtil.checkDiUpload(grayControlParams, 39) && (str25 = confignation.mTPLAppName) == null) {
                str25 = SapiUtils.getClientId(context);
            }
            arrayList.add(str25);
            Log.e("privacy_parameter_control", "token=" + arrayList);
            return arrayList;
        }
        str24 = "";
        arrayList.add(str24);
        if (!diExceptIndex.contains(39)) {
            str25 = SapiUtils.getClientId(context);
        }
        arrayList.add(str25);
        Log.e("privacy_parameter_control", "token=" + arrayList);
        return arrayList;
    }

    public static String buildIV() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 11) + "0";
    }

    public static String encryptDeviceInfo(String str) {
        try {
            String buildIV = buildIV();
            String base64Encode = SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(str, buildIV, AES_KEY));
            return TextUtils.join("_", new String[]{buildIV, base64Encode, SecurityUtil.md5(TextUtils.join("_", new String[]{buildIV, base64Encode, ApkCheckUBCManagerKt.PAGE}).getBytes(), false).substring(0, 6)});
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static String getDeviceInfo(String str) {
        List<String> buildDeviceTokens = buildDeviceTokens(str);
        DeviceInfoCookieManager.updateCookiesMap(buildDeviceTokens);
        return encryptDeviceInfo(TextUtils.join(DELIMITER, buildDeviceTokens));
    }

    public static String getDiCookieInfo(List<String> list) {
        return getDiCookieInfo(list, true);
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (DeviceInfoCookieManager.cookiesMap.isEmpty() || list == null) {
            return null;
        }
        for (String str2 : list) {
            try {
                jSONObject.put(str2, DeviceInfoCookieManager.cookiesMap.get(str2));
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        if ("NoZidYet".equals(jSONObject.optString("sf_zid"))) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                Context context = isAccountManager.getConfignation().context;
                if (currentAccount == null) {
                    str = null;
                } else {
                    str = currentAccount.uid;
                }
                jSONObject.put("sf_zid", isAccountManager.getZidAndCheckSafe(context, str, 120));
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        Log.e("privacy_parameter_control", "diObj=" + jSONObject);
        if (z) {
            return encryptDeviceInfo(jSONObject.toString());
        }
        return jSONObject.toString();
    }
}
