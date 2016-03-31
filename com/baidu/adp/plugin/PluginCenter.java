package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PluginCenter {
    public static final String NAME_LIGHTAPP = "com.baidu.tieba.pluginLightApp";
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    private static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    private static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    private static volatile PluginCenter mInstance = null;
    private String mCommonErrorShowText;
    private ConcurrentHashMap<String, Plugin> mPluginsMap;
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
        this.mPluginsMap = new ConcurrentHashMap<>();
        this.mCommonErrorShowText = "内部错误，请稍后重试~";
        String packageName = BdBaseApplication.getInst().getPackageName();
        Plugin plugin2 = new Plugin();
        this.mPluginsMap.put(packageName, plugin2);
        plugin2.initBuildInCodePlugin();
    }

    public Plugin.b launch(String str) {
        Plugin.b bVar = new Plugin.b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            bVar.CK = false;
        } else {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
            if (findPluginSetting == null) {
                bVar.CK = false;
            } else if (findPluginSetting.versionCode < PluginPackageManager.lr()) {
                bVar.CK = false;
                com.baidu.adp.plugin.b.a.lf().E("plugincenter_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "plugincenter_load_lowversion", str, String.valueOf(findPluginSetting.apkPath) + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bJ(str);
                com.baidu.adp.plugin.packageManager.a.b.ma().bL(str);
            } else if (this.mPluginsMap.containsKey(str)) {
                bVar.CK = false;
            } else {
                Plugin plugin2 = new Plugin();
                this.mPluginsMap.put(str, plugin2);
                bVar = plugin2.initWithBroadcast(str);
                if (!bVar.CK) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
                }
            }
        }
        return bVar;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        k.ju();
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
        k.ju();
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
        k.ju();
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
        k.ju();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        k.ju();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Plugin plugin2 = this.mPluginsMap.get(str);
        return plugin2 != null && plugin2.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bH(str);
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadNativeLibrary(String str, String str2) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Plugin plugin2 = getPlugin(str);
            if (plugin2 != null) {
                try {
                    System.load(new File(plugin2.getPluginLibPath(), Plugin.SO_LIB_DIR_NAME + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().hG()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getDqClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().hG()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.ls().bv(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().hG()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.ls().bv(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().hG()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
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
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r0.isLoaded() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        if ((java.lang.System.currentTimeMillis() - r0.getLastLaunchTime()) <= com.baidu.adp.plugin.PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0098, code lost:
        r5 = r0.initWithBroadcast(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
        if (r5.CK == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (com.baidu.adp.plugin.packageManager.PluginPackageManager.ls().hG() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        com.baidu.adp.plugin.b.a.lf().bm("plugin_load_retry_succ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b5, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
        if (com.baidu.adp.plugin.packageManager.PluginPackageManager.ls().hG() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r6 = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
        if (r6 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
        if (r3.length() <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d1, code lost:
        r3.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d6, code lost:
        r3.append(r6.packageName);
        r3.append("-");
        r3.append(r6.apkPath);
        r3.append("-");
        r3.append(r6.forbidden);
        r3.append("-");
        r3.append(r6.enable);
        r3.append("-");
        r3.append(r6.installStatus);
        r3.append("-");
        r3.append(r6.versionCode);
        r3.append("-");
        r3.append(r6.install_fail_count);
        r3.append("-");
        r3.append(r6.getAbandon_apk_path());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0123, code lost:
        r3.append("-");
        r3.append(r5.reason);
        r3.append("-");
        r3.append(r5.CL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013d, code lost:
        if (r3.length() <= 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013f, code lost:
        r3.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0144, code lost:
        r3.append(r1);
        r3.append("-");
        r3.append(r0.getPluginApkFilePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(key);
                if (findPluginSetting == null || !findPluginSetting.isPatch || !TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                }
            }
        }
        if (PluginPackageManager.ls().hG()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "retry_load_singleplugin", null, sb.toString());
            }
            logPluginLoadStat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
        if (r0.isLoaded() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e2, code lost:
        if ((java.lang.System.currentTimeMillis() - r0.getLastLaunchTime()) <= com.baidu.adp.plugin.PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e4, code lost:
        r5 = r0.initWithBroadcast(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
        if (r5.CK == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f4, code lost:
        if (com.baidu.adp.plugin.packageManager.PluginPackageManager.ls().hG() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f6, code lost:
        com.baidu.adp.plugin.b.a.lf().bm("plugin_load_retry_succ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0114, code lost:
        if (com.baidu.adp.plugin.packageManager.PluginPackageManager.ls().hG() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0116, code lost:
        com.baidu.adp.plugin.b.a.lf().g("plugin_loaded_failed", r1, r5.reason, r5.CL);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(key);
                if (findPluginSetting == null || !findPluginSetting.isPatch || !TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                    Plugin.b bVar = null;
                    if (value != null) {
                        if (value.isLoaded()) {
                            i2++;
                        } else {
                            i++;
                            if (PluginPackageManager.ls().hG()) {
                                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(key);
                                if (findPluginSetting2 != null) {
                                    if (sb.length() > 0) {
                                        sb.append(",");
                                    }
                                    sb.append(findPluginSetting2.packageName);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.apkPath);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.forbidden);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.enable);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.installStatus);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.versionCode);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.install_fail_count);
                                    sb.append("-");
                                    sb.append(findPluginSetting2.getAbandon_apk_path());
                                } else {
                                    if (sb.length() > 0) {
                                        sb.append(",");
                                    }
                                    sb.append(key);
                                    sb.append("-");
                                    sb.append(value.getPluginApkFilePath());
                                }
                                if (bVar != null) {
                                    sb.append("-");
                                    sb.append(bVar.reason);
                                    sb.append("-");
                                    sb.append(bVar.CL);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.a.b.ma().bL(value.getPackageName());
                        }
                    }
                }
            }
        }
        if (PluginPackageManager.ls().hG() && i > 0) {
            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "retry_load_allplugin", null, sb.toString());
        }
        if (!this.hadRecordPluginLoadLogger && this.mPluginsMap.size() > 1) {
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.ls().hG()) {
                if (i2 + i > 0) {
                    com.baidu.adp.plugin.b.a.lf().l("plugin_load", i2 + i);
                }
                if (i <= 0 && com.baidu.adp.plugin.b.a.lf().lh()) {
                    com.baidu.adp.plugin.b.a.lf().bm("plugin_load_resolve");
                }
                com.baidu.adp.plugin.b.a.lf().H(false);
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
        com.baidu.adp.plugin.b.a.lf().e("plugin_load", "load_rate", null, String.format("%.2f", Float.valueOf(f / length)));
        logPluginLoadStat();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00b1: INVOKE  (r10v0 long A[REMOVE]) = 
      (wrap: java.io.File : 0x00a9: CONSTRUCTOR  (r8v16 java.io.File A[REMOVE]) = 
      (wrap: java.lang.String : 0x00a7: IGET  (r9v2 java.lang.String A[REMOVE]) = (r0v6 com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting) com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting.apkPath java.lang.String)
     call: java.io.File.<init>(java.lang.String):void type: CONSTRUCTOR)
     type: VIRTUAL call: java.io.File.length():long)] */
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
                    sb.append("-");
                } else {
                    sb.append("suc-");
                }
                sb2.append(str);
            } else {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
                if (sb2.length() > 0) {
                    sb2.append("-");
                } else {
                    sb2.append("fail-");
                }
                if (findPluginSetting != null) {
                    sb2.append(findPluginSetting.packageName);
                    sb2.append("-");
                    sb2.append(findPluginSetting.apkPath);
                    sb2.append("-");
                    if (findPluginSetting.apkPath != null) {
                        sb2.append(new StringBuilder().append(new File(findPluginSetting.apkPath).length()).toString());
                        sb2.append("-");
                    }
                    sb2.append(findPluginSetting.enable);
                    sb2.append("-");
                    sb2.append(findPluginSetting.installStatus);
                    sb2.append("-");
                    sb2.append(findPluginSetting.versionCode);
                    sb2.append("-");
                    sb2.append(findPluginSetting.tempVersionCode);
                    sb2.append("-");
                    sb2.append(findPluginSetting.install_fail_count);
                    sb2.append("-");
                    sb2.append(findPluginSetting.getAbandon_apk_path());
                    i = i3;
                } else {
                    sb2.append(str);
                    sb2.append("-");
                    sb2.append("null");
                    i = i3;
                }
            }
            i2++;
            i3 = i;
        }
        if (length > i3) {
            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "plugin_loadstate", null, String.valueOf(sb.toString()) + "-" + sb2.toString());
        }
    }
}
