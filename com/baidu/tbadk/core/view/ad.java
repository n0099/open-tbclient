package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UserIconLayout userIconLayout) {
        this.aha = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        Context context;
        zVar = this.aha.aeF;
        if (zVar != null) {
            zVar2 = this.aha.aeF;
            if (zVar2.getAuthor() != null) {
                zVar3 = this.aha.aeF;
                String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + zVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m411getInst().getString(n.j.user_icon_web_view_title);
                context = this.aha.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, false);
            }
        }
    }
}
