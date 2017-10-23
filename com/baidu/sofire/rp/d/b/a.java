package com.baidu.sofire.rp.d.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.rp.f.b;
import com.baidu.sofire.rp.f.f;
import com.baidu.sofire.rp.f.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public final class a {
    private static String c = "";
    private Context a;
    private String b = "2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q";

    private a(Context context) {
        this.a = context;
    }

    public static synchronized a as(Context context) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(context);
        }
        return aVar;
    }

    private String b() {
        if (TextUtils.isEmpty(c)) {
            try {
                c = new String(f.b(Base64.decode(this.b, 0), "30212102dicudiab".getBytes("utf-8")));
            } catch (Exception e) {
                b.a();
            }
        }
        return c;
    }

    public final String a(String str) {
        String[] at = b.at(this.a);
        if (at == null || at.length != 2 || TextUtils.isEmpty(at[0]) || TextUtils.isEmpty(at[1])) {
            return "";
        }
        String str2 = at[0];
        String str3 = at[1];
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        try {
            str4 = b.a(str2, str3, currentTimeMillis);
        } catch (Throwable th) {
            b.a();
        }
        String c2 = b.c();
        sb.append(b()).append("plugin/v1/report?appkey=").append(str2).append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(str4).append("&msg_id=").append(c2).append("&skey=").append(str);
        return sb.toString();
    }

    public final String a() {
        String a;
        try {
            String[] at = b.at(this.a);
            if (at == null || at.length != 2) {
                return "";
            }
            if (TextUtils.isEmpty(at[0]) || TextUtils.isEmpty(at[1])) {
                return "";
            }
            String str = at[0];
            String str2 = at[1];
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            try {
                a = b.a(str, str2, currentTimeMillis);
            } catch (Exception e) {
                b.a();
            }
            sb.append(b()).append("plugin/v1/report/setting?appkey=").append(str).append("&timestamp=").append(currentTimeMillis);
            sb.append("&sign=").append(a);
            return sb.toString();
        } catch (Exception e2) {
            b.a();
            return "";
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            g.e(byteArrayInputStream, byteArrayOutputStream);
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
        } catch (Throwable th) {
            bArr2 = null;
            b.a();
        }
        return f.a(bArr2, bArr);
    }
}
