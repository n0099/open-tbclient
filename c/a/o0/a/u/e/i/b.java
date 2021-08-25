package c.a.o0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c1.d.d;
import c.a.o0.a.e0.d;
import c.a.o0.a.k;
import c.a.o0.a.s1.e;
import c.a.o0.a.s1.f;
import c.a.o0.a.u.e.i.a;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f8919b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f8920a;

    /* loaded from: classes.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f8921a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8922b;

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
            this.f8922b = bVar;
            this.f8921a = cVar;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f8922b.c(this.f8921a);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.b("GetLocationHelper", str);
                this.f8922b.f8920a.f(this.f8921a, str);
            }
        }
    }

    /* renamed from: c.a.o0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0403b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f8923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8924b;

        public C0403b(b bVar, a.c cVar) {
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
            this.f8924b = bVar;
            this.f8923a = cVar;
        }

        @Override // c.a.o0.a.c1.d.d.a
        public void a(c.a.o0.a.c2.f.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f8924b.f8920a.g(this.f8923a, bVar);
            }
        }

        @Override // c.a.o0.a.c1.d.d.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f8924b.f8920a.b(this.f8923a, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, c.a.o0.a.c2.f.k0.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1416725305, "Lc/a/o0/a/u/e/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1416725305, "Lc/a/o0/a/u/e/i/b;");
                return;
            }
        }
        boolean z = k.f7049a;
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
            if (f8919b == null) {
                synchronized (b.class) {
                    if (f8919b == null) {
                        f8919b = new b();
                    }
                }
            }
            return f8919b;
        }
        return (b) invokeV.objValue;
    }

    public final void c(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.f8916a, "gcj02")) {
                str = TextUtils.equals(cVar.f8916a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
            }
            c.a.o0.a.c1.a.E().b(str, false, cVar.f8917b, new C0403b(this, cVar));
        }
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.f8920a = cVar2;
            if (q0.L()) {
                c(cVar);
            } else if (z) {
                this.f8920a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                a aVar = new a(this, cVar);
                e.f(c.a.o0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
            }
        }
    }
}
