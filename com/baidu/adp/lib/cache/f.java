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
        private LinkedList<g<?>> ahg;
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
            this.ahg = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.ahm < System.currentTimeMillis()) {
                return gVar.ahi;
            }
            this.ahg.add(gVar);
            if (this.ahg.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.ahg.size()) {
                    g<?> gVar2 = this.ahg.get(i2);
                    if (i3 == -1 || gVar2.ahl < j) {
                        String str3 = gVar2.ahi;
                        j = gVar2.ahl;
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
                this.ahg.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void me() {
            this.ahg.clear();
            this.ahg = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mc() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> ahh = new HashMap<>();
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
            if (!this.ahh.containsKey(str) && this.ahh.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.ahh.entrySet()) {
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
                        this.ahh.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String ab = ab(gVar.ahi);
            synchronized (this) {
                this.ahh.put(gVar.ahi, Long.valueOf(gVar.ahl));
            }
            return ab;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mf() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.ahm < System.currentTimeMillis() ? gVar.ahi : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mg() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.ahh.clear();
            }
        }
    }
}
