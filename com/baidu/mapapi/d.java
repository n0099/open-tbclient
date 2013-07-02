package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    static Context a;
    static HashMap b = new HashMap();
    public static boolean c = false;
    public static int d = 4;
    public static boolean e = false;
    public static byte f = 0;
    public static String g = HttpUtils.IP_CTWAP;
    public static int h = 80;

    /* loaded from: classes.dex */
    public interface a {
        void onError(int i, int i2, String str, Object obj);

        void onOk(int i, int i2, String str, Object obj);
    }

    public static HttpURLConnection a(String str) {
        String substring;
        String substring2;
        if (!c) {
            a();
            if (!c) {
                return null;
            }
        }
        if (e) {
            int indexOf = str.indexOf(47, 7);
            if (indexOf < 0) {
                substring = str.substring(7);
                substring2 = "";
            } else {
                substring = str.substring(7, indexOf);
                substring2 = str.substring(indexOf);
            }
            if (f == 1) {
                return (HttpURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(g, 80)));
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(com.baidu.loginshare.e.f + g + substring2).openConnection();
            httpURLConnection.setRequestProperty(HttpUtils.HEADER_NAME_CMWAP_ONLINE_HOST, substring);
            return httpURLConnection;
        }
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public static void a() {
        ConnectivityManager connectivityManager = a != null ? (ConnectivityManager) a.getSystemService("connectivity") : null;
        if (connectivityManager == null) {
            c = false;
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            a(activeNetworkInfo, activeNetworkInfo.isConnected());
        } else {
            c = false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.mapapi.d$1] */
    public static void a(final int i, final int i2, final String str, final a aVar) {
        if (str == null || !str.startsWith(com.baidu.loginshare.e.f)) {
            return;
        }
        new Thread() { // from class: com.baidu.mapapi.d.1
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x00db */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r1v2 */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                HttpURLConnection httpURLConnection;
                u uVar;
                InputStream inputStream = null;
                synchronized (d.b) {
                    ?? r0 = d.b;
                    ?? r1 = str;
                    SoftReference softReference = (SoftReference) r0.get(r1);
                    if (softReference != null && (uVar = (u) softReference.get()) != null) {
                        aVar.onOk(i, i2, str, uVar);
                        return;
                    }
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        httpURLConnection = d.a(str);
                        try {
                            if (httpURLConnection != null) {
                                httpURLConnection.setConnectTimeout(20000);
                                httpURLConnection.connect();
                                if (httpURLConnection.getResponseCode() == 200) {
                                    inputStream = httpURLConnection.getInputStream();
                                    byte[] bArr = new byte[2048];
                                    for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                    if (aVar != null) {
                                        u uVar2 = new u(byteArrayOutputStream.toByteArray());
                                        d.b.put(str, new SoftReference(uVar2));
                                        aVar.onOk(i, i2, str, uVar2);
                                    }
                                }
                            } else if (aVar != null) {
                                aVar.onError(i, i2, str, "网络连接失败");
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            if (aVar != null) {
                                aVar.onError(i, i2, str, "网络连接失败");
                            }
                            e.printStackTrace();
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        httpURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r1 = 0;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                        throw th;
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        a = context;
    }

    public static void a(NetworkInfo networkInfo, boolean z) {
        c = z;
        try {
            if (networkInfo.getType() == 1) {
                d = 4;
                e = false;
            } else {
                String extraInfo = networkInfo.getExtraInfo();
                if (extraInfo == null) {
                    d = 0;
                    g = android.net.Proxy.getDefaultHost();
                    h = android.net.Proxy.getDefaultPort();
                    if (g == null || "".equals(g)) {
                        d = 1;
                        e = false;
                    } else {
                        d = 2;
                        e = true;
                        if (HttpUtils.IP_CTWAP.equals(g)) {
                            f = (byte) 1;
                        } else {
                            f = (byte) 0;
                        }
                    }
                } else {
                    String trim = extraInfo.toLowerCase().trim();
                    if (trim.startsWith("cmwap") || trim.startsWith("uniwap") || trim.startsWith("3gwap")) {
                        d = 2;
                        e = true;
                        f = (byte) 0;
                        g = "10.0.0.172";
                    } else if (trim.startsWith("ctwap")) {
                        d = 2;
                        e = true;
                        f = (byte) 1;
                        g = HttpUtils.IP_CTWAP;
                    } else if (trim.startsWith("cmnet") || trim.startsWith("uninet") || trim.startsWith("ctnet") || trim.startsWith("3gnet")) {
                        d = 1;
                        e = false;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
