package com.baidu.adp.lib.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.de;
import com.baidu.tieba.ee;
import com.baidu.tieba.fe;
import com.baidu.tieba.he;
import com.baidu.tieba.ie;
import com.baidu.tieba.ke;
import com.baidu.tieba.le;
import com.baidu.tieba.me;
import com.baidu.tieba.ne;
import com.baidu.tieba.o9;
import com.baidu.tieba.oe;
import com.baidu.tieba.pe;
import com.baidu.tieba.qe;
import com.baidu.tieba.se;
import com.baidu.tieba.te;
import com.baidu.tieba.ue;
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
public class BdCacheService {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BdCacheService h;
    public transient /* synthetic */ FieldHolder $fh;
    public se a;
    public Context b;
    public o9 c;
    public final String d;
    public HashMap<String, oe<String>> e;
    public HashMap<String, oe<byte[]>> f;
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

    public BdCacheService(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        ((TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE)).registerDbListener(str, this.e, this.f);
    }

    public static BdCacheService j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new BdCacheService(str);
        }
        return (BdCacheService) invokeL.objValue;
    }

    public boolean l(oe<?> oeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, oeVar)) == null) {
            return m(oeVar, true);
        }
        return invokeL.booleanValue;
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

    public o9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c == null) {
                this.c = new o9(new le(getContext(), this.d));
            }
            return this.c;
        }
        return (o9) invokeV.objValue;
    }

    public se g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == null) {
                this.a = new se(getContext(), f());
            }
            return this.a;
        }
        return (se) invokeV.objValue;
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

    public synchronized oe<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        he b;
        fe<?> deVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                oe<byte[]> oeVar = this.f.get(str);
                if (oeVar != null) {
                    return oeVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ie.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ie.a(i, true);
                } else {
                    b = ie.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    deVar = new ee(f());
                    z = false;
                } else {
                    deVar = new de(f(), "cache_kv_bshare");
                }
                deVar.r(b, h(deVar, str, "blob", i));
                return c(str, new me(deVar, b, z));
            }
        }
        return (oe) invokeLLLI.objValue;
    }

    public synchronized oe<String> d(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        he b;
        fe<?> teVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                oe<String> oeVar = this.e.get(str);
                if (oeVar != null) {
                    return oeVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = ie.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = ie.a(i, true);
                } else {
                    b = ie.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    teVar = new ue(f());
                    z = false;
                } else {
                    teVar = new te(f(), "cache_kv_tshare");
                }
                teVar.r(b, h(teVar, str, "text", i));
                return e(str, new me(teVar, b, z));
            }
        }
        return (oe) invokeLLLI.objValue;
    }

    public synchronized String h(fe<?> feVar, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, feVar, str, str2, i)) == null) {
            synchronized (this) {
                int g = feVar.g();
                se g2 = g();
                ke b = g2.b(str);
                if (b == null) {
                    b = new ke();
                    b.a = str;
                    b.e = g;
                    b.d = str2;
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    b.b = feVar.l(str);
                    g2.a(b);
                } else if (str2.equalsIgnoreCase(b.d)) {
                    b.c = i;
                    b.f = System.currentTimeMillis();
                    if (g != b.e) {
                        feVar.k(str, b.b, g, b.e);
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

    public synchronized oe<byte[]> c(String str, ne<byte[]> neVar) {
        InterceptResult invokeLL;
        pe qeVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, neVar)) == null) {
            synchronized (this) {
                oe<byte[]> oeVar = this.f.get(str);
                if (oeVar != null) {
                    if (neVar != null && (oeVar instanceof oe.c) && ((oe.c) oeVar).c() != neVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + neVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return oeVar;
                }
                if (i()) {
                    qeVar = new pe(str, neVar);
                } else {
                    qeVar = new qe(str, neVar);
                }
                this.f.put(str, qeVar);
                qeVar.k();
                return qeVar;
            }
        }
        return (oe) invokeLL.objValue;
    }

    public synchronized oe<String> e(String str, ne<String> neVar) {
        InterceptResult invokeLL;
        pe qeVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, neVar)) == null) {
            synchronized (this) {
                oe<String> oeVar = this.e.get(str);
                if (oeVar != null) {
                    if (neVar != null && (oeVar instanceof oe.c) && ((oe.c) oeVar).c() != neVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + neVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return oeVar;
                }
                if (i()) {
                    qeVar = new pe(str, neVar);
                } else {
                    qeVar = new qe(str, neVar);
                }
                this.e.put(str, qeVar);
                qeVar.k();
                return qeVar;
            }
        }
        return (oe) invokeLL.objValue;
    }

    public boolean k(oe<byte[]> oeVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, oeVar, z)) == null) {
            if (oeVar instanceof oe.c) {
                oe.c cVar = (oe.c) oeVar;
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

    public boolean m(oe<?> oeVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, oeVar, z)) == null) {
            if (oeVar instanceof oe.c) {
                oe.c cVar = (oe.c) oeVar;
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
