package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ay implements View.OnClickListener {
    final /* synthetic */ UserIconLayout anE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UserIconLayout userIconLayout) {
        this.anE = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        Context context;
        int i;
        bmVar = this.anE.aiu;
        if (bmVar != null) {
            bmVar2 = this.anE.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.anE.aiu;
                String str = String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bmVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
                context = this.anE.mContext;
                com.baidu.tbadk.browser.g.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.anE.anB;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10134").r("obj_type", 3));
                }
            }
        }
    }
}
