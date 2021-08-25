package c.a.o0.a.h0.s;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import c.a.o0.a.k;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6387h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f6388i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f6389a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6390b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6391c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6392d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6393e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f6394f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f6395g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f6397f;

        public a(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6397f = bVar;
            this.f6396e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f6397f.f(this.f6396e);
                this.f6397f.f6390b = true;
                synchronized (this.f6397f.f6394f) {
                    this.f6397f.f6392d = true;
                    this.f6397f.f6394f.notifyAll();
                    this.f6397f.l();
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0248b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0248b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebView.setWebContentsDebuggingEnabled(true);
                Log.setMinLogLevel(3, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(958143462, "Lc/a/o0/a/h0/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(958143462, "Lc/a/o0/a/h0/s/b;");
                return;
            }
        }
        f6387h = k.f7049a;
    }

    public b(Context context) {
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
                return;
            }
        }
        this.f6390b = false;
        this.f6391c = false;
        this.f6392d = false;
        this.f6393e = new Object();
        this.f6394f = new Object();
        this.f6395g = new ArrayList<>();
        this.f6389a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (b.class) {
                if (f6388i == null) {
                    f6388i = new b(context);
                }
                bVar = f6388i;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this.f6394f) {
                boolean z = f6387h;
                if (!this.f6395g.contains(cVar)) {
                    this.f6395g.add(cVar);
                }
                if (this.f6392d) {
                    l();
                }
            }
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            WebKitFactory.setNeedDownloadCloudResource(false);
            WebKitFactory.setProcessType("1");
            com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
            BdSailor.getInstance().init(this.f6389a, null, null);
            if (f6387h) {
                q0.X(new RunnableC0248b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(f6387h && c.a.o0.a.u1.a.a.F().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                boolean z2 = f6387h;
            } else {
                boolean z3 = f6387h;
            }
            CookieSyncManager.createInstance(this.f6389a);
            BdSailor.initCookieSyncManager(this.f6389a);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
        }
    }

    public final void i(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f6390b) {
            return;
        }
        synchronized (this.f6393e) {
            if (!this.f6391c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2));
                this.f6391c = true;
            }
        }
        if (z) {
            synchronized (this.f6394f) {
                while (!this.f6392d) {
                    try {
                        this.f6394f.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            i(false, z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6390b : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f6394f) {
                boolean z = f6387h;
                Iterator<c> it = this.f6395g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f6395g.clear();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && k()) {
            BdSailor.getInstance().destroy();
        }
    }
}
