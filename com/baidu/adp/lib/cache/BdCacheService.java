package com.baidu.adp.lib.cache;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.k.b;
import b.a.e.e.d.a;
import b.a.e.e.d.c;
import b.a.e.e.d.e;
import b.a.e.e.d.f;
import b.a.e.e.d.h;
import b.a.e.e.d.i;
import b.a.e.e.d.j;
import b.a.e.e.d.k;
import b.a.e.e.d.l;
import b.a.e.e.d.m;
import b.a.e.e.d.n;
import b.a.e.e.d.p;
import b.a.e.e.d.q;
import b.a.e.e.d.r;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class BdCacheService extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile BdCacheService f34393h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f34394a;

    /* renamed from: b  reason: collision with root package name */
    public Context f34395b;

    /* renamed from: c  reason: collision with root package name */
    public b f34396c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34397d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, l<String>> f34398e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, l<byte[]>> f34399f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34400g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CacheEvictPolicy {
        public static final /* synthetic */ CacheEvictPolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheEvictPolicy LRU_ON_COUNT;
        public static final CacheEvictPolicy LRU_ON_INSERT;
        public static final CacheEvictPolicy NO_EVICT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343092326, "Lcom/baidu/adp/lib/cache/BdCacheService$CacheEvictPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1343092326, "Lcom/baidu/adp/lib/cache/BdCacheService$CacheEvictPolicy;");
                    return;
                }
            }
            NO_EVICT = new CacheEvictPolicy("NO_EVICT", 0);
            LRU_ON_COUNT = new CacheEvictPolicy("LRU_ON_COUNT", 1);
            CacheEvictPolicy cacheEvictPolicy = new CacheEvictPolicy("LRU_ON_INSERT", 2);
            LRU_ON_INSERT = cacheEvictPolicy;
            $VALUES = new CacheEvictPolicy[]{NO_EVICT, LRU_ON_COUNT, cacheEvictPolicy};
        }

        public CacheEvictPolicy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheEvictPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CacheEvictPolicy) Enum.valueOf(CacheEvictPolicy.class, str) : (CacheEvictPolicy) invokeL.objValue;
        }

        public static CacheEvictPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CacheEvictPolicy[]) $VALUES.clone() : (CacheEvictPolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CacheStorage {
        public static final /* synthetic */ CacheStorage[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CacheStorage SQLite_CACHE_All_IN_ONE_TABLE;
        public static final CacheStorage SQLite_CACHE_PER_TABLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704743174, "Lcom/baidu/adp/lib/cache/BdCacheService$CacheStorage;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1704743174, "Lcom/baidu/adp/lib/cache/BdCacheService$CacheStorage;");
                    return;
                }
            }
            SQLite_CACHE_PER_TABLE = new CacheStorage("SQLite_CACHE_PER_TABLE", 0);
            CacheStorage cacheStorage = new CacheStorage("SQLite_CACHE_All_IN_ONE_TABLE", 1);
            SQLite_CACHE_All_IN_ONE_TABLE = cacheStorage;
            $VALUES = new CacheStorage[]{SQLite_CACHE_PER_TABLE, cacheStorage};
        }

        public CacheStorage(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CacheStorage valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CacheStorage) Enum.valueOf(CacheStorage.class, str) : (CacheStorage) invokeL.objValue;
        }

        public static CacheStorage[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CacheStorage[]) $VALUES.clone() : (CacheStorage[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdCacheService(String str) {
        super(2000998);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34398e = new HashMap<>();
        this.f34399f = new HashMap<>();
        this.f34397d = str;
        if (BdBaseApplication.getInst() != null) {
            this.f34400g = BdBaseApplication.getInst().isDebugMode();
        }
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public static BdCacheService i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new BdCacheService(str) : (BdCacheService) invokeL.objValue;
    }

    public static BdCacheService k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f34393h == null) {
                synchronized (BdCacheService.class) {
                    if (f34393h == null) {
                        f34393h = new BdCacheService("baidu_adp.db");
                    }
                }
            }
            return f34393h;
        }
        return (BdCacheService) invokeV.objValue;
    }

    public synchronized l<byte[]> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i2) {
        InterceptResult invokeLLLI;
        e b2;
        c<?> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, str, cacheStorage, cacheEvictPolicy, i2)) == null) {
            synchronized (this) {
                l<byte[]> lVar = this.f34399f.get(str);
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
                    aVar = new b.a.e.e.d.b(e());
                    z = false;
                } else {
                    aVar = new a(e(), "cache_kv_bshare");
                }
                aVar.r(b2, g(aVar, str, "blob", i2));
                return b(str, new j(aVar, b2, z));
            }
        }
        return (l) invokeLLLI.objValue;
    }

    public synchronized l<byte[]> b(String str, k<byte[]> kVar) {
        InterceptResult invokeLL;
        m nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, kVar)) == null) {
            synchronized (this) {
                l<byte[]> lVar = this.f34399f.get(str);
                if (lVar != null) {
                    if (kVar != null && (lVar instanceof l.c) && ((l.c) lVar).c() != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return lVar;
                }
                if (h()) {
                    nVar = new m(str, kVar);
                } else {
                    nVar = new n(str, kVar);
                }
                this.f34399f.put(str, nVar);
                nVar.k();
                return nVar;
            }
        }
        return (l) invokeLL.objValue;
    }

    public synchronized l<String> c(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i2) {
        InterceptResult invokeLLLI;
        e b2;
        c<?> qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, str, cacheStorage, cacheEvictPolicy, i2)) == null) {
            synchronized (this) {
                l<String> lVar = this.f34398e.get(str);
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
                    qVar = new r(e());
                    z = false;
                } else {
                    qVar = new q(e(), "cache_kv_tshare");
                }
                qVar.r(b2, g(qVar, str, "text", i2));
                return d(str, new j(qVar, b2, z));
            }
        }
        return (l) invokeLLLI.objValue;
    }

    public synchronized l<String> d(String str, k<String> kVar) {
        InterceptResult invokeLL;
        m nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, kVar)) == null) {
            synchronized (this) {
                l<String> lVar = this.f34398e.get(str);
                if (lVar != null) {
                    if (kVar != null && (lVar instanceof l.c) && ((l.c) lVar).c() != kVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + kVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return lVar;
                }
                if (h()) {
                    nVar = new m(str, kVar);
                } else {
                    nVar = new n(str, kVar);
                }
                this.f34398e.put(str, nVar);
                nVar.k();
                return nVar;
            }
        }
        return (l) invokeLL.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f34396c == null) {
                this.f34396c = new b(new i(getContext(), this.f34397d));
            }
            return this.f34396c;
        }
        return (b) invokeV.objValue;
    }

    public p f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f34394a == null) {
                this.f34394a = new p(getContext(), e());
            }
            return this.f34394a;
        }
        return (p) invokeV.objValue;
    }

    public synchronized String g(c<?> cVar, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, cVar, str, str2, i2)) == null) {
            synchronized (this) {
                int g2 = cVar.g();
                p f2 = f();
                h b2 = f2.b(str);
                if (b2 == null) {
                    b2 = new h();
                    b2.f1693a = str;
                    b2.f1697e = g2;
                    b2.f1696d = str2;
                    b2.f1695c = i2;
                    b2.f1698f = System.currentTimeMillis();
                    b2.f1694b = cVar.l(str);
                    f2.a(b2);
                } else if (str2.equalsIgnoreCase(b2.f1696d)) {
                    b2.f1695c = i2;
                    b2.f1698f = System.currentTimeMillis();
                    if (g2 != b2.f1697e) {
                        cVar.k(str, b2.f1694b, g2, b2.f1697e);
                    }
                    f2.a(b2);
                } else {
                    throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + b2.f1696d);
                }
                str3 = b2.f1694b;
            }
            return str3;
        }
        return (String) invokeLLLI.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.f34395b;
            return context == null ? BdBaseApplication.getInst().getApp() : context;
        }
        return (Context) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34400g : invokeV.booleanValue;
    }

    public void j(l<?> lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) && (lVar instanceof l.c)) {
            l.c cVar = (l.c) lVar;
            synchronized (cVar) {
                String j = cVar.j();
                cVar.b();
                this.f34398e.remove(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.f34397d)) {
            this.f34398e.clear();
            this.f34399f.clear();
        }
    }
}
