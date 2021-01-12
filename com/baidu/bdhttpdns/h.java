package com.baidu.bdhttpdns;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f1578a;

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, a> f1579b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<String> f1580a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f1581b;
        private long c;
        private long d;

        public void a(long j) {
            this.c = j;
        }

        public void a(ArrayList<String> arrayList) {
            this.f1580a = arrayList;
        }

        public boolean a() {
            return e() + this.c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> b() {
            return this.f1580a;
        }

        public void b(long j) {
            this.d = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f1581b = arrayList;
        }

        public ArrayList<String> c() {
            return this.f1581b;
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
        this.f1578a = str;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f1579b.evictAll();
        l.a("Clear %s cache", this.f1578a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        ArrayList<String> b2 = aVar.b();
        ArrayList<String> c = aVar.c();
        if ((b2 == null || b2.isEmpty()) && (c == null || c.isEmpty())) {
            return;
        }
        this.f1579b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f1578a;
        objArr[1] = str;
        objArr[2] = b2 != null ? b2.toString() : null;
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
        for (String str : this.f1579b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a da = da(str);
        if (da == null || !da.a()) {
            return;
        }
        this.f1579b.remove(str);
        l.a("Remove expired entry from %s cache, host(%s)", this.f1578a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a da(String str) {
        a aVar = this.f1579b.get(str);
        if (aVar != null && aVar.a() && this.c) {
            this.f1579b.remove(str);
            l.a("Remove expired entry from %s cache while reading, host(%s)", this.f1578a, str);
            return null;
        }
        return aVar;
    }
}
