package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/* loaded from: classes2.dex */
public final class bn {
    public static final Proxy a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
    public static final Proxy b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    public static String a(Context context, String str) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(str);
            byte[] a2 = a(fileInputStream);
            if (a2 != null) {
                String str2 = new String(a2, IMAudioTransRequest.CHARSET);
                bt.a(fileInputStream);
                return str2;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            bt.a(fileInputStream);
            throw th;
        }
        bt.a(fileInputStream);
        return "";
    }

    public static boolean b(Context context, String str) {
        return context.deleteFile(str);
    }

    public static boolean c(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    public static HttpURLConnection d(Context context, String str) throws IOException {
        return a(context, str, 50000, 50000);
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
            bb c = bb.c();
            c.b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        return z;
    }

    @SuppressLint({"DefaultLocale"})
    public static HttpURLConnection a(Context context, String str, int i, int i2) throws IOException {
        HttpURLConnection httpURLConnection;
        String str2;
        URL url = new URL(str);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 != null && networkInfo2.isAvailable()) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            if (networkInfo != null && networkInfo.isAvailable()) {
                String extraInfo = networkInfo.getExtraInfo();
                if (extraInfo != null) {
                    str2 = extraInfo.toLowerCase();
                } else {
                    str2 = "";
                }
                if (!str2.startsWith(ConectivityUtils.APN_CMWAP) && !str2.startsWith(ConectivityUtils.APN_UNIWAP) && !str2.startsWith(ConectivityUtils.APN_3GWAP)) {
                    if (str2.startsWith(ConectivityUtils.APN_CTWAP)) {
                        httpURLConnection = (HttpURLConnection) url.openConnection(b);
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(a);
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

    public static void a(Context context, String str, String str2, boolean z) {
        int i;
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        if (z) {
            i = 32768;
        } else {
            i = 0;
        }
        try {
            fileOutputStream = context.openFileOutput(str, i);
            bt.a(new ByteArrayInputStream(str2.getBytes(IMAudioTransRequest.CHARSET)), fileOutputStream);
        } catch (Exception unused) {
            bt.a(fileOutputStream);
        } catch (Throwable th) {
            bt.a(fileOutputStream);
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bt.a(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }
}
