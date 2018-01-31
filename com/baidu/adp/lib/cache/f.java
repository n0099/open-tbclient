package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e m(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e mh() {
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
        public boolean mc() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private LinkedList<g<?>> ahi;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void md() {
            this.ahi = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.aho < System.currentTimeMillis()) {
                return gVar.ahk;
            }
            this.ahi.add(gVar);
            if (this.ahi.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.ahi.size()) {
                    g<?> gVar2 = this.ahi.get(i2);
                    if (i3 == -1 || gVar2.ahn < j) {
                        String str3 = gVar2.ahk;
                        j = gVar2.ahn;
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
                this.ahi.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void me() {
            this.ahi.clear();
            this.ahi = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mc() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> ahj = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean mc() {
            return true;
        }

        public String ab(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.ahj.containsKey(str) && this.ahj.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.ahj.entrySet()) {
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
                        this.ahj.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String ab = ab(gVar.ahk);
            synchronized (this) {
                this.ahj.put(gVar.ahk, Long.valueOf(gVar.ahn));
            }
            return ab;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mf() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.aho < System.currentTimeMillis() ? gVar.ahk : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void mg() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.ahj.clear();
            }
        }
    }
}
