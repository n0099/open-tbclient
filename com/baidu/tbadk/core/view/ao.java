package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.ahX = userIconLayout;
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
        context = this.ahX.mContext;
        if (bn.al(context)) {
            bgVar = this.ahX.adL;
            if (bgVar != null) {
                bgVar2 = this.ahX.adL;
                if (bgVar2.getAuthor() != null) {
                    bgVar3 = this.ahX.adL;
                    if (bgVar3.getAuthor().getTShowInfoNew() != null) {
                        bgVar4 = this.ahX.adL;
                        ArrayList<IconData> tShowInfoNew = bgVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null) {
                            bgVar5 = this.ahX.adL;
                            String url = bgVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.ahX.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    bi vx = bi.vx();
                                    context3 = this.ahX.mContext;
                                    vx.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
