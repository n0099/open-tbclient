package com.baidu.adp.lib.network;

import android.net.Proxy;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f430a = true;
    private static String b = "\r\n";
    private static String c = "--";
    private static String d = "--------7da3d81520810*";

    public static HttpURLConnection a(String str) {
        String replaceFirst;
        try {
            URL url = new URL(str);
            String defaultHost = Proxy.getDefaultHost();
            if (!f.b()) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            int defaultPort = Proxy.getDefaultPort();
            if (defaultPort == -1) {
                defaultPort = 80;
            }
            java.net.Proxy proxy = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort));
            try {
                if (f.b(defaultHost)) {
                    String host = url.getHost();
                    int port = url.getPort();
                    int i = port != -1 ? port : 80;
                    if (str.indexOf(String.valueOf(host) + ":" + i) != -1) {
                        replaceFirst = str.replaceFirst(String.valueOf(host) + ":" + i, String.valueOf(defaultHost) + ":" + defaultPort);
                    } else {
                        replaceFirst = str.replaceFirst(host, String.valueOf(defaultHost) + ":" + defaultPort);
                    }
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
                        httpURLConnection.setRequestProperty(HttpUtils.HEADER_NAME_CMWAP_ONLINE_HOST, String.valueOf(host) + ":" + i);
                        return httpURLConnection;
                    } catch (MalformedURLException e2) {
                        return null;
                    }
                }
                return (HttpURLConnection) url.openConnection(proxy);
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023 A[LOOP:0: B:3:0x0003->B:15:0x0023, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0017 A[EDGE_INSN: B:34:0x0017->B:9:0x0017 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, ArrayList arrayList, String str2, byte[] bArr, int i, c cVar, a aVar) {
        e eVar;
        int i2;
        e eVar2;
        e eVar3 = null;
        int i3 = 0;
        while (true) {
            try {
                try {
                    eVar2 = a(str, arrayList, str2, bArr, true, cVar, aVar);
                    if (eVar2 != null) {
                        try {
                            if (eVar2.f432a == 200) {
                                break;
                            }
                        } catch (Exception e) {
                            eVar = eVar2;
                            e = e;
                            if (i3 < i) {
                                e eVar4 = eVar;
                                i2 = i3 + 1;
                                eVar2 = eVar4;
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
                } catch (Exception e2) {
                    e = e2;
                    eVar = eVar3;
                }
                if (i2 < i) {
                    try {
                        Thread.sleep(5000L);
                    } catch (Exception e3) {
                    }
                }
                if (i2 < i) {
                    break;
                }
                eVar3 = eVar2;
                i3 = i2;
            } catch (BdHttpCancelException e4) {
                throw e4;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [993=4] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, ArrayList arrayList, String str2, byte[] bArr, boolean z, c cVar, a aVar) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection2 = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = a(str);
            if (aVar != null) {
                try {
                    if (aVar.b()) {
                        throw new BdHttpCancelException();
                    }
                    aVar.a(httpURLConnection);
                } catch (Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (aVar != null) {
                            aVar.a();
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
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + d);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            if (f430a) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            }
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(45000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (z) {
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            }
            if (aVar == null || !aVar.b()) {
                httpURLConnection.connect();
                if (aVar == null || !aVar.b()) {
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (f430a) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    byteArrayOutputStream.write((String.valueOf(c) + d + b).getBytes());
                                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"" + b).getBytes());
                                    byteArrayOutputStream.write(b.getBytes());
                                    if (value == null) {
                                        byteArrayOutputStream.write("null".getBytes("UTF-8"));
                                    } else {
                                        byteArrayOutputStream.write(value.getBytes("UTF-8"));
                                    }
                                    byteArrayOutputStream.write(b.getBytes());
                                }
                            }
                        }
                        if (bArr != null) {
                            byteArrayOutputStream.write((String.valueOf(c) + d + b).getBytes());
                            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"" + b).getBytes());
                            byteArrayOutputStream.write(b.getBytes());
                            byteArrayOutputStream.write(bArr);
                            byteArrayOutputStream.write(b.getBytes());
                            byteArrayOutputStream.write((String.valueOf(c) + d + c + b).getBytes());
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        com.baidu.adp.lib.e.c.a(byteArrayInputStream, byteArrayOutputStream2);
                        DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream3.write(byteArrayOutputStream2.toByteArray());
                            dataOutputStream3.flush();
                            dataOutputStream3.close();
                            dataOutputStream = dataOutputStream3;
                        } catch (Exception e3) {
                            e = e3;
                            dataOutputStream2 = dataOutputStream3;
                            httpURLConnection2 = httpURLConnection;
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream3;
                            if (dataOutputStream2 != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    } else {
                        DataOutputStream dataOutputStream4 = new DataOutputStream(httpURLConnection.getOutputStream());
                        if (arrayList != null) {
                            try {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    BasicNameValuePair basicNameValuePair2 = (BasicNameValuePair) it2.next();
                                    if (basicNameValuePair2 != null) {
                                        String name2 = basicNameValuePair2.getName();
                                        String value2 = basicNameValuePair2.getValue();
                                        dataOutputStream4.writeBytes(String.valueOf(c) + d + b);
                                        dataOutputStream4.writeBytes("Content-Disposition: form-data; name=\"" + name2 + "\"" + b);
                                        dataOutputStream4.writeBytes(b);
                                        if (value2 == null) {
                                            dataOutputStream4.write("null".getBytes("UTF-8"));
                                        } else {
                                            dataOutputStream4.write(value2.getBytes("UTF-8"));
                                        }
                                        dataOutputStream4.writeBytes(b);
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                dataOutputStream2 = dataOutputStream4;
                                httpURLConnection2 = httpURLConnection;
                                throw e;
                            } catch (Throwable th4) {
                                th = th4;
                                dataOutputStream2 = dataOutputStream4;
                                if (dataOutputStream2 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (aVar != null) {
                                }
                                throw th;
                            }
                        }
                        if (bArr != null) {
                            dataOutputStream4.writeBytes(String.valueOf(c) + d + b);
                            dataOutputStream4.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"" + b);
                            dataOutputStream4.writeBytes(b);
                            dataOutputStream4.write(bArr);
                            dataOutputStream4.writeBytes(b);
                            dataOutputStream4.writeBytes(String.valueOf(c) + d + c + b);
                        }
                        dataOutputStream4.flush();
                        dataOutputStream4.close();
                        dataOutputStream = dataOutputStream4;
                    }
                    if (aVar == null || !aVar.b()) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (aVar == null || !aVar.b()) {
                            if (responseCode != 200 && responseCode != 204 && responseCode != 206 && responseCode != 416) {
                                if (responseCode == 202 || responseCode == 201 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408 || responseCode == 502 || responseCode == 504 || responseCode == 503) {
                                    throw new IOException("doGetOrPost retry");
                                }
                                throw new BdHttpErrorException();
                            }
                            e a2 = (responseCode == 200 || responseCode == 206) ? a(httpURLConnection, false, cVar, aVar) : new e();
                            if (aVar == null || !aVar.b()) {
                                a2.f432a = responseCode;
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
                                    aVar.a();
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
            }
            throw new BdHttpCancelException();
        } catch (Exception e6) {
            e = e6;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
    }

    private static e a(HttpURLConnection httpURLConnection, boolean z, c cVar, a aVar) {
        int read;
        int i = 0;
        InputStream inputStream = null;
        try {
            e eVar = new e();
            String contentType = httpURLConnection.getContentType();
            eVar.d = f.d(contentType);
            if (z && f.c(contentType)) {
                if (aVar != null && aVar.b()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.disconnect();
                if (aVar != null && aVar.b()) {
                    throw new BdHttpCancelException();
                }
                httpURLConnection.connect();
                if (aVar != null && aVar.b()) {
                    throw new BdHttpCancelException();
                }
            }
            if (cVar != null) {
                cVar.a(httpURLConnection.getContentLength());
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (aVar != null && aVar.b()) {
                throw new BdHttpCancelException();
            }
            if (inputStream2 != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                do {
                    read = inputStream2.read(bArr);
                    if (read > 0) {
                        i += read;
                        byteArrayOutputStream.write(bArr, 0, read);
                        if (cVar != null) {
                            cVar.a(read, httpURLConnection.getContentLength());
                        }
                    }
                    if (aVar != null && aVar.b()) {
                        throw new BdHttpCancelException();
                    }
                } while (read > 0);
                eVar.c = byteArrayOutputStream.toByteArray();
                if (eVar.c != null) {
                    try {
                        eVar.b = new JSONObject(new String(eVar.c)).getInt("errno");
                    } catch (Exception e) {
                    }
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
