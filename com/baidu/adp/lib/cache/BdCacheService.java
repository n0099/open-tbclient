package com.baidu.adp.lib.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.aa;
import com.baidu.tieba.ba;
import com.baidu.tieba.c5;
import com.baidu.tieba.ca;
import com.baidu.tieba.da;
import com.baidu.tieba.ea;
import com.baidu.tieba.ga;
import com.baidu.tieba.ha;
import com.baidu.tieba.ia;
import com.baidu.tieba.r9;
import com.baidu.tieba.s9;
import com.baidu.tieba.t9;
import com.baidu.tieba.v9;
import com.baidu.tieba.w9;
import com.baidu.tieba.y9;
import com.baidu.tieba.z9;
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
    public ga a;
    public Context b;
    public c5 c;
    public final String d;
    public HashMap<String, ca<String>> e;
    public HashMap<String, ca<byte[]>> f;
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

    public boolean m(ca<?> caVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, caVar)) == null) {
            return n(caVar, true);
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

    public c5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == null) {
                this.c = new c5(new z9(f(), this.d));
            }
            return this.c;
        }
        return (c5) invokeV.objValue;
    }

    public ga h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                this.a = new ga(f(), g());
            }
            return this.a;
        }
        return (ga) invokeV.objValue;
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

    public synchronized ca<byte[]> b(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        v9 b;
        t9<?> r9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                ca<byte[]> caVar = this.f.get(str);
                if (caVar != null) {
                    return caVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = w9.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = w9.a(i, true);
                } else {
                    b = w9.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    r9Var = new s9(g());
                    z = false;
                } else {
                    r9Var = new r9(g(), "cache_kv_bshare");
                }
                r9Var.r(b, i(r9Var, str, "blob", i));
                return c(str, new aa(r9Var, b, z));
            }
        }
        return (ca) invokeLLLI.objValue;
    }

    public synchronized ca<String> d(String str, CacheStorage cacheStorage, CacheEvictPolicy cacheEvictPolicy, int i) {
        InterceptResult invokeLLLI;
        v9 b;
        t9<?> haVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, cacheStorage, cacheEvictPolicy, i)) == null) {
            synchronized (this) {
                ca<String> caVar = this.e.get(str);
                if (caVar != null) {
                    return caVar;
                }
                boolean z = true;
                if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_COUNT) {
                    b = w9.a(i, false);
                } else if (cacheEvictPolicy == CacheEvictPolicy.LRU_ON_INSERT) {
                    b = w9.a(i, true);
                } else {
                    b = w9.b();
                }
                if (cacheStorage == CacheStorage.SQLite_CACHE_PER_TABLE) {
                    haVar = new ia(g());
                    z = false;
                } else {
                    haVar = new ha(g(), "cache_kv_tshare");
                }
                haVar.r(b, i(haVar, str, "text", i));
                return e(str, new aa(haVar, b, z));
            }
        }
        return (ca) invokeLLLI.objValue;
    }

    public synchronized String i(t9<?> t9Var, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, t9Var, str, str2, i)) == null) {
            synchronized (this) {
                int g = t9Var.g();
                ga h2 = h();
                y9 c = h2.c(str);
                if (c == null) {
                    c = new y9();
                    c.a = str;
                    c.e = g;
                    c.d = str2;
                    c.c = i;
                    c.f = System.currentTimeMillis();
                    c.b = t9Var.l(str);
                    h2.a(c);
                } else if (str2.equalsIgnoreCase(c.d)) {
                    c.c = i;
                    c.f = System.currentTimeMillis();
                    if (g != c.e) {
                        t9Var.k(str, c.b, g, c.e);
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

    public synchronized ca<byte[]> c(String str, ba<byte[]> baVar) {
        InterceptResult invokeLL;
        da eaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, baVar)) == null) {
            synchronized (this) {
                ca<byte[]> caVar = this.f.get(str);
                if (caVar != null) {
                    if (baVar != null && (caVar instanceof ca.c) && ((ca.c) caVar).c() != baVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + baVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return caVar;
                }
                if (j()) {
                    eaVar = new da(str, baVar);
                } else {
                    eaVar = new ea(str, baVar);
                }
                this.f.put(str, eaVar);
                eaVar.k();
                return eaVar;
            }
        }
        return (ca) invokeLL.objValue;
    }

    public synchronized ca<String> e(String str, ba<String> baVar) {
        InterceptResult invokeLL;
        da eaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, baVar)) == null) {
            synchronized (this) {
                ca<String> caVar = this.e.get(str);
                if (caVar != null) {
                    if (baVar != null && (caVar instanceof ca.c) && ((ca.c) caVar).c() != baVar) {
                        throw new IllegalStateException("nameSpace:[" + str + "] is already used for storage:[" + baVar + "]. Make sure to return the old cache before re-use the same namespace.");
                    }
                    return caVar;
                }
                if (j()) {
                    eaVar = new da(str, baVar);
                } else {
                    eaVar = new ea(str, baVar);
                }
                this.e.put(str, eaVar);
                eaVar.k();
                return eaVar;
            }
        }
        return (ca) invokeLL.objValue;
    }

    public boolean l(ca<byte[]> caVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, caVar, z)) == null) {
            if (caVar instanceof ca.c) {
                ca.c cVar = (ca.c) caVar;
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

    public boolean n(ca<?> caVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, caVar, z)) == null) {
            if (caVar instanceof ca.c) {
                ca.c cVar = (ca.c) caVar;
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
