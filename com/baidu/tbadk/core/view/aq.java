package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ UserIconLayout agV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UserIconLayout userIconLayout) {
        this.agV = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        Context context2;
        Context context3;
        context = this.agV.mContext;
        if (bf.ak(context)) {
            bhVar = this.agV.acX;
            if (bhVar != null) {
                bhVar2 = this.agV.acX;
                if (bhVar2.getAuthor() != null) {
                    bhVar3 = this.agV.acX;
                    if (bhVar3.getAuthor().getTShowInfoNew() != null) {
                        bhVar4 = this.agV.acX;
                        ArrayList<IconData> tShowInfoNew = bhVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.w.r(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.w.c(tShowInfoNew, 0) != null) {
                            bhVar5 = this.agV.acX;
                            String url = bhVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.agV.mContext;
                                if (com.baidu.adp.base.k.C(context2) instanceof TbPageContext) {
                                    ba vt = ba.vt();
                                    context3 = this.agV.mContext;
                                    vt.c((TbPageContext) com.baidu.adp.base.k.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
