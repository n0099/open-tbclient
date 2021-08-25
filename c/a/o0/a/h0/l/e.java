package c.a.o0.a.h0.l;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import c.a.o0.a.l0.j;
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
public class e implements c.a.o0.a.h0.l.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f6042j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f6043e;

    /* renamed from: f  reason: collision with root package name */
    public String f6044f;

    /* renamed from: g  reason: collision with root package name */
    public String f6045g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6046h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6047i;

    /* loaded from: classes.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f6049b;

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
            this.f6049b = eVar;
            this.f6048a = str;
        }

        @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
        public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                if (e.f6042j) {
                    String str = "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath;
                }
                if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                    return;
                }
                File file = new File(cacheInfo.jsPath);
                try {
                    if (file.getPath().startsWith(new File(this.f6048a).getCanonicalPath())) {
                        this.f6049b.f6046h = true;
                    } else if (!TextUtils.isEmpty(this.f6049b.f6045g) && file.getCanonicalPath().startsWith(new File(this.f6049b.f6045g).getCanonicalPath())) {
                        this.f6049b.f6047i = true;
                    }
                } catch (IOException e2) {
                    if (e.f6042j) {
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
        public final /* synthetic */ c.a.o0.a.h0.b f6050a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f6051b;

        public b(e eVar, c.a.o0.a.h0.b bVar) {
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
            this.f6051b = eVar;
            this.f6050a = bVar;
        }

        @Override // c.a.o0.a.l0.j
        public void a(c.a.o0.a.l0.a aVar) {
            c.a.o0.a.h0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (bVar = this.f6050a) == null) {
                return;
            }
            bVar.a(this.f6051b.f6044f);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6052e;

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
            this.f6052e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.f6052e);
                } catch (Throwable th) {
                    c.a.o0.a.e0.d.b("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957935018, "Lc/a/o0/a/h0/l/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957935018, "Lc/a/o0/a/h0/l/e;");
                return;
            }
        }
        f6042j = k.f7049a;
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

    @Override // c.a.o0.a.h0.l.a
    public void E(c.a.o0.a.h0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (f6042j) {
            String str = "pathList item: " + aVar.f6431b;
        }
        String str2 = aVar.f6431b;
        this.f6045g = str2;
        this.f6043e.j(c.a.o0.a.h0.d.a.a("appjs", str2));
    }

    @Override // c.a.o0.a.h0.l.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f6043e;
            if (dVar != null) {
                return dVar.g();
            }
            if (f6042j) {
                Log.getStackTraceString(new Exception("illegal state"));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.l.a
    public void d(c.a.o0.a.h0.b bVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (dVar = this.f6043e) == null) {
            return;
        }
        dVar.k(new b(this, bVar));
    }

    @Override // c.a.o0.a.h0.l.a
    public void destroy() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f6043e) == null) {
            return;
        }
        dVar.f();
    }

    @Override // c.a.o0.a.h0.l.a
    public void f(Activity activity) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (dVar = this.f6043e) == null) {
            return;
        }
        dVar.d(activity);
    }

    @Override // c.a.o0.a.h0.l.a
    public c.a.o0.a.h0.f.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6043e.h() : (c.a.o0.a.h0.f.a) invokeV.objValue;
    }

    public d j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new d(str, "runtime/index.js") : (d) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.o0.a.h0.d.a.b(this.f6046h, this.f6047i) : invokeV.intValue;
    }

    @Override // c.a.o0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.f6043e == null) {
                String U = g.N().U();
                d j2 = j(U);
                this.f6043e = j2;
                this.f6044f = str;
                j2.i(new a(this, U));
            } else if (f6042j) {
                Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice."));
            }
        }
    }

    @Override // c.a.o0.a.h0.l.a
    @AnyThread
    public void q(int i2) {
        d dVar;
        c.a.o0.a.l0.a h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (dVar = this.f6043e) == null || (h2 = dVar.h()) == null) {
            return;
        }
        h2.runOnJSThread(new c(this, i2));
    }
}
