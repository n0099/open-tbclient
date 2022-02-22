package c.a.i0.l.h;

import androidx.core.view.InputDeviceCompat;
import c.a.i0.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.i0.l.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0154a extends c.a.i0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.i0.o.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3787b;

        public C0154a(c.a.i0.o.a aVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f3787b = jSONObject;
        }

        @Override // c.a.i0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                c.a.i0.o.a aVar = this.a;
                if (aVar != null) {
                    aVar.a(1, str);
                }
                c.a.i0.l.i.a.d(this.f3787b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.i0.l.a
        /* renamed from: d */
        public void c(String str) {
            c.a.i0.o.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(0, "");
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends c.a.i0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.i0.o.a a;

        public b(c.a.i0.o.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.i0.l.a
        public void a(Throwable th, int i2, String str) {
            c.a.i0.o.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(1, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.i0.l.a
        /* renamed from: d */
        public void c(String str) {
            c.a.i0.o.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.a(0, "");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1276853178, "Lc/a/i0/l/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1276853178, "Lc/a/i0/l/h/a;");
        }
    }

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : invokeV.intValue;
    }

    public static final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            a = i2;
        }
    }

    public static final void c(JSONObject jSONObject, c.a.i0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, jSONObject, aVar) == null) || jSONObject == null) {
            return;
        }
        c.a.i0.l.c cVar = new c.a.i0.l.c();
        c.d(cVar);
        c.a.i0.l.b e2 = c.e(jSONObject);
        c.c(cVar, e2.a("bduss"));
        HttpSigner.b(e2);
        new g(false).a(d.f(), cVar, e2, new C0154a(aVar, jSONObject));
    }

    public static final void d(JSONArray jSONArray, c.a.i0.o.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, aVar) == null) || jSONArray == null) {
            return;
        }
        c.a.i0.l.c cVar = new c.a.i0.l.c();
        c.d(cVar);
        c.a.i0.l.b bVar = new c.a.i0.l.b();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        bVar.d("batchData", jSONArray2);
        HttpSigner.b(bVar);
        new g(false).a(d.a(), cVar, bVar, new b(aVar));
    }
}
