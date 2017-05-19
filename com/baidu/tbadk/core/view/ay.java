package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ay implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UserIconLayout userIconLayout) {
        this.amK = userIconLayout;
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
        context = this.amK.mContext;
        if (bg.aN(context)) {
            bkVar = this.amK.ahV;
            if (bkVar != null) {
                bkVar2 = this.amK.ahV;
                if (bkVar2.getAuthor() != null) {
                    bkVar3 = this.amK.ahV;
                    if (bkVar3.getAuthor().getTShowInfoNew() != null) {
                        bkVar4 = this.amK.ahV;
                        ArrayList<IconData> tShowInfoNew = bkVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            bkVar5 = this.amK.ahV;
                            String url = bkVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amK.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
                                    context3 = this.amK.mContext;
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
