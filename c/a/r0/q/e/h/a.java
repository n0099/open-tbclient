package c.a.r0.q.e.h;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.q.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f24128a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.q.e.c f24129b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f24130c;

    /* renamed from: d  reason: collision with root package name */
    public int f24131d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f24132e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1944488044, "Lc/a/r0/q/e/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1944488044, "Lc/a/r0/q/e/h/a;");
        }
    }

    public a(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadCacheKey};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24128a = new Object();
        this.f24131d = 0;
        this.f24132e = new HashSet();
        this.f24130c = downloadCacheKey;
        this.f24129b = new c.a.r0.q.e.c();
    }

    @Override // c.a.r0.q.e.h.c
    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || this.f24130c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f24130c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.c(this.f24130c, b2.getPercent());
        }
    }

    @Override // c.a.r0.q.e.h.c
    public void b(String str, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) || this.f24130c == null) {
            return;
        }
        e.c().b(this.f24130c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.f(this.f24130c, stopStatus);
        }
    }

    @Override // c.a.r0.q.e.h.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f24130c == null) {
            return;
        }
        e.c().b(this.f24130c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.e(this.f24130c);
        }
    }

    @Override // c.a.r0.q.e.h.c
    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) || this.f24130c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f24130c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.g(this.f24130c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            synchronized (this.f24128a) {
                add = this.f24132e.add(dVar);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24132e.isEmpty() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f24130c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f24130c);
        this.f24129b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f24130c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.b(this.f24130c);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f24130c == null) {
            return;
        }
        e.c().b(this.f24130c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.d(this.f24130c);
        }
    }

    public boolean i(d dVar) {
        InterceptResult invokeL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            synchronized (this.f24128a) {
                remove = this.f24132e.remove(dVar);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, adDownloadData}) == null) {
            this.f24129b.b(i2, str, str2, adDownloadData);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f24131d = i2;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f24131d : invokeV.intValue;
    }

    @Override // c.a.r0.q.e.h.c
    public void onSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.f24130c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f24130c);
        this.f24129b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f24130c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        e.c().b(this.f24130c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f24132e) {
            dVar.a(this.f24130c, str2, false);
        }
    }
}
