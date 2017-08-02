package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e c(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e eD() {
        return new c();
    }

    /* loaded from: classes.dex */
    static class c implements e {
        c() {
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return 1;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ey() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> tu;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void ez() {
            this.tu = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.tA < System.currentTimeMillis()) {
                return gVar.tw;
            }
            this.tu.add(gVar);
            if (this.tu.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tu.size()) {
                    g<?> gVar2 = this.tu.get(i2);
                    if (i3 == -1 || gVar2.tz < j) {
                        String str3 = gVar2.tw;
                        j = gVar2.tz;
                        str = str3;
                        i = i2;
                    } else {
                        str = str2;
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                    str2 = str;
                }
                this.tu.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void eA() {
            this.tu.clear();
            this.tu = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ey() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;

        /* renamed from: tv  reason: collision with root package name */
        private HashMap<String, Long> f0tv = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ey() {
            return true;
        }

        public String T(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.f0tv.containsKey(str) && this.f0tv.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.f0tv.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j2 == -1 || j2 > longValue) {
                            key = entry.getKey();
                            j = longValue;
                        } else {
                            j = j2;
                            key = str2;
                        }
                        str2 = key;
                        j2 = j;
                    }
                    if (str2 != null) {
                        this.f0tv.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String T = T(gVar.tw);
            synchronized (this) {
                this.f0tv.put(gVar.tw, Long.valueOf(gVar.tz));
            }
            return T;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eB() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.tA < System.currentTimeMillis() ? gVar.tw : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eC() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.f0tv.clear();
            }
        }
    }
}
