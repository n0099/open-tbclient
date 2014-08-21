package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        relativeLayout = this.a.i;
        relativeLayout.setVisibility(8);
        imageView = this.a.p;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.a().b(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.a().b(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
