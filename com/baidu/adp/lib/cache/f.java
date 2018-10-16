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

    public static e ix() {
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
        public boolean is() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private LinkedList<g<?>> AC;
        private final int maxSize;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void it() {
            this.AC = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.AI < System.currentTimeMillis()) {
                return gVar.AE;
            }
            this.AC.add(gVar);
            if (this.AC.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.AC.size()) {
                    g<?> gVar2 = this.AC.get(i2);
                    if (i3 == -1 || gVar2.AH < j) {
                        String str3 = gVar2.AE;
                        j = gVar2.AH;
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
                this.AC.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void iu() {
            this.AC.clear();
            this.AC = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean is() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> AD = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean is() {
            return true;
        }

        public String aC(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.AD.containsKey(str) && this.AD.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.AD.entrySet()) {
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
                        this.AD.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String aC = aC(gVar.AE);
            synchronized (this) {
                this.AD.put(gVar.AE, Long.valueOf(gVar.AH));
            }
            return aC;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void iv() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.AI < System.currentTimeMillis() ? gVar.AE : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void iw() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.AD.clear();
            }
        }
    }
}
