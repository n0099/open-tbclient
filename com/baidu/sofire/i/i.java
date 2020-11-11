package com.baidu.sofire.i;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.sofire.ac.F;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class i {
    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        return b(context, str, str2, z, z2);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02d9: ARRAY_LENGTH  (r4v3 int A[REMOVE]) = (r2v10 byte[]))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x02e8: ARRAY_LENGTH  (r4v4 int A[REMOVE]) = (r1v24 byte[]))] */
    private static String b(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        byte[] bytes;
        String str3;
        String[] g = e.g(context);
        String str4 = g[0];
        String str5 = g[1];
        if ("com.baidu.input_huawei".equals(context.getPackageName()) && !new com.baidu.sofire.e(context).A()) {
            throw new NetworkErrorException("conn is blocked");
        }
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a2 = p.a(str4 + valueOf + str5);
        byte[] a3 = com.baidu.sofire.core.h.a();
        new StringBuilder().append(new String(a3));
        com.baidu.sofire.b.a();
        if (TextUtils.isEmpty(str2)) {
            bytes = "".getBytes();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder().append(byteArray.length);
            com.baidu.sofire.b.a();
            bytes = F.getInstance().ae(byteArray, a3);
        }
        new StringBuilder().append(bytes.length).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(str2);
        com.baidu.sofire.b.a();
        byte[] bytes2 = p.a(h.b(context)).getBytes();
        new StringBuilder().append(bytes2 == null ? 0 : bytes2.length);
        com.baidu.sofire.b.a();
        byte[] re = F.getInstance().re(a3, bytes2);
        new StringBuilder().append(re.length);
        com.baidu.sofire.b.a();
        String encodeToString = Base64.encodeToString(re, 0);
        new StringBuilder().append(encodeToString);
        com.baidu.sofire.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("/100/").append(str4).append("/").append(valueOf).append("/").append(a2);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb.append("?skey=").append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.sofire.b.a();
        try {
            if (r.a(context)) {
                str3 = new r(context).a(sb.toString(), bytes);
            } else {
                str3 = new n(context).a(sb.toString(), bytes);
            }
        } catch (Throwable th) {
            str3 = "";
            e.a();
        }
        com.baidu.sofire.b.a();
        if (!z || !TextUtils.isEmpty(str3)) {
            if (z2) {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("skey");
                new StringBuilder().append(optString);
                com.baidu.sofire.b.a();
                byte[] decode = Base64.decode(optString, 0);
                new StringBuilder().append(decode.length);
                com.baidu.sofire.b.a();
                byte[] rd = F.getInstance().rd(decode, bytes2);
                new StringBuilder().append(rd == null ? "null" : new StringBuilder().append(rd.length).toString());
                com.baidu.sofire.b.a();
                String optString2 = jSONObject.optString(IIntercepter.TYPE_RESPONSE);
                new StringBuilder().append(jSONObject.optString("request_id"));
                com.baidu.sofire.b.a();
                new StringBuilder().append(optString2);
                com.baidu.sofire.b.a();
                byte[] decode2 = Base64.decode(optString2, 0);
                new StringBuilder().append(decode2 == null ? "null" : new StringBuilder().append(decode2.length).toString());
                com.baidu.sofire.b.a();
                byte[] ad = F.getInstance().ad(decode2, rd);
                if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                    e.h(context);
                    throw new NetworkErrorException("aes is fail");
                }
                return new String(ad);
            }
            return str3;
        }
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            long currentTimeMillis = System.currentTimeMillis();
            long j = eVar.f3621a.getLong("pu_cl_fd", 0L);
            if (j == 0) {
                j = System.currentTimeMillis();
                eVar.g();
            }
            if (currentTimeMillis - j > 86400000) {
                HashMap hashMap = new HashMap();
                if (e.e(context)) {
                    hashMap.put("0", Integer.valueOf(eVar.i() + 1));
                    hashMap.put("1", Integer.valueOf(eVar.j()));
                } else {
                    hashMap.put("0", Integer.valueOf(eVar.i()));
                    hashMap.put("1", Integer.valueOf(eVar.j() + 1));
                }
                eVar.c.putInt("mo_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.c.putInt("wi_fa_pu_cl", 0);
                eVar.c.commit();
                eVar.g();
                e.a(context, "1003112", hashMap);
            } else if (e.e(context)) {
                eVar.a(eVar.i() + 1);
            } else {
                eVar.b(eVar.j() + 1);
            }
        } catch (Throwable th2) {
            e.a();
        }
        throw new NetworkErrorException("response is empty");
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
