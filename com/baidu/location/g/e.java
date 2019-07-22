package com.baidu.location.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public abstract class e {
    public String h = null;
    public int i = 3;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;
    public static int g = a.g;
    private static String a = "10.0.0.172";
    private static int b = 80;
    protected static int p = 0;

    private static int a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                a = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                return a.d;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                a = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.200" : "10.0.0.200";
                return a.d;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                return a.e;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 != null && defaultHost3.length() > 0) {
            if ("10.0.0.172".equals(defaultHost3.trim())) {
                a = "10.0.0.172";
                return a.d;
            } else if ("10.0.0.200".equals(defaultHost3.trim())) {
                a = "10.0.0.200";
                return a.d;
            }
        }
        return a.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        g = c();
    }

    private int c() {
        int i;
        Context serviceContext = com.baidu.location.f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                i = a.g;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    i = a.g;
                } else if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    i = (defaultHost == null || defaultHost.length() <= 0) ? a.f : a.h;
                } else {
                    i = a(serviceContext, activeNetworkInfo);
                }
            }
            return i;
        } catch (Exception e) {
            return a.g;
        }
    }

    public abstract void a();

    public abstract void a(boolean z);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$2] */
    public void a(final boolean z, final String str) {
        new Thread() { // from class: com.baidu.location.g.e.2
            /* JADX WARN: Removed duplicated region for block: B:110:0x0248 A[LOOP:0: B:3:0x001b->B:110:0x0248, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:146:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:152:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:164:0x0226 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:183:0x0085 A[EDGE_INSN: B:183:0x0085->B:22:0x0085 ?: BREAK  , SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:96:0x0217  */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                HttpURLConnection httpURLConnection;
                ByteArrayOutputStream byteArrayOutputStream;
                OutputStream outputStream;
                ByteArrayOutputStream byteArrayOutputStream2;
                HttpURLConnection httpURLConnection2;
                InputStream inputStream2;
                OutputStream outputStream2;
                HttpURLConnection httpURLConnection3;
                boolean z2;
                boolean z3;
                ByteArrayOutputStream byteArrayOutputStream3;
                InputStream inputStream3;
                OutputStream outputStream3 = null;
                e.this.h = g.c();
                e.this.b();
                e.this.a();
                HttpURLConnection httpURLConnection4 = null;
                int i = e.this.i;
                while (i > 0) {
                    try {
                        URL url = new URL(e.this.h);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Map.Entry<String, Object> entry : e.this.k.entrySet()) {
                            stringBuffer.append(entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(entry.getValue());
                            stringBuffer.append("&");
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        }
                        httpURLConnection3 = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection3.setRequestMethod("POST");
                            httpURLConnection3.setDoInput(true);
                            httpURLConnection3.setDoOutput(true);
                            httpURLConnection3.setUseCaches(false);
                            httpURLConnection3.setConnectTimeout(a.b);
                            httpURLConnection3.setReadTimeout(a.b);
                            httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                            httpURLConnection3.setRequestProperty("Accept-Charset", HTTP.UTF_8);
                            httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                            if (!TextUtils.isEmpty(str)) {
                                httpURLConnection3.setRequestProperty(HTTP.TARGET_HOST, str);
                            }
                            outputStream2 = httpURLConnection3.getOutputStream();
                            try {
                                outputStream2.write(stringBuffer.toString().getBytes());
                                outputStream2.flush();
                                if (httpURLConnection3.getResponseCode() == 200) {
                                    inputStream2 = httpURLConnection3.getInputStream();
                                    try {
                                        String contentEncoding = httpURLConnection3.getContentEncoding();
                                        inputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream2 : new GZIPInputStream(new BufferedInputStream(inputStream2));
                                        try {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                try {
                                                    byte[] bArr = new byte[1024];
                                                    while (true) {
                                                        int read = inputStream.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        byteArrayOutputStream.write(bArr, 0, read);
                                                    }
                                                    e.this.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                                    if (z) {
                                                        e.this.m = byteArrayOutputStream.toByteArray();
                                                    }
                                                    e.this.a(true);
                                                    inputStream3 = inputStream;
                                                    byteArrayOutputStream3 = byteArrayOutputStream;
                                                    z3 = true;
                                                } catch (Throwable th) {
                                                    outputStream3 = outputStream2;
                                                    httpURLConnection = httpURLConnection3;
                                                    th = th;
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                    if (outputStream3 != null) {
                                                        try {
                                                            outputStream3.close();
                                                        } catch (Exception e) {
                                                            Log.d(a.a, "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Exception e2) {
                                                            Log.d(a.a, "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Exception e3) {
                                                            Log.d(a.a, "close baos IOException!");
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Error e4) {
                                                Log.d(a.a, "NetworkCommunicationError!");
                                                if (httpURLConnection3 != null) {
                                                    httpURLConnection3.disconnect();
                                                }
                                                if (outputStream2 != null) {
                                                    try {
                                                        outputStream2.close();
                                                    } catch (Exception e5) {
                                                        Log.d(a.a, "close os IOException!");
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e6) {
                                                        Log.d(a.a, "close is IOException!");
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e7) {
                                                        Log.d(a.a, "close baos IOException!");
                                                        httpURLConnection4 = httpURLConnection3;
                                                        z2 = false;
                                                    }
                                                }
                                                httpURLConnection4 = httpURLConnection3;
                                                z2 = false;
                                                if (z2) {
                                                }
                                            } catch (Exception e8) {
                                                byteArrayOutputStream2 = byteArrayOutputStream;
                                                inputStream2 = inputStream;
                                                httpURLConnection2 = httpURLConnection3;
                                                outputStream = outputStream2;
                                                try {
                                                    Log.d(a.a, "NetworkCommunicationException!");
                                                    if (httpURLConnection2 != null) {
                                                        httpURLConnection2.disconnect();
                                                    }
                                                    if (outputStream != null) {
                                                        try {
                                                            outputStream.close();
                                                        } catch (Exception e9) {
                                                            Log.d(a.a, "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Exception e10) {
                                                            Log.d(a.a, "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream2 != null) {
                                                        try {
                                                            byteArrayOutputStream2.close();
                                                        } catch (Exception e11) {
                                                            Log.d(a.a, "close baos IOException!");
                                                            z2 = false;
                                                            httpURLConnection4 = httpURLConnection2;
                                                        }
                                                    }
                                                    z2 = false;
                                                    httpURLConnection4 = httpURLConnection2;
                                                    if (z2) {
                                                    }
                                                } catch (Throwable th2) {
                                                    outputStream3 = outputStream;
                                                    th = th2;
                                                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                                                    httpURLConnection = httpURLConnection2;
                                                    inputStream = inputStream2;
                                                    byteArrayOutputStream = byteArrayOutputStream4;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (outputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } catch (Error e12) {
                                            byteArrayOutputStream = null;
                                        } catch (Exception e13) {
                                            inputStream2 = inputStream;
                                            httpURLConnection2 = httpURLConnection3;
                                            outputStream = outputStream2;
                                            byteArrayOutputStream2 = null;
                                        } catch (Throwable th3) {
                                            byteArrayOutputStream = null;
                                            outputStream3 = outputStream2;
                                            httpURLConnection = httpURLConnection3;
                                            th = th3;
                                        }
                                    } catch (Error e14) {
                                        inputStream = inputStream2;
                                        byteArrayOutputStream = null;
                                    } catch (Exception e15) {
                                        httpURLConnection2 = httpURLConnection3;
                                        outputStream = outputStream2;
                                        byteArrayOutputStream2 = null;
                                    } catch (Throwable th4) {
                                        inputStream = inputStream2;
                                        byteArrayOutputStream = null;
                                        outputStream3 = outputStream2;
                                        httpURLConnection = httpURLConnection3;
                                        th = th4;
                                    }
                                } else {
                                    z3 = false;
                                    byteArrayOutputStream3 = null;
                                    inputStream3 = null;
                                }
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception e16) {
                                        Log.d(a.a, "close os IOException!");
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Exception e17) {
                                        Log.d(a.a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream3 != null) {
                                    try {
                                        byteArrayOutputStream3.close();
                                    } catch (Exception e18) {
                                        Log.d(a.a, "close baos IOException!");
                                        boolean z4 = z3;
                                        httpURLConnection4 = httpURLConnection3;
                                        z2 = z4;
                                    }
                                }
                                boolean z5 = z3;
                                httpURLConnection4 = httpURLConnection3;
                                z2 = z5;
                            } catch (Error e19) {
                                byteArrayOutputStream = null;
                                inputStream = null;
                            } catch (Exception e20) {
                                inputStream2 = null;
                                httpURLConnection2 = httpURLConnection3;
                                outputStream = outputStream2;
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th5) {
                                inputStream = null;
                                httpURLConnection = httpURLConnection3;
                                th = th5;
                                byteArrayOutputStream = null;
                                outputStream3 = outputStream2;
                            }
                        } catch (Error e21) {
                            outputStream2 = null;
                            byteArrayOutputStream = null;
                            inputStream = null;
                        } catch (Exception e22) {
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            httpURLConnection2 = httpURLConnection3;
                            outputStream = null;
                        } catch (Throwable th6) {
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpURLConnection = httpURLConnection3;
                            th = th6;
                        }
                    } catch (Error e23) {
                        outputStream2 = null;
                        inputStream = null;
                        httpURLConnection3 = httpURLConnection4;
                        byteArrayOutputStream = null;
                    } catch (Exception e24) {
                        outputStream = null;
                        byteArrayOutputStream2 = null;
                        httpURLConnection2 = httpURLConnection4;
                        inputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream = null;
                        httpURLConnection = httpURLConnection4;
                        byteArrayOutputStream = null;
                    }
                    if (z2) {
                        break;
                    }
                    i--;
                }
                if (i > 0) {
                    e.p = 0;
                    return;
                }
                e.p++;
                e.this.j = null;
                e.this.a(false);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$3] */
    public void b(final String str) {
        new Thread() { // from class: com.baidu.location.g.e.3
            /* JADX WARN: Removed duplicated region for block: B:147:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:159:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:161:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:91:0x01f5  */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                InputStream inputStream;
                URL url;
                HttpsURLConnection httpsURLConnection;
                ByteArrayOutputStream byteArrayOutputStream2;
                InputStream inputStream2;
                URL url2;
                HttpsURLConnection httpsURLConnection2;
                ByteArrayOutputStream byteArrayOutputStream3 = null;
                e.this.a();
                e.this.b();
                e.this.h = str;
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    url = new URL(e.this.h);
                    try {
                        HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) url.openConnection();
                        try {
                            httpsURLConnection3.setInstanceFollowRedirects(false);
                            httpsURLConnection3.setDoOutput(true);
                            httpsURLConnection3.setDoInput(true);
                            httpsURLConnection3.setConnectTimeout(a.b);
                            httpsURLConnection3.setReadTimeout(a.c);
                            httpsURLConnection3.setRequestMethod("POST");
                            httpsURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                            httpsURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                            for (Map.Entry<String, Object> entry : e.this.k.entrySet()) {
                                stringBuffer.append(entry.getKey());
                                stringBuffer.append("=");
                                stringBuffer.append(entry.getValue());
                                stringBuffer.append("&");
                            }
                            if (stringBuffer.length() > 0) {
                                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                            }
                            OutputStream outputStream = httpsURLConnection3.getOutputStream();
                            try {
                                outputStream.write(stringBuffer.toString().getBytes());
                                outputStream.flush();
                                if (httpsURLConnection3.getResponseCode() == 200) {
                                    InputStream inputStream3 = httpsURLConnection3.getInputStream();
                                    try {
                                        String contentEncoding = httpsURLConnection3.getContentEncoding();
                                        inputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream3 : new GZIPInputStream(new BufferedInputStream(inputStream3));
                                        try {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int read = inputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    byteArrayOutputStream.write(bArr, 0, read);
                                                }
                                                e.this.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                                e.this.a(true);
                                            } catch (Error e) {
                                                byteArrayOutputStream3 = outputStream;
                                                httpsURLConnection = httpsURLConnection3;
                                                e = e;
                                                try {
                                                    e.printStackTrace();
                                                    Log.i(a.a, "https NetworkCommunicationError!");
                                                    e.this.j = null;
                                                    e.this.a(false);
                                                    if (httpsURLConnection != null) {
                                                        httpsURLConnection.disconnect();
                                                    }
                                                    if (url != null) {
                                                    }
                                                    if (byteArrayOutputStream3 != null) {
                                                        try {
                                                            byteArrayOutputStream3.close();
                                                        } catch (Exception e2) {
                                                            Log.d(a.a, "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Exception e3) {
                                                            Log.d(a.a, "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                            return;
                                                        } catch (Exception e4) {
                                                            Log.d(a.a, "close baos IOException!");
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (httpsURLConnection != null) {
                                                    }
                                                    if (url != null) {
                                                    }
                                                    if (byteArrayOutputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e5) {
                                                byteArrayOutputStream3 = byteArrayOutputStream;
                                                url2 = url;
                                                byteArrayOutputStream2 = outputStream;
                                                inputStream2 = inputStream;
                                                httpsURLConnection2 = httpsURLConnection3;
                                                e = e5;
                                                try {
                                                    e.printStackTrace();
                                                    Log.i(a.a, "https NetworkCommunicationException!");
                                                    e.this.j = null;
                                                    e.this.a(false);
                                                    if (httpsURLConnection2 != null) {
                                                        httpsURLConnection2.disconnect();
                                                    }
                                                    if (url2 != null) {
                                                    }
                                                    if (byteArrayOutputStream2 != null) {
                                                        try {
                                                            byteArrayOutputStream2.close();
                                                        } catch (Exception e6) {
                                                            Log.d(a.a, "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Exception e7) {
                                                            Log.d(a.a, "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream3 != null) {
                                                        try {
                                                            byteArrayOutputStream3.close();
                                                            return;
                                                        } catch (Exception e8) {
                                                            Log.d(a.a, "close baos IOException!");
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    url = url2;
                                                    byteArrayOutputStream = byteArrayOutputStream3;
                                                    byteArrayOutputStream3 = byteArrayOutputStream2;
                                                    httpsURLConnection = httpsURLConnection2;
                                                    inputStream = inputStream2;
                                                    if (httpsURLConnection != null) {
                                                        httpsURLConnection.disconnect();
                                                    }
                                                    if (url != null) {
                                                    }
                                                    if (byteArrayOutputStream3 != null) {
                                                        try {
                                                            byteArrayOutputStream3.close();
                                                        } catch (Exception e9) {
                                                            Log.d(a.a, "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Exception e10) {
                                                            Log.d(a.a, "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Exception e11) {
                                                            Log.d(a.a, "close baos IOException!");
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                byteArrayOutputStream3 = outputStream;
                                                httpsURLConnection = httpsURLConnection3;
                                                th = th3;
                                                if (httpsURLConnection != null) {
                                                }
                                                if (url != null) {
                                                }
                                                if (byteArrayOutputStream3 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (byteArrayOutputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Error e12) {
                                            byteArrayOutputStream = null;
                                            byteArrayOutputStream3 = outputStream;
                                            httpsURLConnection = httpsURLConnection3;
                                            e = e12;
                                        } catch (Exception e13) {
                                            url2 = url;
                                            inputStream2 = inputStream;
                                            httpsURLConnection2 = httpsURLConnection3;
                                            e = e13;
                                            byteArrayOutputStream2 = outputStream;
                                        } catch (Throwable th4) {
                                            byteArrayOutputStream = null;
                                            byteArrayOutputStream3 = outputStream;
                                            httpsURLConnection = httpsURLConnection3;
                                            th = th4;
                                        }
                                    } catch (Error e14) {
                                        inputStream = inputStream3;
                                        byteArrayOutputStream = null;
                                        byteArrayOutputStream3 = outputStream;
                                        httpsURLConnection = httpsURLConnection3;
                                        e = e14;
                                    } catch (Exception e15) {
                                        httpsURLConnection2 = httpsURLConnection3;
                                        e = e15;
                                        byteArrayOutputStream2 = outputStream;
                                        inputStream2 = inputStream3;
                                        url2 = url;
                                    } catch (Throwable th5) {
                                        inputStream = inputStream3;
                                        byteArrayOutputStream = null;
                                        byteArrayOutputStream3 = outputStream;
                                        httpsURLConnection = httpsURLConnection3;
                                        th = th5;
                                    }
                                } else {
                                    e.this.j = null;
                                    e.this.a(false);
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                }
                                if (httpsURLConnection3 != null) {
                                    httpsURLConnection3.disconnect();
                                }
                                if (url != null) {
                                }
                                if (outputStream != 0) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e16) {
                                        Log.d(a.a, "close os IOException!");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                        Log.d(a.a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e18) {
                                        Log.d(a.a, "close baos IOException!");
                                    }
                                }
                            } catch (Error e19) {
                                byteArrayOutputStream = null;
                                inputStream = null;
                                byteArrayOutputStream3 = outputStream;
                                httpsURLConnection = httpsURLConnection3;
                                e = e19;
                            } catch (Exception e20) {
                                url2 = url;
                                httpsURLConnection2 = httpsURLConnection3;
                                e = e20;
                                byteArrayOutputStream2 = outputStream;
                                inputStream2 = null;
                            } catch (Throwable th6) {
                                byteArrayOutputStream = null;
                                inputStream = null;
                                byteArrayOutputStream3 = outputStream;
                                httpsURLConnection = httpsURLConnection3;
                                th = th6;
                            }
                        } catch (Error e21) {
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection3;
                            e = e21;
                        } catch (Exception e22) {
                            inputStream2 = null;
                            url2 = url;
                            httpsURLConnection2 = httpsURLConnection3;
                            e = e22;
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th7) {
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection3;
                            th = th7;
                        }
                    } catch (Error e23) {
                        e = e23;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpsURLConnection = null;
                    } catch (Exception e24) {
                        e = e24;
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        url2 = url;
                        httpsURLConnection2 = null;
                    } catch (Throwable th8) {
                        th = th8;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        httpsURLConnection = null;
                    }
                } catch (Error e25) {
                    e = e25;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    url = null;
                    httpsURLConnection = null;
                } catch (Exception e26) {
                    e = e26;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url2 = null;
                    httpsURLConnection2 = null;
                } catch (Throwable th9) {
                    th = th9;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    url = null;
                    httpsURLConnection = null;
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$1] */
    public void d() {
        new Thread() { // from class: com.baidu.location.g.e.1
            /* JADX WARN: Removed duplicated region for block: B:101:0x009b A[EDGE_INSN: B:101:0x009b->B:26:0x009b ?: BREAK  , SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:51:0x0109  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0121 A[LOOP:0: B:3:0x001b->B:61:0x0121, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:87:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                ByteArrayOutputStream byteArrayOutputStream;
                HttpURLConnection httpURLConnection;
                InputStream inputStream2;
                boolean z;
                boolean z2;
                ByteArrayOutputStream byteArrayOutputStream2;
                InputStream inputStream3;
                ByteArrayOutputStream byteArrayOutputStream3;
                ByteArrayOutputStream byteArrayOutputStream4 = null;
                e.this.h = g.c();
                e.this.b();
                e.this.a();
                HttpURLConnection httpURLConnection2 = null;
                int i = e.this.i;
                while (i > 0) {
                    try {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(e.this.h).openConnection();
                        try {
                            httpURLConnection3.setRequestMethod("GET");
                            httpURLConnection3.setDoInput(true);
                            httpURLConnection3.setDoOutput(true);
                            httpURLConnection3.setUseCaches(false);
                            httpURLConnection3.setConnectTimeout(a.b);
                            httpURLConnection3.setReadTimeout(a.b);
                            httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                            httpURLConnection3.setRequestProperty("Accept-Charset", HTTP.UTF_8);
                            if (httpURLConnection3.getResponseCode() == 200) {
                                inputStream = httpURLConnection3.getInputStream();
                                try {
                                    byteArrayOutputStream3 = new ByteArrayOutputStream();
                                } catch (Exception e) {
                                    inputStream2 = inputStream;
                                    httpURLConnection = httpURLConnection3;
                                    byteArrayOutputStream = null;
                                } catch (Throwable th) {
                                    httpURLConnection2 = httpURLConnection3;
                                    th = th;
                                }
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream3.write(bArr, 0, read);
                                    }
                                    inputStream.close();
                                    byteArrayOutputStream3.close();
                                    e.this.j = new String(byteArrayOutputStream3.toByteArray(), "utf-8");
                                    e.this.a(true);
                                    httpURLConnection3.disconnect();
                                    inputStream3 = inputStream;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    z2 = true;
                                } catch (Exception e2) {
                                    inputStream2 = inputStream;
                                    httpURLConnection = httpURLConnection3;
                                    byteArrayOutputStream = byteArrayOutputStream3;
                                    try {
                                        Log.d(a.a, "NetworkCommunicationException!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                                z = false;
                                                httpURLConnection2 = httpURLConnection;
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                z = false;
                                                httpURLConnection2 = httpURLConnection;
                                            }
                                        } else {
                                            z = false;
                                            httpURLConnection2 = httpURLConnection;
                                        }
                                        if (!z) {
                                        }
                                    } catch (Throwable th2) {
                                        byteArrayOutputStream4 = byteArrayOutputStream;
                                        th = th2;
                                        InputStream inputStream4 = inputStream2;
                                        httpURLConnection2 = httpURLConnection;
                                        inputStream = inputStream4;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream4 != null) {
                                            try {
                                                byteArrayOutputStream4.close();
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    byteArrayOutputStream4 = byteArrayOutputStream3;
                                    httpURLConnection2 = httpURLConnection3;
                                    th = th3;
                                    if (httpURLConnection2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream4 != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                httpURLConnection3.disconnect();
                                z2 = false;
                                byteArrayOutputStream2 = null;
                                inputStream3 = null;
                            }
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                    boolean z3 = z2;
                                    httpURLConnection2 = httpURLConnection3;
                                    z = z3;
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                    boolean z4 = z2;
                                    httpURLConnection2 = httpURLConnection3;
                                    z = z4;
                                }
                            } else {
                                boolean z5 = z2;
                                httpURLConnection2 = httpURLConnection3;
                                z = z5;
                            }
                        } catch (Exception e9) {
                            inputStream2 = null;
                            httpURLConnection = httpURLConnection3;
                            byteArrayOutputStream = null;
                        } catch (Throwable th4) {
                            inputStream = null;
                            httpURLConnection2 = httpURLConnection3;
                            th = th4;
                        }
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        httpURLConnection = httpURLConnection2;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                    if (!z) {
                        break;
                    }
                    i--;
                }
                if (i > 0) {
                    e.p = 0;
                    return;
                }
                e.p++;
                e.this.j = null;
                e.this.a(false);
            }
        }.start();
    }

    public void e() {
        a(false, "loc.map.baidu.com");
    }
}
