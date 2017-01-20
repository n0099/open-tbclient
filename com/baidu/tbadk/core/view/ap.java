package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ UserIconLayout agV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserIconLayout userIconLayout) {
        this.agV = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        Context context;
        int i;
        bhVar = this.agV.acX;
        if (bhVar != null) {
            bhVar2 = this.agV.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.agV.acX;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bhVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(r.l.user_icon_web_view_title);
                context = this.agV.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.agV.agQ;
                if (i == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
