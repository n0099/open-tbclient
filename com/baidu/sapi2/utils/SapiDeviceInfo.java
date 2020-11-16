package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
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
/* loaded from: classes15.dex */
public class SapiDeviceInfo implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3529a = 11;
    private static final String c = "android";
    private static final String b = Character.toString(1);
    private static final String d = TextUtils.join("", new String[]{"O", "a", "L", "h", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "O", "K", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_DIRECTION_TRUE, "Q", "G", "L", "w", "8", "h", "P"});

    static String a() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 11) + "0";
    }

    static List<String> b() {
        List<SapiAccount> shareAccounts = ServiceManager.getInstance().getIsAccountManager().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List<Integer> diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
        ArrayList arrayList = new ArrayList();
        arrayList.add(diExceptIndex.contains(0) ? "" : context.getPackageName());
        arrayList.add(diExceptIndex.contains(1) ? "" : SapiUtils.getVersionName(context));
        arrayList.add(diExceptIndex.contains(2) ? "" : isAccountManager.getVersionName());
        arrayList.add(diExceptIndex.contains(3) ? "" : c());
        arrayList.add(diExceptIndex.contains(4) ? "" : d());
        arrayList.add(diExceptIndex.contains(5) ? "" : "android");
        arrayList.add(diExceptIndex.contains(6) ? "" : SapiUtils.getClientId(context));
        arrayList.add(diExceptIndex.contains(7) ? "" : confignation.tpl);
        arrayList.add(diExceptIndex.contains(8) ? "" : String.valueOf(isAccountManager.getShareAccounts().size()));
        arrayList.add(diExceptIndex.contains(9) ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, b()));
        if (diExceptIndex.contains(10) || str == null) {
            str = "";
        }
        arrayList.add(str);
        arrayList.add(diExceptIndex.contains(11) ? "" : String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes()));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        arrayList.add((diExceptIndex.contains(12) || currentAccount == null) ? "" : currentAccount.uid);
        arrayList.add(diExceptIndex.contains(13) ? "" : SapiUtils.getNetworkClass(context));
        String str3 = "";
        if (!diExceptIndex.contains(14)) {
            str3 = SapiContext.getInstance().getRootStatus();
            if (TextUtils.isEmpty(str3)) {
                str3 = String.valueOf(SapiUtils.isRoot());
                SapiContext.getInstance().setRootStatus(str3);
            }
        }
        arrayList.add(str3);
        arrayList.add(diExceptIndex.contains(15) ? "" : SapiUtils.getWifiInfo(context));
        arrayList.add(diExceptIndex.contains(16) ? "" : SapiDeviceUtils.b(context));
        if (diExceptIndex.contains(17)) {
            str2 = "";
        } else {
            str2 = SapiUtils.isEmulator(context) ? "emulator" : "android";
        }
        arrayList.add(str2);
        arrayList.add(diExceptIndex.contains(18) ? "" : SapiDeviceUtils.c(context));
        arrayList.add((diExceptIndex.contains(19) || SapiUtils.getCpuName() == null) ? "" : SapiUtils.getCpuName());
        arrayList.add(diExceptIndex.contains(20) ? "" : SapiUtils.getRamMemorySize());
        arrayList.add(diExceptIndex.contains(21) ? "" : SapiUtils.getInternalMemorySize() + "");
        arrayList.add(diExceptIndex.contains(22) ? "" : SapiUtils.getInternalAvailableMemorySize() + "");
        arrayList.add(diExceptIndex.contains(23) ? "" : SapiUtils.getTimeSinceBoot() + "");
        diExceptIndex.contains(24);
        arrayList.add("");
        arrayList.add(diExceptIndex.contains(25) ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, SapiUtils.getPackageList(context)));
        arrayList.add((diExceptIndex.contains(26) || SapiUtils.getLocalIpAddress() == null) ? "" : SapiUtils.getLocalIpAddress());
        arrayList.add(diExceptIndex.contains(27) ? "" : SapiUtils.a(context));
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

    static String c() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    static String d() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "";
    }

    public static String getDeviceInfo(String str) {
        List<String> buildDeviceTokens = buildDeviceTokens(str);
        a.a(buildDeviceTokens);
        return a(TextUtils.join(b, buildDeviceTokens));
    }

    public static String getDiCookieInfo(List<String> list) {
        return getDiCookieInfo(list, true);
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (!a.f3530a.isEmpty() && list != null) {
            for (String str : list) {
                try {
                    jSONObject.put(str, a.f3530a.get(str));
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if ("NoZidYet".equals(jSONObject.optString("sf_zid"))) {
                try {
                    ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    jSONObject.put("sf_zid", isAccountManager.getZidAndCheckSafe(isAccountManager.getConfignation().context, currentAccount == null ? null : currentAccount.uid, 120));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            if (z) {
                return a(jSONObject.toString());
            }
            return jSONObject.toString();
        }
        return null;
    }

    private static String a(String str) {
        try {
            String a2 = a();
            String base64Encode = SapiDeviceUtils.DeviceCrypto.base64Encode(new AES().encrypt(str, a2, d));
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{a2, base64Encode, SecurityUtil.md5(TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{a2, base64Encode, "check"}).getBytes(), false).substring(0, 6)});
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static Map<String, String> f3530a = new HashMap();

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
            arrayList.add(UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST);
            arrayList.add(TableDefine.UserInfoColumns.COLUMN_IP);
            arrayList.add("device_name");
            arrayList.add("map_location");
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

        static void a(List<String> list) {
            List<String> a2 = a();
            for (int i = 0; i < a2.size() && i < list.size(); i++) {
                f3530a.put(a2.get(i), list.get(i));
            }
        }
    }
}
