package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Lq;
    private PluginNetConfigInfos Lr = new PluginNetConfigInfos();
    private b Ls;

    public static d nz() {
        if (Lq == null) {
            synchronized (d.class) {
                if (Lq == null) {
                    Lq = new d();
                }
            }
        }
        return Lq;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c c = c(pluginSettings);
        if (this.Ls != null) {
            this.Ls.a(z, c, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.Lr = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Lr);
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
        cVar.l(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos nA() {
        return this.Lr;
    }

    public void a(b bVar) {
        this.Ls = bVar;
    }
}
