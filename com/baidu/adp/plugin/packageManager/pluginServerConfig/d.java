package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d EP;
    private PluginNetConfigInfos EQ = new PluginNetConfigInfos();
    private b ER;

    public static d lO() {
        if (EP == null) {
            synchronized (d.class) {
                if (EP == null) {
                    EP = new d();
                }
            }
        }
        return EP;
    }

    public void a(PluginSettings pluginSettings, boolean z, a aVar) {
        c c = c(pluginSettings);
        if (this.ER != null) {
            this.ER.a(z, c, new e(this, aVar));
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
        cVar.f(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos lP() {
        return this.EQ;
    }

    public void a(b bVar) {
        this.ER = bVar;
    }
}
