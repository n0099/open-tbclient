package b.i.b.a.j0;

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
        public final Handler f32717a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e f32718b;

        /* renamed from: b.i.b.a.j0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1493a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.y.d f32719e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32720f;

            public RunnableC1493a(a aVar, b.i.b.a.y.d dVar) {
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
                this.f32720f = aVar;
                this.f32719e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32720f.f32718b.l(this.f32719e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f32721e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f32722f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f32723g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f32724h;

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
                this.f32724h = aVar;
                this.f32721e = str;
                this.f32722f = j;
                this.f32723g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32724h.f32718b.e(this.f32721e, this.f32722f, this.f32723g);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f32725e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32726f;

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
                this.f32726f = aVar;
                this.f32725e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32726f.f32718b.h(this.f32725e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32727e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f32728f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f32729g;

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
                this.f32729g = aVar;
                this.f32727e = i2;
                this.f32728f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32729g.f32718b.c(this.f32727e, this.f32728f);
                }
            }
        }

        /* renamed from: b.i.b.a.j0.e$a$e  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1494e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32730e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32731f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32732g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ float f32733h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f32734i;

            public RunnableC1494e(a aVar, int i2, int i3, int i4, float f2) {
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
                this.f32734i = aVar;
                this.f32730e = i2;
                this.f32731f = i3;
                this.f32732g = i4;
                this.f32733h = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32734i.f32718b.onVideoSizeChanged(this.f32730e, this.f32731f, this.f32732g, this.f32733h);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Surface f32735e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32736f;

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
                this.f32736f = aVar;
                this.f32735e = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32736f.f32718b.f(this.f32735e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.y.d f32737e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32738f;

            public g(a aVar, b.i.b.a.y.d dVar) {
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
                this.f32738f = aVar;
                this.f32737e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32737e.a();
                    this.f32738f.f32718b.j(this.f32737e);
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
                b.i.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f32717a = handler2;
            this.f32718b = eVar;
        }

        public void b(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new b(this, str, j, j2));
        }

        public void c(b.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new g(this, dVar));
        }

        public void d(int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new d(this, i2, j));
        }

        public void e(b.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new RunnableC1493a(this, dVar));
        }

        public void f(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, format) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new c(this, format));
        }

        public void g(Surface surface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, surface) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new f(this, surface));
        }

        public void h(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f32718b == null) {
                return;
            }
            this.f32717a.post(new RunnableC1494e(this, i2, i3, i4, f2));
        }
    }

    void c(int i2, long j);

    void e(String str, long j, long j2);

    void f(Surface surface);

    void h(Format format);

    void j(b.i.b.a.y.d dVar);

    void l(b.i.b.a.y.d dVar);

    void onVideoSizeChanged(int i2, int i3, int i4, float f2);
}
