package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.ahH = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        Context context;
        int i;
        bgVar = this.ahH.adN;
        if (bgVar != null) {
            bgVar2 = this.ahH.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.ahH.adN;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bgVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(r.j.user_icon_web_view_title);
                context = this.ahH.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.ahH.ahC;
                if (i == 1) {
                    TiebaStatic.log(new at("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
