package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.b.a.k.b;
import d.b.b.e.d.a;
import d.b.b.e.d.c;
import d.b.b.e.d.e;
import d.b.b.e.d.f;
import d.b.b.e.d.h;
import d.b.b.e.d.i;
import d.b.b.e.d.j;
import d.b.b.e.d.k;
import d.b.b.e.d.l;
import d.b.b.e.d.m;
import d.b.b.e.d.n;
import d.b.b.e.d.p;
import d.b.b.e.d.q;
import d.b.b.e.d.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {

    /* renamed from: h  reason: collision with root package name */
    public static volatile BdCacheService f2150h;

    /* renamed from: a  reason: collision with root package name */
    public p f2151a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2152b;

    /* renamed from: c  reason: collision with root package name */
    public b f2153c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2154d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, l<String>> f2155e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, l<byte[]>> f2156f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2157g;

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
        this.f2155e = new HashMap<>();
        this.f2156f = new HashMap<>();
        this.f2154d = str;
        if (BdBaseApplication.getInst() != null) {
            this.f2157g = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static BdCacheService j(String str) {
        return new BdCacheService(str);
    }

    public static BdCacheService l() {
        if (f2150h == null) {
            synchronized (BdCacheService.class) {
                if (f2150h == null) {
                    f2150h = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return f2150h;
    }

    public synchronized l<byte[]> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        e b2;
        c<?> aVar;
        l<byte[]> lVar = this.f2156f.get(str);
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
            aVar = new d.b.b.e.d.b(f());
            z = false;
        } else {
            aVar = new a(f(), "cache_kv_bshare");
        }
        aVar.r(b2, h(aVar, str, "blob", i));
        return b(str, new j(aVar, b2, z));
    }

    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        m nVar;
        l<byte[]> lVar = this.f2156f.get(str);
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
        this.f2156f.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public synchronized l<String> c(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        e b2;
        c<?> qVar;
        l<String> lVar = this.f2155e.get(str);
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
        l<String> lVar = this.f2155e.get(str);
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
        this.f2155e.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public Context e() {
        Context context = this.f2152b;
        return context == null ? BdBaseApplication.getInst().getApp() : context;
    }

    public b f() {
        if (this.f2153c == null) {
            this.f2153c = new b(new i(e(), this.f2154d));
        }
        return this.f2153c;
    }

    public p g() {
        if (this.f2151a == null) {
            this.f2151a = new p(e(), f());
        }
        return this.f2151a;
    }

    public synchronized String h(c<?> cVar, String str, String str2, int i) {
        h c2;
        int g2 = cVar.g();
        p g3 = g();
        c2 = g3.c(str);
        if (c2 == null) {
            c2 = new h();
            c2.f41689a = str;
            c2.f41693e = g2;
            c2.f41692d = str2;
            c2.f41691c = i;
            c2.f41694f = System.currentTimeMillis();
            c2.f41690b = cVar.l(str);
            g3.a(c2);
        } else if (str2.equalsIgnoreCase(c2.f41692d)) {
            c2.f41691c = i;
            c2.f41694f = System.currentTimeMillis();
            if (g2 != c2.f41693e) {
                cVar.k(str, c2.f41690b, g2, c2.f41693e);
            }
            g3.a(c2);
        } else {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + c2.f41692d);
        }
        return c2.f41690b;
    }

    public boolean i() {
        return this.f2157g;
    }

    public void k(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String j = cVar.j();
                cVar.b();
                this.f2155e.remove(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.f2154d)) {
            this.f2155e.clear();
            this.f2156f.clear();
        }
    }
}
