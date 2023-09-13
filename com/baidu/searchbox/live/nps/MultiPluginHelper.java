package com.baidu.searchbox.live.nps;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tieba.ue1;
import com.baidu.ubc.UBCManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MultiPluginHelper {
    public static final int ARCH_TYPE_NEW = 3;
    public static final int ARCH_TYPE_OLD = 1;
    public static final int ARCH_TYPE_OLD_KEEP_LOCAL = 2;
    public static final String MEDIA_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final int MIX_NEW_ARCH_PLUGIN_VERSION = 508000000;
    public static final String UBC_ID_CANCEL_JOIN_LIVE = "4417";
    public static final String YY_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static AppInfoService appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());

    public static boolean isMultiPluginOn() {
        return true;
    }

    public static String bundleToJsonStr(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    public static HashMap<String, String> stringToMap(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str3 : str.split("&")) {
            String[] split = str3.split("=");
            try {
                String decode = URLDecoder.decode(split[0], "UTF-8");
                if (split.length > 1) {
                    str2 = URLDecoder.decode(split[1], "UTF-8");
                } else {
                    str2 = "";
                }
                hashMap.put(decode, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static void fillSubBundlePkgName(BundleInfo bundleInfo, Set<String> set) {
        if (bundleInfo != null && bundleInfo.isMainBundle() && set != null) {
            for (SubBundleInfo subBundleInfo : bundleInfo.getSubBundle()) {
                set.add(subBundleInfo.getPackageName());
            }
        }
    }

    public static String getParamsStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf <= 0) {
            return null;
        }
        return str.substring(indexOf + 1);
    }

    public static void log(String str) {
        AppInfoService appInfoService = appService;
        if (appInfoService != null && appInfoService.isDebug()) {
            Log.e("MultiPluginWay", "MultiPluginHelper " + str);
        }
    }

    public static Map<String, String> paramsJsonToMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                hashMap.put(next, (String) opt);
            } else {
                hashMap.put(next, opt.toString());
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Type inference failed for r2v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public static String parserYYSchemaUrl(String str) {
        HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
        boolean containsKey = stringToMap.containsKey("params");
        Map map = stringToMap;
        if (containsKey) {
            try {
                map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
            } catch (Exception unused) {
                map = null;
            }
        }
        if (map != null) {
            return map.get("url");
        }
        return "";
    }

    public static int getPluginArchLaunchType(boolean z) {
        BundleInfoGroup bundleGroup;
        BundleInfoGroup bundleGroup2;
        BundleInfo bundleInfo;
        BundleInfo bundleInfo2;
        log("getPluginArchLaunchType ignoreEntrance:  " + z);
        try {
            bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            bundleGroup2 = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bundleGroup == null) {
            return 3;
        }
        BundleInfo bundleByType = bundleGroup.getBundleByType(3);
        BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
        boolean z2 = true;
        BundleInfo bundleByType3 = bundleGroup.getBundleByType(1);
        BundleInfo bundleInfo3 = null;
        if (bundleGroup2 != null) {
            bundleInfo3 = bundleGroup2.getBundleByType(3);
            bundleInfo2 = bundleGroup2.getBundleByType(2);
            bundleInfo = bundleGroup2.getBundleByType(1);
        } else {
            bundleInfo = null;
            bundleInfo2 = null;
        }
        if (bundleByType == null && bundleByType2 == null && bundleInfo3 == null && bundleInfo2 == null) {
            log("ARCH_TYPE_NEW installLivenps downloadLivenps installEntrance downloadEntrance all null");
            return 3;
        } else if (bundleByType != null && bundleByType.getVersionCode() >= 508000000) {
            log("ARCH_TYPE_NEW installLivenps version: " + bundleByType.getVersionCode());
            return 3;
        } else if (bundleInfo3 != null && bundleInfo3.getVersionCode() >= 508000000) {
            log("ARCH_TYPE_NEW installEntrance version: " + bundleInfo3.getVersionCode());
            return 3;
        } else if (bundleByType3 != null && bundleByType3.getVersionCode() >= 508000000 && bundleByType3.needForceUpdate()) {
            log("ARCH_TYPE_NEW updateLivenps version: " + bundleByType3.getVersionCode() + "  needForceUpdate:" + bundleByType3.needForceUpdate());
            return 3;
        } else if (bundleInfo != null && bundleInfo.getVersionCode() >= 508000000 && bundleInfo.needForceUpdate()) {
            log("ARCH_TYPE_NEW updateEntrance version: " + bundleInfo.getVersionCode() + "  needForceUpdate" + bundleInfo.needForceUpdate());
            return 3;
        } else {
            boolean z3 = false;
            if (bundleByType2 != null && bundleByType2.getVersionCode() >= 508000000) {
                log("downloadLivenps version: " + bundleByType2.getVersionCode());
                z3 = true;
            }
            BundleInfo presetBundle = NPSPackageManager.getInstance().getPresetBundle("com.baidu.searchbox.livenps");
            if (presetBundle != null && presetBundle.getVersionCode() >= 508000000) {
                log("presetLivenps version: " + presetBundle.getVersionCode());
            } else {
                z2 = z3;
            }
            if (z2 && (z || (bundleInfo2 != null && bundleInfo2.getVersionCode() >= 508000000))) {
                if (bundleInfo2 != null) {
                    log("downloadEntrance version: " + bundleInfo2.getVersionCode());
                }
                return 3;
            }
            HashSet hashSet = new HashSet();
            fillSubBundlePkgName(bundleByType2, hashSet);
            fillSubBundlePkgName(bundleByType3, hashSet);
            fillSubBundlePkgName(bundleInfo2, hashSet);
            fillSubBundlePkgName(bundleInfo, hashSet);
            if (newArchSubPluginNeedForceUpdate(hashSet)) {
                log("ARCH_TYPE_NEW newArchSubPluginNeedForceUpdate true");
                return 3;
            }
            int c = ue1.b().c("com.baidu.searchbox.livenps");
            if (bundleByType != null && bundleByType.getVersionCode() < 508000000 && bundleByType.getVersionCode() >= c) {
                log("installLivenps：" + bundleByType.getVersionCode());
                log("installLivenps.livenpsHostMinVersion：" + c);
                if (z2 && bundleInfo2 != null && bundleInfo2.getVersionCode() >= 508000000) {
                    log("ARCH_TYPE_NEW downloadEntrance：" + bundleInfo2.getVersionCode());
                    return 3;
                }
                if (bundleInfo2 != null) {
                    log("ARCH_TYPE_OLD_KEEP_LOCAL downloadEntrance version: " + bundleInfo2.getVersionCode());
                } else {
                    log("ARCH_TYPE_OLD_KEEP_LOCAL downloadEntrance null:");
                }
                return 2;
            }
            if (!isMultiPluginOn() && bundleByType == null && bundleByType2 != null && bundleByType2.getVersionCode() < 508000000 && bundleByType2.getVersionCode() >= c) {
                log("downloadLivenps.getVersionCode：" + bundleByType2.getVersionCode());
                log("downloadLivenps.livenpsHostMinVersion：" + c);
                log("ARCH_TYPE_OLD_KEEP_LOCAL installLivenps null  downloadLivenps: " + bundleByType2.getVersionCode());
                return 2;
            }
            log("ARCH_TYPE_NEW：兜底");
            return 3;
        }
    }

    public static boolean isNetworkAvailableForImmediately() {
        NetworkInfo[] allNetworkInfo;
        if (LiveNpsRuntime.getApplication() == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) LiveNpsRuntime.getApplication().getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void logCancelJoinLive(String str, boolean z, UBCManager uBCManager) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            if ("download".equals(str)) {
                str2 = "entrance_download";
            } else if ("install".equals(str)) {
                str2 = "entrance_install";
            } else if ("load".equals(str)) {
                str2 = "entrance_load";
            } else {
                str2 = "";
            }
            jSONObject.put("type", str2);
            jSONObject.put("value", "suc");
            if (z) {
                jSONObject.put("page", "yyshow");
            } else {
                jSONObject.put("page", "media");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (uBCManager != null) {
            uBCManager.onEvent("4417", jSONObject);
        }
    }

    public static boolean newArchSubPluginNeedForceUpdate(Set<String> set) {
        for (String str : set) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                BundleInfo bundleByType = bundleGroup.getBundleByType(1);
                if (bundleByType != null && bundleByType.getVersionCode() >= 508000000 && bundleByType.needForceUpdate()) {
                    return true;
                }
                BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
                if (bundleByType2 != null && bundleByType2.getVersionCode() >= 508000000 && bundleByType2.needForceUpdate()) {
                    return true;
                }
            }
        }
        return false;
    }
}
