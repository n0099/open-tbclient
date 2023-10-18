package com.baidu.adp.lib.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.b9;
import com.baidu.tieba.c9;
import com.baidu.tieba.d9;
import com.baidu.tieba.f9;
import com.baidu.tieba.g9;
import com.baidu.tieba.i9;
import com.baidu.tieba.j9;
import com.baidu.tieba.k9;
import com.baidu.tieba.l9;
import com.baidu.tieba.m4;
import com.baidu.tieba.m9;
import com.baidu.tieba.n9;
import com.baidu.tieba.o9;
import com.baidu.tieba.q9;
import com.baidu.tieba.r9;
import com.baidu.tieba.s9;
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
    public q9 a;
    public Context b;
    public m4 c;
    public final String d;
    public HashMap<String, m9<String>> e;
    public HashMap<String, m9<byte[]>> f;
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

    public static BdCacheService k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new BdCacheService(str);
        }
        return (BdCacheService) invokeL.objValue;
    }

    public boolean m(m9<?> m9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, m9Var)) == null) {
            return n(m9Var, true);
        }
        return invokeL.booleanValue;
    }

    public static BdCacheService o() {
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

    public Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.b;
            if (context == null) {
                return BdBaseApplication.getInst().getApp();
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public m4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == null) {
                this.c = new m4(new j9(f(), this.d));
            }
            return this.c;
        }
        return (m4) invokeV.objValue;
    }

    public q9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                this.a = new q9(f(), g());
            }
            return this.a;
        }
        return (q9) invokeV.objValue;
    }

    public boolean j() {
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
                    if (!TextUtils.isEmpty(next) && next.endsWith(str) && n(this.e.get(next), false)) {
                        it.remove();
                    }
                } else if (n(this.e.get(next), false)) {
                    it.remove();
                }
            }
            Iterator<String> it2 = this.f.keySet().iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(next2) && next2.endsWith(str) && l(this.f.get(next2), false)) {
                        it2.remove();
                    }
                } else if (l(this.f.get(next2), false)) {
                    it2.remove();
                }
            }
        }
    }

    public synchronized m9<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        f9 b;
        d9<?> b9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                m9<byte[]> m9Var = this.f.get(str);
                if (m9Var != null) {
                    return m9Var;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = g9.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = g9.a(i, true);
                } else {
                    b = g9.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    b9Var = new c9(g());
                    z = false;
                } else {
                    b9Var = new b9(g(), "cache_kv_bshare");
                }
                b9Var.r(b, i(b9Var, str, "blob", i));
                return c(str, new k9(b9Var, b, z));
            }
        }
        return (m9) invokeLLLI.objValue;
    }

    public synchronized m9<String> d(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        f9 b;
        d9<?> r9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                m9<String> m9Var = this.e.get(str);
                if (m9Var != null) {
                    return m9Var;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = g9.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = g9.a(i, true);
                } else {
                    b = g9.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    r9Var = new s9(g());
                    z = false;
                } else {
                    r9Var = new r9(g(), "cache_kv_tshare");
                }
                r9Var.r(b, i(r9Var, str, "text", i));
                return e(str, new k9(r9Var, b, z));
            }
        }
        return (m9) invokeLLLI.objValue;
    }

    public synchronized String i(d9<?> d9Var, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, d9Var, str, str2, i)) == null) {
            synchronized (this) {
                int g = d9Var.g();
                q9 h2 = h();
                i9 c = h2.c(str);
                if (c == null) {
                    c = new i9();
                    c.a = str;
                    c.e = g;
                    c.d = str2;
                    c.c = i;
                    c.f = System.currentTimeMillis();
                    c.b = d9Var.l(str);
                    h2.a(c);
                } else if (str2.equalsIgnoreCase(c.d)) {
                    c.c = i;
                    c.f = System.currentTimeMillis();
                    if (g != c.e) {
                        d9Var.k(str, c.b, g, c.e);
                    }
                    h2.a(c);
                } else {
                    throw new IllegalArgumentException("nameSpace [" + str + "] is already taken by cacheType:" + c.d);
                }
                str3 = c.b;
            }
            return str3;
        }
        return (String) invokeLLLI.objValue;
    }

    public synchronized m9<byte[]> c(String str, l9<byte[]> l9Var) {
        InterceptResult invokeLL;
        n9 o9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, l9Var)) == null) {
            synchronized (this) {
                m9<byte[]> m9Var = this.f.get(str);
                if (m9Var != null) {
                    if (l9Var != null && (m9Var instanceof m9.c) && ((m9.c) m9Var).c() != l9Var) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + l9Var + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return m9Var;
                }
                if (j()) {
                    o9Var = new n9(str, l9Var);
                } else {
                    o9Var = new o9(str, l9Var);
                }
                this.f.put(str, o9Var);
                o9Var.k();
                return o9Var;
            }
        }
        return (m9) invokeLL.objValue;
    }

    public synchronized m9<String> e(String str, l9<String> l9Var) {
        InterceptResult invokeLL;
        n9 o9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, l9Var)) == null) {
            synchronized (this) {
                m9<String> m9Var = this.e.get(str);
                if (m9Var != null) {
                    if (l9Var != null && (m9Var instanceof m9.c) && ((m9.c) m9Var).c() != l9Var) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + l9Var + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return m9Var;
                }
                if (j()) {
                    o9Var = new n9(str, l9Var);
                } else {
                    o9Var = new o9(str, l9Var);
                }
                this.e.put(str, o9Var);
                o9Var.k();
                return o9Var;
            }
        }
        return (m9) invokeLL.objValue;
    }

    public boolean l(m9<byte[]> m9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, m9Var, z)) == null) {
            if (m9Var instanceof m9.c) {
                m9.c cVar = (m9.c) m9Var;
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

    public boolean n(m9<?> m9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, m9Var, z)) == null) {
            if (m9Var instanceof m9.c) {
                m9.c cVar = (m9.c) m9Var;
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
