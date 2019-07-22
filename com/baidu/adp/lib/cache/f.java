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

    public static e hy() {
        return new c();
    }

    /* loaded from: classes.dex */
    static class c implements e {
        c() {
        }

        @Override // com.baidu.adp.lib.cache.e
        public int hs() {
            return 1;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ht() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> yt;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int hs() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void hu() {
            this.yt = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.yz < System.currentTimeMillis()) {
                return gVar.yv;
            }
            this.yt.add(gVar);
            if (this.yt.size() > hs()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.yt.size()) {
                    g<?> gVar2 = this.yt.get(i2);
                    if (i3 == -1 || gVar2.yy < j) {
                        String str3 = gVar2.yv;
                        j = gVar2.yy;
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
                this.yt.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void hv() {
            this.yt.clear();
            this.yt = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ht() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> yu = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int hs() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean ht() {
            return true;
        }

        public String am(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.yu.containsKey(str) && this.yu.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.yu.entrySet()) {
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
                        this.yu.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String am = am(gVar.yv);
            synchronized (this) {
                this.yu.put(gVar.yv, Long.valueOf(gVar.yy));
            }
            return am;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void hw() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.yz < System.currentTimeMillis() ? gVar.yv : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void hx() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.yu.clear();
            }
        }
    }
}
