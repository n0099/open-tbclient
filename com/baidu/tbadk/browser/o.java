package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import java.util.Date;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ m xB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.xB = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbWebViewActivity tbWebViewActivity;
        com.baidu.adp.lib.guide.d dVar;
        TbWebViewActivity tbWebViewActivity2;
        ImageView imageView;
        TbWebViewActivity tbWebViewActivity3;
        com.baidu.adp.lib.guide.d dVar2;
        tbWebViewActivity = this.xB.xA;
        dVar = tbWebViewActivity.mInstallGuide;
        if (dVar != null) {
            tbWebViewActivity3 = this.xB.xA;
            dVar2 = tbWebViewActivity3.mInstallGuide;
            dVar2.dismiss();
        }
        tbWebViewActivity2 = this.xB.xA;
        imageView = tbWebViewActivity2.mBottomInstallPlugin;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
