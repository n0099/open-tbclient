package com.baidu.adp.lib.cache;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.fe;
import com.repackage.ge;
import com.repackage.h9;
import com.repackage.he;
import com.repackage.je;
import com.repackage.ke;
import com.repackage.me;
import com.repackage.ne;
import com.repackage.oe;
import com.repackage.pe;
import com.repackage.qe;
import com.repackage.re;
import com.repackage.se;
import com.repackage.ue;
import com.repackage.ve;
import com.repackage.we;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BdCacheService h;
    public transient /* synthetic */ FieldHolder $fh;
    public ue a;
    public Context b;
    public h9 c;
    public final String d;
    public HashMap<String, qe<String>> e;
    public HashMap<String, qe<byte[]>> f;
    public boolean g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public CacheEvictPolicy(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    /* loaded from: classes.dex */
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

        public CacheStorage(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new HashMap<>();
        this.f = new HashMap<>();
        this.d = str;
        if (BdBaseApplication.getInst() != null) {
            this.g = BdBaseApplication.getInst().isDebugMode();
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
            if (h == null) {
                synchronized (BdCacheService.class) {
                    if (h == null) {
                        h = new BdCacheService("baidu_adp.db");
                    }
                }
            }
            return h;
        }
        return (BdCacheService) invokeV.objValue;
    }

    public synchronized qe<byte[]> a(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        je b;
        he<?> feVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                qe<byte[]> qeVar = this.f.get(str);
                if (qeVar != null) {
                    return qeVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ke.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ke.a(i, true);
                } else {
                    b = ke.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    feVar = new ge(e());
                    z = false;
                } else {
                    feVar = new fe(e(), "cache_kv_bshare");
                }
                feVar.r(b, g(feVar, str, "blob", i));
                return b(str, new oe(feVar, b, z));
            }
        }
        return (qe) invokeLLLI.objValue;
    }

    public synchronized qe<byte[]> b(String str, pe<byte[]> peVar) {
        InterceptResult invokeLL;
        re seVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, peVar)) == null) {
            synchronized (this) {
                qe<byte[]> qeVar = this.f.get(str);
                if (qeVar != null) {
                    if (peVar != null && (qeVar instanceof qe.c) && ((qe.c) qeVar).c() != peVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + peVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return qeVar;
                }
                if (h()) {
                    seVar = new re(str, peVar);
                } else {
                    seVar = new se(str, peVar);
                }
                this.f.put(str, seVar);
                seVar.k();
                return seVar;
            }
        }
        return (qe) invokeLL.objValue;
    }

    public synchronized qe<String> c(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        je b;
        he<?> veVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                qe<String> qeVar = this.e.get(str);
                if (qeVar != null) {
                    return qeVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ke.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ke.a(i, true);
                } else {
                    b = ke.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    veVar = new we(e());
                    z = false;
                } else {
                    veVar = new ve(e(), "cache_kv_tshare");
                }
                veVar.r(b, g(veVar, str, "text", i));
                return d(str, new oe(veVar, b, z));
            }
        }
        return (qe) invokeLLLI.objValue;
    }

    public synchronized qe<String> d(String str, pe<String> peVar) {
        InterceptResult invokeLL;
        re seVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, peVar)) == null) {
            synchronized (this) {
                qe<String> qeVar = this.e.get(str);
                if (qeVar != null) {
                    if (peVar != null && (qeVar instanceof qe.c) && ((qe.c) qeVar).c() != peVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + peVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return qeVar;
                }
                if (h()) {
                    seVar = new re(str, peVar);
                } else {
                    seVar = new se(str, peVar);
                }
                this.e.put(str, seVar);
                seVar.k();
                return seVar;
            }
        }
        return (qe) invokeLL.objValue;
    }

    public h9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c == null) {
                this.c = new h9(new ne(getContext(), this.d));
            }
            return this.c;
        }
        return (h9) invokeV.objValue;
    }

    public ue f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ue(getContext(), e());
            }
            return this.a;
        }
        return (ue) invokeV.objValue;
    }

    public synchronized String g(he<?> heVar, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, heVar, str, str2, i)) == null) {
            synchronized (this) {
                int g = heVar.g();
                ue f = f();
                me b = f.b(str);
                if (b == null) {
                    b = new me();
                    b.a = str;
                    b.e = g;
                    b.d = str2;
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    b.b = heVar.l(str);
                    f.a(b);
                } else if (str2.equalsIgnoreCase(b.d)) {
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    if (g != b.e) {
                        heVar.k(str, b.b, g, b.e);
                    }
                    f.a(b);
                } else {
                    throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + b.d);
                }
                str3 = b.b;
            }
            return str3;
        }
        return (String) invokeLLLI.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.b;
            return context == null ? BdBaseApplication.getInst().getApp() : context;
        }
        return (Context) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void j(qe<?> qeVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qeVar) == null) && (qeVar instanceof qe.c)) {
            qe.c cVar = (qe.c) qeVar;
            synchronized (cVar) {
                String j = cVar.j();
                cVar.b();
                this.e.remove(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.d)) {
            this.e.clear();
            this.f.clear();
        }
    }
}
