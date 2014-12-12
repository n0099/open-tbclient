package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private static volatile c sA;
    private d sB;
    private ArrayList<String> sx = new ArrayList<>();

    public static c ib() {
        if (sA == null) {
            synchronized (c.class) {
                if (sA == null) {
                    sA = new c();
                }
            }
        }
        return sA;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.sx.iterator();
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
                this.sx.add(pluginSetting.packageName);
            }
            ia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.sx.size() > 0 && this.sB == null) {
            this.sB = new d(this, this.sx.get(0));
            this.sB.execute(new String[0]);
        }
    }
}
