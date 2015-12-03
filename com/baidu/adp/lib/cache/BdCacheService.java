package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.o;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static volatile BdCacheService tm;
    private Context context;
    private com.baidu.adp.base.a.b sO;
    private v tp;
    private final String tq;
    private HashMap<String, o<String>> tr;
    private HashMap<String, o<byte[]>> ts;
    private boolean tt;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tu) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheEvictPolicy[] valuesCustom() {
            CacheEvictPolicy[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheEvictPolicy[] cacheEvictPolicyArr = new CacheEvictPolicy[length];
            System.arraycopy(valuesCustom, 0, cacheEvictPolicyArr, 0, length);
            return cacheEvictPolicyArr;
        }
    }

    /* loaded from: classes.dex */
    public enum CacheStorage {
        SQLite_CACHE_PER_TABLE,
        SQLite_CACHE_All_IN_ONE_TABLE;

        /* JADX DEBUG: Replace access to removed values field (tv) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheStorage[] valuesCustom() {
            CacheStorage[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheStorage[] cacheStorageArr = new CacheStorage[length];
            System.arraycopy(valuesCustom, 0, cacheStorageArr, 0, length);
            return cacheStorageArr;
        }
    }

    public boolean isDebugMode() {
        return this.tt;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tr = new HashMap<>();
        this.ts = new HashMap<>();
        this.tq = str;
        if (BdBaseApplication.getInst() != null) {
            this.tt = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService gk() {
        if (tm == null) {
            synchronized (BdCacheService.class) {
                if (tm == null) {
                    tm = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tm;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i ac;
        int fX = cVar.fX();
        v gl = gl();
        ac = gl.ac(str);
        if (ac == null) {
            ac = new i();
            ac.tc = str;
            ac.th = fX;
            ac.tg = str2;
            ac.maxSize = i;
            ac.ti = System.currentTimeMillis();
            ac.sP = cVar.N(str);
            gl.a(ac);
        } else if (!str2.equalsIgnoreCase(ac.tg)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ac.tg);
        } else {
            ac.maxSize = i;
            ac.ti = System.currentTimeMillis();
            if (fX != ac.th) {
                cVar.a(str, ac.sP, fX, ac.th);
            }
            gl.a(ac);
        }
        return ac.sP;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f gi;
        x wVar;
        boolean z;
        oVar = this.tr.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gi = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gi = g.a(i, true);
            } else {
                gi = g.gi();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(ga());
                z = false;
            } else {
                wVar = new w(ga(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(gi, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, gi, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.tr.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> gn = ((o.c) oVar).gn();
                    tVar2 = oVar;
                    if (gn != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                tVar = new p(str, nVar);
            } else {
                tVar = new t(str, nVar);
            }
            this.tr.put(str, tVar);
            tVar.gp();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f gi;
        b aVar;
        boolean z;
        oVar = this.ts.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gi = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gi = g.a(i, true);
            } else {
                gi = g.gi();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ga());
                z = false;
            } else {
                aVar = new a(ga(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gi, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, gi, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.ts.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> gn = ((o.c) oVar).gn();
                    tVar2 = oVar;
                    if (gn != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                tVar = new p(str, nVar);
            } else {
                tVar = new t(str, nVar);
            }
            this.ts.put(str, tVar);
            tVar.gp();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String gm = cVar.gm();
                cVar.go();
                this.tr.remove(gm);
            }
        }
    }

    public v gl() {
        if (this.tp == null) {
            this.tp = new v(getContext(), ga());
        }
        return this.tp;
    }

    public com.baidu.adp.base.a.b ga() {
        if (this.sO == null) {
            this.sO = new com.baidu.adp.base.a.b(new j(getContext(), this.tq));
        }
        return this.sO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tq)) {
            this.tr.clear();
            this.ts.clear();
        }
    }
}
