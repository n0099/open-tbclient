package com.baidu.tbadk.browser;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m xB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.xB = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbWebViewActivity tbWebViewActivity;
        TbWebViewActivity tbWebViewActivity2;
        try {
            tbWebViewActivity = this.xB.xA;
            Intent intent = new Intent(tbWebViewActivity, Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
            intent.putExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG, PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_BROWSER));
            tbWebViewActivity2 = this.xB.xA;
            tbWebViewActivity2.startActivityForResult(intent, 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
