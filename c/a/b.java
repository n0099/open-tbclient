package c.a;

import android.os.Handler;
import android.os.Looper;
import c.a.f0.b.f;
import c.a.f0.b.g.g;
import c.a.j0.a.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final b f1852f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1853a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.f0.b.a f1854b;

    /* renamed from: c  reason: collision with root package name */
    public long f1855c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1856d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<d> f1857e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1859f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1859f = bVar;
            this.f1858e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1858e != 1 || ((float) (System.currentTimeMillis() - this.f1859f.f1855c)) >= g.d() * 60000.0f) {
                    if (this.f1859f.f1854b == null) {
                        this.f1859f.f1854b = new c.a.f0.b.a();
                    }
                    this.f1859f.f1854b.l(c.a.f0.a.b.a.f3337a.get());
                    this.f1859f.f1855c = System.currentTimeMillis();
                }
            }
        }
    }

    /* renamed from: c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0020b {
        void onFailed();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1611432447, "Lc/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1611432447, "Lc/a/b;");
                return;
            }
        }
        f1852f = new b();
    }

    public b() {
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
        this.f1853a = false;
        this.f1856d = new Handler(Looper.myLooper());
        this.f1857e = new ArrayList<>();
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f1852f : (b) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1857e.clear();
        }
    }

    public void g(c.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.f0.a.b.a.f3337a.set(aVar);
        aVar.p().registerActivityLifecycleCallbacks(new f());
        new BDAdConfig.Builder().setAppName(aVar.v()).setAppsid(aVar.s()).build(aVar.p()).init();
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionLocation(true);
        MobadsPermissionSettings.setPermissionStorage(true);
        MobadsPermissionSettings.setPermissionAppList(true);
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1853a : invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || c.a.f0.a.b.a.f3337a.get() == null) {
            return;
        }
        this.f1856d.postDelayed(new a(this, i2), 5000L);
    }
}
