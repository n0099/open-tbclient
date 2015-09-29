package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginCenter {
    public static final String NAME_LIGHTAPP = "com.baidu.tieba.pluginLightApp";
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    private static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    private static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    private static volatile PluginCenter mInstance = null;
    private String mCommonErrorShowText;
    private HashMap<String, a> mPluginsMap;
    private Handler mHandler = new Handler();
    private boolean hadRecordPluginLoadLogger = false;
    private Runnable mRunnable = new b(this);
    private Runnable mRetryRunnable = new c(this);

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
        this.mPluginsMap = new HashMap<>();
        this.mCommonErrorShowText = "内部错误，请稍后重试~";
        String packageName = BdBaseApplication.getInst().getPackageName();
        a aVar = new a();
        this.mPluginsMap.put(packageName, aVar);
        aVar.ku();
    }

    public a.b launch(String str) {
        a.b bVar = new a.b();
        bVar.pkgName = str;
        k.jb();
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            bVar.Cj = false;
        } else if (this.mPluginsMap.containsKey(str)) {
            bVar.Cj = false;
        } else {
            a aVar = new a();
            this.mPluginsMap.put(str, aVar);
            if (!aVar.aZ(str).Cj) {
                this.mHandler.removeCallbacks(this.mRunnable);
                this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
            }
        }
        return bVar;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        k.jb();
        if (context == null || TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        a aVar = this.mPluginsMap.get(str);
        if (aVar == null || !aVar.isLoaded()) {
            return false;
        }
        return aVar.i(context, intent);
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        k.jb();
        if (context == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        a aVar = this.mPluginsMap.get(str);
        if (aVar == null || !aVar.isLoaded()) {
            return false;
        }
        return aVar.a(context, intent, serviceConnection, i);
    }

    public boolean releasePlugin(String str) {
        k.jb();
        if (str == null) {
            return false;
        }
        a remove = this.mPluginsMap.remove(str);
        if (remove == null || !remove.isLoaded()) {
            return false;
        }
        remove.destroy();
        return true;
    }

    public boolean hasInstance(String str) {
        k.jb();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        k.jb();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = this.mPluginsMap.get(str);
        return aVar != null && aVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bD(str);
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

    public a getPlugin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mPluginsMap.get(str);
    }

    public String getPluginFilePathByClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().ba(str)) {
                return entry.getValue().ko();
            }
        }
        return BdBaseApplication.getInst().getPackageCodePath();
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().kq() != null && entry.getValue().kq().equals(classLoader)) {
                return entry.getValue().getPackageName();
            }
        }
        return BdBaseApplication.getInst().getPackageName();
    }

    public String getPluginFilePathByPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null) {
                String ko = entry.getValue().ko();
                if (!TextUtils.isEmpty(ko) && ko.contains(str)) {
                    return ko;
                }
            }
        }
        return null;
    }

    public ArrayList<a> getAllPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadNativeLibrary(String str, String str2) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a plugin2 = getPlugin(str);
            if (plugin2 != null) {
                try {
                    System.load(new File(plugin2.kp(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
                    z = true;
                } catch (UnsatisfiedLinkError e) {
                    BdLog.e(e.getMessage());
                }
                if (z) {
                    System.loadLibrary(str2);
                    return;
                }
                return;
            }
            z = false;
            if (z) {
            }
        }
    }

    public <P> P getSocialShareClassInstance() {
        if (PluginPackageManager.lR().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getDqClassInstance() {
        if (PluginPackageManager.lR().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.lR().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.lR().bs(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.lR().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.lR().bs(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
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
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.km() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                    if (value.aZ(key).Cj) {
                        if (PluginPackageManager.lR().hp()) {
                            com.baidu.adp.plugin.b.a.lF().bj("plugin_load_retry_succ");
                        }
                    } else {
                        i++;
                        if (PluginPackageManager.lR().hp()) {
                            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(key);
                            if (findPluginSetting != null) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(findPluginSetting.packageName);
                                sb.append("-");
                                sb.append(findPluginSetting.apkPath);
                                sb.append("-");
                                sb.append(findPluginSetting.forbidden);
                                sb.append("-");
                                sb.append(findPluginSetting.enable);
                                sb.append("-");
                                sb.append(findPluginSetting.installStatus);
                                sb.append("-");
                                sb.append(findPluginSetting.versionCode);
                                sb.append("-");
                                sb.append(findPluginSetting.install_fail_count);
                                sb.append("-");
                                sb.append(findPluginSetting.getAbandon_apk_path());
                            } else {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(key);
                                sb.append("-");
                                sb.append(value.ko());
                            }
                        }
                    }
                }
            }
        }
        if (PluginPackageManager.lR().hp() && i > 0) {
            com.baidu.adp.plugin.b.a.lF().d("plugin_load", "retry_load_singleplugin", null, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.km() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                    a.b aZ = value.aZ(key);
                    if (aZ.Cj) {
                        if (PluginPackageManager.lR().hp()) {
                            com.baidu.adp.plugin.b.a.lF().bj("plugin_load_retry_succ");
                        }
                    } else if (PluginPackageManager.lR().hp()) {
                        com.baidu.adp.plugin.b.a.lF().h("plugin_loaded_failed", key, aZ.reason);
                    }
                }
                if (value != null) {
                    if (value.isLoaded()) {
                        i2++;
                    } else {
                        i++;
                        if (PluginPackageManager.lR().hp()) {
                            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(key);
                            if (findPluginSetting != null) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(findPluginSetting.packageName);
                                sb.append("-");
                                sb.append(findPluginSetting.apkPath);
                                sb.append("-");
                                sb.append(findPluginSetting.forbidden);
                                sb.append("-");
                                sb.append(findPluginSetting.enable);
                                sb.append("-");
                                sb.append(findPluginSetting.installStatus);
                                sb.append("-");
                                sb.append(findPluginSetting.versionCode);
                                sb.append("-");
                                sb.append(findPluginSetting.install_fail_count);
                                sb.append("-");
                                sb.append(findPluginSetting.getAbandon_apk_path());
                            } else {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(key);
                                sb.append("-");
                                sb.append(value.ko());
                            }
                        }
                        com.baidu.adp.plugin.packageManager.a.b.mt().bG(value.getPackageName());
                    }
                }
            }
        }
        if (PluginPackageManager.lR().hp() && i > 0) {
            com.baidu.adp.plugin.b.a.lF().d("plugin_load", "retry_load_allplugin", null, sb.toString());
        }
        if (!this.hadRecordPluginLoadLogger && this.mPluginsMap.size() > 1) {
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.lR().hp()) {
                if (i2 + i > 0) {
                    com.baidu.adp.plugin.b.a.lF().k("plugin_load", i2 + i);
                }
                if (i <= 0 && com.baidu.adp.plugin.b.a.lF().lH()) {
                    com.baidu.adp.plugin.b.a.lF().bj("plugin_load_resolve");
                }
                com.baidu.adp.plugin.b.a.lF().M(false);
            }
        }
    }
}
