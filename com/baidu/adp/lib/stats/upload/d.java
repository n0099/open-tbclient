package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class d {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.lL() != null && (aVar.lL().equals(BdStatsConstant.FILE_OMP) || aVar.lL().equals(BdStatsConstant.FILE_MON))) {
            return c(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.Lw);
        a(hashMap, "_client_id", cVar.Lt);
        a(hashMap, "subapp_type", cVar.Lx);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.LA);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.Ly);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.Lz);
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

    private static String c(com.baidu.adp.lib.stats.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Lq, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(BdStatsConstant.StatsKey.SUB_SYSTEM);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Lr, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("version");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.mAppVersion, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("os");
            sb.append(ETAG.EQUAL);
            sb.append("android");
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("os_version");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.LB, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("from");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mChannel, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.Ls)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(BdStatsConstant.StatsKey.CURRENT_CHANNEL);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Ls, "utf-8"));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("phone");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Ly, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("uid");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.Lt)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("client_id");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Lt, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.Lw)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("imei");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Lw, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.Lz)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(BdStatsConstant.StatsKey.UNAME);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Lz, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.mCuid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("cuid");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mCuid, "utf-8"));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("net");
            sb.append(ETAG.EQUAL);
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
                StringBuilder append = sb.append(ETAG.ITEM_SEPARATOR).append(str).append(ETAG.EQUAL);
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
        a(sb, "_phone_imei", cVar.Lw, z);
        a(sb, "_client_id", cVar.Lt, z);
        a(sb, "subapp_type", cVar.Lx, z);
        a(sb, "os_version", cVar.LB, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, BdStatsConstant.StatsKey.CURRENT_CHANNEL, cVar.Ls, z);
        a(sb, "net_type", cVar.LA, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.Ly, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.Lz, z);
        return sb.toString();
    }
}
