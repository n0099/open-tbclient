package com.baidu.baiduarsdk.filter;

import com.baidu.baiduarsdk.filter.configdata.FilterData;
import com.baidu.baiduarsdk.gpuimage.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private String a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Map<Integer, FilterData> g;
    private Map<Integer, FilterData> h;
    private Map<Integer, FilterData> i;
    private Map<Integer, g> j;
    private Map<Integer, g> k;
    private Map<Integer, g> l;
    private List<g> m = new ArrayList();
    private List<g> n = new ArrayList();
    private List<g> o = new ArrayList();

    private List<g> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g());
        return arrayList;
    }

    public String a() {
        return this.a;
    }

    public synchronized void a(int i) {
        this.b = i;
    }

    public void a(int i, FilterData filterData) {
        if (this.g != null) {
            this.g.put(Integer.valueOf(i), filterData);
        }
    }

    public void a(int i, g gVar) {
        if (this.j != null) {
            this.j.put(Integer.valueOf(i), gVar);
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(Map<Integer, FilterData> map) {
        this.g = map;
    }

    public synchronized void a(boolean z) {
        this.c = z;
    }

    public synchronized int b() {
        return this.b;
    }

    public void b(int i) {
        if (this.g != null) {
            this.g.remove(Integer.valueOf(i));
        }
    }

    public void b(int i, FilterData filterData) {
        if (this.h != null) {
            this.h.put(Integer.valueOf(i), filterData);
        }
    }

    public void b(int i, g gVar) {
        if (this.k != null) {
            this.k.put(Integer.valueOf(i), gVar);
        }
    }

    public void b(Map<Integer, FilterData> map) {
        this.h = map;
    }

    public synchronized void b(boolean z) {
        this.d = z;
    }

    public synchronized List<g> c() {
        List<g> l;
        if (!this.c || !this.d || this.j == null || this.j.size() == 0) {
            l = l();
        } else {
            this.m.clear();
            this.m.addAll(this.j.values());
            l = this.m;
        }
        return l;
    }

    public void c(int i) {
        if (this.h != null) {
            this.h.remove(Integer.valueOf(i));
        }
    }

    public void c(int i, FilterData filterData) {
        if (this.i != null) {
            this.i.put(Integer.valueOf(i), filterData);
        }
    }

    public void c(int i, g gVar) {
        if (this.l != null) {
            this.l.put(Integer.valueOf(i), gVar);
        }
    }

    public void c(Map<Integer, FilterData> map) {
        this.i = map;
    }

    public synchronized void c(boolean z) {
        this.e = z;
    }

    public List<g> d() {
        if (!this.c || !this.e || this.k == null || this.k.size() == 0) {
            return l();
        }
        this.n.clear();
        this.n.addAll(this.k.values());
        return this.n;
    }

    public void d(int i) {
        if (this.i != null) {
            this.i.remove(Integer.valueOf(i));
        }
    }

    public void d(Map<Integer, g> map) {
        this.j = map;
    }

    public synchronized void d(boolean z) {
        this.f = z;
    }

    public synchronized List<g> e() {
        List<g> l;
        if (!this.c || !this.f || this.l == null || this.l.size() == 0) {
            l = l();
        } else {
            this.o.clear();
            this.o.addAll(this.l.values());
            l = this.o;
        }
        return l;
    }

    public void e(int i) {
        if (this.j != null) {
            this.j.remove(Integer.valueOf(i));
        }
    }

    public void e(Map<Integer, g> map) {
        this.k = map;
    }

    public Map<Integer, FilterData> f() {
        return this.g;
    }

    public void f(int i) {
        if (this.k != null) {
            this.k.remove(Integer.valueOf(i));
        }
    }

    public void f(Map<Integer, g> map) {
        this.l = map;
    }

    public Map<Integer, FilterData> g() {
        return this.h;
    }

    public void g(int i) {
        if (this.l != null) {
            this.l.remove(Integer.valueOf(i));
        }
    }

    public Map<Integer, FilterData> h() {
        return this.i;
    }

    public Map<Integer, g> i() {
        return this.j;
    }

    public Map<Integer, g> j() {
        return this.k;
    }

    public Map<Integer, g> k() {
        return this.l;
    }
}
