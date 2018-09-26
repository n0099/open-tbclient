package cn.jiguang.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
/* loaded from: classes3.dex */
public class b {
    private String a;
    private Map<String, String> d;
    private Object f;
    private boolean g;
    private boolean h;
    private boolean i;
    private e mb;
    private HostnameVerifier mc;
    private boolean n;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private int b = -1;
    private int c = -1;
    private Map<String, String> e = new HashMap();

    public b(String str) {
        this.a = str;
    }

    public void a(e eVar) {
        this.mb = eVar;
    }

    public boolean bW() {
        return this.l;
    }

    public e bX() {
        return this.mb;
    }

    public byte[] bY() {
        if (this.f != null) {
            if (this.f instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) this.f)) {
                    return ((String) this.f).getBytes();
                }
            } else if (this.f instanceof byte[]) {
                return (byte[]) this.f;
            }
        }
        String g = d.g(this.d);
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        return g.getBytes();
    }

    public boolean bZ() {
        return this.j;
    }

    public boolean ca() {
        return this.k;
    }

    public void f(Object obj) {
        this.f = obj;
    }

    public int getConnectTimeout() {
        return this.b;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.mc;
    }

    public int getReadTimeout() {
        return this.c;
    }

    public Map<String, String> getRequestProperties() {
        return this.e;
    }

    public String getUrl() {
        return this.a;
    }

    public void j(boolean z) {
        this.g = z;
    }

    public void k(boolean z) {
        this.h = z;
    }

    public void l(boolean z) {
        this.l = z;
    }

    public void m(boolean z) {
        this.n = z;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o(boolean z) {
        this.k = z;
    }

    public void setConnectTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.b = i;
    }

    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.c = i;
    }

    public void setRequestProperty(String str, String str2) {
        this.e.put(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.i = z;
    }
}
