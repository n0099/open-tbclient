package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CookeryGodHallActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l {
    public static int dE(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("game:detail")) {
                return 1;
            }
            if (str.startsWith("game:cookerygod") || str.endsWith("tieba.baidu.com/mo/q/gameszone?kw=food")) {
                return 3;
            }
            if (str.startsWith("http")) {
                return 2;
            }
        }
        return 0;
    }

    public static void a(final TbPageContext<?> tbPageContext, String str) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && !StringUtils.isNull(str)) {
            PluginPackageManager.PluginStatus bp = PluginPackageManager.ju().bp("com.baidu.tieba.pluginCookeryGod");
            if (TbadkCoreApplication.getInst().getIntentClass(CookeryGodHallActivityConfig.class) != null && bp != PluginPackageManager.PluginStatus.FORBIDDEN) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CookeryGodHallActivityConfig(tbPageContext.getPageActivity())));
            } else if (bp == PluginPackageManager.PluginStatus.NROMAL) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CookeryGodHallActivityConfig(tbPageContext.getPageActivity())));
            } else if (bp == PluginPackageManager.PluginStatus.UNINSTALLED || bp == PluginPackageManager.PluginStatus.DISABLE) {
                if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null && com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig("com.baidu.tieba.pluginCookeryGod") == null) {
                    tbPageContext.showToast(d.l.plugin_config_no_tip);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(tbPageContext.getPageActivity(), "com.baidu.tieba.pluginCookeryGod")));
                }
            } else if (bp == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(tbPageContext, d.l.plugin_cookery_god_forbidden, new a.b() { // from class: com.baidu.tbadk.core.util.l.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(TbPageContext.this.getPageActivity(), "com.baidu.tieba.pluginCookeryGod")));
                        aVar.dismiss();
                    }
                }, new a.b() { // from class: com.baidu.tbadk.core.util.l.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
            }
        }
    }
}
