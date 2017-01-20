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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m {
    public static int dm(String str) {
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

    public static void a(TbPageContext<?> tbPageContext, String str) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && !StringUtils.isNull(str)) {
            PluginPackageManager.PluginStatus bt = PluginPackageManager.iz().bt("com.baidu.tieba.pluginCookeryGod");
            if (TbadkCoreApplication.m9getInst().getIntentClass(CookeryGodHallActivityConfig.class) != null && bt != PluginPackageManager.PluginStatus.FORBIDDEN) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CookeryGodHallActivityConfig(tbPageContext.getPageActivity())));
            } else if (bt == PluginPackageManager.PluginStatus.NROMAL) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CookeryGodHallActivityConfig(tbPageContext.getPageActivity())));
            } else if (bt == PluginPackageManager.PluginStatus.UNINSTALLED || bt == PluginPackageManager.PluginStatus.DISABLE) {
                if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iW().iX() != null && com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iW().iX().getPluginConfig("com.baidu.tieba.pluginCookeryGod") == null) {
                    tbPageContext.showToast(r.l.plugin_config_no_tip);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(tbPageContext.getPageActivity(), "com.baidu.tieba.pluginCookeryGod")));
                }
            } else if (bt == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, r.l.plugin_cookery_god_forbidden, new n(tbPageContext), new o());
            }
        }
    }
}
