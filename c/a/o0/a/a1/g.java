package c.a.o0.a.a1;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.i;
import c.a.o0.a.a2.m;
import c.a.o0.a.f1.e.f.c;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class g extends m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f4476i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, f> f4477f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.o0.a.f1.e.f.c f4478g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.o0.a.f1.e.f.c f4479h;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f4480e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4480e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.g(this.f4480e);
                this.f4480e.f4477f.put(fVar.f4485e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.c1.a f4481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f4482f;

        public b(g gVar, c.a.o0.a.v2.c1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4482f = gVar;
            this.f4481e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if ("on_progress".equals(str)) {
                    this.f4482f.A((i.a) new i.a("installer_on_progress").u(" event_params_installer_progress", this.f4481e.j()));
                } else if ("pump_finish".equals(str)) {
                    this.f4482f.q("installer_on_pump_finish");
                } else if (ConstantHelper.LOG_FINISH.equals(str)) {
                    this.f4482f.q("installer_on_finish");
                } else if ("start".equals(str)) {
                    this.f4482f.q("installer_on_start");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.c1.a f4483e;

        public c(g gVar, c.a.o0.a.v2.c1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4483e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f4483e.d(fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.e();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f4484e;

        public e(g gVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4484e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean[] zArr = this.f4484e;
                zArr[0] = fVar.c() & zArr[0];
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f implements c.a.o0.a.v2.e1.b<Pipe.SourceChannel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f4485e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f4486f;

        /* renamed from: g  reason: collision with root package name */
        public g f4487g;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4486f = new Bundle();
            this.f4485e = str;
        }

        public Bundle b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4486f : (Bundle) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b().getBoolean("flag_is_ok") : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sourceChannel) == null) && (gVar = this.f4487g) != null && f(sourceChannel, gVar.f4478g.C())) {
                h();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
                this.f4487g = gVar;
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f4486f.putBoolean("flag_is_ok", true);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4485e : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1009085821, "Lc/a/o0/a/a1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1009085821, "Lc/a/o0/a/a1/g;");
                return;
            }
        }
        f4476i = k.f7049a;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4477f = new HashMap();
        this.f4478g = new c.a();
        this.f4479h = new c.a();
    }

    public g f(f... fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
            c.a.o0.a.v2.e1.a.d(new a(this), fVarArr);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f4478g.D(bundle);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final void h(c.a.o0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            c.a.o0.a.v2.e1.a.c(bVar, this.f4477f.values());
        }
    }

    public synchronized g i(ReadableByteChannel readableByteChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, readableByteChannel)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f4479h.b();
                c.a.o0.a.v2.c1.a aVar = new c.a.o0.a.v2.c1.a();
                aVar.o(32768);
                aVar.q(30L, TimeUnit.SECONDS);
                aVar.g(this.f4478g.C());
                aVar.p(new b(this, aVar));
                h(new c(this, aVar));
                k("connect: " + readableByteChannel + " at: " + currentTimeMillis);
                aVar.h(readableByteChannel);
                boolean j2 = j();
                if (f4476i) {
                    k("allOk: " + j2 + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (!j2) {
                    h(new d(this));
                }
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f4477f.isEmpty() || this.f4479h.e("flag_is_ok", false)) {
                return true;
            }
            boolean[] zArr = {true};
            h(new e(this, zArr));
            this.f4479h.s("flag_is_ok", zArr[0]);
            return zArr[0];
        }
        return invokeV.booleanValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && f4476i) {
            c.a.o0.a.f1.g.a.d(this.f4478g.o("launch_id", "")).f(str).b("SwanInstaller");
        }
    }
}
