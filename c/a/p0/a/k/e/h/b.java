package c.a.p0.a.k.e.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k.e.h.a;
import c.a.p0.a.l1.f;
import c.a.p0.a.p2.q0;
import c.a.p0.a.s0.d.e;
import c.a.p0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f6056b;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f6057e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f6058f;

        public a(b bVar, a.c cVar) {
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
            this.f6058f = bVar;
            this.f6057e = cVar;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6058f.c(this.f6057e);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.c("GetLocationHelper", str);
                c.a.p0.a.d2.u.a.b("getLocation", 5002, "user no permission", 10005, str);
                this.f6058f.a.f(this.f6057e, str);
            }
        }
    }

    /* renamed from: c.a.p0.a.k.e.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0355b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f6059b;

        public C0355b(b bVar, a.c cVar) {
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
            this.f6059b = bVar;
            this.a = cVar;
        }

        @Override // c.a.p0.a.s0.d.e.a
        public void a(c.a.p0.a.v1.f.j0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f6059b.a.g(this.a, bVar);
            }
        }

        @Override // c.a.p0.a.s0.d.e.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.a.d2.u.a.b("getLocation", 4000, "sdk's errCode is " + i2, 1001, String.valueOf(i2));
                this.f6059b.a.b(this.a, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, c.a.p0.a.v1.f.j0.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875058341, "Lc/a/p0/a/k/e/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(875058341, "Lc/a/p0/a/k/e/h/b;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
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
            }
        }
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6056b == null) {
                synchronized (b.class) {
                    if (f6056b == null) {
                        f6056b = new b();
                    }
                }
            }
            return f6056b;
        }
        return (b) invokeV.objValue;
    }

    public final void c(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.a, "gcj02")) {
                str = TextUtils.equals(cVar.a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
            }
            c.a.p0.a.s0.a.I().b(str, false, cVar.f6054b, new C0355b(this, cVar));
        }
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.a = cVar2;
            if (q0.M()) {
                c(cVar);
            } else if (z) {
                c.a.p0.a.d2.u.a.b("getLocation", 1002, "GetLocation does not supported when app is invisible", 10005, "GetLocation does not supported when app is invisible");
                this.a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                c.a.p0.a.l1.e.g(c.a.p0.a.t1.d.J().x(), new String[]{s.f53808g, s.f53809h}, 0, new a(this, cVar));
            }
        }
    }
}
