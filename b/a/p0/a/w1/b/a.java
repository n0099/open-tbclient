package b.a.p0.a.w1.b;

import androidx.annotation.NonNull;
import b.a.p0.a.h0.j.b;
import b.a.p0.a.h0.m.k;
import b.a.p0.a.h0.m.l;
import b.a.p0.q.f.e;
import b.a.p0.q.i.i;
import b.a.p0.q.p.g;
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
    public b<Boolean> f9194g;

    /* renamed from: h  reason: collision with root package name */
    public String f9195h;

    /* renamed from: i  reason: collision with root package name */
    public String f9196i;
    public long j;
    public final e<i> k;

    /* renamed from: b.a.p0.a.w1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0458a extends l<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9197f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0458a(a aVar, a aVar2) {
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
            this.f9197f = aVar;
        }

        @Override // b.a.p0.a.h0.m.l
        public void r(@NonNull i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f9197f.f9194g.a(Boolean.TRUE);
            }
        }

        @Override // b.a.p0.a.h0.m.l
        public void u(i iVar, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                this.f9197f.f9194g.a(Boolean.FALSE);
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
        this.k = new C0458a(this, this);
        this.f9194g = bVar;
        this.f9195h = str;
        this.f9196i = str2;
        this.j = j;
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        i p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            if (bVar != null) {
                if (bVar.f11762a == 1010 && (p = b.a.p0.a.w1.c.a.p(this.f9195h, this.f9196i, this.j)) != null) {
                    p.f11771d = p.b();
                    b.a.p0.q.g.a.i().x(p);
                }
                b.a.p0.a.w1.e.a.b("fetch plugin error: " + bVar.toString());
            } else {
                b.a.p0.a.w1.e.a.b("fetch plugin error");
            }
            this.f9194g.a(Boolean.FALSE);
        }
    }

    @Override // b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            b.a.p0.a.w1.e.a.b("fetch plugin success");
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            b.a.p0.a.w1.e.a.b("no package");
            this.f9194g.a(Boolean.FALSE);
        }
    }

    @Override // b.a.p0.q.f.i
    public void G(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.G(gVar);
        }
    }

    @Override // b.a.p0.q.f.i
    public e<i> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (e) invokeV.objValue;
    }
}
