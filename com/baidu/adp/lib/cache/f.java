package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e e(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e hb() {
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
        public boolean gW() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> xz;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void gX() {
            this.xz = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.xF < System.currentTimeMillis()) {
                return gVar.xB;
            }
            this.xz.add(gVar);
            if (this.xz.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.xz.size()) {
                    g<?> gVar2 = this.xz.get(i2);
                    if (i3 == -1 || gVar2.xE < j) {
                        String str3 = gVar2.xB;
                        j = gVar2.xE;
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
                this.xz.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void gY() {
            this.xz.clear();
            this.xz = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean gW() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> xA = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean gW() {
            return true;
        }

        public String al(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.xA.containsKey(str) && this.xA.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.xA.entrySet()) {
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
                        this.xA.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String al = al(gVar.xB);
            synchronized (this) {
                this.xA.put(gVar.xB, Long.valueOf(gVar.xE));
            }
            return al;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void gZ() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.xF < System.currentTimeMillis() ? gVar.xB : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void ha() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.xA.clear();
            }
        }
    }
}
