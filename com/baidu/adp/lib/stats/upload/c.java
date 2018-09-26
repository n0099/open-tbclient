package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class c {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.stats.c cVar) {
        if (aVar.jV() != null && (aVar.jV().equals("omp") || aVar.jV().equals("mon"))) {
            return a(cVar);
        }
        return a(true, cVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.stats.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", cVar.mAppVersion);
        a(hashMap, "_phone_imei", cVar.Du);
        a(hashMap, "_client_id", cVar.Dr);
        a(hashMap, "subapp_type", cVar.Dv);
        a(hashMap, "from", cVar.mChannel);
        a(hashMap, "net_type", cVar.Dz);
        a(hashMap, "cuid", cVar.mCuid);
        a(hashMap, "model", cVar.Dw);
        if (TextUtils.isEmpty(cVar.mUid)) {
            cVar.mUid = "0";
        }
        a(hashMap, "uid", cVar.mUid);
        a(hashMap, "un", cVar.Dx);
        a(hashMap, "BDUSS", cVar.Dy);
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
            sb.append(URLEncoder.encode(cVar.Do, IoUtils.UTF_8));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.Dp, IoUtils.UTF_8));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.mAppVersion, IoUtils.UTF_8));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append(HttpConstants.OS_TYPE_VALUE);
            sb.append("&");
            sb.append(StatisticConstants.OS_VERSION);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.DA, IoUtils.UTF_8));
            if (!TextUtils.isEmpty(cVar.mChannel)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mChannel, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Dq)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.Dq, IoUtils.UTF_8));
            }
            sb.append("&");
            sb.append(ISapiAccount.SAPI_ACCOUNT_PHONE);
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.Dw, IoUtils.UTF_8));
            if (!TextUtils.isEmpty(cVar.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mUid, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Dr)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.Dr, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Du)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.Du, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.Dx)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.Dx, IoUtils.UTF_8));
            }
            if (!TextUtils.isEmpty(cVar.mCuid)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.mCuid, IoUtils.UTF_8));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
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
                StringBuilder append = sb.append("&").append(str).append("=");
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
        a(sb, "_phone_imei", cVar.Du, z);
        a(sb, "_client_id", cVar.Dr, z);
        a(sb, "subapp_type", cVar.Dv, z);
        a(sb, StatisticConstants.OS_VERSION, cVar.DA, z);
        a(sb, "from", cVar.mChannel, z);
        a(sb, "cfrom", cVar.Dq, z);
        a(sb, "net_type", cVar.Dz, z);
        a(sb, "cuid", cVar.mCuid, z);
        a(sb, "model", cVar.Dw, z);
        if (TextUtils.isEmpty(cVar.mUid)) {
            a(sb, "uid", "0", z);
        } else {
            a(sb, "uid", cVar.mUid, z);
        }
        a(sb, "un", cVar.Dx, z);
        return sb.toString();
    }
}
