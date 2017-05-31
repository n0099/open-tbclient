package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.bh;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ ThreadUserInfoLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ThreadUserInfoLayout threadUserInfoLayout) {
        this.amr = threadUserInfoLayout;
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
        context = this.amr.mContext;
        if (bh.aN(context)) {
            blVar = this.amr.ahM;
            if (blVar != null) {
                blVar2 = this.amr.ahM;
                if (blVar2.getAuthor() != null) {
                    blVar3 = this.amr.ahM;
                    if (blVar3.getAuthor().getTShowInfoNew() != null) {
                        blVar4 = this.amr.ahM;
                        if (com.baidu.tbadk.core.util.x.c(blVar4.getAuthor().getTShowInfoNew(), 0) != null) {
                            blVar5 = this.amr.ahM;
                            String url = blVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amr.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
                                    context3 = this.amr.mContext;
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
