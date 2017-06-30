package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ UserIconLayout anE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UserIconLayout userIconLayout) {
        this.anE = userIconLayout;
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
        context = this.anE.mContext;
        if (bl.aN(context)) {
            bmVar = this.anE.aiu;
            if (bmVar != null) {
                bmVar2 = this.anE.aiu;
                if (bmVar2.getAuthor() != null) {
                    bmVar3 = this.anE.aiu;
                    if (bmVar3.getAuthor().getTShowInfoNew() != null) {
                        bmVar4 = this.anE.aiu;
                        ArrayList<IconData> tShowInfoNew = bmVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.z.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.z.c(tShowInfoNew, 0) != null) {
                            bmVar5 = this.anE.aiu;
                            String url = bmVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.anE.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
                                    context3 = this.anE.mContext;
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
