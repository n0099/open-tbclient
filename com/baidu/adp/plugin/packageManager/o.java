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
        PluginSettings jX;
        PluginNetConfigInfos jV;
        List<PluginNetConfigInfos.PluginConfig> configs;
        String e;
        String str;
        boolean F;
        boolean z = false;
        Object data = customResponsedMessage.getData();
        if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (jX = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().jX()) != null) {
            if (jX != null) {
                PluginPackageManager pluginPackageManager = this.this$0;
                str = this.this$0.Eh;
                F = pluginPackageManager.F(str, jX.getContainerVersion());
                if (F) {
                    return;
                }
            }
            PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
            if (!TextUtils.isEmpty(pluginConfig.package_name) && (jV = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV()) != null && (configs = jV.getConfigs()) != null) {
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
                this.this$0.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().c(com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().jX()), pluginConfig);
                e = this.this$0.e(configs);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().setForbiddenFeatures(e);
                this.this$0.jI();
            }
        }
    }
}
