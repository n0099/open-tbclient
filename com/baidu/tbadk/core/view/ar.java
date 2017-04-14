package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(UserIconLayout userIconLayout) {
        this.amF = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        Context context2;
        Context context3;
        context = this.amF.mContext;
        if (bg.aK(context)) {
            biVar = this.amF.aiB;
            if (biVar != null) {
                biVar2 = this.amF.aiB;
                if (biVar2.getAuthor() != null) {
                    biVar3 = this.amF.aiB;
                    if (biVar3.getAuthor().getTShowInfoNew() != null) {
                        biVar4 = this.amF.aiB;
                        ArrayList<IconData> tShowInfoNew = biVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.p(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            biVar5 = this.amF.aiB;
                            String url = biVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.amF.mContext;
                                if (com.baidu.adp.base.k.Z(context2) instanceof TbPageContext) {
                                    bb wn = bb.wn();
                                    context3 = this.amF.mContext;
                                    wn.c((TbPageContext) com.baidu.adp.base.k.Z(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
