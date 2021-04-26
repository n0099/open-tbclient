package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import d.a.c.e.p.l;
import d.a.c.h.j.g.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PluginCenter {
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    public static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    public static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    public static volatile PluginCenter mInstance;
    public String mCommonErrorShowText;
    public ConcurrentHashMap<String, Plugin> mPluginsMap;
    public Handler mHandler = new Handler();
    public boolean hadRecordPluginLoadLogger = false;
    public Runnable mRunnable = new a();
    public Runnable mRetryRunnable = new b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PluginCenter.this.retryLaunchPlugins();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PluginCenter.this.retryLaunchAllPlugins();
        }
    }

    public PluginCenter() {
        this.mPluginsMap = null;
        this.mCommonErrorShowText = null;
        this.mPluginsMap = new ConcurrentHashMap<>();
        this.mCommonErrorShowText = "内部错误，请稍后重试~";
        String packageName = BdBaseApplication.getInst().getPackageName();
        Plugin plugin2 = new Plugin();
        this.mPluginsMap.put(packageName, plugin2);
        plugin2.initBuildInCodePlugin();
    }

    public static PluginCenter getInstance() {
        if (mInstance == null) {
            synchronized (PluginCenter.class) {
                if (mInstance == null) {
                    mInstance = new PluginCenter();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
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
                    PluginSetting h2 = d.k().h(key);
                    if (h2 == null || !h2.isPatch || (!TextUtils.isEmpty(h2.replaceMethodClasses) && PluginPackageManager.O().Q() <= 0)) {
                        long j = 4001;
                        if (value != null && !value.isLoaded()) {
                            j = System.currentTimeMillis() - value.getLastLaunchTime();
                            if (j > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                cVar = value.initWithBroadcast(key);
                                if (cVar.f2190a) {
                                    if (PluginPackageManager.O().c0()) {
                                        d.a.c.h.h.a.b().g("plugin_load_retry_succ");
                                    }
                                } else if (PluginPackageManager.O().c0()) {
                                    d.a.c.h.h.a.b().p("plugin_loaded_failed", key, cVar.f2191b, cVar.f2192c);
                                }
                            }
                        }
                        if (value != null) {
                            if (value.isLoaded()) {
                                i3++;
                            } else {
                                i2++;
                                if (PluginPackageManager.O().c0()) {
                                    PluginSetting h3 = d.k().h(key);
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
                                        sb.append(cVar.f2191b);
                                        sb.append("-");
                                        sb.append(cVar.f2192c);
                                    } else {
                                        sb.append("-ret==null");
                                    }
                                }
                                if (j > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                    d.a.c.h.j.h.a.b().f(value.getPackageName());
                                }
                            }
                        }
                    }
                }
            }
            if (PluginPackageManager.O().c0() && i2 > 0) {
                d.a.c.h.h.a.b().o("plugin_load", "retry_load_allplugin", null, sb.toString());
            }
            if (this.hadRecordPluginLoadLogger || this.mPluginsMap.size() <= 1) {
                return;
            }
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.O().c0()) {
                int i4 = i3 + i2;
                if (i4 > 0) {
                    d.a.c.h.h.a.b().h("plugin_load", i4);
                }
                if (i2 <= 0 && d.a.c.h.h.a.b().f()) {
                    d.a.c.h.h.a.b().g("plugin_load_resolve");
                }
                d.a.c.h.h.a.b().u(false);
                return;
            }
            return;
        }
        this.mHandler.removeCallbacks(this.mRetryRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchPlugins() {
        ConcurrentHashMap<String, Plugin> concurrentHashMap = this.mPluginsMap;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    String key = entry.getKey();
                    Plugin value = entry.getValue();
                    PluginSetting h2 = d.k().h(key);
                    if (h2 != null) {
                        if (!h2.isPatch || !TextUtils.isEmpty(h2.replaceMethodClasses)) {
                            if (h2.isPatch && PluginPackageManager.O().Q() > 0) {
                            }
                        }
                    }
                    if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.getLastLaunchTime() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                        Plugin.c initWithBroadcast = value.initWithBroadcast(key);
                        if (initWithBroadcast.f2190a) {
                            if (PluginPackageManager.O().c0()) {
                                d.a.c.h.h.a.b().g("plugin_load_retry_succ");
                            }
                        } else {
                            i2++;
                            if (PluginPackageManager.O().c0()) {
                                PluginSetting h3 = d.k().h(key);
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
                                sb.append(initWithBroadcast.f2191b);
                                sb.append("-");
                                sb.append(initWithBroadcast.f2192c);
                            }
                        }
                    }
                }
            }
            if (!PluginPackageManager.O().c0() || i2 <= 0) {
                return;
            }
            d.a.c.h.h.a.b().o("plugin_load", "retry_load_singleplugin", null, sb.toString());
            return;
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        l.d();
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

    public ArrayList<Plugin> getAllPlugins() {
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

    public String getCommonErrorShowText() {
        return this.mCommonErrorShowText;
    }

    public int getHostResourcesId(Context context, String str, String str2, String str3) {
        if (context != null) {
            return context.getResources().getIdentifier(str2, str3, context.getPackageName());
        }
        return 0;
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.O().a0("com.baidu.tbadk.motu_gallery") || PluginPackageManager.O().b0(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.O().c0()) {
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                b2.o("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
            }
            return null;
        }
    }

    public Plugin getPlugin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mPluginsMap.get(str);
    }

    public String getPluginFilePathByClassName(String str) {
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

    public String getPluginFilePathByPackage(String str) {
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

    public String getPluginNameByClassloader(ClassLoader classLoader) {
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

    public boolean hasInstance(String str) {
        l.d();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isEnable(String str) {
        if (isLoaded(str)) {
            return !d.k().n(str);
        }
        return false;
    }

    public boolean isLoaded(String str) {
        Plugin plugin2;
        l.d();
        return (TextUtils.isEmpty(str) || (plugin2 = this.mPluginsMap.get(str)) == null || !plugin2.isLoaded()) ? false : true;
    }

    public Plugin.c launch(String str) {
        return launch(str, true);
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        l.d();
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

    public boolean releasePlugin(String str) {
        Plugin remove;
        l.d();
        if (str == null || (remove = this.mPluginsMap.remove(str)) == null || !remove.isLoaded()) {
            return false;
        }
        remove.destroy();
        return true;
    }

    public void setCommonErrorShowText(String str) {
        this.mCommonErrorShowText = str;
    }

    public void startRetryLaunchPlugins() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRetryRunnable);
            this.mHandler.post(this.mRetryRunnable);
        }
    }

    public void stopRetryLaunchPlugins() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRetryRunnable);
        }
    }

    public Plugin.c launch(String str, boolean z) {
        Plugin.c cVar = new Plugin.c();
        if (TextUtils.isEmpty(str)) {
            if (!BdBaseApplication.getInst().isDebugMode()) {
                cVar.f2191b = "pluginName_is_null";
                cVar.f2190a = false;
                return cVar;
            }
            throw new IllegalArgumentException("plugincenter launch args exception!");
        }
        PluginSetting h2 = d.k().h(str);
        if (h2 == null) {
            cVar.f2191b = "pluginSetting_is_null";
            cVar.f2190a = false;
            return cVar;
        } else if (h2.versionCode < PluginPackageManager.L()) {
            cVar.f2191b = "launch_lowversion";
            cVar.f2190a = false;
            d.a.c.h.h.a.b().i("plugincenter_launch_lowversion", str);
            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
            b2.o("plugin_load", "plugincenter_load_lowversion", str, h2.apkPath + "-" + h2.versionCode + "-" + h2.forbidden + "-" + h2.tempVersionCode + "-" + h2.installStatus);
            d.k().D(str);
            if (z) {
                d.a.c.h.j.h.a.b().f(str);
            }
            return cVar;
        } else if (this.mPluginsMap.containsKey(str)) {
            cVar.f2190a = false;
            return cVar;
        } else {
            Plugin plugin2 = new Plugin();
            this.mPluginsMap.put(str, plugin2);
            Plugin.c initWithBroadcast = plugin2.initWithBroadcast(str);
            if (!initWithBroadcast.f2190a) {
                this.mHandler.removeCallbacks(this.mRunnable);
                this.mHandler.postDelayed(this.mRunnable, 10000L);
            }
            return initWithBroadcast;
        }
    }
}
