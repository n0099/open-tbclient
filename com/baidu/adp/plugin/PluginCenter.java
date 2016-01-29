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
    private ConcurrentHashMap<String, a> mPluginsMap;
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
        a aVar = new a();
        this.mPluginsMap.put(packageName, aVar);
        aVar.kH();
    }

    public a.b launch(String str) {
        a.b bVar = new a.b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            bVar.CF = false;
        } else {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
            if (findPluginSetting == null) {
                bVar.CF = false;
            } else if (findPluginSetting.versionCode < PluginPackageManager.lC()) {
                bVar.CF = false;
                com.baidu.adp.plugin.b.a.lq().F("plugincenter_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "plugincenter_load_lowversion", str, String.valueOf(findPluginSetting.apkPath) + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bL(str);
                com.baidu.adp.plugin.packageManager.a.b.mi().bN(str);
            } else if (this.mPluginsMap.containsKey(str)) {
                bVar.CF = false;
            } else {
                a aVar = new a();
                this.mPluginsMap.put(str, aVar);
                bVar = aVar.ba(str);
                if (!bVar.CF) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
                }
            }
        }
        return bVar;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        k.jo();
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
        k.jo();
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
        k.jo();
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
        k.jo();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        k.jo();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = this.mPluginsMap.get(str);
        return aVar != null && aVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bJ(str);
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
            if (entry.getValue() != null && entry.getValue().bc(str)) {
                return entry.getValue().kB();
            }
        }
        return BdBaseApplication.getInst().getPackageCodePath();
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().kD() != null && entry.getValue().kD().equals(classLoader)) {
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
                String kB = entry.getValue().kB();
                if (!TextUtils.isEmpty(kB) && kB.contains(str)) {
                    return kB;
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
                    System.load(new File(plugin2.kC(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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
        if (PluginPackageManager.lD().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getDqClassInstance() {
        if (PluginPackageManager.lD().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.lD().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.lD().bx(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.lD().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.lD().bx(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(key);
                if (findPluginSetting == null || !findPluginSetting.isPatch) {
                    if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.kz() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                        a.b ba = value.ba(key);
                        if (ba.CF) {
                            if (PluginPackageManager.lD().hA()) {
                                com.baidu.adp.plugin.b.a.lq().bo("plugin_load_retry_succ");
                            }
                        } else {
                            i++;
                            if (PluginPackageManager.lD().hA()) {
                                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(key);
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
                                    sb.append(value.kB());
                                }
                                sb.append("-");
                                sb.append(ba.reason);
                                sb.append("-");
                                sb.append(ba.CG);
                            }
                        }
                    }
                }
            }
        }
        if (PluginPackageManager.lD().hA()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "retry_load_singleplugin", null, sb.toString());
            }
            logPluginLoadStat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
        a.b bVar;
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0 || this.mPluginsMap.size() == 1) {
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(key);
                if (findPluginSetting == null || !findPluginSetting.isPatch) {
                    if (value == null || value.isLoaded() || System.currentTimeMillis() - value.kz() <= PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                        bVar = null;
                    } else {
                        bVar = value.ba(key);
                        if (bVar.CF) {
                            if (PluginPackageManager.lD().hA()) {
                                com.baidu.adp.plugin.b.a.lq().bo("plugin_load_retry_succ");
                            }
                        } else if (PluginPackageManager.lD().hA()) {
                            com.baidu.adp.plugin.b.a.lq().g("plugin_loaded_failed", key, bVar.reason, bVar.CG);
                        }
                    }
                    if (value != null) {
                        if (value.isLoaded()) {
                            i2++;
                        } else {
                            i++;
                            if (PluginPackageManager.lD().hA()) {
                                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(key);
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
                                    sb.append(value.kB());
                                }
                                if (bVar != null) {
                                    sb.append("-");
                                    sb.append(bVar.reason);
                                    sb.append("-");
                                    sb.append(bVar.CG);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.a.b.mi().bN(value.getPackageName());
                        }
                    }
                }
            }
        }
        if (PluginPackageManager.lD().hA() && i > 0) {
            com.baidu.adp.plugin.b.a.lq().e("plugin_load", "retry_load_allplugin", null, sb.toString());
        }
        if (!this.hadRecordPluginLoadLogger && this.mPluginsMap.size() > 1) {
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.lD().hA()) {
                if (i2 + i > 0) {
                    com.baidu.adp.plugin.b.a.lq().l("plugin_load", i2 + i);
                }
                if (i <= 0 && com.baidu.adp.plugin.b.a.lq().ls()) {
                    com.baidu.adp.plugin.b.a.lq().bo("plugin_load_resolve");
                }
                com.baidu.adp.plugin.b.a.lq().I(false);
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
            a aVar = this.mPluginsMap.get(strArr[i]);
            i++;
            f = (aVar == null || !aVar.isLoaded()) ? f : 1.0f + f;
        }
        com.baidu.adp.plugin.b.a.lq().e("plugin_load", "load_rate", null, String.format("%.2f", Float.valueOf(f / length)));
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
            a aVar = this.mPluginsMap.get(str);
            if (aVar != null && aVar.isLoaded()) {
                i = i3 + 1;
                if (sb.length() > 0) {
                    sb.append("-");
                } else {
                    sb.append("suc-");
                }
                sb2.append(str);
            } else {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
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
            com.baidu.adp.plugin.b.a.lq().e("plugin_load", "plugin_loadstate", null, String.valueOf(sb.toString()) + "-" + sb2.toString());
        }
    }
}
