package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Tq;
    private PluginNetConfigInfos Tr = new PluginNetConfigInfos();
    private b Ts;

    public static d qk() {
        if (Tq == null) {
            synchronized (d.class) {
                if (Tq == null) {
                    Tq = new d();
                }
            }
        }
        return Tq;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c b = b(pluginSettings);
        if (this.Ts != null) {
            this.Ts.a(z, b, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
                    if (z2) {
                        d.this.Tr = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Tr, str);
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
        cVar.p(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos ql() {
        return this.Tr;
    }

    public void a(b bVar) {
        this.Ts = bVar;
    }
}
