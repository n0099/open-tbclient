package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e b(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e eC() {
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
        public boolean ex() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> sN;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void ey() {
            this.sN = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.sT < System.currentTimeMillis()) {
                return gVar.sP;
            }
            this.sN.add(gVar);
            if (this.sN.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.sN.size()) {
                    g<?> gVar2 = this.sN.get(i2);
                    if (i3 == -1 || gVar2.sS < j) {
                        String str3 = gVar2.sP;
                        j = gVar2.sS;
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
                this.sN.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void ez() {
            this.sN.clear();
            this.sN = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ex() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> sO = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ex() {
            return true;
        }

        public String T(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.sO.containsKey(str) && this.sO.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.sO.entrySet()) {
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
                        this.sO.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String T = T(gVar.sP);
            synchronized (this) {
                this.sO.put(gVar.sP, Long.valueOf(gVar.sS));
            }
            return T;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eA() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.sT < System.currentTimeMillis() ? gVar.sP : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eB() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.sO.clear();
            }
        }
    }
}
