package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    protected final k<T> MA;
    protected final String nameSpace;
    private boolean strictMode = false;

    public m(String str, k<T> kVar) {
        this.nameSpace = str;
        this.MA = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.MA.get(this.nameSpace, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.b<T> bC(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.MA.r(this.nameSpace, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void set(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= BdKVCache.MILLS_10Years ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.MA.set(this.nameSpace, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void setForever(String str, T t) {
        set(str, t, BdKVCache.MILLS_10Years);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.strictMode) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.MA.remove(this.nameSpace, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.adp.lib.cache.l$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                aVar.onItemGet(str, m.this.get(str));
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void asyncSet(final String str, final T t, final long j) {
        com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.adp.lib.cache.m */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                m.this.set(str, t, j);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void asyncSetForever(String str, T t) {
        asyncSet(str, t, BdKVCache.MILLS_10Years);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void asyncRemove(final String str) {
        com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public String getNameSpace() {
        return this.nameSpace;
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public k<T> ly() {
        return this.MA;
    }

    public void onCacheCreated() {
        this.MA.startup(this.nameSpace);
    }

    protected void releaseCacheData() {
        e lt = ly().lt();
        if (lt instanceof e.b) {
            ((e.b) lt).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public void clearAndClose() {
        this.MA.clearAndClose(this.nameSpace);
        releaseCacheData();
    }
}
