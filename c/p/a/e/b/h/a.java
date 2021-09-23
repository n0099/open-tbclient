package c.p.a.e.b.h;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.e;
import c.p.a.e.b.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f35170a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35171b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35172c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35173d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f35174e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.e.b.i.a f35175f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.e.b.i.a f35176g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.i.a f35177h;

    /* renamed from: i  reason: collision with root package name */
    public c.p.a.e.b.i.a f35178i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.i.a f35179j;
    public c.p.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Runnable q;

    /* renamed from: c.p.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1548a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f35180e;

        public RunnableC1548a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35180e = aVar;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            c.p.a.e.b.i.a k;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                do {
                    try {
                        k = this.f35180e.k();
                        k.f35185c = this.f35180e.f35170a.read(k.f35183a);
                        this.f35180e.j(k);
                    } catch (Throwable th) {
                        try {
                            this.f35180e.n = th;
                            th.printStackTrace();
                            synchronized (this.f35180e.f35174e) {
                                this.f35180e.m = true;
                                this.f35180e.f35174e.notify();
                                f.E(this.f35180e.f35170a);
                                return;
                            }
                        } catch (Throwable th2) {
                            synchronized (this.f35180e.f35174e) {
                                this.f35180e.m = true;
                                this.f35180e.f35174e.notify();
                                f.E(this.f35180e.f35170a);
                                throw th2;
                            }
                        }
                    }
                } while (k.f35185c != -1);
                synchronized (this.f35180e.f35174e) {
                    this.f35180e.m = true;
                    this.f35180e.f35174e.notify();
                }
                f.E(this.f35180e.f35170a);
            }
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35173d = new Object();
        this.f35174e = new Object();
        this.q = new RunnableC1548a(this);
        this.f35170a = inputStream;
        this.f35171b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f35172c = i3;
        i();
    }

    @Override // c.p.a.e.b.h.b
    public c.p.a.e.b.i.a a() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l() : (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final void g(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f35173d) {
                c.p.a.e.b.i.a aVar2 = this.f35176g;
                if (aVar2 == null) {
                    this.f35176g = aVar;
                    this.f35175f = aVar;
                    this.f35173d.notify();
                } else {
                    aVar2.f35186d = aVar;
                    this.f35176g = aVar;
                }
            }
        }
    }

    public final void i() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = e.F0().submit(this.q);
        }
    }

    public final void j(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this.f35174e) {
                c.p.a.e.b.i.a aVar2 = this.f35179j;
                if (aVar2 == null) {
                    this.f35179j = aVar;
                    this.f35178i = aVar;
                    this.f35174e.notify();
                } else {
                    aVar2.f35186d = aVar;
                    this.f35179j = aVar;
                }
            }
        }
    }

    public final c.p.a.e.b.i.a k() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.p.a.e.b.i.a aVar = this.f35177h;
            if (aVar != null) {
                if (!this.l) {
                    this.f35177h = aVar.f35186d;
                    aVar.f35186d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f35173d) {
                if (!this.l) {
                    c.p.a.e.b.i.a aVar2 = this.f35175f;
                    if (aVar2 == null && this.p < this.f35172c) {
                        this.p++;
                        return new c.p.a.e.b.i.a(this.f35171b);
                    }
                    while (aVar2 == null) {
                        this.f35173d.wait();
                        if (!this.l) {
                            aVar2 = this.f35175f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f35177h = aVar2.f35186d;
                    this.f35176g = null;
                    this.f35175f = null;
                    aVar2.f35186d = null;
                    return aVar2;
                }
                throw new p("");
            }
        }
        return (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final c.p.a.e.b.i.a l() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        c.p.a.e.b.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.p.a.e.b.i.a aVar2 = this.k;
            if (aVar2 != null) {
                this.k = aVar2.f35186d;
                aVar2.f35186d = null;
                return aVar2;
            }
            synchronized (this.f35174e) {
                aVar = this.f35178i;
                if (aVar == null) {
                    while (!this.m) {
                        this.f35174e.wait();
                        aVar = this.f35178i;
                        if (aVar != null) {
                        }
                    }
                    m();
                    throw null;
                }
                this.k = aVar.f35186d;
                this.f35179j = null;
                this.f35178i = null;
                aVar.f35186d = null;
            }
            return aVar;
        }
        return (c.p.a.e.b.i.a) invokeV.objValue;
    }

    public final void m() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Throwable th = this.n;
            if (th != null) {
                if (th instanceof p) {
                    throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
                }
                f.B(th, "async_read");
                throw null;
            }
            throw new BaseException(1069, "async reader terminated!");
        }
    }

    @Override // c.p.a.e.b.h.b
    public void a(c.p.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            g(aVar);
        }
    }

    @Override // c.p.a.e.b.h.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f35173d) {
                this.l = true;
                this.f35173d.notify();
            }
            Future future = this.o;
            if (future != null) {
                try {
                    future.cancel(true);
                } catch (Throwable unused) {
                }
                this.o = null;
            }
        }
    }
}
