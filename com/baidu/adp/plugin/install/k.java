package com.baidu.adp.plugin.install;

import com.baidu.adp.plugin.install.c;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.Comparator;
import java.util.HashMap;
/* loaded from: classes.dex */
class k implements Comparator<String> {
    final /* synthetic */ c.a DW;
    private final /* synthetic */ HashMap DX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c.a aVar, HashMap hashMap) {
        this.DW = aVar;
        this.DX = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        PluginStatus pluginStatus = (PluginStatus) this.DX.get(str);
        PluginStatus pluginStatus2 = (PluginStatus) this.DX.get(str2);
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
