package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.webkit.internal.ConectivityUtils;
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
/* loaded from: classes2.dex */
public final class bo {

    /* renamed from: a  reason: collision with root package name */
    public static final Proxy f9123a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));

    /* renamed from: b  reason: collision with root package name */
    public static final Proxy f9124b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    public static String a() {
        try {
            return Environment.getExternalStorageState();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        File a2 = a(str);
        if (a2 == null || !a2.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(a2);
            try {
                byte[] a3 = a(fileInputStream2);
                if (a3 == null) {
                    bu.a(fileInputStream2);
                    return "";
                }
                String str2 = new String(a3, "utf-8");
                bu.a(fileInputStream2);
                return str2;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                bu.a(fileInputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                bu.a(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(String str) {
        File a2 = a(str);
        if (a2 == null || !a2.isFile()) {
            return false;
        }
        return a2.delete();
    }

    public static HttpURLConnection d(Context context, String str) throws IOException {
        return a(context, str, (int) IMConstants.ERROR_BASE, (int) IMConstants.ERROR_BASE);
    }

    public static boolean e(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (!z) {
            bc c2 = bc.c();
            c2.b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        return z;
    }

    public static File a(String str) {
        File file;
        if ("mounted".equals(a())) {
            try {
                file = Environment.getExternalStorageDirectory();
            } catch (Exception unused) {
                file = null;
            }
            if (file == null) {
                return null;
            }
            return new File(file, str);
        }
        return null;
    }

    public static boolean c(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
        } catch (Exception unused) {
            bu.a(fileOutputStream);
        } catch (Throwable th) {
            bu.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean b(Context context, String str) {
        return context.deleteFile(str);
    }

    public static void a(String str, String str2, boolean z) {
        File parentFile;
        FileOutputStream fileOutputStream = null;
        try {
            File a2 = a(str);
            if (a2 != null) {
                if (!a2.exists() && (parentFile = a2.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2, z);
                try {
                    bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream2);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    bu.a(fileOutputStream);
                    throw th;
                }
                fileOutputStream = fileOutputStream2;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        bu.a(fileOutputStream);
    }

    public static String a(Context context, String str) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(str);
            byte[] a2 = a(fileInputStream);
            if (a2 != null) {
                String str2 = new String(a2, "utf-8");
                bu.a(fileInputStream);
                return str2;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            bu.a(fileInputStream);
            throw th;
        }
        bu.a(fileInputStream);
        return "";
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bu.a(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
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
                if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                    if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        httpURLConnection = (HttpURLConnection) url.openConnection(f9124b);
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(f9123a);
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
}
