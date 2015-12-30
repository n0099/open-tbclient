package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(UserIconLayout userIconLayout) {
        this.aha = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        com.baidu.tbadk.core.data.z zVar4;
        com.baidu.tbadk.core.data.z zVar5;
        Context context2;
        Context context3;
        context = this.aha.mContext;
        if (bj.ah(context)) {
            zVar = this.aha.aeF;
            if (zVar != null) {
                zVar2 = this.aha.aeF;
                if (zVar2.getAuthor() != null) {
                    zVar3 = this.aha.aeF;
                    if (zVar3.getAuthor().getTShowInfoNew() != null) {
                        zVar4 = this.aha.aeF;
                        ArrayList<IconData> tShowInfoNew = zVar4.getAuthor().getTShowInfoNew();
                        if (com.baidu.tbadk.core.util.y.l(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.b(tShowInfoNew, 0) != null) {
                            zVar5 = this.aha.aeF;
                            String url = zVar5.getAuthor().getTShowInfoNew().get(0).getUrl();
                            if (url != null) {
                                context2 = this.aha.mContext;
                                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                                    bf vn = bf.vn();
                                    context3 = this.aha.mContext;
                                    vn.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
