package b.a.p0.h.f.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.j;
import b.a.p0.a.k;
import b.a.p0.a.v2.j0;
import b.a.p0.h.f.b;
import b.a.p0.h.s.a;
import b.a.p0.n.f.c;
import b.a.p0.n.h.h;
import b.a.p0.n.o.f;
import b.a.p0.t.d;
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
/* loaded from: classes4.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f10432g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.h.f.k.a f10433h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f10434i;

    /* renamed from: b.a.p0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0565a extends b.a.p0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10435e;

        public C0565a(a aVar) {
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
            this.f10435e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f10435e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(h hVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (a.j) {
                    String str = "onDownloadError: " + aVar.toString();
                }
                this.f10435e.f10432g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.j) {
                    String str = "onDownloadFinish: " + hVar.toString();
                }
                if (!j0.a(new File(hVar.f11070a), hVar.m)) {
                    boolean unused = a.j;
                    this.f10435e.f10432g.a(false);
                    return;
                }
                File a2 = this.f10435e.f10433h.a();
                if (a2.exists()) {
                    d.i(a2);
                } else {
                    d.k(a2);
                }
                boolean T = d.T(hVar.f11070a, a2.getAbsolutePath());
                if (T) {
                    this.f10435e.f10433h.b(hVar.j, hVar.f11078i);
                }
                d.j(hVar.f11070a);
                this.f10435e.f10432g.a(T);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (a.j) {
                    String str = "onDownloadStart: " + hVar.toString();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1665127767, "Lb/a/p0/h/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1665127767, "Lb/a/p0/h/f/j/a;");
                return;
            }
        }
        j = k.f6397a;
    }

    public a(@NonNull b.a.p0.h.f.k.a aVar, @NonNull b bVar) {
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
        this.f10434i = new C0565a(this);
        this.f10432g = bVar;
        this.f10433h = aVar;
    }

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (j) {
                String str = "onFetchError: " + aVar.toString();
            }
            this.f10432g.a(false);
        }
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = j;
        }
    }

    @Override // b.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            boolean z = j;
            this.f10432g.a(false);
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            boolean z = j;
        }
    }

    @Override // b.a.p0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10434i : (c) invokeV.objValue;
    }
}
