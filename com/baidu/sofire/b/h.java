package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.F;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h {
    public static String a(Context context, String str, String str2, boolean z) {
        return a(context, str, str2, z, false);
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false, false);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) {
        byte[] bytes;
        String str3;
        String[] g = e.g(context);
        String str4 = g[0];
        String str5 = g[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a = o.a(str4 + valueOf + str5);
        byte[] a2 = com.baidu.sofire.core.i.a();
        new StringBuilder("after get aesKey:").append(new String(a2));
        com.baidu.sofire.b.a();
        if (TextUtils.isEmpty(str2)) {
            bytes = "".getBytes();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder("afterGzipPostBody,length=").append(byteArray.length);
            com.baidu.sofire.b.a();
            bytes = F.getInstance().ae(byteArray, a2);
        }
        new StringBuilder("afterEncryptPostBody length=").append(bytes.length).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(new String(bytes));
        com.baidu.sofire.b.a();
        byte[] bytes2 = o.a(g.a(context)).getBytes();
        new StringBuilder("afterLoadRc4Key:").append(new String(bytes2));
        com.baidu.sofire.b.a();
        byte[] re = F.getInstance().re(a2, bytes2);
        new StringBuilder("after ar:sKey length=").append(re.length);
        com.baidu.sofire.b.a();
        String encodeToString = Base64.encodeToString(re, 0);
        com.baidu.sofire.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("/100/").append(str4).append("/").append(valueOf).append("/").append(a);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb.append("?skey=").append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.sofire.b.a();
        try {
            if (z2) {
                str3 = new m(context).a(sb.toString());
            } else {
                str3 = new m(context).a(sb.toString(), bytes);
            }
        } catch (Throwable th) {
            str3 = "";
            e.a();
        }
        com.baidu.sofire.b.a();
        if (!z || !TextUtils.isEmpty(str3)) {
            JSONObject jSONObject = new JSONObject(str3);
            String optString = jSONObject.optString("skey");
            com.baidu.sofire.b.a();
            byte[] decode = Base64.decode(optString, 0);
            new StringBuilder("after Base64 decode:server aeskey size=").append(decode.length);
            com.baidu.sofire.b.a();
            byte[] rd = F.getInstance().rd(decode, bytes2);
            new StringBuilder("after dr aes key:size=").append(new String(rd));
            com.baidu.sofire.b.a();
            String optString2 = jSONObject.optString("response");
            jSONObject.optString("request_id");
            com.baidu.sofire.b.a();
            com.baidu.sofire.b.a();
            byte[] decode2 = Base64.decode(optString2, 0);
            new StringBuilder("after Base64 decode:server aeskey size=").append(decode2.length);
            com.baidu.sofire.b.a();
            byte[] ad = F.getInstance().ad(decode2, rd);
            if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                e.j(context);
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
                eVar.i();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (e.e(context)) {
                    hashMap.put("0", Integer.valueOf(eVar.k() + 1));
                    hashMap.put("1", Integer.valueOf(eVar.l()));
                } else {
                    hashMap.put("0", Integer.valueOf(eVar.k()));
                    hashMap.put("1", Integer.valueOf(eVar.l() + 1));
                }
                eVar.c.putInt("mo_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.c.putInt("wi_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.i();
                e.a(context, "1003112", hashMap);
            } else if (e.e(context)) {
                eVar.a(eVar.k() + 1);
            } else {
                eVar.b(eVar.l() + 1);
            }
        } catch (Throwable th2) {
            e.a();
        }
        throw new NetworkErrorException("response is empty");
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
                        jSONObject.put("sign", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        com.baidu.sofire.b.a();
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
            com.baidu.sofire.b.a();
            String a2 = a(context, e.b() + "p/1/auh", jSONObject2, false);
            com.baidu.sofire.b.a();
            JSONObject jSONObject3 = new JSONObject(a2);
            if (jSONObject3.length() > 0) {
                int optInt = jSONObject3.optInt("code");
                com.baidu.sofire.b.a();
                if (optInt == 200) {
                    String optString = jSONObject3.optString("ak");
                    String optString2 = jSONObject3.optString("sk");
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        return false;
                    }
                    com.baidu.sofire.core.d a3 = com.baidu.sofire.core.d.a(context);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!"3".equals(optString) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(optString2))) {
                        e.a(optString, optString2);
                        com.baidu.sofire.e eVar = a3.a;
                        eVar.c.putString("svi_n", optString + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString2);
                        eVar.c.commit();
                    }
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            new StringBuilder("key redress exception ").append(th.toString());
            com.baidu.sofire.b.a();
            e.a();
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr3[i] = (byte) i;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i2 = (i2 + (bArr2[i3] & 255) + (bArr3[i4] & 255)) & 255;
                byte b = bArr3[i4];
                bArr3[i4] = bArr3[i2];
                bArr3[i2] = b;
                i3 = (i3 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i6 = (i6 + 1) & 255;
            i5 = (i5 + (bArr3[i6] & 255)) & 255;
            byte b2 = bArr3[i6];
            bArr3[i6] = bArr3[i5];
            bArr3[i5] = b2;
            bArr4[i7] = (byte) (bArr3[((bArr3[i6] & 255) + (bArr3[i5] & 255)) & 255] ^ bArr[i7]);
            bArr4[i7] = (byte) (bArr4[i7] ^ 42);
        }
        return bArr4;
    }
}
