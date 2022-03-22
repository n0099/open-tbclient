package c.a.n0.a.m1.b;

import androidx.annotation.NonNull;
import c.a.n0.a.x.j.b;
import c.a.n0.a.x.m.k;
import c.a.n0.a.x.m.l;
import c.a.n0.q.e.e;
import c.a.n0.q.h.i;
import c.a.n0.q.o.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public b<Boolean> f5436c;

    /* renamed from: d  reason: collision with root package name */
    public String f5437d;

    /* renamed from: e  reason: collision with root package name */
    public String f5438e;

    /* renamed from: f  reason: collision with root package name */
    public long f5439f;

    /* renamed from: g  reason: collision with root package name */
    public final e<i> f5440g;

    /* renamed from: c.a.n0.a.m1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0372a extends l<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5441b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0372a(a aVar, a aVar2) {
            super(aVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5441b = aVar;
        }

        @Override // c.a.n0.a.x.m.l
        public void r(@NonNull i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5441b.f5436c.a(Boolean.TRUE);
            }
        }

        @Override // c.a.n0.a.x.m.l
        public void u(i iVar, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                this.f5441b.f5436c.a(Boolean.FALSE);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5440g = new C0372a(this, this);
        this.f5436c = bVar;
        this.f5437d = str;
        this.f5438e = str2;
        this.f5439f = j;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        i p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (bVar != null) {
                if (bVar.a == 1010 && (p = c.a.n0.a.m1.c.a.p(this.f5437d, this.f5438e, this.f5439f)) != null) {
                    p.f9142d = p.b();
                    c.a.n0.q.f.a.i().x(p);
                }
                c.a.n0.a.m1.e.a.b("fetch plugin error: " + bVar.toString());
            } else {
                c.a.n0.a.m1.e.a.b("fetch plugin error");
            }
            this.f5436c.a(Boolean.FALSE);
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            c.a.n0.a.m1.e.a.b("fetch plugin success");
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.n0.a.m1.e.a.b("no package");
            this.f5436c.a(Boolean.FALSE);
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public e<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5440g : (e) invokeV.objValue;
    }
}
