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
        private LinkedList<g<?>> sM;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void ez() {
            this.sM = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.sS < System.currentTimeMillis()) {
                return gVar.sO;
            }
            this.sM.add(gVar);
            if (this.sM.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.sM.size()) {
                    g<?> gVar2 = this.sM.get(i2);
                    if (i3 == -1 || gVar2.sR < j) {
                        String str3 = gVar2.sO;
                        j = gVar2.sR;
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
                this.sM.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void eA() {
            this.sM.clear();
            this.sM = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ey() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> sN = new HashMap<>();

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
            if (!this.sN.containsKey(str) && this.sN.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.sN.entrySet()) {
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
                        this.sN.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String T = T(gVar.sO);
            synchronized (this) {
                this.sN.put(gVar.sO, Long.valueOf(gVar.sR));
            }
            return T;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eB() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.sS < System.currentTimeMillis() ? gVar.sO : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void eC() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.sN.clear();
            }
        }
    }
}
