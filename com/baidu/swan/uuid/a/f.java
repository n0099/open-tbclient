package com.baidu.swan.uuid.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
/* loaded from: classes11.dex */
public class f implements b<String> {
    private Context mContext;

    public f(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        this.mContext = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: aoR */
    public String get() {
        return aEB();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean aEx() {
        return false;
    }

    private String aEB() {
        byte[] bytes = getAndroidId().getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = "com.baidu.swan".getBytes(StandardCharsets.UTF_8);
        return com.baidu.swan.uuid.b.b.toMd5(Build.VERSION.SDK_INT < 23 ? b(bytes2, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8), String.valueOf(System.nanoTime()).getBytes(StandardCharsets.UTF_8), bytes) : b(bytes2, bytes), true);
    }

    private static byte[] b(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    private String getAndroidId() {
        String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            string = aEC();
        }
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
        }
        return string == null ? "" : string;
    }

    private String aEC() {
        String str;
        try {
            str = (String) Build.class.getField("SERIAL").get(null);
            try {
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                    Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                    declaredMethod.setAccessible(true);
                    str = (String) declaredMethod.invoke(null, "ro.serialno");
                }
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                    str = getProp("ro.serialno");
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            return null;
        }
        return str;
    }

    private String getProp(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 256);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.swan.uuid.b.a.closeSafely(bufferedReader);
                    return readLine == null ? "" : readLine;
                } catch (IOException e) {
                    com.baidu.swan.uuid.b.a.closeSafely(bufferedReader);
                    com.baidu.swan.uuid.b.a.closeSafely(bufferedReader);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.uuid.b.a.closeSafely(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            com.baidu.swan.uuid.b.a.closeSafely(bufferedReader);
            throw th;
        }
    }
}
