package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d EJ;
    private PluginNetConfigInfos EK = new PluginNetConfigInfos();
    private b EL;

    public static d lW() {
        if (EJ == null) {
            synchronized (d.class) {
                if (EJ == null) {
                    EJ = new d();
                }
            }
        }
        return EJ;
    }

    public void a(PluginSettings pluginSettings, boolean z, a aVar) {
        c c = c(pluginSettings);
        if (this.EL != null) {
            this.EL.a(z, c, new e(this, aVar));
        }
    }

    private c c(PluginSettings pluginSettings) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        if (pluginSettings.getPlugins() != null) {
            for (Map.Entry<String, PluginSetting> entry : pluginSettings.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    arrayList.add(new BasicNameValuePair(value.packageName, String.valueOf(value.versionCode)));
                }
            }
        }
        cVar.f(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos lX() {
        return this.EK;
    }

    public void a(b bVar) {
        this.EL = bVar;
    }
}
