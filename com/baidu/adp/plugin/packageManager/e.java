package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static volatile e Dw;
    private HashMap<String, String> Dx = new HashMap<>();
    private f Dy = null;

    public static e lo() {
        if (Dw == null) {
            synchronized (e.class) {
                if (Dw == null) {
                    Dw = new e();
                }
            }
        }
        return Dw;
    }

    private e() {
    }

    public void clear(boolean z) {
        if (z && this.Dy == null && lp()) {
            this.Dy = new f(this);
            this.Dy.execute(new Void[0]);
        }
    }

    private boolean lp() {
        String[] split;
        this.Dx.clear();
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM();
        if (lM == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : lM.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Dx.put(value.apkPath, "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Dx.put(str, "");
                    }
                }
            }
        }
        return true;
    }
}
