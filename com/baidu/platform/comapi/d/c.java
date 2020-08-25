package com.baidu.platform.comapi.d;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes20.dex */
final class c {
    private JSONObject a;

    public c(Context context, String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                this.a = new JSONObject(a(inputStream));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            a.a(inputStream);
        }
    }

    private static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                e = e;
                byteArrayOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[512];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                    a.a(byteArrayOutputStream);
                    a.a(bufferedInputStream);
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            try {
                throw e;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                a.a(byteArrayOutputStream);
                a.a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            a.a(byteArrayOutputStream);
            a.a(bufferedInputStream);
            throw th;
        }
    }

    public byte[] a() {
        JSONArray optJSONArray = this.a.optJSONArray("ver");
        if (optJSONArray != null) {
            byte[] bArr = new byte[optJSONArray.length()];
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) optJSONArray.optInt(i);
            }
            return bArr;
        }
        return null;
    }

    public String[] b() {
        JSONArray optJSONArray = this.a.optJSONArray("res");
        if (optJSONArray != null) {
            String[] strArr = new String[optJSONArray.length()];
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                strArr[i] = optJSONArray.optString(i);
            }
            return strArr;
        }
        return null;
    }
}
