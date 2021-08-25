package c.a.o0.a.h0.m.o;

import c.a.o0.a.h0.m.f;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b F;

    /* renamed from: c.a.o0.a.h0.m.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0232a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.q2.a f6226f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6227g;

        public RunnableC0232a(a aVar, int i2, c.a.o0.a.q2.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6227g = aVar;
            this.f6225e = i2;
            this.f6226f = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f6227g.F == null) {
                return;
            }
            int i2 = this.f6225e;
            if (i2 == -1) {
                this.f6227g.F.b(this.f6226f);
            } else if (i2 == 0) {
                this.f6227g.F.a();
            } else if (i2 != 1) {
            } else {
                this.f6227g.F.onSuccess();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(c.a.o0.a.q2.a aVar);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, b bVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = bVar;
    }

    @Override // c.a.o0.a.h0.m.f, c.a.o0.n.f.g
    public void B(c.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            c.a.o0.a.q2.a aVar2 = new c.a.o0.a.q2.a();
            aVar2.j(10L);
            aVar2.h(aVar.f11847a);
            aVar2.c(aVar.f11848b);
            aVar2.p(aVar.f11849c);
            G0(-1, aVar2);
        }
    }

    @Override // c.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            F0(0);
        }
    }

    public final void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            G0(i2, null);
        }
    }

    public final void G0(int i2, c.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) {
            q0.X(new RunnableC0232a(this, i2, aVar));
        }
    }

    @Override // c.a.o0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.a.h0.m.f
    public PMSDownloadType h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.m.f
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.s0();
            c.a.o0.a.q2.a C0 = C0();
            if (C0 == null) {
                F0(1);
                x0("page_route_download", "0");
                return;
            }
            G0(-1, C0);
        }
    }

    @Override // c.a.o0.a.h0.m.f
    public void t0(Throwable th) {
        c.a.o0.a.q2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                aVar = ((PkgDownloadError) th).getErrCode();
            } else {
                aVar = new c.a.o0.a.q2.a();
                aVar.j(10L);
                aVar.h(0L);
            }
            G0(-1, aVar);
        }
    }
}
