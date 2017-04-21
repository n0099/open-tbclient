package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class d {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, e eVar) {
        if (aVar.gv() != null && (aVar.gv().equals("omp") || aVar.gv().equals("mon"))) {
            return a(eVar);
        }
        return a(true, eVar);
    }

    public static HashMap<String, Object> a(e eVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", eVar.mAppVersion);
        a(hashMap, "_phone_imei", eVar.wQ);
        a(hashMap, "_client_id", eVar.mClientId);
        a(hashMap, "subapp_type", eVar.wR);
        a(hashMap, "from", eVar.wO);
        a(hashMap, "net_type", eVar.wU);
        a(hashMap, "cuid", eVar.mCuid);
        a(hashMap, "model", eVar.wS);
        if (TextUtils.isEmpty(eVar.mUid)) {
            eVar.mUid = "0";
        }
        a(hashMap, SapiAccountManager.SESSION_UID, eVar.mUid);
        a(hashMap, "un", eVar.wT);
        a(hashMap, "BDUSS", eVar.mBduss);
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

    private static String a(e eVar) {
        if (eVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wM, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wN, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.mAppVersion, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wV, "utf-8"));
            if (!TextUtils.isEmpty(eVar.wO)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wO, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.wP)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wP, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wS, "utf-8"));
            if (!TextUtils.isEmpty(eVar.mUid)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.wQ)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wQ, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.wT)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wT, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.mCuid)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mCuid, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.mNetType, "utf-8"));
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

    private static String a(boolean z, e eVar) {
        if (eVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        a(sb, "_client_version", eVar.mAppVersion, z);
        a(sb, "_phone_imei", eVar.wQ, z);
        a(sb, "_client_id", eVar.mClientId, z);
        a(sb, "subapp_type", eVar.wR, z);
        a(sb, "os_version", eVar.wV, z);
        a(sb, "from", eVar.wO, z);
        a(sb, "cfrom", eVar.wP, z);
        a(sb, "net_type", eVar.wU, z);
        a(sb, "cuid", eVar.mCuid, z);
        a(sb, "model", eVar.wS, z);
        if (TextUtils.isEmpty(eVar.mUid)) {
            a(sb, SapiAccountManager.SESSION_UID, "0", z);
        } else {
            a(sb, SapiAccountManager.SESSION_UID, eVar.mUid, z);
        }
        a(sb, "un", eVar.wT, z);
        return sb.toString();
    }
}
