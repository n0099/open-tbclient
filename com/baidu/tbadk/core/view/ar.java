package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(UserIconLayout userIconLayout) {
        this.amr = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        Context context2;
        Context context3;
        context = this.amr.mContext;
        if (bg.aI(context)) {
            bjVar = this.amr.ain;
            if (bjVar != null) {
                bjVar2 = this.amr.ain;
                if (bjVar2.getAuthor() != null) {
                    bjVar3 = this.amr.ain;
                    if (bjVar3.getAuthor().getTShowInfoNew() != null) {
                        bjVar4 = this.amr.ain;
                        ArrayList<IconData> tShowInfoNew = bjVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.p(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            bjVar5 = this.amr.ain;
                            String url = bjVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amr.mContext;
                                if (com.baidu.adp.base.k.aa(context2) instanceof TbPageContext) {
                                    bb vQ = bb.vQ();
                                    context3 = this.amr.mContext;
                                    vQ.c((TbPageContext) com.baidu.adp.base.k.aa(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
