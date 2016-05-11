package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static final int a = 6;
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
        List<SapiAccount> shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    static List<String> a(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getPackageName());
        arrayList.add(SapiUtils.getVersionName(context));
        arrayList.add(SapiAccountManager.VERSION_NAME);
        arrayList.add(b());
        arrayList.add(a());
        arrayList.add("android");
        arrayList.add(SapiUtils.getClientId(context));
        arrayList.add(SapiAccountManager.getInstance().getSapiConfiguration().tpl);
        arrayList.add(String.valueOf(SapiAccountManager.getInstance().getShareAccounts().size()));
        arrayList.add(TextUtils.join(",", c()));
        if (str == null) {
            str = "";
        }
        arrayList.add(str);
        arrayList.add(String.valueOf(com.baidu.sapi2.c.a(context).x()));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        arrayList.add(session != null ? session.uid : "");
        arrayList.add(SapiUtils.getNetworkClass(context));
        String z = com.baidu.sapi2.c.a(context).z();
        if (TextUtils.isEmpty(z)) {
            z = String.valueOf(SapiUtils.isRoot());
            com.baidu.sapi2.c.a(context).g(z);
        }
        arrayList.add(z);
        arrayList.add(SapiUtils.getWifiInfo(context));
        arrayList.add(SapiUtils.getImei(context));
        arrayList.add(SapiUtils.isEmulator(context) ? "emulator" : "android");
        arrayList.add(SapiUtils.getMacAddress(context));
        arrayList.add(SapiUtils.getCpuName() != null ? SapiUtils.getCpuName() : "");
        arrayList.add(SapiUtils.getRamMemorySize());
        arrayList.add(SapiUtils.getInternalMemorySize() + "");
        arrayList.add(SapiUtils.getInternalAvailableMemorySize() + "");
        arrayList.add(SapiUtils.getTimeSinceBoot() + "");
        arrayList.add(SapiUtils.getGPSInfo(context));
        arrayList.add(TextUtils.join(",", SapiUtils.getPackageList(context)));
        arrayList.add(SapiUtils.getLocalIpAddress() != null ? SapiUtils.getLocalIpAddress() : "");
        arrayList.add(SapiUtils.getBlueToothDeviceName(context));
        arrayList.add(SapiUtils.getLocation(context));
        arrayList.add("");
        arrayList.add("");
        return arrayList;
    }

    static String d() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 6) + "0";
    }

    public static String b(String str) {
        List<String> a2 = a(str);
        a.a(a2);
        return c(TextUtils.join(b, a2));
    }

    private static String c(String str) {
        try {
            String d2 = d();
            String b2 = e.a.b(new com.baidu.sapi2.utils.a().a(str, d2, d));
            return TextUtils.join("_", new String[]{d2, b2, MD5Util.toMd5(TextUtils.join("_", new String[]{d2, b2, "check"}).getBytes(), false).substring(0, 6)});
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    public static String a(List<String> list) {
        JSONObject jSONObject = new JSONObject();
        if (a.a.isEmpty()) {
            return null;
        }
        for (String str : list) {
            try {
                jSONObject.put(str, a.a.get(str));
            } catch (JSONException e) {
                L.e(e);
            }
        }
        return c(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        static Map<String, String> a = new HashMap();

        a() {
        }

        static List<String> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("PackageName");
            arrayList.add("AppVersion");
            arrayList.add("SdkVersion");
            arrayList.add("PhoneModel");
            arrayList.add("SystemVersion");
            arrayList.add("SystemType");
            arrayList.add(SocialConstants.PARAM_CUID);
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
