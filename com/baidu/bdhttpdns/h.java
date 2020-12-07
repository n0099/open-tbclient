package com.baidu.bdhttpdns;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes5.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f1275a;
    private final LruCache<String, a> afj = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<String> f1276a;
        private ArrayList<String> b;
        private long c;
        private long d;

        public void a(long j) {
            this.c = j;
        }

        public void a(ArrayList<String> arrayList) {
            this.f1276a = arrayList;
        }

        public boolean a() {
            return e() + this.c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> b() {
            return this.f1276a;
        }

        public void b(long j) {
            this.d = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.b = arrayList;
        }

        public ArrayList<String> c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public long e() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, boolean z) {
        this.c = false;
        this.f1275a = str;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.afj.evictAll();
        l.a("Clear %s cache", this.f1275a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        ArrayList<String> b = aVar.b();
        ArrayList<String> c = aVar.c();
        if ((b == null || b.isEmpty()) && (c == null || c.isEmpty())) {
            return;
        }
        this.afj.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f1275a;
        objArr[1] = str;
        objArr[2] = b != null ? b.toString() : null;
        objArr[3] = c != null ? c.toString() : null;
        objArr[4] = Long.valueOf(aVar.d());
        l.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.afj.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a dm = dm(str);
        if (dm == null || !dm.a()) {
            return;
        }
        this.afj.remove(str);
        l.a("Remove expired entry from %s cache, host(%s)", this.f1275a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a dm(String str) {
        a aVar = this.afj.get(str);
        if (aVar != null && aVar.a() && this.c) {
            this.afj.remove(str);
            l.a("Remove expired entry from %s cache while reading, host(%s)", this.f1275a, str);
            return null;
        }
        return aVar;
    }
}
