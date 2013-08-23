package com.baidu.adp.lib.network;

import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f444a = true;
    public static String b = "";
    private static String c = "\r\n";
    private static String d = "--";
    private static String e = "--------7da3d81520810*";

    public static HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnection;
        String replaceFirst;
        try {
            URL url = new URL(str);
            String defaultHost = Proxy.getDefaultHost();
            if (!g.b()) {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    if (!TextUtils.isEmpty(b)) {
                        httpURLConnection2.setRequestProperty(HttpUtils.HEADER_NAME_COOKIE, b);
                        return httpURLConnection2;
                    }
                    return httpURLConnection2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            int defaultPort = Proxy.getDefaultPort();
            if (defaultPort == -1) {
                defaultPort = 80;
            }
            java.net.Proxy proxy = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort));
            try {
                if (g.b(defaultHost)) {
                    String host = url.getHost();
                    int port = url.getPort();
                    int i = port != -1 ? port : 80;
                    if (str.indexOf(String.valueOf(host) + ":" + i) != -1) {
                        replaceFirst = str.replaceFirst(String.valueOf(host) + ":" + i, String.valueOf(defaultHost) + ":" + defaultPort);
                    } else {
                        replaceFirst = str.replaceFirst(host, String.valueOf(defaultHost) + ":" + defaultPort);
                    }
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
                        httpURLConnection.setRequestProperty(HttpUtils.HEADER_NAME_CMWAP_ONLINE_HOST, String.valueOf(host) + ":" + i);
                    } catch (MalformedURLException e3) {
                        return null;
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                }
                if (!TextUtils.isEmpty(b)) {
                    httpURLConnection.setRequestProperty(HttpUtils.HEADER_NAME_COOKIE, b);
                    return httpURLConnection;
                }
                return httpURLConnection;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (MalformedURLException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static HttpURLConnection a(String str, long j, long j2) {
        HttpURLConnection a2 = a(str);
        a2.setConnectTimeout(VersionUtils.CUR_DEVELOPMENT);
        a2.setReadTimeout(30000);
        a2.setRequestMethod("GET");
        a2.setDoInput(true);
        a2.setUseCaches(false);
        a2.setRequestProperty("Range", "bytes=" + j + "-" + (j2 > 0 ? Long.valueOf(j2) : ""));
        if (!TextUtils.isEmpty(b)) {
            a2.setRequestProperty(HttpUtils.HEADER_NAME_COOKIE, b);
        }
        a2.connect();
        return a2;
    }

    public static e a(HttpURLConnection httpURLConnection, boolean z, byte[] bArr, c cVar, a aVar) {
        return a(httpURLConnection, z, bArr, cVar, aVar, (f) null);
    }

    public static e a(HttpURLConnection httpURLConnection, boolean z, byte[] bArr, c cVar, a aVar, f fVar) {
        e a2;
        DataOutputStream dataOutputStream = null;
        try {
            if (aVar != null) {
                try {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(httpURLConnection);
                } catch (Exception e2) {
                    throw e2;
                }
            }
            if (f444a && !z && bArr != null && bArr.length != 0) {
                httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
            }
            long time = new Date().getTime();
            b(httpURLConnection.getURL().toString());
            if (fVar != null) {
                fVar.g = new Date().getTime() - time;
            }
            httpURLConnection.connect();
            if (fVar != null) {
                fVar.c = (new Date().getTime() - time) - fVar.g;
            }
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            if (cVar != null) {
                cVar.a();
            }
            if (!z && bArr != null && bArr.length != 0) {
                if (f444a) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    com.baidu.adp.lib.e.c.b(byteArrayInputStream, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    dataOutputStream = dataOutputStream2;
                } catch (Exception e3) {
                    throw e3;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (aVar != null) {
                        aVar.b();
                    }
                    throw th;
                }
            }
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            if (responseCode == 200 || responseCode == 204 || responseCode == 206 || responseCode == 416) {
                if (responseCode == 200 || responseCode == 206) {
                    a2 = a(httpURLConnection, z, cVar, aVar, fVar);
                    if (fVar != null) {
                        fVar.d = ((new Date().getTime() - time) - fVar.c) - fVar.g;
                    }
                } else {
                    a2 = new e();
                }
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                a2.f446a = responseCode;
                if (cVar != null && responseCode != 206) {
                    cVar.a(a2);
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (aVar != null) {
                    aVar.b();
                }
                return a2;
            } else if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408 || responseCode == 502 || responseCode == 504 || responseCode == 503) {
                throw new IOException("excuteConnection retry");
            } else {
                throw new BdHttpErrorException();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        return com.baidu.adp.lib.network.g.a(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, long j, int i, ArrayList arrayList, int i2, c cVar, a aVar) {
        long j2;
        int i3;
        HttpURLConnection a2;
        int i4 = 0;
        if (arrayList == null) {
            arrayList = new ArrayList();
            j2 = j;
        } else {
            j2 = j;
        }
        while (true) {
            try {
                a2 = a(str, j2, i <= 0 ? -1L : i + j2);
            } catch (BdHttpCancelException e2) {
                throw e2;
            } catch (SocketException e3) {
                if (i4 < i2) {
                    i3 = i4 + 1;
                } else {
                    throw e3;
                }
            } catch (SocketTimeoutException e4) {
                if (i4 < i2) {
                    i3 = i4 + 1;
                } else {
                    throw e4;
                }
            } catch (Exception e5) {
                throw e5;
            }
            if (a2 == null) {
                break;
            }
            e a3 = a(a2, true, (byte[]) null, cVar, aVar);
            if (a3 != null && (a3.f446a == 200 || a3.f446a == 206)) {
                i4 = 0;
                if (a3.d != null && a3.d.length > 0) {
                    arrayList.add(a3.d);
                    j2 += a3.d.length;
                } else {
                    i4 = 1;
                }
                if (a3.d.length >= i) {
                    if (a3.f446a == 200) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (a3 != null && (a3.f446a == 204 || a3.f446a == 416)) {
                break;
            }
            i3 = i4 + 1;
            if (i3 < i2) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e6) {
                }
            }
            if (i3 >= i2) {
                break;
            }
            i4 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, boolean z, int i, c cVar, a aVar) {
        int i2;
        long j;
        HttpURLConnection a2;
        long j2 = 0;
        int i3 = 0;
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            if (z) {
                file.delete();
            } else {
                j2 = file.length();
            }
        }
        while (true) {
            try {
                j = g.a() ? 2000000 : 200000;
                a2 = a(str, j2, j <= 0 ? j : j2 + j);
            } catch (BdHttpCancelException e2) {
            } catch (Exception e3) {
                e3.printStackTrace();
                i2 = i3 + 1;
            }
            if (a2 == null) {
                break;
            }
            e a3 = a(a2, true, (byte[]) null, cVar, aVar);
            if (a3 != null && (a3.f446a == 200 || a3.f446a == 206)) {
                i3 = 0;
                if (a3.d != null && a3.d.length > 0) {
                    g.a(str2, a3.d, j2);
                    j2 += a3.d.length;
                } else {
                    i3 = 1;
                }
                if (a3.d.length < j || a3.f446a == 200) {
                    break;
                }
            }
            if (a3 == null || (a3.f446a != 204 && a3.f446a != 416)) {
                i2 = i3 + 1;
                if (i2 < i) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e4) {
                    }
                }
                if (i2 >= i) {
                    break;
                }
                i3 = i2;
            }
        }
        return true;
        return false;
    }

    public static e a(String str, boolean z, int i, c cVar, a aVar) {
        return a(true, z, str, (byte[]) null, i, cVar, aVar);
    }

    public static e a(boolean z, String str, byte[] bArr, int i, c cVar, a aVar) {
        return a(false, z, str, bArr, i, cVar, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004f A[LOOP:0: B:3:0x000b->B:32:0x004f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(boolean z, boolean z2, String str, byte[] bArr, int i, c cVar, a aVar) {
        int i2;
        int i3;
        e eVar;
        int i4 = 0;
        f fVar = new f();
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                eVar = a(z, z2, str, bArr, cVar, aVar, fVar);
                i3 = i4;
                break;
            } catch (BdHttpCancelException e2) {
                throw e2;
            } catch (SocketException e3) {
                if (i4 < i) {
                    i2 = i4 + 1;
                    if (i2 < i && i2 > 1) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e4) {
                        }
                    }
                    if (i2 < i) {
                        i3 = i2;
                        eVar = null;
                        if (fVar != null) {
                        }
                        if (eVar != null) {
                        }
                        return eVar;
                    }
                    i4 = i2;
                } else {
                    throw e3;
                }
            } catch (SocketTimeoutException e5) {
                if (i4 < i) {
                    i2 = i4 + 1;
                    if (i2 < i) {
                        Thread.sleep(100L);
                    }
                    if (i2 < i) {
                    }
                } else {
                    throw e5;
                }
            } catch (Exception e6) {
                throw e6;
            }
            i4 = i2;
        }
        if (fVar != null) {
            fVar.e = i3;
            fVar.f = new Date().getTime() - currentTimeMillis;
        }
        if (eVar != null) {
            eVar.c = fVar;
        }
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static e a(boolean z, boolean z2, String str, byte[] bArr, c cVar, a aVar, f fVar) {
        HttpURLConnection httpURLConnection;
        e a2;
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        DataOutputStream dataOutputStream = null;
        try {
            httpURLConnection = a(str);
            try {
                if (fVar != null) {
                    if (z || bArr == null) {
                        fVar.f447a = str.length();
                    } else {
                        fVar.f447a = bArr.length;
                    }
                }
                if (aVar != null) {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(httpURLConnection);
                }
                if (z) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    if (f444a) {
                        httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
                    }
                }
                if (z2) {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                }
                httpURLConnection.setConnectTimeout(VersionUtils.CUR_DEVELOPMENT);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(!z);
                httpURLConnection.setUseCaches(false);
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                b(str);
                if (fVar != null) {
                    fVar.g = System.currentTimeMillis() - currentTimeMillis;
                }
                httpURLConnection.connect();
                if (fVar != null) {
                    fVar.c = (System.currentTimeMillis() - currentTimeMillis) - fVar.g;
                }
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                if (cVar != null) {
                    cVar.a();
                }
                if (!z && bArr != null && bArr.length != 0) {
                    if (f444a) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        com.baidu.adp.lib.e.c.b(byteArrayInputStream, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream2.write(bArr);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                        dataOutputStream = dataOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection2 = httpURLConnection;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection = httpURLConnection2;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (aVar != null) {
                                aVar.b();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (aVar != null) {
                        }
                        throw th;
                    }
                }
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                if (responseCode == 200 || responseCode == 204 || responseCode == 206 || responseCode == 413 || responseCode == 416) {
                    if (responseCode == 200 || responseCode == 206) {
                        a2 = a(httpURLConnection, z, cVar, aVar, fVar);
                    } else {
                        a2 = new e();
                    }
                    if (aVar != null && aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    a2.f446a = responseCode;
                    if (fVar != null) {
                        fVar.d = ((new Date().getTime() - currentTimeMillis) - fVar.c) - fVar.g;
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (aVar != null) {
                        aVar.b();
                    }
                    return a2;
                } else if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408 || responseCode == 502 || responseCode == 504 || responseCode == 503) {
                    throw new IOException("doGetOrPost retry");
                } else {
                    throw new BdHttpErrorException();
                }
            } catch (Exception e5) {
                e = e5;
                httpURLConnection2 = httpURLConnection;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            e = e6;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        r6.e = r0;
        r6.f = java.lang.System.currentTimeMillis() - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039 A[LOOP:0: B:5:0x000d->B:20:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0022 A[EDGE_INSN: B:38:0x0022->B:12:0x0022 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, boolean z, ArrayList arrayList, HashMap hashMap, int i, c cVar, a aVar, f fVar) {
        e eVar;
        int i2;
        int i3 = 0;
        e eVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        f fVar2 = fVar == null ? new f() : fVar;
        while (true) {
            try {
                try {
                    eVar = a(str, z, arrayList, hashMap, cVar, aVar, fVar2);
                    if (eVar != null) {
                        try {
                            if (eVar.f446a == 200) {
                                i2 = i3;
                                break;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (i3 < i) {
                                i2 = i3 + 1;
                                if (i2 < i) {
                                }
                                if (i2 < i) {
                                }
                            } else {
                                throw e;
                            }
                        }
                    }
                    i2 = i3 + 1;
                } catch (BdHttpCancelException e3) {
                    throw e3;
                }
            } catch (Exception e4) {
                e = e4;
                eVar = eVar2;
            }
            if (i2 < i) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e5) {
                }
            }
            if (i2 < i) {
                break;
            }
            eVar2 = eVar;
            i3 = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1152=4, 1154=5] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, boolean z, ArrayList arrayList, HashMap hashMap, c cVar, a aVar, f fVar) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = a(str);
            if (aVar != null) {
                try {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(httpURLConnection);
                } catch (Exception e2) {
                    e = e2;
                    dataOutputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (aVar != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (aVar != null) {
                    }
                    throw th;
                }
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + e);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            if (f444a) {
                httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
            }
            if (z) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            }
            httpURLConnection.setConnectTimeout(VersionUtils.CUR_DEVELOPMENT);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (aVar == null || !aVar.c()) {
                long currentTimeMillis = System.currentTimeMillis();
                b(str);
                if (fVar != null) {
                    fVar.g = new Date().getTime() - currentTimeMillis;
                }
                httpURLConnection.connect();
                if (fVar != null) {
                    fVar.c = (System.currentTimeMillis() - currentTimeMillis) - fVar.g;
                }
                if (aVar == null || !aVar.c()) {
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (f444a) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    byteArrayOutputStream.write((String.valueOf(d) + e + c).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"" + c).getBytes());
                                    byteArrayOutputStream.write(c.getBytes());
                                    if (value == null) {
                                        byteArrayOutputStream.write("null".getBytes("UTF-8"));
                                    } else {
                                        byteArrayOutputStream.write(value.getBytes("UTF-8"));
                                    }
                                    byteArrayOutputStream.write(c.getBytes());
                                }
                            }
                        }
                        if (hashMap != null) {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                byte[] bArr = (byte[]) entry.getValue();
                                if (bArr != null) {
                                    byteArrayOutputStream.write((String.valueOf(d) + e + c).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"" + c).getBytes());
                                    byteArrayOutputStream.write(c.getBytes());
                                    byteArrayOutputStream.write(bArr);
                                    byteArrayOutputStream.write(c.getBytes());
                                    byteArrayOutputStream.write((String.valueOf(d) + e + d + c).getBytes());
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        com.baidu.adp.lib.e.c.b(byteArrayInputStream, byteArrayOutputStream2);
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            try {
                                dataOutputStream.write(byteArrayOutputStream2.toByteArray());
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                                httpURLConnection2 = httpURLConnection;
                                throw e;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    } else {
                        DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                        if (arrayList != null) {
                            try {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair basicNameValuePair2 = (BasicNameValuePair) it2.next();
                                    if (basicNameValuePair2 != null) {
                                        String name2 = basicNameValuePair2.getName();
                                        String value2 = basicNameValuePair2.getValue();
                                        dataOutputStream3.writeBytes(String.valueOf(d) + e + c);
                                        dataOutputStream3.writeBytes("Content-Disposition: form-data; name=\"" + name2 + "\"" + c);
                                        dataOutputStream3.writeBytes(c);
                                        if (value2 == null) {
                                            dataOutputStream3.write("null".getBytes("UTF-8"));
                                        } else {
                                            dataOutputStream3.write(value2.getBytes("UTF-8"));
                                        }
                                        dataOutputStream3.writeBytes(c);
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                dataOutputStream = dataOutputStream3;
                                httpURLConnection2 = httpURLConnection;
                                throw e;
                            } catch (Throwable th4) {
                                th = th4;
                                dataOutputStream2 = dataOutputStream3;
                                if (dataOutputStream2 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (aVar != null) {
                                }
                                throw th;
                            }
                        }
                        if (hashMap != null) {
                            for (Map.Entry entry2 : hashMap.entrySet()) {
                                String str3 = (String) entry2.getKey();
                                byte[] bArr2 = (byte[]) entry2.getValue();
                                if (bArr2 != null) {
                                    dataOutputStream3.writeBytes(String.valueOf(d) + e + c);
                                    dataOutputStream3.writeBytes("Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"file\"" + c);
                                    dataOutputStream3.writeBytes(c);
                                    dataOutputStream3.write(bArr2);
                                    dataOutputStream3.writeBytes(c);
                                    dataOutputStream3.writeBytes(String.valueOf(d) + e + d + c);
                                }
                            }
                        }
                        dataOutputStream3.flush();
                        dataOutputStream3.close();
                        dataOutputStream = dataOutputStream3;
                    }
                    if (aVar != null) {
                        try {
                            if (aVar.c()) {
                                throw new BdHttpCancelException();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (aVar != null) {
                                aVar.b();
                            }
                            throw th;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (aVar == null || !aVar.c()) {
                        if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 416) {
                            if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408 || responseCode == 502 || responseCode == 504 || responseCode == 503) {
                                throw new IOException("doGetOrPost retry");
                            }
                            throw new BdHttpErrorException();
                        }
                        e a2 = (responseCode == 200 || responseCode == 206) ? a(httpURLConnection, false, cVar, aVar, fVar) : new e();
                        if (aVar == null || !aVar.c()) {
                            a2.f446a = responseCode;
                            if (fVar != null) {
                                fVar.d = ((System.currentTimeMillis() - currentTimeMillis) - fVar.c) - fVar.g;
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (aVar != null) {
                                aVar.b();
                            }
                            return a2;
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            }
            throw new BdHttpCancelException();
        } catch (Exception e7) {
            e = e7;
            httpURLConnection2 = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    private static e a(HttpURLConnection httpURLConnection, boolean z, c cVar, a aVar, f fVar) {
        int i;
        int read;
        String headerField;
        int i2 = 0;
        InputStream inputStream = null;
        try {
            e eVar = new e();
            String contentType = httpURLConnection.getContentType();
            eVar.e = g.d(contentType);
            if (z && g.c(contentType)) {
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.disconnect();
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.connect();
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
            }
            String headerField2 = httpURLConnection.getHeaderField("Content-Range");
            if (headerField2 != null) {
                int indexOf = headerField2.indexOf("/");
                i = indexOf != -1 ? Integer.valueOf(headerField2.substring(indexOf + 1)).intValue() : 0;
                int indexOf2 = headerField2.indexOf("-");
                if (indexOf2 != -1 && indexOf2 > 6) {
                    i2 = Integer.valueOf(headerField2.substring(6, indexOf2)).intValue();
                }
            } else {
                i = 0;
            }
            if (i == 0 && httpURLConnection.getResponseCode() == 200 && (headerField = httpURLConnection.getHeaderField(HttpUtils.HEADER_NAME_CONTENT_LENGTH)) != null) {
                i = Integer.valueOf(headerField).intValue();
            }
            if (cVar != null) {
                cVar.a(i, httpURLConnection);
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            if (inputStream2 != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                do {
                    read = inputStream2.read(bArr);
                    i2 += read;
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        if (cVar != null) {
                            cVar.a(i2, i, httpURLConnection);
                        }
                    }
                    if (aVar != null && aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                } while (read > 0);
                if (fVar != null) {
                    fVar.b = i2;
                }
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(LVBuffer.LENGTH_ALLOC_PER_NEW);
                    com.baidu.adp.lib.e.c.a(byteArrayInputStream, byteArrayOutputStream2);
                    eVar.d = byteArrayOutputStream2.toByteArray();
                } else {
                    eVar.d = byteArrayOutputStream.toByteArray();
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e2) {
                }
            }
            return eVar;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }

    private static void b(String str) {
        try {
            InetAddress.getByName(new URL(str).getHost()).getHostAddress();
        } catch (Exception e2) {
            com.baidu.adp.lib.e.d.b("BdHttpImpl", "checkDNS", e2.toString());
        }
    }
}
