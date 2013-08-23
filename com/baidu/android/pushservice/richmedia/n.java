package com.baidu.android.pushservice.richmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.util.LangUtils;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f638a;
    public String b;
    public String c;
    public String d;
    protected o e;
    private String j;
    private String l;
    private String m;
    private String n;
    private l i = l.a(n.class.getName());
    private Map k = new HashMap();
    public boolean g = true;
    public boolean h = false;
    public List f = new ArrayList();

    public Map a() {
        return this.k;
    }

    public void a(o oVar) {
        this.e = oVar;
    }

    public void a(String str) {
        this.l = str;
    }

    public o b() {
        return this.e;
    }

    public void b(String str) {
        this.m = str;
    }

    public String c() {
        return this.l == null ? "GET" : this.l;
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.m != null) {
            stringBuffer.append(this.m);
        }
        this.m = stringBuffer.toString();
        return this.m.endsWith("&") ? this.m.substring(0, this.m.length() - 1) : this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.j != null ? this.j.equals(nVar.j) : nVar.j == null) {
                if (this.e != null ? this.e.equals(nVar.e) : nVar.e == null) {
                    if (this.k != null ? this.k.equals(nVar.k) : nVar.k == null) {
                        if (this.l != null ? this.l.equals(nVar.l) : nVar.l == null) {
                            if (this.m != null ? this.m.equals(nVar.m) : nVar.m == null) {
                                if (this.n != null ? this.n.equals(nVar.n) : nVar.n == null) {
                                    if (this.f != null ? this.f.equals(nVar.f) : nVar.f == null) {
                                        if (this.h == nVar.h) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.j), this.e), this.k), this.l), this.m), this.n), this.f), this.h);
    }
}
