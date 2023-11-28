package com.baidu.searchbox.pms.init.response;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.dyesdk.DyeService;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ParseUtils {
    public static final String BIZ_NAME_PREFIX = "aps_";
    public static final String UNIQUE_VERSION = "unique_version";

    public static List<PackageInfo> parseAPSItems(JSONObject jSONObject) {
        PackageInfo parsePkgItem;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next2);
                    if (optJSONObject2 != null && (parsePkgItem = parsePkgItem(true, next, next2, optJSONObject2)) != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(parsePkgItem);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<PackageInfo> parseDPMItems(JSONObject jSONObject) {
        JSONObject optJSONObject;
        PackageInfo parsePkgItem;
        PackageInfo parsePkgItem2;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("mainentrance")) != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(next2);
                    if (optJSONObject3 != null && (parsePkgItem2 = parsePkgItem(true, next, next2, optJSONObject3)) != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(parsePkgItem2);
                    }
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("dependencies");
                if (optJSONObject4 != null) {
                    Iterator<String> keys3 = optJSONObject4.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(next3);
                        if (optJSONObject5 != null) {
                            Iterator<String> keys4 = optJSONObject5.keys();
                            while (keys4.hasNext()) {
                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject(keys4.next());
                                if (optJSONObject6 != null && (parsePkgItem = parsePkgItem(false, next, next3, optJSONObject6)) != null) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(parsePkgItem);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<PackageInfo> parseItems(String str, JSONObject jSONObject) {
        if (TextUtils.equals(str, "aps")) {
            return parseAPSItems(jSONObject);
        }
        if (TextUtils.equals(str, ApsCloudControlProcessor.SERVER_DPM)) {
            return parseDPMItems(jSONObject);
        }
        return null;
    }

    @Deprecated
    public static List<PackageInfo> parseItems(JSONObject jSONObject) {
        return parseItems("aps", jSONObject);
    }

    public static PackageInfo parsePkgItem(String str, String str2, JSONObject jSONObject) {
        return parsePkgItem(true, str, str2, jSONObject);
    }

    public static PackageInfo parsePkgItem(boolean z, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PackageInfo packageInfo = new PackageInfo(z);
        packageInfo.channelId = str;
        packageInfo.packageName = str2;
        packageInfo.errNo = jSONObject.optInt("errno", 0);
        packageInfo.updateVersion = jSONObject.optLong("version");
        packageInfo.updateSign = jSONObject.optString("sign");
        DyeService dyeService = (DyeService) ServiceManager.getService(DyeService.Companion.getSERVICE_REFERENCE());
        if (dyeService != null) {
            dyeService.putRawDyeConfig(BIZ_NAME_PREFIX + str, str2, jSONObject.optString("trace_id", ""));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pkg_info");
            if (optJSONObject2 != null) {
                packageInfo.name = optJSONObject2.optString("name");
                packageInfo.version = optJSONObject2.optLong("version");
                packageInfo.downloadUrl = optJSONObject2.optString("download_url");
                packageInfo.md5 = optJSONObject2.optString("md5");
                packageInfo.size = optJSONObject2.optString("size");
                packageInfo.minHostVersion = optJSONObject2.optString("minv");
                packageInfo.maxHostVersion = optJSONObject2.optString("maxv");
                packageInfo.maxHostVersion = optJSONObject2.optString("maxv");
                packageInfo.sign = optJSONObject2.optString("sign");
                packageInfo.patchMD5 = optJSONObject2.optString(UpdatePackageDownloadInfo.JSON_KEY_PATCH_MD5);
                packageInfo.patchUrl = optJSONObject2.optString(UpdatePackageDownloadInfo.JSON_KEY_PATCH_URL);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("pkg_control");
            if (optJSONObject3 != null) {
                packageInfo.wifi = optJSONObject3.optInt("wifi");
                packageInfo.isSilence = optJSONObject3.optInt("issilence");
                packageInfo.disable = optJSONObject3.optInt(PackageTable.DISABLE);
                packageInfo.isSilentUpgrade = optJSONObject3.optInt("silentupgrade", 1);
                String optString = optJSONObject3.optString("cdn_key");
                String optString2 = optJSONObject3.optString("cdn_value");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        packageInfo.netWorkStrategy = URLEncoder.encode(optString, "UTF-8") + "=" + URLEncoder.encode(optString2, "UTF-8");
                    } catch (Exception unused) {
                    }
                }
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("pkg_ext");
            if (optJSONObject4 != null) {
                String jSONObject2 = optJSONObject4.toString();
                packageInfo.extraServer = jSONObject2;
                if (jSONObject2 != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(packageInfo.extraServer);
                        packageInfo.abi = jSONObject3.optString("abi");
                        packageInfo.uniqueVersion = jSONObject3.optString(UNIQUE_VERSION);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("dependencies");
            if (optJSONObject5 != null) {
                packageInfo.setDependenciesString(optJSONObject5);
            }
            packageInfo.subBundle = optJSONObject.optString("sub_bundle");
            packageInfo.dependInfo = optJSONObject.optString("depend_info");
        }
        return packageInfo;
    }
}
