package c.a.q0.v2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f27526b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, c.a.q0.v2.d.a> f27527a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27527a = new ConcurrentHashMap<>();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f27526b == null) {
                synchronized (c.class) {
                    if (f27526b == null) {
                        f27526b = new c();
                    }
                }
            }
            return f27526b;
        }
        return (c) invokeV.objValue;
    }

    public ConcurrentHashMap<String, c.a.q0.v2.d.a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27527a : (ConcurrentHashMap) invokeV.objValue;
    }

    public c.a.q0.v2.d.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ConcurrentHashMap<String, c.a.q0.v2.d.a> concurrentHashMap = this.f27527a;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (c.a.q0.v2.d.a) invokeL.objValue;
    }

    public void d(String str) {
        ConcurrentHashMap<String, c.a.q0.v2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f27527a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            c.a.q0.v2.d.a aVar = this.f27527a.get(it.next());
            if (aVar != null && str.equals(aVar.f27529b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, c.a.q0.v2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (concurrentHashMap = this.f27527a) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            c.a.q0.v2.d.a aVar = this.f27527a.get(str);
            if (aVar != null) {
                aVar.f27532e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, c.a.q0.v2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f27527a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            c.a.q0.v2.d.a aVar = this.f27527a.get(str2);
            if (aVar != null && str.equals(aVar.f27529b)) {
                aVar.f27532e = z;
            }
        }
    }

    public void g(HashMap<String, c.a.q0.v2.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.f27527a.clear();
            if (hashMap == null) {
                return;
            }
            this.f27527a.putAll(hashMap);
        }
    }

    public void h(String str, HashMap<String, c.a.q0.v2.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) {
            if (this.f27527a == null) {
                this.f27527a = new ConcurrentHashMap<>();
            }
            d(str);
            this.f27527a.putAll(hashMap);
        }
    }
}
