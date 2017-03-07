package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.bb;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements c.b {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.alQ = threadCommentAndPraiseInfoLayout;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        List list;
        TbPageContext<?> tbPageContext;
        list = this.alQ.alD;
        String str = (String) com.baidu.tbadk.core.util.x.c(list, i);
        if (!StringUtils.isNull(str)) {
            bb vQ = bb.vQ();
            tbPageContext = this.alQ.ajF;
            vQ.c(tbPageContext, new String[]{str});
        }
        cVar.dismiss();
    }
}
