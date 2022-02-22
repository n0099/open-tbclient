package c.a.u0.v.g.h;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.e;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes9.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.u0.v.g.c f24383b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f24384c;

    /* renamed from: d  reason: collision with root package name */
    public int f24385d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f24386e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1435967856, "Lc/a/u0/v/g/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1435967856, "Lc/a/u0/v/g/h/a;");
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
        this.a = new Object();
        this.f24385d = 0;
        this.f24386e = new HashSet();
        this.f24384c = downloadCacheKey;
        this.f24383b = new c.a.u0.v.g.c();
    }

    @Override // c.a.u0.v.g.h.c
    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || this.f24384c == null) {
            return;
        }
        if (e.e()) {
            String str2 = str + " pause download";
        }
        AdDownloadData b2 = c.a.u0.v.g.e.d().b(this.f24384c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.c(this.f24384c, b2.getPercent());
        }
    }

    @Override // c.a.u0.v.g.h.c
    public void b(String str, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) || this.f24384c == null) {
            return;
        }
        if (e.e()) {
            String str2 = str + " stop download";
        }
        c.a.u0.v.g.e.d().b(this.f24384c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.f(this.f24384c, stopStatus);
        }
    }

    @Override // c.a.u0.v.g.h.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f24384c == null) {
            return;
        }
        if (e.e()) {
            String str2 = str + " start downloading";
        }
        c.a.u0.v.g.e.d().b(this.f24384c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.e(this.f24384c);
        }
    }

    @Override // c.a.u0.v.g.h.c
    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) || this.f24384c == null) {
            return;
        }
        if (e.e()) {
            String str2 = str + " downloading: " + String.valueOf(i2);
        }
        AdDownloadData b2 = c.a.u0.v.g.e.d().b(this.f24384c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.g(this.f24384c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            synchronized (this.a) {
                add = this.f24386e.add(dVar);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24386e.isEmpty() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f24384c == null) {
            return;
        }
        AdDownloadData b2 = c.a.u0.v.g.e.d().b(this.f24384c);
        this.f24383b.b(710, this.f24384c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.b(this.f24384c);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f24384c == null) {
            return;
        }
        c.a.u0.v.g.e.d().b(this.f24384c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.d(this.f24384c);
        }
    }

    public boolean i(d dVar) {
        InterceptResult invokeL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            synchronized (this.a) {
                remove = this.f24386e.remove(dVar);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, adDownloadData}) == null) {
            this.f24383b.b(i2, str, str2, adDownloadData);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f24385d = i2;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f24385d : invokeV.intValue;
    }

    @Override // c.a.u0.v.g.h.c
    public void onSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.f24384c == null) {
            return;
        }
        AdDownloadData b2 = c.a.u0.v.g.e.d().b(this.f24384c);
        this.f24383b.b(704, this.f24384c.mPackageName, b2.getExtInfo(), b2);
        if (e.e()) {
            String str3 = str + " download succeed";
        }
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        c.a.u0.v.g.e.d().b(this.f24384c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f24386e) {
            dVar.a(this.f24384c, str2, false);
        }
    }
}
