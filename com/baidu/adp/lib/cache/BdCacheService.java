package com.baidu.adp.lib.cache;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    private static BdCacheService tf;
    private Context context;
    private com.baidu.adp.base.a.c sH;
    private ad tg;
    private final String th;
    private HashMap<String, t<String>> ti;
    private HashMap<String, t<byte[]>> tj;
    private boolean tk;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tl) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tm) with 'values()' method */
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
        return this.tk;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.ti = new HashMap<>();
        this.tj = new HashMap<>();
        this.th = str;
        if (BdBaseApplication.getInst() != null) {
            this.tk = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static void fR() {
        tf = null;
    }

    public static BdCacheService gp() {
        if (tf == null) {
            tf = new BdCacheService("baidu_adp.db");
        }
        return tf;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n ad;
        int gb = cVar.gb();
        ad gq = gq();
        ad = gq.ad(str);
        if (ad == null) {
            ad = new n();
            ad.sU = str;
            ad.sZ = gb;
            ad.sY = str2;
            ad.maxSize = i;
            ad.tb = System.currentTimeMillis();
            ad.sI = cVar.O(str);
            gq.a(ad);
        } else if (!str2.equalsIgnoreCase(ad.sY)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + ad.sY);
        } else {
            ad.maxSize = i;
            ad.tb = System.currentTimeMillis();
            if (gb != ad.sZ) {
                cVar.a(str, ad.sI, gb, ad.sZ);
            }
            gq.a(ad);
        }
        return ad.sI;
    }

    public synchronized t<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<String> tVar;
        f gn;
        af aeVar;
        boolean z;
        tVar = this.ti.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gn = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gn = i.a(i, true);
            } else {
                gn = i.gn();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aeVar = new af(gf());
                z = false;
            } else {
                aeVar = new ae(gf(), "cache_kv_tshare");
                z = true;
            }
            aeVar.a(gn, a(aeVar, str, "text", i));
            tVar = a(str, new p(aeVar, gn, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<String> a(String str, s<String> sVar) {
        ab abVar;
        ab abVar2;
        t<String> tVar = this.ti.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<String> gs = ((w) tVar).gs();
                    abVar2 = tVar;
                    if (gs != sVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + sVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                abVar = new x(str, sVar);
            } else {
                abVar = new ab(str, sVar);
            }
            this.ti.put(str, abVar);
            abVar.gu();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public synchronized t<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<byte[]> tVar;
        f gn;
        b aVar;
        boolean z;
        tVar = this.tj.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                gn = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                gn = i.a(i, true);
            } else {
                gn = i.gn();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(gf());
                z = false;
            } else {
                aVar = new a(gf(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(gn, a(aVar, str, "blob", i));
            tVar = b(str, new p(aVar, gn, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<byte[]> b(String str, s<byte[]> sVar) {
        ab abVar;
        ab abVar2;
        t<byte[]> tVar = this.tj.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<byte[]> gs = ((w) tVar).gs();
                    abVar2 = tVar;
                    if (gs != sVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + sVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                abVar = new x(str, sVar);
            } else {
                abVar = new ab(str, sVar);
            }
            this.tj.put(str, abVar);
            abVar.gu();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public void a(t<?> tVar) {
        if (tVar instanceof w) {
            w wVar = (w) tVar;
            synchronized (wVar) {
                String gr = wVar.gr();
                wVar.gt();
                this.ti.remove(gr);
            }
        }
    }

    public ad gq() {
        if (this.tg == null) {
            this.tg = new ad(getContext(), gf());
        }
        return this.tg;
    }

    public com.baidu.adp.base.a.c gf() {
        if (this.sH == null) {
            this.sH = new com.baidu.adp.base.a.c(new o(getContext(), this.th));
        }
        return this.sH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.th)) {
            this.ti.clear();
            this.tj.clear();
        }
    }
}
