package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MemoryBitmapCache implements bn {
    private int a;
    private IEvictPolicy b;
    private Map c;

    /* loaded from: classes.dex */
    public interface IEvictPolicy {
        public static final int LRU = 0;
        public static final int OLDEST = 1;

        String findItemToDelete(Map map);

        void updateCacheItem(a aVar);
    }

    /* loaded from: classes.dex */
    public class LRUPolicy implements IEvictPolicy {
        private long a;

        public LRUPolicy(long j) {
            this.a = 1000 * j;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public String findItemToDelete(Map map) {
            a aVar;
            String str;
            boolean z;
            String str2 = null;
            boolean z2 = true;
            a aVar2 = null;
            for (String str3 : map.keySet()) {
                a aVar3 = (a) map.get(str3);
                if (System.currentTimeMillis() - aVar3.c < this.a) {
                    if (z2 && (aVar2 == null || aVar3.b < aVar2.b)) {
                        boolean z3 = z2;
                        aVar = aVar3;
                        str = str3;
                        z = z3;
                    }
                    z = z2;
                    str = str2;
                    aVar = aVar2;
                } else {
                    if (aVar2 == null || aVar3.c < aVar2.c) {
                        aVar = aVar3;
                        str = str3;
                        z = false;
                    }
                    z = z2;
                    str = str2;
                    aVar = aVar2;
                }
                str2 = str;
                aVar2 = aVar;
                z2 = z;
            }
            return str2;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public void updateCacheItem(a aVar) {
            if (aVar.c + this.a < System.currentTimeMillis()) {
                aVar.b = 1;
            } else {
                aVar.b++;
            }
            aVar.c = System.currentTimeMillis();
        }
    }

    /* loaded from: classes.dex */
    public class OldestPolicy implements IEvictPolicy {
        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public String findItemToDelete(Map map) {
            String str = null;
            a aVar = null;
            for (String str2 : map.keySet()) {
                a aVar2 = (a) map.get(str2);
                if (aVar != null && aVar2.c >= aVar.c) {
                    str2 = str;
                    aVar2 = aVar;
                }
                str = str2;
                aVar = aVar2;
            }
            return str;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache.IEvictPolicy
        public void updateCacheItem(a aVar) {
            aVar.b++;
            aVar.c = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public Bitmap a;
        public int b;
        public long c;

        a() {
        }
    }

    public MemoryBitmapCache(int i) {
        this(i, null);
    }

    public MemoryBitmapCache(int i, IEvictPolicy iEvictPolicy) {
        this.c = new HashMap();
        this.a = i;
        this.b = iEvictPolicy;
        if (this.b == null) {
            this.b = new OldestPolicy();
        }
    }

    public synchronized Bitmap a(String str) {
        Bitmap bitmap;
        a aVar = (a) this.c.get(str);
        if (aVar != null) {
            this.b.updateCacheItem(aVar);
            bitmap = aVar.a;
        } else {
            bitmap = null;
        }
        return bitmap;
    }

    public MemoryBitmapCache a(int i) {
        this.a = i;
        return this;
    }

    public MemoryBitmapCache a(IEvictPolicy iEvictPolicy) {
        this.b = iEvictPolicy;
        return this;
    }

    @Override // defpackage.bn
    public synchronized void a(String str, Bitmap bitmap) {
        if (!c(str)) {
            if (this.c.size() >= this.a) {
                b(this.b.findItemToDelete(this.c));
            }
            a aVar = new a();
            aVar.b = 1;
            aVar.c = System.currentTimeMillis();
            aVar.a = bitmap;
            this.c.put(str, aVar);
        }
    }

    public synchronized void b(String str) {
        a aVar = (a) this.c.remove(str);
        if (aVar != null && aVar.a != null) {
            aVar.a.recycle();
        }
    }

    public synchronized boolean c(String str) {
        return this.c.get(str) != null;
    }
}
