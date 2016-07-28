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
        if (aVar.eB() != null && (aVar.eB().equals("omp") || aVar.eB().equals("mon"))) {
            return a(fVar);
        }
        return a(true, fVar);
    }

    public static HashMap<String, Object> a(f fVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", fVar.mAppVersion);
        a(hashMap, "_phone_imei", fVar.ny);
        a(hashMap, "_client_id", fVar.mClientId);
        a(hashMap, "subapp_type", fVar.nz);
        a(hashMap, "from", fVar.nw);
        a(hashMap, "net_type", fVar.nD);
        a(hashMap, SocialConstants.PARAM_CUID, fVar.mCuid);
        a(hashMap, "model", fVar.nA);
        if (TextUtils.isEmpty(fVar.mUid)) {
            fVar.mUid = "0";
        }
        a(hashMap, "uid", fVar.mUid);
        a(hashMap, "un", fVar.nB);
        a(hashMap, "BDUSS", fVar.nC);
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
            sb.append(URLEncoder.encode(fVar.nu, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.nv, "utf-8"));
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
            sb.append(URLEncoder.encode(fVar.nE, "utf-8"));
            if (!TextUtils.isEmpty(fVar.nw)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.nw, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.nx)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.nx, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(fVar.nA, "utf-8"));
            if (!TextUtils.isEmpty(fVar.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.ny)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.ny, "utf-8"));
            }
            if (!TextUtils.isEmpty(fVar.nB)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(fVar.nB, "utf-8"));
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d4  */
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
        String str2 = fVar.mAppVersion;
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
                a(sb, "_phone_imei", fVar.ny, z);
                a(sb, "_client_id", fVar.mClientId, z);
                a(sb, "subapp_type", fVar.nz, z);
                a(sb, "os_version", fVar.nE, z);
                a(sb, "from", fVar.nw, z);
                a(sb, "cfrom", fVar.nx, z);
                a(sb, "net_type", fVar.nD, z);
                a(sb, SocialConstants.PARAM_CUID, fVar.mCuid, z);
                a(sb, "model", fVar.nA, z);
                if (!TextUtils.isEmpty(fVar.mUid)) {
                    a(sb, "uid", "0", z);
                } else {
                    a(sb, "uid", fVar.mUid, z);
                }
                a(sb, "un", fVar.nB, z);
                a(sb, "BDUSS", fVar.nC, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", fVar.ny, z);
        a(sb, "_client_id", fVar.mClientId, z);
        a(sb, "subapp_type", fVar.nz, z);
        a(sb, "os_version", fVar.nE, z);
        a(sb, "from", fVar.nw, z);
        a(sb, "cfrom", fVar.nx, z);
        a(sb, "net_type", fVar.nD, z);
        a(sb, SocialConstants.PARAM_CUID, fVar.mCuid, z);
        a(sb, "model", fVar.nA, z);
        if (!TextUtils.isEmpty(fVar.mUid)) {
        }
        a(sb, "un", fVar.nB, z);
        a(sb, "BDUSS", fVar.nC, z);
        return sb.toString();
    }
}
