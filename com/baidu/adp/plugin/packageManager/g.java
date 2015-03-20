package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private static volatile g DA;
    private h DB;
    private ArrayList<String> Ds = new ArrayList<>();

    public static g lr() {
        if (DA == null) {
            synchronized (g.class) {
                if (DA == null) {
                    DA = new g();
                }
            }
        }
        return DA;
    }

    private g() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Ds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.equals(pluginSetting.packageName)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.Ds.add(pluginSetting.packageName);
            }
            ln();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        if (this.Ds.size() > 0 && this.DB == null) {
            this.DB = new h(this, this.Ds.get(0));
            this.DB.execute(new String[0]);
        }
    }
}
