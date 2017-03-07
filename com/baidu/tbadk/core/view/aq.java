package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UserIconLayout userIconLayout) {
        this.amr = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        Context context;
        int i;
        bjVar = this.amr.ain;
        if (bjVar != null) {
            bjVar2 = this.amr.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.amr.ain;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bjVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
                context = this.amr.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.amr.aml;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
