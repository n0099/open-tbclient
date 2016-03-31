package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(UserIconLayout userIconLayout) {
        this.ahU = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        Context context;
        asVar = this.ahU.aeC;
        if (asVar != null) {
            asVar2 = this.ahU.aeC;
            if (asVar2.getAuthor() != null) {
                asVar3 = this.ahU.aeC;
                String str = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + asVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
                context = this.ahU.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, false);
            }
        }
    }
}
