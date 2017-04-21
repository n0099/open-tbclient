package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UserIconLayout userIconLayout) {
        this.amF = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        Context context;
        int i;
        biVar = this.amF.aiC;
        if (biVar != null) {
            biVar2 = this.amF.aiC;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.amF.aiC;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + biVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
                context = this.amF.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.amF.amz;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
