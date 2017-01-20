package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class d {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, f fVar) {
        if (aVar.fu() != null && (aVar.fu().equals("omp") || aVar.fu().equals("mon"))) {
            return a(fVar);
        }
        return a(true, fVar);
    }

    public static HashMap<String, Object> a(f fVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", fVar.mAppVersion);
        a(hashMap, "_phone_imei", fVar.pO);
        a(hashMap, "_client_id", fVar.mClientId);
        a(hashMap, "subapp_type", fVar.pP);
        a(hashMap, "from", fVar.pM);
        a(hashMap, "net_type", fVar.pT);
        a(hashMap, SocialConstants.PARAM_CUID, fVar.mCuid);
        a(hashMap, "model", fVar.pQ);
        if (TextUtils.isEmpty(fVar.mUid)) {
            fVar.mUid = "0";
        }
        a(hashMap, SapiAccountManager.SESSION_UID, fVar.mUid);
        a(hashMap, "un", fVar.pR);
        a(hashMap, "BDUSS", fVar.pS);
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

    private static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.pK, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.pL, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.mAppVersion, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append(SocialConstants.ANDROID_CLIENT_TYPE);
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.pU, "utf-8"));
            if (!TextUtils.isEmpty(fVar.pM)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.pM, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.pN)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.pN, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.pQ, "utf-8"));
            if (!TextUtils.isEmpty(fVar.mUid)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.pO)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.pO, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.pR)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.pR, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.mCuid)) {
                sb.append("&");
                sb.append(SocialConstants.PARAM_CUID);
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mCuid, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.mNetType, "utf-8"));
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

    private static String a(boolean z, f fVar) {
        if (fVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        a(sb, "_client_version", fVar.mAppVersion, z);
        a(sb, "_phone_imei", fVar.pO, z);
        a(sb, "_client_id", fVar.mClientId, z);
        a(sb, "subapp_type", fVar.pP, z);
        a(sb, "os_version", fVar.pU, z);
        a(sb, "from", fVar.pM, z);
        a(sb, "cfrom", fVar.pN, z);
        a(sb, "net_type", fVar.pT, z);
        a(sb, SocialConstants.PARAM_CUID, fVar.mCuid, z);
        a(sb, "model", fVar.pQ, z);
        if (TextUtils.isEmpty(fVar.mUid)) {
            a(sb, SapiAccountManager.SESSION_UID, "0", z);
        } else {
            a(sb, SapiAccountManager.SESSION_UID, fVar.mUid, z);
        }
        a(sb, "un", fVar.pR, z);
        a(sb, "BDUSS", fVar.pS, z);
        return sb.toString();
    }
}
