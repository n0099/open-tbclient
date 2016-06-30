package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.aeo = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        az azVar3;
        Context context;
        int i;
        azVar = this.aeo.aas;
        if (azVar != null) {
            azVar2 = this.aeo.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.aeo.aas;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + azVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m9getInst().getString(u.j.user_icon_web_view_title);
                context = this.aeo.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, true);
                i = this.aeo.aek;
                if (i == 1) {
                    TiebaStatic.log(new ay("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
