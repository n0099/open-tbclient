package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class c {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.gC() != null && (aVar.gC().equals("omp") || aVar.gC().equals("mon"))) {
            return a(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.yu);
        a(hashMap, "_client_id", cVar.mClientId);
        a(hashMap, "subapp_type", cVar.yv);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.yy);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.yw);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, SapiAccountManager.SESSION_UID, cVar.mUid);
        a(hashMap, "un", cVar.yx);
        a(hashMap, "BDUSS", cVar.mBduss);
        if (z) {
            a(hashMap, "find_bug", "2");
        } else {
            a(hashMap, "find_bug", "0");
        }
        return hashMap;
    }

    private static void a(HashMap<String, Object> hashMap, String str, String str2) {
        if (hashMap != null && str != null && str2 != null) {
            hashMap.put(str, str2);
        }
    }

    private static String a(com.baidu.adp.lib.stats.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.yr, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.ys, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mAppVersion, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.yz, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mChannel, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.yt)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.yt, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.yw, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.yu)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.yu, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.yx)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.yx, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.mCuid)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mCuid, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mNetType, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            BdLog.e(e);
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, String str, String str2, boolean z) {
        if (sb != null && !TextUtils.isEmpty(str)) {
            try {
                String str3 = TextUtils.isEmpty(str2) ? "" : str2;
                StringBuilder append = sb.append("&").append(str).append("=");
                if (z) {
                    str3 = URLEncoder.encode(str3, "utf-8");
                }
                append.append(str3);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private static String a(boolean z, com.baidu.adp.lib.stats.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        a(sb, "_client_version", cVar.mAppVersion, z);
        a(sb, "_phone_imei", cVar.yu, z);
        a(sb, "_client_id", cVar.mClientId, z);
        a(sb, "subapp_type", cVar.yv, z);
        a(sb, "os_version", cVar.yz, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, "cfrom", cVar.yt, z);
        a(sb, "net_type", cVar.yy, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.yw, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, SapiAccountManager.SESSION_UID, "0", z);
        } else {
            a(sb, SapiAccountManager.SESSION_UID, cVar.mUid, z);
        }
        a(sb, "un", cVar.yx, z);
        return sb.toString();
    }
}
