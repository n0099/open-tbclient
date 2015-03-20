package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
    public static final String NAME_XIU8 = "com.xiu8.android.activity";
    private static volatile PluginCenter mInstance = null;
    private String mCommonErrorShowText;
    private HashMap<String, b> mPluginsMap;

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
        b bVar = new b();
        this.mPluginsMap.put(packageName, bVar);
        bVar.kk();
    }

    public boolean launch(String str) {
        n.iV();
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            return false;
        }
        BdLog.i("----launch plugin" + str);
        if (this.mPluginsMap.containsKey(str)) {
            return false;
        }
        b bVar = new b();
        this.mPluginsMap.put(str, bVar);
        return bVar.aV(str);
    }

    public boolean launchIntent(Context context, String str, Intent intent) {
        n.iV();
        if (context == null || TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        b bVar = this.mPluginsMap.get(str);
        if (bVar == null || !bVar.isLoaded()) {
            return false;
        }
        return bVar.i(context, intent);
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        n.iV();
        if (context == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        b bVar = this.mPluginsMap.get(str);
        if (bVar == null || !bVar.isLoaded()) {
            return false;
        }
        return bVar.a(context, intent, serviceConnection, i);
    }

    public boolean releasePlugin(String str) {
        n.iV();
        if (str == null) {
            return false;
        }
        b remove = this.mPluginsMap.remove(str);
        if (remove == null || !remove.isLoaded()) {
            return false;
        }
        remove.destroy();
        return true;
    }

    public boolean hasInstance(String str) {
        n.iV();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mPluginsMap.containsKey(str);
    }

    public boolean isLoaded(String str) {
        n.iV();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (BdBaseApplication.getInst().isDebugMode() && str.equals(NAME_INJECT_PLUGIN)) {
            return true;
        }
        b bVar = this.mPluginsMap.get(str);
        return bVar != null && bVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return isLoaded(str) && !h.lP().by(str);
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

    public b getPlugin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mPluginsMap.get(str);
    }

    public String getPluginFilePathByClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, b> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().aW(str)) {
                return entry.getValue().kf();
            }
        }
        return BdBaseApplication.getInst().getPackageCodePath();
    }

    public String getPluginNameByClassloader(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        for (Map.Entry<String, b> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().kh() != null && entry.getValue().kh().equals(classLoader)) {
                return entry.getValue().getPackageName();
            }
        }
        return BdBaseApplication.getInst().getPackageName();
    }

    public String getPluginFilePathByPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, b> entry : this.mPluginsMap.entrySet()) {
            if (entry.getValue() != null) {
                String kf = entry.getValue().kf();
                if (!TextUtils.isEmpty(kf) && kf.contains(str)) {
                    return kf;
                }
            }
        }
        return null;
    }

    public ArrayList<b> getAllPlugins() {
        if (this.mPluginsMap == null || this.mPluginsMap.size() == 0) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>();
        for (Map.Entry<String, b> entry : this.mPluginsMap.entrySet()) {
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
            b plugin2 = getPlugin(str);
            if (plugin2 != null) {
                try {
                    System.load(new File(plugin2.kg(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
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
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getMotuClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tbadk.motu_gallery") || PluginPackageManager.ls().bn(NAME_MOTUSDK)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getLightAppClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.ls().bn(NAME_LIGHTAPP)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P getXiubaClassInstance() {
        if (PluginPackageManager.ls().isFeatureForbidden("com.baidu.tieba.xiuba") || PluginPackageManager.ls().bn(NAME_XIU8)) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.xiuba.XiubaPluginStatic").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "get_inject_class", null, "xiuba-" + th.getMessage());
                return null;
            }
            return null;
        }
    }
}
