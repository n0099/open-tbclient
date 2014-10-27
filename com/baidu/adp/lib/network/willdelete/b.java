package com.baidu.adp.lib.network.willdelete;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
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
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {
    public static boolean kK = true;
    public static String cookie = "";
    public static String kL = "";
    public static String uid = "";
    private static String kM = "\r\n";
    private static String kN = "--";
    private static String kf = "--------7da3d81520810*";

    public static HttpURLConnection a(String str, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        String replaceFirst;
        URL url = new URL(str);
        String fq = j.fq();
        if (!j.fe()) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (!TextUtils.isEmpty(cookie)) {
                httpURLConnection2.setRequestProperty("Cookie", cookie);
            } else {
                httpURLConnection2.setRequestProperty("Cookie", "");
            }
            if (!TextUtils.isEmpty(kL)) {
                httpURLConnection2.setRequestProperty("User-Agent", kL);
            }
            if (!TextUtils.isEmpty(uid)) {
                httpURLConnection2.setRequestProperty("client_user_token", uid);
            }
            a(httpURLConnection2, linkedList);
            return httpURLConnection2;
        }
        int fr = j.fr();
        if (fr == -1) {
            fr = 80;
        }
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fq, fr));
        if (j.ay(fq)) {
            String host = url.getHost();
            int port = url.getPort();
            int i = port != -1 ? port : 80;
            if (str.indexOf(String.valueOf(host) + ":" + i) != -1) {
                replaceFirst = str.replaceFirst(String.valueOf(host) + ":" + i, String.valueOf(fq) + ":" + fr);
            } else {
                replaceFirst = str.replaceFirst(host, String.valueOf(fq) + ":" + fr);
            }
            try {
                httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
                httpURLConnection.setRequestProperty("X-Online-Host", String.valueOf(host) + ":" + i);
            } catch (MalformedURLException e) {
                return null;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        }
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.setRequestProperty("Cookie", cookie);
        } else {
            httpURLConnection.setRequestProperty("Cookie", "");
        }
        if (!TextUtils.isEmpty(kL)) {
            httpURLConnection.setRequestProperty("User-Agent", kL);
        }
        if (!TextUtils.isEmpty(uid)) {
            httpURLConnection.setRequestProperty("client_user_token", uid);
        }
        a(httpURLConnection, linkedList);
        return httpURLConnection;
    }

    public static HttpURLConnection a(String str, long j, long j2, int i, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection a = a(str, linkedList);
        a.setConnectTimeout(TbConfig.BIG_IMAGE_MIN_CAPACITY);
        if (i < 0) {
            i = 30000;
        }
        a.setReadTimeout(i);
        a.setRequestMethod("GET");
        a.setDoInput(true);
        a.setUseCaches(false);
        a.setRequestProperty("Range", "bytes=" + j + "-" + (j2 > 0 ? Long.valueOf(j2) : ""));
        if (!TextUtils.isEmpty(cookie)) {
            a.setRequestProperty("Cookie", cookie);
        } else {
            a.setRequestProperty("Cookie", "");
        }
        if (!TextUtils.isEmpty(kL)) {
            a.setRequestProperty("User-Agent", kL);
        }
        a.connect();
        return a;
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
        return a(httpURLConnection, z, bArr, gVar, dVar, aVar, (com.baidu.adp.lib.network.http.d) null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [510=4] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(HttpURLConnection httpURLConnection, boolean z, byte[] bArr, g gVar, d dVar, a aVar, com.baidu.adp.lib.network.http.d dVar2) {
        DataOutputStream dataOutputStream;
        f a;
        DataOutputStream dataOutputStream2 = null;
        if (aVar != null) {
            try {
                if (aVar.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                aVar.d(httpURLConnection);
            } catch (Exception e) {
                e = e;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (aVar != null) {
                        aVar.finish();
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
        if (kK && !z && bArr != null && bArr.length != 0) {
            httpURLConnection.setRequestProperty("Post-Encoding", "gzip");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (dVar2 != null) {
            dVar2.kq = System.currentTimeMillis() - currentTimeMillis;
        }
        httpURLConnection.connect();
        if (dVar2 != null) {
            dVar2.km = (System.currentTimeMillis() - currentTimeMillis) - dVar2.kq;
        }
        if (aVar == null || !aVar.isCanceled()) {
            if (dVar != null) {
                dVar.dX();
            }
            if (z || bArr == null || bArr.length == 0) {
                dataOutputStream = null;
            } else {
                if (kK) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                }
                DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream3.write(bArr);
                    dataOutputStream3.flush();
                    dataOutputStream3.close();
                    dataOutputStream = dataOutputStream3;
                } catch (Exception e3) {
                    e = e3;
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
                    if (aVar.isCanceled()) {
                        throw new BdHttpCancelException();
                    }
                } catch (Exception e4) {
                    e = e4;
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
            if (aVar == null || !aVar.isCanceled()) {
                if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 416) {
                    if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                        throw new BdHttpErrorException("retry, errorCode:" + responseCode, responseCode, true);
                    }
                    if (responseCode == 502 || responseCode == 503 || responseCode == 504 || responseCode == 404) {
                        throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                    }
                    throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
                }
                if (responseCode == 200 || responseCode == 206) {
                    a = a(httpURLConnection, z, gVar, dVar, aVar, dVar2);
                    if (dVar2 != null) {
                        dVar2.ko = ((System.currentTimeMillis() - currentTimeMillis) - dVar2.km) - dVar2.kq;
                    }
                } else {
                    a = new f();
                }
                if (aVar == null || !aVar.isCanceled()) {
                    a.kU = responseCode;
                    if (dVar != null && responseCode != 206) {
                        dVar.a(a);
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
                        aVar.finish();
                    }
                    return a;
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
        HttpURLConnection a;
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
                    a = a(str, j2, i <= 0 ? -1L : i + j2, i4, linkedList);
                } catch (BdHttpCancelException e) {
                    throw e;
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (BdHttpErrorException e3) {
                e = e3;
                j3 = j2;
                i6 = i8;
            } catch (SocketException e4) {
                e = e4;
                i5 = i8;
            } catch (SocketTimeoutException e5) {
                e = e5;
                i5 = i8;
            }
            if (a == null) {
                break;
            }
            f a2 = a(a, true, (byte[]) null, (g) null, dVar, aVar);
            if (a2 == null || !(a2.kU == 200 || a2.kU == 206)) {
                j3 = j2;
                i6 = i8;
            } else {
                i5 = 0;
                try {
                    if (a2.data != null && a2.data.length > 0) {
                        arrayList.add(a2.data);
                        j3 = j2 + a2.data.length;
                        i6 = 0;
                    } else {
                        j3 = j2;
                        i6 = 1;
                    }
                    try {
                        if (a2.data.length >= i) {
                            if (a2.kU == 200) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (BdHttpErrorException e6) {
                        e = e6;
                        if (e.needRetry() && i6 < i2 - 1) {
                            i7 = i6 + 1;
                            if (i7 < i2 - 1) {
                            }
                            if (i7 < i2) {
                            }
                        } else {
                            throw e;
                        }
                    } catch (SocketException e7) {
                        e = e7;
                        int i9 = i6;
                        j2 = j3;
                        i5 = i9;
                        if (i5 < i2 - 1) {
                            j3 = j2;
                            i7 = i5 + 1;
                            if (i7 < i2 - 1) {
                            }
                            if (i7 < i2) {
                            }
                        } else {
                            throw e;
                        }
                    } catch (SocketTimeoutException e8) {
                        e = e8;
                        int i10 = i6;
                        j2 = j3;
                        i5 = i10;
                        if (i5 < i2 - 1) {
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
                } catch (BdHttpErrorException e9) {
                    e = e9;
                    j3 = j2;
                    i6 = 0;
                } catch (SocketException e10) {
                    e = e10;
                } catch (SocketTimeoutException e11) {
                    e = e11;
                }
            }
            if (a2 != null && (a2.kU == 204 || a2.kU == 416)) {
                break;
            }
            i7 = i6 + 1;
            if (i7 < i2 - 1) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait(i3);
                    }
                } catch (Exception e12) {
                }
            }
            if (i7 < i2) {
                break;
            }
            i8 = i7;
            j2 = j3;
        }
        return h.c(arrayList);
    }

    public static boolean a(String str, String str2, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        long j;
        HttpURLConnection a;
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
        c cVar = new c(atomicInteger2, str2, atomicLong, atomicInteger, file);
        do {
            try {
                j = j.fi() ? 2000000 : 200000;
                a = a(str, atomicLong.longValue(), j <= 0 ? j : atomicLong.longValue() + j, i3, linkedList);
            } catch (BdHttpCancelException e) {
            } catch (Exception e2) {
                e2.printStackTrace();
                atomicInteger2.incrementAndGet();
            }
            if (a == null) {
                break;
            }
            atomicInteger.set(0);
            f a2 = a(a, true, (byte[]) null, (g) cVar, dVar, aVar);
            if (a2 != null && (atomicInteger.longValue() < j || a2.kU == 200)) {
                return true;
            }
            if (a2 != null && (a2.kU == 204 || a2.kU == 416)) {
                return true;
            }
            atomicInteger2.incrementAndGet();
            if (atomicInteger2.intValue() <= i) {
                try {
                    synchronized (Thread.currentThread()) {
                        Thread.currentThread().wait(i2);
                    }
                } catch (Exception e3) {
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
        com.baidu.adp.lib.network.http.d dVar2 = new com.baidu.adp.lib.network.http.d();
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                fVar = a(z, z2, str, bArr, dVar, i2, aVar, dVar2, linkedList);
                i4 = i5;
                break;
            } catch (BdHttpCancelException e) {
                throw e;
            } catch (BdHttpErrorException e2) {
                if (e2.needRetry() && i5 < i - 1) {
                    i3 = i5 + 1;
                    if (i3 < i - 1 && i3 > 1) {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e3) {
                        }
                    }
                    if (i3 < i) {
                        i4 = i3;
                        fVar = null;
                        if (dVar2 != null) {
                            dVar2.retry = i4;
                            dVar2.kp = new Date().getTime() - currentTimeMillis;
                        }
                        if (fVar != null) {
                            fVar.kW = dVar2;
                        }
                        return fVar;
                    }
                    i5 = i3;
                } else {
                    throw e2;
                }
            } catch (SocketException e4) {
                if (i5 < i - 1) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                        Thread.sleep(100L);
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e4;
                }
            } catch (SocketTimeoutException e5) {
                if (i5 < i - 1) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e5;
                }
            } catch (IOException e6) {
                if (i5 < i - 1) {
                    i3 = i5 + 1;
                    if (i3 < i - 1) {
                    }
                    if (i3 < i) {
                    }
                } else {
                    throw e6;
                }
            } catch (Exception e7) {
                throw e7;
            }
            i5 = i3;
        }
        throw e2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1108=5] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f a(boolean z, boolean z2, String str, byte[] bArr, d dVar, int i, a aVar, com.baidu.adp.lib.network.http.d dVar2, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        DataOutputStream dataOutputStream3 = null;
        try {
            try {
                HttpURLConnection a = a(str, linkedList);
                try {
                    if (dVar2 != null) {
                        if (z || bArr == null) {
                            dVar2.kk = str.length();
                        } else {
                            dVar2.kk = bArr.length;
                        }
                    }
                    if (aVar != null) {
                        if (aVar.isCanceled()) {
                            throw new BdHttpCancelException();
                        }
                        aVar.d(a);
                    }
                    if (z) {
                        a.setRequestMethod("GET");
                    } else {
                        a.setRequestMethod("POST");
                        a.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (kK) {
                            a.setRequestProperty("Post-Encoding", "gzip");
                        }
                    }
                    if (z2) {
                        a.setRequestProperty("Accept-Encoding", "gzip");
                    }
                    a.setConnectTimeout(TbConfig.BIG_IMAGE_MIN_CAPACITY);
                    if (i < 0) {
                        i = 30000;
                    }
                    a.setReadTimeout(i);
                    a.setDoInput(true);
                    a.setDoOutput(!z);
                    a.setUseCaches(false);
                    if (aVar == null || !aVar.isCanceled()) {
                        if (dVar2 != null) {
                            dVar2.kq = System.currentTimeMillis() - currentTimeMillis;
                        }
                        a.connect();
                        if (dVar2 != null) {
                            dVar2.km = (System.currentTimeMillis() - currentTimeMillis) - dVar2.kq;
                        }
                        if (aVar == null || !aVar.isCanceled()) {
                            if (dVar != null) {
                                dVar.dX();
                            }
                            if (z || bArr == null || bArr.length == 0) {
                                dataOutputStream2 = null;
                            } else {
                                if (kK) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                    com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
                                    bArr = byteArrayOutputStream.toByteArray();
                                }
                                DataOutputStream dataOutputStream4 = new DataOutputStream(a.getOutputStream());
                                try {
                                    dataOutputStream4.write(bArr);
                                    dataOutputStream4.flush();
                                    dataOutputStream4.close();
                                    dataOutputStream2 = dataOutputStream4;
                                } catch (Exception e) {
                                    httpURLConnection = a;
                                    e = e;
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
                                            } catch (Exception e2) {
                                            }
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        if (aVar != null) {
                                            aVar.finish();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw new BdHttpErrorException("open socket error:" + th.getMessage(), th);
                                }
                            }
                            if (aVar != null) {
                                try {
                                    if (aVar.isCanceled()) {
                                        throw new BdHttpCancelException();
                                    }
                                } catch (Exception e3) {
                                    httpURLConnection = a;
                                    e = e3;
                                    dataOutputStream = dataOutputStream2;
                                    throw e;
                                } catch (Throwable th3) {
                                    dataOutputStream3 = dataOutputStream2;
                                    httpURLConnection2 = a;
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
                            int responseCode = a.getResponseCode();
                            if (aVar == null || !aVar.isCanceled()) {
                                if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 413 && responseCode != 416) {
                                    if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                                        throw new BdHttpErrorException("doGetOrPost retry, errorCode:" + responseCode, responseCode, true);
                                    }
                                    if (responseCode == 502 || responseCode == 503 || responseCode == 504 || responseCode == 404) {
                                        throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                                    }
                                    throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
                                }
                                f a2 = (responseCode == 200 || responseCode == 206) ? a(a, z, (g) null, dVar, aVar, dVar2) : new f();
                                if (aVar == null || !aVar.isCanceled()) {
                                    a2.kU = responseCode;
                                    if (dVar2 != null) {
                                        dVar2.ko = ((new Date().getTime() - currentTimeMillis) - dVar2.km) - dVar2.kq;
                                    }
                                    if (dataOutputStream2 != null) {
                                        try {
                                            dataOutputStream2.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    if (a != null) {
                                        a.disconnect();
                                    }
                                    if (aVar != null) {
                                        aVar.finish();
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
                } catch (Exception e5) {
                    dataOutputStream = null;
                    httpURLConnection = a;
                    e = e5;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[LOOP:0: B:5:0x000d->B:22:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0028 A[EDGE_INSN: B:50:0x0028->B:12:0x0028 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, com.baidu.adp.lib.network.http.d dVar2, LinkedList<BasicNameValuePair> linkedList) {
        f fVar;
        int i3;
        int i4 = 0;
        f fVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.lib.network.http.d dVar3 = dVar2 == null ? new com.baidu.adp.lib.network.http.d() : dVar2;
        while (true) {
            try {
                try {
                    fVar = a(str, z, arrayList, hashMap, i2, dVar, aVar, dVar3, linkedList);
                    if (fVar != null) {
                        try {
                            if (fVar.kU == 200) {
                                i3 = i4;
                                break;
                            }
                        } catch (BdHttpErrorException e) {
                            e = e;
                            if (e.needRetry() && i4 < i - 1) {
                                i3 = i4 + 1;
                                if (i3 < i - 1) {
                                }
                                if (i3 >= i) {
                                }
                            } else {
                                throw e;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (i4 < i - 1) {
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
                } catch (BdHttpCancelException e3) {
                    throw e3;
                }
            } catch (BdHttpErrorException e4) {
                e = e4;
                fVar = fVar2;
            } catch (Exception e5) {
                e = e5;
                fVar = fVar2;
            }
            if (i3 < i - 1) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e6) {
                }
            }
            if (i3 >= i) {
                break;
            }
            fVar2 = fVar;
            i4 = i3;
        }
        if (dVar3 != null) {
            dVar3.retry = i3;
            dVar3.kp = System.currentTimeMillis() - currentTimeMillis;
        }
        return fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1381=4, 1383=5] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, d dVar, a aVar, com.baidu.adp.lib.network.http.d dVar2, LinkedList<BasicNameValuePair> linkedList) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3 = null;
        try {
            HttpURLConnection a = a(str, linkedList);
            if (aVar != null) {
                try {
                    if (aVar.isCanceled()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.d(a);
                } catch (Exception e) {
                    httpURLConnection = a;
                    e = e;
                    dataOutputStream = null;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream3 = dataOutputStream;
                        if (dataOutputStream3 != null) {
                            try {
                                dataOutputStream3.close();
                            } catch (Exception e2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (aVar != null) {
                            aVar.finish();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    httpURLConnection = a;
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
            a.setRequestMethod("POST");
            a.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + kf);
            a.setRequestProperty("Charset", "UTF-8");
            if (kK) {
                a.setRequestProperty("Post-Encoding", "gzip");
            }
            if (z) {
                a.setRequestProperty("Accept-Encoding", "gzip");
            }
            a.setConnectTimeout(TbConfig.BIG_IMAGE_MIN_CAPACITY);
            if (i < 0) {
                i = 30000;
            }
            a.setReadTimeout(i);
            a.setDoInput(true);
            a.setDoOutput(true);
            a.setUseCaches(false);
            if (aVar == null || !aVar.isCanceled()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (dVar2 != null) {
                    dVar2.kq = new Date().getTime() - currentTimeMillis;
                }
                a.connect();
                if (dVar2 != null) {
                    dVar2.km = (System.currentTimeMillis() - currentTimeMillis) - dVar2.kq;
                }
                if (aVar == null || !aVar.isCanceled()) {
                    if (dVar != null) {
                        dVar.dX();
                    }
                    if (kK) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        if (arrayList != null) {
                            Iterator<BasicNameValuePair> it = arrayList.iterator();
                            while (it.hasNext()) {
                                BasicNameValuePair next = it.next();
                                if (next != null) {
                                    String name = next.getName();
                                    String value = next.getValue();
                                    byteArrayOutputStream.write((String.valueOf(kN) + kf + kM).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"" + kM).getBytes());
                                    byteArrayOutputStream.write(kM.getBytes());
                                    if (value == null) {
                                        byteArrayOutputStream.write("null".getBytes("UTF-8"));
                                    } else {
                                        byteArrayOutputStream.write(value.getBytes("UTF-8"));
                                    }
                                    byteArrayOutputStream.write(kM.getBytes());
                                }
                            }
                        }
                        if (hashMap != null) {
                            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                                String key = entry.getKey();
                                byte[] value2 = entry.getValue();
                                if (value2 != null) {
                                    byteArrayOutputStream.write((String.valueOf(kN) + kf + kM).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + kM).getBytes());
                                    byteArrayOutputStream.write(kM.getBytes());
                                    byteArrayOutputStream.write(value2);
                                    byteArrayOutputStream.write(kM.getBytes());
                                    byteArrayOutputStream.write((String.valueOf(kN) + kf + kN + kM).getBytes());
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream2);
                        DataOutputStream dataOutputStream4 = new DataOutputStream(a.getOutputStream());
                        try {
                            dataOutputStream4.write(byteArrayOutputStream2.toByteArray());
                            dataOutputStream4.flush();
                            dataOutputStream4.close();
                            dataOutputStream2 = dataOutputStream4;
                        } catch (Exception e3) {
                            dataOutputStream = dataOutputStream4;
                            httpURLConnection = a;
                            e = e3;
                            throw e;
                        } catch (Throwable th3) {
                            dataOutputStream3 = dataOutputStream4;
                            httpURLConnection = a;
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
                        DataOutputStream dataOutputStream5 = new DataOutputStream(a.getOutputStream());
                        if (arrayList != null) {
                            try {
                                Iterator<BasicNameValuePair> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair next2 = it2.next();
                                    if (next2 != null) {
                                        String name2 = next2.getName();
                                        String value3 = next2.getValue();
                                        dataOutputStream5.writeBytes(String.valueOf(kN) + kf + kM);
                                        dataOutputStream5.writeBytes("Content-Disposition: form-data; name=\"" + name2 + "\"" + kM);
                                        dataOutputStream5.writeBytes(kM);
                                        if (value3 == null) {
                                            dataOutputStream5.write("null".getBytes("UTF-8"));
                                        } else {
                                            dataOutputStream5.write(value3.getBytes("UTF-8"));
                                        }
                                        dataOutputStream5.writeBytes(kM);
                                    }
                                }
                            } catch (Exception e4) {
                                httpURLConnection = a;
                                e = e4;
                                dataOutputStream = dataOutputStream5;
                                throw e;
                            } catch (Throwable th4) {
                                dataOutputStream3 = dataOutputStream5;
                                httpURLConnection = a;
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
                                    dataOutputStream5.writeBytes(String.valueOf(kN) + kf + kM);
                                    dataOutputStream5.writeBytes("Content-Disposition: form-data; name=\"" + key2 + "\"; filename=\"file\"" + kM);
                                    dataOutputStream5.writeBytes(kM);
                                    dataOutputStream5.write(value4);
                                    dataOutputStream5.writeBytes(kM);
                                    dataOutputStream5.writeBytes(String.valueOf(kN) + kf + kN + kM);
                                }
                            }
                        }
                        dataOutputStream5.flush();
                        dataOutputStream5.close();
                        dataOutputStream2 = dataOutputStream5;
                    }
                    if (aVar != null) {
                        try {
                            if (aVar.isCanceled()) {
                                throw new BdHttpCancelException();
                            }
                        } catch (Exception e5) {
                            httpURLConnection = a;
                            e = e5;
                            dataOutputStream = dataOutputStream2;
                            throw e;
                        } catch (Throwable th5) {
                            dataOutputStream3 = dataOutputStream2;
                            httpURLConnection = a;
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
                    int responseCode = a.getResponseCode();
                    if (aVar == null || !aVar.isCanceled()) {
                        if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 416) {
                            if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408) {
                                throw new BdHttpErrorException("retry, errorCode:" + responseCode, responseCode, true);
                            }
                            if (responseCode == 502 || responseCode == 503 || responseCode == 504 || responseCode == 404) {
                                throw new BdHttpErrorException("close not retry, errorCode:" + responseCode, responseCode, false);
                            }
                            throw new BdHttpErrorException("errorCode:" + responseCode, responseCode, true);
                        }
                        f a2 = (responseCode == 200 || responseCode == 206) ? a(a, false, (g) null, dVar, aVar, dVar2) : new f();
                        if (aVar == null || !aVar.isCanceled()) {
                            a2.kU = responseCode;
                            if (dVar2 != null) {
                                dVar2.ko = ((System.currentTimeMillis() - currentTimeMillis) - dVar2.km) - dVar2.kq;
                            }
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            if (aVar != null) {
                                aVar.finish();
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
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    private static f a(HttpURLConnection httpURLConnection, boolean z, g gVar, d dVar, a aVar, com.baidu.adp.lib.network.http.d dVar2) {
        int i;
        int i2;
        int read;
        String headerField;
        boolean z2 = false;
        InputStream inputStream = null;
        try {
            f fVar = new f();
            String contentType = httpURLConnection.getContentType();
            fVar.charset = h.Z(contentType);
            if (z && h.Y(contentType)) {
                if (aVar != null && aVar.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.disconnect();
                if (aVar != null && aVar.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.connect();
                if (aVar != null && aVar.isCanceled()) {
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
            if (gVar != null) {
                gVar.u(headerField2 != null);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (dVar != null) {
                dVar.a(intValue2, httpURLConnection, byteArrayOutputStream);
            }
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                z2 = true;
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (aVar != null && aVar.isCanceled()) {
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
                            gVar.d(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (dVar != null) {
                            dVar.a(size, intValue2, httpURLConnection);
                        }
                    }
                    if (aVar != null && aVar.isCanceled()) {
                        throw new BdHttpCancelException();
                    }
                    if (intValue2 > 0 && size > intValue2) {
                        throw new BdHttpCancelException("over max content length");
                    }
                } while (read > 0);
                if (dVar2 != null) {
                    dVar2.kl = size;
                }
                if (z2) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(4096);
                    com.baidu.adp.lib.util.f.a(byteArrayInputStream, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (gVar != null) {
                        gVar.d(byteArray, 0, byteArray.length);
                    } else {
                        fVar.data = byteArray;
                    }
                } else if (gVar == null) {
                    fVar.data = byteArrayOutputStream.toByteArray();
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e) {
                }
            }
            return fVar;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }
}
