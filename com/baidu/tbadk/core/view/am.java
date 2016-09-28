package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.ahF = userIconLayout;
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
        context = this.ahF.mContext;
        if (bm.ak(context)) {
            biVar = this.ahF.adW;
            if (biVar != null) {
                biVar2 = this.ahF.adW;
                if (biVar2.getAuthor() != null) {
                    biVar3 = this.ahF.adW;
                    if (biVar3.getAuthor().getTShowInfoNew() != null) {
                        biVar4 = this.ahF.adW;
                        ArrayList<IconData> tShowInfoNew = biVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null) {
                            biVar5 = this.ahF.adW;
                            String url = biVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.ahF.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    bh vL = bh.vL();
                                    context3 = this.ahF.mContext;
                                    vL.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
