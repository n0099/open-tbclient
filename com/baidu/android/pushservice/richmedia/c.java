package com.baidu.android.pushservice.richmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes2.dex */
public class c {
    public String a;
    public String b;
    public String c;
    public String d;
    protected a e;
    private String i;
    private String k;
    private String l;
    private String m;
    private Map<String, String> j = new HashMap();
    public boolean g = true;
    public boolean h = false;
    public HashMap<String, String> f = new HashMap<>();

    /* loaded from: classes2.dex */
    public enum a {
        REQ_TYPE_GET_ZIP
    }

    public a a() {
        return this.e;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(String str) {
        this.k = str;
    }

    public String b() {
        return this.k == null ? HttpGet.METHOD_NAME : this.k;
    }

    public void b(String str) {
        this.l = str;
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.l != null) {
            stringBuffer.append(this.l);
        }
        this.l = stringBuffer.toString();
        return this.l.endsWith("&") ? this.l.substring(0, this.l.length() - 1) : this.l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.i != null ? this.i.equals(cVar.i) : cVar.i == null) {
                if (this.e != null ? this.e.equals(cVar.e) : cVar.e == null) {
                    if (this.j != null ? this.j.equals(cVar.j) : cVar.j == null) {
                        if (this.k != null ? this.k.equals(cVar.k) : cVar.k == null) {
                            if (this.l != null ? this.l.equals(cVar.l) : cVar.l == null) {
                                if (this.m != null ? this.m.equals(cVar.m) : cVar.m == null) {
                                    if (this.f != null ? this.f.equals(cVar.f) : cVar.f == null) {
                                        if (this.h == cVar.h) {
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.i);
        arrayList.add(this.e);
        arrayList.add(this.j);
        arrayList.add(this.k);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.f);
        arrayList.add(Boolean.valueOf(this.h));
        return arrayList.hashCode();
    }
}
