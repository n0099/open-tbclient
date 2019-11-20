package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class c {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.gz() != null && (aVar.gz().equals(BdStatsConstant.FILE_OMP) || aVar.gz().equals(BdStatsConstant.FILE_MON))) {
            return a(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.pQ);
        a(hashMap, "_client_id", cVar.pN);
        a(hashMap, "subapp_type", cVar.pR);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.pU);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.pS);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.pT);
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
            sb.append(BdStatsConstant.StatsKey.PRODUCT);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.pK, "utf-8"));
            sb.append("&");
            sb.append(BdStatsConstant.StatsKey.SUB_SYSTEM);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.pL, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mAppVersion, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append(BdStatsConstant.StatsKey.OS_VERSION);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.pV, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mChannel, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.pM)) {
                sb.append("&");
                sb.append(BdStatsConstant.StatsKey.CURRENT_CHANNEL);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.pM, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.pS, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.pN)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.pN, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.pQ)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.pQ, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.pT)) {
                sb.append("&");
                sb.append(BdStatsConstant.StatsKey.UNAME);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.pT, "utf-8"));
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
        a(sb, "_phone_imei", cVar.pQ, z);
        a(sb, "_client_id", cVar.pN, z);
        a(sb, "subapp_type", cVar.pR, z);
        a(sb, BdStatsConstant.StatsKey.OS_VERSION, cVar.pV, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, BdStatsConstant.StatsKey.CURRENT_CHANNEL, cVar.pM, z);
        a(sb, "net_type", cVar.pU, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.pS, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.pT, z);
        return sb.toString();
    }
}
