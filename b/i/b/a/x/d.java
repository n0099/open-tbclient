package b.i.b.a.x;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public interface d {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Handler f32818a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final d f32819b;

        /* renamed from: b.i.b.a.x.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1497a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.y.d f32820e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32821f;

            public RunnableC1497a(a aVar, b.i.b.a.y.d dVar) {
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
                this.f32821f = aVar;
                this.f32820e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32821f.f32819b.d(this.f32820e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f32822e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f32823f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f32824g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f32825h;

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
                this.f32825h = aVar;
                this.f32822e = str;
                this.f32823f = j;
                this.f32824g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32825h.f32819b.b(this.f32822e, this.f32823f, this.f32824g);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f32826e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32827f;

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
                this.f32827f = aVar;
                this.f32826e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32827f.f32819b.m(this.f32826e);
                }
            }
        }

        /* renamed from: b.i.b.a.x.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1498d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32828e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f32829f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f32830g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f32831h;

            public RunnableC1498d(a aVar, int i2, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32831h = aVar;
                this.f32828e = i2;
                this.f32829f = j;
                this.f32830g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32831h.f32819b.i(this.f32828e, this.f32829f, this.f32830g);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.y.d f32832e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32833f;

            public e(a aVar, b.i.b.a.y.d dVar) {
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
                this.f32833f = aVar;
                this.f32832e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32832e.a();
                    this.f32833f.f32819b.k(this.f32832e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32834e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f32835f;

            public f(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32835f = aVar;
                this.f32834e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32835f.f32819b.a(this.f32834e);
                }
            }
        }

        public a(@Nullable Handler handler, @Nullable d dVar) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (dVar != null) {
                b.i.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f32818a = handler2;
            this.f32819b = dVar;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new f(this, i2));
        }

        public void c(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new RunnableC1498d(this, i2, j, j2));
        }

        public void d(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new b(this, str, j, j2));
        }

        public void e(b.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new e(this, dVar));
        }

        public void f(b.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new RunnableC1497a(this, dVar));
        }

        public void g(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, format) == null) || this.f32819b == null) {
                return;
            }
            this.f32818a.post(new c(this, format));
        }
    }

    void a(int i2);

    void b(String str, long j, long j2);

    void d(b.i.b.a.y.d dVar);

    void i(int i2, long j, long j2);

    void k(b.i.b.a.y.d dVar);

    void m(Format format);
}
