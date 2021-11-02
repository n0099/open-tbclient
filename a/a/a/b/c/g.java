package a.a.a.b.c;

import a.a.a.b.a.a;
import a.a.a.b.a.b;
import androidx.core.view.InputDeviceCompat;
import b.a.a.c.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class g implements b.a.a.c.c.d, a.InterfaceC0000a, b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.a.c.b f1033a;

    /* renamed from: b  reason: collision with root package name */
    public a f1034b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1035c;

    /* renamed from: d  reason: collision with root package name */
    public String f1036d;

    /* renamed from: e  reason: collision with root package name */
    public a.a.a.b.d f1037e;

    /* renamed from: f  reason: collision with root package name */
    public d.a f1038f;

    /* renamed from: g  reason: collision with root package name */
    public int f1039g;

    /* renamed from: h  reason: collision with root package name */
    public c f1040h;

    /* renamed from: i  reason: collision with root package name */
    public a.a.a.b.a.a f1041i;
    public List<a.a.a.b.a.b> j;

    public g(b.a.a.c.b bVar, a aVar, Executor executor, String str, a.a.a.b.d dVar, d.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, executor, str, dVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1033a = bVar;
        this.f1034b = aVar;
        this.f1035c = executor;
        this.f1036d = str;
        this.f1037e = dVar;
        this.f1038f = aVar2;
        this.f1040h = new c(bVar.b().toString(), this.f1033a.c(), this.f1033a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.f1040h;
            File file = new File(cVar.f1026b, cVar.f1025a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a aVar = this.f1034b;
            aVar.f1020b.n(j);
            aVar.f1020b.o(j2);
            aVar.f1020b.p((int) ((100 * j) / j2));
            aVar.f1020b.r(104);
            aVar.f1019a.a(aVar.f1020b);
        }
    }

    public void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((b) this.f1041i).d()) {
                e();
                return;
            }
            if (((b) this.f1041i).f1023g == 106) {
                h();
                return;
            }
            this.f1039g = 108;
            a aVar = this.f1034b;
            aVar.f1020b.m(downloadException);
            aVar.f1020b.r(108);
            aVar.f1019a.a(aVar.f1020b);
            i();
        }
    }

    @Override // b.a.a.c.c.d
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.b.a.a aVar = this.f1041i;
            if (aVar != null) {
                ((b) aVar).f1023g = 107;
            }
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).j = 107;
            }
            if (this.f1039g != 104) {
                g();
            }
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((i) it.next()).f1050i != 105) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            if (z) {
                this.f1039g = 105;
                a aVar = this.f1034b;
                aVar.f1020b.r(105);
                aVar.f1020b.q(str);
                aVar.f1019a.a(aVar.f1020b);
                i();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.f1039g = 107;
            a aVar = this.f1034b;
            aVar.f1020b.r(107);
            aVar.f1019a.a(aVar.f1020b);
            i();
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1039g = 108;
                a aVar = this.f1034b;
                aVar.f1020b.m(downloadException);
                aVar.f1020b.r(108);
                aVar.f1019a.a(aVar.f1020b);
                i();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                a();
                this.f1039g = 107;
                a aVar = this.f1034b;
                aVar.f1020b.r(107);
                aVar.f1019a.a(aVar.f1020b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((i) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f1039g = 106;
                a aVar = this.f1034b;
                aVar.f1020b.r(106);
                aVar.f1019a.a(aVar.f1020b);
                i();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f1038f.a(this.f1036d, this);
        }
    }

    @Override // b.a.a.c.c.d
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f1039g;
            return i2 == 101 || i2 == 102 || i2 == 103 || i2 == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.a.c.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a.a.a.b.a.a aVar = this.f1041i;
            if (aVar != null) {
                ((b) aVar).f1023g = 106;
            }
            Iterator<a.a.a.b.a.b> it = this.j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).j = 106;
            }
            if (this.f1039g != 104) {
                h();
            }
        }
    }

    @Override // b.a.a.c.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1039g = 101;
            a aVar = this.f1034b;
            aVar.f1020b.r(101);
            aVar.f1020b.a().h();
            b bVar = new b(this.f1033a.c(), this);
            this.f1041i = bVar;
            this.f1035c.execute(bVar);
        }
    }
}
