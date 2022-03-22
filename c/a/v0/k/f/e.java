package c.a.v0.k.f;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.k.e.e;
import c.a.v0.k.e.f;
import c.a.v0.k.e.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class e implements c.a.v0.k.e.f, g.a, e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.v0.k.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.v0.k.e.b f21655b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f21656c;

    /* renamed from: d  reason: collision with root package name */
    public String f21657d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.v0.k.a f21658e;

    /* renamed from: f  reason: collision with root package name */
    public f.a f21659f;

    /* renamed from: g  reason: collision with root package name */
    public int f21660g;

    /* renamed from: h  reason: collision with root package name */
    public a f21661h;
    public c.a.v0.k.e.g i;
    public List<c.a.v0.k.e.e> j;

    public e(c.a.v0.k.c cVar, c.a.v0.k.e.b bVar, Executor executor, String str, c.a.v0.k.a aVar, f.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, executor, str, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f21655b = bVar;
        this.f21656c = executor;
        this.f21657d = str;
        this.f21658e = aVar;
        this.f21659f = aVar2;
        g();
    }

    @Override // c.a.v0.k.e.e.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.f21660g = 108;
            this.f21655b.a(downloadException);
            m();
        }
    }

    @Override // c.a.v0.k.e.g.a
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
            } else if (this.i.isPaused()) {
                onDownloadPaused();
            } else {
                this.f21660g = 108;
                this.f21655b.b(downloadException);
                m();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            File file = new File(this.f21661h.a(), this.f21661h.d());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    @Override // c.a.v0.k.e.f
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.v0.k.e.g gVar = this.i;
            if (gVar != null) {
                gVar.cancel();
            }
            for (c.a.v0.k.e.e eVar : this.j) {
                eVar.cancel();
            }
            if (this.f21660g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f21660g = 104;
            h(j, z);
            for (c.a.v0.k.e.e eVar : this.j) {
                this.f21656c.execute(eVar);
            }
        }
    }

    public final List<i> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b2 = this.f21658e.b();
            int i = 0;
            while (i < b2) {
                long j2 = j / b2;
                long j3 = j2 * i;
                arrayList.add(new i(i, this.f21657d, this.a.c(), j3, i == b2 + (-1) ? j : (j2 + j3) - 1, 0L));
                i++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new i(0, this.f21657d, this.a.c(), 0L) : (i) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21661h = new a(this.a.b().toString(), this.a.c(), this.a.a());
            this.j = new LinkedList();
        }
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<i> e2 = e(j);
                int i = 0;
                for (i iVar : e2) {
                    i = (int) (i + iVar.b());
                }
                this.f21661h.f(i);
                for (i iVar2 : e2) {
                    this.j.add(new g(this.f21661h, iVar2, this));
                }
                return;
            }
            this.j.add(new h(this.f21661h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (c.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.k.e.f
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.f21660g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (c.a.v0.k.e.e eVar : this.j) {
                if (!eVar.isComplete()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            for (c.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (c.a.v0.k.e.e eVar : this.j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f21659f.a(this.f21657d, this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f fVar = new f(this.a.c(), this);
            this.i = fVar;
            this.f21656c.execute(fVar);
        }
    }

    @Override // c.a.v0.k.e.g.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.f21660g = 107;
            this.f21655b.onConnectCanceled();
            m();
        }
    }

    @Override // c.a.v0.k.e.g.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // c.a.v0.k.e.g.a
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
                return;
            }
            this.f21660g = 103;
            this.f21655b.onConnected(j, j2, z);
            this.f21661h.e(z);
            this.f21661h.g(j2);
            d(j2, z);
        }
    }

    @Override // c.a.v0.k.e.g.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f21660g = 102;
            this.f21655b.onConnecting();
        }
    }

    @Override // c.a.v0.k.e.e.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.f21660g = 107;
            this.f21655b.onDownloadCanceled();
            m();
        }
    }

    @Override // c.a.v0.k.e.e.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.f21660g = 105;
            this.f21655b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // c.a.v0.k.e.e.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.f21660g = 106;
            this.f21655b.onDownloadPaused();
            m();
        }
    }

    @Override // c.a.v0.k.e.e.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f21655b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // c.a.v0.k.e.f
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.v0.k.e.g gVar = this.i;
            if (gVar != null) {
                gVar.pause();
            }
            for (c.a.v0.k.e.e eVar : this.j) {
                eVar.pause();
            }
            if (this.f21660g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // c.a.v0.k.e.f
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f21660g = 101;
            this.f21655b.onStarted();
            n();
        }
    }
}
