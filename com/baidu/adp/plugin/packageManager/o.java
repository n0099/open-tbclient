package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PluginPackageManager pluginPackageManager, int i) {
        super(i);
        this.this$0 = pluginPackageManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PluginSettings m9if;
        PluginNetConfigInfos id;
        List<PluginNetConfigInfos.PluginConfig> configs;
        String e;
        String str;
        boolean H;
        boolean z = false;
        Object data = customResponsedMessage.getData();
        if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if()) != null) {
            if (m9if != null) {
                PluginPackageManager pluginPackageManager = this.this$0;
                str = this.this$0.uL;
                H = pluginPackageManager.H(str, m9if.getContainerVersion());
                if (H) {
                    return;
                }
            }
            PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
            if (!TextUtils.isEmpty(pluginConfig.package_name) && (id = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().id()) != null && (configs = id.getConfigs()) != null) {
                int i = 0;
                while (true) {
                    if (i >= configs.size()) {
                        z = true;
                        break;
                    } else if (!configs.get(i).package_name.equals(pluginConfig.package_name)) {
                        i++;
                    } else {
                        configs.set(i, pluginConfig);
                        break;
                    }
                }
                if (z) {
                    configs.add(pluginConfig);
                }
                this.this$0.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().c(com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if()), pluginConfig);
                e = this.this$0.e(configs);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().setForbiddenFeatures(e);
                this.this$0.hQ();
            }
        }
    }
}
