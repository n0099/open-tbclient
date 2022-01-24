package c.a.r0.a.u2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class e implements c.a.r0.a.u2.b, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<c.a.r0.a.u2.c<?>, Set<b>> l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f9604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Set f9605f;

        public a(e eVar, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, set, set2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9604e = set;
            this.f9605f = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b bVar : this.f9604e) {
                    bVar.onCallback(this.f9605f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends c.a.r0.a.z2.g1.c<Set<c.a.r0.a.u2.c<?>>> {
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(54868272, "Lc/a/r0/a/u2/e$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(54868272, "Lc/a/r0/a/u2/e$c;");
                    return;
                }
            }
            a = new e();
        }
    }

    public e() {
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
        this.l = new HashMap();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (e) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public e c(Set<c.a.r0.a.u2.c<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (c.a.r0.a.u2.c<?> cVar : set) {
                    hashSet.addAll(i(cVar));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final e d(Set<b> set, Set<c.a.r0.a.u2.c<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            c.a.r0.a.u1.k.i.b.j().i(new a(this, set, set2));
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e e(c.a.r0.a.u2.c<?>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVarArr)) == null) {
            c(Sets.newHashSet(cVarArr));
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e f(c.a.r0.a.u2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            String aVar2 = aVar == null ? "" : aVar.toString();
            boolean z = c.a.r0.a.u2.b.a;
            c.a.r0.a.e0.d.c("Tracer-ErrCode", aVar2);
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e g(b bVar, c.a.r0.a.u2.c<?>... cVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, cVarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<c.a.r0.a.u2.c<?>> keySet = b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr);
                    for (c.a.r0.a.u2.c<?> cVar : keySet) {
                        if (cVar != null) {
                            i(cVar).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e h(c.a.r0.a.u2.c<?>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVarArr)) == null) {
            synchronized (this.l) {
                for (c.a.r0.a.u2.c<?> cVar : cVarArr) {
                    if (!this.l.containsKey(cVar)) {
                        this.l.put(cVar, new HashSet());
                    }
                }
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final Set<b> i(@NonNull c.a.r0.a.u2.c<?> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            Set<b> set = this.l.get(cVar);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(cVar, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public e j(b bVar, c.a.r0.a.u2.c<?>... cVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, cVarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (c.a.r0.a.u2.c<?> cVar : b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr)) {
                        if (cVar != null) {
                            i(cVar).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }
}
