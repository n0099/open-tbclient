package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.aig = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        Context context;
        int i;
        bkVar = this.aig.aeu;
        if (bkVar != null) {
            bkVar2 = this.aig.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aig.aeu;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bkVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(r.j.user_icon_web_view_title);
                context = this.aig.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.aig.aib;
                if (i == 1) {
                    TiebaStatic.log(new av("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
