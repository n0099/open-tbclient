package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import java.util.Date;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.a = nVar;
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
        dVar = tbWebViewActivity.w;
        if (dVar != null) {
            tbWebViewActivity3 = this.a.a;
            dVar2 = tbWebViewActivity3.w;
            dVar2.a();
        }
        tbWebViewActivity2 = this.a.a;
        imageView = tbWebViewActivity2.q;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.a().b("install_plugin_dialog_closed", true);
        com.baidu.tbadk.core.sharedPref.b.a().b("install_plugin_dialog_shown_time", new Date().getTime());
    }
}
