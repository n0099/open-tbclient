package com.baidu.platform.comapi.d;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f4236a;

    public c(Context context, String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                this.f4236a = new JSONObject(a(inputStream));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            a.a(inputStream);
        }
    }

    private static String a(InputStream inputStream) throws IOException {
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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
            } catch (IOException e2) {
                throw e2;
            }
        } catch (IOException e3) {
            throw e3;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            a.a(closeable);
            a.a(bufferedInputStream);
            throw th;
        }
    }

    public byte[] a() {
        JSONArray optJSONArray = this.f4236a.optJSONArray("ver");
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
        JSONArray optJSONArray = this.f4236a.optJSONArray("res");
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
