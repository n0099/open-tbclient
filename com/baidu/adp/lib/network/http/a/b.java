package com.baidu.adp.lib.network.http.a;

import com.baidu.adp.lib.util.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    private static b LQ = null;
    private HashMap<String, com.baidu.adp.lib.network.http.a.a> mCache = new HashMap<>();
    private a LR = null;
    private int LS = 0;

    /* loaded from: classes.dex */
    public interface a {
    }

    private b() {
    }

    public static b mC() {
        if (LQ == null) {
            synchronized (b.class) {
                if (LQ == null) {
                    LQ = new b();
                }
            }
        }
        return LQ;
    }

    public c bJ(String str) {
        c cVar = new c();
        com.baidu.adp.lib.network.http.a.a aVar = this.mCache.get(str);
        if (aVar != null && !aVar.F(System.currentTimeMillis()) && aVar.mB() != null && aVar.mB().size() > 0) {
            cVar.bL(aVar.mB().get(0));
        }
        return cVar;
    }

    public c x(String str, String str2) {
        c cVar = new c();
        if (k.isEmpty(str)) {
            return cVar;
        }
        com.baidu.adp.lib.network.http.a.a aVar = this.mCache.get(str);
        if (aVar != null && !aVar.F(System.currentTimeMillis()) && aVar.mB() != null && aVar.mB().size() > 0) {
            for (int i = 0; i < aVar.mB().size(); i++) {
                if (!k.A(str2, aVar.mB().get(i))) {
                    cVar.al(i);
                    cVar.bL(aVar.mB().get(i));
                    return cVar;
                } else if (i == aVar.mB().size() - 1) {
                    cVar.al(0);
                    cVar.bL(aVar.mB().get(0));
                    return cVar;
                }
            }
        }
        for (int i2 = 0; i2 < 3; i2++) {
            cVar.mE();
            cVar.ao(i2);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.a.a a2 = a(str, cVar);
            cVar.G(System.currentTimeMillis() - currentTimeMillis);
            if (a2 != null && a2.mB() != null && a2.mB().size() > 0) {
                a2.E(300L);
                this.mCache.put(str, a2);
                for (int i3 = 0; i3 < a2.mB().size(); i3++) {
                    if (!k.A(str2, a2.mB().get(i2))) {
                        cVar.al(i3);
                        cVar.bL(a2.mB().get(i3));
                        return cVar;
                    } else if (i3 == a2.mB().size() - 1) {
                        cVar.al(0);
                        cVar.bL(a2.mB().get(0));
                        return cVar;
                    }
                }
                continue;
            } else {
                com.baidu.adp.lib.network.http.a.a aVar2 = this.mCache.get(str);
                if (aVar2 != null && aVar2.mB() != null && aVar2.mB().size() > 0) {
                    cVar.bL(aVar2.mB().get(0));
                    return cVar;
                }
            }
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[Catch: all -> 0x0151, TryCatch #9 {all -> 0x0151, blocks: (B:15:0x0068, B:17:0x006e, B:35:0x00f6, B:20:0x0073, B:22:0x0082, B:23:0x0086), top: B:80:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[Catch: Exception -> 0x0154, TryCatch #5 {Exception -> 0x0154, blocks: (B:25:0x008b, B:27:0x0090, B:29:0x0095, B:31:0x009a), top: B:78:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[Catch: Exception -> 0x0154, TryCatch #5 {Exception -> 0x0154, blocks: (B:25:0x008b, B:27:0x0090, B:29:0x0095, B:31:0x009a), top: B:78:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[Catch: Exception -> 0x0154, TRY_LEAVE, TryCatch #5 {Exception -> 0x0154, blocks: (B:25:0x008b, B:27:0x0090, B:29:0x0095, B:31:0x009a), top: B:78:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0131 A[Catch: Exception -> 0x013f, TryCatch #8 {Exception -> 0x013f, blocks: (B:50:0x012c, B:52:0x0131, B:54:0x0136, B:56:0x013b), top: B:82:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136 A[Catch: Exception -> 0x013f, TryCatch #8 {Exception -> 0x013f, blocks: (B:50:0x012c, B:52:0x0131, B:54:0x0136, B:56:0x013b), top: B:82:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b A[Catch: Exception -> 0x013f, TRY_LEAVE, TryCatch #8 {Exception -> 0x013f, blocks: (B:50:0x012c, B:52:0x0131, B:54:0x0136, B:56:0x013b), top: B:82:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.adp.lib.network.http.a.a a(String str, final c cVar) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        if (k.isEmpty(str)) {
            return null;
        }
        cVar.am(true);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (cVar.mD()) {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL("http://180.76.76.112/v2/0011/?dn=" + str).openConnection();
                try {
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setConnectTimeout(5000);
                    httpURLConnection3.setReadTimeout(10000);
                    httpURLConnection3.setRequestMethod("GET");
                    httpURLConnection3.connect();
                    inputStream = httpURLConnection3.getInputStream();
                    httpURLConnection = httpURLConnection3;
                } catch (Exception e) {
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    e = e;
                    httpURLConnection = httpURLConnection3;
                    cVar.setException(e.getClass().getName());
                    if (e instanceof SSLException) {
                    }
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection3;
                    th = th;
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    throw th;
                }
            } else {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + str).openConnection();
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
                httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.adp.lib.network.http.a.b.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str2, SSLSession sSLSession) {
                        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
                        if (!verify) {
                            cVar.an(true);
                        }
                        return verify;
                    }
                });
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.connect();
                inputStream = httpsURLConnection.getInputStream();
                httpURLConnection = null;
            }
            try {
                inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (Exception e2) {
                                e = e2;
                                cVar.setException(e.getClass().getName());
                                if (e instanceof SSLException) {
                                    cVar.an(true);
                                }
                                e.printStackTrace();
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e3) {
                                        return null;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e4) {
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    }
                    com.baidu.adp.lib.network.http.a.a aVar = new com.baidu.adp.lib.network.http.a.a();
                    aVar.setStartTime(System.currentTimeMillis());
                    cVar.mE();
                    com.baidu.adp.lib.network.http.a.a bI = aVar.bI(stringBuffer.toString());
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e5) {
                            return bI;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return bI;
                    }
                    return bI;
                } catch (Exception e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    httpURLConnection2 = httpURLConnection;
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                httpURLConnection2 = httpURLConnection;
            }
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
        }
    }
}
