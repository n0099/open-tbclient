package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(UserIconLayout userIconLayout) {
        this.ahP = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        Context context2;
        Context context3;
        context = this.ahP.mContext;
        if (bi.ah(context)) {
            ahVar = this.ahP.afg;
            if (ahVar != null) {
                ahVar2 = this.ahP.afg;
                if (ahVar2.getAuthor() != null) {
                    ahVar3 = this.ahP.afg;
                    if (ahVar3.getAuthor().getTShowInfoNew() != null) {
                        ahVar4 = this.ahP.afg;
                        ArrayList<IconData> tShowInfoNew = ahVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.o(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.b(tShowInfoNew, 0) != null) {
                            ahVar5 = this.ahP.afg;
                            String url = ahVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.ahP.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    be wt = be.wt();
                                    context3 = this.ahP.mContext;
                                    wt.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
