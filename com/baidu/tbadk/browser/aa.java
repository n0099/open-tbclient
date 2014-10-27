package com.baidu.tbadk.browser;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        relativeLayout = this.xR.xH;
        relativeLayout.setVisibility(8);
        imageView = this.xR.mBottomInstallPlugin;
        imageView.setSelected(false);
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
        com.baidu.tbadk.core.sharedPref.b.lk().putLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
    }
}
