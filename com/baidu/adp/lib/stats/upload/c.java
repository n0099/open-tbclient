package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.Constants;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class c {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.nU() != null && (aVar.nU().equals("omp") || aVar.nU().equals("mon"))) {
            return a(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.akA);
        a(hashMap, "_client_id", cVar.akz);
        a(hashMap, "subapp_type", cVar.akB);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.akF);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.akC);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.akD);
        a(hashMap, "BDUSS", cVar.akE);
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
            sb.append(URLEncoder.encode(cVar.akw, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.akx, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mAppVersion, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append(Constants.OS_TYPE_VALUE);
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.akG, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mChannel, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.aky)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.aky, "utf-8"));
            }
            sb.append("&");
            sb.append(ISapiAccount.SAPI_ACCOUNT_PHONE);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.akC, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.akz)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.akz, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.akA)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.akA, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.akD)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.akD, "utf-8"));
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
        a(sb, "_phone_imei", cVar.akA, z);
        a(sb, "_client_id", cVar.akz, z);
        a(sb, "subapp_type", cVar.akB, z);
        a(sb, "os_version", cVar.akG, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, "cfrom", cVar.aky, z);
        a(sb, "net_type", cVar.akF, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.akC, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.akD, z);
        return sb.toString();
    }
}
