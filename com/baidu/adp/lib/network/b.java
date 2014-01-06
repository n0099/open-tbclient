package com.baidu.adp.lib.network;

import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.zeus.NotificationProxy;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
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
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {
    public static boolean a = true;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    private static String e = "\r\n";
    private static String f = "--";
    private static String g = "--------7da3d81520810*";

    public static HttpURLConnection a(String str, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        String replaceFirst;
        URL url = new URL(str);
        String defaultHost = Proxy.getDefaultHost();
        if (!g.b()) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (!TextUtils.isEmpty(b)) {
                httpURLConnection2.setRequestProperty("Cookie", b);
            } else {
                httpURLConnection2.setRequestProperty("Cookie", "");
            }
            if (!TextUtils.isEmpty(c)) {
                httpURLConnection2.setRequestProperty("User-Agent", c);
            }
            if (!TextUtils.isEmpty(d)) {
                httpURLConnection2.setRequestProperty("client_user_token", d);
            }
            a(httpURLConnection2, linkedList);
            return httpURLConnection2;
        }
        int defaultPort = Proxy.getDefaultPort();
        if (defaultPort == -1) {
            defaultPort = 80;
        }
        java.net.Proxy proxy = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort));
        if (g.b(defaultHost)) {
            String host = url.getHost();
            int port = url.getPort();
            int i = port != -1 ? port : 80;
            if (str.indexOf(host + ":" + i) != -1) {
                replaceFirst = str.replaceFirst(host + ":" + i, defaultHost + ":" + defaultPort);
            } else {
                replaceFirst = str.replaceFirst(host, defaultHost + ":" + defaultPort);
            }
            try {
                httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
                httpURLConnection.setRequestProperty("X-Online-Host", host + ":" + i);
            } catch (MalformedURLException e2) {
                return null;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        }
        if (!TextUtils.isEmpty(b)) {
            httpURLConnection.setRequestProperty("Cookie", b);
        } else {
            httpURLConnection.setRequestProperty("Cookie", "");
        }
        if (!TextUtils.isEmpty(c)) {
            httpURLConnection.setRequestProperty("User-Agent", c);
        }
        if (!TextUtils.isEmpty(d)) {
            httpURLConnection.setRequestProperty("client_user_token", d);
        }
        a(httpURLConnection, linkedList);
        return httpURLConnection;
    }

    public static HttpURLConnection a(String str, long j, long j2, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection a2 = a(str, linkedList);
        a2.setConnectTimeout(10000);
        a2.setReadTimeout(30000);
        a2.setRequestMethod("GET");
        a2.setDoInput(true);
        a2.setUseCaches(false);
        a2.setRequestProperty("Range", "bytes=" + j + "-" + (j2 > 0 ? Long.valueOf(j2) : ""));
        if (!TextUtils.isEmpty(b)) {
            a2.setRequestProperty("Cookie", b);
        } else {
            a2.setRequestProperty("Cookie", "");
        }
        if (!TextUtils.isEmpty(c)) {
            a2.setRequestProperty("User-Agent", c);
        }
        a2.connect();
        return a2;
    }

    private static void a(HttpURLConnection httpURLConnection, LinkedList<BasicNameValuePair> linkedList) {
        if (httpURLConnection != null && linkedList != null && linkedList.size() > 0) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    httpURLConnection.setRequestProperty(next.getName(), next.getValue());
                }
            }
        }
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
            if (a && !z && bArr != null && bArr.length != 0) {
                httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
            }
            long currentTimeMillis = System.currentTimeMillis();
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
                if (a) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                    com.baidu.adp.lib.h.d.b(byteArrayInputStream, byteArrayOutputStream);
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
                        fVar.d = ((System.currentTimeMillis() - currentTimeMillis) - fVar.c) - fVar.g;
                    }
                } else {
                    a2 = new e();
                }
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
                a2.a = responseCode;
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
            } else if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                throw new BdHttpErrorException("retry, errorCode:" + responseCode, responseCode, true);
            } else {
                if (responseCode == 502 || responseCode == 503 || responseCode == 504) {
                    throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                }
                throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0016 A[EDGE_INSN: B:100:0x0016->B:10:0x0016 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084 A[LOOP:0: B:5:0x0009->B:47:0x0084, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, long j, int i, ArrayList<byte[]> arrayList, int i2, int i3, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        long j2;
        int i4;
        long j3;
        int i5;
        int i6;
        HttpURLConnection a2;
        int i7 = 0;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            j2 = j;
        } else {
            j2 = j;
        }
        while (true) {
            try {
                try {
                    a2 = a(str, j2, i <= 0 ? -1L : i + j2, linkedList);
                } catch (BdHttpCancelException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw e3;
                }
            } catch (BdHttpErrorException e4) {
                e = e4;
                j3 = j2;
                i5 = i7;
            } catch (SocketException e5) {
                e = e5;
                i4 = i7;
            } catch (SocketTimeoutException e6) {
                e = e6;
                i4 = i7;
            }
            if (a2 == null) {
                break;
            }
            e a3 = a(a2, true, (byte[]) null, cVar, aVar);
            if (a3 == null || !(a3.a == 200 || a3.a == 206)) {
                j3 = j2;
                i5 = i7;
            } else {
                i4 = 0;
                try {
                    if (a3.d != null && a3.d.length > 0) {
                        arrayList.add(a3.d);
                        j3 = j2 + a3.d.length;
                        i5 = 0;
                    } else {
                        j3 = j2;
                        i5 = 1;
                    }
                } catch (BdHttpErrorException e7) {
                    e = e7;
                    j3 = j2;
                    i5 = 0;
                } catch (SocketException e8) {
                    e = e8;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                }
                try {
                    if (a3.d.length >= i) {
                        if (a3.a == 200) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (BdHttpErrorException e10) {
                    e = e10;
                    if (e.needRetry() && i5 < i2) {
                        i6 = i5 + 1;
                        if (i6 <= i2) {
                        }
                        if (i6 <= i2) {
                        }
                    } else {
                        throw e;
                    }
                } catch (SocketException e11) {
                    e = e11;
                    int i8 = i5;
                    j2 = j3;
                    i4 = i8;
                    if (i4 < i2) {
                        j3 = j2;
                        i6 = i4 + 1;
                        if (i6 <= i2) {
                        }
                        if (i6 <= i2) {
                        }
                    } else {
                        throw e;
                    }
                } catch (SocketTimeoutException e12) {
                    e = e12;
                    int i9 = i5;
                    j2 = j3;
                    i4 = i9;
                    if (i4 < i2) {
                        j3 = j2;
                        i6 = i4 + 1;
                        if (i6 <= i2) {
                        }
                        if (i6 <= i2) {
                        }
                    } else {
                        throw e;
                    }
                }
            }
            if (a3 != null && (a3.a == 204 || a3.a == 416)) {
                break;
            }
            i6 = i5 + 1;
            if (i6 <= i2) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait(i3);
                    }
                } catch (Exception e13) {
                }
            }
            if (i6 <= i2) {
                break;
            }
            i7 = i6;
            j2 = j3;
        }
        return g.a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0097, code lost:
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4 A[LOOP:0: B:78:0x0019->B:59:0x00b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0032 A[EDGE_INSN: B:85:0x0032->B:16:0x0032 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, boolean z, int i, int i2, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        long j;
        int i3;
        int i4;
        long j2;
        HttpURLConnection a2;
        long j3 = 0;
        int i5 = 0;
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            if (z) {
                file.delete();
            } else {
                j3 = file.length();
            }
        }
        while (true) {
            try {
                try {
                    j2 = g.a() ? 2000000L : 200000L;
                    a2 = a(str, j3, j2 <= 0 ? j2 : j3 + j2, linkedList);
                } catch (Exception e2) {
                    e = e2;
                    j = j3;
                    i3 = i5;
                }
                if (a2 == null) {
                    break;
                }
                e a3 = a(a2, true, (byte[]) null, cVar, aVar);
                if (a3 == null || !(a3.a == 200 || a3.a == 206)) {
                    j = j3;
                    i3 = i5;
                } else {
                    try {
                        if (a3.d != null && a3.d.length > 0) {
                            g.a(str2, a3.d, j3);
                            j = j3 + a3.d.length;
                            i3 = 0;
                        } else {
                            j = j3;
                            i3 = 1;
                        }
                        try {
                            if (a3.d.length < j2 || a3.a == 200) {
                                break;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            i4 = i3 + 1;
                            if (i4 <= i) {
                            }
                            if (i4 <= i) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        j = j3;
                        i3 = 0;
                    }
                }
                if (a3 == null || (a3.a != 204 && a3.a != 416)) {
                    i4 = i3 + 1;
                    if (i4 <= i) {
                        try {
                            synchronized (Thread.currentThread()) {
                                Thread.currentThread().wait(i2);
                            }
                        } catch (Exception e5) {
                        }
                    }
                    if (i4 <= i) {
                        break;
                    }
                    i5 = i4;
                    j3 = j;
                }
            } catch (BdHttpCancelException e6) {
            }
        }
        return true;
        return false;
    }

    public static e a(String str, boolean z, int i, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return a(true, z, str, (byte[]) null, i, cVar, aVar, linkedList);
    }

    public static e a(boolean z, String str, byte[] bArr, int i, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return a(false, z, str, bArr, i, cVar, aVar, linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072 A[LOOP:0: B:3:0x000b->B:48:0x0072, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(boolean z, boolean z2, String str, byte[] bArr, int i, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        int i2;
        int i3;
        e eVar;
        int i4 = 0;
        f fVar = new f();
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                eVar = a(z, z2, str, bArr, cVar, aVar, fVar, linkedList);
                i3 = i4;
                break;
            } catch (BdHttpCancelException e2) {
                throw e2;
            } catch (BdHttpErrorException e3) {
                if (e3.needRetry() && i4 < i) {
                    i2 = i4 + 1;
                    if (i2 <= i && i2 > 1) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e4) {
                        }
                    }
                    if (i2 <= i) {
                        i3 = i2;
                        eVar = null;
                        if (fVar != null) {
                            fVar.e = i3;
                            fVar.f = new Date().getTime() - currentTimeMillis;
                        }
                        if (eVar != null) {
                            eVar.c = fVar;
                        }
                        return eVar;
                    }
                    i4 = i2;
                } else {
                    throw e3;
                }
            } catch (SocketException e5) {
                if (i4 < i) {
                    i2 = i4 + 1;
                    if (i2 <= i) {
                        Thread.sleep(100L);
                    }
                    if (i2 <= i) {
                    }
                } else {
                    throw e5;
                }
            } catch (SocketTimeoutException e6) {
                if (i4 < i) {
                    i2 = i4 + 1;
                    if (i2 <= i) {
                    }
                    if (i2 <= i) {
                    }
                } else {
                    throw e6;
                }
            } catch (IOException e7) {
                if (i4 < i) {
                    i2 = i4 + 1;
                    if (i2 <= i) {
                    }
                    if (i2 <= i) {
                    }
                } else {
                    throw e7;
                }
            } catch (Exception e8) {
                throw e8;
            }
            i4 = i2;
        }
        throw e3;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static e a(boolean z, boolean z2, String str, byte[] bArr, c cVar, a aVar, f fVar, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        e a2;
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        DataOutputStream dataOutputStream = null;
        try {
            httpURLConnection = a(str, linkedList);
            try {
                if (fVar != null) {
                    if (z || bArr == null) {
                        fVar.a = str.length();
                    } else {
                        fVar.a = bArr.length;
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
                    if (a) {
                        httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
                    }
                }
                if (z2) {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                }
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(!z);
                httpURLConnection.setUseCaches(false);
                if (aVar != null && aVar.c()) {
                    throw new BdHttpCancelException();
                }
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
                    if (a) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        com.baidu.adp.lib.h.d.b(byteArrayInputStream, byteArrayOutputStream);
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
                    a2.a = responseCode;
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
                } else if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                    throw new BdHttpErrorException("doGetOrPost retry, errorCode:" + responseCode, responseCode, true);
                } else {
                    if (responseCode == 502 || responseCode == 503 || responseCode == 504) {
                        throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                    }
                    throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[LOOP:0: B:5:0x000d->B:22:0x0040, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0025 A[EDGE_INSN: B:54:0x0025->B:12:0x0025 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, c cVar, a aVar, f fVar, LinkedList<BasicNameValuePair> linkedList) {
        e eVar;
        int i2;
        int i3 = 0;
        e eVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        f fVar2 = fVar == null ? new f() : fVar;
        while (true) {
            try {
                try {
                    eVar = a(str, z, arrayList, hashMap, cVar, aVar, fVar2, linkedList);
                    if (eVar != null) {
                        try {
                            if (eVar.a == 200) {
                                i2 = i3;
                                break;
                            }
                        } catch (BdHttpErrorException e2) {
                            e = e2;
                            if (e.needRetry() && i3 < i) {
                                i2 = i3 + 1;
                                if (i2 <= i) {
                                }
                                if (i2 > i) {
                                }
                            } else {
                                throw e;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            if (i3 < i) {
                                i2 = i3 + 1;
                                if (i2 <= i) {
                                }
                                if (i2 > i) {
                                }
                            } else {
                                throw e;
                            }
                        }
                    }
                    i2 = i3 + 1;
                } catch (BdHttpCancelException e4) {
                    throw e4;
                }
            } catch (BdHttpErrorException e5) {
                e = e5;
                eVar = eVar2;
            } catch (Exception e6) {
                e = e6;
                eVar = eVar2;
            }
            if (i2 <= i) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e7) {
                }
            }
            if (i2 > i) {
                break;
            }
            eVar2 = eVar;
            i3 = i2;
        }
        if (fVar2 != null) {
            fVar2.e = i2;
            fVar2.f = System.currentTimeMillis() - currentTimeMillis;
        }
        return eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1315=4, 1318=5] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, c cVar, a aVar, f fVar, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = a(str, linkedList);
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
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + g);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            if (a) {
                httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
            }
            if (z) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            }
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (aVar == null || !aVar.c()) {
                long currentTimeMillis = System.currentTimeMillis();
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
                    if (a) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        if (arrayList != null) {
                            Iterator<BasicNameValuePair> it = arrayList.iterator();
                            while (it.hasNext()) {
                                BasicNameValuePair next = it.next();
                                if (next != null) {
                                    String name = next.getName();
                                    String value = next.getValue();
                                    byteArrayOutputStream.write((f + g + e).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"" + e).getBytes());
                                    byteArrayOutputStream.write(e.getBytes());
                                    if (value == null) {
                                        byteArrayOutputStream.write("null".getBytes("UTF-8"));
                                    } else {
                                        byteArrayOutputStream.write(value.getBytes("UTF-8"));
                                    }
                                    byteArrayOutputStream.write(e.getBytes());
                                }
                            }
                        }
                        if (hashMap != null) {
                            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                                String key = entry.getKey();
                                byte[] value2 = entry.getValue();
                                if (value2 != null) {
                                    byteArrayOutputStream.write((f + g + e).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + e).getBytes());
                                    byteArrayOutputStream.write(e.getBytes());
                                    byteArrayOutputStream.write(value2);
                                    byteArrayOutputStream.write(e.getBytes());
                                    byteArrayOutputStream.write((f + g + f + e).getBytes());
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        com.baidu.adp.lib.h.d.b(byteArrayInputStream, byteArrayOutputStream2);
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            try {
                                dataOutputStream.write(byteArrayOutputStream2.toByteArray());
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
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
                        } catch (Exception e4) {
                            e = e4;
                            httpURLConnection2 = httpURLConnection;
                            throw e;
                        }
                    } else {
                        DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                        if (arrayList != null) {
                            try {
                                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next2 = it2.next();
                                    if (next2 != null) {
                                        String name2 = next2.getName();
                                        String value3 = next2.getValue();
                                        dataOutputStream3.writeBytes(f + g + e);
                                        dataOutputStream3.writeBytes("Content-Disposition: form-data; name=\"" + name2 + "\"" + e);
                                        dataOutputStream3.writeBytes(e);
                                        if (value3 == null) {
                                            dataOutputStream3.write("null".getBytes("UTF-8"));
                                        } else {
                                            dataOutputStream3.write(value3.getBytes("UTF-8"));
                                        }
                                        dataOutputStream3.writeBytes(e);
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
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
                            for (Map.Entry<String, byte[]> entry2 : hashMap.entrySet()) {
                                String key2 = entry2.getKey();
                                byte[] value4 = entry2.getValue();
                                if (value4 != null) {
                                    dataOutputStream3.writeBytes(f + g + e);
                                    dataOutputStream3.writeBytes("Content-Disposition: form-data; name=\"" + key2 + "\"; filename=\"file\"" + e);
                                    dataOutputStream3.writeBytes(e);
                                    dataOutputStream3.write(value4);
                                    dataOutputStream3.writeBytes(e);
                                    dataOutputStream3.writeBytes(f + g + f + e);
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
                            }
                            if (httpURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (aVar == null || !aVar.c()) {
                        if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 416) {
                            if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                                throw new BdHttpErrorException("retry, errorCode:" + responseCode, responseCode, true);
                            }
                            if (responseCode == 502 || responseCode == 503 || responseCode == 504) {
                                throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                            }
                            throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
                        }
                        e a2 = (responseCode == 200 || responseCode == 206) ? a(httpURLConnection, false, cVar, aVar, fVar) : new e();
                        if (aVar == null || !aVar.c()) {
                            a2.a = responseCode;
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
                int intValue = indexOf != -1 ? Integer.valueOf(headerField2.substring(indexOf + 1)).intValue() : 0;
                int indexOf2 = headerField2.indexOf("-");
                if (indexOf2 == -1 || indexOf2 <= 6) {
                    i = 0;
                    i2 = intValue;
                } else {
                    i = Integer.valueOf(headerField2.substring(6, indexOf2)).intValue();
                    i2 = intValue;
                }
            } else {
                i = 0;
            }
            int intValue2 = (i2 == 0 && httpURLConnection.getResponseCode() == 200 && (headerField = httpURLConnection.getHeaderField("Content-Length")) != null) ? Integer.valueOf(headerField).intValue() : i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (cVar != null) {
                cVar.a(intValue2, httpURLConnection, byteArrayOutputStream);
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            if (inputStream2 != null && byteArrayOutputStream != null) {
                byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
                int size = byteArrayOutputStream.size() + i;
                do {
                    read = inputStream2.read(bArr);
                    size += read;
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        if (cVar != null) {
                            cVar.a(size, intValue2, httpURLConnection);
                        }
                    }
                    if (aVar != null && aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                } while (read > 0);
                if (fVar != null) {
                    fVar.b = size;
                }
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                    com.baidu.adp.lib.h.d.a(byteArrayInputStream, byteArrayOutputStream2);
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
}
