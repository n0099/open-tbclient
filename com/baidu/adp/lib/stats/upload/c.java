package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class c {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.kh() != null && (aVar.kh().equals("omp") || aVar.kh().equals("mon"))) {
            return a(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.Eh);
        a(hashMap, "_client_id", cVar.Ee);
        a(hashMap, "subapp_type", cVar.Ei);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, ETAG.KEY_NET_TYPE, cVar.Em);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.Ej);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.Ek);
        a(hashMap, "BDUSS", cVar.El);
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
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Eb, IoUtils.UTF_8));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("sub_sys");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Ec, IoUtils.UTF_8));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("version");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.mAppVersion, IoUtils.UTF_8));
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("os");
            sb.append(ETAG.EQUAL);
            sb.append(HttpConstants.OS_TYPE_VALUE);
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(StatisticConstants.OS_VERSION);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.En, IoUtils.UTF_8));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("from");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mChannel, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Ed)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("cfrom");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Ed, IoUtils.UTF_8));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(ISapiAccount.SAPI_ACCOUNT_PHONE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.Ej, IoUtils.UTF_8));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("uid");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mUid, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Ee)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("client_id");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Ee, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Eh)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("imei");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Eh, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Ek)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("uname");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.Ek, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.mCuid)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("cuid");
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(cVar.mCuid, IoUtils.UTF_8));
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("net");
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(cVar.mNetType, IoUtils.UTF_8));
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
                    str3 = URLEncoder.encode(str3, IoUtils.UTF_8);
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
        a(sb, "_phone_imei", cVar.Eh, z);
        a(sb, "_client_id", cVar.Ee, z);
        a(sb, "subapp_type", cVar.Ei, z);
        a(sb, StatisticConstants.OS_VERSION, cVar.En, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, "cfrom", cVar.Ed, z);
        a(sb, ETAG.KEY_NET_TYPE, cVar.Em, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.Ej, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.Ek, z);
        return sb.toString();
    }
}
