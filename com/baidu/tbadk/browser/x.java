package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        relativeLayout = this.By.Bn;
        relativeLayout.setVisibility(8);
        imageView = this.By.Bw;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.oj().putLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
