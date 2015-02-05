package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private static volatile c sG;
    private ArrayList<String> sD = new ArrayList<>();
    private d sH;

    public static c hU() {
        if (sG == null) {
            synchronized (c.class) {
                if (sG == null) {
                    sG = new c();
                }
            }
        }
        return sG;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.sD.iterator();
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
                this.sD.add(pluginSetting.packageName);
            }
            hT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT() {
        if (this.sD.size() > 0 && this.sH == null) {
            this.sH = new d(this, this.sD.get(0));
            this.sH.execute(new String[0]);
        }
    }
}
