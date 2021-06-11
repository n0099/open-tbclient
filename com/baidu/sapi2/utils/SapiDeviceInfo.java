package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiDeviceInfo implements NoProguard {
    public static final String OS_TYPE = "android";
    public static final int VERSION = 11;
    public static final String DELIMITER = Character.toString(1);
    public static final String AES_KEY = TextUtils.join("", new String[]{"O", "a", "L", "h", "z", "O", "K", "T", "T", "Q", "G", "L", "w", "8", "h", "P"});

    /* loaded from: classes2.dex */
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
            return arrayList;
        }

        public static void updateCookiesMap(List<String> list) {
            List<String> cookiesKeyList = getCookiesKeyList();
            for (int i2 = 0; i2 < cookiesKeyList.size() && i2 < list.size(); i2++) {
                cookiesMap.put(cookiesKeyList.get(i2), list.get(i2));
            }
        }
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List<Integer> diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
        ArrayList arrayList = new ArrayList();
        arrayList.add(diExceptIndex.contains(0) ? "" : context.getPackageName());
        arrayList.add(diExceptIndex.contains(1) ? "" : SapiUtils.getVersionName(context));
        arrayList.add(diExceptIndex.contains(2) ? "" : isAccountManager.getVersionName());
        arrayList.add(diExceptIndex.contains(3) ? "" : getOSModel());
        arrayList.add(diExceptIndex.contains(4) ? "" : getOSVersion());
        String str6 = "android";
        arrayList.add(diExceptIndex.contains(5) ? "" : "android");
        arrayList.add(diExceptIndex.contains(6) ? "" : SapiUtils.getClientId(context));
        arrayList.add(diExceptIndex.contains(7) ? "" : confignation.tpl);
        diExceptIndex.contains(8);
        arrayList.add("");
        diExceptIndex.contains(9);
        arrayList.add("");
        if (diExceptIndex.contains(10) || str == null) {
            str = "";
        }
        arrayList.add(str);
        arrayList.add(diExceptIndex.contains(11) ? "" : String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes()));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        arrayList.add((diExceptIndex.contains(12) || currentAccount == null) ? "" : currentAccount.uid);
        arrayList.add(diExceptIndex.contains(13) ? "" : SapiUtils.getNetworkClass(context));
        if (diExceptIndex.contains(14)) {
            str2 = "";
        } else {
            str2 = SapiContext.getInstance().getRootStatus();
            if (TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(SapiUtils.isRoot());
                SapiContext.getInstance().setRootStatus(str2);
            }
        }
        arrayList.add(str2);
        arrayList.add(diExceptIndex.contains(15) ? "" : SapiUtils.getWifiInfo(context));
        arrayList.add(diExceptIndex.contains(16) ? "" : SapiDeviceUtils.getIMEI(context));
        if (diExceptIndex.contains(17)) {
            str6 = "";
        } else if (SapiUtils.isEmulator(context)) {
            str6 = "emulator";
        }
        arrayList.add(str6);
        arrayList.add(diExceptIndex.contains(18) ? "" : SapiDeviceUtils.getMac(context));
        arrayList.add((diExceptIndex.contains(19) || SapiUtils.getCpuName() == null) ? "" : SapiUtils.getCpuName());
        arrayList.add(diExceptIndex.contains(20) ? "" : SapiUtils.getRamMemorySize());
        if (diExceptIndex.contains(21)) {
            str3 = "";
        } else {
            str3 = SapiUtils.getInternalMemorySize() + "";
        }
        arrayList.add(str3);
        if (diExceptIndex.contains(22)) {
            str4 = "";
        } else {
            str4 = SapiUtils.getInternalAvailableMemorySize() + "";
        }
        arrayList.add(str4);
        if (diExceptIndex.contains(23)) {
            str5 = "";
        } else {
            str5 = SapiUtils.getTimeSinceBoot() + "";
        }
        arrayList.add(str5);
        diExceptIndex.contains(24);
        arrayList.add("");
        arrayList.add(diExceptIndex.contains(25) ? "" : TextUtils.join(",", SapiUtils.getPackageList(context)));
        String localIpAddress = SapiUtils.getLocalIpAddress();
        if (diExceptIndex.contains(26) || localIpAddress == null) {
            localIpAddress = "";
        }
        arrayList.add(localIpAddress);
        String deviceName = SapiUtils.getDeviceName();
        if (TextUtils.isEmpty(deviceName)) {
            deviceName = SapiUtils.getBlueToothDeviceName(context);
        }
        if (diExceptIndex.contains(27)) {
            deviceName = "";
        }
        arrayList.add(deviceName);
        diExceptIndex.contains(28);
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add(diExceptIndex.contains(34) ? "" : isAccountManager.getCurrentZid(context));
        diExceptIndex.contains(35);
        arrayList.add("");
        arrayList.add(diExceptIndex.contains(36) ? "" : SapiUtils.getIccid(context));
        return arrayList;
    }

    public static String buildIV() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 11) + "0";
    }

    public static String encryptDeviceInfo(String str) {
        try {
            String buildIV = buildIV();
            String base64Encode = SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(str, buildIV, AES_KEY));
            return TextUtils.join("_", new String[]{buildIV, base64Encode, SecurityUtil.md5(TextUtils.join("_", new String[]{buildIV, base64Encode, BundleOpProvider.METHOD_BUNDLE_CHECK}).getBytes(), false).substring(0, 6)});
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

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    public static String getOSVersion() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "";
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (DeviceInfoCookieManager.cookiesMap.isEmpty() || list == null) {
            return null;
        }
        for (String str : list) {
            try {
                jSONObject.put(str, DeviceInfoCookieManager.cookiesMap.get(str));
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        if ("NoZidYet".equals(jSONObject.optString("sf_zid"))) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                jSONObject.put("sf_zid", isAccountManager.getZidAndCheckSafe(isAccountManager.getConfignation().context, currentAccount == null ? null : currentAccount.uid, 120));
            } catch (JSONException e3) {
                Log.e(e3);
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        if (z) {
            return encryptDeviceInfo(jSONObject.toString());
        }
        return jSONObject.toString();
    }
}
