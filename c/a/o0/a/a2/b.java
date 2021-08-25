package c.a.o0.a.a2;

import android.text.TextUtils;
import c.a.o0.a.a2.i;
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
public final class b implements c.a.o0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4510g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c.a.o0.a.v2.e1.b<i.a>> f4511e;

    /* renamed from: f  reason: collision with root package name */
    public final List<c.a.o0.a.v2.e1.c<i.a, Boolean>> f4512f;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f4513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4514f;

        public a(b bVar, c.a.o0.a.v2.e1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4514f = bVar;
            this.f4513e = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f4514f.f4511e.put(str, this.f4513e);
        }
    }

    /* renamed from: c.a.o0.a.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115b implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4515e;

        public C0115b(b bVar) {
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
            this.f4515e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4515e.f4511e.remove(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1009115457, "Lc/a/o0/a/a2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1009115457, "Lc/a/o0/a/a2/b;");
                return;
            }
        }
        f4510g = c.a.o0.a.k.f7049a;
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
        this.f4511e = new HashMap();
        this.f4512f = new ArrayList();
    }

    public b b(c.a.o0.a.v2.e1.c<i.a, Boolean> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar != null) {
                this.f4512f.add(cVar);
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
            for (c.a.o0.a.v2.e1.c<i.a, Boolean> cVar : this.f4512f) {
                if (cVar != null && !cVar.a(aVar).booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.v2.e1.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        c.a.o0.a.v2.e1.b<i.a> bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f4510g) {
                String str = "handle: " + aVar;
            }
            if (!c(aVar) || (bVar = this.f4511e.get(aVar.f4537f)) == null) {
                return;
            }
            bVar.onCallback(aVar);
        }
    }

    public b e(c.a.o0.a.v2.e1.b<i.a> bVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, strArr)) == null) {
            if (bVar != null && strArr != null && strArr.length > 0) {
                c.a.o0.a.v2.e1.a.d(new a(this, bVar), strArr);
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
                c.a.o0.a.v2.e1.a.d(new C0115b(this), strArr);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }
}
