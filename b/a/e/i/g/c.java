package b.a.e.i.g;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
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
import b.a.e.f.p.m;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallTask;
import com.baidu.adp.plugin.install.PluginInstallerRetryService;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.adp.plugin.util.Util;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Handler u;
    public static volatile c v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2239a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f2240b;

    /* renamed from: c  reason: collision with root package name */
    public BroadcastReceiver f2241c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2242d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.i.g.a f2243e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2244f;

    /* renamed from: g  reason: collision with root package name */
    public h f2245g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f2246h;

    /* renamed from: i  reason: collision with root package name */
    public PluginInstallTask f2247i;
    public LinkedList<PluginInstallTask> j;
    public PluginInstallTask k;
    public LinkedList<PluginInstallTask> l;
    public Messenger m;
    public ServiceConnection n;
    public Handler o;
    public Messenger p;
    public Runnable q;
    public Runnable r;
    public Runnable s;
    public Runnable t;

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
            if (android.text.TextUtils.equals(r1, r6.this$0.k.f35277f) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.k.f35277f) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
            r6.this$0.O();
            r0 = r6.this$0.w(null);
            b.a.e.i.h.a.b().g("plugin_retry_install_succ");
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
                    if (this.this$0.f2247i == null || !TextUtils.equals(null, this.this$0.f2247i.f35277f)) {
                        if (this.this$0.k == null || !TextUtils.equals(null, this.this$0.k.f35277f)) {
                            this.this$0.w(null);
                            return;
                        }
                        this.this$0.O();
                        this.this$0.w(null);
                        b.a.e.i.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.L();
                    this.this$0.f2247i = null;
                    this.this$0.w(null);
                    return;
                }
                try {
                    str = intent.getStringExtra("package_name");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        if (this.this$0.f2247i == null || !TextUtils.equals(str, this.this$0.f2247i.f35277f)) {
                            if (this.this$0.k != null) {
                            }
                            this.this$0.w(null);
                            return;
                        }
                        this.this$0.L();
                        this.this$0.f2247i = null;
                        this.this$0.w(null);
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (this.this$0.f2247i == null || !TextUtils.equals(null, this.this$0.f2247i.f35277f)) {
                        if (this.this$0.k == null || !TextUtils.equals(null, this.this$0.k.f35277f)) {
                            this.this$0.w(null);
                        } else {
                            this.this$0.O();
                            this.this$0.w(null);
                            b.a.e.i.h.a.b().g("plugin_retry_install_succ");
                        }
                    } else {
                        this.this$0.L();
                        this.this$0.f2247i = null;
                        this.this$0.w(null);
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(str)) {
                    if (this.this$0.f2247i == null || !TextUtils.equals(str, this.this$0.f2247i.f35277f)) {
                        if (this.this$0.k == null || !TextUtils.equals(str, this.this$0.k.f35277f)) {
                            this.this$0.w(null);
                            return;
                        }
                        this.this$0.O();
                        this.this$0.w(null);
                        b.a.e.i.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.L();
                    this.this$0.f2247i = null;
                    this.this$0.w(null);
                    return;
                }
                String stringExtra = intent.getStringExtra("install_src_file");
                boolean z = stringExtra != null && stringExtra.startsWith("assets://");
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    this.this$0.C(str, z);
                    b.a.e.i.j.h.a.b().e(str);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    if (z) {
                        this.this$0.f2244f = false;
                    }
                    this.this$0.C(str, z);
                    b.a.e.i.j.h.a.b().d(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    this.this$0.C(str, z);
                } else {
                    "com.baidu.adp.plugin.installrepeat".equals(action);
                }
                if (this.this$0.f2247i == null || !TextUtils.equals(str, this.this$0.f2247i.f35277f)) {
                    if (this.this$0.k != null) {
                    }
                    this.this$0.w(null);
                    return;
                }
                this.this$0.L();
                this.this$0.f2247i = null;
                this.this$0.w(null);
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
        public final /* synthetic */ Intent f2248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f2249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f2250g;

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
            this.f2250g = cVar;
            this.f2248e = intent;
            this.f2249f = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f2250g.m = new Messenger(iBinder);
                String stringExtra = this.f2248e.getStringExtra("package_name");
                if (this.f2250g.f2247i == null || !TextUtils.equals(stringExtra, this.f2250g.f2247i.f35277f)) {
                    return;
                }
                try {
                    this.f2249f.startService(this.f2248e);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f2250g.M();
            }
        }
    }

    /* renamed from: b.a.e.i.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0035c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f2251a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0035c(c cVar, Looper looper) {
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
            this.f2251a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f2251a.f2247i == null || message == null) {
                return;
            }
            try {
                if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).f35277f, this.f2251a.f2247i.f35277f)) {
                    c.u.removeCallbacks(this.f2251a.r);
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
        public final /* synthetic */ c f2252e;

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
            this.f2252e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2252e.u();
                this.f2252e.J();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2253e;

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
            this.f2253e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2253e.K();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2254e;

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
            this.f2254e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2254e.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2255e;

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
            this.f2255e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2255e.P();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends BdAsyncTask<String, Object, String[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f2256a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f2257b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f2258c;

        /* loaded from: classes.dex */
        public class a implements Comparator<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f2259e;

            public a(h hVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2259e = hashMap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                    PluginStatus pluginStatus = (PluginStatus) this.f2259e.get(str);
                    PluginStatus pluginStatus2 = (PluginStatus) this.f2259e.get(str2);
                    if (pluginStatus == null || pluginStatus2 == null) {
                        if (pluginStatus == null || pluginStatus2 != null) {
                            return (pluginStatus != null || pluginStatus2 == null) ? 0 : 1;
                        }
                        return -1;
                    }
                    return pluginStatus2.w() - pluginStatus.w();
                }
                return invokeLL.intValue;
            }
        }

        public h(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2258c = cVar;
            this.f2256a = null;
            this.f2257b = new String[]{"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
            this.f2256a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String[] doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, strArr)) != null) {
                return (String[]) invokeL.objValue;
            }
            Context context = this.f2256a;
            InputStream inputStream = null;
            if (context == null) {
                return null;
            }
            try {
                AssetManager assets = context.getAssets();
                String[] list = assets.list("plugins");
                if (list != null) {
                    try {
                        if (list.length > 0) {
                            HashMap hashMap = new HashMap();
                            try {
                                inputStream = assets.open("plugins/plugin.config");
                            } catch (IOException unused) {
                                BdLog.e("plugin.config file not in assets");
                            }
                            if (inputStream != null) {
                                try {
                                    byte[] bArr = new byte[inputStream.available()];
                                    inputStream.read(bArr);
                                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (next instanceof String) {
                                            String str = next;
                                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                            if (!str.endsWith(".apk")) {
                                                str = str + ".apk";
                                            }
                                            PluginStatus pluginStatus = (PluginStatus) OrmObject.objectWithJson(optJSONObject, PluginStatus.class);
                                            if (pluginStatus != null) {
                                                hashMap.put(str, pluginStatus);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                m.e(inputStream);
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new a(this, hashMap));
                                return list;
                            }
                            return list;
                        }
                        return list;
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = list;
                        BdLog.e(e);
                        return inputStream;
                    }
                }
                return list;
            } catch (Exception e4) {
                e = e4;
            }
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (Build.VERSION.SDK_INT <= 10) {
                    for (String str2 : this.f2257b) {
                        if (str.contains(str2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
                super.onPostExecute(strArr);
                int i2 = 0;
                if (strArr != null && strArr.length > 0) {
                    int length = strArr.length;
                    int i3 = 0;
                    while (i2 < length) {
                        String str = strArr[i2];
                        if (str != null && str.endsWith(".apk") && c(str)) {
                            c cVar = this.f2258c;
                            Context context = this.f2256a;
                            if (cVar.D(context, "plugins/" + str, "install_from_start")) {
                                i3 = 1;
                            }
                        }
                        i2++;
                    }
                    i2 = i3;
                }
                if (i2 != 0 || this.f2258c.f2243e == null) {
                    return;
                }
                this.f2258c.f2243e.a(this.f2258c.f2244f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1196857783, "Lb/a/e/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1196857783, "Lb/a/e/i/g/c;");
                return;
            }
        }
        u = new Handler(Looper.getMainLooper());
        v = null;
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
        this.f2239a = false;
        this.f2240b = null;
        this.f2241c = null;
        this.f2242d = false;
        this.f2244f = true;
        this.f2245g = null;
        this.f2246h = new Object();
        this.j = new LinkedList<>();
        this.l = new LinkedList<>();
        this.o = new HandlerC0035c(this, Looper.getMainLooper());
        this.p = new Messenger(this.o);
        this.q = new d(this);
        this.r = new e(this);
        this.s = new f(this);
        this.t = new g(this);
        this.f2240b = new ArrayList<>();
        this.f2241c = new a(this);
        Q();
    }

    public static File A(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            PluginSetting P = PluginPackageManager.O().P(str);
            if (P == null || (str2 = P.apkPath) == null || str2.length() <= 0) {
                return null;
            }
            return new File(P.apkPath);
        }
        return (File) invokeL.objValue;
    }

    public static c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (v == null) {
                synchronized (c.class) {
                    if (v == null) {
                        v = new c();
                    }
                }
            }
            return v;
        }
        return (c) invokeV.objValue;
    }

    public final void C(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            if (this.f2240b.contains(str)) {
                this.f2240b.remove(str);
            }
            if (!this.f2242d && z && this.f2240b.isEmpty()) {
                this.f2242d = true;
                b.a.e.i.g.a aVar = this.f2243e;
                if (aVar != null) {
                    aVar.a(this.f2244f);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
                v();
            }
        }
    }

    public final boolean D(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        PluginSetting pluginSetting;
        InputStream inputStream;
        FileInputStream fileInputStream;
        b.a.e.i.k.f x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".apk");
            int i2 = lastIndexOf + 1;
            if (i2 >= lastIndexOf2) {
                return false;
            }
            String substring = str.substring(i2, lastIndexOf2);
            PluginSetting P = PluginPackageManager.O().P(substring);
            if (substring == null || substring.length() <= 0 || P == null || P.apkPath == null) {
                pluginSetting = P;
            } else {
                File file = new File(P.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            x = Util.x(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            try {
                                try {
                                } catch (Throwable th) {
                                    th = th;
                                    b.a.e.f.m.a.c(fileInputStream);
                                    b.a.e.f.m.a.c(inputStream);
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                pluginSetting = P;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            pluginSetting = P;
                            inputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            b.a.e.f.m.a.c(fileInputStream);
                            b.a.e.f.m.a.c(inputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        pluginSetting = P;
                        inputStream = null;
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        fileInputStream = null;
                    }
                    if (x.compareTo(Util.x(inputStream)) == 0) {
                        if (this.f2243e != null) {
                            this.f2243e.b(substring);
                        }
                        pluginSetting = P;
                        try {
                            b.a.e.i.h.a.b().o("plugin_install", "install_timeequals", substring, x.toString());
                            b.a.e.f.m.a.c(fileInputStream);
                            b.a.e.f.m.a.c(inputStream);
                            return false;
                        } catch (Exception e5) {
                            e = e5;
                            BdLog.e(e);
                            b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                            b2.o("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                            b.a.e.f.m.a.c(fileInputStream);
                            b.a.e.f.m.a.c(inputStream);
                            T(context, "assets://" + str, false);
                            b.a.e.i.h.a.b().d("plugin_install", substring, pluginSetting, str2);
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, b.a.e.i.j.h.a.b().c(substring)));
                            return true;
                        }
                    }
                    pluginSetting = P;
                    b.a.e.f.m.a.c(fileInputStream);
                    b.a.e.f.m.a.c(inputStream);
                } else {
                    pluginSetting = P;
                    b.a.e.i.h.a b3 = b.a.e.i.h.a.b();
                    b3.o("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            T(context, "assets://" + str, false);
            b.a.e.i.h.a.b().d("plugin_install", substring, pluginSetting, str2);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, b.a.e.i.j.h.a.b().c(substring)));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void E(Context context, b.a.e.i.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar) == null) {
            this.f2243e = aVar;
            h hVar = this.f2245g;
            if (hVar != null) {
                hVar.cancel();
                this.f2245g = null;
            }
            h hVar2 = new h(this, context);
            this.f2245g = hVar2;
            hVar2.setPriority(4);
            this.f2245g.execute(new String[0]);
        }
    }

    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            T(context, "file://" + str, false);
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? z() > 0 : invokeV.booleanValue;
    }

    public boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PluginInstallTask pluginInstallTask = this.f2247i;
            if (pluginInstallTask != null) {
                return TextUtils.equals(str, pluginInstallTask.f35277f);
            }
            PluginInstallTask pluginInstallTask2 = this.k;
            if (pluginInstallTask2 != null) {
                return TextUtils.equals(str, pluginInstallTask2.f35277f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.n != null) {
                BdBaseApplication.getInst().getApplicationContext().unbindService(this.n);
            }
            this.n = null;
            this.m = null;
            int z = z();
            if (z <= 0 || z == Process.myPid()) {
                return;
            }
            Process.killProcess(z);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            u.removeCallbacks(this.q);
            u.postDelayed(this.q, 10000L);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.e.i.h.a.b().g("plugin_installprocess_noresponse");
            b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.f2247i;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f35277f;
            b2.o("plugin_install", "installprocess_noresponse", str, this.j.size() + "-" + this.l.size());
            L();
            I();
            S();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            u.removeCallbacks(this.q);
            u.removeCallbacks(this.s);
            u.removeCallbacks(this.r);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.n = null;
            this.m = null;
            b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.f2247i;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f35277f;
            b2.o("plugin_install", "system_kill_installprocess", str, this.j.size() + "-" + this.l.size());
            L();
            S();
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f2247i != null) {
                b.a.e.i.j.h.a.b().d(this.f2247i.f35277f, "plugin_install_timeout", null);
            }
            PluginInstallTask pluginInstallTask = this.f2247i;
            if (!G()) {
                b.a.e.i.h.a.b().g("plugin_install_timeout_installprocess_notlive");
                b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                String str = pluginInstallTask == null ? "" : pluginInstallTask.f35277f;
                StringBuilder sb = new StringBuilder();
                sb.append("timeout-");
                sb.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.w()) : "");
                sb.append("-");
                sb.append(this.j.size());
                sb.append("-");
                sb.append(this.l.size());
                b2.o("plugin_install", "timeout_installprocess_notlive", str, sb.toString());
            } else {
                b.a.e.i.h.a.b().g("plugin_install_timeout");
                b.a.e.i.h.a b3 = b.a.e.i.h.a.b();
                String str2 = pluginInstallTask == null ? "" : pluginInstallTask.f35277f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("timeout-");
                sb2.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.w()) : "");
                sb2.append("-");
                sb2.append(this.j.size());
                sb2.append("-");
                sb2.append(this.l.size());
                b3.o("plugin_install", "timeout", str2, sb2.toString());
            }
            L();
            I();
            S();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = null;
            u.removeCallbacks(this.t);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.k != null) {
                b.a.e.i.j.h.a.b().d(this.k.f35277f, "plugin_install_retry_timeout", null);
            }
            b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
            PluginInstallTask pluginInstallTask = this.k;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f35277f;
            StringBuilder sb = new StringBuilder();
            sb.append("timeout-");
            PluginInstallTask pluginInstallTask2 = this.k;
            sb.append(pluginInstallTask2 != null ? Long.valueOf(pluginInstallTask2.w()) : "");
            sb.append("-");
            sb.append(this.j.size());
            sb.append("-");
            sb.append(this.l.size());
            b2.o("plugin_install", "timeout", str, sb.toString());
            O();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f2239a) {
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
            applicationContext.registerReceiver(this.f2241c, intentFilter);
            this.f2239a = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void R(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048591, this, str, i2) == null) && i2 == 1) {
            BdBaseApplication inst = BdBaseApplication.getInst();
            D(inst, "plugins/" + str + ".apk", "install_from_rollback");
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f2247i != null) {
                b.a.e.i.h.a.b().i("plugin_retry_install", this.f2247i.f35277f);
                b.a.e.i.h.a b2 = b.a.e.i.h.a.b();
                String str = this.f2247i.f35277f;
                b2.o("plugin_install", "plugin_retry_install", str, this.f2247i.w() + "");
                y(this.f2247i);
                this.f2247i = null;
                return;
            }
            w(null);
        }
    }

    public final void T(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048593, this, context, str, z) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Q();
        PluginInstallTask pluginInstallTask = new PluginInstallTask();
        pluginInstallTask.f35276e = str;
        boolean z2 = true;
        if (str.startsWith("assets://")) {
            r8 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
            try {
                pluginInstallTask.f35279h = context.getAssets().open(str.substring(9)).available();
            } catch (IOException e2) {
                BdLog.detailException(e2);
            }
        } else {
            if (str.startsWith("file://")) {
                PackageManager packageManager = context.getPackageManager();
                String substring = str.substring(7);
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring, 0);
                r8 = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
                pluginInstallTask.f35279h = new File(substring).length();
            }
            z2 = false;
        }
        if (r8 != null) {
            pluginInstallTask.f35277f = r8;
            if (w(pluginInstallTask) && z2) {
                this.f2240b.add(r8);
                return;
            }
            return;
        }
        pluginInstallTask.f35277f = str;
        w(pluginInstallTask);
    }

    public final boolean U(Context context, PluginInstallTask pluginInstallTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, context, pluginInstallTask)) == null) {
            if (pluginInstallTask == null) {
                return false;
            }
            PluginSetting h2 = b.a.e.i.j.g.d.k().h(pluginInstallTask.f35277f);
            String str = pluginInstallTask.f35276e;
            boolean z = str != null && str.startsWith("assets://");
            String str2 = pluginInstallTask.f35276e;
            if (str2 != null && str2.startsWith("file://")) {
                if (h2 != null && h2.installStatus == 0 && h2.tempVersionCode == 0) {
                    b.a.e.i.h.a.b().o("plugin_install", "start_service_install_status_error", pluginInstallTask.f35277f, "apkFilePath_" + pluginInstallTask.f35276e);
                    return false;
                }
                String substring = pluginInstallTask.f35276e.substring(7);
                try {
                    if (!new File(substring).exists()) {
                        b.a.e.i.h.a.b().o("plugin_install", "start_service_file_not_find", pluginInstallTask.f35277f, "apkFilePath_" + substring);
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            String str3 = "f" + System.currentTimeMillis();
            b.a.e.i.h.a.b().o("plugin_install", "start_install_service", pluginInstallTask.f35277f, "flag=" + str3 + "_" + pluginInstallTask.f35276e);
            Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
            intent.putExtra("install_src_file", pluginInstallTask.f35276e);
            intent.putExtra("package_name", pluginInstallTask.f35277f);
            intent.putExtra("install_flag", str3);
            if (h2 != null) {
                intent.putExtra("plugin_setting", h2);
            }
            intent.putExtra("is_debug_plugin", PluginPackageManager.O().e0());
            if (pluginInstallTask.f35278g) {
                intent.setClass(context, PluginInstallerRetryService.class);
                try {
                    context.startService(intent);
                    return true;
                } catch (Throwable unused2) {
                    return false;
                }
            }
            intent.setClass(context, PluginInstallerService.class);
            if (this.n == null && z) {
                ServiceConnection bVar = new b(this, intent, context);
                this.n = bVar;
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

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.m == null || this.f2247i == null) {
            return;
        }
        Message message = new Message();
        try {
            message.setData(OrmObject.bundleWithObject(this.f2247i));
            message.replyTo = this.p;
            this.m.send(message);
        } catch (RemoteException e2) {
            BdLog.detailException(e2);
        }
        u.removeCallbacks(this.r);
        u.postDelayed(this.r, 1000L);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.n == null) {
            return;
        }
        BdBaseApplication.getInst().unbindService(this.n);
        this.n = null;
    }

    public final boolean w(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, pluginInstallTask)) == null) {
            if (x(pluginInstallTask)) {
                return true;
            }
            return y(pluginInstallTask);
        }
        return invokeL.booleanValue;
    }

    public final boolean x(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pluginInstallTask)) == null) {
            synchronized (this.f2246h) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.j.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.f2247i != null) {
                    Iterator<PluginInstallTask> it = this.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.f35277f, next.f35277f)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.j.add(pluginInstallTask);
                    }
                    return true;
                }
                this.f2247i = pluginInstallTask;
                if (U(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    J();
                    u.removeCallbacks(this.s);
                    u.postDelayed(this.s, this.f2247i.w());
                    return true;
                }
                this.f2247i = null;
                return w(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean y(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pluginInstallTask)) == null) {
            synchronized (this.f2246h) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.l.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.k != null) {
                    Iterator<PluginInstallTask> it = this.l.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.f35277f, next.f35277f)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.l.add(pluginInstallTask);
                    }
                    return true;
                }
                this.k = pluginInstallTask;
                pluginInstallTask.f35278g = true;
                if (U(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    u.removeCallbacks(this.t);
                    u.postDelayed(this.t, this.k.w());
                    return true;
                }
                return w(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final int z() {
        InterceptResult invokeV;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
}
