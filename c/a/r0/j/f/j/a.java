package c.a.r0.j.f.j;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.m.k;
import c.a.r0.a.z2.j0;
import c.a.r0.j.f.b;
import c.a.r0.j.t.a;
import c.a.r0.q.f.e;
import c.a.r0.q.i.i;
import c.a.r0.q.p.g;
import c.a.r0.w.d;
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
/* loaded from: classes6.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f11241j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f11242g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j.f.k.a f11243h;

    /* renamed from: i  reason: collision with root package name */
    public e<i> f11244i;

    /* renamed from: c.a.r0.j.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0737a extends c.a.r0.q.f.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11245e;

        public C0737a(a aVar) {
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
            this.f11245e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f11245e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(i iVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, iVar, bVar) == null) {
                super.e(iVar, bVar);
                if (a.f11241j) {
                    String str = "onDownloadError: " + bVar.toString();
                }
                this.f11245e.f11242g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
                super.i(iVar);
                if (a.f11241j) {
                    String str = "onDownloadFinish: " + iVar.toString();
                }
                if (!j0.a(new File(iVar.a), iVar.m)) {
                    boolean unused = a.f11241j;
                    this.f11245e.f11242g.a(false);
                    return;
                }
                File a = this.f11245e.f11243h.a();
                if (a.exists()) {
                    d.j(a);
                } else {
                    d.l(a);
                }
                boolean U = d.U(iVar.a, a.getAbsolutePath());
                if (U) {
                    this.f11245e.f11243h.b(iVar.f11764j, iVar.f11763i);
                }
                d.k(iVar.a);
                this.f11245e.f11242g.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.c(iVar);
                if (a.f11241j) {
                    String str = "onDownloadStart: " + iVar.toString();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: r */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.f(iVar);
                boolean unused = a.f11241j;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1230569768, "Lc/a/r0/j/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1230569768, "Lc/a/r0/j/f/j/a;");
                return;
            }
        }
        f11241j = c.a.r0.a.k.a;
    }

    public a(@NonNull c.a.r0.j.f.k.a aVar, @NonNull b bVar) {
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
        this.f11244i = new C0737a(this);
        this.f11242g = bVar;
        this.f11243h = aVar;
    }

    @Override // c.a.r0.q.f.i
    public void D(c.a.r0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (f11241j) {
                String str = "onFetchError: " + bVar.toString();
            }
            this.f11242g.a(false);
        }
    }

    @Override // c.a.r0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            boolean z = f11241j;
        }
    }

    @Override // c.a.r0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            boolean z = f11241j;
            this.f11242g.a(false);
        }
    }

    @Override // c.a.r0.q.f.i
    public void H(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
            boolean z = f11241j;
        }
    }

    @Override // c.a.r0.q.f.i
    public e<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11244i : (e) invokeV.objValue;
    }
}
