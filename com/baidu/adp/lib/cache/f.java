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

    public static e hc() {
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
        public boolean gX() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> xH;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void gY() {
            this.xH = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.xN < System.currentTimeMillis()) {
                return gVar.xJ;
            }
            this.xH.add(gVar);
            if (this.xH.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.xH.size()) {
                    g<?> gVar2 = this.xH.get(i2);
                    if (i3 == -1 || gVar2.xM < j) {
                        String str3 = gVar2.xJ;
                        j = gVar2.xM;
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
                this.xH.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void gZ() {
            this.xH.clear();
            this.xH = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean gX() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> xI = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean gX() {
            return true;
        }

        public String ak(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.xI.containsKey(str) && this.xI.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.xI.entrySet()) {
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
                        this.xI.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String ak = ak(gVar.xJ);
            synchronized (this) {
                this.xI.put(gVar.xJ, Long.valueOf(gVar.xM));
            }
            return ak;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void ha() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.xN < System.currentTimeMillis() ? gVar.xJ : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void hb() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.xI.clear();
            }
        }
    }
}
