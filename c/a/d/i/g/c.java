package c.a.d.i.g;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallTask;
import com.baidu.adp.plugin.install.PluginInstallerRetryService;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Handler t;
    public static volatile c u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f2760b;

    /* renamed from: c  reason: collision with root package name */
    public BroadcastReceiver f2761c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2762d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.i.g.a f2763e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2764f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f2765g;

    /* renamed from: h  reason: collision with root package name */
    public PluginInstallTask f2766h;

    /* renamed from: i  reason: collision with root package name */
    public LinkedList<PluginInstallTask> f2767i;

    /* renamed from: j  reason: collision with root package name */
    public PluginInstallTask f2768j;

    /* renamed from: k  reason: collision with root package name */
    public LinkedList<PluginInstallTask> f2769k;
    public Messenger l;
    public ServiceConnection m;
    public Handler n;
    public Messenger o;
    public Runnable p;
    public Runnable q;
    public Runnable r;
    public Runnable s;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c this$0;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0150, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.f2768j.f32090f) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.f2768j.f32090f) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
            r6.this$0.I();
            r0 = r6.this$0.t(null);
            c.a.d.i.h.a.b().g("plugin_retry_install_succ");
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) {
                return;
            }
            try {
                if (intent == null) {
                    if (this.this$0.f2766h == null || !TextUtils.equals(null, this.this$0.f2766h.f32090f)) {
                        if (this.this$0.f2768j == null || !TextUtils.equals(null, this.this$0.f2768j.f32090f)) {
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.I();
                        this.this$0.t(null);
                        c.a.d.i.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.F();
                    this.this$0.f2766h = null;
                    this.this$0.t(null);
                    return;
                }
                try {
                    str = intent.getStringExtra("package_name");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        if (this.this$0.f2766h == null || !TextUtils.equals(str, this.this$0.f2766h.f32090f)) {
                            if (this.this$0.f2768j != null) {
                            }
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.F();
                        this.this$0.f2766h = null;
                        this.this$0.t(null);
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (this.this$0.f2766h == null || !TextUtils.equals(null, this.this$0.f2766h.f32090f)) {
                        if (this.this$0.f2768j == null || !TextUtils.equals(null, this.this$0.f2768j.f32090f)) {
                            this.this$0.t(null);
                        } else {
                            this.this$0.I();
                            this.this$0.t(null);
                            c.a.d.i.h.a.b().g("plugin_retry_install_succ");
                        }
                    } else {
                        this.this$0.F();
                        this.this$0.f2766h = null;
                        this.this$0.t(null);
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(str)) {
                    if (this.this$0.f2766h == null || !TextUtils.equals(str, this.this$0.f2766h.f32090f)) {
                        if (this.this$0.f2768j == null || !TextUtils.equals(str, this.this$0.f2768j.f32090f)) {
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.I();
                        this.this$0.t(null);
                        c.a.d.i.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.F();
                    this.this$0.f2766h = null;
                    this.this$0.t(null);
                    return;
                }
                String stringExtra = intent.getStringExtra("install_src_file");
                boolean z = stringExtra != null && stringExtra.startsWith("assets://");
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    this.this$0.z(str, z);
                    c.a.d.i.j.g.a.b().e(str);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    if (z) {
                        this.this$0.f2764f = false;
                    }
                    this.this$0.z(str, z);
                    c.a.d.i.j.g.a.b().d(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    this.this$0.z(str, z);
                } else {
                    "com.baidu.adp.plugin.installrepeat".equals(action);
                }
                if (this.this$0.f2766h == null || !TextUtils.equals(str, this.this$0.f2766h.f32090f)) {
                    if (this.this$0.f2768j != null) {
                    }
                    this.this$0.t(null);
                    return;
                }
                this.this$0.F();
                this.this$0.f2766h = null;
                this.this$0.t(null);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f2770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f2771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f2772g;

        public b(c cVar, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2772g = cVar;
            this.f2770e = intent;
            this.f2771f = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f2772g.l = new Messenger(iBinder);
                String stringExtra = this.f2770e.getStringExtra("package_name");
                if (this.f2772g.f2766h == null || !TextUtils.equals(stringExtra, this.f2772g.f2766h.f32090f)) {
                    return;
                }
                try {
                    this.f2771f.startService(this.f2770e);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f2772g.G();
            }
        }
    }

    /* renamed from: c.a.d.i.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0089c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0089c(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f2766h == null || message == null) {
                return;
            }
            try {
                if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).f32090f, this.a.f2766h.f32090f)) {
                    c.t.removeCallbacks(this.a.q);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2773e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2773e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2773e.r();
                this.f2773e.D();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2774e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2774e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2774e.E();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2775e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2775e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2775e.H();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2776e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2776e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2776e.J();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416869833, "Lc/a/d/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-416869833, "Lc/a/d/i/g/c;");
                return;
            }
        }
        t = new Handler(Looper.getMainLooper());
        u = null;
    }

    public c() {
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
        this.a = false;
        this.f2760b = null;
        this.f2761c = null;
        this.f2762d = false;
        this.f2764f = true;
        this.f2765g = new Object();
        this.f2767i = new LinkedList<>();
        this.f2769k = new LinkedList<>();
        this.n = new HandlerC0089c(this, Looper.getMainLooper());
        this.o = new Messenger(this.n);
        this.p = new d(this);
        this.q = new e(this);
        this.r = new f(this);
        this.s = new g(this);
        this.f2760b = new ArrayList<>();
        this.f2761c = new a(this);
        K();
    }

    public static File x(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            PluginSetting v = PluginPackageManager.u().v(str);
            if (v == null || (str2 = v.apkPath) == null || str2.length() <= 0) {
                return null;
            }
            return new File(v.apkPath);
        }
        return (File) invokeL.objValue;
    }

    public static c y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (u == null) {
                synchronized (c.class) {
                    if (u == null) {
                        u = new c();
                    }
                }
            }
            return u;
        }
        return (c) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? w() > 0 : invokeV.booleanValue;
    }

    public boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PluginInstallTask pluginInstallTask = this.f2766h;
            if (pluginInstallTask != null) {
                return TextUtils.equals(str, pluginInstallTask.f32090f);
            }
            PluginInstallTask pluginInstallTask2 = this.f2768j;
            if (pluginInstallTask2 != null) {
                return TextUtils.equals(str, pluginInstallTask2.f32090f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.m != null) {
                BdBaseApplication.getInst().getApplicationContext().unbindService(this.m);
            }
            this.m = null;
            this.l = null;
            int w = w();
            if (w <= 0 || w == Process.myPid()) {
                return;
            }
            Process.killProcess(w);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t.removeCallbacks(this.p);
            t.postDelayed(this.p, 10000L);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.i.h.a.b().g("plugin_installprocess_noresponse");
            c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.f2766h;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f32090f;
            b2.m("plugin_install", "installprocess_noresponse", str, this.f2767i.size() + "-" + this.f2769k.size());
            F();
            C();
            L();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t.removeCallbacks(this.p);
            t.removeCallbacks(this.r);
            t.removeCallbacks(this.q);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m = null;
            this.l = null;
            c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.f2766h;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f32090f;
            b2.m("plugin_install", "system_kill_installprocess", str, this.f2767i.size() + "-" + this.f2769k.size());
            F();
            L();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f2766h != null) {
                c.a.d.i.j.g.a.b().d(this.f2766h.f32090f, "plugin_install_timeout", null);
            }
            PluginInstallTask pluginInstallTask = this.f2766h;
            if (!A()) {
                c.a.d.i.h.a.b().g("plugin_install_timeout_installprocess_notlive");
                c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                String str = pluginInstallTask == null ? "" : pluginInstallTask.f32090f;
                StringBuilder sb = new StringBuilder();
                sb.append("timeout-");
                sb.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.w()) : "");
                sb.append("-");
                sb.append(this.f2767i.size());
                sb.append("-");
                sb.append(this.f2769k.size());
                b2.m("plugin_install", "timeout_installprocess_notlive", str, sb.toString());
            } else {
                c.a.d.i.h.a.b().g("plugin_install_timeout");
                c.a.d.i.h.a b3 = c.a.d.i.h.a.b();
                String str2 = pluginInstallTask == null ? "" : pluginInstallTask.f32090f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("timeout-");
                sb2.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.w()) : "");
                sb2.append("-");
                sb2.append(this.f2767i.size());
                sb2.append("-");
                sb2.append(this.f2769k.size());
                b3.m("plugin_install", com.alipay.sdk.data.a.O, str2, sb2.toString());
            }
            F();
            C();
            L();
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f2768j = null;
            t.removeCallbacks(this.s);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f2768j != null) {
                c.a.d.i.j.g.a.b().d(this.f2768j.f32090f, "plugin_install_retry_timeout", null);
            }
            c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.f2768j;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f32090f;
            StringBuilder sb = new StringBuilder();
            sb.append("timeout-");
            PluginInstallTask pluginInstallTask2 = this.f2768j;
            sb.append(pluginInstallTask2 != null ? Long.valueOf(pluginInstallTask2.w()) : "");
            sb.append("-");
            sb.append(this.f2767i.size());
            sb.append("-");
            sb.append(this.f2769k.size());
            b2.m("plugin_install", com.alipay.sdk.data.a.O, str, sb.toString());
            I();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a) {
            return;
        }
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
            if (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().equals(RomUtils.MANUFACTURER_OPPO)) {
                intentFilter.setPriority(1000);
            }
            applicationContext.registerReceiver(this.f2761c, intentFilter);
            this.a = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f2766h != null) {
                c.a.d.i.h.a.b().i("plugin_retry_install", this.f2766h.f32090f);
                c.a.d.i.h.a b2 = c.a.d.i.h.a.b();
                String str = this.f2766h.f32090f;
                b2.m("plugin_install", "plugin_retry_install", str, this.f2766h.w() + "");
                v(this.f2766h);
                this.f2766h = null;
                return;
            }
            t(null);
        }
    }

    public final boolean M(Context context, PluginInstallTask pluginInstallTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, pluginInstallTask)) == null) {
            if (pluginInstallTask == null) {
                return false;
            }
            PluginSetting h2 = c.a.d.i.j.f.c.j().h(pluginInstallTask.f32090f);
            String str = pluginInstallTask.f32089e;
            boolean z = str != null && str.startsWith("assets://");
            String str2 = pluginInstallTask.f32089e;
            if (str2 != null && str2.startsWith("file://")) {
                if (h2 != null && h2.installStatus == 0 && h2.tempVersionCode == 0) {
                    c.a.d.i.h.a.b().m("plugin_install", "start_service_install_status_error", pluginInstallTask.f32090f, "apkFilePath_" + pluginInstallTask.f32089e);
                    return false;
                }
                String substring = pluginInstallTask.f32089e.substring(7);
                try {
                    if (!new File(substring).exists()) {
                        c.a.d.i.h.a.b().m("plugin_install", "start_service_file_not_find", pluginInstallTask.f32090f, "apkFilePath_" + substring);
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            String str3 = "f" + System.currentTimeMillis();
            c.a.d.i.h.a.b().m("plugin_install", "start_install_service", pluginInstallTask.f32090f, "flag=" + str3 + "_" + pluginInstallTask.f32089e);
            Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
            intent.putExtra("install_src_file", pluginInstallTask.f32089e);
            intent.putExtra("package_name", pluginInstallTask.f32090f);
            intent.putExtra("install_flag", str3);
            if (h2 != null) {
                intent.putExtra("plugin_setting", h2);
            }
            intent.putExtra("is_debug_plugin", PluginPackageManager.u().D());
            if (pluginInstallTask.f32091g) {
                intent.setClass(context, PluginInstallerRetryService.class);
                try {
                    context.startService(intent);
                    return true;
                } catch (Throwable unused2) {
                    return false;
                }
            }
            intent.setClass(context, PluginInstallerService.class);
            if (this.m == null && z) {
                ServiceConnection bVar = new b(this, intent, context);
                this.m = bVar;
                if (context.bindService(intent, bVar, 1)) {
                    return true;
                }
                try {
                    context.startService(intent);
                    return true;
                } catch (Throwable unused3) {
                    return false;
                }
            }
            try {
                context.startService(intent);
                return true;
            } catch (Throwable unused4) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.l == null || this.f2766h == null) {
            return;
        }
        Message message = new Message();
        try {
            message.setData(OrmObject.bundleWithObject(this.f2766h));
            message.replyTo = this.o;
            this.l.send(message);
        } catch (RemoteException e2) {
            BdLog.detailException(e2);
        }
        t.removeCallbacks(this.q);
        t.postDelayed(this.q, 1000L);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.m == null) {
            return;
        }
        BdBaseApplication.getInst().unbindService(this.m);
        this.m = null;
    }

    public final boolean t(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pluginInstallTask)) == null) {
            if (u(pluginInstallTask)) {
                return true;
            }
            return v(pluginInstallTask);
        }
        return invokeL.booleanValue;
    }

    public final boolean u(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pluginInstallTask)) == null) {
            synchronized (this.f2765g) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.f2767i.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.f2766h != null) {
                    Iterator<PluginInstallTask> it = this.f2767i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.f32090f, next.f32090f)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f2767i.add(pluginInstallTask);
                    }
                    return true;
                }
                this.f2766h = pluginInstallTask;
                if (M(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    D();
                    t.removeCallbacks(this.r);
                    t.postDelayed(this.r, this.f2766h.w());
                    return true;
                }
                this.f2766h = null;
                return t(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean v(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, pluginInstallTask)) == null) {
            synchronized (this.f2765g) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.f2769k.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.f2768j != null) {
                    Iterator<PluginInstallTask> it = this.f2769k.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.f32090f, next.f32090f)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f2769k.add(pluginInstallTask);
                    }
                    return true;
                }
                this.f2768j = pluginInstallTask;
                pluginInstallTask.f32091g = true;
                if (M(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    t.removeCallbacks(this.s);
                    t.postDelayed(this.s, this.f2768j.w());
                    return true;
                }
                return t(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final int w() {
        InterceptResult invokeV;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            try {
                serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, PluginInstallerService.class), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                serviceInfo = null;
            }
            if (serviceInfo != null) {
                String str = serviceInfo.processName;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                            return runningAppProcessInfo.pid;
                        }
                    }
                    return Integer.MIN_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        return invokeV.intValue;
    }

    public final void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, str, z) == null) {
            if (this.f2760b.contains(str)) {
                this.f2760b.remove(str);
            }
            if (!this.f2762d && z && this.f2760b.isEmpty()) {
                this.f2762d = true;
                c.a.d.i.g.a aVar = this.f2763e;
                if (aVar != null) {
                    aVar.a(this.f2764f);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
                s();
            }
        }
    }
}
