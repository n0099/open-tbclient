package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(UserIconLayout userIconLayout) {
        this.ahU = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        Context context2;
        Context context3;
        context = this.ahU.mContext;
        if (bl.ad(context)) {
            asVar = this.ahU.aeC;
            if (asVar != null) {
                asVar2 = this.ahU.aeC;
                if (asVar2.getAuthor() != null) {
                    asVar3 = this.ahU.aeC;
                    if (asVar3.getAuthor().getTShowInfoNew() != null) {
                        asVar4 = this.ahU.aeC;
                        ArrayList<IconData> tShowInfoNew = asVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.p(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.b(tShowInfoNew, 0) != null) {
                            asVar5 = this.ahU.aeC;
                            String url = asVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.ahU.mContext;
                                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                                    bg wM = bg.wM();
                                    context3 = this.ahU.mContext;
                                    wM.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
