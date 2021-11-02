package b.a.x0.k.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes6.dex */
public class b implements b.a.x0.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.x0.k.e.d f29650a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.x0.k.e.c f29651b;

    public b(b.a.x0.k.e.d dVar, b.a.x0.k.e.a aVar) {
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
        this.f29650a = dVar;
        b.a.x0.k.e.c cVar = new b.a.x0.k.e.c();
        this.f29651b = cVar;
        cVar.k(aVar);
    }

    @Override // b.a.x0.k.e.b
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
            this.f29651b.m(downloadException);
            this.f29651b.r(108);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            this.f29651b.m(downloadException);
            this.f29651b.r(108);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29651b.r(107);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f29651b.s(j);
            this.f29651b.j(z);
            this.f29651b.r(103);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29651b.r(102);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29651b.r(107);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f29651b.r(105);
            this.f29651b.q(str);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f29651b.r(106);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onDownloadProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f29651b.n(j);
            this.f29651b.o(j2);
            this.f29651b.p(i2);
            this.f29651b.r(104);
            this.f29650a.a(this.f29651b);
        }
    }

    @Override // b.a.x0.k.e.b
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f29651b.r(101);
            this.f29651b.a().h();
        }
    }
}
