package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e m(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e mg() {
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
        public boolean mb() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private LinkedList<g<?>> ahf;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void mc() {
            this.ahf = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.ahl < System.currentTimeMillis()) {
                return gVar.ahh;
            }
            this.ahf.add(gVar);
            if (this.ahf.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.ahf.size()) {
                    g<?> gVar2 = this.ahf.get(i2);
                    if (i3 == -1 || gVar2.ahk < j) {
                        String str3 = gVar2.ahh;
                        j = gVar2.ahk;
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
                this.ahf.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void md() {
            this.ahf.clear();
            this.ahf = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mb() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> ahg = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mb() {
            return true;
        }

        public String ab(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.ahg.containsKey(str) && this.ahg.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.ahg.entrySet()) {
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
                        this.ahg.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String ab = ab(gVar.ahh);
            synchronized (this) {
                this.ahg.put(gVar.ahh, Long.valueOf(gVar.ahk));
            }
            return ab;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void me() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.ahl < System.currentTimeMillis() ? gVar.ahh : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mf() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.ahg.clear();
            }
        }
    }
}
