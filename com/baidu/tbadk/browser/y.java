package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bm;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bm(this.a, com.baidu.tbadk.pluginArch.d.a().b("browser"), 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
