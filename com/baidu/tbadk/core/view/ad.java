package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UserIconLayout userIconLayout) {
        this.ahP = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        Context context;
        ahVar = this.ahP.afg;
        if (ahVar != null) {
            ahVar2 = this.ahP.afg;
            if (ahVar2.getAuthor() != null) {
                ahVar3 = this.ahP.afg;
                String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ahVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
                context = this.ahP.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, false);
            }
        }
    }
}
