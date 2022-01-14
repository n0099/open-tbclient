package c.a.a1.k.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes.dex */
public class b implements c.a.a1.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a1.k.e.d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a1.k.e.c f1247b;

    public b(c.a.a1.k.e.d dVar, c.a.a1.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
        c.a.a1.k.e.c cVar = new c.a.a1.k.e.c();
        this.f1247b = cVar;
        cVar.k(aVar);
    }

    @Override // c.a.a1.k.e.b
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
            this.f1247b.m(downloadException);
            this.f1247b.r(108);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            this.f1247b.m(downloadException);
            this.f1247b.r(108);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1247b.r(107);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onConnected(long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.f1247b.s(j2);
            this.f1247b.j(z);
            this.f1247b.r(103);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1247b.r(102);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f1247b.r(107);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f1247b.r(105);
            this.f1247b.q(str);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f1247b.r(106);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onDownloadProgress(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.f1247b.n(j2);
            this.f1247b.o(j3);
            this.f1247b.p(i2);
            this.f1247b.r(104);
            this.a.a(this.f1247b);
        }
    }

    @Override // c.a.a1.k.e.b
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1247b.r(101);
            this.f1247b.a().h();
        }
    }
}
