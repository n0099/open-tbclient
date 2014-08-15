package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import java.util.Date;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbWebViewActivity tbWebViewActivity;
        com.baidu.adp.lib.guide.d dVar;
        TbWebViewActivity tbWebViewActivity2;
        ImageView imageView;
        TbWebViewActivity tbWebViewActivity3;
        com.baidu.adp.lib.guide.d dVar2;
        tbWebViewActivity = this.a.a;
        dVar = tbWebViewActivity.mInstallGuide;
        if (dVar != null) {
            tbWebViewActivity3 = this.a.a;
            dVar2 = tbWebViewActivity3.mInstallGuide;
            dVar2.a();
        }
        tbWebViewActivity2 = this.a.a;
        imageView = tbWebViewActivity2.mBottomInstallPlugin;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.a().b(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.a().b(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
