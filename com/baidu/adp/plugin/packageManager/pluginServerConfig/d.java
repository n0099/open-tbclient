package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ge;
    private PluginNetConfigInfos Gf = new PluginNetConfigInfos();
    private b Gg;

    public static d kb() {
        if (Ge == null) {
            synchronized (d.class) {
                if (Ge == null) {
                    Ge = new d();
                }
            }
        }
        return Ge;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c c = c(pluginSettings);
        if (this.Gg != null) {
            this.Gg.a(z, c, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.Gf = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Gf);
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

    public PluginNetConfigInfos kc() {
        return this.Gf;
    }

    public void a(b bVar) {
        this.Gg = bVar;
    }
}
