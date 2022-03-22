package c.a.v0.k.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class b implements c.a.v0.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.v0.k.e.d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.v0.k.e.c f21648b;

    public b(c.a.v0.k.e.d dVar, c.a.v0.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
        c.a.v0.k.e.c cVar = new c.a.v0.k.e.c();
        this.f21648b = cVar;
        cVar.k(aVar);
    }

    @Override // c.a.v0.k.e.b
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
            this.f21648b.m(downloadException);
            this.f21648b.r(108);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            this.f21648b.m(downloadException);
            this.f21648b.r(108);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21648b.r(107);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f21648b.s(j);
            this.f21648b.j(z);
            this.f21648b.r(103);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21648b.r(102);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21648b.r(107);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f21648b.r(105);
            this.f21648b.q(str);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21648b.r(106);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onDownloadProgress(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            this.f21648b.n(j);
            this.f21648b.o(j2);
            this.f21648b.p(i);
            this.f21648b.r(104);
            this.a.a(this.f21648b);
        }
    }

    @Override // c.a.v0.k.e.b
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21648b.r(101);
            this.f21648b.a().h();
        }
    }
}
