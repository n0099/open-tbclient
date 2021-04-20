package com.baidu.sofire.g;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sofire.ac.F;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g {
    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        return b(context, str, str2, z, z2);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0247: ARRAY_LENGTH  (r2v1 int A[REMOVE]) = (r12v4 byte[]))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0288: ARRAY_LENGTH  (r0v10 int A[REMOVE]) = (r11v7 byte[]))] */
    public static String b(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        byte[] bytes;
        String sb;
        String[] h2 = d.h(context);
        String str3 = h2[0];
        String str4 = h2[1];
        if ("com.baidu.input_huawei".equals(context.getPackageName()) && !new com.baidu.sofire.e(context).y()) {
            throw new NetworkErrorException("conn is blocked");
        }
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a2 = n.a(str3 + valueOf + str4);
        byte[] a3 = com.baidu.sofire.core.h.a();
        new StringBuilder().append(new String(a3));
        com.baidu.sofire.b.a();
        String str5 = "";
        if (!TextUtils.isEmpty(str2)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            i.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            new StringBuilder().append(byteArray.length);
            com.baidu.sofire.b.a();
            bytes = F.getInstance().ae(byteArray, a3);
        } else {
            bytes = "".getBytes();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bytes.length);
        sb2.append(",");
        sb2.append(str2);
        com.baidu.sofire.b.a();
        byte[] bytes2 = n.a(f.b(context)).getBytes();
        new StringBuilder().append(bytes2 == null ? 0 : bytes2.length);
        com.baidu.sofire.b.a();
        byte[] re = F.getInstance().re(a3, bytes2);
        new StringBuilder().append(re.length);
        com.baidu.sofire.b.a();
        String encodeToString = Base64.encodeToString(re, 0);
        new StringBuilder().append(encodeToString);
        com.baidu.sofire.b.a();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("/100/");
        sb3.append(str3);
        sb3.append("/");
        sb3.append(valueOf);
        sb3.append("/");
        sb3.append(a2);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb3.append("?skey=");
            sb3.append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.sofire.b.a();
        try {
            if (p.a(context)) {
                str5 = new p(context).a(sb3.toString(), bytes);
            } else {
                str5 = new l(context).a(sb3.toString(), bytes);
            }
        } catch (Throwable unused) {
            d.a();
        }
        com.baidu.sofire.b.a();
        if (z && TextUtils.isEmpty(str5)) {
            try {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j = eVar.f11390a.getLong("pu_cl_fd", 0L);
                if (j == 0) {
                    j = System.currentTimeMillis();
                    eVar.g();
                }
                if (currentTimeMillis - j > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (d.f(context)) {
                        hashMap.put("0", Integer.valueOf(eVar.i() + 1));
                        hashMap.put("1", Integer.valueOf(eVar.j()));
                    } else {
                        hashMap.put("0", Integer.valueOf(eVar.i()));
                        hashMap.put("1", Integer.valueOf(eVar.j() + 1));
                    }
                    eVar.f11392c.putInt("mo_fa_pu_cl", 0);
                    eVar.f11392c.commit();
                    eVar.f11392c.putInt("wi_fa_pu_cl", 0);
                    eVar.f11392c.commit();
                    eVar.g();
                    d.a(context, "1003112", (Map<String, Object>) hashMap, false);
                } else if (d.f(context)) {
                    eVar.a(eVar.i() + 1);
                } else {
                    eVar.b(eVar.j() + 1);
                }
            } catch (Throwable unused2) {
                d.a();
            }
            throw new NetworkErrorException("response is empty");
        } else if (z2) {
            JSONObject jSONObject = new JSONObject(str5);
            String optString = jSONObject.optString("skey");
            new StringBuilder().append(optString);
            com.baidu.sofire.b.a();
            byte[] decode = Base64.decode(optString, 0);
            new StringBuilder().append(decode.length);
            com.baidu.sofire.b.a();
            byte[] rd = F.getInstance().rd(decode, bytes2);
            StringBuilder sb4 = new StringBuilder();
            String str6 = StringUtil.NULL_STRING;
            if (rd == null) {
                sb = StringUtil.NULL_STRING;
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(rd.length);
                sb = sb5.toString();
            }
            sb4.append(sb);
            com.baidu.sofire.b.a();
            String optString2 = jSONObject.optString("response");
            new StringBuilder().append(jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
            com.baidu.sofire.b.a();
            new StringBuilder().append(optString2);
            com.baidu.sofire.b.a();
            byte[] decode2 = Base64.decode(optString2, 0);
            StringBuilder sb6 = new StringBuilder();
            if (decode2 != null) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(decode2.length);
                str6 = sb7.toString();
            }
            sb6.append(str6);
            com.baidu.sofire.b.a();
            byte[] ad = F.getInstance().ad(decode2, rd);
            if (decode2 != null && decode2.length > 0 && (ad == null || ad.length == 0)) {
                d.i(context);
                throw new NetworkErrorException("aes is fail");
            }
            return new String(ad);
        } else {
            return str5;
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
                i3 = ((bArr2[i2] & 255) + (bArr3[i4] & 255) + i3) & 255;
                byte b2 = bArr3[i4];
                bArr3[i4] = bArr3[i3];
                bArr3[i3] = b2;
                i2 = (i2 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            i6 = ((bArr3[i5] & 255) + i6) & 255;
            byte b3 = bArr3[i5];
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b3;
            bArr4[i7] = (byte) (bArr3[((bArr3[i5] & 255) + (bArr3[i6] & 255)) & 255] ^ bArr[i7]);
            bArr4[i7] = (byte) (bArr4[i7] ^ ExifInterface.START_CODE);
        }
        return bArr4;
    }
}
