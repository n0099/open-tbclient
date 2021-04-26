package com.baidu.crabsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.baidu.crabsdk.b.p;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f4856a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4857b;

    public static String a(Date date) {
        if (f4856a == null) {
            f4856a = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return f4856a.format(date);
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, jSONObject2.optString(next));
        }
        return jSONObject;
    }

    public static void c(SharedPreferences.Editor editor, boolean z) {
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(byte[] bArr) {
        Deflater deflater;
        DeflaterOutputStream deflaterOutputStream;
        DeflaterOutputStream deflaterOutputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            deflater = new Deflater(9, true);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                try {
                    try {
                        deflaterOutputStream.write(bArr);
                        deflaterOutputStream.close();
                        deflater.end();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            deflaterOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            deflater.end();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return byteArray;
                    } catch (Exception e4) {
                        e = e4;
                        a.a("Compress error!", e);
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (deflater != null) {
                            try {
                                deflater.end();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    deflaterOutputStream2 = deflaterOutputStream;
                    if (deflaterOutputStream2 != null) {
                        try {
                            deflaterOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (deflater != null) {
                        try {
                            deflater.end();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                deflaterOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (deflaterOutputStream2 != null) {
                }
                if (deflater != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            deflater = null;
            deflaterOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            deflater = null;
        }
    }

    public static String e() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public static String f(long j) {
        StringBuilder sb;
        String str;
        if (j / 1000000000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100000000)) / 10.0f);
            str = "G";
        } else if (j / 1000000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100000)) / 10.0f);
            str = "M";
        } else if (j / 1000 > 0) {
            sb = new StringBuilder();
            sb.append(((float) (j / 100)) / 10.0f);
            str = "K";
        } else {
            sb = new StringBuilder();
            sb.append(j);
            str = "B";
        }
        sb.append(str);
        return sb.toString();
    }

    public static String g(Throwable th) {
        if (th == null) {
            a.d("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String h(Throwable th) {
        if (th == null) {
            a.d("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String a2 = p.a();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains(a2)) {
                return stackTrace[i2].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static boolean i(Context context, String str) {
        if (f4857b == null) {
            f4857b = context.getPackageManager();
        }
        return f4857b.checkPermission(str, context.getPackageName()) == 0;
    }

    public static byte[] j(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return d(str.getBytes());
    }
}
