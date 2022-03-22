package c.a.p0.x.g.h;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.e;
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
/* loaded from: classes3.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final String f20616f = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.x.g.c f20617b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f20618c;

    /* renamed from: d  reason: collision with root package name */
    public int f20619d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f20620e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1021443433, "Lc/a/p0/x/g/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1021443433, "Lc/a/p0/x/g/h/a;");
        }
    }

    public a(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadCacheKey};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f20619d = 0;
        this.f20620e = new HashSet();
        this.f20618c = downloadCacheKey;
        this.f20617b = new c.a.p0.x.g.c();
    }

    @Override // c.a.p0.x.g.h.c
    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || this.f20618c == null) {
            return;
        }
        if (e.e()) {
            String str2 = f20616f;
            Log.e(str2, str + " pause download");
        }
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(this.f20618c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.c(this.f20618c, b2.getPercent());
        }
    }

    @Override // c.a.p0.x.g.h.c
    public void b(String str, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) || this.f20618c == null) {
            return;
        }
        if (e.e()) {
            String str2 = f20616f;
            Log.e(str2, str + " stop download");
        }
        c.a.p0.x.g.e.d().b(this.f20618c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.f(this.f20618c, stopStatus);
        }
    }

    @Override // c.a.p0.x.g.h.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f20618c == null) {
            return;
        }
        if (e.e()) {
            String str2 = f20616f;
            Log.e(str2, str + " start downloading");
        }
        c.a.p0.x.g.e.d().b(this.f20618c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.e(this.f20618c);
        }
    }

    @Override // c.a.p0.x.g.h.c
    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) || this.f20618c == null) {
            return;
        }
        if (e.e()) {
            String str2 = f20616f;
            Log.e(str2, str + " downloading: " + String.valueOf(i));
        }
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(this.f20618c);
        b2.extra().setPercent(i);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.g(this.f20618c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            synchronized (this.a) {
                add = this.f20620e.add(dVar);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20620e.isEmpty() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f20618c == null) {
            return;
        }
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(this.f20618c);
        this.f20617b.b(710, this.f20618c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.b(this.f20618c);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f20618c == null) {
            return;
        }
        c.a.p0.x.g.e.d().b(this.f20618c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.d(this.f20618c);
        }
    }

    public boolean i(d dVar) {
        InterceptResult invokeL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            synchronized (this.a) {
                remove = this.f20620e.remove(dVar);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    public void j(int i, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, adDownloadData}) == null) {
            this.f20617b.b(i, str, str2, adDownloadData);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f20619d = i;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20619d : invokeV.intValue;
    }

    @Override // c.a.p0.x.g.h.c
    public void onSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.f20618c == null) {
            return;
        }
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(this.f20618c);
        this.f20617b.b(704, this.f20618c.mPackageName, b2.getExtInfo(), b2);
        if (e.e()) {
            String str3 = f20616f;
            Log.e(str3, str + " download succeed");
        }
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        c.a.p0.x.g.e.d().b(this.f20618c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f20620e) {
            dVar.a(this.f20618c, str2, false);
        }
    }
}
