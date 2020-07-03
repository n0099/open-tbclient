package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d SR;
    private PluginNetConfigInfos SS = new PluginNetConfigInfos();
    private b ST;

    public static d oK() {
        if (SR == null) {
            synchronized (d.class) {
                if (SR == null) {
                    SR = new d();
                }
            }
        }
        return SR;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c b = b(pluginSettings);
        if (this.ST != null) {
            this.ST.a(z, b, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
                    if (z2) {
                        d.this.SS = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.SS, str);
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
        cVar.o(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos oL() {
        return this.SS;
    }

    public void a(b bVar) {
        this.ST = bVar;
    }
}
