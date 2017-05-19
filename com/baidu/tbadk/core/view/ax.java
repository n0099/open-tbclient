package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(UserIconLayout userIconLayout) {
        this.amK = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        Context context;
        int i;
        bkVar = this.amK.ahV;
        if (bkVar != null) {
            bkVar2 = this.amK.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.amK.ahV;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bkVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.user_icon_web_view_title);
                context = this.amK.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.amK.amH;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
