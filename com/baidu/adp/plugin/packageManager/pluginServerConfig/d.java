package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d arM;
    private PluginNetConfigInfos arN = new PluginNetConfigInfos();
    private b arO;

    public static d ro() {
        if (arM == null) {
            synchronized (d.class) {
                if (arM == null) {
                    arM = new d();
                }
            }
        }
        return arM;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c c = c(pluginSettings);
        if (this.arO != null) {
            this.arO.a(z, c, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.arN = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.arN);
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
        cVar.r(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos rp() {
        return this.arN;
    }

    public void a(b bVar) {
        this.arO = bVar;
    }
}
