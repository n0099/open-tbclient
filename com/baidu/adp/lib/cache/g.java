package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public static f c(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static f dz() {
        return new c();
    }

    /* loaded from: classes.dex */
    static class c implements f {
        c() {
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return 1;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean du() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private LinkedList<h<?>> ma;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void dv() {
            this.ma = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.mh < System.currentTimeMillis()) {
                return hVar.mc;
            }
            this.ma.add(hVar);
            if (this.ma.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.ma.size()) {
                    h<?> hVar2 = this.ma.get(i2);
                    if (i3 == -1 || hVar2.mg < j2) {
                        String str3 = hVar2.mc;
                        long j3 = hVar2.mg;
                        str = str3;
                        j = j3;
                        i = i2;
                    } else {
                        str = str2;
                        j = j2;
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                    j2 = j;
                    str2 = str;
                }
                this.ma.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void dw() {
            this.ma.clear();
            this.ma = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean du() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> mb = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean du() {
            return true;
        }

        public String Q(String str) {
            String str2;
            if (!this.mb.containsKey(str) && this.mb.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.mb.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.mb.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String Q = Q(hVar.mc);
            synchronized (this) {
                this.mb.put(hVar.mc, Long.valueOf(hVar.mg));
            }
            return Q;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void dx() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.mh < System.currentTimeMillis() ? hVar.mc : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void dy() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.mb.clear();
            }
        }
    }
}
