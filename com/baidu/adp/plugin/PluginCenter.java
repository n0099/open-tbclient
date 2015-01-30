package com.baidu.adp.plugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginCenter {
    private static volatile PluginCenter rX = null;
    private HashMap<String, b> rY;
    private String rZ;

    public static PluginCenter gW() {
        if (rX == null) {
            synchronized (PluginCenter.class) {
                if (rX == null) {
                    rX = new PluginCenter();
                }
            }
        }
        return rX;
    }

    private PluginCenter() {
        this.rY = null;
        this.rZ = null;
        this.rY = new HashMap<>();
        this.rZ = "内部错误，请稍后重试~";
    }

    public boolean aP(String str) {
        l.fs();
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launch args exception!");
            }
            return false;
        } else if (this.rY.containsKey(str) || h.iy().bt(str)) {
            return false;
        } else {
            b bVar = new b();
            this.rY.put(str, bVar);
            return bVar.aN(str);
        }
    }

    public boolean a(Context context, int i, Intent intent) {
        boolean z;
        String str;
        l.fs();
        if (context == null || i == 0) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("plugincenter launchIntent args exception!");
            }
            return false;
        }
        String aw = h.iy().aw(i);
        if (TextUtils.isEmpty(aw)) {
            str = BdBaseApplication.getInst().getPackageName();
            z = true;
        } else if (h.iy().bt(aw)) {
            return false;
        } else {
            z = false;
            str = aw;
        }
        b bVar = this.rY.get(str);
        if (bVar == null && z) {
            bVar = new b();
            this.rY.put(str, bVar);
            bVar.gP();
        }
        if (bVar == null || !bVar.isLoaded()) {
            return false;
        }
        return bVar.i(context, intent);
    }

    public boolean aQ(String str) {
        l.fs();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.rY.containsKey(str);
    }

    public boolean aR(String str) {
        l.fs();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (BdBaseApplication.getInst().isDebugMode() && str.equals("com.baidu.tieba.pluginInjectAll")) {
            return true;
        }
        b bVar = this.rY.get(str);
        return bVar != null && bVar.isLoaded();
    }

    public boolean isEnable(String str) {
        return aR(str) && !h.iy().bt(str);
    }

    public String gX() {
        return this.rZ;
    }

    public b aS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.rY.get(str);
    }

    public String getPluginFilePathByPackage(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        for (Map.Entry<String, b> entry : this.rY.entrySet()) {
            if (entry.getValue() != null) {
                String gJ = entry.getValue().gJ();
                if (!StringUtils.isNull(gJ) && gJ.contains(str)) {
                    return gJ;
                }
            }
        }
        return null;
    }

    public ArrayList<b> gY() {
        if (this.rY == null || this.rY.size() == 0) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>();
        for (Map.Entry<String, b> entry : this.rY.entrySet()) {
            if (entry.getValue() != null) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public <P> P gZ() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.social_share_sdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.social_share_sdk.BdSocialShareSdkDelegateImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().d("plugin_load", "get_inject_class", null, "SocialShare-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P ha() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.dqsdk")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.dqsdk.DQSdkImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().d("plugin_load", "get_inject_class", null, "dq-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hb() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.motu_sdk") || PluginPackageManager.ic().bj("com.baidu.tieba.pluginMotu")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.motu_sdk.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().d("plugin_load", "get_inject_class", null, "motu-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hc() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.light_app") || PluginPackageManager.ic().bj("com.baidu.tieba.pluginLightApp")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.light_app.LightAppPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().d("plugin_load", "get_inject_class", null, "lightapp-" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public <P> P hd() {
        if (PluginPackageManager.ic().isFeatureForbidden("com.baidu.tieba.xiuba") || PluginPackageManager.ic().bj("com.xiu8.android.activity")) {
            return null;
        }
        try {
            return (P) BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tieba.xiuba.XiubaPluginStatic").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().d("plugin_load", "get_inject_class", null, "xiuba-" + th.getMessage());
                return null;
            }
            return null;
        }
    }
}
