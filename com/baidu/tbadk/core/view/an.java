package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.aig = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        Context context2;
        Context context3;
        context = this.aig.mContext;
        if (com.baidu.tbadk.core.util.bk.ak(context)) {
            bkVar = this.aig.aeu;
            if (bkVar != null) {
                bkVar2 = this.aig.aeu;
                if (bkVar2.getAuthor() != null) {
                    bkVar3 = this.aig.aeu;
                    if (bkVar3.getAuthor().getTShowInfoNew() != null) {
                        bkVar4 = this.aig.aeu;
                        ArrayList<IconData> tShowInfoNew = bkVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            bkVar5 = this.aig.aeu;
                            String url = bkVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.aig.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    bf vP = bf.vP();
                                    context3 = this.aig.mContext;
                                    vP.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
