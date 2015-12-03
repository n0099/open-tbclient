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
    private Object opPluginMapLock = new Object();
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
        aVar.kw();
    }

    public a.b launch(String str) {
        a.b bVar = new a.b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            bVar.Cq = false;
        } else {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
            if (findPluginSetting == null) {
                bVar.Cq = false;
            } else if (findPluginSetting.versionCode < 42) {
                bVar.Cq = false;
                com.baidu.adp.plugin.b.a.lI().F("plugincenter_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "plugincenter_load_lowversion", str, String.valueOf(findPluginSetting.apkPath) + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bI(str);
                com.baidu.adp.plugin.packageManager.a.b.mx().bK(str);
            } else if (this.mPluginsMap.containsKey(str)) {
                bVar.Cq = false;
            } else {
                a aVar = new a();
                synchronized (this.opPluginMapLock) {
                    this.mPluginsMap.put(str, aVar);
                }
                bVar = aVar.bb(str);
                if (!bVar.Cq) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
                }
            }
        }
        return bVar;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        k.je();
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
        k.je();
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
        a remove;
        k.je();
        if (str == null) {
            return false;
        }
        synchronized (this.opPluginMapLock) {
            remove = this.mPluginsMap.remove(str);
        }
        if (remove == null || !remove.isLoaded()) {
            return false;
        }
        remove.destroy();
        return true;
    }

    public boolean hasInstance(String str) {
        k.je();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        k.je();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = this.mPluginsMap.get(str);
        return aVar != null && aVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bG(str);
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
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null && ((a) entry.getValue()).bc(str)) {
                return ((a) entry.getValue()).kq();
            }
        }
        return BdBaseApplication.getInst().getPackageCodePath();
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        HashMap hashMap;
        if (classLoader == null) {
            return null;
        }
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null && ((a) entry.getValue()).ks() != null && ((a) entry.getValue()).ks().equals(classLoader)) {
                return ((a) entry.getValue()).getPackageName();
            }
        }
        return BdBaseApplication.getInst().getPackageName();
    }

    public String getPluginFilePathByPackage(String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                String kq = ((a) entry.getValue()).kq();
                if (!TextUtils.isEmpty(kq) && kq.contains(str)) {
                    return kq;
                }
            }
        }
        return null;
    }

    public ArrayList<a> getAllPlugins() {
        HashMap hashMap;
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                arrayList.add((a) entry.getValue());
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
                    System.load(new File(plugin2.kr(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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
        if (PluginPackageManager.lU().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getDqClassInstance() {
        if (PluginPackageManager.lU().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.lU().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.lU().bu(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.lU().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.lU().bu(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
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
        HashMap hashMap;
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return;
        }
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String str = (String) entry.getKey();
                a aVar = (a) entry.getValue();
                if (aVar != null && !aVar.isLoaded() && System.currentTimeMillis() - aVar.ko() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                    a.b bb = aVar.bb(str);
                    if (bb.Cq) {
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().bl("plugin_load_retry_succ");
                        }
                    } else {
                        i++;
                        if (PluginPackageManager.lU().hs()) {
                            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
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
                                sb.append(str);
                                sb.append("-");
                                sb.append(aVar.kq());
                            }
                            sb.append("-");
                            sb.append(bb.reason);
                            sb.append("-");
                            sb.append(bb.Cr);
                        }
                    }
                }
            }
        }
        if (PluginPackageManager.lU().hs()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_load", "retry_load_singleplugin", null, sb.toString());
            }
            logPluginLoadStat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchAllPlugins() {
        HashMap hashMap;
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0 || this.mPluginsMap.size() == 1) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
            return;
        }
        synchronized (this.opPluginMapLock) {
            hashMap = new HashMap(this.mPluginsMap);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String str = (String) entry.getKey();
                a aVar = (a) entry.getValue();
                if (aVar != null && !aVar.isLoaded() && System.currentTimeMillis() - aVar.ko() > PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                    a.b bb = aVar.bb(str);
                    if (bb.Cq) {
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().bl("plugin_load_retry_succ");
                        }
                    } else if (PluginPackageManager.lU().hs()) {
                        com.baidu.adp.plugin.b.a.lI().f("plugin_loaded_failed", str, bb.reason, bb.Cr);
                    }
                }
                if (aVar != null) {
                    if (aVar.isLoaded()) {
                        i2++;
                    } else {
                        i++;
                        if (PluginPackageManager.lU().hs()) {
                            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
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
                                sb.append(str);
                                sb.append("-");
                                sb.append(aVar.kq());
                            }
                        }
                        com.baidu.adp.plugin.packageManager.a.b.mx().bK(aVar.getPackageName());
                    }
                }
            }
        }
        if (PluginPackageManager.lU().hs() && i > 0) {
            com.baidu.adp.plugin.b.a.lI().d("plugin_load", "retry_load_allplugin", null, sb.toString());
        }
        if (!this.hadRecordPluginLoadLogger && this.mPluginsMap.size() > 1) {
            this.hadRecordPluginLoadLogger = true;
            if (PluginPackageManager.lU().hs()) {
                if (i2 + i > 0) {
                    com.baidu.adp.plugin.b.a.lI().k("plugin_load", i2 + i);
                }
                if (i <= 0 && com.baidu.adp.plugin.b.a.lI().lK()) {
                    com.baidu.adp.plugin.b.a.lI().bl("plugin_load_resolve");
                }
                com.baidu.adp.plugin.b.a.lI().M(false);
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
        com.baidu.adp.plugin.b.a.lI().d("plugin_load", "load_rate", null, String.format("%.2f", Float.valueOf(f / length)));
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
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
            com.baidu.adp.plugin.b.a.lI().d("plugin_load", "plugin_loadstate", null, String.valueOf(sb.toString()) + "-" + sb2.toString());
        }
    }
}
