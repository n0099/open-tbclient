package b.a.p0.a.h0.l;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.l0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class e implements b.a.p0.a.h0.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f5421e;

    /* renamed from: f  reason: collision with root package name */
    public String f5422f;

    /* renamed from: g  reason: collision with root package name */
    public String f5423g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5424h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5425i;

    /* loaded from: classes.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5426a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f5427b;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5427b = eVar;
            this.f5426a = str;
        }

        @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
        public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                if (e.j) {
                    String str = "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath;
                }
                if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                    return;
                }
                File file = new File(cacheInfo.jsPath);
                try {
                    if (file.getPath().startsWith(new File(this.f5426a).getCanonicalPath())) {
                        this.f5427b.f5424h = true;
                    } else if (!TextUtils.isEmpty(this.f5427b.f5423g) && file.getCanonicalPath().startsWith(new File(this.f5427b.f5423g).getCanonicalPath())) {
                        this.f5427b.f5425i = true;
                    }
                } catch (IOException e2) {
                    if (e.j) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.b f5428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f5429b;

        public b(e eVar, b.a.p0.a.h0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5429b = eVar;
            this.f5428a = bVar;
        }

        @Override // b.a.p0.a.l0.j
        public void a(b.a.p0.a.l0.a aVar) {
            b.a.p0.a.h0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (bVar = this.f5428a) == null) {
                return;
            }
            bVar.a(this.f5429b.f5422f);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f5430e;

        public c(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5430e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.f5430e);
                } catch (Throwable th) {
                    b.a.p0.a.e0.d.b("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597551914, "Lb/a/p0/a/h0/l/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597551914, "Lb/a/p0/a/h0/l/e;");
                return;
            }
        }
        j = k.f6397a;
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // b.a.p0.a.h0.l.a
    public void C(b.a.p0.a.h0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (j) {
            String str = "pathList item: " + aVar.f5800b;
        }
        String str2 = aVar.f5800b;
        this.f5423g = str2;
        this.f5421e.j(b.a.p0.a.h0.d.a.a("appjs", str2));
    }

    @Override // b.a.p0.a.h0.l.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f5421e;
            if (dVar != null) {
                return dVar.g();
            }
            if (j) {
                Log.getStackTraceString(new Exception("illegal state"));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.l.a
    public void c(b.a.p0.a.h0.b bVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (dVar = this.f5421e) == null) {
            return;
        }
        dVar.k(new b(this, bVar));
    }

    @Override // b.a.p0.a.h0.l.a
    public void destroy() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f5421e) == null) {
            return;
        }
        dVar.f();
    }

    @Override // b.a.p0.a.h0.l.a
    public void e(Activity activity) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (dVar = this.f5421e) == null) {
            return;
        }
        dVar.d(activity);
    }

    @Override // b.a.p0.a.h0.l.a
    public b.a.p0.a.h0.f.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5421e.h() : (b.a.p0.a.h0.f.a) invokeV.objValue;
    }

    public d j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new d(str, "runtime/index.js") : (d) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.p0.a.h0.d.a.b(this.f5424h, this.f5425i) : invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.f5421e == null) {
                String T = g.M().T();
                d j2 = j(T);
                this.f5421e = j2;
                this.f5422f = str;
                j2.i(new a(this, T));
            } else if (j) {
                Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice."));
            }
        }
    }

    @Override // b.a.p0.a.h0.l.a
    @AnyThread
    public void p(int i2) {
        d dVar;
        b.a.p0.a.l0.a h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (dVar = this.f5421e) == null || (h2 = dVar.h()) == null) {
            return;
        }
        h2.runOnJSThread(new c(this, i2));
    }
}
