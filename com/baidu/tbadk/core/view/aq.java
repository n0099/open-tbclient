package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayoutNew amm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ThreadCommentAndPraiseInfoLayoutNew threadCommentAndPraiseInfoLayoutNew) {
        this.amm = threadCommentAndPraiseInfoLayoutNew;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.amm.alN;
        String str = (String) com.baidu.tbadk.core.util.x.c(list, i);
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
            tbPageContext = this.amm.ajr;
            vB.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
