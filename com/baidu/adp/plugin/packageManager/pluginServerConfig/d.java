package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d Lt;
    private PluginNetConfigInfos Lu = new PluginNetConfigInfos();
    private b Lv;

    public static d nw() {
        if (Lt == null) {
            synchronized (d.class) {
                if (Lt == null) {
                    Lt = new d();
                }
            }
        }
        return Lt;
    }

    public void a(PluginSettings pluginSettings, boolean z, final a aVar) {
        c c = c(pluginSettings);
        if (this.Lv != null) {
            this.Lv.a(z, c, new a() { // from class: com.baidu.adp.plugin.packageManager.pluginServerConfig.d.1
                @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
                public void a(boolean z2, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
                    if (z2) {
                        d.this.Lu = pluginNetConfigInfos;
                    }
                    if (aVar != null) {
                        aVar.a(z2, cVar, d.this.Lu);
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

    public PluginNetConfigInfos nx() {
        return this.Lu;
    }

    public void a(b bVar) {
        this.Lv = bVar;
    }
}
