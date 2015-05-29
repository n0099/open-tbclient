package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private static volatile g Dr;
    private ArrayList<String> Dj = new ArrayList<>();
    private h Ds;

    public static g lL() {
        if (Dr == null) {
            synchronized (g.class) {
                if (Dr == null) {
                    Dr = new g();
                }
            }
        }
        return Dr;
    }

    private g() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Dj.iterator();
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
                this.Dj.add(pluginSetting.packageName);
            }
            lH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH() {
        if (this.Dj.size() > 0 && this.Ds == null) {
            this.Ds = new h(this, this.Dj.get(0));
            this.Ds.execute(new String[0]);
        }
    }
}
