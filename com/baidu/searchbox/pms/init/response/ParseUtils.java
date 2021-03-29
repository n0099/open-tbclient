package com.baidu.searchbox.pms.init.response;

import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ParseUtils {
    public static List<PackageInfo> parseItems(JSONObject jSONObject) {
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
                    if (optJSONObject2 != null && (parsePkgItem = parsePkgItem(next, next2, optJSONObject2)) != null) {
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

    public static PackageInfo parsePkgItem(String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.channelId = str;
        packageInfo.packageName = str2;
        packageInfo.errNo = jSONObject.optInt("errno", 0);
        packageInfo.updateVersion = jSONObject.optLong("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pkg_info");
            if (optJSONObject2 != null) {
                packageInfo.name = optJSONObject2.optString("name");
                packageInfo.version = optJSONObject2.optLong("version");
                packageInfo.downloadUrl = optJSONObject2.optString("download_url");
                packageInfo.md5 = optJSONObject2.optString(PackageTable.MD5);
                packageInfo.size = optJSONObject2.optString("size");
                packageInfo.minHostVersion = optJSONObject2.optString("minv");
                packageInfo.maxHostVersion = optJSONObject2.optString("maxv");
                packageInfo.maxHostVersion = optJSONObject2.optString("maxv");
                packageInfo.sign = optJSONObject2.optString("sign");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("pkg_control");
            if (optJSONObject3 != null) {
                packageInfo.wifi = optJSONObject3.optInt("wifi");
                packageInfo.isSilence = optJSONObject3.optInt("issilence");
                packageInfo.disable = optJSONObject3.optInt(PackageTable.DISABLE);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("pkg_ext");
            if (optJSONObject4 != null) {
                packageInfo.extraServer = optJSONObject4.toString();
            }
        }
        return packageInfo;
    }
}
