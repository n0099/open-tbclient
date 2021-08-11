package c.a.n0.h.f.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.h0.m.j;
import c.a.n0.a.k;
import c.a.n0.a.v2.j0;
import c.a.n0.h.f.b;
import c.a.n0.h.s.a;
import c.a.n0.n.f.c;
import c.a.n0.n.h.h;
import c.a.n0.n.o.f;
import c.a.n0.t.d;
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
    public static final boolean f10952j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f10953g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.h.f.k.a f10954h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f10955i;

    /* renamed from: c.a.n0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0560a extends c.a.n0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10956e;

        public C0560a(a aVar) {
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
            this.f10956e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // c.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f10956e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: o */
        public void e(h hVar, c.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (a.f10952j) {
                    String str = "onDownloadError: " + aVar.toString();
                }
                this.f10956e.f10953g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.f10952j) {
                    String str = "onDownloadFinish: " + hVar.toString();
                }
                if (!j0.a(new File(hVar.f11605a), hVar.m)) {
                    boolean unused = a.f10952j;
                    this.f10956e.f10953g.a(false);
                    return;
                }
                File a2 = this.f10956e.f10954h.a();
                if (a2.exists()) {
                    d.i(a2);
                } else {
                    d.k(a2);
                }
                boolean T = d.T(hVar.f11605a, a2.getAbsolutePath());
                if (T) {
                    this.f10956e.f10954h.b(hVar.f11614j, hVar.f11613i);
                }
                d.j(hVar.f11605a);
                this.f10956e.f10953g.a(T);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (a.f10952j) {
                    String str = "onDownloadStart: " + hVar.toString();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.f10952j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1823352298, "Lc/a/n0/h/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1823352298, "Lc/a/n0/h/f/j/a;");
                return;
            }
        }
        f10952j = k.f6803a;
    }

    public a(@NonNull c.a.n0.h.f.k.a aVar, @NonNull b bVar) {
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
        this.f10955i = new C0560a(this);
        this.f10953g = bVar;
        this.f10954h = aVar;
    }

    @Override // c.a.n0.n.f.g
    public void B(c.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (f10952j) {
                String str = "onFetchError: " + aVar.toString();
            }
            this.f10953g.a(false);
        }
    }

    @Override // c.a.n0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = f10952j;
        }
    }

    @Override // c.a.n0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            boolean z = f10952j;
            this.f10953g.a(false);
        }
    }

    @Override // c.a.n0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            boolean z = f10952j;
        }
    }

    @Override // c.a.n0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10955i : (c) invokeV.objValue;
    }
}
