package com.baidu.adp.lib.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.be;
import com.baidu.tieba.ce;
import com.baidu.tieba.de;
import com.baidu.tieba.fe;
import com.baidu.tieba.ge;
import com.baidu.tieba.i9;
import com.baidu.tieba.ie;
import com.baidu.tieba.je;
import com.baidu.tieba.ke;
import com.baidu.tieba.le;
import com.baidu.tieba.me;
import com.baidu.tieba.ne;
import com.baidu.tieba.oe;
import com.baidu.tieba.qe;
import com.baidu.tieba.re;
import com.baidu.tieba.se;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BdCacheService extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BdCacheService h;
    public transient /* synthetic */ FieldHolder $fh;
    public qe a;
    public Context b;
    public i9 c;
    public final String d;
    public HashMap<String, me<String>> e;
    public HashMap<String, me<byte[]>> f;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CacheEvictPolicy) Enum.valueOf(CacheEvictPolicy.class, str);
            }
            return (CacheEvictPolicy) invokeL.objValue;
        }

        public static CacheEvictPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CacheEvictPolicy[]) $VALUES.clone();
            }
            return (CacheEvictPolicy[]) invokeV.objValue;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CacheStorage) Enum.valueOf(CacheStorage.class, str);
            }
            return (CacheStorage) invokeL.objValue;
        }

        public static CacheStorage[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CacheStorage[]) $VALUES.clone();
            }
            return (CacheStorage[]) invokeV.objValue;
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

    public static BdCacheService j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new BdCacheService(str);
        }
        return (BdCacheService) invokeL.objValue;
    }

    public boolean l(me<?> meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, meVar)) == null) {
            return m(meVar, true);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String databaseFile;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BdDatabaseNewCreatedMessage) && (databaseFile = ((BdDatabaseNewCreatedMessage) customResponsedMessage).getDatabaseFile()) != null && databaseFile.contains(this.d)) {
            this.e.clear();
            this.f.clear();
        }
    }

    public static BdCacheService n() {
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

    public i9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c == null) {
                this.c = new i9(new je(getContext(), this.d));
            }
            return this.c;
        }
        return (i9) invokeV.objValue;
    }

    public qe g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == null) {
                this.a = new qe(getContext(), f());
            }
            return this.a;
        }
        return (qe) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.b;
            if (context == null) {
                return BdBaseApplication.getInst().getApp();
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Iterator<String> it = this.e.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(next) && next.endsWith(str) && m(this.e.get(next), false)) {
                        it.remove();
                    }
                } else if (m(this.e.get(next), false)) {
                    it.remove();
                }
            }
            Iterator<String> it2 = this.f.keySet().iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(next2) && next2.endsWith(str) && k(this.f.get(next2), false)) {
                        it2.remove();
                    }
                } else if (k(this.f.get(next2), false)) {
                    it2.remove();
                }
            }
        }
    }

    public synchronized me<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        fe b;
        de<?> beVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                me<byte[]> meVar = this.f.get(str);
                if (meVar != null) {
                    return meVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ge.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ge.a(i, true);
                } else {
                    b = ge.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    beVar = new ce(f());
                    z = false;
                } else {
                    beVar = new be(f(), "cache_kv_bshare");
                }
                beVar.r(b, h(beVar, str, "blob", i));
                return c(str, new ke(beVar, b, z));
            }
        }
        return (me) invokeLLLI.objValue;
    }

    public synchronized me<String> d(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        fe b;
        de<?> reVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                me<String> meVar = this.e.get(str);
                if (meVar != null) {
                    return meVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ge.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ge.a(i, true);
                } else {
                    b = ge.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    reVar = new se(f());
                    z = false;
                } else {
                    reVar = new re(f(), "cache_kv_tshare");
                }
                reVar.r(b, h(reVar, str, "text", i));
                return e(str, new ke(reVar, b, z));
            }
        }
        return (me) invokeLLLI.objValue;
    }

    public synchronized String h(de<?> deVar, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, deVar, str, str2, i)) == null) {
            synchronized (this) {
                int g = deVar.g();
                qe g2 = g();
                ie b = g2.b(str);
                if (b == null) {
                    b = new ie();
                    b.a = str;
                    b.e = g;
                    b.d = str2;
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    b.b = deVar.l(str);
                    g2.a(b);
                } else if (str2.equalsIgnoreCase(b.d)) {
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    if (g != b.e) {
                        deVar.k(str, b.b, g, b.e);
                    }
                    g2.a(b);
                } else {
                    throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + b.d);
                }
                str3 = b.b;
            }
            return str3;
        }
        return (String) invokeLLLI.objValue;
    }

    public synchronized me<byte[]> c(String str, le<byte[]> leVar) {
        InterceptResult invokeLL;
        ne oeVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, leVar)) == null) {
            synchronized (this) {
                me<byte[]> meVar = this.f.get(str);
                if (meVar != null) {
                    if (leVar != null && (meVar instanceof me.c) && ((me.c) meVar).c() != leVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + leVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return meVar;
                }
                if (i()) {
                    oeVar = new ne(str, leVar);
                } else {
                    oeVar = new oe(str, leVar);
                }
                this.f.put(str, oeVar);
                oeVar.k();
                return oeVar;
            }
        }
        return (me) invokeLL.objValue;
    }

    public synchronized me<String> e(String str, le<String> leVar) {
        InterceptResult invokeLL;
        ne oeVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, leVar)) == null) {
            synchronized (this) {
                me<String> meVar = this.e.get(str);
                if (meVar != null) {
                    if (leVar != null && (meVar instanceof me.c) && ((me.c) meVar).c() != leVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + leVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return meVar;
                }
                if (i()) {
                    oeVar = new ne(str, leVar);
                } else {
                    oeVar = new oe(str, leVar);
                }
                this.e.put(str, oeVar);
                oeVar.k();
                return oeVar;
            }
        }
        return (me) invokeLL.objValue;
    }

    public boolean k(me<byte[]> meVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, meVar, z)) == null) {
            if (meVar instanceof me.c) {
                me.c cVar = (me.c) meVar;
                synchronized (cVar) {
                    String j = cVar.j();
                    cVar.b();
                    if (z) {
                        this.f.remove(j);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public boolean m(me<?> meVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, meVar, z)) == null) {
            if (meVar instanceof me.c) {
                me.c cVar = (me.c) meVar;
                synchronized (cVar) {
                    String j = cVar.j();
                    cVar.b();
                    if (z) {
                        this.e.remove(j);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
