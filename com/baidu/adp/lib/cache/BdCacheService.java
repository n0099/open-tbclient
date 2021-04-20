package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.c.a.k.b;
import d.b.c.e.d.a;
import d.b.c.e.d.c;
import d.b.c.e.d.e;
import d.b.c.e.d.f;
import d.b.c.e.d.h;
import d.b.c.e.d.i;
import d.b.c.e.d.j;
import d.b.c.e.d.k;
import d.b.c.e.d.l;
import d.b.c.e.d.m;
import d.b.c.e.d.n;
import d.b.c.e.d.p;
import d.b.c.e.d.q;
import d.b.c.e.d.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {

    /* renamed from: h  reason: collision with root package name */
    public static volatile BdCacheService f2186h;

    /* renamed from: a  reason: collision with root package name */
    public p f2187a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2188b;

    /* renamed from: c  reason: collision with root package name */
    public b f2189c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2190d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, l<String>> f2191e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, l<byte[]>> f2192f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2193g;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT
    }

    /* loaded from: classes.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE
    }

    public BdCacheService(String str) {
        super(2000998);
        this.f2191e = new HashMap<>();
        this.f2192f = new HashMap<>();
        this.f2190d = str;
        if (BdBaseApplication.getInst() != null) {
            this.f2193g = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static BdCacheService j(String str) {
        return new BdCacheService(str);
    }

    public static BdCacheService l() {
        if (f2186h == null) {
            synchronized (BdCacheService.class) {
                if (f2186h == null) {
                    f2186h = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return f2186h;
    }

    public synchronized l<byte[]> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        e b2;
        c<?> aVar;
        l<byte[]> lVar = this.f2192f.get(str);
        if (lVar != null) {
            return lVar;
        }
        boolean z = true;
        if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
            b2 = f.a(i, false);
        } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
            b2 = f.a(i, true);
        } else {
            b2 = f.b();
        }
        if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
            aVar = new d.b.c.e.d.b(f());
            z = false;
        } else {
            aVar = new a(f(), "cache_kv_bshare");
        }
        aVar.r(b2, h(aVar, str, "blob", i));
        return b(str, new j(aVar, b2, z));
    }

    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        m nVar;
        l<byte[]> lVar = this.f2192f.get(str);
        if (lVar != null) {
            if (kVar != null && (lVar instanceof l.c) && ((l.c) lVar).c() != kVar) {
                throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
            }
            return lVar;
        }
        if (i()) {
            nVar = new m(str, kVar);
        } else {
            nVar = new n(str, kVar);
        }
        this.f2192f.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public synchronized l<String> c(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        e b2;
        c<?> qVar;
        l<String> lVar = this.f2191e.get(str);
        if (lVar != null) {
            return lVar;
        }
        boolean z = true;
        if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
            b2 = f.a(i, false);
        } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
            b2 = f.a(i, true);
        } else {
            b2 = f.b();
        }
        if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
            qVar = new r(f());
            z = false;
        } else {
            qVar = new q(f(), "cache_kv_tshare");
        }
        qVar.r(b2, h(qVar, str, "text", i));
        return d(str, new j(qVar, b2, z));
    }

    public synchronized l<String> d(String str, k<String> kVar) {
        m nVar;
        l<String> lVar = this.f2191e.get(str);
        if (lVar != null) {
            if (kVar != null && (lVar instanceof l.c) && ((l.c) lVar).c() != kVar) {
                throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
            }
            return lVar;
        }
        if (i()) {
            nVar = new m(str, kVar);
        } else {
            nVar = new n(str, kVar);
        }
        this.f2191e.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public Context e() {
        Context context = this.f2188b;
        return context == null ? BdBaseApplication.getInst().getApp() : context;
    }

    public b f() {
        if (this.f2189c == null) {
            this.f2189c = new b(new i(e(), this.f2190d));
        }
        return this.f2189c;
    }

    public p g() {
        if (this.f2187a == null) {
            this.f2187a = new p(e(), f());
        }
        return this.f2187a;
    }

    public synchronized String h(c<?> cVar, String str, String str2, int i) {
        h c2;
        int g2 = cVar.g();
        p g3 = g();
        c2 = g3.c(str);
        if (c2 == null) {
            c2 = new h();
            c2.f42187a = str;
            c2.f42191e = g2;
            c2.f42190d = str2;
            c2.f42189c = i;
            c2.f42192f = System.currentTimeMillis();
            c2.f42188b = cVar.l(str);
            g3.a(c2);
        } else if (str2.equalsIgnoreCase(c2.f42190d)) {
            c2.f42189c = i;
            c2.f42192f = System.currentTimeMillis();
            if (g2 != c2.f42191e) {
                cVar.k(str, c2.f42188b, g2, c2.f42191e);
            }
            g3.a(c2);
        } else {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + c2.f42190d);
        }
        return c2.f42188b;
    }

    public boolean i() {
        return this.f2193g;
    }

    public void k(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String j = cVar.j();
                cVar.b();
                this.f2191e.remove(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.f2190d)) {
            this.f2191e.clear();
            this.f2192f.clear();
        }
    }
}
