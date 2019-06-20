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

    public static e ho() {
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
        public boolean hj() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> yn;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void hk() {
            this.yn = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.yt < System.currentTimeMillis()) {
                return gVar.yp;
            }
            this.yn.add(gVar);
            if (this.yn.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.yn.size()) {
                    g<?> gVar2 = this.yn.get(i2);
                    if (i3 == -1 || gVar2.ys < j) {
                        String str3 = gVar2.yp;
                        j = gVar2.ys;
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
                this.yn.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void hl() {
            this.yn.clear();
            this.yn = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean hj() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private final int maxSize;
        private HashMap<String, Long> yo = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean hj() {
            return true;
        }

        public String al(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.yo.containsKey(str) && this.yo.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.yo.entrySet()) {
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
                        this.yo.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String al = al(gVar.yp);
            synchronized (this) {
                this.yo.put(gVar.yp, Long.valueOf(gVar.ys));
            }
            return al;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void hm() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.yt < System.currentTimeMillis() ? gVar.yp : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void hn() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.yo.clear();
            }
        }
    }
}
