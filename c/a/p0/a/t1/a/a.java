package c.a.p0.a.t1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.h0.j.b;
import c.a.p0.a.h0.m.j;
import c.a.p0.a.v2.j0;
import c.a.p0.n.f.c;
import c.a.p0.n.h.h;
import c.a.p0.n.o.f;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f8656g;

    /* renamed from: h  reason: collision with root package name */
    public String f8657h;

    /* renamed from: i  reason: collision with root package name */
    public String f8658i;

    /* renamed from: j  reason: collision with root package name */
    public long f8659j;
    public c<h> k;

    /* renamed from: c.a.p0.a.t1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0376a extends c.a.p0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8660e;

        public C0376a(a aVar) {
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
            this.f8660e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? e.C0114e.h().getAbsolutePath() : (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f8660e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(h hVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (aVar != null) {
                    c.a.p0.a.t1.d.a.a("plugin download error: " + aVar.toString());
                }
                this.f8660e.f8656g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (hVar == null) {
                    c.a.p0.a.t1.d.a.a("download finish, plugin is null");
                    this.f8660e.f8656g.a(Boolean.FALSE);
                } else if (!j0.a(new File(hVar.f11887a), hVar.m)) {
                    c.a.p0.a.t1.d.a.a("download finish, check zip sign failure");
                    this.f8660e.f8656g.a(Boolean.FALSE);
                } else {
                    File t = e.t(hVar.f11893g, String.valueOf(hVar.f11895i));
                    d.k(t);
                    if (t != null && t.exists()) {
                        boolean T = d.T(hVar.f11887a, t.getAbsolutePath());
                        hVar.f11889c = hVar.b();
                        hVar.f11890d = hVar.b();
                        c.a.p0.n.g.a.h().l(hVar);
                        d.j(hVar.f11887a);
                        c.a.p0.a.t1.d.a.a("download finish, unZipSuccess = " + T);
                        this.f8660e.f8656g.a(Boolean.valueOf(T));
                        return;
                    }
                    c.a.p0.a.t1.d.a.a("download finish, create file failure, name = " + hVar.f11893g + " ; version = " + hVar.f11895i);
                    this.f8660e.f8656g.a(Boolean.FALSE);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (hVar != null) {
                    c.a.p0.a.t1.d.a.a("plugin download start: bundleId = " + hVar.f11893g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
            }
        }
    }

    public a(String str, String str2, long j2, b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j2), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new C0376a(this);
        this.f8656g = bVar;
        this.f8657h = str;
        this.f8658i = str2;
        this.f8659j = j2;
    }

    @Override // c.a.p0.n.f.g
    public void B(c.a.p0.n.h.a aVar) {
        h i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (aVar != null) {
                if (aVar.f11883a == 1010 && (i2 = c.a.p0.a.t1.b.a.i(this.f8657h, this.f8658i, this.f8659j)) != null) {
                    i2.f11890d = i2.b();
                    c.a.p0.n.g.a.h().v(i2);
                }
                c.a.p0.a.t1.d.a.a("fetch plugin error: " + aVar.toString());
            } else {
                c.a.p0.a.t1.d.a.a("fetch plugin error");
            }
            this.f8656g.a(Boolean.FALSE);
        }
    }

    @Override // c.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            c.a.p0.a.t1.d.a.a("fetch plugin success");
        }
    }

    @Override // c.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            c.a.p0.a.t1.d.a.a("no package");
            this.f8656g.a(Boolean.FALSE);
        }
    }

    @Override // c.a.p0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
        }
    }

    @Override // c.a.p0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (c) invokeV.objValue;
    }
}
