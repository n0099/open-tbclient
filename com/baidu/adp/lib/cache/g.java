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

    public static f gm() {
        return new c();
    }

    /* loaded from: classes.dex */
    static class c implements f {
        c() {
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gg() {
            return 1;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gh() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements f.a {
        private final int maxSize;
        private LinkedList<h<?>> sZ;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gg() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gi() {
            this.sZ = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public String d(h<?> hVar) {
            String str;
            long j;
            int i;
            String str2 = null;
            if (hVar.tg < System.currentTimeMillis()) {
                return hVar.tc;
            }
            this.sZ.add(hVar);
            if (this.sZ.size() > gg()) {
                long j2 = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.sZ.size()) {
                    h<?> hVar2 = this.sZ.get(i2);
                    if (i3 == -1 || hVar2.tf < j2) {
                        String str3 = hVar2.tc;
                        long j3 = hVar2.tf;
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
                this.sZ.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.a
        public void gj() {
            this.sZ.clear();
            this.sZ = null;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gh() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements f.b {
        private final int maxSize;
        private HashMap<String, Long> tb = new HashMap<>();

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.f
        public int gg() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.f
        public boolean gh() {
            return true;
        }

        public String Z(String str) {
            String str2;
            if (!this.tb.containsKey(str) && this.tb.size() >= this.maxSize) {
                synchronized (this) {
                    long j = -1;
                    str2 = null;
                    for (Map.Entry<String, Long> entry : this.tb.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            j = longValue;
                            str2 = entry.getKey();
                        }
                    }
                    if (str2 != null) {
                        this.tb.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String e(h<?> hVar) {
            String Z = Z(hVar.tc);
            synchronized (this) {
                this.tb.put(hVar.tc, Long.valueOf(hVar.tf));
            }
            return Z;
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gk() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public String f(h<?> hVar) {
            return hVar.tg < System.currentTimeMillis() ? hVar.tc : e(hVar);
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void gl() {
        }

        @Override // com.baidu.adp.lib.cache.f.b
        public void release() {
            synchronized (this) {
                this.tb.clear();
            }
        }
    }
}
