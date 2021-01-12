package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.baidu.android.imsdk.IMConstants;
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
/* loaded from: classes14.dex */
public final class bo {

    /* renamed from: a  reason: collision with root package name */
    private static final Proxy f3768a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));

    /* renamed from: b  reason: collision with root package name */
    private static final Proxy f3769b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

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
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
            } catch (Exception e) {
            } finally {
                bu.a(fileOutputStream);
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File parentFile;
        FileOutputStream fileOutputStream3 = null;
        try {
            File a2 = a(str);
            if (a2 == null) {
                fileOutputStream2 = null;
            } else {
                if (!a2.exists() && (parentFile = a2.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                fileOutputStream2 = new FileOutputStream(a2, z);
                try {
                    bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream2);
                } catch (Exception e) {
                    fileOutputStream3 = fileOutputStream2;
                    bu.a(fileOutputStream3);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    bu.a(fileOutputStream);
                    throw th;
                }
            }
            bu.a(fileOutputStream2);
        } catch (Exception e2) {
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static String a(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream openFileInput;
        byte[] a2;
        FileInputStream fileInputStream2 = null;
        try {
            openFileInput = context.openFileInput(str);
            try {
                a2 = a(openFileInput);
            } catch (Exception e) {
                fileInputStream2 = openFileInput;
                bu.a(fileInputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = openFileInput;
                bu.a(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        if (a2 != null) {
            String str2 = new String(a2, "utf-8");
            bu.a(openFileInput);
            return str2;
        }
        bu.a(openFileInput);
        return "";
    }

    public static String b(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File a2 = a(str);
        if (a2 != null && a2.exists()) {
            FileInputStream fileInputStream3 = null;
            try {
                fileInputStream2 = new FileInputStream(a2);
            } catch (Exception e) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] a3 = a(fileInputStream2);
                if (a3 != null) {
                    String str2 = new String(a3, "utf-8");
                    bu.a(fileInputStream2);
                    return str2;
                }
                bu.a(fileInputStream2);
            } catch (Exception e2) {
                fileInputStream3 = fileInputStream2;
                bu.a(fileInputStream3);
                return "";
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                bu.a(fileInputStream);
                throw th;
            }
        }
        return "";
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bu.a(inputStream, byteArrayOutputStream)) {
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
        return a(context, str, (int) IMConstants.ERROR_BASE, (int) IMConstants.ERROR_BASE);
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
                if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(f3768a);
                } else if (lowerCase.startsWith("ctwap")) {
                    httpURLConnection = (HttpURLConnection) url.openConnection(f3769b);
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
            bc.c().b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        return z;
    }
}
