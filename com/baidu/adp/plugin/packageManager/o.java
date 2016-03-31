package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
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
        PluginNetConfigInfos lP;
        List<PluginNetConfigInfos.PluginConfig> configs;
        String e;
        boolean z = false;
        Object data = customResponsedMessage.getData();
        if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig)) {
            PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
            if (!TextUtils.isEmpty(pluginConfig.package_name) && (lP = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().lP()) != null && (configs = lP.getConfigs()) != null) {
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
                this.this$0.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().c(com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR()), pluginConfig);
                e = this.this$0.e(configs);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().setForbiddenFeatures(e);
                this.this$0.lD();
            }
        }
    }
}
