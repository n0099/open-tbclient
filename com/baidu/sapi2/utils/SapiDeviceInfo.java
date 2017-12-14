package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SapiDeviceInfo {
    private static final int a = 7;
    private static final String c = "android";
    private static final String b = Character.toString(1);
    private static final String d = TextUtils.join("", new String[]{"O", "a", "L", "h", "z", "O", "K", "T", "T", "Q", "G", "L", "w", "8", "h", "P"});

    static String a() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "";
    }

    static String b() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    static List<String> c() {
        List<SapiAccount> shareAccounts = ServiceManager.getInstance().getIsAccountManager().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        String str3;
        String cpuName;
        String localIpAddress;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List<Integer> diExceptIndex = SapiContext.getInstance(context).getDiExceptIndex();
        ArrayList arrayList = new ArrayList();
        arrayList.add(diExceptIndex.contains(0) ? "" : context.getPackageName());
        arrayList.add(diExceptIndex.contains(1) ? "" : SapiUtils.getVersionName(context));
        arrayList.add(diExceptIndex.contains(2) ? "" : isAccountManager.getVersionName());
        arrayList.add(diExceptIndex.contains(3) ? "" : b());
        arrayList.add(diExceptIndex.contains(4) ? "" : a());
        arrayList.add(diExceptIndex.contains(5) ? "" : c);
        arrayList.add(diExceptIndex.contains(6) ? "" : SapiUtils.getClientId(context));
        arrayList.add(diExceptIndex.contains(7) ? "" : confignation.tpl);
        arrayList.add(diExceptIndex.contains(8) ? "" : String.valueOf(isAccountManager.getShareAccounts().size()));
        arrayList.add(diExceptIndex.contains(9) ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, c()));
        if (diExceptIndex.contains(10)) {
            str = "";
        } else if (str == null) {
            str = "";
        }
        arrayList.add(str);
        arrayList.add(diExceptIndex.contains(11) ? "" : String.valueOf(SapiContext.getInstance(context).getDeviceInfoReadTimes()));
        SapiAccount session = isAccountManager.getSession();
        if (diExceptIndex.contains(12)) {
            str2 = "";
        } else {
            str2 = session != null ? session.uid : "";
        }
        arrayList.add(str2);
        arrayList.add(diExceptIndex.contains(13) ? "" : SapiUtils.getNetworkClass(context));
        String str4 = "";
        if (!diExceptIndex.contains(14)) {
            str4 = SapiContext.getInstance(context).getRootStatus();
            if (TextUtils.isEmpty(str4)) {
                str4 = String.valueOf(SapiUtils.isRoot());
                SapiContext.getInstance(context).setRootStatus(str4);
            }
        }
        arrayList.add(str4);
        arrayList.add(diExceptIndex.contains(15) ? "" : SapiUtils.getWifiInfo(context));
        arrayList.add(diExceptIndex.contains(16) ? "" : SapiDeviceUtils.getIMEI(context));
        if (diExceptIndex.contains(17)) {
            str3 = "";
        } else {
            str3 = SapiUtils.isEmulator(context) ? "emulator" : c;
        }
        arrayList.add(str3);
        arrayList.add(diExceptIndex.contains(18) ? "" : SapiDeviceUtils.getMac(context));
        if (diExceptIndex.contains(19)) {
            cpuName = "";
        } else {
            cpuName = SapiUtils.getCpuName() != null ? SapiUtils.getCpuName() : "";
        }
        arrayList.add(cpuName);
        arrayList.add(diExceptIndex.contains(20) ? "" : SapiUtils.getRamMemorySize());
        arrayList.add(diExceptIndex.contains(21) ? "" : SapiUtils.getInternalMemorySize() + "");
        arrayList.add(diExceptIndex.contains(22) ? "" : SapiUtils.getInternalAvailableMemorySize() + "");
        arrayList.add(diExceptIndex.contains(23) ? "" : SapiUtils.getTimeSinceBoot() + "");
        arrayList.add(diExceptIndex.contains(24) ? "" : SapiUtils.getGPSInfo(context));
        arrayList.add(diExceptIndex.contains(25) ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, SapiUtils.getPackageList(context)));
        if (diExceptIndex.contains(26)) {
            localIpAddress = "";
        } else {
            localIpAddress = SapiUtils.getLocalIpAddress() != null ? SapiUtils.getLocalIpAddress() : "";
        }
        arrayList.add(localIpAddress);
        arrayList.add(diExceptIndex.contains(27) ? "" : SapiUtils.getBlueToothDeviceName(context));
        arrayList.add(diExceptIndex.contains(28) ? "" : SapiUtils.getLocation(context));
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add(diExceptIndex.contains(34) ? "" : SafeService.getInstance().getCurZid(context));
        arrayList.add(diExceptIndex.contains(35) ? "" : "1.0.3");
        return arrayList;
    }

    static String d() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 7) + "0";
    }

    public static String getDeviceInfo(String str) {
        List<String> buildDeviceTokens = buildDeviceTokens(str);
        DeviceInfoCookieManager.a(buildDeviceTokens);
        return a(TextUtils.join(b, buildDeviceTokens));
    }

    public static String getPisDeviceInfo() {
        Pair<ArrayList<String>, ArrayList<String>> combinePisCookies = PluginFacade.combinePisCookies();
        JSONObject jSONObject = new JSONObject();
        if (combinePisCookies != null && combinePisCookies.first != null && combinePisCookies.second != null && ((ArrayList) combinePisCookies.first).size() > 0 && ((ArrayList) combinePisCookies.second).size() > 0 && ((ArrayList) combinePisCookies.first).size() == ((ArrayList) combinePisCookies.second).size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ArrayList) combinePisCookies.first).size()) {
                    break;
                }
                if (!TextUtils.isEmpty((CharSequence) ((ArrayList) combinePisCookies.first).get(i2))) {
                    try {
                        jSONObject.put((String) ((ArrayList) combinePisCookies.first).get(i2), ((ArrayList) combinePisCookies.second).get(i2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
        }
        return a(jSONObject.toString());
    }

    private static String a(String str) {
        try {
            String d2 = d();
            String base64Encode = SapiDeviceUtils.DeviceCrypto.base64Encode(new AES().encrypt(str, d2, d));
            return TextUtils.join("_", new String[]{d2, base64Encode, MD5Util.toMd5(TextUtils.join("_", new String[]{d2, base64Encode, "check"}).getBytes(), false).substring(0, 6)});
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static String getDiCookieInfo(List<String> list) {
        JSONObject jSONObject = new JSONObject();
        if (DeviceInfoCookieManager.a.isEmpty()) {
            return null;
        }
        for (String str : list) {
            try {
                jSONObject.put(str, DeviceInfoCookieManager.a.get(str));
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        Pair<ArrayList<String>, ArrayList<String>> combinePisCookies = PluginFacade.combinePisCookies();
        if (combinePisCookies != null && combinePisCookies.first != null && combinePisCookies.second != null && ((ArrayList) combinePisCookies.first).size() > 0 && ((ArrayList) combinePisCookies.second).size() > 0 && ((ArrayList) combinePisCookies.first).size() == ((ArrayList) combinePisCookies.second).size()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ArrayList) combinePisCookies.first).size()) {
                    break;
                }
                String str2 = (String) ((ArrayList) combinePisCookies.first).get(i2);
                if (!TextUtils.isEmpty(str2) && list.contains(str2)) {
                    try {
                        jSONObject.put((String) ((ArrayList) combinePisCookies.first).get(i2), ((ArrayList) combinePisCookies.second).get(i2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return a(jSONObject.toString());
    }

    /* loaded from: classes.dex */
    static final class DeviceInfoCookieManager {
        static Map<String, String> a = new HashMap();

        DeviceInfoCookieManager() {
        }

        static List<String> a() {
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
            arrayList.add("map_location");
            arrayList.add("device_sn");
            arrayList.add("device_uuid");
            arrayList.add("mtj_cuid");
            arrayList.add("idfa");
            arrayList.add("baidumap_cuid");
            arrayList.add("sf_zid");
            arrayList.add("hostver");
            return arrayList;
        }

        static void a(List<String> list) {
            List<String> a2 = a();
            for (int i = 0; i < a2.size(); i++) {
                a.put(a2.get(i), list.get(i));
            }
        }
    }
}
