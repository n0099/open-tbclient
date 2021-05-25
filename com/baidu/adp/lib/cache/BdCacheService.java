package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.c.a.k.b;
import d.a.c.e.d.a;
import d.a.c.e.d.c;
import d.a.c.e.d.e;
import d.a.c.e.d.f;
import d.a.c.e.d.h;
import d.a.c.e.d.i;
import d.a.c.e.d.j;
import d.a.c.e.d.k;
import d.a.c.e.d.l;
import d.a.c.e.d.m;
import d.a.c.e.d.n;
import d.a.c.e.d.p;
import d.a.c.e.d.q;
import d.a.c.e.d.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {

    /* renamed from: h  reason: collision with root package name */
    public static volatile BdCacheService f2155h;

    /* renamed from: a  reason: collision with root package name */
    public p f2156a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2157b;

    /* renamed from: c  reason: collision with root package name */
    public b f2158c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2159d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, l<String>> f2160e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, l<byte[]>> f2161f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2162g;

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
        this.f2160e = new HashMap<>();
        this.f2161f = new HashMap<>();
        this.f2159d = str;
        if (BdBaseApplication.getInst() != null) {
            this.f2162g = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static BdCacheService j(String str) {
        return new BdCacheService(str);
    }

    public static BdCacheService l() {
        if (f2155h == null) {
            synchronized (BdCacheService.class) {
                if (f2155h == null) {
                    f2155h = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return f2155h;
    }

    public synchronized l<byte[]> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i2) {
        e b2;
        c<?> aVar;
        l<byte[]> lVar = this.f2161f.get(str);
        if (lVar != null) {
            return lVar;
        }
        boolean z = true;
        if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
            b2 = f.a(i2, false);
        } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
            b2 = f.a(i2, true);
        } else {
            b2 = f.b();
        }
        if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
            aVar = new d.a.c.e.d.b(f());
            z = false;
        } else {
            aVar = new a(f(), "cache_kv_bshare");
        }
        aVar.r(b2, h(aVar, str, "blob", i2));
        return b(str, new j(aVar, b2, z));
    }

    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        m nVar;
        l<byte[]> lVar = this.f2161f.get(str);
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
        this.f2161f.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public synchronized l<String> c(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i2) {
        e b2;
        c<?> qVar;
        l<String> lVar = this.f2160e.get(str);
        if (lVar != null) {
            return lVar;
        }
        boolean z = true;
        if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
            b2 = f.a(i2, false);
        } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
            b2 = f.a(i2, true);
        } else {
            b2 = f.b();
        }
        if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
            qVar = new r(f());
            z = false;
        } else {
            qVar = new q(f(), "cache_kv_tshare");
        }
        qVar.r(b2, h(qVar, str, "text", i2));
        return d(str, new j(qVar, b2, z));
    }

    public synchronized l<String> d(String str, k<String> kVar) {
        m nVar;
        l<String> lVar = this.f2160e.get(str);
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
        this.f2160e.put(str, nVar);
        nVar.k();
        return nVar;
    }

    public Context e() {
        Context context = this.f2157b;
        return context == null ? BdBaseApplication.getInst().getApp() : context;
    }

    public b f() {
        if (this.f2158c == null) {
            this.f2158c = new b(new i(e(), this.f2159d));
        }
        return this.f2158c;
    }

    public p g() {
        if (this.f2156a == null) {
            this.f2156a = new p(e(), f());
        }
        return this.f2156a;
    }

    public synchronized String h(c<?> cVar, String str, String str2, int i2) {
        h c2;
        int g2 = cVar.g();
        p g3 = g();
        c2 = g3.c(str);
        if (c2 == null) {
            c2 = new h();
            c2.f38530a = str;
            c2.f38534e = g2;
            c2.f38533d = str2;
            c2.f38532c = i2;
            c2.f38535f = System.currentTimeMillis();
            c2.f38531b = cVar.l(str);
            g3.a(c2);
        } else if (str2.equalsIgnoreCase(c2.f38533d)) {
            c2.f38532c = i2;
            c2.f38535f = System.currentTimeMillis();
            if (g2 != c2.f38534e) {
                cVar.k(str, c2.f38531b, g2, c2.f38534e);
            }
            g3.a(c2);
        } else {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + c2.f38533d);
        }
        return c2.f38531b;
    }

    public boolean i() {
        return this.f2162g;
    }

    public void k(l<?> lVar) {
        if (lVar instanceof l.c) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String j = cVar.j();
                cVar.b();
                this.f2160e.remove(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.f2159d)) {
            this.f2160e.clear();
            this.f2161f.clear();
        }
    }
}
