package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ ThreadUserInfoLayout amu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ThreadUserInfoLayout threadUserInfoLayout) {
        this.amu = threadUserInfoLayout;
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
        context = this.amu.mContext;
        if (bg.aN(context)) {
            bkVar = this.amu.ahV;
            if (bkVar != null) {
                bkVar2 = this.amu.ahV;
                if (bkVar2.getAuthor() != null) {
                    bkVar3 = this.amu.ahV;
                    if (bkVar3.getAuthor().getTShowInfoNew() != null) {
                        bkVar4 = this.amu.ahV;
                        if (com.baidu.tbadk.core.util.x.c(bkVar4.getAuthor().getTShowInfoNew(), 0) != null) {
                            bkVar5 = this.amu.ahV;
                            String url = bkVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amu.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
                                    context3 = this.amu.mContext;
                                    vB.c((TbPageContext) com.baidu.adp.base.k.Z(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
