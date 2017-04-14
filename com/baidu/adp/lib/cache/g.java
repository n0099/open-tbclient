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

    public static f eF() {
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
        public boolean eA() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private final int maxSize;
        private LinkedList<h<?>> tm;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void eB() {
            this.tm = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.tu < System.currentTimeMillis()) {
                return hVar.tq;
            }
            this.tm.add(hVar);
            if (this.tm.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tm.size()) {
                    h<?> hVar2 = this.tm.get(i2);
                    if (i3 == -1 || hVar2.tt < j2) {
                        String str3 = hVar2.tq;
                        long j3 = hVar2.tt;
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
                this.tm.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void eC() {
            this.tm.clear();
            this.tm = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean eA() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> tp = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean eA() {
            return true;
        }

        public String M(String str) {
            String str2;
            if (!this.tp.containsKey(str) && this.tp.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.tp.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.tp.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String M = M(hVar.tq);
            synchronized (this) {
                this.tp.put(hVar.tq, Long.valueOf(hVar.tt));
            }
            return M;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void eD() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.tu < System.currentTimeMillis() ? hVar.tq : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void eE() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.tp.clear();
            }
        }
    }
}
