package com.baidu.pano.platform.a.a;

import android.os.SystemClock;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.s;
import com.baidu.pano.platform.a.t;
import com.baidu.pano.platform.a.u;
import com.baidu.pano.platform.a.v;
import com.baidu.pano.platform.a.w;
import com.baidubce.http.Headers;
import com.coremedia.iso.boxes.AuthorBox;
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
/* loaded from: classes3.dex */
public class a implements com.baidu.pano.platform.a.i {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f3885a = w.f3933b;
    private static int d = 3000;
    private static int e = 4096;

    /* renamed from: b  reason: collision with root package name */
    protected final i f3886b;
    protected final b c;

    public a(i iVar) {
        this(iVar, new b(e));
    }

    public a(i iVar, b bVar) {
        this.f3886b = iVar;
        this.c = bVar;
    }

    @Override // com.baidu.pano.platform.a.i
    public com.baidu.pano.platform.a.l a(com.baidu.pano.platform.a.n<?> nVar) throws v {
        byte[] bArr;
        byte[] bArr2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> emptyMap = Collections.emptyMap();
            try {
                try {
                    HashMap hashMap = new HashMap();
                    a(hashMap, nVar.f());
                    HttpResponse a2 = this.f3886b.a(nVar, hashMap);
                    try {
                        StatusLine statusLine = a2.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        emptyMap = a(a2.getAllHeaders());
                        if (statusCode == 304) {
                            b.a f = nVar.f();
                            if (f == null) {
                                return new com.baidu.pano.platform.a.l(304, null, emptyMap, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                            f.g.putAll(emptyMap);
                            return new com.baidu.pano.platform.a.l(304, f.f3902a, f.g, true, SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        if (statusCode == 301 || statusCode == 302) {
                            nVar.c(emptyMap.get(Headers.LOCATION));
                        }
                        if (a2.getEntity() != null) {
                            bArr2 = a(a2.getEntity());
                        } else {
                            bArr2 = new byte[0];
                        }
                        try {
                            a(SystemClock.elapsedRealtime() - elapsedRealtime, nVar, bArr2, statusLine);
                            if (statusCode < 200 || statusCode > 299) {
                                throw new IOException();
                            }
                            return new com.baidu.pano.platform.a.l(statusCode, bArr2, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                        } catch (IOException e2) {
                            e = e2;
                            bArr = bArr2;
                            httpResponse = a2;
                            if (httpResponse != null) {
                                int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                                if (statusCode2 == 301 || statusCode2 == 302) {
                                    w.c("Request at %s has been redirected to %s", nVar.d(), nVar.c());
                                } else {
                                    w.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), nVar.c());
                                }
                                if (bArr != null) {
                                    com.baidu.pano.platform.a.l lVar = new com.baidu.pano.platform.a.l(statusCode2, bArr, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                                    if (statusCode2 == 401 || statusCode2 == 403) {
                                        a(AuthorBox.TYPE, nVar, new com.baidu.pano.platform.a.a(lVar));
                                    } else if (statusCode2 == 301 || statusCode2 == 302) {
                                        a("redirect", nVar, new com.baidu.pano.platform.a.a(lVar));
                                    } else {
                                        throw new t(lVar);
                                    }
                                } else {
                                    throw new com.baidu.pano.platform.a.k((com.baidu.pano.platform.a.l) null);
                                }
                            } else {
                                throw new com.baidu.pano.platform.a.m(e);
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bArr = null;
                        httpResponse = a2;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bArr = null;
                }
            } catch (MalformedURLException e5) {
                throw new RuntimeException("Bad URL " + nVar.c(), e5);
            } catch (SocketTimeoutException e6) {
                a("socket", nVar, new u());
            } catch (ConnectTimeoutException e7) {
                a(android.net.http.Headers.CONN_DIRECTIVE, nVar, new u());
            }
        }
    }

    private void a(long j, com.baidu.pano.platform.a.n<?> nVar, byte[] bArr, StatusLine statusLine) {
        if (f3885a || j > d) {
            Object[] objArr = new Object[5];
            objArr[0] = nVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(nVar.u().b());
            w.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, com.baidu.pano.platform.a.n<?> nVar, v vVar) throws v {
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
        if (aVar != null) {
            if (aVar.f3903b != null) {
                map.put("If-None-Match", aVar.f3903b);
            }
            if (aVar.d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.d)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, t {
        k kVar = new k(this.c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new t();
            }
            byte[] a2 = this.c.a(1024);
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
            } catch (IOException e2) {
                w.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a(a2);
            kVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e3) {
                w.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a((byte[]) null);
            kVar.close();
            throw th;
        }
    }

    protected static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
