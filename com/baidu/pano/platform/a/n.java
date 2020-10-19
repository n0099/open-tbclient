package com.baidu.pano.platform.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.q;
import com.baidu.pano.platform.a.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class n<T> implements Comparable<n<T>> {
    private static long p;

    /* renamed from: a  reason: collision with root package name */
    private final w.a f2656a;
    private final int b;
    private final String c;
    private String d;
    private String e;
    private final int f;
    private final q.a g;
    private Integer h;
    private p i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private s n;
    private b.a o;

    /* loaded from: classes7.dex */
    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract q<T> a(l lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(T t);

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        return a((n) ((n) obj));
    }

    public n(int i, String str, q.a aVar) {
        this.f2656a = w.a.f2663a ? new w.a() : null;
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = 0L;
        this.o = null;
        this.b = i;
        this.c = str;
        this.e = a(i, str);
        this.g = aVar;
        a((s) new e());
        this.f = d(str);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f;
    }

    private static int d(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(s sVar) {
        this.n = sVar;
        return this;
    }

    public void a(String str) {
        if (w.a.f2663a) {
            this.f2656a.a(str, Thread.currentThread().getId());
        } else if (this.m == 0) {
            this.m = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (this.i != null) {
            this.i.b(this);
        }
        if (w.a.f2663a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new o(this, str, id));
                return;
            }
            this.f2656a.a(str, id);
            this.f2656a.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        if (elapsedRealtime >= IMConnection.RETRY_DELAY_TIMES) {
            w.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(p pVar) {
        this.i = pVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> a(int i) {
        this.h = Integer.valueOf(i);
        return this;
    }

    public String c() {
        return this.d != null ? this.d : this.c;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String e() {
        return c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(b.a aVar) {
        this.o = aVar;
        return this;
    }

    public b.a f() {
        return this.o;
    }

    public void g() {
        this.k = true;
    }

    public boolean h() {
        return this.k;
    }

    public Map<String, String> i() throws com.baidu.pano.platform.a.a {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> j() throws com.baidu.pano.platform.a.a {
        return n();
    }

    @Deprecated
    protected String k() {
        return o();
    }

    @Deprecated
    public String l() {
        return p();
    }

    @Deprecated
    public byte[] m() throws com.baidu.pano.platform.a.a {
        Map<String, String> j = j();
        if (j == null || j.size() <= 0) {
            return null;
        }
        return a(j, k());
    }

    protected Map<String, String> n() throws com.baidu.pano.platform.a.a {
        return null;
    }

    protected String o() {
        return "UTF-8";
    }

    public String p() {
        return "application/x-www-form-urlencoded; charset=" + o();
    }

    public byte[] q() throws com.baidu.pano.platform.a.a {
        Map<String, String> n = n();
        if (n == null || n.size() <= 0) {
            return null;
        }
        return a(n, o());
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> a(boolean z) {
        this.j = z;
        return this;
    }

    public final boolean r() {
        return this.j;
    }

    public a s() {
        return a.NORMAL;
    }

    public final int t() {
        return this.n.a();
    }

    public s u() {
        return this.n;
    }

    public void v() {
        this.l = true;
    }

    public boolean w() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v a(v vVar) {
        return vVar;
    }

    public void b(v vVar) {
        if (this.g != null) {
            this.g.a(vVar);
        }
    }

    public int a(n<T> nVar) {
        a s = s();
        a s2 = nVar.s();
        if (s == s2) {
            return this.h.intValue() - nVar.h.intValue();
        }
        return s2.ordinal() - s.ordinal();
    }

    public String toString() {
        return (this.k ? "[X] " : "[ ] ") + c() + " " + ("0x" + Integer.toHexString(b())) + " " + s() + " " + this.h;
    }

    private static String a(int i, String str) {
        StringBuilder append = new StringBuilder().append("Request:").append(i).append(":").append(str).append(":").append(System.currentTimeMillis()).append(":");
        long j = p;
        p = 1 + j;
        return h.a(append.append(j).toString());
    }
}
