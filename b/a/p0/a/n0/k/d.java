package b.a.p0.a.n0.k;

import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f7177a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f7178b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f7179c;

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f7180d;

    /* loaded from: classes.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Set<b.a.p0.a.z2.g1.c<T>> f7181a;

        public a() {
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
            this.f7181a = new HashSet();
        }

        public void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                for (b.a.p0.a.z2.g1.c<T> cVar : this.f7181a) {
                    cVar.onCallback(t);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7181a.clear();
            }
        }

        public void c(b.a.p0.a.z2.g1.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
                return;
            }
            this.f7181a.add(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f7182a;

        /* renamed from: b  reason: collision with root package name */
        public final long f7183b;

        public b(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7182a = j;
            this.f7183b = j2;
            int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7183b > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667390414, "Lb/a/p0/a/n0/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667390414, "Lb/a/p0/a/n0/k/d;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7177a = new HashSet();
        this.f7178b = new HashMap();
        this.f7179c = new HashMap();
        this.f7180d = new a<>();
    }

    public static <T> a<T> i(Map<String, a<T>> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, str)) == null) {
            a<T> aVar = map.get(str);
            if (aVar == null) {
                a<T> aVar2 = new a<>();
                map.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public HashSet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new HashSet<>(this.f7177a) : (HashSet) invokeV.objValue;
    }

    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            this.f7180d.a(exc);
            this.f7180d.b();
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            a i2 = i(this.f7178b, str);
            i2.a(Boolean.valueOf(z));
            i2.b();
        }
    }

    public void d(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            if (bVar == null || bVar.a()) {
                i(this.f7179c, str).a(bVar);
            }
        }
    }

    public d e(b.a.p0.a.z2.g1.c<Exception> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            this.f7180d.c(cVar);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            this.f7177a.addAll(Arrays.asList(strArr));
            return this;
        }
        return (d) invokeL.objValue;
    }

    public final <T> d g(Map<String, a<T>> map, String str, b.a.p0.a.z2.g1.c<T> cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, map, str, cVar)) == null) {
            f(str);
            i(map, str).c(cVar);
            return this;
        }
        return (d) invokeLLL.objValue;
    }

    public d h(String str, b.a.p0.a.z2.g1.c<Boolean> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, cVar)) == null) {
            g(this.f7178b, str, cVar);
            return this;
        }
        return (d) invokeLL.objValue;
    }
}
