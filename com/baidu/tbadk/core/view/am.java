package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout afc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.afc = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        be beVar3;
        Context context;
        int i;
        beVar = this.afc.abb;
        if (beVar != null) {
            beVar2 = this.afc.abb;
            if (beVar2.getAuthor() != null) {
                beVar3 = this.afc.abb;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + beVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m10getInst().getString(u.j.user_icon_web_view_title);
                context = this.afc.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.afc.aeY;
                if (i == 1) {
                    TiebaStatic.log(new ay("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
