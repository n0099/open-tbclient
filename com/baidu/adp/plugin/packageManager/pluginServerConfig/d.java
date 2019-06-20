package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Jy;
    private b JA;
    private PluginNetConfigInfos Jz = new PluginNetConfigInfos();

    public static d mA() {
        if (Jy == null) {
            synchronized (d.class) {
                if (Jy == null) {
                    Jy = new d();
                }
            }
        }
        return Jy;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c b = b(pluginSettings);
        if (this.JA != null) {
            this.JA.a(z, b, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.Jz = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Jz);
                    }
                }
            });
        }
    }

    public c b(PluginSettings pluginSettings) {
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

    public PluginNetConfigInfos mB() {
        return this.Jz;
    }

    public void a(b bVar) {
        this.JA = bVar;
    }
}
