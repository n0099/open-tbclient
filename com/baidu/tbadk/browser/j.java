package com.baidu.tbadk.browser;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbWebViewActivity tbWebViewActivity;
        TbWebViewActivity tbWebViewActivity2;
        try {
            tbWebViewActivity = this.a.a;
            Intent intent = new Intent(tbWebViewActivity, Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
            intent.putExtra("plugin_config", com.baidu.tbadk.pluginArch.d.a().b("browser"));
            tbWebViewActivity2 = this.a.a;
            tbWebViewActivity2.startActivityForResult(intent, 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
