package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d DR;
    private PluginNetConfigInfos DS = new PluginNetConfigInfos();
    private b DU;

    public static d mi() {
        if (DR == null) {
            synchronized (d.class) {
                if (DR == null) {
                    DR = new d();
                }
            }
        }
        return DR;
    }

    public void a(PluginSettings pluginSettings, a aVar) {
        c b = b(pluginSettings);
        if (this.DU != null) {
            this.DU.a(b, new e(this, aVar));
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
        cVar.g(arrayList);
        return cVar;
    }

    public PluginNetConfigInfos mj() {
        return this.DS;
    }

    public void a(b bVar) {
        this.DU = bVar;
    }
}
