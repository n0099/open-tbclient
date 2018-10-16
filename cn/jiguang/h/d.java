package cn.jiguang.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.text.TextUtils;
import cn.jiguang.d.h.x;
import cn.jiguang.g.f;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.webkit.internal.ETAG;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
/* loaded from: classes3.dex */
public class d {
    public static HttpURLConnection R(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals(Apn.APN_CMWAP) || extraInfo.equals(Apn.APN_3GWAP) || extraInfo.equals(Apn.APN_UNIWAP))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                }
            } catch (Throwable th) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static c a(Context context, b bVar) {
        return a(context, bVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static c a(Context context, b bVar, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        InputStream inputStream3;
        byte[] bArr;
        InputStream inputStream4 = null;
        if (bVar == null) {
            return null;
        }
        c cVar = new c(bVar.getUrl());
        try {
            try {
                httpURLConnection = R(context, bVar.getUrl());
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            inputStream3 = null;
            httpURLConnection = null;
        } catch (Exception e2) {
            e = e2;
            inputStream3 = null;
            httpURLConnection = null;
        } catch (StackOverflowError e3) {
            inputStream3 = null;
            httpURLConnection = null;
        } catch (MalformedURLException e4) {
            inputStream2 = null;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.getURL().getPort();
            if (bVar != null && httpURLConnection != null) {
                a(bVar.getRequestProperties(), httpURLConnection);
                if (bVar.getConnectTimeout() >= 0) {
                    httpURLConnection.setConnectTimeout(bVar.getConnectTimeout());
                }
                if (bVar.getReadTimeout() >= 0) {
                    httpURLConnection.setReadTimeout(bVar.getReadTimeout());
                }
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    if (bVar.co() != null) {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{bVar.co()}, new SecureRandom());
                        if (sSLContext != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                        }
                    }
                    if (bVar.getHostnameVerifier() != null) {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(bVar.getHostnameVerifier());
                    } else {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new a(httpURLConnection.getURL().getHost()));
                    }
                } catch (Throwable th3) {
                    cn.jiguang.e.c.c("HttpUtils", "set ssl config error:" + th3.getMessage());
                }
            }
            if (z) {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                byte[] cp = bVar.cp();
                if (cp != null) {
                    httpURLConnection.getOutputStream().write(cp);
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            cVar.q(responseCode);
            try {
                inputStream3 = httpURLConnection.getInputStream();
            } catch (Throwable th4) {
                inputStream3 = null;
            }
            try {
                if (!bVar.cq() || inputStream3 == null) {
                    bArr = null;
                } else {
                    try {
                        bArr = f(inputStream3);
                        if (bArr != null) {
                            try {
                                if (bVar.cr()) {
                                    bArr = x.b(bArr);
                                }
                            } catch (Throwable th5) {
                            }
                        }
                    } catch (Throwable th6) {
                        bArr = null;
                    }
                }
                if (bArr == null && responseCode != 200 && bVar.cn()) {
                    inputStream4 = httpURLConnection.getErrorStream();
                    bArr = f(inputStream4);
                }
                if (bArr != null) {
                    cVar.R(new String(bArr, "UTF-8"));
                }
                if (httpURLConnection != null) {
                    cVar.q(httpURLConnection.getResponseCode());
                    cVar.m("expires", httpURLConnection.getHeaderField("Expires"));
                    cVar.m(Headers.CACHE_CONTROL, httpURLConnection.getHeaderField("Cache-Control"));
                }
                f.a((Closeable) inputStream3);
                f.a((Closeable) inputStream4);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (MalformedURLException e5) {
                inputStream2 = inputStream3;
                try {
                    cVar.q(3004);
                    cVar.R("MalformedURLException");
                    f.a((Closeable) inputStream2);
                    f.a((Closeable) inputStream4);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return cVar;
                } catch (Throwable th7) {
                    inputStream = inputStream2;
                    th = th7;
                    f.a((Closeable) inputStream);
                    f.a((Closeable) inputStream4);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                cVar.q(2998);
                cVar.R("网络错误");
                if (e instanceof SocketTimeoutException) {
                    cVar.q(3001);
                    cVar.R("请求超时");
                } else if (e instanceof UnknownHostException) {
                    cVar.q(3003);
                    cVar.R("域名无效");
                } else if (e instanceof SSLHandshakeException) {
                    cVar.q(ComponentMessageType.MSG_TYPE_LOGO_START);
                    cVar.R("SSL失败");
                }
                f.a((Closeable) inputStream3);
                f.a((Closeable) inputStream4);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return cVar;
            } catch (Exception e7) {
                e = e7;
                cVar.q(ComponentMessageType.MSG_TYPE_LOGO_STOP);
                cVar.R("UNKnow execption" + e.getMessage());
                f.a((Closeable) inputStream3);
                f.a((Closeable) inputStream4);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return cVar;
            } catch (StackOverflowError e8) {
                cVar.q(ComponentMessageType.MSG_TYPE_LOGO_HIT);
                cVar.R("StackOverflowError");
                f.a((Closeable) inputStream3);
                f.a((Closeable) inputStream4);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return cVar;
            }
        } catch (IOException e9) {
            e = e9;
            inputStream3 = null;
        } catch (StackOverflowError e10) {
            inputStream3 = null;
        } catch (MalformedURLException e11) {
            inputStream2 = null;
        } catch (Exception e12) {
            e = e12;
            inputStream3 = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            f.a((Closeable) inputStream);
            f.a((Closeable) inputStream4);
            if (httpURLConnection != null) {
            }
            throw th;
        }
        return cVar;
    }

    public static void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static c b(Context context, b bVar) {
        return a(context, bVar, true);
    }

    public static byte[] f(InputStream inputStream) {
        return f.a(inputStream);
    }

    public static String g(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey()).append(ETAG.EQUAL).append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
