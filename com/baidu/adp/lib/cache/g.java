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

    public static f dx() {
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
        public boolean ds() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private LinkedList<h<?>> lV;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void dt() {
            this.lV = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.mb < System.currentTimeMillis()) {
                return hVar.lX;
            }
            this.lV.add(hVar);
            if (this.lV.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.lV.size()) {
                    h<?> hVar2 = this.lV.get(i2);
                    if (i3 == -1 || hVar2.ma < j2) {
                        String str3 = hVar2.lX;
                        long j3 = hVar2.ma;
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
                this.lV.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void du() {
            this.lV.clear();
            this.lV = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean ds() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private HashMap<String, Long> lW = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean ds() {
            return true;
        }

        public String Q(String str) {
            String str2;
            if (!this.lW.containsKey(str) && this.lW.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.lW.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.lW.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String Q = Q(hVar.lX);
            synchronized (this) {
                this.lW.put(hVar.lX, Long.valueOf(hVar.ma));
            }
            return Q;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void dv() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.mb < System.currentTimeMillis() ? hVar.lX : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void dw() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.lW.clear();
            }
        }
    }
}
