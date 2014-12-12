package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginCenter {
    private static volatile PluginCenter rS = null;
    private HashMap<String, b> rT;
    private String rU;

    public static PluginCenter gX() {
        if (rS == null) {
            synchronized (PluginCenter.class) {
                if (rS == null) {
                    rS = new PluginCenter();
                }
            }
        }
        return rS;
    }

    private PluginCenter() {
        this.rT = null;
        this.rU = null;
        this.rT = new HashMap<>();
        this.rU = "内部错误，请稍后重试~";
    }

    public boolean aP(String str) {
        l.ft();
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            return false;
        } else if (this.rT.containsKey(str) || h.iy().bt(str)) {
            return false;
        } else {
            b bVar = new b();
            this.rT.put(str, bVar);
            return bVar.aN(str);
        }
    }

    public boolean a(Context context, int i, Intent intent) {
        boolean z;
        String str;
        l.ft();
        if (context == null || i == 0) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        String ar = h.iy().ar(i);
        if (TextUtils.isEmpty(ar)) {
            str = BdBaseApplication.getInst().getPackageName();
            z = true;
        } else if (h.iy().bt(ar)) {
            return false;
        } else {
            z = false;
            str = ar;
        }
        b bVar = this.rT.get(str);
        if (bVar == null && z) {
            bVar = new b();
            this.rT.put(str, bVar);
            bVar.gQ();
        }
        if (bVar == null || !bVar.isLoaded()) {
            return false;
        }
        return bVar.i(context, intent);
    }

    public boolean aQ(String str) {
        l.ft();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.rT.containsKey(str);
    }

    public boolean aR(String str) {
        l.ft();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (BdBaseApplication.getInst().isDebugMode() && str.equals("com.baidu.tieba.pluginInjectAll")) {
            return true;
        }
        b bVar = this.rT.get(str);
        return bVar != null && bVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return aR(str) && !h.iy().bt(str);
    }

    public String gY() {
        return this.rU;
    }

    public b aS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.rT.get(str);
    }

    public String getPluginFilePathByPackage(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        for (Map.Entry<String, b> entry : this.rT.entrySet()) {
            if (entry.getValue() != null) {
                String gK = entry.getValue().gK();
                if (!StringUtils.isNull(gK) && gK.contains(str)) {
                    return gK;
                }
            }
        }
        return null;
    }

    public ArrayList<b> gZ() {
        if (this.rT == null || this.rT.size() == 0) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>();
        for (Map.Entry<String, b> entry : this.rT.entrySet()) {
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
    public void B(String str, String str2) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b aS = aS(str);
            if (aS != null) {
                try {
                    System.load(new File(aS.gL(), "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX).getAbsolutePath());
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

    public <P> P ha() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hb() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hc() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.hao123_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.hao123_sdk.Hao123PluginImplStatic").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "hao123-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hd() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.motu_sdk") || PluginPackageManager.ic().bj("com.baidu.tieba.pluginMotu")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.motu_sdk.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P he() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.ic().bj("com.baidu.tieba.pluginLightApp")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hf() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.xiuba") || PluginPackageManager.ic().bj("com.xiu8.android.activity")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.xiuba.XiubaPluginStatic").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "get_inject_class", null, "xiuba-" + th.getMessage());
                return null;
            }
            return null;
        }
    }
}
