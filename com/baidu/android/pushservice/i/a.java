package com.baidu.android.pushservice.i;

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
/* loaded from: classes8.dex */
public class a {
    private static final Object a = new Object();

    public static String a(Context context, String str) {
        if (context == null) {
            return "";
        }
        String str2 = null;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Object b = b(context, str);
                return (b == null || !(b instanceof String)) ? str2 : String.valueOf(b);
            } catch (Exception e2) {
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
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
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
                }
            }
        } catch (Exception e5) {
        } catch (Throwable th2) {
            th = th2;
        }
        return jSONObject;
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e) {
        }
        if (z) {
            return;
        }
        a(context, str, (Object) str2);
    }

    private static boolean a(Context context, String str, Object obj) {
        FileOutputStream fileOutputStream;
        if (!l.u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        synchronized (a) {
            JSONObject a2 = a(context);
            FileOutputStream fileOutputStream2 = null;
            if (a2.opt(str) != null) {
                a2.remove(str);
            }
            try {
                a2.put(str, obj);
                File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/files");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".info");
                String encrypted = BaiduAppSSOJni.getEncrypted(context, "", a2.toString());
                if (TextUtils.isEmpty(encrypted)) {
                    com.baidu.android.pushservice.e.b.a(null);
                    return false;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                try {
                    fileOutputStream3.write(encrypted.getBytes());
                    com.baidu.android.pushservice.e.b.a(fileOutputStream3);
                    return true;
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream3;
                    com.baidu.android.pushservice.e.b.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    com.baidu.android.pushservice.e.b.a(fileOutputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static Object b(Context context, String str) {
        Object opt;
        if (l.u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            synchronized (a) {
                opt = a(context).opt(str);
            }
            return opt;
        }
        return null;
    }
}
