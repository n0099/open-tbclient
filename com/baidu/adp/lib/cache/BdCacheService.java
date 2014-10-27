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
    private static BdCacheService fF;
    private Context context;
    private ad fG;
    private final String fH;
    private HashMap<String, t<String>> fI;
    private HashMap<String, t<byte[]>> fJ;
    private boolean fK;
    private com.baidu.adp.base.a.c fi;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (fL) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (fM) with 'values()' method */
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
        return this.fK;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.fI = new HashMap<>();
        this.fJ = new HashMap<>();
        this.fH = str;
        if (BdBaseApplication.getInst() != null) {
            this.fK = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService cr() {
        if (fF == null) {
            fF = new BdCacheService("baidu_adp.db");
        }
        return fF;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        n I;
        int ce = cVar.ce();
        ad cs = cs();
        I = cs.I(str);
        if (I == null) {
            I = new n();
            I.fv = str;
            I.fA = ce;
            I.fz = str2;
            I.maxSize = i;
            I.fB = System.currentTimeMillis();
            I.fj = cVar.r(str);
            cs.a(I);
        } else if (!str2.equalsIgnoreCase(I.fz)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + I.fz);
        } else {
            I.maxSize = i;
            I.fB = System.currentTimeMillis();
            if (ce != I.fA) {
                cVar.a(str, I.fj, ce, I.fA);
            }
            cs.a(I);
        }
        return I.fj;
    }

    public synchronized t<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<String> tVar;
        f cp;
        af aeVar;
        boolean z;
        tVar = this.fI.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cp = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cp = i.a(i, true);
            } else {
                cp = i.cp();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aeVar = new af(ch());
                z = false;
            } else {
                aeVar = new ae(ch(), "cache_kv_tshare");
                z = true;
            }
            aeVar.a(cp, a(aeVar, str, "text", i));
            tVar = a(str, new p(aeVar, cp, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<String> a(String str, s<String> sVar) {
        ab abVar;
        ab abVar2;
        t<String> tVar = this.fI.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<String> cu = ((w) tVar).cu();
                    abVar2 = tVar;
                    if (cu != sVar) {
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
            this.fI.put(str, abVar);
            abVar.cw();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public synchronized t<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        t<byte[]> tVar;
        f cp;
        b aVar;
        boolean z;
        tVar = this.fJ.get(str);
        if (tVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                cp = i.a(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                cp = i.a(i, true);
            } else {
                cp = i.cp();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(ch());
                z = false;
            } else {
                aVar = new a(ch(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(cp, a(aVar, str, "blob", i));
            tVar = b(str, new p(aVar, cp, z));
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.x] */
    public synchronized t<byte[]> b(String str, s<byte[]> sVar) {
        ab abVar;
        ab abVar2;
        t<byte[]> tVar = this.fJ.get(str);
        abVar2 = tVar;
        if (tVar != null) {
            if (sVar != null) {
                boolean z = tVar instanceof w;
                abVar2 = tVar;
                if (z) {
                    s<byte[]> cu = ((w) tVar).cu();
                    abVar2 = tVar;
                    if (cu != sVar) {
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
            this.fJ.put(str, abVar);
            abVar.cw();
            abVar2 = abVar;
        }
        return abVar2;
    }

    public void a(t<?> tVar) {
        if (tVar instanceof w) {
            w wVar = (w) tVar;
            synchronized (wVar) {
                String ct = wVar.ct();
                wVar.cv();
                this.fI.remove(ct);
            }
        }
    }

    public ad cs() {
        if (this.fG == null) {
            this.fG = new ad(getContext(), ch());
        }
        return this.fG;
    }

    public com.baidu.adp.base.a.c ch() {
        if (this.fi == null) {
            this.fi = new com.baidu.adp.base.a.c(new o(getContext(), this.fH));
        }
        return this.fi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.fH)) {
            this.fI.clear();
            this.fJ.clear();
        }
    }
}
