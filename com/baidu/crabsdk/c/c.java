package com.baidu.crabsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.baidu.crabsdk.b.o;
import com.baidu.sapi2.base.network.Apn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class c {
    private static SimpleDateFormat ZX;
    private static PackageManager ZY;

    public static void a(SharedPreferences.Editor editor, boolean z) {
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static byte[] cj(String str) {
        Deflater deflater;
        DeflaterOutputStream deflaterOutputStream;
        byte[] bArr = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    try {
                        deflater = new Deflater(9, true);
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                            try {
                                deflaterOutputStream.write(str.getBytes(HTTP.UTF_8));
                                deflaterOutputStream.close();
                                deflater.end();
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    deflaterOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    deflater.end();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                a.a("Compress error!", e);
                                if (deflaterOutputStream != null) {
                                    try {
                                        deflaterOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (deflater != null) {
                                    try {
                                        deflater.end();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                return bArr;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            deflaterOutputStream = null;
                        } catch (Throwable th) {
                            deflaterOutputStream = null;
                            th = th;
                            if (deflaterOutputStream != null) {
                                try {
                                    deflaterOutputStream.close();
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
                        deflater = null;
                    } catch (Throwable th2) {
                        deflaterOutputStream = null;
                        deflater = null;
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return bArr;
    }

    public static String e(Date date) {
        if (ZX == null) {
            ZX = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return ZX.format(date);
    }

    public static String f(Throwable th) {
        if (th == null) {
            a.w("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : Apn.APN_UNKNOWN;
    }

    public static String g(Throwable th) {
        if (th == null) {
            a.w("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String F = o.F();
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().contains(F)) {
                return stackTrace[i].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : Apn.APN_UNKNOWN;
    }

    public static boolean g(Context context, String str) {
        if (ZY == null) {
            ZY = context.getPackageManager();
        }
        try {
            return ZY.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String qR() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public static String r(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / 1000000 > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }
}
