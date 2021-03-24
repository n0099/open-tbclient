package com.baidu.pano.platform.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.pano.platform.a.b;
import com.baidu.pano.platform.a.q;
import com.baidu.pano.platform.a.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public abstract class n<T> implements Comparable<n<T>> {
    public static long p;

    /* renamed from: a  reason: collision with root package name */
    public final w.a f9383a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9384b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9385c;

    /* renamed from: d  reason: collision with root package name */
    public String f9386d;

    /* renamed from: e  reason: collision with root package name */
    public String f9387e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9388f;

    /* renamed from: g  reason: collision with root package name */
    public final q.a f9389g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f9390h;
    public p i;
    public boolean j;
    public boolean k;
    public boolean l;
    public long m;
    public s n;
    public b.a o;

    /* loaded from: classes2.dex */
    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public n(int i, String str, q.a aVar) {
        this.f9383a = w.a.f9415a ? new w.a() : null;
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = 0L;
        this.o = null;
        this.f9384b = i;
        this.f9385c = str;
        this.f9387e = a(i, str);
        this.f9389g = aVar;
        a((s) new e());
        this.f9388f = d(str);
    }

    public static int d(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public int a() {
        return this.f9384b;
    }

    public abstract q<T> a(l lVar);

    public v a(v vVar) {
        return vVar;
    }

    public abstract void a(T t);

    public String c() {
        String str = this.f9386d;
        return str != null ? str : this.f9385c;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        return a((n) ((n) obj));
    }

    public String e() {
        return c();
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
    public Map<String, String> j() throws com.baidu.pano.platform.a.a {
        return n();
    }

    @Deprecated
    public String k() {
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

    public Map<String, String> n() throws com.baidu.pano.platform.a.a {
        return null;
    }

    public String o() {
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

    public final boolean r() {
        return this.j;
    }

    public a s() {
        return a.NORMAL;
    }

    public final int t() {
        return this.n.a();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(b());
        StringBuilder sb = new StringBuilder();
        sb.append(this.k ? "[X] " : "[ ] ");
        sb.append(c());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(s());
        sb.append(" ");
        sb.append(this.f9390h);
        return sb.toString();
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(s sVar) {
        this.n = sVar;
        return this;
    }

    public int b() {
        return this.f9388f;
    }

    public void c(String str) {
        this.f9386d = str;
    }

    public void a(String str) {
        if (w.a.f9415a) {
            this.f9383a.a(str, Thread.currentThread().getId());
        } else if (this.m == 0) {
            this.m = SystemClock.elapsedRealtime();
        }
    }

    public void b(String str) {
        p pVar = this.i;
        if (pVar != null) {
            pVar.b(this);
        }
        if (w.a.f9415a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new o(this, str, id));
                return;
            }
            this.f9383a.a(str, id);
            this.f9383a.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        if (elapsedRealtime >= 3000) {
            w.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public String d() {
        return this.f9385c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(p pVar) {
        this.i = pVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> a(int i) {
        this.f9390h = Integer.valueOf(i);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public n<?> a(b.a aVar) {
        this.o = aVar;
        return this;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append(com.alipay.sdk.encrypt.a.f1897h);
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append(Typography.amp);
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public void b(v vVar) {
        q.a aVar = this.f9389g;
        if (aVar != null) {
            aVar.a(vVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.pano.platform.a.n<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> a(boolean z) {
        this.j = z;
        return this;
    }

    public int a(n<T> nVar) {
        a s = s();
        a s2 = nVar.s();
        if (s == s2) {
            return this.f9390h.intValue() - nVar.f9390h.intValue();
        }
        return s2.ordinal() - s.ordinal();
    }

    public static String a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Request:");
        sb.append(i);
        sb.append(":");
        sb.append(str);
        sb.append(":");
        sb.append(System.currentTimeMillis());
        sb.append(":");
        long j = p;
        p = 1 + j;
        sb.append(j);
        return h.a(sb.toString());
    }
}
