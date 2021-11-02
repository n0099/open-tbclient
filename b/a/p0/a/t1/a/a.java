package b.a.p0.a.t1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.h0.j.b;
import b.a.p0.a.h0.m.j;
import b.a.p0.a.v2.j0;
import b.a.p0.n.f.c;
import b.a.p0.n.h.h;
import b.a.p0.n.o.f;
import b.a.p0.t.d;
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
    public b<Boolean> f7923g;

    /* renamed from: h  reason: collision with root package name */
    public String f7924h;

    /* renamed from: i  reason: collision with root package name */
    public String f7925i;
    public long j;
    public c<h> k;

    /* renamed from: b.a.p0.a.t1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0371a extends b.a.p0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7926e;

        public C0371a(a aVar) {
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
            this.f7926e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? e.C0109e.h().getAbsolutePath() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f7926e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(h hVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (aVar != null) {
                    b.a.p0.a.t1.d.a.a("plugin download error: " + aVar.toString());
                }
                this.f7926e.f7923g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (hVar == null) {
                    b.a.p0.a.t1.d.a.a("download finish, plugin is null");
                    this.f7926e.f7923g.a(Boolean.FALSE);
                } else if (!j0.a(new File(hVar.f11070a), hVar.m)) {
                    b.a.p0.a.t1.d.a.a("download finish, check zip sign failure");
                    this.f7926e.f7923g.a(Boolean.FALSE);
                } else {
                    File t = e.t(hVar.f11076g, String.valueOf(hVar.f11078i));
                    d.k(t);
                    if (t != null && t.exists()) {
                        boolean T = d.T(hVar.f11070a, t.getAbsolutePath());
                        hVar.f11072c = hVar.b();
                        hVar.f11073d = hVar.b();
                        b.a.p0.n.g.a.h().l(hVar);
                        d.j(hVar.f11070a);
                        b.a.p0.a.t1.d.a.a("download finish, unZipSuccess = " + T);
                        this.f7926e.f7923g.a(Boolean.valueOf(T));
                        return;
                    }
                    b.a.p0.a.t1.d.a.a("download finish, create file failure, name = " + hVar.f11076g + " ; version = " + hVar.f11078i);
                    this.f7926e.f7923g.a(Boolean.FALSE);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (hVar != null) {
                    b.a.p0.a.t1.d.a.a("plugin download start: bundleId = " + hVar.f11076g);
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
            }
        }
    }

    public a(String str, String str2, long j, b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new C0371a(this);
        this.f7923g = bVar;
        this.f7924h = str;
        this.f7925i = str2;
        this.j = j;
    }

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        h i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (aVar != null) {
                if (aVar.f11066a == 1010 && (i2 = b.a.p0.a.t1.b.a.i(this.f7924h, this.f7925i, this.j)) != null) {
                    i2.f11073d = i2.b();
                    b.a.p0.n.g.a.h().v(i2);
                }
                b.a.p0.a.t1.d.a.a("fetch plugin error: " + aVar.toString());
            } else {
                b.a.p0.a.t1.d.a.a("fetch plugin error");
            }
            this.f7923g.a(Boolean.FALSE);
        }
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            b.a.p0.a.t1.d.a.a("fetch plugin success");
        }
    }

    @Override // b.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            b.a.p0.a.t1.d.a.a("no package");
            this.f7923g.a(Boolean.FALSE);
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
        }
    }

    @Override // b.a.p0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (c) invokeV.objValue;
    }
}
