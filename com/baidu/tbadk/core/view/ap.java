package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserIconLayout userIconLayout) {
        this.ahH = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        Context context2;
        Context context3;
        context = this.ahH.mContext;
        if (bh.ai(context)) {
            bgVar = this.ahH.adN;
            if (bgVar != null) {
                bgVar2 = this.ahH.adN;
                if (bgVar2.getAuthor() != null) {
                    bgVar3 = this.ahH.adN;
                    if (bgVar3.getAuthor().getTShowInfoNew() != null) {
                        bgVar4 = this.ahH.adN;
                        ArrayList<IconData> tShowInfoNew = bgVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.x.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.c(tShowInfoNew, 0) != null) {
                            bgVar5 = this.ahH.adN;
                            String url = bgVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.ahH.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    bc vz = bc.vz();
                                    context3 = this.ahH.mContext;
                                    vz.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
