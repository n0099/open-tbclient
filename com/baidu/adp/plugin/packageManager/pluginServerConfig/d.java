package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Eg;
    private PluginNetConfigInfos Eh = new PluginNetConfigInfos();
    private b Ei;

    public static d ml() {
        if (Eg == null) {
            synchronized (d.class) {
                if (Eg == null) {
                    Eg = new d();
                }
            }
        }
        return Eg;
    }

    public void a(PluginSettings pluginSettings, a aVar) {
        c b = b(pluginSettings);
        if (this.Ei != null) {
            this.Ei.a(b, new e(this, aVar));
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

    public PluginNetConfigInfos mm() {
        return this.Eh;
    }

    public void a(b bVar) {
        this.Ei = bVar;
    }
}
