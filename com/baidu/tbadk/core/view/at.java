package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.bl;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ ThreadUserInfoLayout anp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ThreadUserInfoLayout threadUserInfoLayout) {
        this.anp = threadUserInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        Context context2;
        Context context3;
        context = this.anp.mContext;
        if (bl.aN(context)) {
            bmVar = this.anp.aiu;
            if (bmVar != null) {
                bmVar2 = this.anp.aiu;
                if (bmVar2.getAuthor() != null) {
                    bmVar3 = this.anp.aiu;
                    if (bmVar3.getAuthor().getTShowInfoNew() != null) {
                        bmVar4 = this.anp.aiu;
                        if (com.baidu.tbadk.core.util.z.c(bmVar4.getAuthor().getTShowInfoNew(), 0) != null) {
                            bmVar5 = this.anp.aiu;
                            String url = bmVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.anp.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
                                    context3 = this.anp.mContext;
                                    vP.c((TbPageContext) com.baidu.adp.base.k.Z(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
