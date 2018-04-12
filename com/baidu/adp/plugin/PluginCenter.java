package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PluginCenter {
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    private static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    private static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    private static volatile PluginCenter mInstance = null;
    private String mCommonErrorShowText;
    private ConcurrentHashMap<String, Plugin> mPluginsMap;
    private Handler mHandler = new Handler();
    private boolean hadRecordPluginLoadLogger = false;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.adp.plugin.PluginCenter.1
        @Override // java.lang.Runnable
        public void run() {
            PluginCenter.this.retryLaunchPlugins();
        }
    };
    private Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.adp.plugin.PluginCenter.2
        @Override // java.lang.Runnable
        public void run() {
            PluginCenter.this.retryLaunchAllPlugins();
        }
    };

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

    private PluginCenter() {
        this.mPluginsMap = null;
        this.mCommonErrorShowText = null;
        this.mPluginsMap = new ConcurrentHashMap<>();
        this.mCommonErrorShowText = "内部错误，请稍后重试~";
        String packageName = BdBaseApplication.getInst().getPackageName();
        Plugin plugin2 = new Plugin();
        this.mPluginsMap.put(packageName, plugin2);
        plugin2.initBuildInCodePlugin();
    }

    public Plugin.b launch(String str) {
        Plugin.b bVar = new Plugin.b();
        bVar.Ak = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            bVar.Aj = false;
        } else {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(str);
            if (findPluginSetting == null) {
                bVar.Aj = false;
            } else if (findPluginSetting.versionCode < PluginPackageManager.iW()) {
                bVar.Aj = false;
                com.baidu.adp.plugin.b.a.iK().B("plugincenter_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.iK().f("plugin_load", "plugincenter_load_lowversion", str, findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().bH(str);
                com.baidu.adp.plugin.packageManager.status.a.jG().onLoadFailed(str);
            } else if (this.mPluginsMap.containsKey(str)) {
                bVar.Aj = false;
            } else {
                Plugin plugin2 = new Plugin();
                this.mPluginsMap.put(str, plugin2);
                bVar = plugin2.initWithBroadcast(str);
                if (!bVar.Aj) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
                }
            }
        }
        return bVar;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        l.he();
        if (context == null || TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        Plugin plugin2 = this.mPluginsMap.get(str);
        if (plugin2 == null || !plugin2.isLoaded()) {
            return false;
        }
        return plugin2.launchIntent(context, intent);
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        l.he();
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
        return plugin2.bindService(context, intent, serviceConnection, i);
    }

    public boolean releasePlugin(String str) {
        l.he();
        if (str == null) {
            return false;
        }
        Plugin remove = this.mPluginsMap.remove(str);
        if (remove == null || !remove.isLoaded()) {
            return false;
        }
        remove.destroy();
        return true;
    }

    public boolean hasInstance(String str) {
        l.he();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        l.he();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Plugin plugin2 = this.mPluginsMap.get(str);
        return plugin2 != null && plugin2.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().bF(str);
    }

    public int getHostResourcesId(Context context, String str, String str2, String str3) {
        if (context != null) {
            return context.getResources().getIdentifier(str2, str3, context.getPackageName());
        }
        return 0;
    }

    public void setCommonErrorShowText(String str) {
        this.mCommonErrorShowText = str;
    }

    public String getCommonErrorShowText() {
        return this.mCommonErrorShowText;
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

    public ArrayList<Plugin> getAllPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
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

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.iX().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.iX().bt(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.iX().isMainProcess()) {
                com.baidu.adp.plugin.b.a.iK().f("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public void stopRetryLaunchPlugins() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
        }
    }

    public void startRetryLaunchPlugins() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
            this.mHandler.post(this.mRetryRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                Plugin value = entry.getValue();
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(key);
                if (findPluginSetting != null) {
                    if (!findPluginSetting.isPatch || !TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        if (findPluginSetting.isPatch && PluginPackageManager.iX().jo() > 0) {
                        }
                    }
                }
                if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.getLastLaunchTime() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                    Plugin.b initWithBroadcast = value.initWithBroadcast(key);
                    if (initWithBroadcast.Aj) {
                        if (PluginPackageManager.iX().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.iK().bk("plugin_load_retry_succ");
                        }
                    } else {
                        i++;
                        if (PluginPackageManager.iX().isMainProcess()) {
                            PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(key);
                            if (findPluginSetting2 != null) {
                                if (sb.length() > 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append(findPluginSetting2.packageName);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.apkPath);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.forbidden);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.enable);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.installStatus);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.versionCode);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.install_fail_count);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(findPluginSetting2.getAbandon_apk_path());
                            } else {
                                if (sb.length() > 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append(key);
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb.append(value.getPluginApkFilePath());
                            }
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(initWithBroadcast.reason);
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(initWithBroadcast.Al);
                        }
                    }
                }
            }
            i = i;
        }
        if (PluginPackageManager.iX().isMainProcess()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.iK().f("plugin_load", "retry_load_singleplugin", null, sb.toString());
            }
            logPluginLoadStat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0 || this.mPluginsMap.size() == 1) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (Map.Entry<String, Plugin> entry : this.mPluginsMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                Plugin value = entry.getValue();
                Plugin.b bVar = null;
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(key);
                if (findPluginSetting == null || !findPluginSetting.isPatch || (!TextUtils.isEmpty(findPluginSetting.replaceMethodClasses) && PluginPackageManager.iX().jo() <= 0)) {
                    long j = 4001;
                    if (value != null && !value.isLoaded()) {
                        j = System.currentTimeMillis() - value.getLastLaunchTime();
                        if (j > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                            bVar = value.initWithBroadcast(key);
                            if (bVar.Aj) {
                                if (PluginPackageManager.iX().isMainProcess()) {
                                    com.baidu.adp.plugin.b.a.iK().bk("plugin_load_retry_succ");
                                }
                            } else if (PluginPackageManager.iX().isMainProcess()) {
                                com.baidu.adp.plugin.b.a.iK().h("plugin_loaded_failed", key, bVar.reason, bVar.Al);
                            }
                        }
                    }
                    if (value != null) {
                        if (value.isLoaded()) {
                            i2++;
                        } else {
                            i++;
                            if (PluginPackageManager.iX().isMainProcess()) {
                                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(key);
                                if (findPluginSetting2 != null) {
                                    if (sb.length() > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(findPluginSetting2.packageName);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.apkPath);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.forbidden);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.enable);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.installStatus);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.versionCode);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.install_fail_count);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(findPluginSetting2.getAbandon_apk_path());
                                } else {
                                    if (sb.length() > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(key);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(value.getPluginApkFilePath());
                                }
                                if (bVar != null) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(bVar.reason);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(bVar.Al);
                                } else {
                                    sb.append("-ret==null");
                                }
                            }
                            if (j > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                com.baidu.adp.plugin.packageManager.status.a.jG().onLoadFailed(value.getPackageName());
                            }
                        }
                    }
                }
            }
            i = i;
            i2 = i2;
        }
        if (PluginPackageManager.iX().isMainProcess() && i > 0) {
            com.baidu.adp.plugin.b.a.iK().f("plugin_load", "retry_load_allplugin", null, sb.toString());
        }
        if (!this.hadRecordPluginLoadLogger && this.mPluginsMap.size() > 1) {
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.iX().isMainProcess()) {
                if (i2 + i > 0) {
                    com.baidu.adp.plugin.b.a.iK().m("plugin_load", i2 + i);
                }
                if (i <= 0 && com.baidu.adp.plugin.b.a.iK().iM()) {
                    com.baidu.adp.plugin.b.a.iK().bk("plugin_load_resolve");
                }
                com.baidu.adp.plugin.b.a.iK().Q(false);
                recordPluginLoadRate();
            }
        }
    }

    private void recordPluginLoadRate() {
        String[] strArr = {"com.baidu.tieba.pluginall", "com.baidu.tieba.pluginInjectAll"};
        int length = strArr.length;
        float f = 0.0f;
        int length2 = strArr.length;
        int i = 0;
        while (i < length2) {
            Plugin plugin2 = this.mPluginsMap.get(strArr[i]);
            i++;
            f = (plugin2 == null || !plugin2.isLoaded()) ? f : 1.0f + f;
        }
        com.baidu.adp.plugin.b.a.iK().f("plugin_load", "load_rate", null, String.format("%.2f", Float.valueOf(f / length)));
        logPluginLoadStat();
    }

    public void logPluginLoadStat() {
        int i;
        String[] strArr = {"com.baidu.tieba.pluginall", "com.baidu.tieba.pluginInjectAll"};
        int length = strArr.length;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length2 = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str = strArr[i2];
            Plugin plugin2 = this.mPluginsMap.get(str);
            if (plugin2 != null && plugin2.isLoaded()) {
                i = i3 + 1;
                if (sb.length() > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                } else {
                    sb.append("suc-");
                }
                sb2.append(str);
            } else {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jz().findPluginSetting(str);
                if (sb2.length() > 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                } else {
                    sb2.append("fail-");
                }
                if (findPluginSetting != null) {
                    sb2.append(findPluginSetting.packageName);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.apkPath);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    if (findPluginSetting.apkPath != null) {
                        sb2.append("" + new File(findPluginSetting.apkPath).length());
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    sb2.append(findPluginSetting.enable);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.installStatus);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.versionCode);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.tempVersionCode);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.install_fail_count);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(findPluginSetting.getAbandon_apk_path());
                    i = i3;
                } else {
                    sb2.append(str);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append("null");
                    i = i3;
                }
            }
            i2++;
            i3 = i;
        }
        if (length > i3) {
            com.baidu.adp.plugin.b.a.iK().f("plugin_load", "plugin_loadstate", null, sb.toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sb2.toString());
        }
    }
}
