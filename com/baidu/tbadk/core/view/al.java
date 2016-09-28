package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(UserIconLayout userIconLayout) {
        this.ahF = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        Context context;
        int i;
        biVar = this.ahF.adW;
        if (biVar != null) {
            biVar2 = this.ahF.adW;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.ahF.adW;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + biVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(r.j.user_icon_web_view_title);
                context = this.ahF.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.ahF.ahB;
                if (i == 1) {
                    TiebaStatic.log(new ax("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
