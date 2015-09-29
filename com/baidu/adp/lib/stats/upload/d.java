package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
class d {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, f fVar) {
        if (aVar.hW() != null && aVar.hW().equals("omp")) {
            return a(fVar);
        }
        return a(true, fVar);
    }

    public static HashMap<String, Object> a(f fVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", fVar.wa);
        a(hashMap, "_phone_imei", fVar.wn);
        a(hashMap, "_client_id", fVar.mClientId);
        a(hashMap, "subapp_type", fVar.wo);
        a(hashMap, "from", fVar.wm);
        a(hashMap, "net_type", fVar.wt);
        a(hashMap, SocialConstants.PARAM_CUID, fVar.mCuid);
        a(hashMap, "model", fVar.wp);
        if (TextUtils.isEmpty(fVar.wq)) {
            fVar.wq = "0";
        }
        a(hashMap, "uid", fVar.wq);
        a(hashMap, "un", fVar.wr);
        a(hashMap, "BDUSS", fVar.ws);
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
            sb.append(URLEncoder.encode(fVar.wk, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.wl, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.wa, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append(SocialConstants.ANDROID_CLIENT_TYPE);
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.wu, "utf-8"));
            if (!TextUtils.isEmpty(fVar.wm)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.wm, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.wp, "utf-8"));
            if (!TextUtils.isEmpty(fVar.wq)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.wq, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.wn)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.wn, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.wr)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.wr, "utf-8"));
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(boolean z, f fVar) {
        String str;
        String[] split;
        if (fVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = fVar.wa;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.split("\\.").length == 4) {
                str = String.valueOf(split[0]) + "." + split[1] + "." + split[2];
                try {
                    StringBuilder append = sb.append("&").append("new_four_version").append("=");
                    if (z) {
                        str2 = URLEncoder.encode(str2, "utf-8");
                    }
                    append.append(str2);
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(e);
                }
                a(sb, "_client_version", str, z);
                a(sb, "_phone_imei", fVar.wn, z);
                a(sb, "_client_id", fVar.mClientId, z);
                if (!TextUtils.isEmpty(fVar.wo)) {
                    a(sb, "subapp_type", fVar.wo, z);
                }
                a(sb, "from", fVar.wm, z);
                a(sb, "net_type", fVar.wt, z);
                a(sb, SocialConstants.PARAM_CUID, fVar.mCuid, z);
                a(sb, "model", fVar.wp, z);
                if (!TextUtils.isEmpty(fVar.wq)) {
                    a(sb, "uid", "0", z);
                } else {
                    a(sb, "uid", fVar.wq, z);
                }
                a(sb, "un", fVar.wr, z);
                a(sb, "BDUSS", fVar.ws, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", fVar.wn, z);
        a(sb, "_client_id", fVar.mClientId, z);
        if (!TextUtils.isEmpty(fVar.wo)) {
        }
        a(sb, "from", fVar.wm, z);
        a(sb, "net_type", fVar.wt, z);
        a(sb, SocialConstants.PARAM_CUID, fVar.mCuid, z);
        a(sb, "model", fVar.wp, z);
        if (!TextUtils.isEmpty(fVar.wq)) {
        }
        a(sb, "un", fVar.wr, z);
        a(sb, "BDUSS", fVar.ws, z);
        return sb.toString();
    }
}
