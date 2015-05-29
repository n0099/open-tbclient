package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.game.GameInfoData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String a(com.baidu.adp.lib.stats.base.a aVar, com.baidu.adp.lib.h.e eVar) {
        if (aVar.getPostFileName() != null && aVar.getPostFileName().equals("omp") && aVar.ig().equals("stat")) {
            return b(true, eVar);
        }
        if (aVar.getPostFileName() != null && aVar.getPostFileName().equals("omp")) {
            return b(eVar);
        }
        return a(true, eVar);
    }

    public static HashMap<String, Object> a(com.baidu.adp.lib.h.e eVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, "_client_type", "2");
        a(hashMap, "_client_version", eVar.wp);
        a(hashMap, "_phone_imei", eVar.wq);
        a(hashMap, "_client_id", eVar.mClientId);
        a(hashMap, "subapp_type", eVar.wr);
        a(hashMap, "from", eVar.wi);
        a(hashMap, "net_type", eVar.ws);
        a(hashMap, "cuid", eVar.mCuid);
        a(hashMap, "model", eVar.xF);
        if (TextUtils.isEmpty(eVar.mUid)) {
            eVar.mUid = GameInfoData.NOT_FROM_DETAIL;
        }
        a(hashMap, "uid", eVar.mUid);
        a(hashMap, "un", eVar.wj);
        a(hashMap, "BDUSS", eVar.wk);
        a(hashMap, "find_bug", "1");
        return hashMap;
    }

    private static void a(HashMap<String, Object> hashMap, String str, String str2) {
        if (hashMap != null && str != null && str2 != null) {
            hashMap.put(str, str2);
        }
    }

    private static String b(com.baidu.adp.lib.h.e eVar) {
        if (eVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wg, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wh, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wp, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.wm, "utf-8"));
            if (!TextUtils.isEmpty(eVar.wi)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wi, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(eVar.xF, "utf-8"));
            if (!TextUtils.isEmpty(eVar.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.wq)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wq, "utf-8"));
            }
            if (!TextUtils.isEmpty(eVar.wj)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wj, "utf-8"));
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(boolean z, com.baidu.adp.lib.h.e eVar) {
        String str;
        String[] split;
        if (eVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = eVar.wp;
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
                a(sb, "_phone_imei", eVar.wq, z);
                a(sb, "_client_id", eVar.mClientId, z);
                if (!TextUtils.isEmpty(eVar.wr)) {
                    a(sb, "subapp_type", eVar.wr, z);
                }
                a(sb, "from", eVar.wi, z);
                a(sb, "net_type", eVar.ws, z);
                a(sb, "cuid", eVar.mCuid, z);
                a(sb, "model", eVar.xF, z);
                if (!TextUtils.isEmpty(eVar.mUid)) {
                    a(sb, "uid", GameInfoData.NOT_FROM_DETAIL, z);
                } else {
                    a(sb, "uid", eVar.mUid, z);
                }
                a(sb, "un", eVar.wj, z);
                a(sb, "BDUSS", eVar.wk, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", eVar.wq, z);
        a(sb, "_client_id", eVar.mClientId, z);
        if (!TextUtils.isEmpty(eVar.wr)) {
        }
        a(sb, "from", eVar.wi, z);
        a(sb, "net_type", eVar.ws, z);
        a(sb, "cuid", eVar.mCuid, z);
        a(sb, "model", eVar.xF, z);
        if (!TextUtils.isEmpty(eVar.mUid)) {
        }
        a(sb, "un", eVar.wj, z);
        a(sb, "BDUSS", eVar.wk, z);
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:4|(2:6|(22:8|9|10|(1:12)|13|14|(1:16)|17|(1:19)(1:40)|20|21|22|(1:24)|25|(1:27)|28|(1:30)|31|(1:33)|34|35|36))|44|14|(0)|17|(0)(0)|20|21|22|(0)|25|(0)|28|(0)|31|(0)|34|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x020a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x020b, code lost:
        com.baidu.adp.lib.util.BdLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0141 A[Catch: UnsupportedEncodingException -> 0x020a, TryCatch #1 {UnsupportedEncodingException -> 0x020a, blocks: (B:21:0x00c2, B:23:0x0141, B:24:0x015b, B:26:0x017d, B:27:0x0197, B:29:0x019f, B:30:0x01b9, B:32:0x01c1, B:33:0x01db), top: B:43:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017d A[Catch: UnsupportedEncodingException -> 0x020a, TryCatch #1 {UnsupportedEncodingException -> 0x020a, blocks: (B:21:0x00c2, B:23:0x0141, B:24:0x015b, B:26:0x017d, B:27:0x0197, B:29:0x019f, B:30:0x01b9, B:32:0x01c1, B:33:0x01db), top: B:43:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x019f A[Catch: UnsupportedEncodingException -> 0x020a, TryCatch #1 {UnsupportedEncodingException -> 0x020a, blocks: (B:21:0x00c2, B:23:0x0141, B:24:0x015b, B:26:0x017d, B:27:0x0197, B:29:0x019f, B:30:0x01b9, B:32:0x01c1, B:33:0x01db), top: B:43:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01c1 A[Catch: UnsupportedEncodingException -> 0x020a, TryCatch #1 {UnsupportedEncodingException -> 0x020a, blocks: (B:21:0x00c2, B:23:0x0141, B:24:0x015b, B:26:0x017d, B:27:0x0197, B:29:0x019f, B:30:0x01b9, B:32:0x01c1, B:33:0x01db), top: B:43:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(boolean z, com.baidu.adp.lib.h.e eVar) {
        String str;
        String[] split;
        if (eVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = eVar.wp;
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
                a(sb, "_phone_imei", eVar.wq, z);
                a(sb, "_client_id", eVar.mClientId, z);
                if (!TextUtils.isEmpty(eVar.wr)) {
                    a(sb, "subapp_type", eVar.wr, z);
                }
                a(sb, "from", eVar.wi, z);
                a(sb, "net_type", eVar.ws, z);
                a(sb, "cuid", eVar.mCuid, z);
                a(sb, "model", eVar.xF, z);
                if (!TextUtils.isEmpty(eVar.mUid)) {
                    a(sb, "uid", GameInfoData.NOT_FROM_DETAIL, z);
                } else {
                    a(sb, "uid", eVar.mUid, z);
                }
                a(sb, "un", eVar.wj, z);
                a(sb, "BDUSS", eVar.wk, z);
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wg, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wh, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wp, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append("os_version");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.wm, "utf-8"));
                if (!TextUtils.isEmpty(eVar.wi)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(eVar.wi, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.xF, "utf-8"));
                if (!TextUtils.isEmpty(eVar.mClientId)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(eVar.mClientId, "utf-8"));
                }
                if (!TextUtils.isEmpty(eVar.wq)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(eVar.wq, "utf-8"));
                }
                if (!TextUtils.isEmpty(eVar.wj)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(eVar.wj, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(eVar.mNetType, "utf-8"));
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", eVar.wq, z);
        a(sb, "_client_id", eVar.mClientId, z);
        if (!TextUtils.isEmpty(eVar.wr)) {
        }
        a(sb, "from", eVar.wi, z);
        a(sb, "net_type", eVar.ws, z);
        a(sb, "cuid", eVar.mCuid, z);
        a(sb, "model", eVar.xF, z);
        if (!TextUtils.isEmpty(eVar.mUid)) {
        }
        a(sb, "un", eVar.wj, z);
        a(sb, "BDUSS", eVar.wk, z);
        sb.append("product");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.wg, "utf-8"));
        sb.append("&");
        sb.append("sub_sys");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.wh, "utf-8"));
        sb.append("&");
        sb.append("version");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.wp, "utf-8"));
        sb.append("&");
        sb.append("os");
        sb.append("=");
        sb.append("android");
        sb.append("&");
        sb.append("os_version");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.wm, "utf-8"));
        if (!TextUtils.isEmpty(eVar.wi)) {
        }
        sb.append("&");
        sb.append("phone");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.xF, "utf-8"));
        if (!TextUtils.isEmpty(eVar.mClientId)) {
        }
        if (!TextUtils.isEmpty(eVar.wq)) {
        }
        if (!TextUtils.isEmpty(eVar.wj)) {
        }
        sb.append("&");
        sb.append("net");
        sb.append("=");
        sb.append(URLEncoder.encode(eVar.mNetType, "utf-8"));
        return sb.toString();
    }
}
