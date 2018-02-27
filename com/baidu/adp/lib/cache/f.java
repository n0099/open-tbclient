package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e p(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e mh() {
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
        public boolean mc() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private LinkedList<g<?>> aha;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void md() {
            this.aha = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.ahg < System.currentTimeMillis()) {
                return gVar.ahc;
            }
            this.aha.add(gVar);
            if (this.aha.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.aha.size()) {
                    g<?> gVar2 = this.aha.get(i2);
                    if (i3 == -1 || gVar2.ahf < j) {
                        String str3 = gVar2.ahc;
                        j = gVar2.ahf;
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
                this.aha.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void me() {
            this.aha.clear();
            this.aha = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mc() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> ahb = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mc() {
            return true;
        }

        public String ab(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.ahb.containsKey(str) && this.ahb.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.ahb.entrySet()) {
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
                        this.ahb.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String ab = ab(gVar.ahc);
            synchronized (this) {
                this.ahb.put(gVar.ahc, Long.valueOf(gVar.ahf));
            }
            return ab;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mf() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.ahg < System.currentTimeMillis() ? gVar.ahc : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mg() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.ahb.clear();
            }
        }
    }
}
