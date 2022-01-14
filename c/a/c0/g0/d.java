package c.a.c0.g0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1875b;

    /* renamed from: c  reason: collision with root package name */
    public long f1876c;

    /* renamed from: d  reason: collision with root package name */
    public long f1877d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1878e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1879f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1880g;

    /* renamed from: h  reason: collision with root package name */
    public c f1881h;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: i  reason: collision with root package name */
    public Handler f1882i;

    /* loaded from: classes.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.c0.g0.d.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.e();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.a.c(message);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            }
        }
    }

    public d(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1878e = false;
        this.f1879f = true;
        this.f1880g = false;
        this.f1881h = new a(this);
        this.f1882i = new b(this);
        this.a = j2;
        this.f1875b = j3;
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f1878e = true;
                this.f1882i.removeMessages(1);
                this.f1881h.a();
            }
        }
    }

    public final void c(Message message) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            synchronized (this) {
                if (!this.f1878e && !this.f1879f) {
                    long elapsedRealtime = this.f1876c - SystemClock.elapsedRealtime();
                    long j3 = 0;
                    if (elapsedRealtime <= 0) {
                        this.f1880g = true;
                        this.f1881h.b();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.f1881h.f(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < this.f1875b) {
                            j2 = elapsedRealtime - elapsedRealtime3;
                            if (j2 < 0) {
                                this.f1882i.sendMessageDelayed(this.f1882i.obtainMessage(1), j3);
                            }
                        } else {
                            j2 = this.f1875b - elapsedRealtime3;
                            while (j2 < 0) {
                                j2 += this.f1875b;
                            }
                        }
                        j3 = j2;
                        this.f1882i.sendMessageDelayed(this.f1882i.obtainMessage(1), j3);
                    }
                }
            }
        }
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!this.f1879f && !this.f1878e && !this.f1880g) {
                    this.f1877d = SystemClock.elapsedRealtime();
                    this.f1879f = true;
                    this.f1881h.c();
                    this.f1882i.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f1879f && !this.f1878e && !this.f1880g) {
                    this.f1879f = false;
                    this.f1876c = SystemClock.elapsedRealtime() + (this.f1876c - this.f1877d);
                    this.f1881h.d();
                    this.f1882i.sendMessage(this.f1882i.obtainMessage(1));
                }
            }
        }
    }

    public d f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar != null) {
                this.f1881h = cVar;
            }
            return this;
        }
        return (d) invokeL.objValue;
    }

    public final synchronized d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                this.f1878e = false;
                if (this.a <= 0) {
                    this.f1880g = true;
                    this.f1881h.b();
                    return this;
                }
                this.f1880g = false;
                this.f1879f = false;
                this.f1876c = SystemClock.elapsedRealtime() + this.a;
                this.f1882i.sendMessage(this.f1882i.obtainMessage(1));
                this.f1881h.e();
                return this;
            }
        }
        return (d) invokeV.objValue;
    }
}
