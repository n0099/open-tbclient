package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.ahX = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        Context context;
        int i;
        bgVar = this.ahX.adL;
        if (bgVar != null) {
            bgVar2 = this.ahX.adL;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.ahX.adL;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + bgVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(t.j.user_icon_web_view_title);
                context = this.ahX.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.ahX.ahT;
                if (i == 1) {
                    TiebaStatic.log(new ay("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
