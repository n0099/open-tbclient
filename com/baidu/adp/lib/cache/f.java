package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    public static e j(int i, boolean z) {
        return z ? new b(i) : new a(i);
    }

    public static e lS() {
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
        public boolean shouldUpdateLastHitTime() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e.a {
        private final int maxSize;
        private LinkedList<g<?>> tempItems;

        public a(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void startEvict() {
            this.tempItems = new LinkedList<>();
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public String d(g<?> gVar) {
            String str;
            int i;
            String str2 = null;
            if (gVar.timeToExpire < System.currentTimeMillis()) {
                return gVar.uniqueKey;
            }
            this.tempItems.add(gVar);
            if (this.tempItems.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tempItems.size()) {
                    g<?> gVar2 = this.tempItems.get(i2);
                    if (i3 == -1 || gVar2.lastHitTime < j) {
                        String str3 = gVar2.uniqueKey;
                        j = gVar2.lastHitTime;
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
                this.tempItems.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.cache.e.a
        public void finishEvict() {
            this.tempItems.clear();
            this.tempItems = null;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean shouldUpdateLastHitTime() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class b implements e.b {
        private HashMap<String, Long> items = new HashMap<>();
        private final int maxSize;

        public b(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.adp.lib.cache.e
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.adp.lib.cache.e
        public boolean shouldUpdateLastHitTime() {
            return true;
        }

        public String keyToEvictedOnNewItemJoined(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.items.containsKey(str) && this.items.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.items.entrySet()) {
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
                        this.items.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String e(g<?> gVar) {
            String keyToEvictedOnNewItemJoined = keyToEvictedOnNewItemJoined(gVar.uniqueKey);
            synchronized (this) {
                this.items.put(gVar.uniqueKey, Long.valueOf(gVar.lastHitTime));
            }
            return keyToEvictedOnNewItemJoined;
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void startInit() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public String f(g<?> gVar) {
            return gVar.timeToExpire < System.currentTimeMillis() ? gVar.uniqueKey : e(gVar);
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void finishInit() {
        }

        @Override // com.baidu.adp.lib.cache.e.b
        public void release() {
            synchronized (this) {
                this.items.clear();
            }
        }
    }
}
