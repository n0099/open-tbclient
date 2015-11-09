package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    public static f a(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static f gj() {
        return new c();
    }

    /* loaded from: classes.dex */
    static class c implements f {
        c() {
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gd() {
            return 1;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean ge() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private final int maxSize;
        private LinkedList<h<?>> sX;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gd() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gf() {
            this.sX = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.te < System.currentTimeMillis()) {
                return hVar.sZ;
            }
            this.sX.add(hVar);
            if (this.sX.size() > gd()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.sX.size()) {
                    h<?> hVar2 = this.sX.get(i2);
                    if (i3 == -1 || hVar2.td < j2) {
                        String str3 = hVar2.sZ;
                        long j3 = hVar2.td;
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
                this.sX.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gg() {
            this.sX.clear();
            this.sX = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean ge() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> sY = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gd() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean ge() {
            return true;
        }

        public String X(String str) {
            String str2;
            if (!this.sY.containsKey(str) && this.sY.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.sY.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.sY.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String X = X(hVar.sZ);
            synchronized (this) {
                this.sY.put(hVar.sZ, Long.valueOf(hVar.td));
            }
            return X;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gh() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.te < System.currentTimeMillis() ? hVar.sZ : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gi() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.sY.clear();
            }
        }
    }
}
