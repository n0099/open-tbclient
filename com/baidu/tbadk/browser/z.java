package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.xR, PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_BROWSER), 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
