package com.baidu.android.pushservice.j;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final Object a = new Object();

    public static String a(Context context, String str) {
        if (context == null) {
            return "";
        }
        String str2 = null;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("CommonParams", e);
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Object b = b(context, str);
                if (b == null || !(b instanceof String)) {
                    com.baidu.android.pushservice.g.a.c("CommonParams", "no sp or external storage found: " + str);
                } else {
                    str2 = String.valueOf(b);
                }
                return str2;
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.e("CommonParams", "getSPString exception, key=" + str);
                return str2;
            }
        }
        return str2;
    }

    private static JSONObject a(Context context) {
        FileInputStream fileInputStream;
        JSONObject jSONObject = new JSONObject();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/files");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".info");
                if (file2.exists()) {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        jSONObject = new JSONObject(BaiduAppSSOJni.getDecrypted(context, "", new String(bArr, "utf-8")));
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        com.baidu.android.pushservice.g.a.a("CommonParams", e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                com.baidu.android.pushservice.g.a.a("CommonParams", e2);
                            }
                        }
                        return jSONObject;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                com.baidu.android.pushservice.g.a.a("CommonParams", e3);
                            }
                        }
                        throw th;
                    }
                } else {
                    fileInputStream = null;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        com.baidu.android.pushservice.g.a.a("CommonParams", e4);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        return jSONObject;
    }

    public static void a(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            if (q.t(context, "android.permission.WRITE_SETTINGS")) {
                z = Settings.System.putInt(context.getContentResolver(), str, i);
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.e("CommonParams", "putSPInt exception, key=" + str);
        }
        if (z) {
            return;
        }
        a(context, str, Integer.valueOf(i));
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.e("CommonParams", "putSPString exception, key=" + str);
        }
        if (z) {
            return;
        }
        a(context, str, (Object) str2);
    }

    private static boolean a(Context context, String str, Object obj) {
        if (!q.t(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.baidu.android.pushservice.g.a.c("CommonParams", "android.permission.WRITE_EXTERNAL_STORAGE is not granted!");
            return false;
        }
        synchronized (a) {
            JSONObject a2 = a(context);
            FileOutputStream fileOutputStream = null;
            if (a2.opt(str) != null) {
                a2.remove(str);
            }
            try {
                try {
                    a2.put(str, obj);
                    File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/files");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".info");
                    String encrypted = BaiduAppSSOJni.getEncrypted(context, "", a2.toString());
                    if (TextUtils.isEmpty(encrypted)) {
                        com.baidu.android.pushservice.f.b.a(null);
                        return false;
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        fileOutputStream2.write(encrypted.getBytes());
                        com.baidu.android.pushservice.f.b.a(fileOutputStream2);
                        return true;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.android.pushservice.g.a.a("CommonParams", e);
                        com.baidu.android.pushservice.f.b.a(fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.android.pushservice.f.b.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static Object b(Context context, String str) {
        Object opt;
        if (!q.t(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.baidu.android.pushservice.g.a.c("CommonParams", "write permission not granted");
            return null;
        }
        synchronized (a) {
            opt = a(context).opt(str);
        }
        return opt;
    }
}
