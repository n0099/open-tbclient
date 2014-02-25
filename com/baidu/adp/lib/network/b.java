package com.baidu.adp.lib.network;

import android.net.Proxy;
import android.text.TextUtils;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.io.IOUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {
    public static boolean a = true;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    private static String e = IOUtils.LINE_SEPARATOR_WINDOWS;
    private static String f = "--";
    private static String g = "--------7da3d81520810*";

    public static HttpURLConnection a(String str, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        String replaceFirst;
        URL url = new URL(str);
        String defaultHost = Proxy.getDefaultHost();
        if (!i.b()) {
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
        if (i.b(defaultHost)) {
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
                httpURLConnection.setRequestProperty("X-Online-Host", String.valueOf(host) + ":" + i);
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

    public static HttpURLConnection a(String str, long j, long j2, int i, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection a2 = a(str, linkedList);
        a2.setConnectTimeout(10000);
        if (i < 0) {
            i = 30000;
        }
        a2.setReadTimeout(i);
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

    public static f a(HttpURLConnection httpURLConnection, boolean z, byte[] bArr, g gVar, d dVar, a aVar) {
        return a(httpURLConnection, z, bArr, gVar, dVar, aVar, (h) null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [507=4] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(HttpURLConnection httpURLConnection, boolean z, byte[] bArr, g gVar, d dVar, a aVar, h hVar) {
        DataOutputStream dataOutputStream;
        f a2;
        DataOutputStream dataOutputStream2 = null;
        if (aVar != null) {
            try {
                if (aVar.c()) {
                    throw new BdHttpCancelException();
                }
                aVar.a(httpURLConnection);
            } catch (Exception e2) {
                e = e2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
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
                dataOutputStream = null;
                if (dataOutputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                if (aVar != null) {
                }
                throw th;
            }
        }
        if (a && !z && bArr != null && bArr.length != 0) {
            httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (hVar != null) {
            hVar.g = System.currentTimeMillis() - currentTimeMillis;
        }
        httpURLConnection.connect();
        if (hVar != null) {
            hVar.c = (System.currentTimeMillis() - currentTimeMillis) - hVar.g;
        }
        if (aVar == null || !aVar.c()) {
            if (dVar != null) {
                dVar.a();
            }
            if (z || bArr == null || bArr.length == 0) {
                dataOutputStream = null;
            } else {
                if (a) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                }
                DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream3.write(bArr);
                    dataOutputStream3.flush();
                    dataOutputStream3.close();
                    dataOutputStream = dataOutputStream3;
                } catch (Exception e4) {
                    e = e4;
                    dataOutputStream2 = dataOutputStream3;
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = dataOutputStream3;
                    if (dataOutputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (aVar != null) {
                    }
                    throw th;
                }
            }
            if (aVar != null) {
                try {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                } catch (Exception e5) {
                    e = e5;
                    dataOutputStream2 = dataOutputStream;
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    if (dataOutputStream != null) {
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
                if (responseCode == 200 || responseCode == 206) {
                    a2 = a(httpURLConnection, z, gVar, dVar, aVar, hVar);
                    if (hVar != null) {
                        hVar.d = ((System.currentTimeMillis() - currentTimeMillis) - hVar.c) - hVar.g;
                    }
                } else {
                    a2 = new f();
                }
                if (aVar == null || !aVar.c()) {
                    a2.a = responseCode;
                    if (dVar != null && responseCode != 206) {
                        dVar.a(a2);
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x0018 A[EDGE_INSN: B:100:0x0018->B:10:0x0018 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b A[LOOP:0: B:5:0x0009->B:47:0x008b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, long j, int i, ArrayList<byte[]> arrayList, int i2, int i3, int i4, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        long j2;
        int i5;
        long j3;
        int i6;
        int i7;
        HttpURLConnection a2;
        int i8 = 0;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            j2 = j;
        } else {
            j2 = j;
        }
        while (true) {
            try {
                try {
                    a2 = a(str, j2, i <= 0 ? -1L : i + j2, i4, linkedList);
                } catch (BdHttpCancelException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw e3;
                }
            } catch (BdHttpErrorException e4) {
                e = e4;
                j3 = j2;
                i6 = i8;
            } catch (SocketException e5) {
                e = e5;
                i5 = i8;
            } catch (SocketTimeoutException e6) {
                e = e6;
                i5 = i8;
            }
            if (a2 == null) {
                break;
            }
            f a3 = a(a2, true, (byte[]) null, (g) null, dVar, aVar);
            if (a3 == null || !(a3.a == 200 || a3.a == 206)) {
                j3 = j2;
                i6 = i8;
            } else {
                i5 = 0;
                try {
                    if (a3.d != null && a3.d.length > 0) {
                        arrayList.add(a3.d);
                        j3 = j2 + a3.d.length;
                        i6 = 0;
                    } else {
                        j3 = j2;
                        i6 = 1;
                    }
                    try {
                        if (a3.d.length >= i) {
                            if (a3.a == 200) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (BdHttpErrorException e7) {
                        e = e7;
                        if (e.needRetry() && i6 < i2) {
                            i7 = i6 + 1;
                            if (i7 < i2 - 1) {
                            }
                            if (i7 < i2) {
                            }
                        } else {
                            throw e;
                        }
                    } catch (SocketException e8) {
                        e = e8;
                        int i9 = i6;
                        j2 = j3;
                        i5 = i9;
                        if (i5 < i2) {
                            j3 = j2;
                            i7 = i5 + 1;
                            if (i7 < i2 - 1) {
                            }
                            if (i7 < i2) {
                            }
                        } else {
                            throw e;
                        }
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        int i10 = i6;
                        j2 = j3;
                        i5 = i10;
                        if (i5 < i2) {
                            j3 = j2;
                            i7 = i5 + 1;
                            if (i7 < i2 - 1) {
                            }
                            if (i7 < i2) {
                            }
                        } else {
                            throw e;
                        }
                    }
                } catch (BdHttpErrorException e10) {
                    e = e10;
                    j3 = j2;
                    i6 = 0;
                } catch (SocketException e11) {
                    e = e11;
                } catch (SocketTimeoutException e12) {
                    e = e12;
                }
            }
            if (a3 != null && (a3.a == 204 || a3.a == 416)) {
                break;
            }
            i7 = i6 + 1;
            if (i7 < i2 - 1) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait(i3);
                    }
                } catch (Exception e13) {
                }
            }
            if (i7 < i2) {
                break;
            }
            i8 = i7;
            j2 = j3;
        }
        return i.a(arrayList);
    }

    public static boolean a(String str, String str2, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        long j;
        HttpURLConnection a2;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicLong atomicLong = new AtomicLong(0L);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            if (z) {
                file.delete();
            } else {
                atomicLong.set(file.length());
            }
        }
        c cVar = new c(atomicInteger2, str2, atomicLong, atomicInteger);
        do {
            try {
                j = i.a() ? 2000000 : 200000;
                a2 = a(str, atomicLong.longValue(), j <= 0 ? j : atomicLong.longValue() + j, i3, linkedList);
            } catch (BdHttpCancelException e2) {
            } catch (Exception e3) {
                e3.printStackTrace();
                atomicInteger2.incrementAndGet();
            }
            if (a2 == null) {
                break;
            }
            atomicInteger.set(0);
            f a3 = a(a2, true, (byte[]) null, (g) cVar, dVar, aVar);
            if (a3 != null && (atomicInteger.longValue() < j || a3.a == 200)) {
                return true;
            }
            if (a3 != null && (a3.a == 204 || a3.a == 416)) {
                return true;
            }
            atomicInteger2.incrementAndGet();
            if (atomicInteger2.intValue() <= i) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait(i2);
                    }
                } catch (Exception e4) {
                }
            }
        } while (atomicInteger2.intValue() < i);
        return false;
    }

    public static f a(String str, boolean z, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return a(true, z, str, (byte[]) null, i, i2, dVar, aVar, linkedList);
    }

    public static f a(boolean z, String str, byte[] bArr, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return a(false, z, str, bArr, i, i2, dVar, aVar, linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075 A[LOOP:0: B:3:0x000b->B:48:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0052 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(boolean z, boolean z2, String str, byte[] bArr, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        int i3;
        int i4;
        f fVar;
        int i5 = 0;
        h hVar = new h();
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                fVar = a(z, z2, str, bArr, dVar, i2, aVar, hVar, linkedList);
                i4 = i5;
                break;
            } catch (BdHttpCancelException e2) {
                throw e2;
            } catch (BdHttpErrorException e3) {
                if (e3.needRetry() && i5 < i) {
                    i3 = i5 + 1;
                    if (i3 < i - 1 && i3 > 1) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e4) {
                        }
                    }
                    if (i3 < i) {
                        i4 = i3;
                        fVar = null;
                        if (hVar != null) {
                            hVar.e = i4;
                            hVar.f = new Date().getTime() - currentTimeMillis;
                        }
                        if (fVar != null) {
                            fVar.c = hVar;
                        }
                        return fVar;
                    }
                    i5 = i3;
                } else {
                    throw e3;
                }
            } catch (SocketException e5) {
                if (i5 < i) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                        Thread.sleep(100L);
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e5;
                }
            } catch (SocketTimeoutException e6) {
                if (i5 < i) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e6;
                }
            } catch (IOException e7) {
                if (i5 < i) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e7;
                }
            } catch (Exception e8) {
                throw e8;
            }
            i5 = i3;
        }
        throw e3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1090=4] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f a(boolean z, boolean z2, String str, byte[] bArr, d dVar, int i, a aVar, h hVar, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        DataOutputStream dataOutputStream3 = null;
        try {
            HttpURLConnection a2 = a(str, linkedList);
            try {
                if (hVar != null) {
                    if (z || bArr == null) {
                        hVar.a = str.length();
                    } else {
                        hVar.a = bArr.length;
                    }
                }
                if (aVar != null) {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(a2);
                }
                if (z) {
                    a2.setRequestMethod("GET");
                } else {
                    a2.setRequestMethod("POST");
                    a2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    if (a) {
                        a2.setRequestProperty("Post-Encoding", "gzip");
                    }
                }
                if (z2) {
                    a2.setRequestProperty("Accept-Encoding", "gzip");
                }
                a2.setConnectTimeout(10000);
                if (i < 0) {
                    i = 30000;
                }
                a2.setReadTimeout(i);
                a2.setDoInput(true);
                a2.setDoOutput(!z);
                a2.setUseCaches(false);
                if (aVar == null || !aVar.c()) {
                    if (hVar != null) {
                        hVar.g = System.currentTimeMillis() - currentTimeMillis;
                    }
                    a2.connect();
                    if (hVar != null) {
                        hVar.c = (System.currentTimeMillis() - currentTimeMillis) - hVar.g;
                    }
                    if (aVar == null || !aVar.c()) {
                        if (dVar != null) {
                            dVar.a();
                        }
                        if (z || bArr == null || bArr.length == 0) {
                            dataOutputStream2 = null;
                        } else {
                            if (a) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream);
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            DataOutputStream dataOutputStream4 = new DataOutputStream(a2.getOutputStream());
                            try {
                                dataOutputStream4.write(bArr);
                                dataOutputStream4.flush();
                                dataOutputStream4.close();
                                dataOutputStream2 = dataOutputStream4;
                            } catch (Exception e2) {
                                httpURLConnection = a2;
                                e = e2;
                                dataOutputStream = dataOutputStream4;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    DataOutputStream dataOutputStream5 = dataOutputStream;
                                    httpURLConnection2 = httpURLConnection;
                                    dataOutputStream3 = dataOutputStream5;
                                    if (dataOutputStream3 != null) {
                                        try {
                                            dataOutputStream3.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    if (aVar != null) {
                                        aVar.b();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                dataOutputStream3 = dataOutputStream4;
                                httpURLConnection2 = a2;
                                th = th2;
                                if (dataOutputStream3 != null) {
                                }
                                if (httpURLConnection2 != null) {
                                }
                                if (aVar != null) {
                                }
                                throw th;
                            }
                        }
                        if (aVar != null) {
                            try {
                                if (aVar.c()) {
                                    throw new BdHttpCancelException();
                                }
                            } catch (Exception e4) {
                                httpURLConnection = a2;
                                e = e4;
                                dataOutputStream = dataOutputStream2;
                                throw e;
                            } catch (Throwable th3) {
                                dataOutputStream3 = dataOutputStream2;
                                httpURLConnection2 = a2;
                                th = th3;
                                if (dataOutputStream3 != null) {
                                }
                                if (httpURLConnection2 != null) {
                                }
                                if (aVar != null) {
                                }
                                throw th;
                            }
                        }
                        int responseCode = a2.getResponseCode();
                        if (aVar == null || !aVar.c()) {
                            if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 413 && responseCode != 416) {
                                if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                                    throw new BdHttpErrorException("doGetOrPost retry, errorCode:" + responseCode, responseCode, true);
                                }
                                if (responseCode == 502 || responseCode == 503 || responseCode == 504) {
                                    throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                                }
                                throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
                            }
                            f a3 = (responseCode == 200 || responseCode == 206) ? a(a2, z, (g) null, dVar, aVar, hVar) : new f();
                            if (aVar == null || !aVar.c()) {
                                a3.a = responseCode;
                                if (hVar != null) {
                                    hVar.d = ((new Date().getTime() - currentTimeMillis) - hVar.c) - hVar.g;
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (a2 != null) {
                                    a2.disconnect();
                                }
                                if (aVar != null) {
                                    aVar.b();
                                }
                                return a3;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Exception e6) {
                dataOutputStream = null;
                httpURLConnection = a2;
                e = e6;
            } catch (Throwable th4) {
                httpURLConnection2 = a2;
                th = th4;
            }
        } catch (Exception e7) {
            e = e7;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[LOOP:0: B:5:0x000d->B:22:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0028 A[EDGE_INSN: B:50:0x0028->B:12:0x0028 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, h hVar, LinkedList<BasicNameValuePair> linkedList) {
        f fVar;
        int i3;
        int i4 = 0;
        f fVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        h hVar2 = hVar == null ? new h() : hVar;
        while (true) {
            try {
                try {
                    fVar = a(str, z, arrayList, hashMap, i2, dVar, aVar, hVar2, linkedList);
                    if (fVar != null) {
                        try {
                            if (fVar.a == 200) {
                                i3 = i4;
                                break;
                            }
                        } catch (BdHttpErrorException e2) {
                            e = e2;
                            if (e.needRetry() && i4 < i) {
                                i3 = i4 + 1;
                                if (i3 < i - 1) {
                                }
                                if (i3 >= i) {
                                }
                            } else {
                                throw e;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            if (i4 < i) {
                                i3 = i4 + 1;
                                if (i3 < i - 1) {
                                }
                                if (i3 >= i) {
                                }
                            } else {
                                throw e;
                            }
                        }
                    }
                    i3 = i4 + 1;
                } catch (BdHttpCancelException e4) {
                    throw e4;
                }
            } catch (BdHttpErrorException e5) {
                e = e5;
                fVar = fVar2;
            } catch (Exception e6) {
                e = e6;
                fVar = fVar2;
            }
            if (i3 < i - 1) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e7) {
                }
            }
            if (i3 >= i) {
                break;
            }
            fVar2 = fVar;
            i4 = i3;
        }
        if (hVar2 != null) {
            hVar2.e = i3;
            hVar2.f = System.currentTimeMillis() - currentTimeMillis;
        }
        return fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1362=4, 1364=5] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, d dVar, a aVar, h hVar, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3 = null;
        try {
            HttpURLConnection a2 = a(str, linkedList);
            if (aVar != null) {
                try {
                    if (aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(a2);
                } catch (Exception e2) {
                    httpURLConnection = a2;
                    e = e2;
                    dataOutputStream = null;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream3 = dataOutputStream;
                        if (dataOutputStream3 != null) {
                            try {
                                dataOutputStream3.close();
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
                    httpURLConnection = a2;
                    th = th2;
                    if (dataOutputStream3 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (aVar != null) {
                    }
                    throw th;
                }
            }
            a2.setRequestMethod("POST");
            a2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + g);
            a2.setRequestProperty("Charset", "UTF-8");
            if (a) {
                a2.setRequestProperty("Post-Encoding", "gzip");
            }
            if (z) {
                a2.setRequestProperty("Accept-Encoding", "gzip");
            }
            a2.setConnectTimeout(10000);
            if (i < 0) {
                i = 30000;
            }
            a2.setReadTimeout(i);
            a2.setDoInput(true);
            a2.setDoOutput(true);
            a2.setUseCaches(false);
            if (aVar == null || !aVar.c()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (hVar != null) {
                    hVar.g = new Date().getTime() - currentTimeMillis;
                }
                a2.connect();
                if (hVar != null) {
                    hVar.c = (System.currentTimeMillis() - currentTimeMillis) - hVar.g;
                }
                if (aVar == null || !aVar.c()) {
                    if (dVar != null) {
                        dVar.a();
                    }
                    if (a) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        if (arrayList != null) {
                            Iterator<BasicNameValuePair> it = arrayList.iterator();
                            while (it.hasNext()) {
                                BasicNameValuePair next = it.next();
                                if (next != null) {
                                    String name = next.getName();
                                    String value = next.getValue();
                                    byteArrayOutputStream.write((String.valueOf(f) + g + e).getBytes());
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
                                    byteArrayOutputStream.write((String.valueOf(f) + g + e).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + e).getBytes());
                                    byteArrayOutputStream.write(e.getBytes());
                                    byteArrayOutputStream.write(value2);
                                    byteArrayOutputStream.write(e.getBytes());
                                    byteArrayOutputStream.write((String.valueOf(f) + g + f + e).getBytes());
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream2);
                        DataOutputStream dataOutputStream4 = new DataOutputStream(a2.getOutputStream());
                        try {
                            dataOutputStream4.write(byteArrayOutputStream2.toByteArray());
                            dataOutputStream4.flush();
                            dataOutputStream4.close();
                            dataOutputStream2 = dataOutputStream4;
                        } catch (Exception e4) {
                            dataOutputStream = dataOutputStream4;
                            httpURLConnection = a2;
                            e = e4;
                            throw e;
                        } catch (Throwable th3) {
                            dataOutputStream3 = dataOutputStream4;
                            httpURLConnection = a2;
                            th = th3;
                            if (dataOutputStream3 != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    } else {
                        DataOutputStream dataOutputStream5 = new DataOutputStream(a2.getOutputStream());
                        if (arrayList != null) {
                            try {
                                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next2 = it2.next();
                                    if (next2 != null) {
                                        String name2 = next2.getName();
                                        String value3 = next2.getValue();
                                        dataOutputStream5.writeBytes(String.valueOf(f) + g + e);
                                        dataOutputStream5.writeBytes("Content-Disposition: form-data; name=\"" + name2 + "\"" + e);
                                        dataOutputStream5.writeBytes(e);
                                        if (value3 == null) {
                                            dataOutputStream5.write("null".getBytes("UTF-8"));
                                        } else {
                                            dataOutputStream5.write(value3.getBytes("UTF-8"));
                                        }
                                        dataOutputStream5.writeBytes(e);
                                    }
                                }
                            } catch (Exception e5) {
                                httpURLConnection = a2;
                                e = e5;
                                dataOutputStream = dataOutputStream5;
                                throw e;
                            } catch (Throwable th4) {
                                dataOutputStream3 = dataOutputStream5;
                                httpURLConnection = a2;
                                th = th4;
                                if (dataOutputStream3 != null) {
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
                                    dataOutputStream5.writeBytes(String.valueOf(f) + g + e);
                                    dataOutputStream5.writeBytes("Content-Disposition: form-data; name=\"" + key2 + "\"; filename=\"file\"" + e);
                                    dataOutputStream5.writeBytes(e);
                                    dataOutputStream5.write(value4);
                                    dataOutputStream5.writeBytes(e);
                                    dataOutputStream5.writeBytes(String.valueOf(f) + g + f + e);
                                }
                            }
                        }
                        dataOutputStream5.flush();
                        dataOutputStream5.close();
                        dataOutputStream2 = dataOutputStream5;
                    }
                    if (aVar != null) {
                        try {
                            if (aVar.c()) {
                                throw new BdHttpCancelException();
                            }
                        } catch (Exception e6) {
                            httpURLConnection = a2;
                            e = e6;
                            dataOutputStream = dataOutputStream2;
                            throw e;
                        } catch (Throwable th5) {
                            dataOutputStream3 = dataOutputStream2;
                            httpURLConnection = a2;
                            th = th5;
                            if (dataOutputStream3 != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    }
                    int responseCode = a2.getResponseCode();
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
                        f a3 = (responseCode == 200 || responseCode == 206) ? a(a2, false, (g) null, dVar, aVar, hVar) : new f();
                        if (aVar == null || !aVar.c()) {
                            a3.a = responseCode;
                            if (hVar != null) {
                                hVar.d = ((System.currentTimeMillis() - currentTimeMillis) - hVar.c) - hVar.g;
                            }
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e7) {
                                }
                            }
                            if (a2 != null) {
                                a2.disconnect();
                            }
                            if (aVar != null) {
                                aVar.b();
                            }
                            return a3;
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            }
            throw new BdHttpCancelException();
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    private static f a(HttpURLConnection httpURLConnection, boolean z, g gVar, d dVar, a aVar, h hVar) {
        int i;
        int i2;
        int read;
        String headerField;
        InputStream inputStream = null;
        try {
            f fVar = new f();
            String contentType = httpURLConnection.getContentType();
            fVar.e = i.d(contentType);
            if (z && i.c(contentType)) {
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
                i2 = 0;
            }
            int intValue2 = (i2 == 0 && httpURLConnection.getResponseCode() == 200 && (headerField = httpURLConnection.getHeaderField("Content-Length")) != null) ? Integer.valueOf(headerField).intValue() : i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (dVar != null) {
                dVar.a(intValue2, httpURLConnection, byteArrayOutputStream);
            }
            String contentEncoding = httpURLConnection.getContentEncoding();
            boolean z2 = contentEncoding != null && contentEncoding.contains("gzip");
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (aVar != null && aVar.c()) {
                throw new BdHttpCancelException();
            }
            if (inputStream2 != null && byteArrayOutputStream != null) {
                byte[] bArr = new byte[4096];
                int size = byteArrayOutputStream.size() + i;
                do {
                    read = inputStream2.read(bArr);
                    size += read;
                    if (read > 0) {
                        if (!z2 && gVar != null) {
                            gVar.a(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (dVar != null) {
                            dVar.a(size, intValue2, httpURLConnection);
                        }
                    }
                    if (aVar != null && aVar.c()) {
                        throw new BdHttpCancelException();
                    }
                } while (read > 0);
                if (hVar != null) {
                    hVar.b = size;
                }
                if (z2) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(4096);
                    com.baidu.adp.lib.util.e.a(byteArrayInputStream, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (gVar != null) {
                        gVar.a(byteArray, 0, byteArray.length);
                    } else {
                        fVar.d = byteArray;
                    }
                } else if (gVar == null) {
                    fVar.d = byteArrayOutputStream.toByteArray();
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e2) {
                }
            }
            return fVar;
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
