package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout afc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.afc = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        Context context2;
        Context context3;
        context = this.afc.mContext;
        if (bn.ab(context)) {
            beVar = this.afc.abb;
            if (beVar != null) {
                beVar2 = this.afc.abb;
                if (beVar2.getAuthor() != null) {
                    beVar3 = this.afc.abb;
                    if (beVar3.getAuthor().getTShowInfoNew() != null) {
                        beVar4 = this.afc.abb;
                        ArrayList<IconData> tShowInfoNew = beVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null) {
                            beVar5 = this.afc.abb;
                            String url = beVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.afc.mContext;
                                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                                    bi us = bi.us();
                                    context3 = this.afc.mContext;
                                    us.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
