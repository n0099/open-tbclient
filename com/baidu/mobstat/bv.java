package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.baidu.sapi2.base.network.Apn;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/* loaded from: classes6.dex */
public final class bv {
    private static final Proxy a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
    private static final Proxy b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    public static String a() {
        try {
            return Environment.getExternalStorageState();
        } catch (Exception e) {
            return null;
        }
    }

    public static File a(String str) {
        File file;
        if ("mounted".equals(a())) {
            try {
                file = Environment.getExternalStorageDirectory();
            } catch (Exception e) {
                file = null;
            }
            if (file != null) {
                return new File(file, str);
            }
            return null;
        }
        return null;
    }

    public static void a(Context context, String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream openFileOutput;
        if (context != null) {
            try {
                try {
                    openFileOutput = context.openFileOutput(str, z ? 32768 : 0);
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    th = th2;
                }
                try {
                    ca.a(new ByteArrayInputStream(str2.getBytes("utf-8")), openFileOutput);
                    ca.a(openFileOutput);
                } catch (Throwable th3) {
                    fileOutputStream = openFileOutput;
                    th = th3;
                    ca.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e) {
                ca.a(null);
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        File parentFile;
        FileOutputStream fileOutputStream2 = null;
        try {
            File a2 = a(str);
            if (a2 == null) {
                fileOutputStream = null;
            } else {
                if (!a2.exists() && (parentFile = a2.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(a2, z);
                try {
                    ca.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
                } catch (Exception e) {
                    fileOutputStream2 = fileOutputStream;
                    ca.a(fileOutputStream2);
                    return;
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    ca.a(fileOutputStream2);
                    throw th;
                }
            }
            ca.a(fileOutputStream);
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] a2;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = context.openFileInput(str);
        } catch (Exception e) {
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            a2 = a(fileInputStream);
        } catch (Exception e2) {
            fileInputStream2 = fileInputStream;
            ca.a(fileInputStream2);
            return "";
        } catch (Throwable th3) {
            th = th3;
            ca.a(fileInputStream);
            throw th;
        }
        if (a2 != null) {
            String str2 = new String(a2, "utf-8");
            ca.a(fileInputStream);
            return str2;
        }
        ca.a(fileInputStream);
        return "";
    }

    public static String b(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        File a2 = a(str);
        if (a2 != null && a2.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(a2);
            } catch (Exception e) {
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                byte[] a3 = a(fileInputStream);
                if (a3 != null) {
                    String str2 = new String(a3, "utf-8");
                    ca.a(fileInputStream);
                    return str2;
                }
                ca.a(fileInputStream);
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                ca.a(fileInputStream2);
                return "";
            } catch (Throwable th3) {
                th = th3;
                ca.a(fileInputStream);
                throw th;
            }
        }
        return "";
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (ca.a(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        return context.deleteFile(str);
    }

    public static boolean c(String str) {
        File a2 = a(str);
        if (a2 == null || !a2.isFile()) {
            return false;
        }
        return a2.delete();
    }

    public static boolean c(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    public static HttpURLConnection d(Context context, String str) throws IOException {
        return a(context, str, 50000, 50000);
    }

    @SuppressLint({"DefaultLocale"})
    public static HttpURLConnection a(Context context, String str, int i, int i2) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 != null && networkInfo2.isAvailable()) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            if (networkInfo != null && networkInfo.isAvailable()) {
                String extraInfo = networkInfo.getExtraInfo();
                String lowerCase = extraInfo != null ? extraInfo.toLowerCase() : "";
                if (lowerCase.startsWith(Apn.APN_CMWAP) || lowerCase.startsWith(Apn.APN_UNIWAP) || lowerCase.startsWith(Apn.APN_3GWAP)) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(a);
                } else if (lowerCase.startsWith(Apn.APN_CTWAP)) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(b);
                }
            }
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        return httpURLConnection;
    }

    public static boolean e(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        } catch (Exception e) {
        }
        if (!z) {
            bj.c().b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        return z;
    }
}
