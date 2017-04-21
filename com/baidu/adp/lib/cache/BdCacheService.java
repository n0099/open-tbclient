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
    private static volatile BdCacheService tG;
    private Context context;
    private w tH;
    private final String tI;
    private HashMap<String, o<String>> tJ;
    private HashMap<String, o<byte[]>> tK;
    private boolean tL;
    private com.baidu.adp.base.a.b th;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (tM) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (tN) with 'values()' method */
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
        return this.tL;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.tJ = new HashMap<>();
        this.tK = new HashMap<>();
        this.tI = str;
        if (BdBaseApplication.getInst() != null) {
            this.tL = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService eI() {
        if (tG == null) {
            synchronized (BdCacheService.class) {
                if (tG == null) {
                    tG = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return tG;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i R;
        int ew = cVar.ew();
        w eJ = eJ();
        R = eJ.R(str);
        if (R == null) {
            R = new i();
            R.tw = str;
            R.tB = ew;
            R.tA = str2;
            R.maxSize = i;
            R.tC = System.currentTimeMillis();
            R.ti = cVar.C(str);
            eJ.a(R);
        } else if (!str2.equalsIgnoreCase(R.tA)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + R.tA);
        } else {
            R.maxSize = i;
            R.tC = System.currentTimeMillis();
            if (ew != R.tB) {
                cVar.b(str, R.ti, ew, R.tB);
            }
            eJ.a(R);
        }
        return R.ti;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f eG;
        y xVar;
        boolean z;
        oVar = this.tJ.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eG = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eG = g.c(i, true);
            } else {
                eG = g.eG();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(ez());
                z = false;
            } else {
                xVar = new x(ez(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(eG, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, eG, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.tJ.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> eL = ((o.d) oVar).eL();
                    uVar2 = oVar;
                    if (eL != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                uVar = new p(str, nVar);
            } else {
                uVar = new u(str, nVar);
            }
            this.tJ.put(str, uVar);
            uVar.eN();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f eG;
        b aVar;
        boolean z;
        oVar = this.tK.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                eG = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                eG = g.c(i, true);
            } else {
                eG = g.eG();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ez());
                z = false;
            } else {
                aVar = new a(ez(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(eG, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, eG, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.tK.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> eL = ((o.d) oVar).eL();
                    uVar2 = oVar;
                    if (eL != nVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + nVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                }
            }
        } else {
            if (isDebugMode()) {
                uVar = new p(str, nVar);
            } else {
                uVar = new u(str, nVar);
            }
            this.tK.put(str, uVar);
            uVar.eN();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String eK = dVar.eK();
                dVar.eM();
                this.tJ.remove(eK);
            }
        }
    }

    public w eJ() {
        if (this.tH == null) {
            this.tH = new w(getContext(), ez());
        }
        return this.tH;
    }

    public com.baidu.adp.base.a.b ez() {
        if (this.th == null) {
            this.th = new com.baidu.adp.base.a.b(new j(getContext(), this.tI));
        }
        return this.th;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.tI)) {
            this.tJ.clear();
            this.tK.clear();
        }
    }
}
