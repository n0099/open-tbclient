package c.a.p0.a.w1.b;

import androidx.annotation.NonNull;
import c.a.p0.a.h0.j.b;
import c.a.p0.a.h0.m.k;
import c.a.p0.a.h0.m.l;
import c.a.p0.q.f.e;
import c.a.p0.q.i.i;
import c.a.p0.q.p.g;
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

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f8669g;

    /* renamed from: h  reason: collision with root package name */
    public String f8670h;

    /* renamed from: i  reason: collision with root package name */
    public String f8671i;

    /* renamed from: j  reason: collision with root package name */
    public long f8672j;

    /* renamed from: k  reason: collision with root package name */
    public final e<i> f8673k;

    /* renamed from: c.a.p0.a.w1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0514a extends l<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8674f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0514a(a aVar, a aVar2) {
            super(aVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8674f = aVar;
        }

        @Override // c.a.p0.a.h0.m.l
        public void r(@NonNull i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f8674f.f8669g.a(Boolean.TRUE);
            }
        }

        @Override // c.a.p0.a.h0.m.l
        public void u(i iVar, c.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                this.f8674f.f8669g.a(Boolean.FALSE);
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
        this.f8673k = new C0514a(this, this);
        this.f8669g = bVar;
        this.f8670h = str;
        this.f8671i = str2;
        this.f8672j = j2;
    }

    @Override // c.a.p0.q.f.i
    public void D(c.a.p0.q.i.b bVar) {
        i p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (bVar != null) {
                if (bVar.a == 1010 && (p = c.a.p0.a.w1.c.a.p(this.f8670h, this.f8671i, this.f8672j)) != null) {
                    p.f10714d = p.b();
                    c.a.p0.q.g.a.i().x(p);
                }
                c.a.p0.a.w1.e.a.b("fetch plugin error: " + bVar.toString());
            } else {
                c.a.p0.a.w1.e.a.b("fetch plugin error");
            }
            this.f8669g.a(Boolean.FALSE);
        }
    }

    @Override // c.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            c.a.p0.a.w1.e.a.b("fetch plugin success");
        }
    }

    @Override // c.a.p0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.p0.a.w1.e.a.b("no package");
            this.f8669g.a(Boolean.FALSE);
        }
    }

    @Override // c.a.p0.q.f.i
    public void H(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
        }
    }

    @Override // c.a.p0.q.f.i
    public e<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8673k : (e) invokeV.objValue;
    }
}
