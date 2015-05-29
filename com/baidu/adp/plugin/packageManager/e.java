package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static volatile e Dn;
    private HashMap<String, String> Do = new HashMap<>();
    private f Dp = null;

    public static e lI() {
        if (Dn == null) {
            synchronized (e.class) {
                if (Dn == null) {
                    Dn = new e();
                }
            }
        }
        return Dn;
    }

    private e() {
    }

    public void clear(boolean z) {
        if (z && this.Dp == null && lJ()) {
            this.Dp = new f(this);
            this.Dp.execute(new Void[0]);
        }
    }

    private boolean lJ() {
        String[] split;
        this.Do.clear();
        PluginSettings mf = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf();
        if (mf == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mf.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Do.put(value.apkPath, "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Do.put(str, "");
                    }
                }
            }
        }
        return true;
    }
}
