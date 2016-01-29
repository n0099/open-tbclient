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

    public static f gq() {
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
        public boolean gl() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private final int maxSize;
        private LinkedList<h<?>> tk;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gm() {
            this.tk = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.ts < System.currentTimeMillis()) {
                return hVar.tm;
            }
            this.tk.add(hVar);
            if (this.tk.size() > getMaxSize()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tk.size()) {
                    h<?> hVar2 = this.tk.get(i2);
                    if (i3 == -1 || hVar2.tr < j2) {
                        String str3 = hVar2.tm;
                        long j3 = hVar2.tr;
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
                this.tk.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gn() {
            this.tk.clear();
            this.tk = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gl() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> tl = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gl() {
            return true;
        }

        public String W(String str) {
            String str2;
            if (!this.tl.containsKey(str) && this.tl.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.tl.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.tl.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String W = W(hVar.tm);
            synchronized (this) {
                this.tl.put(hVar.tm, Long.valueOf(hVar.tr));
            }
            return W;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void go() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.ts < System.currentTimeMillis() ? hVar.tm : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gp() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.tl.clear();
            }
        }
    }
}
