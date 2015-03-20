package com.baidu.tbadk.browser;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.y;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(2005016, new g(0));
        bk.tl().a(new h());
        bk.tl().a(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(TbPageContext<?> tbPageContext) {
        PluginPackageManager.PluginStatus br = PluginPackageManager.ls().br(PluginCenter.NAME_XIU8);
        if (br == PluginPackageManager.PluginStatus.NROMAL) {
            return true;
        }
        if (br == PluginPackageManager.PluginStatus.DISABLE) {
            UtilHelper.showToast(TbadkCoreApplication.m411getInst(), y.plugin_config_not_found);
            return false;
        } else if (br == PluginPackageManager.PluginStatus.UNINSTALLED) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(TbadkCoreApplication.m411getInst(), PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_XIU8))));
            return false;
        } else if (br == PluginPackageManager.PluginStatus.FORBIDDEN) {
            com.baidu.tbadk.coreExtra.util.a.a(tbPageContext, y.plugin_xiuba_not_canuse, new l(tbPageContext), new m());
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String bG(String str) {
        if (!StringUtils.isNull(str)) {
            String checkUrl = TbadkCoreApplication.m411getInst().getCheckUrl();
            if (checkUrl == null) {
                checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
            } else if (checkUrl.trim().length() == 0) {
                return str;
            }
            if (!str.startsWith(checkUrl)) {
                return String.valueOf(checkUrl) + bH(str);
            }
            return str;
        }
        return str;
    }

    public static String bH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), "UTF-8");
            try {
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str;
        }
    }
}
