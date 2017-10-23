package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ed;
    private PluginNetConfigInfos Ee = new PluginNetConfigInfos();
    private b Ef;

    public static d jR() {
        if (Ed == null) {
            synchronized (d.class) {
                if (Ed == null) {
                    Ed = new d();
                }
            }
        }
        return Ed;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c c = c(pluginSettings);
        if (this.Ef != null) {
            this.Ef.a(z, c, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.Ee = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Ee);
                    }
                }
            });
        }
    }

    public c c(PluginSettings pluginSettings) {
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
        cVar.h(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos jS() {
        return this.Ee;
    }

    public void a(b bVar) {
        this.Ef = bVar;
    }
}
