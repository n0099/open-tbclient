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
    private static b Oi = null;
    private HashMap<String, com.baidu.adp.lib.network.http.a.a> mCache = new HashMap<>();
    private a Oj = null;
    private int Ok = 0;

    /* loaded from: classes.dex */
    public interface a {
    }

    private b() {
    }

    public static b mf() {
        if (Oi == null) {
            synchronized (b.class) {
                if (Oi == null) {
                    Oi = new b();
                }
            }
        }
        return Oi;
    }

    public c bM(String str) {
        c cVar = new c();
        com.baidu.adp.lib.network.http.a.a aVar = this.mCache.get(str);
        if (aVar != null && !aVar.D(System.currentTimeMillis()) && aVar.me() != null && aVar.me().size() > 0) {
            cVar.bO(aVar.me().get(0));
        }
        return cVar;
    }

    public c t(String str, String str2) {
        c cVar = new c();
        if (k.isEmpty(str)) {
            return cVar;
        }
        com.baidu.adp.lib.network.http.a.a aVar = this.mCache.get(str);
        if (aVar != null && !aVar.D(System.currentTimeMillis()) && aVar.me() != null && aVar.me().size() > 0) {
            for (int i = 0; i < aVar.me().size(); i++) {
                if (!k.x(str2, aVar.me().get(i))) {
                    cVar.ar(i);
                    cVar.bO(aVar.me().get(i));
                    return cVar;
                } else if (i == aVar.me().size() - 1) {
                    cVar.ar(0);
                    cVar.bO(aVar.me().get(0));
                    return cVar;
                }
            }
        }
        for (int i2 = 0; i2 < 3; i2++) {
            cVar.mh();
            cVar.au(i2);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.a.a a2 = a(str, cVar);
            cVar.E(System.currentTimeMillis() - currentTimeMillis);
            if (a2 != null && a2.me() != null && a2.me().size() > 0) {
                a2.C(300L);
                this.mCache.put(str, a2);
                for (int i3 = 0; i3 < a2.me().size(); i3++) {
                    if (!k.x(str2, a2.me().get(i2))) {
                        cVar.ar(i3);
                        cVar.bO(a2.me().get(i3));
                        return cVar;
                    } else if (i3 == a2.me().size() - 1) {
                        cVar.ar(0);
                        cVar.bO(a2.me().get(0));
                        return cVar;
                    }
                }
                continue;
            } else {
                com.baidu.adp.lib.network.http.a.a aVar2 = this.mCache.get(str);
                if (aVar2 != null && aVar2.me() != null && aVar2.me().size() > 0) {
                    cVar.bO(aVar2.me().get(0));
                    return cVar;
                }
            }
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0083 A[Catch: all -> 0x0153, TryCatch #7 {all -> 0x0153, blocks: (B:15:0x0068, B:17:0x006e, B:36:0x00f7, B:21:0x0074, B:23:0x0083, B:24:0x0087), top: B:81:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[Catch: Exception -> 0x0156, TryCatch #3 {Exception -> 0x0156, blocks: (B:26:0x008c, B:28:0x0091, B:30:0x0096, B:32:0x009b), top: B:79:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096 A[Catch: Exception -> 0x0156, TryCatch #3 {Exception -> 0x0156, blocks: (B:26:0x008c, B:28:0x0091, B:30:0x0096, B:32:0x009b), top: B:79:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[Catch: Exception -> 0x0156, TRY_LEAVE, TryCatch #3 {Exception -> 0x0156, blocks: (B:26:0x008c, B:28:0x0091, B:30:0x0096, B:32:0x009b), top: B:79:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134 A[Catch: Exception -> 0x0142, TryCatch #11 {Exception -> 0x0142, blocks: (B:51:0x012f, B:53:0x0134, B:55:0x0139, B:57:0x013e), top: B:86:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139 A[Catch: Exception -> 0x0142, TryCatch #11 {Exception -> 0x0142, blocks: (B:51:0x012f, B:53:0x0134, B:55:0x0139, B:57:0x013e), top: B:86:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e A[Catch: Exception -> 0x0142, TRY_LEAVE, TryCatch #11 {Exception -> 0x0142, blocks: (B:51:0x012f, B:53:0x0134, B:55:0x0139, B:57:0x013e), top: B:86:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.adp.lib.network.http.a.a a(String str, final c cVar) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        Exception e;
        if (k.isEmpty(str)) {
            return null;
        }
        cVar.aj(true);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (cVar.mg()) {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://180.76.76.112/v2/0011/?dn=" + str).openConnection();
                try {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.connect();
                    inputStream = httpURLConnection2.getInputStream();
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
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
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection != null) {
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
                            cVar.ak(true);
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
                            } catch (Exception e3) {
                                e = e3;
                                cVar.setException(e.getClass().getName());
                                if (e instanceof SSLException) {
                                    cVar.ak(true);
                                }
                                e.printStackTrace();
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e4) {
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
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e5) {
                                    throw th;
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
                            throw th;
                        }
                    }
                    com.baidu.adp.lib.network.http.a.a aVar = new com.baidu.adp.lib.network.http.a.a();
                    aVar.setStartTime(System.currentTimeMillis());
                    cVar.mh();
                    com.baidu.adp.lib.network.http.a.a bL = aVar.bL(stringBuffer.toString());
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e6) {
                            return bL;
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
                        return bL;
                    }
                    return bL;
                } catch (Exception e7) {
                    e = e7;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (Exception e9) {
            e = e9;
            httpURLConnection = null;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
        }
    }
}
