package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.sofire.ac.F;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static String a(Context context, String str, boolean z, boolean z2) {
        return a(context, str, "", z, z2, true, null);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) {
        return a(context, str, str2, z, z2, false, "");
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3) {
        return a(context, str, str2, z, z2, false, str3);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        byte[] bytes;
        String str4;
        String[] h = e.h(context);
        String str5 = h[0];
        String str6 = h[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a = o.a(str5 + valueOf + str6);
        byte[] a2 = com.baidu.sofire.core.i.a();
        com.baidu.sofire.b.a("after get aesKey:" + new String(a2));
        if (!TextUtils.isEmpty(str2)) {
            byte[] a3 = j.a(str2.getBytes());
            com.baidu.sofire.b.a("afterGzipPostBody,length=" + a3.length);
            bytes = F.getInstance().ae(a3, a2);
        } else {
            bytes = "".getBytes();
        }
        com.baidu.sofire.b.a("afterEncryptPostBody length=" + bytes.length + "," + new String(bytes));
        byte[] bytes2 = o.a(g.a(context)).getBytes();
        com.baidu.sofire.b.a("afterLoadRc4Key:" + new String(bytes2));
        byte[] re = F.getInstance().re(a2, bytes2);
        com.baidu.sofire.b.a("after ar:sKey length=" + re.length);
        String encodeToString = Base64.encodeToString(re, 0);
        com.baidu.sofire.b.a("after Base64:sKey=" + encodeToString);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("/").append("100").append("/").append(str5).append("/").append(valueOf).append("/").append(a);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb.append("?skey=").append(URLEncoder.encode(encodeToString, IoUtils.UTF_8));
        }
        com.baidu.sofire.b.a(sb.toString());
        try {
            if (z3) {
                str4 = new m(context, null).a(sb.toString());
            } else {
                str4 = new m(context, null).a(sb.toString(), bytes);
            }
        } catch (Throwable th) {
            e.a(th);
            str4 = "";
        }
        com.baidu.sofire.b.a("r:" + str4);
        if (z && TextUtils.isEmpty(str4)) {
            b(context);
            throw new NetworkErrorException("response is empty");
        } else if (z2) {
            JSONObject jSONObject = new JSONObject(str4);
            String optString = jSONObject.optString("skey");
            com.baidu.sofire.b.a("base sKey from server:" + optString);
            byte[] decode = Base64.decode(optString, 0);
            com.baidu.sofire.b.a("after Base64 decode:server aeskey size=" + decode.length);
            byte[] rd = F.getInstance().rd(decode, bytes2);
            com.baidu.sofire.b.a("after dr aes key:size=" + new String(rd));
            String optString2 = jSONObject.optString("response");
            com.baidu.sofire.b.a("plugins:requestId:" + jSONObject.optString(StatisticConstants.REQUEST_ID));
            com.baidu.sofire.b.a("plugins:response Base64:" + optString2);
            byte[] decode2 = Base64.decode(optString2, 0);
            com.baidu.sofire.b.a("after Base64 decode:server aeskey size=" + decode2.length);
            byte[] ad = F.getInstance().ad(decode2, rd);
            if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                e.k(context);
                throw new NetworkErrorException("aes is fail");
            }
            return new String(ad);
        } else {
            return str4;
        }
    }

    private static void b(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            if (System.currentTimeMillis() - eVar.n() > 86400000) {
                HashMap hashMap = new HashMap();
                if (e.f(context)) {
                    hashMap.put("0", Integer.valueOf(eVar.r() + 1));
                    hashMap.put("1", Integer.valueOf(eVar.s()));
                } else {
                    hashMap.put("0", Integer.valueOf(eVar.r()));
                    hashMap.put("1", Integer.valueOf(eVar.s() + 1));
                }
                eVar.e(0);
                eVar.d(0);
                eVar.o();
                e.a(context, "1003112", hashMap);
            } else if (e.f(context)) {
                eVar.b(eVar.r() + 1);
            } else {
                eVar.c(eVar.s() + 1);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i2 = (i2 + (bArr[i3] & 255) + (bArr2[i4] & 255)) & 255;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i2];
            bArr2[i2] = b;
            i3 = (i3 + 1) % bArr.length;
        }
        return bArr2;
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] a = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 = (i2 + 1) & 255;
            i = (i + (a[i2] & 255)) & 255;
            byte b = a[i2];
            a[i2] = a[i];
            a[i] = b;
            bArr3[i3] = (byte) (a[((a[i2] & 255) + (a[i] & 255)) & 255] ^ bArr[i3]);
            bArr3[i3] = (byte) (bArr3[i3] ^ 42);
        }
        return bArr3;
    }

    public static boolean a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a != null) {
                    byte[] encoded = a.getEncoded();
                    if (encoded != null) {
                        e.a(context, encoded);
                        String a2 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                        jSONObject.put("sign", a2);
                        com.baidu.sofire.b.a("nsm=" + a2);
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put("app", e.e(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
            } else {
                jSONObject.put("sign", "");
                jSONObject.put("app", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.sofire.b.a(jSONObject2);
            String a3 = a(context, e.e(context) + "p/1/auh", jSONObject2, false, true);
            com.baidu.sofire.b.a("list:after java decrypt ResponseDataJsonString=" + a3);
            JSONObject jSONObject3 = new JSONObject(a3);
            if (jSONObject3 != null && jSONObject3.length() > 0) {
                int optInt = jSONObject3.optInt("code");
                com.baidu.sofire.b.a("key redress code " + optInt);
                if (optInt == 200) {
                    String optString = jSONObject3.optString("ak");
                    String optString2 = jSONObject3.optString("sk");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        com.baidu.sofire.core.d.a(context).b(optString, optString2);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.a("key redress exception " + th.toString());
            e.a(th);
        }
        return false;
    }
}
