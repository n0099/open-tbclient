package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class o {
    public static int cW(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("game:detail")) {
                return 1;
            }
            if (str.endsWith("tieba.baidu.com/mo/q/gameszone?kw=food")) {
                return 3;
            }
            if (str.startsWith("http")) {
                return 2;
            }
        }
        return 0;
    }

    public static void a(com.baidu.adp.base.h<?> hVar, String str) {
        if (hVar != null && hVar.getPageActivity() != null && !StringUtils.isNull(str)) {
            boolean bl = PluginPackageManager.lQ().bl("com.baidu.tieba.pluginCookeryGod");
            boolean br = PluginPackageManager.lQ().br("com.baidu.tieba.pluginCookeryGod");
            if (bl && br) {
                hVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(hVar.getPageActivity(), "com.baidu.tieba.pluginCookeryGod")));
            } else if (hVar instanceof TbPageContext) {
                ax.uX().a((TbPageContext) hVar, new String[]{str}, true);
            }
        }
    }
}
