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

    public static f gi() {
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
        public boolean gd() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private final int maxSize;
        private LinkedList<h<?>> tb;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void ge() {
            this.tb = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.th < System.currentTimeMillis()) {
                return hVar.td;
            }
            this.tb.add(hVar);
            if (this.tb.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tb.size()) {
                    h<?> hVar2 = this.tb.get(i2);
                    if (i3 == -1 || hVar2.tg < j2) {
                        String str3 = hVar2.td;
                        long j3 = hVar2.tg;
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
                this.tb.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gf() {
            this.tb.clear();
            this.tb = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gd() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> tc = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gd() {
            return true;
        }

        public String X(String str) {
            String str2;
            if (!this.tc.containsKey(str) && this.tc.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.tc.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.tc.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String X = X(hVar.td);
            synchronized (this) {
                this.tc.put(hVar.td, Long.valueOf(hVar.tg));
            }
            return X;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gg() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.th < System.currentTimeMillis() ? hVar.td : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gh() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.tc.clear();
            }
        }
    }
}
