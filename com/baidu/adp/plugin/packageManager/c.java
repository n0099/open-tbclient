package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private static volatile c sJ;
    private ArrayList<String> sG = new ArrayList<>();
    private d sK;

    public static c ib() {
        if (sJ == null) {
            synchronized (c.class) {
                if (sJ == null) {
                    sJ = new c();
                }
            }
        }
        return sJ;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.sG.iterator();
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
                this.sG.add(pluginSetting.packageName);
            }
            ia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.sG.size() > 0 && this.sK == null) {
            this.sK = new d(this, this.sG.get(0));
            this.sK.execute(new String[0]);
        }
    }
}
