package com.baidu.pano.platform.a.a;

import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.s;
import com.baidu.pano.platform.a.t;
import com.baidu.pano.platform.a.u;
import com.baidu.pano.platform.a.v;
import com.baidu.pano.platform.a.w;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes2.dex */
public class a implements com.baidu.pano.platform.a.i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9200a = w.f9303b;

    /* renamed from: d  reason: collision with root package name */
    public static int f9201d = 3000;

    /* renamed from: e  reason: collision with root package name */
    public static int f9202e = 4096;

    /* renamed from: b  reason: collision with root package name */
    public final i f9203b;

    /* renamed from: c  reason: collision with root package name */
    public final b f9204c;

    public a(i iVar) {
        this(iVar, new b(f9202e));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0168 A[SYNTHETIC] */
    @Override // com.baidu.pano.platform.a.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.pano.platform.a.l a(com.baidu.pano.platform.a.n<?> nVar) throws v {
        Map<String, String> map;
        HttpResponse httpResponse;
        byte[] bArr;
        Map<String, String> map2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Map<String, String> emptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap hashMap = new HashMap();
                    a(hashMap, nVar.f());
                    httpResponse = this.f9203b.a(nVar, hashMap);
                    try {
                        StatusLine statusLine = httpResponse.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        Map<String, String> a2 = a(httpResponse.getAllHeaders());
                        try {
                            if (statusCode == 304) {
                                b.a f2 = nVar.f();
                                if (f2 == null) {
                                    return new com.baidu.pano.platform.a.l(304, null, a2, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                                }
                                f2.f9239g.putAll(a2);
                                return new com.baidu.pano.platform.a.l(304, f2.f9233a, f2.f9239g, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                            if (statusCode == 301 || statusCode == 302) {
                                try {
                                    nVar.c(a2.get("Location"));
                                } catch (IOException e2) {
                                    e = e2;
                                    map2 = a2;
                                    bArr = null;
                                    map = map2;
                                    if (httpResponse != null) {
                                        int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                                        if (statusCode2 == 301 || statusCode2 == 302) {
                                            w.c("Request at %s has been redirected to %s", nVar.d(), nVar.c());
                                        } else {
                                            w.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), nVar.c());
                                        }
                                        if (bArr != null) {
                                            com.baidu.pano.platform.a.l lVar = new com.baidu.pano.platform.a.l(statusCode2, bArr, map, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                                            if (statusCode2 == 401 || statusCode2 == 403) {
                                                a("auth", nVar, new com.baidu.pano.platform.a.a(lVar));
                                            } else if (statusCode2 != 301 && statusCode2 != 302) {
                                                throw new t(lVar);
                                            } else {
                                                a("redirect", nVar, new com.baidu.pano.platform.a.a(lVar));
                                            }
                                        } else {
                                            throw new com.baidu.pano.platform.a.k((com.baidu.pano.platform.a.l) null);
                                        }
                                    } else {
                                        throw new com.baidu.pano.platform.a.m(e);
                                    }
                                }
                            }
                            byte[] a3 = httpResponse.getEntity() != null ? a(httpResponse.getEntity()) : new byte[0];
                            try {
                                map2 = a2;
                            } catch (IOException e3) {
                                e = e3;
                                map2 = a2;
                            }
                            try {
                                a(SystemClock.elapsedRealtime() - elapsedRealtime, nVar, a3, statusLine);
                                if (statusCode >= 200 && statusCode <= 299) {
                                    return new com.baidu.pano.platform.a.l(statusCode, a3, map2, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                                }
                                throw new IOException();
                            } catch (IOException e4) {
                                e = e4;
                                bArr = a3;
                                map = map2;
                                if (httpResponse != null) {
                                }
                            }
                        } catch (IOException e5) {
                            e = e5;
                            map = a2;
                            bArr = null;
                            if (httpResponse != null) {
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        map = emptyMap;
                    }
                } catch (IOException e7) {
                    e = e7;
                    map = emptyMap;
                    httpResponse = null;
                    bArr = null;
                }
            } catch (MalformedURLException e8) {
                throw new RuntimeException("Bad URL " + nVar.c(), e8);
            } catch (SocketTimeoutException unused) {
                a("socket", nVar, new u());
            } catch (ConnectTimeoutException unused2) {
                a("connection", nVar, new u());
            }
        }
    }

    public a(i iVar, b bVar) {
        this.f9203b = iVar;
        this.f9204c = bVar;
    }

    private void a(long j, com.baidu.pano.platform.a.n<?> nVar, byte[] bArr, StatusLine statusLine) {
        if (f9200a || j > f9201d) {
            Object[] objArr = new Object[5];
            objArr[0] = nVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : StringUtil.NULL_STRING;
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(nVar.u().b());
            w.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public static void a(String str, com.baidu.pano.platform.a.n<?> nVar, v vVar) throws v {
        s u = nVar.u();
        int t = nVar.t();
        try {
            u.a(vVar);
            nVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(t)));
        } catch (v e2) {
            nVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(t)));
            throw e2;
        }
    }

    private void a(Map<String, String> map, b.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.f9234b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        if (aVar.f9236d > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.f9236d)));
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, t {
        k kVar = new k(this.f9204c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                byte[] a2 = this.f9204c.a(1024);
                while (true) {
                    int read = content.read(a2);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(a2, 0, read);
                }
                byte[] byteArray = kVar.toByteArray();
                try {
                    httpEntity.consumeContent();
                } catch (IOException unused) {
                    w.a("Error occured when calling consumingContent", new Object[0]);
                }
                this.f9204c.a(a2);
                kVar.close();
                return byteArray;
            }
            throw new t();
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                w.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f9204c.a((byte[]) null);
            kVar.close();
            throw th;
        }
    }

    public static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i2 = 0; i2 < headerArr.length; i2++) {
            treeMap.put(headerArr[i2].getName(), headerArr[i2].getValue());
        }
        return treeMap;
    }
}
