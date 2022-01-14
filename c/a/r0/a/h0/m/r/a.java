package c.a.r0.a.h0.m.r;

import c.a.r0.a.h0.m.g;
import c.a.r0.a.z2.q0;
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
    public b H;

    /* renamed from: c.a.r0.a.h0.m.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0389a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.u2.a f6719f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6720g;

        public RunnableC0389a(a aVar, int i2, c.a.r0.a.u2.a aVar2) {
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
            this.f6720g = aVar;
            this.f6718e = i2;
            this.f6719f = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f6720g.H == null) {
                return;
            }
            int i2 = this.f6718e;
            if (i2 == -1) {
                this.f6720g.H.b(this.f6719f);
            } else if (i2 == 0) {
                this.f6720g.H.a();
            } else if (i2 != 1) {
            } else {
                this.f6720g.H.onSuccess();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(c.a.r0.a.u2.a aVar);

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
        this.H = bVar;
    }

    @Override // c.a.r0.a.h0.m.g, c.a.r0.q.f.i
    public void D(c.a.r0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(10L);
            aVar.c(bVar);
            K0(-1, aVar);
        }
    }

    @Override // c.a.r0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            J0(0);
        }
    }

    public final void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            K0(i2, null);
        }
    }

    public final void K0(int i2, c.a.r0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) {
            q0.a0(new RunnableC0389a(this, i2, aVar));
        }
    }

    @Override // c.a.r0.a.h0.m.k
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.a.h0.m.g
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.m.g
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.w0();
            c.a.r0.a.u2.a G0 = G0();
            if (G0 == null) {
                J0(1);
                B0("page_route_download", "0");
                return;
            }
            K0(-1, G0);
        }
    }

    @Override // c.a.r0.a.h0.m.g
    public void x0(Throwable th) {
        c.a.r0.a.u2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                aVar = ((PkgDownloadError) th).getErrCode();
            } else {
                aVar = new c.a.r0.a.u2.a();
                aVar.k(10L);
                aVar.i(0L);
            }
            K0(-1, aVar);
        }
    }
}
