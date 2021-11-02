package b.a.p0.a.a1;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.i;
import b.a.p0.a.a2.m;
import b.a.p0.a.f1.e.f.c;
import b.a.p0.a.k;
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
    public static final boolean f3908i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, f> f3909f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a.p0.a.f1.e.f.c f3910g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.p0.a.f1.e.f.c f3911h;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f3912e;

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
            this.f3912e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.g(this.f3912e);
                this.f3912e.f3909f.put(fVar.f3917e, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.c1.a f3913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f3914f;

        public b(g gVar, b.a.p0.a.v2.c1.a aVar) {
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
            this.f3914f = gVar;
            this.f3913e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if ("on_progress".equals(str)) {
                    this.f3914f.A((i.a) new i.a("installer_on_progress").u(" event_params_installer_progress", this.f3913e.j()));
                } else if ("pump_finish".equals(str)) {
                    this.f3914f.q("installer_on_pump_finish");
                } else if (ConstantHelper.LOG_FINISH.equals(str)) {
                    this.f3914f.q("installer_on_finish");
                } else if ("start".equals(str)) {
                    this.f3914f.q("installer_on_start");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.c1.a f3915e;

        public c(g gVar, b.a.p0.a.v2.c1.a aVar) {
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
            this.f3915e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f3915e.d(fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.v2.e1.b<f> {
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
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.e();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f3916e;

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
            this.f3916e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean[] zArr = this.f3916e;
                zArr[0] = fVar.c() & zArr[0];
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f implements b.a.p0.a.v2.e1.b<Pipe.SourceChannel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f3917e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f3918f;

        /* renamed from: g  reason: collision with root package name */
        public g f3919g;

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
            this.f3918f = new Bundle();
            this.f3917e = str;
        }

        public Bundle b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3918f : (Bundle) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b().getBoolean("flag_is_ok") : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sourceChannel) == null) && (gVar = this.f3919g) != null && f(sourceChannel, gVar.f3910g.C())) {
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
                this.f3919g = gVar;
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f3918f.putBoolean("flag_is_ok", true);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3917e : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1318130941, "Lb/a/p0/a/a1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1318130941, "Lb/a/p0/a/a1/g;");
                return;
            }
        }
        f3908i = k.f6397a;
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
        this.f3909f = new HashMap();
        this.f3910g = new c.a();
        this.f3911h = new c.a();
    }

    public g f(f... fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
            b.a.p0.a.v2.e1.a.d(new a(this), fVarArr);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f3910g.update(bundle);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final void h(b.a.p0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            b.a.p0.a.v2.e1.a.c(bVar, this.f3909f.values());
        }
    }

    public synchronized g i(ReadableByteChannel readableByteChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, readableByteChannel)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f3911h.b();
                b.a.p0.a.v2.c1.a aVar = new b.a.p0.a.v2.c1.a();
                aVar.o(32768);
                aVar.q(30L, TimeUnit.SECONDS);
                aVar.g(this.f3910g.C());
                aVar.p(new b(this, aVar));
                h(new c(this, aVar));
                k("connect: " + readableByteChannel + " at: " + currentTimeMillis);
                aVar.h(readableByteChannel);
                boolean j = j();
                if (f3908i) {
                    k("allOk: " + j + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (!j) {
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
            if (this.f3909f.isEmpty() || this.f3911h.e("flag_is_ok", false)) {
                return true;
            }
            boolean[] zArr = {true};
            h(new e(this, zArr));
            this.f3911h.s("flag_is_ok", zArr[0]);
            return zArr[0];
        }
        return invokeV.booleanValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && f3908i) {
            b.a.p0.a.f1.g.a.d(this.f3910g.o("launch_id", "")).f(str).b("SwanInstaller");
        }
    }
}
