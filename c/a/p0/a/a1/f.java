package c.a.p0.a.a1;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.i;
import c.a.p0.a.d2.m;
import c.a.p0.a.f1.e.f.c;
import c.a.p0.a.k;
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
public class f extends m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f4213i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, AbstractC0168f> f4214f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.p0.a.f1.e.f.c f4215g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.a.f1.e.f.c f4216h;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<AbstractC0168f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4217e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4217e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(AbstractC0168f abstractC0168f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abstractC0168f) == null) {
                abstractC0168f.g(this.f4217e);
                this.f4217e.f4214f.put(abstractC0168f.f4222e, abstractC0168f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.e1.a f4218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f4219f;

        public b(f fVar, c.a.p0.a.z2.e1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4219f = fVar;
            this.f4218e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if ("on_progress".equals(str)) {
                    this.f4219f.A((i.a) new i.a("installer_on_progress").v(" event_params_installer_progress", this.f4218e.j()));
                } else if ("pump_finish".equals(str)) {
                    this.f4219f.q("installer_on_pump_finish");
                } else if (ConstantHelper.LOG_FINISH.equals(str)) {
                    this.f4219f.q("installer_on_finish");
                } else if ("start".equals(str)) {
                    this.f4219f.q("installer_on_start");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.z2.g1.c<AbstractC0168f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.e1.a f4220e;

        public c(f fVar, c.a.p0.a.z2.e1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4220e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(AbstractC0168f abstractC0168f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abstractC0168f) == null) {
                this.f4220e.d(abstractC0168f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.z2.g1.c<AbstractC0168f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
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
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(AbstractC0168f abstractC0168f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abstractC0168f) == null) {
                abstractC0168f.e();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.z2.g1.c<AbstractC0168f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f4221e;

        public e(f fVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4221e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(AbstractC0168f abstractC0168f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abstractC0168f) == null) {
                boolean[] zArr = this.f4221e;
                zArr[0] = abstractC0168f.c() & zArr[0];
            }
        }
    }

    /* renamed from: c.a.p0.a.a1.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0168f implements c.a.p0.a.z2.g1.c<Pipe.SourceChannel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f4222e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f4223f;

        /* renamed from: g  reason: collision with root package name */
        public f f4224g;

        public AbstractC0168f(String str) {
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
            this.f4223f = new Bundle();
            this.f4222e = str;
        }

        public Bundle b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4223f : (Bundle) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b().getBoolean("flag_is_ok") : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sourceChannel) == null) && (fVar = this.f4224g) != null && f(sourceChannel, fVar.f4215g.D())) {
                h();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
                this.f4224g = fVar;
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f4223f.putBoolean("flag_is_ok", true);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4222e : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(812572285, "Lc/a/p0/a/a1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(812572285, "Lc/a/p0/a/a1/f;");
                return;
            }
        }
        f4213i = k.a;
    }

    public f() {
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
        this.f4214f = new HashMap();
        this.f4215g = new c.a();
        this.f4216h = new c.a();
    }

    public f I(AbstractC0168f... abstractC0168fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, abstractC0168fArr)) == null) {
            c.a.p0.a.z2.g1.b.d(new a(this), abstractC0168fArr);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f J(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f4215g.update(bundle);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final void K(c.a.p0.a.z2.g1.c<AbstractC0168f> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.p0.a.z2.g1.b.c(cVar, this.f4214f.values());
        }
    }

    public synchronized f L(ReadableByteChannel readableByteChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, readableByteChannel)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f4216h.b();
                c.a.p0.a.z2.e1.a aVar = new c.a.p0.a.z2.e1.a();
                aVar.o(32768);
                aVar.q(30L, TimeUnit.SECONDS);
                aVar.g(this.f4215g.D());
                aVar.p(new b(this, aVar));
                K(new c(this, aVar));
                N("connect: " + readableByteChannel + " at: " + currentTimeMillis);
                aVar.h(readableByteChannel);
                boolean M = M();
                if (f4213i) {
                    N("allOk: " + M + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (!M) {
                    K(new d(this));
                }
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f4214f.isEmpty() || this.f4216h.e("flag_is_ok", false)) {
                return true;
            }
            boolean[] zArr = {true};
            K(new e(this, zArr));
            this.f4216h.t("flag_is_ok", zArr[0]);
            return zArr[0];
        }
        return invokeV.booleanValue;
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && f4213i) {
            c.a.p0.a.f1.g.a.d(this.f4215g.o("launch_id", "")).f(str).b("SwanInstaller");
        }
    }
}
