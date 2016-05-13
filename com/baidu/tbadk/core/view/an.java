package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout adQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.adQ = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        Context context2;
        Context context3;
        context = this.adQ.mContext;
        if (bl.ac(context)) {
            axVar = this.adQ.aab;
            if (axVar != null) {
                axVar2 = this.adQ.aab;
                if (axVar2.getAuthor() != null) {
                    axVar3 = this.adQ.aab;
                    if (axVar3.getAuthor().getTShowInfoNew() != null) {
                        axVar4 = this.adQ.aab;
                        ArrayList<IconData> tShowInfoNew = axVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.r(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null) {
                            axVar5 = this.adQ.aab;
                            String url = axVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.adQ.mContext;
                                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                                    bg ut = bg.ut();
                                    context3 = this.adQ.mContext;
                                    ut.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
