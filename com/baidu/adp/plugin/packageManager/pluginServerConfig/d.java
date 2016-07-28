package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d vK;
    private PluginNetConfigInfos vL = new PluginNetConfigInfos();
    private b vM;

    public static d id() {
        if (vK == null) {
            synchronized (d.class) {
                if (vK == null) {
                    vK = new d();
                }
            }
        }
        return vK;
    }

    public void a(PluginSettings pluginSettings, boolean z, a aVar) {
        c c = c(pluginSettings);
        if (this.vM != null) {
            this.vM.a(z, c, new e(this, aVar));
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

    public PluginNetConfigInfos ie() {
        return this.vL;
    }

    public void a(b bVar) {
        this.vM = bVar;
    }
}
