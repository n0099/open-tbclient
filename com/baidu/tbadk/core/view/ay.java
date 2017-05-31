package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ay implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UserIconLayout userIconLayout) {
        this.amG = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        Context context2;
        Context context3;
        context = this.amG.mContext;
        if (bh.aN(context)) {
            blVar = this.amG.ahM;
            if (blVar != null) {
                blVar2 = this.amG.ahM;
                if (blVar2.getAuthor() != null) {
                    blVar3 = this.amG.ahM;
                    if (blVar3.getAuthor().getTShowInfoNew() != null) {
                        blVar4 = this.amG.ahM;
                        ArrayList<IconData> tShowInfoNew = blVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            blVar5 = this.amG.ahM;
                            String url = blVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amG.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
                                    context3 = this.amG.mContext;
                                    vy.c((TbPageContext) com.baidu.adp.base.k.Z(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
