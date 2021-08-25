package c.a.o0.h.f.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h0.m.j;
import c.a.o0.a.k;
import c.a.o0.a.v2.j0;
import c.a.o0.h.f.b;
import c.a.o0.h.s.a;
import c.a.o0.n.f.c;
import c.a.o0.n.h.h;
import c.a.o0.n.o.f;
import c.a.o0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f11198j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f11199g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.h.f.k.a f11200h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f11201i;

    /* renamed from: c.a.o0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0568a extends c.a.o0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11202e;

        public C0568a(a aVar) {
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
            this.f11202e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // c.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f11202e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: o */
        public void e(h hVar, c.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (a.f11198j) {
                    String str = "onDownloadError: " + aVar.toString();
                }
                this.f11202e.f11199g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.f11198j) {
                    String str = "onDownloadFinish: " + hVar.toString();
                }
                if (!j0.a(new File(hVar.f11851a), hVar.m)) {
                    boolean unused = a.f11198j;
                    this.f11202e.f11199g.a(false);
                    return;
                }
                File a2 = this.f11202e.f11200h.a();
                if (a2.exists()) {
                    d.i(a2);
                } else {
                    d.k(a2);
                }
                boolean T = d.T(hVar.f11851a, a2.getAbsolutePath());
                if (T) {
                    this.f11202e.f11200h.b(hVar.f11860j, hVar.f11859i);
                }
                d.j(hVar.f11851a);
                this.f11202e.f11199g.a(T);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (a.f11198j) {
                    String str = "onDownloadStart: " + hVar.toString();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.f11198j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(674663639, "Lc/a/o0/h/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(674663639, "Lc/a/o0/h/f/j/a;");
                return;
            }
        }
        f11198j = k.f7049a;
    }

    public a(@NonNull c.a.o0.h.f.k.a aVar, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11201i = new C0568a(this);
        this.f11199g = bVar;
        this.f11200h = aVar;
    }

    @Override // c.a.o0.n.f.g
    public void B(c.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (f11198j) {
                String str = "onFetchError: " + aVar.toString();
            }
            this.f11199g.a(false);
        }
    }

    @Override // c.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = f11198j;
        }
    }

    @Override // c.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            boolean z = f11198j;
            this.f11199g.a(false);
        }
    }

    @Override // c.a.o0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            boolean z = f11198j;
        }
    }

    @Override // c.a.o0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11201i : (c) invokeV.objValue;
    }
}
