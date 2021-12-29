package c.a.a1.k.f;

import androidx.core.view.InputDeviceCompat;
import c.a.a1.k.e.e;
import c.a.a1.k.e.f;
import c.a.a1.k.e.g;
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
/* loaded from: classes.dex */
public class e implements c.a.a1.k.e.f, g.a, e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a1.k.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a1.k.e.b f1262b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1263c;

    /* renamed from: d  reason: collision with root package name */
    public String f1264d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.a1.k.a f1265e;

    /* renamed from: f  reason: collision with root package name */
    public f.a f1266f;

    /* renamed from: g  reason: collision with root package name */
    public int f1267g;

    /* renamed from: h  reason: collision with root package name */
    public a f1268h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.a1.k.e.g f1269i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.a1.k.e.e> f1270j;

    public e(c.a.a1.k.c cVar, c.a.a1.k.e.b bVar, Executor executor, String str, c.a.a1.k.a aVar, f.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, executor, str, aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f1262b = bVar;
        this.f1263c = executor;
        this.f1264d = str;
        this.f1265e = aVar;
        this.f1266f = aVar2;
        g();
    }

    @Override // c.a.a1.k.e.e.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.f1267g = 108;
            this.f1262b.a(downloadException);
            m();
        }
    }

    @Override // c.a.a1.k.e.g.a
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            if (this.f1269i.isCanceled()) {
                onConnectCanceled();
            } else if (this.f1269i.isPaused()) {
                onDownloadPaused();
            } else {
                this.f1267g = 108;
                this.f1262b.b(downloadException);
                m();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            File file = new File(this.f1268h.a(), this.f1268h.d());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    @Override // c.a.a1.k.e.f
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.a1.k.e.g gVar = this.f1269i;
            if (gVar != null) {
                gVar.cancel();
            }
            for (c.a.a1.k.e.e eVar : this.f1270j) {
                eVar.cancel();
            }
            if (this.f1267g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void d(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f1267g = 104;
            h(j2, z);
            for (c.a.a1.k.e.e eVar : this.f1270j) {
                this.f1263c.execute(eVar);
            }
        }
    }

    public final List<i> e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            ArrayList arrayList = new ArrayList();
            int b2 = this.f1265e.b();
            int i2 = 0;
            while (i2 < b2) {
                long j3 = j2 / b2;
                long j4 = j3 * i2;
                arrayList.add(new i(i2, this.f1264d, this.a.c(), j4, i2 == b2 + (-1) ? j2 : (j3 + j4) - 1, 0L));
                i2++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new i(0, this.f1264d, this.a.c(), 0L) : (i) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f1268h = new a(this.a.b().toString(), this.a.c(), this.a.a());
            this.f1270j = new LinkedList();
        }
    }

    public final void h(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f1270j.clear();
            if (z) {
                List<i> e2 = e(j2);
                int i2 = 0;
                for (i iVar : e2) {
                    i2 = (int) (i2 + iVar.b());
                }
                this.f1268h.f(i2);
                for (i iVar2 : e2) {
                    this.f1270j.add(new g(this.f1268h, iVar2, this));
                }
                return;
            }
            this.f1270j.add(new h(this.f1268h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (c.a.a1.k.e.e eVar : this.f1270j) {
                if (eVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.k.e.f
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f1267g;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (c.a.a1.k.e.e eVar : this.f1270j) {
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
            for (c.a.a1.k.e.e eVar : this.f1270j) {
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
            for (c.a.a1.k.e.e eVar : this.f1270j) {
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
            this.f1266f.a(this.f1264d, this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f fVar = new f(this.a.c(), this);
            this.f1269i = fVar;
            this.f1263c.execute(fVar);
        }
    }

    @Override // c.a.a1.k.e.g.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.f1267g = 107;
            this.f1262b.onConnectCanceled();
            m();
        }
    }

    @Override // c.a.a1.k.e.g.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // c.a.a1.k.e.g.a
    public void onConnected(long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            if (this.f1269i.isCanceled()) {
                onConnectCanceled();
                return;
            }
            this.f1267g = 103;
            this.f1262b.onConnected(j2, j3, z);
            this.f1268h.e(z);
            this.f1268h.g(j3);
            d(j3, z);
        }
    }

    @Override // c.a.a1.k.e.g.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f1267g = 102;
            this.f1262b.onConnecting();
        }
    }

    @Override // c.a.a1.k.e.e.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.f1267g = 107;
            this.f1262b.onDownloadCanceled();
            m();
        }
    }

    @Override // c.a.a1.k.e.e.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.f1267g = 105;
            this.f1262b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // c.a.a1.k.e.e.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.f1267g = 106;
            this.f1262b.onDownloadPaused();
            m();
        }
    }

    @Override // c.a.a1.k.e.e.a
    public void onDownloadProgress(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f1262b.onDownloadProgress(j2, j3, (int) ((100 * j2) / j3));
        }
    }

    @Override // c.a.a1.k.e.f
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.a1.k.e.g gVar = this.f1269i;
            if (gVar != null) {
                gVar.pause();
            }
            for (c.a.a1.k.e.e eVar : this.f1270j) {
                eVar.pause();
            }
            if (this.f1267g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // c.a.a1.k.e.f
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f1267g = 101;
            this.f1262b.onStarted();
            n();
        }
    }
}
