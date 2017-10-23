package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.jni.Asc;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x006f: ARRAY_LENGTH  (r5v13 int A[REMOVE]) = (r6v19 byte[]))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00cb: ARRAY_LENGTH  (r7v1 int A[REMOVE]) = (r4v1 byte[]))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02c3: ARRAY_LENGTH  (r4v4 int A[REMOVE]) = (r0v19 byte[]))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x031c: ARRAY_LENGTH  (r3v4 int A[REMOVE]) = (r1v17 byte[]))] */
    public static String a(Context context, String str, String str2, String str3, String str4, boolean z) throws Throwable {
        byte[] bytes;
        String encodeToString;
        String str5;
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a = j.a(str3 + valueOf + str4);
        Asc asc = new Asc();
        byte[] a2 = com.baidu.sofire.core.g.a();
        String str6 = new String(a2);
        com.baidu.sofire.b.a();
        if (!TextUtils.isEmpty(str2)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h.e(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder().append(byteArray.length).toString();
            com.baidu.sofire.b.a();
            bytes = F.getInstance().ae(byteArray, a2);
        } else {
            bytes = "".getBytes();
        }
        String str7 = bytes.length + Constants.ACCEPT_TIME_SEPARATOR_SP + new String(bytes);
        com.baidu.sofire.b.a();
        byte[] bytes2 = j.a(e.a(context)).getBytes();
        String str8 = new String(bytes2);
        com.baidu.sofire.b.a();
        byte[] ar = asc.ar(a2, bytes2);
        new StringBuilder().append(ar.length).toString();
        com.baidu.sofire.b.a();
        String str9 = Base64.encodeToString(ar, 0);
        com.baidu.sofire.b.a();
        String str10 = "sign=" + a + "&appkey=" + str3 + "&timestamp=" + valueOf + "&skey=" + URLEncoder.encode(encodeToString, "utf-8");
        String str11 = str + " - " + str10;
        com.baidu.sofire.b.a();
        try {
            str5 = new i(context).g(str + "?" + str10, bytes);
        } catch (Throwable th) {
            d.a(th);
            str5 = "";
        }
        String str12 = "r:" + str5;
        com.baidu.sofire.b.a();
        if (z && TextUtils.isEmpty(str5)) {
            try {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j = eVar.a.getLong("pu_cl_fd", 0L);
                if (j == 0) {
                    j = System.currentTimeMillis();
                    eVar.PS.putLong("pu_cl_fd", System.currentTimeMillis());
                    eVar.PS.commit();
                }
                if (currentTimeMillis - j > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (d.c(context)) {
                        hashMap.put("0", Integer.valueOf(eVar.a.getInt("wi_fa_pu_cl", 0) + 1));
                        hashMap.put("1", Integer.valueOf(eVar.a.getInt("mo_fa_pu_cl", 0)));
                    } else {
                        hashMap.put("0", Integer.valueOf(eVar.a.getInt("wi_fa_pu_cl", 0)));
                        hashMap.put("1", Integer.valueOf(eVar.a.getInt("mo_fa_pu_cl", 0) + 1));
                    }
                    eVar.PS.putInt("mo_fa_pu_cl", 0);
                    eVar.PS.commit();
                    eVar.PS.putInt("wi_fa_pu_cl", 0);
                    eVar.PS.commit();
                    eVar.PS.putLong("pu_cl_fd", System.currentTimeMillis());
                    eVar.PS.commit();
                    d.a(context, "1013104", hashMap);
                } else if (d.c(context)) {
                    eVar.PS.putInt("wi_fa_pu_ap", eVar.a.getInt("wi_fa_pu_cl", 0) + 1);
                    eVar.PS.commit();
                } else {
                    eVar.PS.putInt("mo_fa_pu_ap", eVar.a.getInt("mo_fa_pu_cl", 0) + 1);
                    eVar.PS.commit();
                }
            } catch (Throwable th2) {
                d.a(th2);
            }
            throw new NetworkErrorException("response is empty");
        }
        JSONObject jSONObject = new JSONObject(str5);
        String optString = jSONObject.optString("skey");
        String str13 = optString;
        com.baidu.sofire.b.a();
        byte[] decode = Base64.decode(optString, 0);
        new StringBuilder().append(decode.length).toString();
        com.baidu.sofire.b.a();
        byte[] dr = asc.dr(decode, bytes2);
        String str14 = new String(dr);
        com.baidu.sofire.b.a();
        String optString2 = jSONObject.optString("response");
        String str15 = jSONObject.optString("request_id");
        com.baidu.sofire.b.a();
        String str16 = optString2;
        com.baidu.sofire.b.a();
        byte[] decode2 = Base64.decode(optString2, 0);
        new StringBuilder().append(decode2.length).toString();
        com.baidu.sofire.b.a();
        byte[] ad = F.getInstance().ad(decode2, dr);
        if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
            d.g(context);
            throw new NetworkErrorException("aes is fail");
        }
        return new String(ad);
    }
}
