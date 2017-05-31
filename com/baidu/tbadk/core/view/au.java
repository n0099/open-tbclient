package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ ThreadUserInfoLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ThreadUserInfoLayout threadUserInfoLayout) {
        this.amr = threadUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        Context context;
        int i;
        blVar = this.amr.ahM;
        if (blVar != null) {
            blVar2 = this.amr.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.amr.ahM;
                String str = String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + blVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
                context = this.amr.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.amr.mFrom;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10134").r("obj_type", 3));
                }
            }
        }
    }
}
