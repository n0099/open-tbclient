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

    public static f cE() {
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
        public boolean cz() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private LinkedList<h<?>> jJ;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void cA() {
            this.jJ = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.jP < System.currentTimeMillis()) {
                return hVar.jL;
            }
            this.jJ.add(hVar);
            if (this.jJ.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.jJ.size()) {
                    h<?> hVar2 = this.jJ.get(i2);
                    if (i3 == -1 || hVar2.jO < j2) {
                        String str3 = hVar2.jL;
                        long j3 = hVar2.jO;
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
                this.jJ.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void cB() {
            this.jJ.clear();
            this.jJ = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean cz() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private HashMap<String, Long> jK = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean cz() {
            return true;
        }

        public String P(String str) {
            String str2;
            if (!this.jK.containsKey(str) && this.jK.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.jK.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.jK.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String P = P(hVar.jL);
            synchronized (this) {
                this.jK.put(hVar.jL, Long.valueOf(hVar.jO));
            }
            return P;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void cC() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.jP < System.currentTimeMillis() ? hVar.jL : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void cD() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.jK.clear();
            }
        }
    }
}
