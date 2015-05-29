package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginCenter {
    public static final String NAME_INJECT_PLUGIN = "com.baidu.tieba.pluginInjectAll";
    public static final String NAME_LIGHTAPP = "com.baidu.tieba.pluginLightApp";
    public static final String NAME_MOTUSDK = "com.baidu.tieba.pluginMotu";
    private static final long PLUGIN_RETRYLAUNCH_DELAY = 10000;
    private static final long PLUGIN_RETRY_MIN_TIME_INTERVAL = 4000;
    private static volatile PluginCenter mInstance = null;
    private String mCommonErrorShowText;
    private HashMap<String, a> mPluginsMap;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new c(this);

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
        aVar.kD();
    }

    public boolean launch(String str) {
        boolean z = false;
        n.jk();
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
        } else {
            BdLog.i("----launch plugin" + str);
            if (!this.mPluginsMap.containsKey(str)) {
                a aVar = new a();
                this.mPluginsMap.put(str, aVar);
                z = aVar.bf(str);
                if (!z) {
                    this.mHandler.removeCallbacks(this.mRunnable);
                    this.mHandler.postDelayed(this.mRunnable, PLUGIN_RETRYLAUNCH_DELAY);
                }
            }
        }
        return z;
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        n.jk();
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
        n.jk();
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
        n.jk();
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
        n.jk();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        n.jk();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (BdBaseApplication.getInst().isDebugMode() && str.equals(NAME_INJECT_PLUGIN)) {
            return true;
        }
        a aVar = this.mPluginsMap.get(str);
        return aVar != null && aVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !h.mi().bI(str);
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
            if (entry.getValue() != null && entry.getValue().bg(str)) {
                return entry.getValue().kx();
            }
        }
        return BdBaseApplication.getInst().getPackageCodePath();
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().kz() != null && entry.getValue().kz().equals(classLoader)) {
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
                String kx = entry.getValue().kx();
                if (!TextUtils.isEmpty(kx) && kx.contains(str)) {
                    return kx;
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
                    System.load(new File(plugin2.ky(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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
        if (PluginPackageManager.lM().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getDqClassInstance() {
        if (PluginPackageManager.lM().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.lM().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.lM().bx(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.lM().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.lM().bx(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public void stopRetryLaunchPlugins() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public void startRetryLaunchPlugins() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.post(this.mRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLaunchPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return;
        }
        for (Map.Entry<String, a> entry : this.mPluginsMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (value != null && !value.isLoaded() && System.currentTimeMillis() - value.kv() > PLUGIN_RETRY_MIN_TIME_INTERVAL && value.bf(key) && PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().bo("retry_succ");
                }
            }
        }
    }
}
