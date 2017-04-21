package com.baidu.adp.plugin.install;

import com.baidu.adp.plugin.install.c;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.Comparator;
import java.util.HashMap;
/* loaded from: classes.dex */
class k implements Comparator<String> {
    final /* synthetic */ c.a DA;
    private final /* synthetic */ HashMap DB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c.a aVar, HashMap hashMap) {
        this.DA = aVar;
        this.DB = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        PluginStatus pluginStatus = (PluginStatus) this.DB.get(str);
        PluginStatus pluginStatus2 = (PluginStatus) this.DB.get(str2);
        if (pluginStatus != null && pluginStatus2 != null) {
            return pluginStatus2.getPriority() - pluginStatus.getPriority();
        }
        if (pluginStatus != null && pluginStatus2 == null) {
            return -1;
        }
        if (pluginStatus == null && pluginStatus2 != null) {
            return 1;
        }
        return 0;
    }
}
