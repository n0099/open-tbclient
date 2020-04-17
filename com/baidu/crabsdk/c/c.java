package com.baidu.crabsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.baidu.crabsdk.b.p;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c {
    private static SimpleDateFormat akD;
    private static PackageManager akE;

    public static String Q(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / TimeUtils.NANOS_PER_MS > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }

    public static String a(Date date) {
        if (akD == null) {
            akD = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return akD.format(date);
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, jSONObject2.optString(next));
        }
        return jSONObject;
    }

    public static void a(SharedPreferences.Editor editor, boolean z) {
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private static byte[] a(byte[] bArr) {
        Deflater deflater;
        DeflaterOutputStream deflaterOutputStream;
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    try {
                        deflater = new Deflater(9, true);
                    } catch (Exception e) {
                        e = e;
                        deflaterOutputStream = null;
                        deflater = null;
                    } catch (Throwable th) {
                        deflaterOutputStream = null;
                        deflater = null;
                        th = th;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                        try {
                            deflaterOutputStream.write(bArr);
                            deflaterOutputStream.close();
                            deflater.end();
                            bArr2 = byteArrayOutputStream.toByteArray();
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
                        } catch (Exception e4) {
                            e = e4;
                            a.f("Compress error!", e);
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
                            return bArr2;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        deflaterOutputStream = null;
                    } catch (Throwable th2) {
                        deflaterOutputStream = null;
                        th = th2;
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (deflater != null) {
                            try {
                                deflater.end();
                            } catch (Exception e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return bArr2;
    }

    public static byte[] dh(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(str.getBytes());
    }

    public static boolean g(Context context, String str) {
        if (akE == null) {
            akE = context.getPackageManager();
        }
        try {
            return akE.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String h(Throwable th) {
        if (th == null) {
            a.w("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String i(Throwable th) {
        if (th == null) {
            a.w("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String sC = p.sC();
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().contains(sC)) {
                return stackTrace[i].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String sM() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
