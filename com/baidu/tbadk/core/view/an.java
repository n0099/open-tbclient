package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ame = threadCommentAndPraiseInfoLayout;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.ame.alN;
        String str = (String) com.baidu.tbadk.core.util.x.c(list, i);
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
            tbPageContext = this.ame.ajr;
            vB.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
