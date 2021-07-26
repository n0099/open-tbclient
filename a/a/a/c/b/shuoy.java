package a.a.a.c.b;

import a.a.a.c.a.ac;
import a.a.a.c.a.bv;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.b.b;
import d.a.m.b.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class shuoy implements d, ac.bv, bv.InterfaceC0007bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f1473a;

    /* renamed from: b  reason: collision with root package name */
    public ac f1474b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1475c;

    /* renamed from: d  reason: collision with root package name */
    public String f1476d;

    /* renamed from: e  reason: collision with root package name */
    public a.a.a.c.bv f1477e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1478f;

    /* renamed from: g  reason: collision with root package name */
    public int f1479g;

    /* renamed from: h  reason: collision with root package name */
    public bv f1480h;

    /* renamed from: i  reason: collision with root package name */
    public a.a.a.c.a.ac f1481i;
    public List<a.a.a.c.a.bv> j;

    public shuoy(b bVar, ac acVar, Executor executor, String str, a.a.a.c.bv bvVar, d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, acVar, executor, str, bvVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1473a = bVar;
        this.f1474b = acVar;
        this.f1475c = executor;
        this.f1476d = str;
        this.f1477e = bvVar;
        this.f1478f = aVar;
        this.f1480h = new bv(bVar.b().toString(), this.f1473a.c(), this.f1473a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bv bvVar = this.f1480h;
            File file = new File(bvVar.f1466b, bvVar.f1465a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            ac acVar = this.f1474b;
            acVar.f1460b.n(j);
            acVar.f1460b.o(j2);
            acVar.f1460b.p((int) ((100 * j) / j2));
            acVar.f1460b.r(104);
            acVar.f1459a.post(acVar.f1460b);
        }
    }

    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((adfad) this.f1481i).b()) {
                b();
                return;
            }
            if (((adfad) this.f1481i).f1463c == 106) {
                d();
                return;
            }
            this.f1479g = 108;
            ac acVar = this.f1474b;
            acVar.f1460b.m(downloadException);
            acVar.f1460b.r(108);
            acVar.f1459a.post(acVar.f1460b);
            onDestroy();
        }
    }

    public void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                if (((uiou) it.next()).f1489e != 105) {
                    z = false;
                    continue;
                }
                if (!z) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1479g = 105;
                ac acVar = this.f1474b;
                acVar.f1460b.r(105);
                acVar.f1460b.q(str);
                acVar.f1459a.post(acVar.f1460b);
                onDestroy();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f1479g = 107;
            ac acVar = this.f1474b;
            acVar.f1460b.r(107);
            acVar.f1459a.post(acVar.f1460b);
            onDestroy();
        }
    }

    public void b(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadException) == null) {
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((uiou) it.next()).d()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1479g = 108;
                ac acVar = this.f1474b;
                acVar.f1460b.m(downloadException);
                acVar.f1460b.r(108);
                acVar.f1459a.post(acVar.f1460b);
                onDestroy();
            }
        }
    }

    public void c() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((uiou) it.next()).d()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                a();
                this.f1479g = 107;
                ac acVar = this.f1474b;
                acVar.f1460b.r(107);
                acVar.f1459a.post(acVar.f1460b);
                onDestroy();
            }
        }
    }

    @Override // d.a.m.b.c.d
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a.a.a.c.a.ac acVar = this.f1481i;
            if (acVar != null) {
                ((adfad) acVar).f1463c = 107;
            }
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (it.hasNext()) {
                ((uiou) it.next()).f1490f = 107;
            }
            if (this.f1479g != 104) {
                c();
            }
        }
    }

    public void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((uiou) it.next()).d()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1479g = 106;
                ac acVar = this.f1474b;
                acVar.f1460b.r(106);
                acVar.f1459a.post(acVar.f1460b);
                onDestroy();
            }
        }
    }

    @Override // d.a.m.b.c.d
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f1479g;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f1478f.a(this.f1476d, this);
        }
    }

    @Override // d.a.m.b.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a.a.a.c.a.ac acVar = this.f1481i;
            if (acVar != null) {
                ((adfad) acVar).f1463c = 106;
            }
            Iterator<a.a.a.c.a.bv> it = this.j.iterator();
            while (it.hasNext()) {
                ((uiou) it.next()).f1490f = 106;
            }
            if (this.f1479g != 104) {
                d();
            }
        }
    }

    @Override // d.a.m.b.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1479g = 101;
            ac acVar = this.f1474b;
            acVar.f1460b.r(101);
            acVar.f1460b.a().onStarted();
            adfad adfadVar = new adfad(this.f1473a.c(), this);
            this.f1481i = adfadVar;
            this.f1475c.execute(adfadVar);
        }
    }
}
