package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.aeo = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        Context context2;
        Context context3;
        context = this.aeo.mContext;
        if (bn.ab(context)) {
            azVar = this.aeo.aas;
            if (azVar != null) {
                azVar2 = this.aeo.aas;
                if (azVar2.getAuthor() != null) {
                    azVar3 = this.aeo.aas;
                    if (azVar3.getAuthor().getTShowInfoNew() != null) {
                        azVar4 = this.aeo.aas;
                        ArrayList<IconData> tShowInfoNew = azVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null) {
                            azVar5 = this.aeo.aas;
                            String url = azVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.aeo.mContext;
                                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                                    bi us = bi.us();
                                    context3 = this.aeo.mContext;
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
