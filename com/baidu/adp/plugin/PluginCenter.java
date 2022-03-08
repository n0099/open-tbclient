package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d.j.j.f.c;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class PluginCenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    public static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    public static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    public static volatile PluginCenter mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hadRecordPluginLoadLogger;
    public String mCommonErrorShowText;
    public Handler mHandler;
    public ConcurrentHashMap<String, Plugin> mPluginsMap;
    public Runnable mRetryRunnable;
    public Runnable mRunnable;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginCenter f29852e;

        public a(PluginCenter pluginCenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29852e = pluginCenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29852e.retryLaunchPlugins();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PluginCenter f29853e;

        public b(PluginCenter pluginCenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29853e = pluginCenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29853e.retryLaunchAllPlugins();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2083026695, "Lcom/baidu/adp/plugin/PluginCenter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2083026695, "Lcom/baidu/adp/plugin/PluginCenter;");
        }
    }

    public PluginCenter() {
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
        this.mPluginsMap = null;
        this.mCommonErrorShowText = null;
        this.mHandler = new Handler();
        this.hadRecordPluginLoadLogger = false;
        this.mRunnable = new a(this);
        this.mRetryRunnable = new b(this);
        this.mPluginsMap = new ConcurrentHashMap<>();
        this.mCommonErrorShowText = "内部错误，请稍后重试~";
        String packageName = BdBaseApplication.getInst().getPackageName();
        Plugin plugin2 = new Plugin();
        this.mPluginsMap.put(packageName, plugin2);
        plugin2.initBuildInCodePlugin();
    }

    public static PluginCenter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mInstance == null) {
                synchronized (PluginCenter.class) {
                    if (mInstance == null) {
                        mInstance = new PluginCenter();
                    }
                }
            }
            return mInstance;
        }
        return (PluginCenter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ConcurrentHashMap<String, Plugin> concurrentHashMap = this.mPluginsMap;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0 && this.mPluginsMap.size() != 1) {
                StringBuilder sb = new StringBuilder();
                Iterator<Map.Entry<String, Plugin>> it = this.mPluginsMap.entrySet().iterator();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Plugin.c cVar = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Plugin> next = it.next();
                    if (next != null && next.getKey() != null && next.getValue() != null) {
                        String key = next.getKey();
                        Plugin value = next.getValue();
                        PluginSetting h2 = c.j().h(key);
                        if (h2 == null || !h2.isPatch || (!TextUtils.isEmpty(h2.replaceMethodClasses) && PluginPackageManager.u().w() <= 0)) {
                            long j2 = 4001;
                            if (value != null && !value.isLoaded()) {
                                j2 = System.currentTimeMillis() - value.getLastLaunchTime();
                                if (j2 > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                    cVar = value.initWithBroadcast(key);
                                    if (cVar.a) {
                                        if (PluginPackageManager.u().B()) {
                                            c.a.d.j.h.a.b().g("plugin_load_retry_succ");
                                        }
                                    } else if (PluginPackageManager.u().B()) {
                                        c.a.d.j.h.a.b().n("plugin_loaded_failed", key, cVar.f29849b, cVar.f29850c);
                                    }
                                }
                            }
                            if (value != null) {
                                if (value.isLoaded()) {
                                    i3++;
                                } else {
                                    i2++;
                                    if (PluginPackageManager.u().B()) {
                                        PluginSetting h3 = c.j().h(key);
                                        if (h3 != null) {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(h3.packageName);
                                            sb.append("-");
                                            sb.append(h3.apkPath);
                                            sb.append("-");
                                            sb.append(h3.forbidden);
                                            sb.append("-");
                                            sb.append(h3.enable);
                                            sb.append("-");
                                            sb.append(h3.installStatus);
                                            sb.append("-");
                                            sb.append(h3.versionCode);
                                            sb.append("-");
                                            sb.append(h3.install_fail_count);
                                            sb.append("-");
                                            sb.append(h3.getAbandon_apk_path());
                                        } else {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(key);
                                            sb.append("-");
                                            sb.append(value.getPluginApkFilePath());
                                        }
                                        if (cVar != null) {
                                            sb.append("-");
                                            sb.append(cVar.f29849b);
                                            sb.append("-");
                                            sb.append(cVar.f29850c);
                                        } else {
                                            sb.append("-ret==null");
                                        }
                                    }
                                    if (j2 > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                        c.a.d.j.j.g.a.b().f(value.getPackageName());
                                    }
                                }
                            }
                        }
                    }
                }
                if (PluginPackageManager.u().B() && i2 > 0) {
                    c.a.d.j.h.a.b().m("plugin_load", "retry_load_allplugin", null, sb.toString());
                }
                if (this.hadRecordPluginLoadLogger || this.mPluginsMap.size() <= 1) {
                    return;
                }
                this.hadRecordPluginLoadLogger = true;
                if (PluginPackageManager.u().B()) {
                    int i4 = i3 + i2;
                    if (i4 > 0) {
                        c.a.d.j.h.a.b().h("plugin_load", i4);
                    }
                    if (i2 <= 0 && c.a.d.j.h.a.b().f()) {
                        c.a.d.j.h.a.b().g("plugin_load_resolve");
                    }
                    c.a.d.j.h.a.b().s(false);
                    return;
                }
                return;
            }
            this.mHandler.removeCallbacks(this.mRetryRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchPlugins() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ConcurrentHashMap<String, Plugin> concurrentHashMap = this.mPluginsMap;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                int i2 = 0;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        String key = entry.getKey();
                        Plugin value = entry.getValue();
                        PluginSetting h2 = c.j().h(key);
                        if (h2 != null) {
                            if (!h2.isPatch || !TextUtils.isEmpty(h2.replaceMethodClasses)) {
                                if (h2.isPatch && PluginPackageManager.u().w() > 0) {
                                }
                            }
                        }
                        if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.getLastLaunchTime() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                            Plugin.c initWithBroadcast = value.initWithBroadcast(key);
                            if (initWithBroadcast.a) {
                                if (PluginPackageManager.u().B()) {
                                    c.a.d.j.h.a.b().g("plugin_load_retry_succ");
                                }
                            } else {
                                i2++;
                                if (PluginPackageManager.u().B()) {
                                    PluginSetting h3 = c.j().h(key);
                                    if (h3 != null) {
                                        if (sb.length() > 0) {
                                            sb.append(",");
                                        }
                                        sb.append(h3.packageName);
                                        sb.append("-");
                                        sb.append(h3.apkPath);
                                        sb.append("-");
                                        sb.append(h3.forbidden);
                                        sb.append("-");
                                        sb.append(h3.enable);
                                        sb.append("-");
                                        sb.append(h3.installStatus);
                                        sb.append("-");
                                        sb.append(h3.versionCode);
                                        sb.append("-");
                                        sb.append(h3.install_fail_count);
                                        sb.append("-");
                                        sb.append(h3.getAbandon_apk_path());
                                    } else {
                                        if (sb.length() > 0) {
                                            sb.append(",");
                                        }
                                        sb.append(key);
                                        sb.append("-");
                                        sb.append(value.getPluginApkFilePath());
                                    }
                                    sb.append("-");
                                    sb.append(initWithBroadcast.f29849b);
                                    sb.append("-");
                                    sb.append(initWithBroadcast.f29850c);
                                }
                            }
                        }
                    }
                }
                if (!PluginPackageManager.u().B() || i2 <= 0) {
                    return;
                }
                c.a.d.j.h.a.b().m("plugin_load", "retry_load_singleplugin", null, sb.toString());
                return;
            }
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, intent, serviceConnection, Integer.valueOf(i2)})) == null) {
            n.c();
            if (context == null) {
                if (BdBaseApplication.getInst().isDebugMode()) {
                    throw new IllegalArgumentException("plugincenter launchIntent args exception!");
                }
                return false;
            }
            Plugin plugin2 = this.mPluginsMap.get(str);
            if (plugin2 == null || !plugin2.isLoaded()) {
                return false;
            }
            return plugin2.bindService(context, intent, serviceConnection, i2);
        }
        return invokeCommon.booleanValue;
    }

    public ArrayList<Plugin> getAllPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ConcurrentHashMap<String, Plugin> concurrentHashMap = this.mPluginsMap;
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return null;
            }
            ArrayList<Plugin> arrayList = new ArrayList<>();
            for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(entry.getValue());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getCommonErrorShowText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCommonErrorShowText : (String) invokeV.objValue;
    }

    public int getHostResourcesId(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, str, str2, str3)) == null) {
            if (context != null) {
                return context.getResources().getIdentifier(str2, str3, context.getPackageName());
            }
            return 0;
        }
        return invokeLLLL.intValue;
    }

    public Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mPluginsMap.get(str);
        }
        return (Plugin) invokeL.objValue;
    }

    public String getPluginFilePathByClassName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                if (entry.getValue() != null && entry.getValue().containssClass(str)) {
                    return entry.getValue().getPluginApkFilePath();
                }
            }
            return BdBaseApplication.getInst().getPackageCodePath();
        }
        return (String) invokeL.objValue;
    }

    public String getPluginFilePathByPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                if (entry.getValue() != null) {
                    String pluginApkFilePath = entry.getValue().getPluginApkFilePath();
                    if (!TextUtils.isEmpty(pluginApkFilePath) && pluginApkFilePath.contains(str)) {
                        return pluginApkFilePath;
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, classLoader)) == null) {
            if (classLoader == null) {
                return null;
            }
            for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                if (entry.getValue() != null && entry.getValue().getDexClassLoader() != null && entry.getValue().getDexClassLoader().equals(classLoader)) {
                    return entry.getValue().getPackageName();
                }
            }
            return BdBaseApplication.getInst().getPackageName();
        }
        return (String) invokeL.objValue;
    }

    public boolean hasInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            n.c();
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.mPluginsMap.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public boolean isEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (isLoaded(str)) {
                return !c.j().m(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isLoaded(String str) {
        InterceptResult invokeL;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            n.c();
            return (TextUtils.isEmpty(str) || (plugin2 = this.mPluginsMap.get(str)) == null || !plugin2.isLoaded()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public Plugin.c launch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? launch(str, true) : (Plugin.c) invokeL.objValue;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, context, str, intent)) == null) {
            n.c();
            if (context != null && !TextUtils.isEmpty(str)) {
                Plugin plugin2 = this.mPluginsMap.get(str);
                if (plugin2 == null || !plugin2.isLoaded()) {
                    return false;
                }
                return plugin2.launchIntent(context, intent);
            } else if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            } else {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public boolean releasePlugin(String str) {
        InterceptResult invokeL;
        Plugin remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            n.c();
            if (str == null || (remove = this.mPluginsMap.remove(str)) == null || !remove.isLoaded()) {
                return false;
            }
            remove.destroy();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCommonErrorShowText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mCommonErrorShowText = str;
        }
    }

    public void startRetryLaunchPlugins() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (handler = this.mHandler) == null) {
            return;
        }
        handler.removeCallbacks(this.mRetryRunnable);
        this.mHandler.post(this.mRetryRunnable);
    }

    public void stopRetryLaunchPlugins() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (handler = this.mHandler) == null) {
            return;
        }
        handler.removeCallbacks(this.mRetryRunnable);
    }

    public Plugin.c launch(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            Plugin.c cVar = new Plugin.c();
            if (TextUtils.isEmpty(str)) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    cVar.f29849b = "pluginName_is_null";
                    cVar.a = false;
                    return cVar;
                }
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            PluginSetting h2 = c.j().h(str);
            if (h2 == null) {
                cVar.f29849b = "pluginSetting_is_null";
                cVar.a = false;
                return cVar;
            } else if (h2.versionCode < PluginPackageManager.t()) {
                cVar.f29849b = "launch_lowversion";
                cVar.a = false;
                c.a.d.j.h.a.b().i("plugincenter_launch_lowversion", str);
                c.a.d.j.h.a b2 = c.a.d.j.h.a.b();
                b2.m("plugin_load", "plugincenter_load_lowversion", str, h2.apkPath + "-" + h2.versionCode + "-" + h2.forbidden + "-" + h2.tempVersionCode + "-" + h2.installStatus);
                c.j().y(str);
                if (z) {
                    c.a.d.j.j.g.a.b().f(str);
                }
                return cVar;
            } else if (this.mPluginsMap.containsKey(str)) {
                cVar.a = false;
                return cVar;
            } else {
                Plugin plugin2 = new Plugin();
                this.mPluginsMap.put(str, plugin2);
                Plugin.c initWithBroadcast = plugin2.initWithBroadcast(str);
                if (!initWithBroadcast.a) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, 10000L);
                }
                return initWithBroadcast;
            }
        }
        return (Plugin.c) invokeLZ.objValue;
    }
}
