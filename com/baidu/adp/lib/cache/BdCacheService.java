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
    private static volatile BdCacheService tl;
    private Context context;
    private com.baidu.adp.base.a.b sN;
    private v tm;
    private final String tp;
    private HashMap<String, o<String>> tq;
    private HashMap<String, o<byte[]>> tr;
    private boolean ts;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tt) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tu) with 'values()' method */
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
        return this.ts;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tq = new HashMap<>();
        this.tr = new HashMap<>();
        this.tp = str;
        if (BdBaseApplication.getInst() != null) {
            this.ts = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService gl() {
        if (tl == null) {
            synchronized (BdCacheService.class) {
                if (tl == null) {
                    tl = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tl;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i ac;
        int fX = cVar.fX();
        v gm = gm();
        ac = gm.ac(str);
        if (ac == null) {
            ac = new i();
            ac.tb = str;
            ac.tg = fX;
            ac.tf = str2;
            ac.maxSize = i;
            ac.th = System.currentTimeMillis();
            ac.sO = cVar.N(str);
            gm.a(ac);
        } else if (!str2.equalsIgnoreCase(ac.tf)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ac.tf);
        } else {
            ac.maxSize = i;
            ac.th = System.currentTimeMillis();
            if (fX != ac.tg) {
                cVar.a(str, ac.sO, fX, ac.tg);
            }
            gm.a(ac);
        }
        return ac.sO;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f gj;
        x wVar;
        boolean z;
        oVar = this.tq.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gj = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gj = g.a(i, true);
            } else {
                gj = g.gj();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                wVar = new x(ga());
                z = false;
            } else {
                wVar = new w(ga(), "cache_kv_tshare");
                z = true;
            }
            wVar.a(gj, a(wVar, str, "text", i));
            oVar = a(str, new k(wVar, gj, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        t tVar;
        t tVar2;
        o<String> oVar = this.tq.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<String> go = ((o.c) oVar).go();
                    tVar2 = oVar;
                    if (go != nVar) {
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
            this.tq.put(str, tVar);
            tVar.gq();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f gj;
        b aVar;
        boolean z;
        oVar = this.tr.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gj = g.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gj = g.a(i, true);
            } else {
                gj = g.gj();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ga());
                z = false;
            } else {
                aVar = new a(ga(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gj, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, gj, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        t tVar;
        t tVar2;
        o<byte[]> oVar = this.tr.get(str);
        tVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.c;
                tVar2 = oVar;
                if (z) {
                    n<byte[]> go = ((o.c) oVar).go();
                    tVar2 = oVar;
                    if (go != nVar) {
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
            tVar.gq();
            tVar2 = tVar;
        }
        return tVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.c) {
            o.c cVar = (o.c) oVar;
            synchronized (cVar) {
                String gn = cVar.gn();
                cVar.gp();
                this.tq.remove(gn);
            }
        }
    }

    public v gm() {
        if (this.tm == null) {
            this.tm = new v(getContext(), ga());
        }
        return this.tm;
    }

    public com.baidu.adp.base.a.b ga() {
        if (this.sN == null) {
            this.sN = new com.baidu.adp.base.a.b(new j(getContext(), this.tp));
        }
        return this.sN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tp)) {
            this.tq.clear();
            this.tr.clear();
        }
    }
}
