package b.a.p0.a.h0.s;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
    public static final boolean f5756h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f5757i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f5758a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5759b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5760c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5761d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f5762e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f5763f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f5764g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5766f;

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
            this.f5766f = bVar;
            this.f5765e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f5766f.f(this.f5765e);
                this.f5766f.f5759b = true;
                synchronized (this.f5766f.f5763f) {
                    this.f5766f.f5761d = true;
                    this.f5766f.f5763f.notifyAll();
                    this.f5766f.l();
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0245b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0245b(b bVar) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597760358, "Lb/a/p0/a/h0/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597760358, "Lb/a/p0/a/h0/s/b;");
                return;
            }
        }
        f5756h = k.f6397a;
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
        this.f5759b = false;
        this.f5760c = false;
        this.f5761d = false;
        this.f5762e = new Object();
        this.f5763f = new Object();
        this.f5764g = new ArrayList<>();
        this.f5758a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (b.class) {
                if (f5757i == null) {
                    f5757i = new b(context);
                }
                bVar = f5757i;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this.f5763f) {
                boolean z = f5756h;
                if (!this.f5764g.contains(cVar)) {
                    this.f5764g.add(cVar);
                }
                if (this.f5761d) {
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
            BdSailor.getInstance().init(this.f5758a, null, null);
            if (f5756h) {
                q0.X(new RunnableC0245b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(f5756h && b.a.p0.a.u1.a.a.F().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                boolean z2 = f5756h;
            } else {
                boolean z3 = f5756h;
            }
            CookieSyncManager.createInstance(this.f5758a);
            BdSailor.initCookieSyncManager(this.f5758a);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f5759b) {
            return;
        }
        synchronized (this.f5762e) {
            if (!this.f5760c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2));
                this.f5760c = true;
            }
        }
        if (z) {
            synchronized (this.f5763f) {
                while (!this.f5761d) {
                    try {
                        this.f5763f.wait(1000L);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5759b : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f5763f) {
                boolean z = f5756h;
                Iterator<c> it = this.f5764g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f5764g.clear();
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
