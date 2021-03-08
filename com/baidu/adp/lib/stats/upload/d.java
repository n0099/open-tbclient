package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class d {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.ni() != null && (aVar.ni().equals(BdStatsConstant.FILE_OMP) || aVar.ni().equals(BdStatsConstant.FILE_MON))) {
            return c(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.mIMEI);
        a(hashMap, "_client_id", cVar.PI);
        a(hashMap, "subapp_type", cVar.PN);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.PQ);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.PO);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.PP);
        a(hashMap, "BDUSS", cVar.mBduss);
        if (z) {
            a(hashMap, "find_bug", "2");
        } else {
            a(hashMap, "find_bug", "0");
        }
        a(hashMap, "sz", cVar.PT);
        a(hashMap, "cua", cVar.PU);
        a(hashMap, "bdid", cVar.Qb);
        a(hashMap, "cookie", cVar.mBduss);
        a(hashMap, "oaid", cVar.PV);
        a(hashMap, "mac", cVar.PW);
        a(hashMap, "android_id", cVar.mAndroidId);
        a(hashMap, "utbrand", cVar.PY);
        a(hashMap, "baiduapppb_ut", cVar.PZ);
        a(hashMap, "user_agent", cVar.Qa);
        a(hashMap, "active_timestamp", cVar.Qc);
        a(hashMap, "first_install_time", cVar.Qd);
        a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, cVar.Qe);
        a(hashMap, "event_day", cVar.Qf);
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
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mProduct, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(BdStatsConstant.StatsKey.SUB_SYSTEM);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.PG, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mAppVersion, "utf-8"));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("os");
            sb.append("=");
            sb.append(HttpConstants.OS_TYPE_VALUE);
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.PR, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mChannel, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.PH)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(BdStatsConstant.StatsKey.CURRENT_CHANNEL);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.PH, "utf-8"));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.PO, "utf-8"));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.PI)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.PI, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.mIMEI)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mIMEI, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.PP)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(BdStatsConstant.StatsKey.UNAME);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.PP, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.mCuid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mCuid, "utf-8"));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
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
                StringBuilder append = sb.append(ETAG.ITEM_SEPARATOR).append(str).append("=");
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
        a(sb, "_phone_imei", cVar.mIMEI, z);
        a(sb, "_client_id", cVar.PI, z);
        a(sb, "subapp_type", cVar.PN, z);
        a(sb, "os_version", cVar.PR, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, BdStatsConstant.StatsKey.CURRENT_CHANNEL, cVar.PH, z);
        a(sb, "net_type", cVar.PQ, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.PO, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.PP, z);
        a(sb, "utbrand", cVar.PY, z);
        return sb.toString();
    }
}
