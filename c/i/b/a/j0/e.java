package c.i.b.a.j0;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public interface e {

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Handler f33925a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e f33926b;

        /* renamed from: c.i.b.a.j0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1499a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.y.d f33927e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33928f;

            public RunnableC1499a(a aVar, c.i.b.a.y.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33928f = aVar;
                this.f33927e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33928f.f33926b.l(this.f33927e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f33929e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f33930f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f33931g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f33932h;

            public b(a aVar, String str, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33932h = aVar;
                this.f33929e = str;
                this.f33930f = j2;
                this.f33931g = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33932h.f33926b.e(this.f33929e, this.f33930f, this.f33931g);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f33933e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33934f;

            public c(a aVar, Format format) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, format};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33934f = aVar;
                this.f33933e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33934f.f33926b.h(this.f33933e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33935e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f33936f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f33937g;

            public d(a aVar, int i2, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33937g = aVar;
                this.f33935e = i2;
                this.f33936f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33937g.f33926b.c(this.f33935e, this.f33936f);
                }
            }
        }

        /* renamed from: c.i.b.a.j0.e$a$e  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1500e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33938e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33939f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33940g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ float f33941h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f33942i;

            public RunnableC1500e(a aVar, int i2, int i3, int i4, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33942i = aVar;
                this.f33938e = i2;
                this.f33939f = i3;
                this.f33940g = i4;
                this.f33941h = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33942i.f33926b.onVideoSizeChanged(this.f33938e, this.f33939f, this.f33940g, this.f33941h);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Surface f33943e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33944f;

            public f(a aVar, Surface surface) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, surface};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33944f = aVar;
                this.f33943e = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33944f.f33926b.f(this.f33943e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.y.d f33945e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33946f;

            public g(a aVar, c.i.b.a.y.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33946f = aVar;
                this.f33945e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33945e.a();
                    this.f33946f.f33926b.j(this.f33945e);
                }
            }
        }

        public a(@Nullable Handler handler, @Nullable e eVar) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (eVar != null) {
                c.i.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f33925a = handler2;
            this.f33926b = eVar;
        }

        public void b(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new b(this, str, j2, j3));
        }

        public void c(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new g(this, dVar));
        }

        public void d(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new d(this, i2, j2));
        }

        public void e(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new RunnableC1499a(this, dVar));
        }

        public void f(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, format) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new c(this, format));
        }

        public void g(Surface surface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, surface) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new f(this, surface));
        }

        public void h(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f33926b == null) {
                return;
            }
            this.f33925a.post(new RunnableC1500e(this, i2, i3, i4, f2));
        }
    }

    void c(int i2, long j2);

    void e(String str, long j2, long j3);

    void f(Surface surface);

    void h(Format format);

    void j(c.i.b.a.y.d dVar);

    void l(c.i.b.a.y.d dVar);

    void onVideoSizeChanged(int i2, int i3, int i4, float f2);
}
