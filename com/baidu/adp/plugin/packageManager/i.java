package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.plugin.packageManager.pluginServerConfig.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        int i;
        i = PluginPackageManager.Dq;
        if (i != 1 && z && pluginNetConfigInfos != null) {
            String str = "";
            if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                this.this$0.e(configs);
                str = this.this$0.f(configs);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().setForbiddenFeatures(str);
        }
        this.this$0.ma();
    }
}
