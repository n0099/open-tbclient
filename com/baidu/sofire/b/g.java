package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.jni.Asc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3) throws Throwable {
        byte[] bytes;
        String encodeToString;
        String str4;
        String[] e = d.e(context);
        String str5 = e[0];
        String str6 = e[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a = l.a(str5 + valueOf + str6);
        Asc asc = new Asc();
        byte[] a2 = com.baidu.sofire.core.g.a();
        new StringBuilder().append(new String(a2));
        if (TextUtils.isEmpty(str2)) {
            bytes = "".getBytes();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            i.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder().append(byteArray.length);
            bytes = F.getInstance().ae(byteArray, a2);
        }
        new StringBuilder().append(bytes.length).append(",").append(new String(bytes));
        byte[] bytes2 = l.a(f.a(context)).getBytes();
        new StringBuilder().append(new String(bytes2));
        byte[] ar = asc.ar(a2, bytes2);
        new StringBuilder().append(ar.length);
        new StringBuilder().append(Base64.encodeToString(ar, 0));
        String str7 = "sign=" + a + "&appkey=" + str5 + "&timestamp=" + valueOf + "&skey=" + URLEncoder.encode(encodeToString, IoUtils.UTF_8);
        if (!TextUtils.isEmpty(str3)) {
            str7 = str7 + str3;
        }
        new StringBuilder().append(str).append(" - ").append(str7);
        try {
            if (z2) {
                str4 = new k(context).a(str + "?" + str7);
            } else {
                str4 = new k(context).a(str + "?" + str7, bytes);
            }
        } catch (Throwable th) {
            d.a(th);
            str4 = "";
        }
        if (!z || !TextUtils.isEmpty(str4)) {
            JSONObject jSONObject = new JSONObject(str4);
            String optString = jSONObject.optString("skey");
            new StringBuilder().append(optString);
            byte[] decode = Base64.decode(optString, 0);
            new StringBuilder().append(decode.length);
            byte[] dr = asc.dr(decode, bytes2);
            new StringBuilder().append(new String(dr));
            String optString2 = jSONObject.optString("response");
            new StringBuilder().append(jSONObject.optString(StatisticConstants.REQUEST_ID));
            new StringBuilder().append(optString2);
            byte[] decode2 = Base64.decode(optString2, 0);
            new StringBuilder().append(decode2.length);
            byte[] ad = F.getInstance().ad(decode2, dr);
            if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                d.i(context);
                throw new NetworkErrorException("aes is fail");
            }
            return new String(ad);
        }
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            long currentTimeMillis = System.currentTimeMillis();
            long j = eVar.a.getLong("pu_cl_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                eVar.c.putLong("pu_cl_fd", System.currentTimeMillis());
                eVar.c.commit();
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
                eVar.c.putInt("mo_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.c.putInt("wi_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.c.putLong("pu_cl_fd", System.currentTimeMillis());
                eVar.c.commit();
                d.a(context, "1003112", hashMap);
            } else if (d.c(context)) {
                eVar.c.putInt("wi_fa_pu_ap", eVar.a.getInt("wi_fa_pu_cl", 0) + 1);
                eVar.c.commit();
            } else {
                eVar.c.putInt("mo_fa_pu_ap", eVar.a.getInt("mo_fa_pu_cl", 0) + 1);
                eVar.c.commit();
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        throw new NetworkErrorException("response is empty");
    }
}
