package c.a.n0.a.x.m.r;

import c.a.n0.a.p2.q0;
import c.a.n0.a.x.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b D;

    /* renamed from: c.a.n0.a.x.m.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0555a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.k2.a f7300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7301c;

        public RunnableC0555a(a aVar, int i, c.a.n0.a.k2.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7301c = aVar;
            this.a = i;
            this.f7300b = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7301c.D == null) {
                return;
            }
            int i = this.a;
            if (i == -1) {
                this.f7301c.D.b(this.f7300b);
            } else if (i == 0) {
                this.f7301c.D.a();
            } else if (i != 1) {
            } else {
                this.f7301c.D.onSuccess();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(c.a.n0.a.k2.a aVar);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = bVar;
    }

    @Override // c.a.n0.a.x.m.g, c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(10L);
            aVar.c(bVar);
            K0(-1, aVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            J0(0);
        }
    }

    public final void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            K0(i, null);
        }
    }

    public final void K0(int i, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, aVar) == null) {
            q0.a0(new RunnableC0555a(this, i, aVar));
        }
    }

    @Override // c.a.n0.a.x.m.k
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.x.m.g
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.g
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.w0();
            c.a.n0.a.k2.a G0 = G0();
            if (G0 == null) {
                J0(1);
                B0("page_route_download", "0");
                return;
            }
            K0(-1, G0);
        }
    }

    @Override // c.a.n0.a.x.m.g
    public void x0(Throwable th) {
        c.a.n0.a.k2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                aVar = ((PkgDownloadError) th).getErrCode();
            } else {
                aVar = new c.a.n0.a.k2.a();
                aVar.k(10L);
                aVar.i(0L);
            }
            K0(-1, aVar);
        }
    }
}
