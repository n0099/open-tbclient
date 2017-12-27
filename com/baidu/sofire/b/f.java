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
    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3) throws Throwable {
        String str4;
        String str5;
        byte[] bytes;
        String encodeToString;
        String str6;
        String[] e = d.e(context);
        if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
            str4 = e[0];
            str5 = e[1];
        } else {
            str4 = "3";
            str5 = "925fc15df8a49bed0b3eca8d2b44cb7b";
        }
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a = j.a(str4 + valueOf + str5);
        Asc asc = new Asc();
        byte[] a2 = com.baidu.sofire.core.g.a();
        new StringBuilder().append(new String(a2));
        if (TextUtils.isEmpty(str2)) {
            bytes = "".getBytes();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h.e(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder().append(byteArray.length);
            bytes = F.getInstance().ae(byteArray, a2);
        }
        new StringBuilder().append(bytes.length).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(new String(bytes));
        byte[] bytes2 = j.a(e.a(context)).getBytes();
        new StringBuilder().append(new String(bytes2));
        byte[] ar = asc.ar(a2, bytes2);
        new StringBuilder().append(ar.length);
        new StringBuilder().append(Base64.encodeToString(ar, 0));
        String str7 = "sign=" + a + "&appkey=" + str4 + "&timestamp=" + valueOf + "&skey=" + URLEncoder.encode(encodeToString, "utf-8");
        if (!TextUtils.isEmpty(str3)) {
            str7 = str7 + str3;
        }
        new StringBuilder().append(str).append(" - ").append(str7);
        try {
            if (z2) {
                str6 = new i(context).a(str + "?" + str7);
            } else {
                str6 = new i(context).g(str + "?" + str7, bytes);
            }
        } catch (Throwable th) {
            d.a(th);
            str6 = "";
        }
        if (!z || !TextUtils.isEmpty(str6)) {
            JSONObject jSONObject = new JSONObject(str6);
            String optString = jSONObject.optString("skey");
            new StringBuilder().append(optString);
            byte[] decode = Base64.decode(optString, 0);
            new StringBuilder().append(decode.length);
            byte[] dr = asc.dr(decode, bytes2);
            new StringBuilder().append(new String(dr));
            String optString2 = jSONObject.optString("response");
            new StringBuilder().append(jSONObject.optString("request_id"));
            new StringBuilder().append(optString2);
            byte[] decode2 = Base64.decode(optString2, 0);
            new StringBuilder().append(decode2.length);
            byte[] ad = F.getInstance().ad(decode2, dr);
            if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                d.g(context);
                throw new NetworkErrorException("aes is fail");
            }
            return new String(ad);
        }
        try {
            com.baidu.sofire.d dVar = new com.baidu.sofire.d(context);
            long currentTimeMillis = System.currentTimeMillis();
            long j = dVar.a.getLong("pu_cl_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                dVar.c.putLong("pu_cl_fd", System.currentTimeMillis());
                dVar.c.commit();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (d.c(context)) {
                    hashMap.put("0", Integer.valueOf(dVar.a.getInt("wi_fa_pu_cl", 0) + 1));
                    hashMap.put("1", Integer.valueOf(dVar.a.getInt("mo_fa_pu_cl", 0)));
                } else {
                    hashMap.put("0", Integer.valueOf(dVar.a.getInt("wi_fa_pu_cl", 0)));
                    hashMap.put("1", Integer.valueOf(dVar.a.getInt("mo_fa_pu_cl", 0) + 1));
                }
                dVar.c.putInt("mo_fa_pu_cl", 0);
                dVar.c.commit();
                dVar.c.putInt("wi_fa_pu_cl", 0);
                dVar.c.commit();
                dVar.c.putLong("pu_cl_fd", System.currentTimeMillis());
                dVar.c.commit();
                d.a(context, "1013104", hashMap);
            } else if (d.c(context)) {
                dVar.c.putInt("wi_fa_pu_ap", dVar.a.getInt("wi_fa_pu_cl", 0) + 1);
                dVar.c.commit();
            } else {
                dVar.c.putInt("mo_fa_pu_ap", dVar.a.getInt("mo_fa_pu_cl", 0) + 1);
                dVar.c.commit();
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        throw new NetworkErrorException("response is empty");
    }
}
