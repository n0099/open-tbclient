package com.baidu.bdhttpdns;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c {
    private final LruCache<String, a> EC = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private final String a;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private ArrayList<String> a;
        private ArrayList<String> b;
        private long c;
        private long d;

        public void a(long j) {
            this.c = j;
        }

        public void a(ArrayList<String> arrayList) {
            this.a = arrayList;
        }

        public boolean a() {
            return e() + this.c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> b() {
            return this.a;
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
    public c(String str, boolean z) {
        this.c = false;
        this.a = str;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.EC.evictAll();
        f.a("Clear %s cache", this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        ArrayList<String> b = aVar.b();
        ArrayList<String> c = aVar.c();
        if ((b == null || b.isEmpty()) && (c == null || c.isEmpty())) {
            return;
        }
        this.EC.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.a;
        objArr[1] = str;
        objArr[2] = b != null ? b.toString() : null;
        objArr[3] = c != null ? c.toString() : null;
        objArr[4] = Long.valueOf(aVar.d());
        f.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.EC.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a bs = bs(str);
        if (bs == null || !bs.a()) {
            return;
        }
        this.EC.remove(str);
        f.a("Remove expired entry from %s cache, host(%s)", this.a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bs(String str) {
        a aVar = this.EC.get(str);
        if (aVar != null && aVar.a() && this.c) {
            this.EC.remove(str);
            f.a("Remove expired entry from %s cache while reading, host(%s)", this.a, str);
            return null;
        }
        return aVar;
    }
}
