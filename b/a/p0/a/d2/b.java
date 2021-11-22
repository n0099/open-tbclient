package b.a.p0.a.d2;

import android.text.TextUtils;
import b.a.p0.a.d2.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class b implements b.a.p0.a.z2.g1.c<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4455g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, b.a.p0.a.z2.g1.c<i.a>> f4456e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b.a.p0.a.z2.g1.e<i.a, Boolean>> f4457f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f4458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4459f;

        public a(b bVar, b.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4459f = bVar;
            this.f4458e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f4459f.f4456e.put(str, this.f4458e);
        }
    }

    /* renamed from: b.a.p0.a.d2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0143b implements b.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4460e;

        public C0143b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4460e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4460e.f4456e.remove(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1320931140, "Lb/a/p0/a/d2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1320931140, "Lb/a/p0/a/d2/b;");
                return;
            }
        }
        f4455g = b.a.p0.a.k.f6863a;
    }

    public b() {
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
        this.f4456e = new HashMap();
        this.f4457f = new ArrayList();
    }

    public b b(b.a.p0.a.z2.g1.e<i.a, Boolean> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            if (eVar != null) {
                this.f4457f.add(eVar);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final boolean c(i.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            for (b.a.p0.a.z2.g1.e<i.a, Boolean> eVar : this.f4457f) {
                if (eVar != null && !eVar.a(aVar).booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z2.g1.c
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        b.a.p0.a.z2.g1.c<i.a> cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f4455g) {
                String str = "handle: " + aVar;
            }
            if (!c(aVar) || (cVar = this.f4456e.get(aVar.f4480f)) == null) {
                return;
            }
            cVar.onCallback(aVar);
        }
    }

    public b e(b.a.p0.a.z2.g1.c<i.a> cVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cVar, strArr)) == null) {
            if (cVar != null && strArr != null && strArr.length > 0) {
                b.a.p0.a.z2.g1.b.d(new a(this, cVar), strArr);
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            if (strArr != null && strArr.length > 0) {
                b.a.p0.a.z2.g1.b.d(new C0143b(this), strArr);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }
}
