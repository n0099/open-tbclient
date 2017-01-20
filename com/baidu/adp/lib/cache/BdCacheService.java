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
    private static volatile BdCacheService mj;
    private Context context;
    private com.baidu.adp.base.a.b lL;
    private w mk;
    private final String ml;
    private HashMap<String, o<String>> mm;
    private HashMap<String, o<byte[]>> mn;
    private boolean mo;

    /* loaded from: classes.dex */
    public enum CacheEvictPolicy {
        NO_EVICT,
        LRU_ON_COUNT,
        LRU_ON_INSERT;

        /* JADX DEBUG: Replace access to removed values field (mp) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (mq) with 'values()' method */
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
        return this.mo;
    }

    private BdCacheService(String str) {
        super(2000998);
        this.mm = new HashMap<>();
        this.mn = new HashMap<>();
        this.ml = str;
        if (BdBaseApplication.getInst() != null) {
            this.mo = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public Context getContext() {
        return this.context == null ? BdBaseApplication.getInst().getApp() : this.context;
    }

    public static BdCacheService dz() {
        if (mj == null) {
            synchronized (BdCacheService.class) {
                if (mj == null) {
                    mj = new BdCacheService("baidu_adp.db");
                }
            }
        }
        return mj;
    }

    public synchronized String a(c<?> cVar, String str, String str2, int i) {
        i V;
        int dn = cVar.dn();
        w dA = dA();
        V = dA.V(str);
        if (V == null) {
            V = new i();
            V.lY = str;
            V.md = dn;
            V.mc = str2;
            V.maxSize = i;
            V.mf = System.currentTimeMillis();
            V.lM = cVar.G(str);
            dA.a(V);
        } else if (!str2.equalsIgnoreCase(V.mc)) {
            throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + V.mc);
        } else {
            V.maxSize = i;
            V.mf = System.currentTimeMillis();
            if (dn != V.md) {
                cVar.b(str, V.lM, dn, V.md);
            }
            dA.a(V);
        }
        return V.lM;
    }

    public synchronized o<String> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<String> oVar;
        f dx;
        y xVar;
        boolean z;
        oVar = this.mm.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                dx = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                dx = g.c(i, true);
            } else {
                dx = g.dx();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                xVar = new y(dq());
                z = false;
            } else {
                xVar = new x(dq(), "cache_kv_tshare");
                z = true;
            }
            xVar.a(dx, a(xVar, str, "text", i));
            oVar = a(str, new k(xVar, dx, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<String> a(String str, n<String> nVar) {
        u uVar;
        u uVar2;
        o<String> oVar = this.mm.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<String> dC = ((o.d) oVar).dC();
                    uVar2 = oVar;
                    if (dC != nVar) {
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
            this.mm.put(str, uVar);
            uVar.dE();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public synchronized o<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        o<byte[]> oVar;
        f dx;
        b aVar;
        boolean z;
        oVar = this.mn.get(str);
        if (oVar == null) {
            if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                dx = g.c(i, false);
            } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                dx = g.c(i, true);
            } else {
                dx = g.dx();
            }
            if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                aVar = new b(dq());
                z = false;
            } else {
                aVar = new a(dq(), "cache_kv_bshare");
                z = true;
            }
            aVar.a(dx, a(aVar, str, "blob", i));
            oVar = b(str, new k(aVar, dx, z));
        }
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.adp.lib.cache.p] */
    public synchronized o<byte[]> b(String str, n<byte[]> nVar) {
        u uVar;
        u uVar2;
        o<byte[]> oVar = this.mn.get(str);
        uVar2 = oVar;
        if (oVar != null) {
            if (nVar != null) {
                boolean z = oVar instanceof o.d;
                uVar2 = oVar;
                if (z) {
                    n<byte[]> dC = ((o.d) oVar).dC();
                    uVar2 = oVar;
                    if (dC != nVar) {
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
            this.mn.put(str, uVar);
            uVar.dE();
            uVar2 = uVar;
        }
        return uVar2;
    }

    public void a(o<?> oVar) {
        if (oVar instanceof o.d) {
            o.d dVar = (o.d) oVar;
            synchronized (dVar) {
                String dB = dVar.dB();
                dVar.dD();
                this.mm.remove(dB);
            }
        }
    }

    public w dA() {
        if (this.mk == null) {
            this.mk = new w(getContext(), dq());
        }
        return this.mk;
    }

    public com.baidu.adp.base.a.b dq() {
        if (this.lL == null) {
            this.lL = new com.baidu.adp.base.a.b(new j(getContext(), this.ml));
        }
        return this.lL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        if ((customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.ml)) {
            this.mm.clear();
            this.mn.clear();
        }
    }
}
