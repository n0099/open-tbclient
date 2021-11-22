package b.h.b.a.j0;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public interface e {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Handler f33575a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e f33576b;

        /* renamed from: b.h.b.a.j0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1535a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.y.d f33577e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33578f;

            public RunnableC1535a(a aVar, b.h.b.a.y.d dVar) {
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
                this.f33578f = aVar;
                this.f33577e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33578f.f33576b.l(this.f33577e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f33579e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f33580f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f33581g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f33582h;

            public b(a aVar, String str, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33582h = aVar;
                this.f33579e = str;
                this.f33580f = j;
                this.f33581g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33582h.f33576b.e(this.f33579e, this.f33580f, this.f33581g);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f33583e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33584f;

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
                this.f33584f = aVar;
                this.f33583e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33584f.f33576b.h(this.f33583e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33585e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f33586f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f33587g;

            public d(a aVar, int i2, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33587g = aVar;
                this.f33585e = i2;
                this.f33586f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33587g.f33576b.c(this.f33585e, this.f33586f);
                }
            }
        }

        /* renamed from: b.h.b.a.j0.e$a$e  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1536e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33588e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33589f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33590g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ float f33591h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f33592i;

            public RunnableC1536e(a aVar, int i2, int i3, int i4, float f2) {
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
                this.f33592i = aVar;
                this.f33588e = i2;
                this.f33589f = i3;
                this.f33590g = i4;
                this.f33591h = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33592i.f33576b.onVideoSizeChanged(this.f33588e, this.f33589f, this.f33590g, this.f33591h);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Surface f33593e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33594f;

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
                this.f33594f = aVar;
                this.f33593e = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33594f.f33576b.f(this.f33593e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.y.d f33595e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33596f;

            public g(a aVar, b.h.b.a.y.d dVar) {
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
                this.f33596f = aVar;
                this.f33595e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33595e.a();
                    this.f33596f.f33576b.j(this.f33595e);
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
                b.h.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f33575a = handler2;
            this.f33576b = eVar;
        }

        public void b(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new b(this, str, j, j2));
        }

        public void c(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new g(this, dVar));
        }

        public void d(int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new d(this, i2, j));
        }

        public void e(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new RunnableC1535a(this, dVar));
        }

        public void f(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, format) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new c(this, format));
        }

        public void g(Surface surface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, surface) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new f(this, surface));
        }

        public void h(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f33576b == null) {
                return;
            }
            this.f33575a.post(new RunnableC1536e(this, i2, i3, i4, f2));
        }
    }

    void c(int i2, long j);

    void e(String str, long j, long j2);

    void f(Surface surface);

    void h(Format format);

    void j(b.h.b.a.y.d dVar);

    void l(b.h.b.a.y.d dVar);

    void onVideoSizeChanged(int i2, int i3, int i4, float f2);
}
