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
/* loaded from: classes9.dex */
public interface e {

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Handler a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e f29817b;

        /* renamed from: c.i.b.a.j0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1671a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.y.d f29818e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f29819f;

            public RunnableC1671a(a aVar, c.i.b.a.y.d dVar) {
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
                this.f29819f = aVar;
                this.f29818e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29819f.f29817b.l(this.f29818e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f29820e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f29821f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f29822g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f29823h;

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
                this.f29823h = aVar;
                this.f29820e = str;
                this.f29821f = j2;
                this.f29822g = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29823h.f29817b.e(this.f29820e, this.f29821f, this.f29822g);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f29824e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f29825f;

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
                this.f29825f = aVar;
                this.f29824e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29825f.f29817b.h(this.f29824e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f29826e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f29827f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f29828g;

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
                this.f29828g = aVar;
                this.f29826e = i2;
                this.f29827f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29828g.f29817b.c(this.f29826e, this.f29827f);
                }
            }
        }

        /* renamed from: c.i.b.a.j0.e$a$e  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1672e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f29829e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f29830f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29831g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ float f29832h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f29833i;

            public RunnableC1672e(a aVar, int i2, int i3, int i4, float f2) {
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
                this.f29833i = aVar;
                this.f29829e = i2;
                this.f29830f = i3;
                this.f29831g = i4;
                this.f29832h = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29833i.f29817b.onVideoSizeChanged(this.f29829e, this.f29830f, this.f29831g, this.f29832h);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Surface f29834e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f29835f;

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
                this.f29835f = aVar;
                this.f29834e = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29835f.f29817b.f(this.f29834e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.y.d f29836e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f29837f;

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
                this.f29837f = aVar;
                this.f29836e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29836e.a();
                    this.f29837f.f29817b.j(this.f29836e);
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
            this.a = handler2;
            this.f29817b = eVar;
        }

        public void b(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new b(this, str, j2, j3));
        }

        public void c(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new g(this, dVar));
        }

        public void d(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new d(this, i2, j2));
        }

        public void e(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new RunnableC1671a(this, dVar));
        }

        public void f(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, format) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new c(this, format));
        }

        public void g(Surface surface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, surface) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new f(this, surface));
        }

        public void h(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f29817b == null) {
                return;
            }
            this.a.post(new RunnableC1672e(this, i2, i3, i4, f2));
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
