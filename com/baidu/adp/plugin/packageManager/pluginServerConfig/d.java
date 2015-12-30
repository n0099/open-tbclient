package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ey;
    private b EA;
    private PluginNetConfigInfos Ez = new PluginNetConfigInfos();

    public static d lJ() {
        if (Ey == null) {
            synchronized (d.class) {
                if (Ey == null) {
                    Ey = new d();
                }
            }
        }
        return Ey;
    }

    public void a(PluginSettings pluginSettings, boolean z, a aVar) {
        c b = b(pluginSettings);
        if (this.EA != null) {
            this.EA.a(z, b, new e(this, aVar));
        }
    }

    private c b(PluginSettings pluginSettings) {
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

    public PluginNetConfigInfos lK() {
        return this.Ez;
    }

    public void a(b bVar) {
        this.EA = bVar;
    }
}
