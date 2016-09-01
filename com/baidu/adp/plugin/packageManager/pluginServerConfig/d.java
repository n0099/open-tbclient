package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static volatile d xW;
    private PluginNetConfigInfos xX = new PluginNetConfigInfos();
    private b xY;

    public static d iY() {
        if (xW == null) {
            synchronized (d.class) {
                if (xW == null) {
                    xW = new d();
                }
            }
        }
        return xW;
    }

    public void a(PluginSettings pluginSettings, boolean z, a aVar) {
        c c = c(pluginSettings);
        if (this.xY != null) {
            this.xY.a(z, c, new e(this, aVar));
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

    public PluginNetConfigInfos iZ() {
        return this.xX;
    }

    public void a(b bVar) {
        this.xY = bVar;
    }
}
