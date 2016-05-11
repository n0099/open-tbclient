package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout adQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.adQ = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        Context context;
        int i;
        axVar = this.adQ.aab;
        if (axVar != null) {
            axVar2 = this.adQ.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.adQ.aab;
                String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + axVar3.getAuthor().getUserId();
                String string = TbadkCoreApplication.m11getInst().getString(t.j.user_icon_web_view_title);
                context = this.adQ.mContext;
                com.baidu.tbadk.browser.f.a(context.getApplicationContext(), string, str, true, true, false);
                i = this.adQ.adM;
                if (i == 1) {
                    TiebaStatic.log(new aw("c10134").s("obj_type", 3));
                }
            }
        }
    }
}
