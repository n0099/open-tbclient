package c.a.r0.f3;

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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f17216b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, c.a.r0.f3.d.a> a;

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
        this.a = new ConcurrentHashMap<>();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f17216b == null) {
                synchronized (c.class) {
                    if (f17216b == null) {
                        f17216b = new c();
                    }
                }
            }
            return f17216b;
        }
        return (c) invokeV.objValue;
    }

    public ConcurrentHashMap<String, c.a.r0.f3.d.a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ConcurrentHashMap) invokeV.objValue;
    }

    public c.a.r0.f3.d.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ConcurrentHashMap<String, c.a.r0.f3.d.a> concurrentHashMap = this.a;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (c.a.r0.f3.d.a) invokeL.objValue;
    }

    public void d(String str) {
        ConcurrentHashMap<String, c.a.r0.f3.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            c.a.r0.f3.d.a aVar = this.a.get(it.next());
            if (aVar != null && str.equals(aVar.f17217b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, c.a.r0.f3.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            c.a.r0.f3.d.a aVar = this.a.get(str);
            if (aVar != null) {
                aVar.f17220e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, c.a.r0.f3.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            c.a.r0.f3.d.a aVar = this.a.get(str2);
            if (aVar != null && str.equals(aVar.f17217b)) {
                aVar.f17220e = z;
            }
        }
    }

    public void g(HashMap<String, c.a.r0.f3.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.a.clear();
            if (hashMap == null) {
                return;
            }
            this.a.putAll(hashMap);
        }
    }

    public void h(String str, HashMap<String, c.a.r0.f3.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) {
            if (this.a == null) {
                this.a = new ConcurrentHashMap<>();
            }
            d(str);
            this.a.putAll(hashMap);
        }
    }
}
